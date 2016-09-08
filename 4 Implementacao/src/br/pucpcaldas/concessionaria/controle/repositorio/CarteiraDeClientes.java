package br.pucpcaldas.concessionaria.controle.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;

import br.pucpcaldas.concessionaria.dominio.Cliente;


public class CarteiraDeClientes {

	private static final String CADASTRA_CLIENTE = "INSERT INTO cliente (nome, endereco, numero, bairro, municipio, uf, cep, telefone, cpf)	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL = "SELECT idCliente, nome, municipio, uf FROM cliente";
	private static final String GET_TABELA_CLIENTES = "SELECT idCliente, nome, municipio, uf FROM cliente";
	private static final String GET_ALL_INFORMATION_ABOUT = "SELECT * FROM cliente";

	/**
	 * validaUsuario
	 * @param user
	 * @param pass
	 * @return
	 * @throws SQLException 
	 */

//	Método responsável por receber uma instância do controlador e inserir ao banco de dados
	public void cadastraCliente(Cliente cliente) throws SQLException {
		Connection 			mySQLConnection = null;
		PreparedStatement 	ps = null;
		try {
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(CADASTRA_CLIENTE);
			ps.clearParameters();
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setInt(3, cliente.getNumero());
			ps.setString(4, cliente.getBairro());
			ps.setString(5, cliente.getMunicipio());
			ps.setString(6, cliente.getUf());
			ps.setString(7, cliente.getCep());
			ps.setString(8, cliente.getTelefone());
			ps.setString(9, cliente.getCpf());

			ps.executeUpdate();

		}
		finally	{
			ConnectionManager.closeConexao();
		}
	}

	
//	Método responsável por criar e retornar uma lista que irá conter determinados dados dos clientes
	public List<Cliente> getAll() throws SQLException {
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int idCliente = 0;
		String nome = null, municipio = null, uf = null;
		try{
			List<Cliente> lista = new ArrayList<Cliente>();
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_ALL);
			ps.clearParameters();
			rs = ps.executeQuery();

			while(rs.next()){

				idCliente = rs.getInt("idCliente");
				nome = rs.getString("nome");
				municipio = rs.getString("municipio");
				uf = rs.getString("uf");
				Cliente cliente = new Cliente(idCliente, nome, municipio, uf);

				lista.add(cliente);

			}
			return lista;
		}
		finally{
			ConnectionManager.closeConexao();
		}	
	}

//	Método responsável por criar e retornar uma tabela que irá conter as instâncias de todos os Clientes
	public JTable getTabelaClientes(){

		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();
		Connection mySQLConnection = null;

		try {
			mySQLConnection = ConnectionManager.getConexao();
			Statement stmt = mySQLConnection.createStatement();
			ResultSet rs = stmt.executeQuery(GET_TABELA_CLIENTES);
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
	
	
//	Método responsável por criar e retornar uma lista com todas as informações do cliente	
	public List<Cliente> getAllInformationAbout() throws SQLException {
		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int numero = 0;
		String nome = null, endereco = null, bairro = null, municipio = null, uf = null,
		 cep = null, telefone = null, cpf = null;
		
		try{
			List<Cliente> lista = new ArrayList<Cliente>();
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_ALL_INFORMATION_ABOUT);
			ps.clearParameters();
			rs = ps.executeQuery();

			while(rs.next()){

				nome = rs.getString("nome");
				endereco = rs.getString("endereco");
				numero = rs.getInt("numero");
				bairro = rs.getString("bairro");
				municipio = rs.getString("municipio");
				uf = rs.getString("uf");
				cep = rs.getString("cep");
				telefone = rs.getString("telefone");
				cpf = rs.getString("cpf");
				
				Cliente cliente = new Cliente(nome, endereco, numero, 
						bairro, municipio, uf, cep, telefone, cpf);

				lista.add(cliente);

			}
			return lista;
		}
		finally{
			ConnectionManager.closeConexao();
		}	
	}

}
