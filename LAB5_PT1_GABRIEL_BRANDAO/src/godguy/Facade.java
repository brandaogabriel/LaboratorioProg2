package godguy;

import controllers.ControllerClientes;
import controllers.ControllerFornecedores;
import controllers.ControllerProdutos;

public class Facade {
	
	private ControllerClientes clientes;
	private ControllerFornecedores fornecedores;
	private ControllerProdutos produtos;
	
	public Facade() {
		this.clientes = new ControllerClientes();
		this.fornecedores = new ControllerFornecedores();
		this.produtos = new ControllerProdutos(fornecedores);
	}
	
	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		return this.clientes.cadastraCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return this.clientes.exibeCliente(cpf);
	}
	
	public String exibeTodosClientes() {
		return this.clientes.exibeTodos();
	}
	
	public String alteraNomeCliente(String cpf, String nome) {
		return this.clientes.alteraDadosNome(cpf, nome);
	}
	
	public String alteraEmailCliente(String cpf, String email) {
		return this.clientes.alteraDadosEmail(cpf, email);
	}
	
	public String alteraTelefoneCliente(String cpf, String localizacao) {
		return this.clientes.alteraDadosLocalizacao(cpf, localizacao);
	}
	
	public String removeCliente(String cpf) {
		return this.clientes.removeCliente(cpf);
	}
	
	
	
}
