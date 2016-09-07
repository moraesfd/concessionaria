package br.pucpcaldas.concessionaria.dominio;

import java.text.SimpleDateFormat;

public class Fornecedor {
	
	private int idFornecedor;
	private String razaoSocial;
	private String municipio;
	private String uf;
	private String pais;
	private SimpleDateFormat ultimaCompra;
	private int status;
	
	public Fornecedor(int idFornecedor, String razaoSocial, String municipio,
			String uf, String pais, SimpleDateFormat ultimaCompra, int status) {
		super();
		this.idFornecedor = idFornecedor;
		this.razaoSocial = razaoSocial;
		this.municipio = municipio;
		this.uf = uf;
		this.pais = pais;
		this.ultimaCompra = ultimaCompra;
		this.status = status;
	}
	
}
