package br.fiap.entidade;

import java.sql.Date;

public class Contato {
	private String nome;	
	private String email;
	private String endereco;
	private Date data;
	private String genero;
	
	public Contato(String nome, String email, String endereco, Date data, String genero) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.data = data;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}	
}
