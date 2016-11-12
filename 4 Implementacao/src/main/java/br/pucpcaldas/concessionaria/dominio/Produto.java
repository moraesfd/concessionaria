package br.pucpcaldas.concessionaria.dominio;

public class Produto {
	
	private int idProduto;
	private String produto;
	private String descricao;
	private double peso;
	private Cor cor;
	private Adicional adicional;
	private double valorUnitario;
	private int disponibilidade;
	
	public Produto(String produto, String descricao, double peso, Cor cor,
			Adicional adicional, double valorUnitario) {
		super();
		this.produto = produto;
		this.descricao = descricao;
		this.peso = peso;
		this.cor = cor;
		this.adicional = adicional;
		this.valorUnitario = valorUnitario;
	}
	
	public Produto(int idProduto, String produto, String descricao, double peso, Cor cor,
			Adicional adicional, double valorUnitario) {
		super();
		this.idProduto = idProduto;
		this.produto = produto;
		this.descricao = descricao;
		this.peso = peso;
		this.cor = cor;
		this.adicional = adicional;
		this.valorUnitario = valorUnitario;
	}
	
	

	public Produto(int idProduto, String produto) {
		super();
		this.idProduto = idProduto;
		this.produto = produto;
	}



	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Adicional getAdicional() {
		return adicional;
	}

	public void setAdicional(Adicional adicional) {
		this.adicional = adicional;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(int disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}	

}
