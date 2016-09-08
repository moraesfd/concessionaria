package br.pucpcaldas.concessionaria.dominio;

public class Adicional {
	
	private int idAdicional;
	private String adicional;
	private int status;
	
	public Adicional(int idAdicional, String adicional, int status) {
		super();
		this.idAdicional = idAdicional;
		this.adicional = adicional;
		this.status = status;
	}

	public Adicional() {
		// TODO Auto-generated constructor stub
	}

	public int getIdAdicional() {
		return idAdicional;
	}

	public void setIdAdicional(int idAdicional) {
		this.idAdicional = idAdicional;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
