package br.pucpcaldas.concessionaria.controle.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import br.pucpcaldas.concessionaria.controle.repositorio.RegistroDeVendedores;
import br.pucpcaldas.concessionaria.dominio.Vendedor;

public class ControladorVendedores {
	
	public RegistroDeVendedores registroVendedores;
	
	public ControladorVendedores() {
		registroVendedores = new RegistroDeVendedores();
	}
	
//	Método responsável por criar e inserir uma nova instância do Vendedor ao banco de dados
	public boolean cadastraVendedor(String nome, double comissao){
		boolean retorno = false;
		if(nome.equals("") || comissao == 0.0){
			retorno = false;
		}else{
			Vendedor vendedor = new Vendedor(nome.toUpperCase(), comissao);
			try {
				registroVendedores.cadastraVendedor(vendedor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				retorno = false;
			}
			retorno = true;
		}
		return retorno;
	}
	
//	Método responsável por criar e retornar uma tabela com os dados dos Vendedores 
//	cadastrados no banco de Dados
	public JTable getTabelaVendedores(){
		JTable tabela = registroVendedores.getTabelaVendedores();
		return tabela;
	}
	
//	Método responsável por criar e retornar uma lista com os Vendedores cadastrados no banco de Dados
	public List<Vendedor> getListVendedor(){
		
		List<Vendedor> lista = new ArrayList<Vendedor>();			
		RegistroDeVendedores ctVendedores = new RegistroDeVendedores();
		
		try {
			lista = ctVendedores.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
		
	} 

}
