package lab05;

import java.util.HashMap;

public class ControllerFornecedores {

	private Excecoes valida;
	private HashMap<String, Fornecedor> fornecedores;

	public ControllerFornecedores() {
		this.fornecedores = new HashMap<>();
		this.valida = new Excecoes();
	}
	
	public boolean cadastraFornecedor(String nome, String email, String telefone) {		
		boolean result = false;
		if (!this.fornecedores.containsKey(nome)) {
			this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
			result = true;
		}
		return result;
	}
	
	public String exibeFornecedor(String nome) {
		valida.validaEntrada(nome);
		if (this.fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString();
		}
		return "Fornecedor nao cadastrado!";
	}
	
	public String exibeTodosFornecedores() {
		String fornecedores = "";
		for (String f : this.fornecedores.keySet()) {
			fornecedores += this.fornecedores.get(f).toString() + " | ";
		}	
		return fornecedores;
	}
	
	public boolean alteraDadosFornecedor(String nome, String email, String telefone) {
		valida.validaEntrada(nome);
		boolean result = false;	
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).setEmail(email);
			this.fornecedores.get(nome).setTelefone(telefone);
			result = true;
		}	
		return result;
	}
	
	public boolean removeFornecedor(String nome) {
		valida.validaEntrada(nome);
		boolean result = false;
		
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.remove(nome);
			result = true;
		}
		return result;
	}
	
	public boolean cadastraProduto(String nomeFornecedor, String nomeProduto, String desc, double preco) {
		valida.validaEntrada(nomeFornecedor);
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		boolean result = false;
		if (this.fornecedores.containsKey(nomeFornecedor)) {
			if(!this.fornecedores.get(nomeFornecedor).verificaIgual(nomeProduto, desc)) {
				fornecedores.get(nomeFornecedor).insereProduto(new Produtos(nomeProduto, desc, preco));
				result = true;
			}
		}
		return result;
	}
	
	public String exibeProduto(String nomeFornecedor, String nomeProduto, String desc) {
		valida.validaEntrada(nomeFornecedor);
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		
		if (this.fornecedores.containsKey(nomeFornecedor)) {
			if (this.fornecedores.get(nomeFornecedor).verificaIgual(nomeProduto, desc)) {
				return this.fornecedores.get(nomeFornecedor).exibeProduto(nomeProduto, desc);
			}return "Produto nao cadastrado";
		}return "Fornecedor nao cadastrado";
	}
	
	public String exibeProdutosUmFornecedor(String nomeFornecedor) {
		valida.validaEntrada(nomeFornecedor);
		String produtos = "";
		if(this.fornecedores.containsKey(nomeFornecedor)) {
			for (String p: this.fornecedores.keySet()) {
				if (p.equals(nomeFornecedor)) {
					produtos += nomeFornecedor + " - " + this.fornecedores.get(p).exibeProdutos() + " | ";
				}
			}
		}
		return produtos;
	}
	
	
	public String exibeProdutosFornecedores() {
		String produtos = "";
	
		for (String p : this.fornecedores.keySet()) {
			produtos += p + " - " + this.fornecedores.get(p).exibeProdutos() + " | ";
		}
		
		return produtos;
	}
	
	
	public String editaProduto(String nomeFornecedor, String nomeProduto, String desc, double preco) {
		valida.validaEntrada(nomeFornecedor);
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		
		if (this.fornecedores.containsKey(nomeFornecedor)) {
			if (this.fornecedores.get(nomeFornecedor).verificaIgual(nomeProduto, desc)) {
				this.fornecedores.get(nomeFornecedor).alteraPreco(nomeProduto, desc, preco);
				return "Preco alterado com sucesso";
			}return "Produto nao cadastrado";
		}return "Fornecedor nao cadastrado";
	}
	
	public String removeProduto(String nomeFornecedor, String nomeProduto, String desc) {
		valida.validaEntrada(nomeFornecedor);
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		
		if (this.fornecedores.containsKey(nomeFornecedor)) {
			if (this.fornecedores.get(nomeFornecedor).verificaIgual(nomeProduto, desc)) {
				this.fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, desc);
				return "Produto removido do fornecedor";
			}return "Produto nao cadastrado";
		}return "Fornecedor nao cadastrado";
	}
			
}
