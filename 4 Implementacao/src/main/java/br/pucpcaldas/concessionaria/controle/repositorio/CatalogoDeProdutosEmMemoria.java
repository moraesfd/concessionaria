package br.pucpcaldas.concessionaria.controle.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;

import br.pucpcaldas.concessionaria.dominio.Adicional;
import br.pucpcaldas.concessionaria.dominio.Cliente;
import br.pucpcaldas.concessionaria.dominio.Cor;
import br.pucpcaldas.concessionaria.dominio.Produto;

public class CatalogoDeProdutosEmMemoria {
	
	ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	ArrayList<Cor> listaCores = new ArrayList<Cor>();
	ArrayList<Adicional> listaAdicionais = new ArrayList<Adicional>();


//	M�todo respons�vel por receber uma inst�ncia do Controlador e 
//	inserir uma nova inst�ncia do Produto em mem�ria
	public void cadastraProduto(Produto produto) {
		listaProdutos.add(produto);
	}
	
//	M�todo respons�vel por receber uma inst�ncia do Controlador e 
//	inserir uma nova inst�ncia da Cor em mem�ria
	public void cadastraCor(Cor cor) {
		listaCores.add(cor);
	}
	
//	M�todo respons�vel por receber uma inst�ncia do Controlador e 
//	inserir uma nova inst�ncia do Adicional em mem�ria
	public void cadastraAdicional(Adicional adicional) {
		listaAdicionais.add(adicional);
	}

//	M�todo respons�vel por retornar uma lista com todas as cores cadastradas em mem�ria
	public List<Cor> getCores() {
		return listaCores;
	}
	
	
//	M�todo respons�vel por retornar o ID do �ltimo Produto cadastrado em mem�ria
	public int getIdUltimoProdutoCadastrado() {
		Produto p = listaProdutos.get(listaProdutos.size()-1);
		return p.getIdProduto();
	}
	
	
//	M�todo respons�vel por retornar uma lista com todas os adicionais cadastadados em mem�ria	
	public List<Adicional> getAdicionais() {
		return listaAdicionais;
	}
	
	
//	M�todo respons�vel por criar e retornar uma lista com os Pedidos cadastrados em mem�ria
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

}
