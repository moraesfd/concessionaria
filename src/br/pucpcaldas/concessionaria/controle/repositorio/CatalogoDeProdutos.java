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

import javax.swing.JTable;

import br.pucpcaldas.concessionaria.dominio.Adicional;
import br.pucpcaldas.concessionaria.dominio.Cliente;
import br.pucpcaldas.concessionaria.dominio.Cor;
import br.pucpcaldas.concessionaria.dominio.Produto;

public class CatalogoDeProdutos {
	
	private static final String CADASTRA_PRODUTO = "INSERT INTO produto (produto, descricao, peso, idCor, idAdicional, valorUnitario) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_CORES = "SELECT idCor, cor, status FROM cor";
	private static final String GET_ULTIMO_CADASTRADO = "SELECT MAX(idProduto) as idProduto FROM produto";
	private static final String GET_ADICIONAIS = "SELECT idAdicional, adicional, status FROM adicional";
	private static final String GET_TABELA_PRODUTOS = "SELECT P.produto AS Produto, " +
													  "P.descricao AS Descricao, " +
													  "P.valorUnitario AS Valor, " +
													  "C.cor AS Cor, " +
													  "A.adicional AS Adicional " +
													  "FROM produto P " +
													  "INNER JOIN cor C ON C.idCor = P.idCor " +
													  "INNER JOIN adicional A ON A.idAdicional = P.idAdicional " +
													  "WHERE P.disponivel = 1";
	private static final String GET_ALL = "SELECT idProduto, produto FROM produto WHERE disponivel = '1'";


//	Método responsável por receber uma instância do Controlador e 
//	inserir uma nova instância do Produto ao banco de dados	
	public void cadastraProduto(Produto produto) throws SQLException {
		Connection 			mySQLConnection = null;
		PreparedStatement 	ps = null;
		try {
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(CADASTRA_PRODUTO);
			ps.clearParameters();
			ps.setString(1, produto.getProduto());
			ps.setString(2, produto.getDescricao());
			ps.setDouble(3, produto.getPeso());
			ps.setInt(4, produto.getCor().getIdCor());
			ps.setInt(5, produto.getAdicional().getIdAdicional());
			ps.setDouble(6, produto.getValorUnitario());

			ps.executeUpdate();

		}
		finally	{
			ConnectionManager.closeConexao();
		}
	}

//	Método responsável por retornar uma lista com todas as cores cadastradas no banco de dados
	public List<Cor> getCores() throws SQLException {
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idCor = 0, status = 0;
		String cor = null;
		try{
			List<Cor> lista = new ArrayList<Cor>();
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_CORES);
			ps.clearParameters();
			rs = ps.executeQuery();

			while(rs.next()){

				idCor = rs.getInt("idCor");
				cor = rs.getString("cor");
				status = rs.getInt("status");
				Cor cor1 = new Cor(idCor, cor, status);

				lista.add(cor1);

			}
			return lista;
		}
		finally{
			ConnectionManager.closeConexao();
		}	
	}
	
	
//	Método responsável por retornar o ID do último Produto cadastrado no banco de dados	
	public int getIdUltimoProdutoCadastrado() throws SQLException {
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idProduto = 0;
		try{
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_ULTIMO_CADASTRADO);
			ps.clearParameters();
			rs = ps.executeQuery();

			while(rs.next()){

				idProduto = rs.getInt("idProduto");

			}
			return idProduto;
		}
		finally{
			ConnectionManager.closeConexao();
		}	
	}
	
	
//	Método responsável por retornar uma lista com todas os adicionais cadastadados no banco de dados	
	public List<Adicional> getAdicionais() throws SQLException {
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idAdicional = 0, status = 0;
		String adicional = null;
		try{
			List<Adicional> lista = new ArrayList<Adicional>();
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_ADICIONAIS);
			ps.clearParameters();
			rs = ps.executeQuery();

			while(rs.next()){

				idAdicional = rs.getInt("idAdicional");
				adicional = rs.getString("adicional");
				status = rs.getInt("status");
				Adicional adicional1 = new Adicional(idAdicional, adicional, status);

				lista.add(adicional1);

			}
			return lista;
		}
		finally{
			ConnectionManager.closeConexao();
		}	
	}
	
	
//	Método responsável por criar e retornar uma tabela com os dados dos Produtos
	public JTable getTabelaProdutos(){

		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();
		Connection mySQLConnection = null;

		try {
			mySQLConnection = ConnectionManager.getConexao();
			Statement stmt = mySQLConnection.createStatement();
			ResultSet rs = stmt.executeQuery(GET_TABELA_PRODUTOS);
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
	
//	Método responsável por criar e retornar uma lista com os Pedidos cadastrados no banco de Dados
	public List<Produto> getListaProdutos() throws SQLException {
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idProduto = 0;
		String produto = "";
		try{
			List<Produto> lista = new ArrayList<Produto>();
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_ALL);
			ps.clearParameters();
			rs = ps.executeQuery();

			while(rs.next()){

				idProduto = rs.getInt("idProduto");
				produto = rs.getString("produto");
				Produto p = new Produto(idProduto, produto);

				lista.add(p);

			}
			return lista;
		}
		finally{
			ConnectionManager.closeConexao();
		}	
	}

}
