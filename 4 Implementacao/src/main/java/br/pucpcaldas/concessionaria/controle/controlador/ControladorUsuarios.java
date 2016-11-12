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
	
//	M�todo respons�vel por validar o login e senha do usu�rio, caso o usu�rio n�o esteja cadastrado
//	ao banco, o usu�rio ficar� impossibilidade de utilizar o sistema
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
	
//	M�todo respons�vel por validar o login e senha do usu�rio, caso o usu�rio n�o esteja cadastrado
//	em mem�ria, o usu�rio ficar� impossibilidade de utilizar o sistema
	public boolean validaUsuarioEmMem�ria(String login, String senha){			
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
	
//	M�todo respons�vel por criar e inserir uma nova inst�ncia do Usuario ao banco de dados
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
	
//	M�todo respons�vel por criar e inserir uma nova inst�ncia do Usuario em mem�ria
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
