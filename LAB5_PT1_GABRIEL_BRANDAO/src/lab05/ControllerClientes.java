package lab05;

import java.util.HashMap;

public class ControllerClientes {
	
	private HashMap<String,Cliente> clientes;

	public ControllerClientes() {
		this.clientes = new HashMap<>();
	}
	
	public String cadastraCliente(String cpf, String nome, String email, String localizacao)
	{
		if (!this.clientes.containsKey(cpf)) {
			Cliente c = new Cliente(cpf, nome, email, localizacao);
			clientes.put(c.getCpf(), c);
			return c.getCpf();
		}
		throw new IllegalArgumentException("Cpf ja cadastrado.");
	}
	
	public String exibeCliente(String cpf) {
		
	}
}
