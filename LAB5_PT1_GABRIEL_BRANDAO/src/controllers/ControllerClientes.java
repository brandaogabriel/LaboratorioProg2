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
		valida.validaCadastroCliente(cpf, nome, email, localizacao);
		if(!this.clientes.containsKey(cpf)) {
			clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
			return cpf;			
			}
		throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
	}
	 
	public String exibeCliente(String cpf) {
		valida.validaEntrada(cpf);
		if (clientes.containsKey(cpf)) {
			return clientes.get(cpf).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
	}
	
	public String exibeTodos() {
		String clientes = "";		
		for (String c : this.clientes.keySet()) {
			clientes += this.clientes.get(c).toString() + " | ";
		}
		return clientes;
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
		valida.validaEditaCliente(atributo, novoValor);
		if (atributo.equals("nome")) {
			alteraDadosNome(cpf, novoValor);
		}
		if (atributo.equals("email")) {
			alteraDadosEmail(cpf, novoValor);
		}
		if(atributo.equals("localizacao")) {
			alteraDadosLocalizacao(cpf, novoValor);
		}
	}
	
	public void alteraDadosNome(String cpf, String nome) {
		valida.validaEntrada(cpf);
		valida.validaEntrada(nome);
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setNome(nome);
		}
	}
	
	public void alteraDadosEmail(String cpf, String email) {
		valida.validaEntrada(cpf);
		valida.validaEntrada(email);
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setEmail(email);;
			
		}
	}
	
	public void alteraDadosLocalizacao(String cpf, String localizacao) {
		valida.validaEntrada(cpf);	
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setLocalizacao(localizacao);
		}
	}
	
	public String removeCliente(String cpf) {
		valida.validaEntrada(cpf);
		if (this.clientes.containsKey(cpf)) {
			this.clientes.remove(cpf);
			return "Cliente removido";
		}return "Cliente nao cadastrado";
	}
	
}
