package lab05;

import java.util.HashMap;

public class ControllerFornecedores {

	private Excecoes valida;
	private HashMap<String, Fornecedor> fornecedores;

	public ControllerFornecedores(HashMap<String, Fornecedor> fornecedores) {
		this.fornecedores = new HashMap<>();
	}
	
	public boolean cadastraFornecedor(String nome, String email, String telefone) {
		boolean result = false;
		
		valida.validaEntrada(nome);
		valida.validaEntrada(email);
		valida.validaEntrada(telefone);	
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
		valida.validaEntrada(email);
		valida.validaEntrada(telefone);
		boolean result = false;
		
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
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
	
		
}
