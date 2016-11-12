package br.pucpcaldas.concessionaria.controle.repositorio;

import java.util.ArrayList;

import br.pucpcaldas.concessionaria.dominio.Cliente;


public class CarteiraDeClientesEmMemoria {

	private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	public void cadastraClienteEmMemoria(Cliente cliente){
		listaClientes.add(cliente);
	}

	public ArrayList<Cliente> getListaClientesEmMemoria(){
		return listaClientes;
	}

}
