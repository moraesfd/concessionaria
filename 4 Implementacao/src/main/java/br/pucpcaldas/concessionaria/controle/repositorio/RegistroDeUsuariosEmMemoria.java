package br.pucpcaldas.concessionaria.controle.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import br.pucpcaldas.concessionaria.dominio.Usuario;

public class RegistroDeUsuariosEmMemoria {
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
//	M�todo respons�vel por criar e inserir uma nova inst�ncia do Usuario em mem�ria	
	public void cadastraUsuarioEmMemoria(Usuario usuario) throws SQLException {
		listaUsuarios.add(usuario);
	}
	
//	M�todo respons�vel por criar e retornar uma lista com os Usu�rios cadastrados em mem�ria
	public ArrayList<Usuario> getListaUsuariosEmMemoria(){
		return listaUsuarios;
	}

}
