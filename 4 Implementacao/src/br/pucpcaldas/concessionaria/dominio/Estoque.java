package br.pucpcaldas.concessionaria.dominio;

public class Estoque {
	
	private int idProduto;
	private int quantidade;
	
	public Estoque(int idProduto, int quantidade) {
		super();
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
		
}
