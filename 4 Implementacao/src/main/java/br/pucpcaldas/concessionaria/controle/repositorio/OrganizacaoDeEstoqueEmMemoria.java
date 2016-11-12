package br.pucpcaldas.concessionaria.controle.repositorio;

import java.util.ArrayList;

import br.pucpcaldas.concessionaria.dominio.Estoque;

public class OrganizacaoDeEstoqueEmMemoria {
	
	ArrayList<Estoque> listaEstoque = new ArrayList<Estoque>();

//	Método responsável por receber e inserir uma nova instância de Estoque em memória
	public void cadastraEstoqueProduto(Estoque estoque) {
		listaEstoque.add(estoque);
	}
	
//	Método responsável por alterar informações sobre o Estoque em memória
	public void atualizaEstoque(Estoque estoque) {
		int i = 0;
		for (i = 0; i < listaEstoque.size(); i++) {
			if (listaEstoque.get(i).getIdProduto() == estoque.getIdProduto()) {
				listaEstoque.get(i).setQuantidade(estoque.getQuantidade());
			}
		}
	}

}
