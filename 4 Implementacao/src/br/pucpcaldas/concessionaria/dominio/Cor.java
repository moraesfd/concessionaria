package br.pucpcaldas.concessionaria.dominio;

public class Cor {
	
	private int idCor;
	private String cor;
	private int status;
	
	public Cor(int idCor, String cor, int status) {
		super();
		this.idCor = idCor;
		this.cor = cor;
		this.status = status;
	}

	public Cor() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCor() {
		return idCor;
	}

	public void setIdCor(int idCor) {
		this.idCor = idCor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
