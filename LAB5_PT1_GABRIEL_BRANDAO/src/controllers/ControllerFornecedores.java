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
	
	public boolean cadastraFornecedor(String nome, String email, String telefone) {		
		boolean result = false;
		if (!this.fornecedores.containsKey(nome)) {
			this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
			result = true;
		}
		return result;
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
	
	public boolean alteraDadosEmailFornecedor(String nome, String email) {
		valida.validaEntrada(nome);
		valida.validaEntrada(email);
		if(this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).setEmail(email);
			return true;
		}return false;	
	}
	
	public boolean alteraDadosTelefoneFornecedor(String nome, String telefone) {
		valida.validaEntrada(nome);
		valida.validaEntrada(telefone);
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).setTelefone(telefone);
			return true;
		}return false;
	}
	
	public boolean removeFornecedor(String nome) {
		valida.validaEntrada(nome);	
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.remove(nome);
			return true;
		}return false;
	}
	
	public LinkedHashMap<String, Fornecedor> getfornecedores() {
		return this.fornecedores;
	}
	
}
