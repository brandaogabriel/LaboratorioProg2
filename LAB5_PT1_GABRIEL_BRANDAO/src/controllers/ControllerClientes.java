package controllers;

import java.util.HashMap;

import lab05.Cliente;
import lab05.Excecoes;

public class ControllerClientes {
	
	private Excecoes valida;
	private HashMap<String , Cliente> clientes;

	public ControllerClientes() {
		this.clientes = new HashMap<>();
		this.valida = new Excecoes();
	}
	
	public String cadastraCliente(String cpf, String nome, String email, String localizacao){
		valida.validaEntrada(cpf);
		valida.validaEntrada(nome);
		valida.validaEntrada(email);
		valida.validaEntrada(localizacao);
		if(!this.clientes.containsKey(cpf)) {
			clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
			return cpf;			
			}
		return "Cpf ja cadastrado!";
	}
	 
	public String exibeCliente(String cpf) {
		valida.validaEntrada(cpf);
		if (clientes.containsKey(cpf)) {
			return clientes.get(cpf).toString();
		}
		return "Cliente nao cadastrado";
	}
	
	public String exibeTodos() {
		String clientes = "";		
		for (String c : this.clientes.keySet()) {
			clientes += this.clientes.get(c).toString() + " | ";
		}
		return clientes;
	}
	
	public String alteraDadosNome(String cpf, String nome) {
		valida.validaEntrada(cpf);
		valida.validaEntrada(nome);
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setNome(nome);
			return "Nome alterado com sucesso";
		}return "Cpf nao cadastrado";
	}
	
	public String alteraDadosEmail(String cpf, String email) {
		valida.validaEntrada(cpf);
		valida.validaEntrada(email);
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setEmail(email);;
			return "Email alterado com sucesso";
		}return "Cpf nao cadastrado";
	}
	
	public String alteraDadosLocalizacao(String cpf, String localizacao) {
		valida.validaEntrada(cpf);	
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setLocalizacao(localizacao);
			return "Localizacao alterada com sucesso";
		}return "Cpf nao cadastrado";
	}
	
	public String removeCliente(String cpf) {
		valida.validaEntrada(cpf);
		if (this.clientes.containsKey(cpf)) {
			this.clientes.remove(cpf);
			return "Cliente removido";
		}return "Cliente nao cadastrado";
	}
	
}
