package br.pucpcaldas.concessionaria.controle.repositorio;

import java.util.ArrayList;

import br.pucpcaldas.concessionaria.dominio.Vendedor;

public class RegistroDeVendedoresEmMemoria {
	
	private static ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();
	
	public void cadastraVendedorEmMemoria(Vendedor vendedor){
		listaVendedores.add(vendedor);
	}

	public ArrayList<Vendedor> getListaVendedoresEmMemoria(){
		return listaVendedores;
	}

}
