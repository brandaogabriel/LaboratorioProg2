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
		if(!this.clientes.containsKey(cpf)) {
			try {
				clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
				return cpf;			
			}catch (Exception e) {
				return e.getMessage();
			}
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
	
	public boolean alteraDadosNome(String cpf, String nome) {
		valida.validaEntrada(cpf);
		valida.validaEntrada(nome);
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setNome(nome);
			return true;
		}return false;
	}
	
	public boolean alteraDadosEmail(String cpf, String email) {
		valida.validaEntrada(cpf);
		valida.validaEntrada(email);
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setEmail(email);;
			return true;
		}return false;
	}
	
	public boolean alteraDadosTelefone(String cpf, String localizacao) {
		valida.validaEntrada(cpf);	
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setLocalizacao(localizacao);
			return true;
		}return false;
	}
	
	public boolean removeCliente(String cpf) {
		valida.validaEntrada(cpf);
		if (this.clientes.containsKey(cpf)) {
			this.clientes.remove(cpf);
			return true;
		}return false;
	}
	
}
