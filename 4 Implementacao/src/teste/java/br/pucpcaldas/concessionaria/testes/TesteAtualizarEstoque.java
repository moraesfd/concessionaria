package br.pucpcaldas.concessionaria.testes;

import org.junit.Assert;
import org.junit.Test;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorEstoque;
import br.pucpcaldas.concessionaria.controle.controlador.ControladorProdutos;
import br.pucpcaldas.concessionaria.dominio.Estoque;


public class TesteAtualizarEstoque {
	
	ControladorEstoque controladorEstoque = new ControladorEstoque();
	ControladorProdutos controladorProdutos = new ControladorProdutos();
	
	Estoque estoqueProduto1ComQuantidadeMaiorQueZero = new Estoque(controladorProdutos.getIdUltimoProdutoCadastrado(), 10);
	Estoque estoqueProduto1ComQuantidadeMenorQueZero = new Estoque(controladorProdutos.getIdUltimoProdutoCadastrado(), -10);
	
	@Test
	public void testaAtualizarEstoqueDeProdutoComQuantidadeMaiorQueZero(){
		Assert.assertEquals(true, controladorEstoque.atualizaEstoque(estoqueProduto1ComQuantidadeMaiorQueZero));
	}
	
	@Test
	public void testaAtualizarEstoqueDeProdutoComQuantidadeMenorQueZero(){
		Assert.assertEquals(false, controladorEstoque.atualizaEstoque(estoqueProduto1ComQuantidadeMenorQueZero));
	}

}
