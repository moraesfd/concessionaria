package br.pucpcaldas.concessionaria.controle.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import br.pucpcaldas.concessionaria.controle.repositorio.CatalogoDeProdutos;
import br.pucpcaldas.concessionaria.dominio.Adicional;
import br.pucpcaldas.concessionaria.dominio.Cor;
import br.pucpcaldas.concessionaria.dominio.Produto;

public class ControladorProdutos {
	
	private CatalogoDeProdutos catalogo;
	private List<Cor> listaCores = null;  //  @jve:decl-index=0:
	private List<Adicional> listaAdicionais = null;
	
	public ControladorProdutos(){
		catalogo = new CatalogoDeProdutos();
	}
	
//	Método responsável por criar e retornar uma lista com todas as cores cadastradas no banco de dados 
	public List<Cor> getCores() throws Exception{
		List<Cor> lista = new ArrayList<Cor>();
		lista = catalogo.getCores();
		return lista;
	}
	
	
//	Método responsável por criar e retornar uma lista com todos os adicionais 
	public List<Adicional> getAdicionais() throws Exception{
		List<Adicional> lista = new ArrayList<Adicional>();
		lista = catalogo.getAdicionais();
		return lista;
	}
	
//	Método responsável por criar e inserir uma nova instância do Produto ao banco de dados
	public boolean cadastrarProduto(String produto, String descricao, double peso, Cor cor,
			Adicional adicional, double valorUnitario){
		boolean retorno = false;
		if(produto.equals("") || descricao.equals("") || peso == 0.0 || cor == null || adicional == null || 
				valorUnitario == 0.0){
			retorno = false;
		}else{
			Produto produto2 = new Produto(produto.toUpperCase(), descricao.toUpperCase(), peso, cor, adicional, valorUnitario);
			try {
				catalogo.cadastraProduto(produto2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				retorno = false;
			}
			retorno = true;
		}
		return retorno;
	}
	
//	Método responsável por retornar uma lista com todas as cores cadastradas no banco de dados
	public List<Cor> getListaCores(){
		try {
			listaCores = getCores();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaCores;
	}
	
//	Método responsável por retornar uma lista com todas os adicionais cadastadados no banco de dados
	public List<Adicional> getListaAdicionais(){
		try {
			listaAdicionais = getAdicionais();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAdicionais;
	}

//	Método responsável por retornar uma determinada instância de cor
	public Cor getCorSelecionada(String cor){
		Cor cor1 = new Cor();
		for(int i = 0; i < listaCores.size(); i++){
			if(listaCores.get(i).getCor().equals(cor)){
				cor1 = listaCores.get(i);
			}
		}
		return cor1;
	}

//	Método responsável por retornar uma determinada instância de adicional
	public Adicional getAdicionalSelecionado(String adicional){
		Adicional adicional1 = new Adicional();
		for(int i = 0; i < listaCores.size(); i++){
			if(listaAdicionais.get(i).getAdicional().equals(adicional)){
				adicional1 = listaAdicionais.get(i);
			}
		}
		return adicional1;
	}
	
//	Método responsável por criar e retornar uma tabela com os dados dos Produtos
	public JTable getTabelaProdutos(){
		JTable tabela = catalogo.getTabelaProdutos();
		return tabela;
	}
	
//	Método responsável por retornar o ID do último Produto cadastrado no banco de dados
	public int getIdUltimoProdutoCadastrado(){
		int id = 0;
		try {
			id = catalogo.getIdUltimoProdutoCadastrado();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
//	Método responsável por criar e retornar uma lista com os Pedidos cadastrados no banco de Dados
	public List<Produto> getListaProdutos(){
		List<Produto> listaProdutos = null;
		try {
			listaProdutos = catalogo.getListaProdutos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaProdutos;
	}

}
