package controllers;

import lab05.Excecoes;

public class ControllerProdutos {
	
	private ControllerFornecedores fornecedores;
	private Excecoes valida;
	
	public ControllerProdutos(ControllerFornecedores f) {
		this.fornecedores = f;
		this.valida = new Excecoes();
	}
	
	public String cadastraProduto(String nomeFornecedor, String nomeProduto, String desc, double preco) {
		if(nomeFornecedor == null || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}	
		valida.validaCadastroProduto(nomeProduto, desc, preco);
		if(!this.fornecedores.getfornecedores().containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		if(this.fornecedores.getfornecedores().get(nomeFornecedor).verificaIgual(nomeProduto, desc)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		this.fornecedores.getfornecedores().get(nomeFornecedor).cadastraProduto(nomeProduto, desc, preco);
		return "Produto cadastrado com sucesso";
	}
	
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		valida.validaExibeProduto(nome, descricao, fornecedor);
		if (!this.fornecedores.getfornecedores().containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		if(!this.fornecedores.getfornecedores().get(fornecedor).verificaIgual(nome, descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		
		return this.fornecedores.getfornecedores().get(fornecedor).exibeUmProduto(nome, descricao);
	}
	
	public String exibeProdutosUmFornecedor(String nomeFornecedor) {
		String produtos = "";
		if(this.fornecedores.getfornecedores().containsKey(nomeFornecedor)) {
			produtos = this.fornecedores.getfornecedores().get(nomeFornecedor).exibeTodosProdutosUmFornecedor(nomeFornecedor);
		}return produtos;
	}
		
	public String exibeProdutosFornecedores() {
		String produtos = "";
		for (String p : this.fornecedores.getfornecedores().keySet()) {
			produtos += this.fornecedores.getfornecedores().get(p).exibeTodosProdutosUmFornecedor(p);
		}	
		return produtos;
	}
	
	public String alteraPrecoProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		valida.validaEditaProduto(nome, descricao, fornecedor, novoPreco);
		if (!this.fornecedores.getfornecedores().containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		if (!this.fornecedores.getfornecedores().get(fornecedor).verificaIgual(nome, descricao)) {
			return "Produto nao cadastrado";
		}
		this.fornecedores.getfornecedores().get(fornecedor).alteraPreco(nome, descricao, novoPreco);
		return "Preco alterado com sucesso";
	}
	
	public String removeProduto(String nome, String descricao, String fornecedor) {	
		valida.validaRemoveProduto(nome, descricao, fornecedor);
		if(!this.fornecedores.getfornecedores().containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		if(!this.fornecedores.getfornecedores().get(fornecedor).verificaIgual(nome, descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		this.fornecedores.getfornecedores().get(fornecedor).removeProduto(nome, descricao);
		return "Produto removido com sucesso";
	}
	
}