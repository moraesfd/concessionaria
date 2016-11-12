package br.pucpcaldas.concessionaria.controle.repositorio;

import java.util.ArrayList;

import br.pucpcaldas.concessionaria.dominio.Estoque;

public class OrganizacaoDeEstoqueEmMemoria {
	
	ArrayList<Estoque> listaEstoque = new ArrayList<Estoque>();

//	M�todo respons�vel por receber e inserir uma nova inst�ncia de Estoque em mem�ria
	public void cadastraEstoqueProduto(Estoque estoque) {
		listaEstoque.add(estoque);
	}
	
//	M�todo respons�vel por alterar informa��es sobre o Estoque em mem�ria
	public void atualizaEstoque(Estoque estoque) {
		int i = 0;
		for (i = 0; i < listaEstoque.size(); i++) {
			if (listaEstoque.get(i).getIdProduto() == estoque.getIdProduto()) {
				listaEstoque.get(i).setQuantidade(estoque.getQuantidade());
			}
		}
	}

}
