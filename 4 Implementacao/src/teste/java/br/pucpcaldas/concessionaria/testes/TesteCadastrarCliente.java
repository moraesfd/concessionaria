package br.pucpcaldas.concessionaria.testes;

import org.junit.Assert;
import org.junit.Test;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorClientes;


public class TesteCadastrarCliente {

	ControladorClientes controladorClientes = new ControladorClientes();

	
// Testa cadastrar usuarios em banco de dados
//	@Test
//	public void testaCadastrarUsuarioComDadosCompletos(){
//		Assert.assertEquals(true, controladorClientes.cadastraCliente("Joao", "Rua XX", 44, "Bairro A", "Cidade X", "MG", "33333333", "35999999999", "11144422253"));
//	}
//
//	@Test
//	public void testaCadastrarUsuarioComDadosImcompletos(){
//		Assert.assertEquals(false, controladorClientes.cadastraCliente("Joao", "Rua XX", 44, "", "", "MG", "33333333", "35999999999", ""));
//	}
//
//	@Test
//	public void testaCadastrarUsuarioSemDados(){
//		Assert.assertEquals(false, controladorClientes.cadastraCliente("", "", 0,"", "", "", "", "", ""));
//	}


// Testa cadastrar usuarios em memória
	@Test
	public void testaCadastrarClienteComDadosCompletos(){
		Assert.assertEquals(true, controladorClientes.cadastraClienteEmMemoria("Joao", "Rua XX", 44, "Bairro A", "Cidade X", "MG", "33333333", "35999999999", "11144422253"));
	}

	@Test
	public void testaCadastrarClienteComDadosImcompletos(){
		Assert.assertEquals(false, controladorClientes.cadastraClienteEmMemoria("Joao", "Rua XX", 44, "", "", "MG", "33333333", "35999999999", ""));
	}

	@Test
	public void testaCadastrarClienteSemDados(){
		Assert.assertEquals(false, controladorClientes.cadastraClienteEmMemoria("", "", 0,"", "", "", "", "", ""));
	}

}
