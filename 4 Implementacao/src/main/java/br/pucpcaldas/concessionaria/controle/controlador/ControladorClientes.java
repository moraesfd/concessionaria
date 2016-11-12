package br.pucpcaldas.concessionaria.controle.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import br.pucpcaldas.concessionaria.controle.repositorio.CarteiraDeClientes;
import br.pucpcaldas.concessionaria.controle.repositorio.CarteiraDeClientesEmMemoria;
import br.pucpcaldas.concessionaria.dominio.Cliente;

public class ControladorClientes {
	
	private CarteiraDeClientes carteira;
	private CarteiraDeClientesEmMemoria carteiraEmMemoria;
	
	public ControladorClientes(){
		carteira = new CarteiraDeClientes();
	}
	
//	M�todo respons�vel por criar uma inst�ncia de Cliente e inserir a inst�ncia no banco
	public boolean cadastraCliente(String nome, String endereco, int numero, String bairro,
			String municipio, String uf, String cep, String telefone, String cpf){
		boolean retorno = false;
		if(nome.equals("") || endereco.equals("") || numero == 0 || bairro.equals("") || municipio.equals("") || 
				uf.equals("") || cep.equals("") || telefone.equals("") || cpf.equals("")){
			retorno = false;
		}else{
			Cliente cliente = new Cliente(nome.toUpperCase(), endereco.toUpperCase(), numero, bairro.toUpperCase(), municipio.toUpperCase(), uf.toUpperCase(), cep.toUpperCase(), telefone.toUpperCase(), cpf.toUpperCase());
			try {
				carteira.cadastraCliente(cliente);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				retorno = false;
			}
			retorno = true;
		}
		return retorno;
	}
	
//	M�todo respons�vel por criar uma inst�ncia de Cliente e inserir a inst�ncia em mem�ria
	public boolean cadastraClienteEmMemoria(String nome, String endereco, int numero, String bairro,
			String municipio, String uf, String cep, String telefone, String cpf){
		boolean retorno = false;
		if(nome.equals("") || endereco.equals("") || numero == 0 || bairro.equals("") || municipio.equals("") || 
				uf.equals("") || cep.equals("") || telefone.equals("") || cpf.equals("")){
			retorno = false;
		}else{
			Cliente cliente = new Cliente(nome.toUpperCase(), endereco.toUpperCase(), numero, bairro.toUpperCase(), municipio.toUpperCase(), uf.toUpperCase(), cep.toUpperCase(), telefone.toUpperCase(), cpf.toUpperCase());
			try {
				carteiraEmMemoria = new CarteiraDeClientesEmMemoria();
				carteiraEmMemoria.cadastraClienteEmMemoria(cliente);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				retorno = false;
			}
			retorno = true;
		}
		return retorno;
	}
	
//	M�todo respons�vel por criar e retornar uma tabela que ir� conter os dados dos clientes	
	public JTable getTabelaClientes(){
		JTable tabela = carteira.getTabelaClientes();
		return tabela;
	}

//	M�todo respons�vel por criar e retornar uma lista com determinadas informa��es sobre o cliente
	public List<Cliente> getListClientes(){
		List<Cliente> lista = null;
		CarteiraDeClientes ctClientes = new CarteiraDeClientes();
		
		try {
			lista = ctClientes.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return lista;
		
	} 
	
//	M�todo respons�vel por criar e retornar uma lista com todas as informa��es do cliente
	public List<Cliente> getListClientesTodasInformacoes(){
		List<Cliente> lista = null;
		CarteiraDeClientes ctClientes = new CarteiraDeClientes();
		
		try {
			lista = ctClientes.getAllInformationAbout();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return lista;
		
	}

}
