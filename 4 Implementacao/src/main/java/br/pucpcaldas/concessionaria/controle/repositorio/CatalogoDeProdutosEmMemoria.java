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


//	Método responsável por receber uma instância do Controlador e 
//	inserir uma nova instância do Produto em memória
	public void cadastraProduto(Produto produto) {
		listaProdutos.add(produto);
	}
	
//	Método responsável por receber uma instância do Controlador e 
//	inserir uma nova instância da Cor em memória
	public void cadastraCor(Cor cor) {
		listaCores.add(cor);
	}
	
//	Método responsável por receber uma instância do Controlador e 
//	inserir uma nova instância do Adicional em memória
	public void cadastraAdicional(Adicional adicional) {
		listaAdicionais.add(adicional);
	}

//	Método responsável por retornar uma lista com todas as cores cadastradas em memória
	public List<Cor> getCores() {
		return listaCores;
	}
	
	
//	Método responsável por retornar o ID do último Produto cadastrado em memória
	public int getIdUltimoProdutoCadastrado() {
		Produto p = listaProdutos.get(listaProdutos.size()-1);
		return p.getIdProduto();
	}
	
	
//	Método responsável por retornar uma lista com todas os adicionais cadastadados em memória	
	public List<Adicional> getAdicionais() {
		return listaAdicionais;
	}
	
	
//	Método responsável por criar e retornar uma lista com os Pedidos cadastrados em memória
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

}
