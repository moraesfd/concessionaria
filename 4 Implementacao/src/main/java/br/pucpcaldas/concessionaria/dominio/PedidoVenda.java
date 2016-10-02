package br.pucpcaldas.concessionaria.dominio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PedidoVenda {
	
	private int idPedidoVenda;
	private Cliente cliente;
	private Vendedor vendedor;
	private CondicaoPagamento condicaoPagamento;
	private StatusPedido statusPedido;
	private double porcentagemDesconto;
	private SimpleDateFormat data;
	private double total;
	
	public PedidoVenda(int idPedidoVenda, Cliente cliente, Vendedor vendedor,
			CondicaoPagamento condicaoPagamento, StatusPedido statusPedido,
			double porcentagemDesconto, double total) {
		super();
		this.idPedidoVenda = idPedidoVenda;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.condicaoPagamento = condicaoPagamento;
		this.statusPedido = statusPedido;
		this.porcentagemDesconto = porcentagemDesconto;
		this.total = total;
	}

	public int getIdPedidoVenda() {
		return idPedidoVenda;
	}

	public void setIdPedidoVenda(int idPedidoVenda) {
		this.idPedidoVenda = idPedidoVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public double getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(double porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public SimpleDateFormat getData() {
		return data;
	}

	public void setData(SimpleDateFormat data) {
		this.data = data;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
