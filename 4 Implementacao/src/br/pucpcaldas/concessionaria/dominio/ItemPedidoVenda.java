package br.pucpcaldas.concessionaria.dominio;

public class ItemPedidoVenda {
	
	private int idPedidoVenda;
	private int idProduto;
	private int quantidade;
	private int status;
	
	public ItemPedidoVenda(int idPedidoVenda, int idProduto,
			int quantidade, int status) {
		super();
		this.idPedidoVenda = idPedidoVenda;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.status = status;
	}
	
	

	public ItemPedidoVenda(int idPedidoVenda, int idProduto,
			int quantidade) {
		super();
		this.idPedidoVenda = idPedidoVenda;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}



	public int getIdPedidoVenda() {
		return idPedidoVenda;
	}

	public void setIdPedidoVenda(int idPedidoVenda) {
		this.idPedidoVenda = idPedidoVenda;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int IdProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}	
	
	

}
