package br.pucpcaldas.concessionaria.testes;

import org.junit.Assert;
import org.junit.Test;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorEstoque;
import br.pucpcaldas.concessionaria.controle.controlador.ControladorProdutos;
import br.pucpcaldas.concessionaria.dominio.Adicional;
import br.pucpcaldas.concessionaria.dominio.Cor;
import br.pucpcaldas.concessionaria.dominio.Estoque;


public class TesteAtualizarEstoque {
	
	ControladorEstoque controladorEstoque = new ControladorEstoque();
	ControladorProdutos controladorProdutos = new ControladorProdutos();
	
	Estoque estoqueProduto1ComQuantidadeMaiorQueZero = new Estoque(1, 10);
	Estoque estoqueProduto1ComQuantidadeMenorQueZero = new Estoque(1, -10);
	
	@Test
	public void testaAtualizarEstoqueDeProdutoComQuantidadeMaiorQueZero(){
		cadastraProdutosParaTeste();
		cadastraEstoqueParaTeste();
		Assert.assertEquals(true, controladorEstoque.atualizaEstoqueEmMemoria(estoqueProduto1ComQuantidadeMaiorQueZero));
	}
	
	@Test
	public void testaAtualizarEstoqueDeProdutoComQuantidadeMenorQueZero(){
		cadastraProdutosParaTeste();
		cadastraEstoqueParaTeste();
		Assert.assertEquals(false, controladorEstoque.atualizaEstoqueEmMemoria(estoqueProduto1ComQuantidadeMenorQueZero));
	}
	
	public void cadastraProdutosParaTeste(){
		Cor cor = new Cor(1, "amarelo", 1);
		Adicional adicional = new Adicional(1, "vidro eletrico", 1);
		controladorProdutos.cadastrarProdutoEmMemoria(1, "meriva", "teste de cadastro", 10.0, cor, adicional, 20000.0);
	}
	
	public void cadastraEstoqueParaTeste(){
		controladorEstoque.cadastraEstoqueProdutoEmMemoria(1, 5);
	}

}
