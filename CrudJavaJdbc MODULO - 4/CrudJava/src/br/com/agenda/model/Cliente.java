package br.com.agenda.model;

import java.util.Date;

public class Cliente {
	private String cpf;
	private String nome;
	private int idade;
	private Date dataCadastro;
	private String email;
	private String destino;
	private String localAtual;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getLocalAtual() {
		return localAtual;
	}

	public void setLocalAtual(String localAtual) {
		this.localAtual = localAtual;
	}

	public String getCpf() {
		return cpf;
	}

	public String setCpf(String cpf) {
		return this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String toString() {
		String msg = "Nome: " + nome + System.lineSeparator() + "Idade: " + idade + System.lineSeparator() + "CPF: "
				+ cpf + System.lineSeparator() + "Email: " + email + System.lineSeparator() + "Local Atual: "
				+ localAtual + System.lineSeparator() + "Destino: " + destino + System.lineSeparator();

		return msg;
	}
}
