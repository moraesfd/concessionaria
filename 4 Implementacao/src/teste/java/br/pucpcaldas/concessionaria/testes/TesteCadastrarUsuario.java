package br.pucpcaldas.concessionaria.testes;

import org.junit.Assert;
import org.junit.Test;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorUsuarios;


public class TesteCadastrarUsuario {
	
	ControladorUsuarios controladorUsuario = new ControladorUsuarios();
	
	@Test
	public void testaCadastrarUsuarioComDadosCompletos(){
		Assert.assertEquals(true, controladorUsuario.cadastraUsuarioEmMemoria("joao", "123", "Joao"));
	}

	@Test
	public void testaCadastrarUsuarioComDadosImcompletos(){
		Assert.assertEquals(false, controladorUsuario.cadastraUsuarioEmMemoria("", "321", "Teste"));
	}

	@Test
	public void testaCadastrarUsuarioSemDados(){
		Assert.assertEquals(false, controladorUsuario.cadastraUsuarioEmMemoria("", "", ""));
	}

}
