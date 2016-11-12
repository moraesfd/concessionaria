package br.pucpcaldas.concessionaria.testes;

import org.junit.Assert;
import org.junit.Test;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorUsuarios;


public class TesteValidarUsuario {
	
	ControladorUsuarios controladorUsuario = new ControladorUsuarios();
	
	@Test
	public void testaUsuarioExistente(){
		cadastrarUsuariosParaTeste();
		Assert.assertEquals(true, controladorUsuario.validaUsuarioEmMemória("teste", "teste"));
	}
	
	@Test
	public void testaUsuarioInexistente(){
		cadastrarUsuariosParaTeste();
		Assert.assertEquals(false, controladorUsuario.validaUsuarioEmMemória("bbb", "bbb"));
	}
	
	public void cadastrarUsuariosParaTeste(){
		controladorUsuario.cadastraUsuarioEmMemoria("teste", "teste", "teste");
		controladorUsuario.cadastraUsuarioEmMemoria("teste1", "123", "teste1");
		controladorUsuario.cadastraUsuarioEmMemoria("teste2", "321", "teste2");
	}

}
