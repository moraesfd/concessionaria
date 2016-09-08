package br.pucpcaldas.concessionaria.dominio;

public class CondicaoPagamento {
	
	private int idCondPagto;
	private String descricao;
	private int status;
	
	public CondicaoPagamento(int idCondPagto, String descricao, int status) {
		super();
		this.idCondPagto = idCondPagto;
		this.descricao = descricao;
		this.status = status;
	}

	public int getIdCondPagto() {
		return idCondPagto;
	}

	public void setIdCondPagto(int idCondPagto) {
		this.idCondPagto = idCondPagto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
