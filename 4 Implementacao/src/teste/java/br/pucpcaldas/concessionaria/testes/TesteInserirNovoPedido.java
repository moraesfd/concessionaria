package br.pucpcaldas.concessionaria.testes;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorClientes;
import br.pucpcaldas.concessionaria.controle.controlador.ControladorPedido;
import br.pucpcaldas.concessionaria.controle.controlador.ControladorProdutos;
import br.pucpcaldas.concessionaria.controle.controlador.ControladorVendedores;
import br.pucpcaldas.concessionaria.dominio.Cliente;
import br.pucpcaldas.concessionaria.dominio.CondicaoPagamento;
import br.pucpcaldas.concessionaria.dominio.ItemPedidoVenda;
import br.pucpcaldas.concessionaria.dominio.PedidoVenda;
import br.pucpcaldas.concessionaria.dominio.StatusPedido;
import br.pucpcaldas.concessionaria.dominio.Vendedor;


public class TesteInserirNovoPedido {
	
	ControladorPedido controladorPedidos = new ControladorPedido();
	ControladorClientes controladorClientes = new ControladorClientes();
	ControladorVendedores controladorVendedores = new ControladorVendedores();
	ControladorProdutos controladorProdutos = new ControladorProdutos();
	
	List<Cliente> listaClientes = controladorClientes.getListClientesTodasInformacoes();
	List<Vendedor> listaVendedores = controladorVendedores.getListVendedor();
	List<CondicaoPagamento> listaCondicaoPagamento = controladorPedidos.getListCondicaoPagamento();
	List<StatusPedido> listaStatusPedido = controladorPedidos.getListStatusPedido();
	
	public PedidoVenda getNovoPedidoComUmItem(){
		
		int idPedidoNovo = controladorPedidos.getNumeroPedidoUltimoItem()+1;
		
		Cliente cliente = listaClientes.get(0);
		Vendedor vendedor = listaVendedores.get(0);
		CondicaoPagamento condicaoPagamento = listaCondicaoPagamento.get(0);
		StatusPedido statusPedido = listaStatusPedido.get(0);
		int idUltimoProduto = controladorProdutos.getIdUltimoProdutoCadastrado();
		
		ItemPedidoVenda item1 = new ItemPedidoVenda(idPedidoNovo, idUltimoProduto, 10);
		controladorPedidos.insereItem(item1);
		
		double valorTotal = controladorPedidos.getValorTotalPedidoCorrente(idPedidoNovo);
		
		PedidoVenda pedido = new PedidoVenda(idPedidoNovo, cliente, vendedor, condicaoPagamento, statusPedido, 10.0, valorTotal);
		
		return pedido;	
		
	}
	
	public PedidoVenda getNovoPedidoFaltandoInformacoes(){
		
		int idPedidoNovo = controladorPedidos.getNumeroPedidoUltimoItem()+1;
		
		Cliente cliente = null;
		Vendedor vendedor = null;
		CondicaoPagamento condicaoPagamento = null;
		StatusPedido statusPedido = null;
		int idUltimoProduto = controladorProdutos.getIdUltimoProdutoCadastrado();
		
		ItemPedidoVenda item1 = new ItemPedidoVenda(idPedidoNovo, idUltimoProduto, 10);
		controladorPedidos.insereItem(item1);
		
		double valorTotal = controladorPedidos.getValorTotalPedidoCorrente(idPedidoNovo);
		
		PedidoVenda pedido = new PedidoVenda(idPedidoNovo, cliente, vendedor, condicaoPagamento, statusPedido, 10.0, valorTotal);
		
		return pedido;	
	}
	
	
	@Test
	public void testaInserirNovoPedidoCompleto(){
		Assert.assertEquals(true, controladorPedidos.inserePedido(getNovoPedidoComUmItem()));
	}
	
	@Test
	public void testaInserirNovoPedidoFaltandoInformacoes(){
		Assert.assertEquals(false, controladorPedidos.inserePedido(getNovoPedidoFaltandoInformacoes()));
	}

}
