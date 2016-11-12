package br.pucpcaldas.concessionaria.controle.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import br.pucpcaldas.concessionaria.dominio.Usuario;

public class RegistroDeUsuariosEmMemoria {
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
//	Método responsável por criar e inserir uma nova instância do Usuario em memória	
	public void cadastraUsuarioEmMemoria(Usuario usuario) throws SQLException {
		listaUsuarios.add(usuario);
	}
	
//	Método responsável por criar e retornar uma lista com os Usuários cadastrados em memória
	public ArrayList<Usuario> getListaUsuariosEmMemoria(){
		return listaUsuarios;
	}

}
