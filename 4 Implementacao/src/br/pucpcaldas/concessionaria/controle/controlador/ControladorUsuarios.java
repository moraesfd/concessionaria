package br.pucpcaldas.concessionaria.controle.controlador;

import java.sql.SQLException;
import java.util.List;

import br.pucpcaldas.concessionaria.controle.repositorio.RegistroDeUsuarios;
import br.pucpcaldas.concessionaria.dominio.Usuario;

public class ControladorUsuarios {
	
	List<Usuario> lista;
	RegistroDeUsuarios usuarios = new RegistroDeUsuarios();
	
//	Método responsável por validar o login e senha do usuário, caso o usuário não esteja cadastrado
//	ao banco, o usuário ficará impossibilidade de utilizar o sistema
	public boolean validaUsuario(String login, String senha){			
		try {
			lista = usuarios.getListaUsuarios();
			int contador = 0;
			while(contador < lista.size()){
				if((login.equals(lista.get(contador).getLogin())) && ((senha.equals(lista.get(contador).getSenha())))){			
					return true;
				}
				contador++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	
//	Método responsável por criar e inserir uma nova instância do Usuario ao banco de dados
	public boolean cadastraUsuario(String login, String senha, String nome){			
		if(login.equals("") || senha.equals("") || nome.equals("")){
			return false;
		}
		else{
			Usuario usuario = new Usuario(login, senha, nome);
			try {
				usuarios.cadastraUsuario(usuario);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	}
	
//	public void mostrarUsuarios() throws SQLException{	
//		List<Usuario> lista = new ArrayList<Usuario>();
//		RegistroDeUsuarios usuarios = new RegistroDeUsuarios();
//		
//		lista = usuarios.getAll();
//		int contador = 0;
//		
//		while(contador < lista.size()){
//			System.out.println(lista.get(contador).getLogin());
//			
//			System.err.println("Tamanho da Lista : " + lista.size());
//			contador++;			
//		}
//	}

}
