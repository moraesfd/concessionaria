package br.pucpcaldas.concessionaria.controle.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.pucpcaldas.concessionaria.dominio.CondicaoPagamento;
import br.pucpcaldas.concessionaria.dominio.ItemPedidoVenda;
import br.pucpcaldas.concessionaria.dominio.PedidoVenda;
import br.pucpcaldas.concessionaria.dominio.Produto;
import br.pucpcaldas.concessionaria.dominio.StatusPedido;

public class LivroDePedidos {

	private static final String GET_CONDICAO_PAGAMENTO = "select * from condicaopagamento";
	private static final String GET_STATUS_PEDIDO = "select * from statuspedido";
	private static final String GET_ID_ULTIMO_PEDIDO = "SELECT MAX(idPedidoVenda) AS idPedidoVenda FROM pedidovenda";
	private static final String GET_ID_PEDIDO_ULTIMO_ITEM = "SELECT MAX(idPedidoVenda) AS idPedidoVenda FROM itempedidovenda";
	private static final String INSERE_ITEM = "INSERT INTO itempedidovenda (idPedidoVenda, idProduto, quantidade) VALUES (?, ?, ?)";
	private static final String INSERE_PEDIDO = "INSERT INTO pedidovenda (idCliente, idVendedor, idCondPagto, idStatusPedido, porcenDesconto, total) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String DELETA_ITENS_PEDIDO_CORRENTE = "DELETE FROM itempedidovenda WHERE idPedidoVenda = ?";
	private static final String GET_TABELA_ITENS = "SELECT P.produto, I.quantidade, (I.quantidade*P.valorUnitario) AS valor " +
												   "FROM itempedidovenda I " +
												   "INNER JOIN produto P ON P.idProduto = I.idProduto " +
												   "WHERE P.disponivel = '1' " +
												   "AND I.idPedidoVenda = ?";
	
	private static final String GET_TOTAL_PEDIDO = "SELECT SUM(I.quantidade*P.valorUnitario) AS valor " +
	   											   "FROM itempedidovenda I " +
	   											   "INNER JOIN produto P ON P.idProduto = I.idProduto " +
	   											   "WHERE P.disponivel = '1' " +
	   											   "AND I.idPedidoVenda = ?";
	
	private static final String GET_TABELA_PEDIDOS = "SELECT P.idPedidoVenda AS idPedido, C.nome AS cliente, S.descricao as statusPedido, P.total as total  FROM pedidovenda P " +
													 "INNER JOIN cliente C ON C.idCliente = P.idCliente " +
													 "INNER JOIN statuspedido S ON S.idStatusPedido = p.idStatusPedido " +
													 "ORDER BY P.idPedidoVenda";

	
//	Método responsável por criar e retornar uma lista com as possíveis condições de pagamento
	public List<CondicaoPagamento> getCondicaoPagamento() throws SQLException {
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idCondPagamento = 0, status = 0;
		String descricao = null;
		try{
			List<CondicaoPagamento> lista = new ArrayList<CondicaoPagamento>();
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_CONDICAO_PAGAMENTO);
			ps.clearParameters();
			rs = ps.executeQuery();

			while(rs.next()){

				idCondPagamento = rs.getInt("idCondPagto");
				descricao = rs.getString("descricao");
				status = rs.getInt("status");
				CondicaoPagamento condPagamento = new CondicaoPagamento(idCondPagamento, descricao, status);

				lista.add(condPagamento);

			}
			return lista;
		}
		finally{
			ConnectionManager.closeConexao();
		}	
	}

//	Método responsável por criar e retornar uma lista com os status do Pedido
	public List<StatusPedido> getStatusPedido() throws SQLException {
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idStatusPedido = 0, status = 0;
		String descricao = null;
		try{
			List<StatusPedido> lista = new ArrayList<StatusPedido>();
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_STATUS_PEDIDO);
			ps.clearParameters();
			rs = ps.executeQuery();

			while(rs.next()){

				idStatusPedido = rs.getInt("idStatusPedido");
				descricao = rs.getString("descricao");
				status = rs.getInt("status");
				StatusPedido condPagamento = new StatusPedido(idStatusPedido, descricao, status);

				lista.add(condPagamento);

			}
			return lista;
		}
		finally{
			ConnectionManager.closeConexao();
		}	
	}

//	Método responsável por retornar o ID do último peido que foi feito	
	public int getNumeroUltimoPedido(){
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idUltimoPedido = 0;
		try{
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_ID_ULTIMO_PEDIDO);
			ps.clearParameters();
			rs = ps.executeQuery();

			while(rs.next()){

				idUltimoPedido = rs.getInt("idPedidoVenda");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			ConnectionManager.closeConexao();
		}	
		return idUltimoPedido;
	}
	
//	Método responsável por retornar o ID do último item que foi inserido ao pedido	
	public int getNumeroPedidoUltimoItem(){
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idUltimoPedido = 0;
		try{
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_ID_PEDIDO_ULTIMO_ITEM);
			ps.clearParameters();
			rs = ps.executeQuery();

			while(rs.next()){

				idUltimoPedido = rs.getInt("idPedidoVenda");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			ConnectionManager.closeConexao();
		}	
		return idUltimoPedido;
	}
	
//	Método responsável por obter o valor total do Pedido	
	public double getValorTotalPedidoCorrente(int numPedido){
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		double valorTotal = 0.0;
		try{
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_TOTAL_PEDIDO);
			ps.setInt(1, numPedido);
			rs = ps.executeQuery();

			while(rs.next()){

				valorTotal = rs.getDouble("valor");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			ConnectionManager.closeConexao();
		}	
		return valorTotal;
	}

