package controllers;

import java.util.LinkedHashMap;

import lab05.Excecoes;
import lab05.Fornecedor;

public class ControllerFornecedores {

	private Excecoes valida;
	private LinkedHashMap<String, Fornecedor> fornecedores;

	public ControllerFornecedores() {
		this.fornecedores = new LinkedHashMap<>();
		this.valida = new Excecoes();
	}
	
	public String cadastraFornecedor(String nome, String email, String telefone) {		
		valida.validaCadastoFornecedor(nome, email, telefone);
		if (!this.fornecedores.containsKey(nome)) {
			this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
			return nome;
		}
		throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
	}
	
	public String exibeFornecedor(String nome) {
		if (this.fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
	}
	
	public String exibeTodosFornecedores() {
		String fornecedores = "";
		for (String f : this.fornecedores.keySet()) {
			fornecedores += this.fornecedores.get(f).toString() + " | ";
		}return fornecedores;
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		if(atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		valida.validaEditaFornecedor(atributo, novoValor);
		if(atributo.equals("email")) {
			alteraDadosEmailFornecedor(nome,novoValor);
		}
		if(atributo.equals("telefone")) {
			alteraDadosTelefoneFornecedor(nome, novoValor);
		}
	}
	
	public String alteraDadosEmailFornecedor(String nome, String email) {
		if(this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).setEmail(email);
			return "Email alterado com sucesso";
		}return "Fornecedor nao cadastrado";	
	}
	
	public String alteraDadosTelefoneFornecedor(String nome, String telefone) {
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).setTelefone(telefone);
			return "Telefone alterado com sucesso";
		}return "Fornecedor nao cadastrado";
	}
	
	public void removeFornecedor(String nome) {
		if(nome.equals("")) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.remove(nome);
		}
	}
	
	public LinkedHashMap<String, Fornecedor> getfornecedores() {
		return this.fornecedores;
	}
	
}