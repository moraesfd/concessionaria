package br.pucpcaldas.concessionaria.testes;

import org.junit.Assert;
import org.junit.Test;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorUsuarios;


public class TesteValidarUsuario {
	
	ControladorUsuarios controladorUsuario = new ControladorUsuarios();
	
	@Test
	public void testaUsuarioExistente(){
		Assert.assertEquals(true, controladorUsuario.validaUsuario("teste", "teste"));
	}
	
	@Test
	public void testaUsuarioInexistente(){
		Assert.assertEquals(false, controladorUsuario.validaUsuario("bbb", "bbb"));
	}

}
