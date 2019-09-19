package br.fiap.modelo;

public class Paciente {
	private String cpf;
	private String nome;
	private String fone;
	
	public Paciente(String cpf, String nome, String fone) {
		this.cpf = cpf;
		this.nome = nome;
		this.fone = fone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
	
	
}
