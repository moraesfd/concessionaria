package br.pucpcaldas.concessionaria.dominio;

import java.text.SimpleDateFormat;

public class Cliente {
	
	private int idCliente;
	private String nome;
	private String endereco;
	private int numero;
	private String bairro;
	private String municipio;
	private String uf;
	private String cep;
	private String telefone;
	private SimpleDateFormat ultimaCompra;
	private int status;
	private String cpf;
	
	//CONSTRUTORES

	public Cliente(String nome, String endereco, int numero, String bairro,
			String municipio, String uf, String cep, String telefone, String cpf) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.municipio = municipio;
		this.uf = uf;
		this.cep = cep;
		this.telefone = telefone;
		this.cpf = cpf;
	}
	
	
	
	public Cliente(int idCliente, String nome, String municipio, String uf) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.municipio = municipio;
		this.uf = uf;
	}



	//GETTERS AND SETTERS

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public SimpleDateFormat getUltimaCompra() {
		return ultimaCompra;
	}

	public void setUltimaCompra(SimpleDateFormat ultimaCompra) {
		this.ultimaCompra = ultimaCompra;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
