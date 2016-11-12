package br.pucpcaldas.concessionaria.testes;

import org.junit.Assert;
import org.junit.Test;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorVendedores;


public class TesteCadastrarVendedor {
	
ControladorVendedores controladorVendedores = new ControladorVendedores();
	

// Testa cadastrar vendedores em banco de dados
//	@Test
//	public void testaCadastrarVendedorComDados(){
//		Assert.assertEquals(true, controladorVendedores.cadastraVendedor("vendedor teste", 10.0));
//	}
//	
//	@Test
//	public void testaCadastrarVendedorSemDados(){
//		Assert.assertEquals(false, controladorVendedores.cadastraVendedor("", 0));
//	}


// Testa cadastrar vendedores em memória
	@Test
	public void testaCadastrarVendedorComDados(){
		Assert.assertEquals(true, controladorVendedores.cadastraVendedorEmMemoria("vendedor teste", 10.0));
	}
	
	@Test
	public void testaCadastrarVendedorSemDados(){
		Assert.assertEquals(false, controladorVendedores.cadastraVendedorEmMemoria("", 0));
	}

}
