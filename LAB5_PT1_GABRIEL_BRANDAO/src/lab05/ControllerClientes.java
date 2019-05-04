package lab05;

import java.util.HashMap;

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
	
	public boolean alteraDados(String cpf, String nome, String email, String localizacao) {
		valida.validaEntrada(cpf);	
		boolean result = false;
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setNome(nome);
			this.clientes.get(cpf).setEmail(email);
			this.clientes.get(cpf).setLocalizacao(localizacao);
			result = true;
		}
		return result;
	}
	
	public boolean removeCliente(String cpf) {
		valida.validaEntrada(cpf);
		boolean result = false;
		if (this.clientes.containsKey(cpf)) {
			this.clientes.remove(cpf);
			result = true;
		}						
		return result; 
	}
	
}
