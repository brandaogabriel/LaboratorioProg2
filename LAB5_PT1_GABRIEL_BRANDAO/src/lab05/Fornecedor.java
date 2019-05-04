package lab05;

import java.util.ArrayList;

public class Fornecedor {
	
	private String nome;
	private String email;
	private String telefone;
	private ArrayList<Produtos> produtos;
	private Excecoes valida;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.valida = new Excecoes();
		valida.validaEntrada(nome);
		valida.validaEntrada(email);
		valida.validaEntrada(telefone);	
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new ArrayList<>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setEmail(String email) {
		valida.validaEntrada(email);
		this.email = email;
	}
	
	public void setTelefone(String telefone) {
		valida.validaEntrada(telefone);
		this.telefone = telefone;
	}
	
	public void insereProduto(Produtos p) {
		produtos.add(p);
	}
	
	public boolean verificaIgual(String nomeProduto, String desc) {
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		for (Produtos p : produtos) {
			if (p.equals(new Produtos(nomeProduto, desc))) {
				return true;
			}
		}
		return false;
	}
	
	public String exibeUmProduto(String nomeProduto, String desc) {
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		for (Produtos p: produtos) {
			if (p.equals(new Produtos(nomeProduto, desc))) {
				return p.toString();
			}
		}return "Produto nao cadastrado";
	}
	
	public String exibeTodosProdutosUmFornecedor(String nomeFornecedor) {
		valida.validaEntrada(nomeFornecedor);
		String itens = "";
		for (Produtos p : this.produtos) {
			itens += nomeFornecedor + " - " +  p.toString() + " | ";
		}
		return itens;
	}
	
	public void alteraPreco(String nomeProduto, String desc, double preco) {
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		for (Produtos p : produtos) {
			if (p.equals(new Produtos(nomeProduto, desc))) {
				p.setPreco(preco);
			}
		}
	}
	
	public boolean removeProduto(String nomeProduto, String desc) {
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		Produtos p = new Produtos(nomeProduto, desc);
		for (Produtos pp : produtos) {
			if (pp.equals(p)) {
				produtos.remove(p);
				return true;
			}
		}return false;
	}
	
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
