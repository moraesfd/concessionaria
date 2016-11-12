package br.pucpcaldas.concessionaria.controle.repositorio;

import java.util.ArrayList;

import br.pucpcaldas.concessionaria.dominio.PedidoVenda;

public class LivroDePedidosEmMemoria {
	
	ArrayList<PedidoVenda> listaPedidos = new ArrayList<PedidoVenda>();
	
//	Método responsável por inserir uma nova instância de Pedido de venda em memória
	public void inserePedido(PedidoVenda pedido) {
		listaPedidos.add(pedido);
	}
	
}
