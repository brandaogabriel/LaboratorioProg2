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
		this.produtos = new ControllerProdutos(fornecedores.getfornecedores());
	}
	

	public static void main(String[] args) {
		args = new String[] {"godguy.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt", "acceptance_test/use_case_3.txt",
				"acceptance_test/use_case_4.txt", "acceptance_test/use_case_5.txt"};
		EasyAccept.main(args);
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.clientes.cadastraCliente(cpf, nome, email, localizacao);
	}
	 
	public String exibeCliente(String cpf) {
		return this.clientes.exibeCliente(cpf);
	}
	
	public String exibeClientes() {
		return this.clientes.exibeTodos();
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.clientes.editaCliente(cpf, atributo, novoValor);
	}
	
	public String removeCliente(String cpf) {
		return this.clientes.removeCliente(cpf);
	}
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.fornecedores.cadastraFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return this.fornecedores.exibeFornecedor(nome);
	}
	
	public String exibeFornecedores() {
		return this.fornecedores.exibeTodosFornecedores();
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.fornecedores.editaFornecedor(nome, atributo, novoValor);
	}
	
	public String removeFornecedor(String nome) {
		return this.fornecedores.removeFornecedor(nome);
	}
	
	public String adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		return this.produtos.cadastraProduto(fornecedor, nome, descricao, preco);
	}
	
	public String exibeProduto(String nome,String descricao, String fornecedor) {
		return this.produtos.exibeProduto(nome, descricao, fornecedor);
	}
	
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.produtos.exibeProdutosUmFornecedor(fornecedor);
	}
	
	public String exibeProdutos() {
		return this.produtos.exibeProdutosFornecedores();
	}
	
	public String editaProduto(String nome, String descricao,String fornecedor, double novoPreco) {
		return this.produtos.alteraPrecoProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	public String removeProduto(String nome, String descricao, String fornecedor) {
		return this.produtos.removeProduto(nome, descricao, fornecedor);
	}
	
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		this.produtos.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}
	
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		this.produtos.editaCombo(nome, descricao, fornecedor, novoFator);
	}
}