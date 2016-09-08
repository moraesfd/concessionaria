package br.pucpcaldas.concessionaria.controle.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	//Conexao MySQL
	private static Connection conexaoMySQL;
	private static String     nomeBanco = "concessionaria";
	private static String     host = "localhost";
	private static int        porta = 3306;
	private static String     usuario = "root";
	private static String     senha = "123456";
	
	
	private final static String		TITULO = "ConnectionManager";
	
	/**
	 *  getConexaoMySQL
	 * @return Connection
	 * @throws BioHealthException
	 */
//	M�todo respons�vel por criar e abrir a conex�o com o banco de Dados
	public static Connection getConexao() {
		if(conexaoMySQL == null){
			try {
				inicializaConexao();
				System.out.println("Conectado - Connection Manager");
				System.out.println("Host: "+host+" Banco: "+nomeBanco);
			} catch (SQLException e) {
				//Mensagens.msgDialog(TITULO, "Erro ao obter a conex�o do MySQL", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		return conexaoMySQL;
	}
	
	/**
	 * inicializaConexao MySQL
	 * @throws SQLException
	 */
	
//	M�todo respons�vel por inicializar a conex�o com o banco de Dados
	private static void inicializaConexao() throws SQLException {
		//monta string conexao
		String STR_CON = "jdbc:mysql://" + host + ":"+porta+"/" + nomeBanco + "?user=" + usuario + "&password=" + senha;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		conexaoMySQL = DriverManager.getConnection(STR_CON);
	}
	
	/**
	 * closeConexao
	 *
	 */
	
//	M�todo respons�vel por fechar a conex�o com o banco de Dados
	public static void closeConexao() {
		try {
			if(conexaoMySQL != null){
				if (!conexaoMySQL.isClosed()) {
					conexaoMySQL.close();
					conexaoMySQL = null;
					System.out.println("Fechou conexao MySQL - ConnectionManager!!");
				}
			}
		} 
		catch (SQLException e){
			//Mensagens.msgDialog(TITULO, "Falha ao fechar a conex�o com MySQL", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}