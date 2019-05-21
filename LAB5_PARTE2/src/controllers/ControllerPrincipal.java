package controllers;

import entities.Excecoes;

public class ControllerPrincipal {

	private ControllerClientes cc;
	private ControllerFornecedores cf;
	private ControllerProdutos cp;
	private Excecoes valida;

	public ControllerPrincipal() {
		this.cc = new ControllerClientes();
		this.cf = new ControllerFornecedores();
		this.cp = new ControllerProdutos(cf.getfornecedores());
		this.valida = new Excecoes();
	}

	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		return cc.cadastraCliente(cpf, nome, email, localizacao);
	}

	public String exibeCliente(String cpf) {
		return cc.exibeCliente(cpf);
	}

	public String exibeTodos() {
		return cc.exibeTodos();
	}

	public void editaCliente(String cpf, String atributo, String novoValor) {
		cc.editaCliente(cpf, atributo, novoValor);
	}

	public void alteraDadosNome(String cpf, String nome) {
		cc.alteraDadosNome(cpf, nome);
	}

	public void alteraDadosEmail(String cpf, String email) {
		cc.alteraDadosEmail(cpf, email);
	}

	public void alteraDadosLocalizacao(String cpf, String localizacao) {
		cc.alteraDadosLocalizacao(cpf, localizacao);
	}

	public String removeCliente(String cpf) {
		return cc.removeCliente(cpf);
	}

	public String cadastraFornecedor(String nome, String email, String telefone) {
		return cf.cadastraFornecedor(nome, email, telefone);
	}

	public String exibeFornecedor(String nome) {
		return cf.exibeFornecedor(nome);
	}

	public String exibeTodosFornecedores() {
		return cf.exibeTodosFornecedores();
	}

	public void editaFornecedor(String nome, String atributo, String novoValor) {
		cf.editaFornecedor(nome, atributo, novoValor);
	}

	public void alteraDadosEmailFornecedor(String nome, String email) {
		cf.alteraDadosEmailFornecedor(nome, email);
	}

	public void alteraDadosTelefoneFornecedor(String nome, String telefone) {
		cf.alteraDadosTelefoneFornecedor(nome, telefone);
	}

	public String removeFornecedor(String nome) {
		return cf.removeFornecedor(nome);
	}

	public String cadastraProduto(String nomeFornecedor, String nomeProduto, String desc, double preco) {
		return cp.cadastraProduto(nomeFornecedor, nomeProduto, desc, preco);
	}

	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return cp.exibeProduto(nome, descricao, fornecedor);
	}

	public String exibeProdutosUmFornecedor(String nomeFornecedor) {
		return cp.exibeProdutosUmFornecedor(nomeFornecedor);
	}

	public String exibeProdutosFornecedores() {
		return cp.exibeProdutosFornecedores();
	}

	public String alteraPrecoProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		return cp.alteraPrecoProduto(nome, descricao, fornecedor, novoPreco);
	}

	public String removeProduto(String nome, String descricao, String fornecedor) {
		return cp.removeProduto(nome, descricao, fornecedor);
	}

	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		cp.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}

	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		cp.editaCombo(nome, descricao, fornecedor, novoFator);
	}

	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		valida.validaCpf(cpf, "Erro ao cadastrar compra: cpf invalido.");
		if (!this.cf.getfornecedores().containsKey(fornecedor))
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		if (!this.cc.getClientes().containsKey(cpf))
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");

		if (!this.cf.getfornecedores().get(fornecedor).getContaCliente().containsKey(cpf))
			this.cf.getfornecedores().get(fornecedor).criaConta(cpf);
		this.cf.getfornecedores().get(fornecedor).insereProdutoNaConta(cpf, data, nome_prod, desc_prod);

	}
}
