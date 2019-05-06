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
		if (!this.fornecedores.containsKey(nome)) {
			this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
			return "Fornecedor cadastrado com sucesso";
		}
		return "Fornecedor ja cadastrado";
	}
	
	public String exibeFornecedor(String nome) {
		valida.validaEntrada(nome);
		if (this.fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString();
		}
		return "Fornecedor nao cadastrado!";
	}
	
	public String exibeTodosFornecedores() {
		String fornecedores = "";
		for (String f : this.fornecedores.keySet()) {
			fornecedores += this.fornecedores.get(f).toString() + " | ";
		}return fornecedores;
	}
	
	public String alteraDadosEmailFornecedor(String nome, String email) {
		valida.validaEntrada(nome);
		valida.validaEntrada(email);
		if(this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).setEmail(email);
			return "Email alterado com sucesso";
		}return "Fornecedor nao cadastrado";	
	}
	
	public String alteraDadosTelefoneFornecedor(String nome, String telefone) {
		valida.validaEntrada(nome);
		valida.validaEntrada(telefone);
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).setTelefone(telefone);
			return "Telefone alterado com sucesso";
		}return "Fornecedor nao cadastrado";
	}
	
	public String removeFornecedor(String nome) {
		valida.validaEntrada(nome);	
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.remove(nome);
			return "Fornecedor removido com sucesso";
		}return "Fornecedor nao cadastrado";
	}
	
	public LinkedHashMap<String, Fornecedor> getfornecedores() {
		return this.fornecedores;
	}
	
}
