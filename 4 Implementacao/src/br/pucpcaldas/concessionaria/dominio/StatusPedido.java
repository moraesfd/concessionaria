package br.pucpcaldas.concessionaria.dominio;

public class StatusPedido {
	
	private int idStatusPedido;
	private String descricao;
	private int status;
	
	public StatusPedido(int idStatusPedido, String descricao, int status) {
		super();
		this.idStatusPedido = idStatusPedido;
		this.descricao = descricao;
		this.status = status;
	}

	public int getIdStatusPedido() {
		return idStatusPedido;
	}

	public void setIdStatusPedido(int idStatusPedido) {
		this.idStatusPedido = idStatusPedido;
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
