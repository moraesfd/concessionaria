package br.pucpcaldas.concessionaria.controle.repositorio;

import java.util.ArrayList;

import br.pucpcaldas.concessionaria.dominio.PedidoVenda;

public class LivroDePedidosEmMemoria {
	
	ArrayList<PedidoVenda> listaPedidos = new ArrayList<PedidoVenda>();
	
//	M�todo respons�vel por inserir uma nova inst�ncia de Pedido de venda em mem�ria
	public void inserePedido(PedidoVenda pedido) {
		listaPedidos.add(pedido);
	}
	
}