//	Método responsável por criar e inserir uma nova instância de Item de venda ao banco de dados	
	public void insereItem(ItemPedidoVenda item) throws SQLException {
		Connection 			mySQLConnection = null;
		PreparedStatement 	ps = null;
		try {
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(INSERE_ITEM);
			ps.clearParameters();
			ps.setInt(1, item.getIdPedidoVenda());
			ps.setInt(2, item.getIdProduto());
			ps.setInt(3, item.getQuantidade());

			ps.executeUpdate();

		}
		finally	{
			ConnectionManager.closeConexao();
		}
	}
	
//	Método responsável por deletar o pedido caso o pedido não seja confirmado	
	public void deletaItensPedidoCorrente(int numPedido) throws SQLException {
		Connection 			mySQLConnection = null;
		PreparedStatement 	ps = null;
		try {
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(DELETA_ITENS_PEDIDO_CORRENTE);
			ps.clearParameters();
			ps.setInt(1, numPedido);

			ps.execute();

		}
		finally	{
			ConnectionManager.closeConexao();
		}
	}
	
//	Método responsável por inserir uma nova instância de Pedido de venda ao banco de dados
	public void inserePedido(PedidoVenda pedido) throws SQLException {
		Connection 			mySQLConnection = null;
		PreparedStatement 	ps = null;
		try {
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(INSERE_PEDIDO);
			ps.clearParameters();
			ps.setInt(1, pedido.getCliente().getIdCliente());
			ps.setInt(2, pedido.getVendedor().getIdVendedor());
			ps.setInt(3, pedido.getCondicaoPagamento().getIdCondPagto());
			ps.setInt(4, pedido.getStatusPedido().getIdStatusPedido());
			ps.setDouble(5, pedido.getPorcentagemDesconto());
			ps.setDouble(6, pedido.getTotal());

			ps.executeUpdate();

		}
		finally	{
			ConnectionManager.closeConexao();
		}
	}

//	Método responsável por criar e retornar uma tabela com os dados dos Itens do Pedido
	public JTable getTabelaItens(int numPedido){

		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			mySQLConnection = ConnectionManager.getConexao();
			Statement stmt = mySQLConnection.createStatement();
			ps = mySQLConnection.prepareStatement(GET_TABELA_ITENS);
			ps.setInt(1, numPedido);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			//  Get column names
			for (int i = 1; i <= columns; i++)
			{
				columnNames.add( md.getColumnName(i) );
			}

			//  Get row data
			while (rs.next())
			{
				ArrayList row = new ArrayList(columns);

				for (int i = 1; i <= columns; i++)
				{
					row.add( rs.getObject(i) );
				}

				data.add( row );
			}
		}
		catch (SQLException e)
		{
			System.out.println( e.getMessage() );
		}
		finally{
			ConnectionManager.closeConexao();
		}


		Vector columnNamesVector = new Vector();
		Vector dataVector = new Vector();

		for (int i = 0; i < data.size(); i++)
		{
			ArrayList subArray = (ArrayList)data.get(i);
			Vector subVector = new Vector();
			for (int j = 0; j < subArray.size(); j++)
			{
				subVector.add(subArray.get(j));
			}
			dataVector.add(subVector);
		}

		for (int i = 0; i < columnNames.size(); i++ )
			columnNamesVector.add(columnNames.get(i));

		JTable table = new JTable(dataVector, columnNamesVector)
		{
			public Class getColumnClass(int column)
			{
				for (int row = 0; row < getRowCount(); row++)
				{
					Object o = getValueAt(row, column);

					if (o != null)
					{
						return o.getClass();
					}
				}

				return Object.class;
			}
		};

		return table;
	}

//	Método responsável por criar e retornar uma tabela com os dados do Pedido	
	public JTable getTabelaPedidos(){

		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();
		Connection mySQLConnection = null;

		try {
			mySQLConnection = ConnectionManager.getConexao();
			Statement stmt = mySQLConnection.createStatement();
			ResultSet rs = stmt.executeQuery(GET_TABELA_PEDIDOS);
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			//  Get column names
			for (int i = 1; i <= columns; i++)
			{
				columnNames.add( md.getColumnName(i) );
			}

			//  Get row data
			while (rs.next())
			{
				ArrayList row = new ArrayList(columns);

				for (int i = 1; i <= columns; i++)
				{
					row.add( rs.getObject(i) );
				}

				data.add( row );
			}
		}
		catch (SQLException e)
		{
			System.out.println( e.getMessage() );
		}
		finally{
			ConnectionManager.closeConexao();
		}


		Vector columnNamesVector = new Vector();
		Vector dataVector = new Vector();

		for (int i = 0; i < data.size(); i++)
		{
			ArrayList subArray = (ArrayList)data.get(i);
			Vector subVector = new Vector();
			for (int j = 0; j < subArray.size(); j++)
			{
				subVector.add(subArray.get(j));
			}
			dataVector.add(subVector);
		}

		for (int i = 0; i < columnNames.size(); i++ )
			columnNamesVector.add(columnNames.get(i));

		JTable table = new JTable(dataVector, columnNamesVector)
		{
			public Class getColumnClass(int column)
			{
				for (int row = 0; row < getRowCount(); row++)
				{
					Object o = getValueAt(row, column);

					if (o != null)
					{
						return o.getClass();
					}
				}

				return Object.class;
			}
		};

		return table;
	}
	
}
