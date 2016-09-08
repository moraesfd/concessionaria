package br.pucpcaldas.concessionaria.controle.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.pucpcaldas.concessionaria.dominio.Cliente;
import br.pucpcaldas.concessionaria.dominio.Usuario;

public class RegistroDeUsuarios {
	private static final String GET_ALL = "SELECT idUsuario, login, senha, nome FROM usuario WHERE status = '1'";
	private static final String CADASTRA_USUARIO = "INSERT INTO usuario (login, senha, nome) VALUES (?, ?, ?)";

//	Método responsável por criar e retornar uma lista com os Usuários cadastrados no banco	
	public List<Usuario> getListaUsuarios() throws SQLException {

		Connection mySQLConnection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		try{
			List<Usuario> lista = new ArrayList<Usuario>();
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(GET_ALL);
			ps.clearParameters();
			rs = ps.executeQuery();
			int idUsuario;
			String login = null, senha = null, nome = null;

			while(rs.next()){

				idUsuario = rs.getInt("idUsuario");
				login =  rs.getString("login");
				senha =  rs.getString("senha");
				nome =  rs.getString("nome");

				Usuario usuario = new Usuario(idUsuario, login, senha, nome);

				lista.add(usuario);

			}
			return lista;
		}
		finally{
			ConnectionManager.closeConexao();
		}
	}
	
//	Método responsável por criar e inserir uma nova instância do Usuario ao banco de dados	
	public void cadastraUsuario(Usuario usuario) throws SQLException {
		Connection 			mySQLConnection = null;
		PreparedStatement 	ps = null;
		try {
			mySQLConnection = ConnectionManager.getConexao();
			ps = mySQLConnection.prepareStatement(CADASTRA_USUARIO);
			ps.clearParameters();
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getNome());

			ps.executeUpdate();

		}
		finally	{
			ConnectionManager.closeConexao();
		}
	}
}
