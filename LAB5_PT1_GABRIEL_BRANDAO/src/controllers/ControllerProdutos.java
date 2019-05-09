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
		valida.validaEntrada(nomeFornecedor);
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		if (this.fornecedores.getfornecedores().containsKey(nomeFornecedor)) {
			if(!this.fornecedores.getfornecedores().get(nomeFornecedor).verificaIgual(nomeProduto, desc)) {
				this.fornecedores.getfornecedores().get(nomeFornecedor).insereProduto(nomeProduto, desc, preco);
				return "Produto cadastrado com sucesso";
			}return "O produto ja existe para o fornecedor solicitado";
		}return "Fornecedor nao cadastrado";
	}
	
	public String exibeProduto(String nomeFornecedor, String nomeProduto, String desc) {
		valida.validaEntrada(nomeFornecedor);
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		if (this.fornecedores.getfornecedores().containsKey(nomeFornecedor)) {
			if (this.fornecedores.getfornecedores().get(nomeFornecedor).verificaIgual(nomeProduto, desc)) {
				return this.fornecedores.getfornecedores().get(nomeFornecedor).exibeUmProduto(nomeProduto, desc);
			}return "Produto nao cadastrado";
		}return "Fornecedor nao cadastrado";
	}
	
	public String exibeProdutosUmFornecedor(String nomeFornecedor) {
		valida.validaEntrada(nomeFornecedor);
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
	
	public String alteraPrecoProduto(String nomeFornecedor, String nomeProduto, String desc, double preco) {
		valida.validaEntrada(nomeFornecedor);
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		
		if (this.fornecedores.getfornecedores().containsKey(nomeFornecedor)) {
			if (this.fornecedores.getfornecedores().get(nomeFornecedor).verificaIgual(nomeProduto, desc)) {
				this.fornecedores.getfornecedores().get(nomeFornecedor).alteraPreco(nomeProduto, desc, preco);
				return "Preco alterado com sucesso";
			}return "Produto nao cadastrado";
		}return "Fornecedor nao cadastrado";
	}
	
	public String removeProduto(String nomeFornecedor, String nomeProduto, String desc) {
		valida.validaEntrada(nomeFornecedor);
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		
		if (this.fornecedores.getfornecedores().containsKey(nomeFornecedor)) {
			if (this.fornecedores.getfornecedores().get(nomeFornecedor).verificaIgual(nomeProduto, desc)) {
				this.fornecedores.getfornecedores().get(nomeFornecedor).removeProduto(nomeProduto, desc);
				return "Produto removido do fornecedor";
			}return "Produto nao cadastrado";
		}return "Fornecedor nao cadastrado";
	}
	
}