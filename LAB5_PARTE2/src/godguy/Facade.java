package godguy;

import controllers.ControllerPrincipal;
import easyaccept.EasyAccept;


public class Facade {

	private ControllerPrincipal cp;
	
	public Facade() {
		this.cp = new ControllerPrincipal();
	}
	
	
	public static void main(String[] args) {
		args = new String[] {"godguy.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt", "acceptance_test/use_case_3.txt",
				"acceptance_test/use_case_4.txt", "acceptance_test/use_case_5.txt", "acceptance_test/use_case_6.txt", "acceptance_test/use_case_7.txt"};
		EasyAccept.main(args);
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.cp.cadastraCliente(cpf, nome, email, localizacao);
	}
	 
	public String exibeCliente(String cpf) {
		return this.cp.exibeCliente(cpf);
	}
	
	public String exibeClientes() {
		return this.cp.exibeTodos();
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.cp.editaCliente(cpf, atributo, novoValor);
	}
	
	public String removeCliente(String cpf) {
		return this.cp.removeCliente(cpf);
	}
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.cp.cadastraFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return this.cp.exibeFornecedor(nome);
	}
	
	public String exibeFornecedores() {
		return this.cp.exibeTodosFornecedores();
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.cp.editaFornecedor(nome, atributo, novoValor);
	}
	
	public String removeFornecedor(String nome) {
		return this.cp.removeFornecedor(nome);
	}
	
	public String adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		return this.cp.cadastraProduto(fornecedor, nome, descricao, preco);
	}
	
	public String exibeProduto(String nome,String descricao, String fornecedor) {
		return this.cp.exibeProduto(nome, descricao, fornecedor);
	}
	
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.cp.exibeProdutosUmFornecedor(fornecedor);
	}
	
	public String exibeProdutos() {
		return this.cp.exibeProdutosFornecedores();
	}
	
	public String editaProduto(String nome, String descricao,String fornecedor, double novoPreco) {
		return this.cp.alteraPrecoProduto(nome, descricao, fornecedor, novoPreco);
	}
	
	public String removeProduto(String nome, String descricao, String fornecedor) {
		return this.cp.removeProduto(nome, descricao, fornecedor);
	}
	
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		this.cp.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}
	
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		this.cp.editaCombo(nome, descricao, fornecedor, novoFator);
	}
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		this.cp.adicionaCompra(cpf, fornecedor, data, nome_prod, desc_prod);
	}
	
	public String getDebito(String cpf, String fornecedor) {
		return this.cp.getDebito(cpf, fornecedor);
	}
	
	public String exibeContas(String cpf, String fornecedor) {
		return this.cp.exibeContas(cpf, fornecedor);
	}
	
	public String exibeContasClientes(String cpf) {
		return cp.exibeContasClientes(cpf);
	}
	
	public void realizaPagamento(String cpf, String fornecedor) {
		cp.realizaPagamento(cpf, fornecedor);
	}
}