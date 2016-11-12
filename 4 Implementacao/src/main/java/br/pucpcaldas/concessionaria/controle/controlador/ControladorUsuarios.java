package br.pucpcaldas.concessionaria.controle.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.pucpcaldas.concessionaria.controle.repositorio.RegistroDeUsuarios;
import br.pucpcaldas.concessionaria.controle.repositorio.RegistroDeUsuariosEmMemoria;
import br.pucpcaldas.concessionaria.dominio.Usuario;

public class ControladorUsuarios {
	
	List<Usuario> lista;
	ArrayList<Usuario> listaUsuariosEmMemoria;
	
	RegistroDeUsuarios usuarios = new RegistroDeUsuarios();
	RegistroDeUsuariosEmMemoria usuariosEmMemoria;
	
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
	
//	Método responsável por validar o login e senha do usuário, caso o usuário não esteja cadastrado
//	em memória, o usuário ficará impossibilidade de utilizar o sistema
	public boolean validaUsuarioEmMemória(String login, String senha){			
		try {
			usuariosEmMemoria = new RegistroDeUsuariosEmMemoria();
			listaUsuariosEmMemoria = usuariosEmMemoria.getListaUsuariosEmMemoria();
			int contador = 0;
			while(contador < listaUsuariosEmMemoria.size()){
				if((login.equals(listaUsuariosEmMemoria.get(contador).getLogin())) && ((senha.equals(listaUsuariosEmMemoria.get(contador).getSenha())))){			
					return true;
				}
				contador++;
			}
		} catch (Exception e) {
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
	
//	Método responsável por criar e inserir uma nova instância do Usuario em memória
	public boolean cadastraUsuarioEmMemoria(String login, String senha, String nome){			
		if(login.equals("") || senha.equals("") || nome.equals("")){
			return false;
		}
		else{
			Usuario usuario = new Usuario(login, senha, nome);
			try {
				usuariosEmMemoria = new RegistroDeUsuariosEmMemoria();
				usuariosEmMemoria.cadastraUsuarioEmMemoria(usuario);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	}
	

}
