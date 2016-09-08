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

import br.pucpcaldas.concessionaria.dominio.Vendedor;

public class RegistroDeVendedores {
	
	private static final String CADASTRA_VENDEDOR = "INSERT INTO vendedor (nome, comissao)	VALUES (?, ?)";
	private static final String GET_ALL = "SELECT idVendedor, nome, comissao, status FROM vendedor";
	private static final String GET_TABELA_VENDEDORES = "SELECT idVendedor, nome, comissao FROM vendedor WHERE status = '1'";
	

//	Método responsável por criar e inserir uma nova instância do Vendedor ao banco de dados	
	public void cadastraVendedor(Vendedor vendedor) throws SQLException {
		Connection 			mySQLConnection = null;
		PreparedStatement 	ps = null;
		try {
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(CADASTRA_VENDEDOR);
			ps.clearParameters();
			ps.setString(1, vendedor.getNome());
			ps.setDouble(2, vendedor.getComissao());

			ps.executeUpdate();

		}
		finally	{
			ConnectionManager.closeConexao();
		}
	}
	
//	Método responsável por criar e retornar uma lista com os Vendedores cadastrados no banco de Dados
	public List<Vendedor> getAll() throws SQLException {
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idVendedor = 0, status = 0;
		String nome = null;
		double comissao = 0.0;
		try{
			List<Vendedor> lista = new ArrayList<Vendedor>();
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_ALL);
			ps.clearParameters();
			rs = ps.executeQuery();

			while(rs.next()){

				idVendedor = rs.getInt("idVendedor");
				nome = rs.getString("nome");
				comissao = rs.getDouble("comissao");
				status = rs.getInt("status");
				Vendedor vendedor = new Vendedor(idVendedor, nome, comissao, status);

				lista.add(vendedor);

			}
			return lista;
		}
		finally{
			ConnectionManager.closeConexao();
		}	
	}

//	Método responsável por criar e retornar uma tabela com os dados dos Vendedores 
//	cadastrados no banco de Dados
	public JTable getTabelaVendedores(){

		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();
		Connection mySQLConnection = null;

		try {
			mySQLConnection = ConnectionManager.getConexao();
			Statement stmt = mySQLConnection.createStatement();
			ResultSet rs = stmt.executeQuery(GET_TABELA_VENDEDORES);
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
