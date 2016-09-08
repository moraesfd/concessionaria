package br.pucpcaldas.concessionaria.dominio;

public class Vendedor {
	
	/*
	 * Atributos
	 */
	
	private int idVendedor;
	private String nome;
	private double comissao;
	private int status;
	
	/*
	 * Construtores
	 */
	
	public Vendedor(int idVendedor, String nome, double comissao, int status) {
		super();
		this.idVendedor = idVendedor;
		this.nome = nome;
		this.comissao = comissao;
		this.status = status;
	}
	
	public Vendedor(String nome, double comissao) {
		super();
		this.nome = nome;
		this.comissao = comissao;
	}
	
	/*
	 * Getters e Setters
	 */

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
