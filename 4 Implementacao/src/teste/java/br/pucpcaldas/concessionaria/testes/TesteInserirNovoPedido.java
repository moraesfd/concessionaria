package br.pucpcaldas.concessionaria.testes;

import org.junit.Assert;
import org.junit.Test;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorPedido;
import br.pucpcaldas.concessionaria.controle.controlador.ControladorProdutos;
import br.pucpcaldas.concessionaria.dominio.Adicional;
import br.pucpcaldas.concessionaria.dominio.Cliente;
import br.pucpcaldas.concessionaria.dominio.CondicaoPagamento;
import br.pucpcaldas.concessionaria.dominio.Cor;
import br.pucpcaldas.concessionaria.dominio.PedidoVenda;
import br.pucpcaldas.concessionaria.dominio.StatusPedido;
import br.pucpcaldas.concessionaria.dominio.Vendedor;


public class TesteInserirNovoPedido {
	
	ControladorPedido controladorPedidos = new ControladorPedido();
	ControladorProdutos controladorProdutos = new ControladorProdutos();
	
	public PedidoVenda getNovoPedidoComUmItem(){
		
		int idPedidoNovo = 1;
		
		Cliente cliente = new Cliente(1, "cliente teste", "pocos", "mg");
		Vendedor vendedor = new Vendedor("vendedor teste", 10.0);
		CondicaoPagamento condicaoPagamento = new CondicaoPagamento(1, "A VISTA", 1);
		StatusPedido statusPedido = new StatusPedido(1, "APROVADO", 1);
		
		double valorTotal = 20000.0;
		
		PedidoVenda pedido = new PedidoVenda(idPedidoNovo, cliente, vendedor, condicaoPagamento, statusPedido, 10.0, valorTotal);
		
		return pedido;	
		
	}
	
	public PedidoVenda getNovoPedidoFaltandoInformacoes(){
		
		int idPedidoNovo = 2;
		
		Cliente cliente = null;
		Vendedor vendedor = null;
		CondicaoPagamento condicaoPagamento = null;
		StatusPedido statusPedido = null;
		
		double valorTotal = 20000.0;
		
		PedidoVenda pedido = new PedidoVenda(idPedidoNovo, cliente, vendedor, condicaoPagamento, statusPedido, 10.0, valorTotal);
		
		return pedido;	
	}
	
	
	@Test
	public void testaInserirNovoPedidoCompleto(){
		Assert.assertEquals(true, controladorPedidos.inserePedidoEmMemoria(getNovoPedidoComUmItem()));
	}
	
	@Test
	public void testaInserirNovoPedidoFaltandoInformacoes(){
		Assert.assertEquals(false, controladorPedidos.inserePedidoEmMemoria(getNovoPedidoFaltandoInformacoes()));
	}

}
