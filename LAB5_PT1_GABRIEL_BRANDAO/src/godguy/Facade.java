package godguy;

import controllers.ControllerClientes;
import controllers.ControllerFornecedores;
import controllers.ControllerProdutos;
import easyaccept.EasyAccept;

public class Facade {
	
	private ControllerClientes clientes;
	private ControllerFornecedores fornecedores;
	private ControllerProdutos produtos;
	
	public Facade() {
		this.clientes = new ControllerClientes();
		this.fornecedores = new ControllerFornecedores();
		this.produtos = new ControllerProdutos(fornecedores);
	}
	
	public static void main(String[] args) {
		args = new String[] {"godguy.Facade", "acceptance_test/use_case_1.txt"};
		EasyAccept.main(args);
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.clientes.cadastraCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return this.clientes.exibeCliente(cpf);
	}
	
	public String exibeTodosClientes() {
		return this.clientes.exibeTodos();
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.clientes.editaCliente(cpf, atributo, novoValor);
	}
	
	public String removeCliente(String cpf) {
		return this.clientes.removeCliente(cpf);
	}
	
	public String cadastraFornecedor(String nome, String email, String telefone) {
		return this.fornecedores.cadastraFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return this.fornecedores.exibeFornecedor(nome);
	}
	
	public String exibeTodosFornecedores() {
		return this.fornecedores.exibeTodosFornecedores();
	}
	
	public String alteraDadosEmailFornecedor(String nome, String email) {
		return this.fornecedores.alteraDadosEmailFornecedor(nome, email);
	}
	
	public String alteraDadosTelefoneFornecedor(String nome, String telefone) {
		return this.fornecedores.alteraDadosTelefoneFornecedor(nome, telefone);
	}
	
	public String removeFornecedor(String nome) {
		return this.fornecedores.removeFornecedor(nome);
	}
	
	public String cadastraProduto(String nomeFornecedor, String nomeProduto, String desc, double preco) {
		return this.produtos.cadastraProduto(nomeFornecedor, nomeProduto, desc, preco);
	}
	
	public String exibeProduto(String nomeFornecedor, String nomeProduto, String desc) {
		return this.produtos.exibeProduto(nomeFornecedor, nomeProduto, desc);
	}
	
	public String exibeProdutosUmFornecedor(String nomeFornecedor) {
		return this.produtos.exibeProdutosUmFornecedor(nomeFornecedor);
	}
	
	public String exibeProdutosFornecedores() {
		return this.produtos.exibeProdutosFornecedores();
	}
	
	public String alteraPrecoProduto(String nomeFornecedor, String nomeProduto, String desc, double preco) {
		return this.produtos.alteraPrecoProduto(nomeFornecedor, nomeProduto, desc, preco);
	}
	
	public String removeProduto(String nomeFornecedor, String nomeProduto, String desc) {
		return this.produtos.removeProduto(nomeFornecedor, nomeProduto, desc);
	}
	
}