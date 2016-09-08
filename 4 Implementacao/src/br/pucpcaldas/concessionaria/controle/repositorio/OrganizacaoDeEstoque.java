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

import br.pucpcaldas.concessionaria.dominio.Cliente;
import br.pucpcaldas.concessionaria.dominio.Estoque;

public class OrganizacaoDeEstoque {
	
	private static final String ATUALIZA_ESTOQUE = "UPDATE estoque SET quantidade = ? where idProduto = ?";
	private static final String CADASTRA_ESTOQUE = "INSERT INTO estoque (idProduto, quantidade)	VALUES (?, ?)";
	private static final String GET_ESTOQUE_ATUAL = "SELECT idProduto, quantidade FROM estoque";
	private static final String GET_TABELA_ESTOQUE = "SELECT E.idProduto, P.produto, E.quantidade FROM estoque E " +
													 "INNER JOIN produto P ON P.idProduto = E.idProduto " +
													 "WHERE P.disponivel = '1'";

//	Método responsável por receber e inserir uma nova instância de Estoque ao banco de dados
	public void cadastraEstoqueProduto(Estoque estoque) throws SQLException {
		Connection 			mySQLConnection = null;
		PreparedStatement 	ps = null;
		try {
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(CADASTRA_ESTOQUE);
			ps.clearParameters();
			ps.setInt(1, estoque.getIdProduto());
			ps.setInt(2, estoque.getQuantidade());

			ps.executeUpdate();

		}
		finally	{
			ConnectionManager.closeConexao();
		}
	}
	
//	Método responsável por alterar informações sobre o Estoque no banco de dados
	public void atualizaEstoque(Estoque estoque) throws SQLException {
		Connection 			mySQLConnection = null;
		PreparedStatement 	ps = null;
		try {
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(ATUALIZA_ESTOQUE);
			ps.clearParameters();
			ps.setInt(1, estoque.getQuantidade());
			ps.setInt(2, estoque.getIdProduto());

			ps.executeUpdate();

		}
		finally	{
			ConnectionManager.closeConexao();
		}
	}
//	Método responsável por criar e retornar uma tabela com os dados do Estoque
	public JTable getTabelaEstoque(){

		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();
		Connection mySQLConnection = null;

		try {
			mySQLConnection = ConnectionManager.getConexao();
			Statement stmt = mySQLConnection.createStatement();
			ResultSet rs = stmt.executeQuery(GET_TABELA_ESTOQUE);
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
