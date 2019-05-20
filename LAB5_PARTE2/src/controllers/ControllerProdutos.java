package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

import entities.Excecoes;
import entities.Fornecedor;

/**
 * Representacao de um controlador de produtos. Vale ressaltar que a classe nao
 * eh responsavel por cadastrar, inserir ou remover um produto. TODAS essas
 * funcionalidades sao da classe Fornecedor. A classe ControllerProduto apenas
 * auxilia na chamada das funcionalidades da classe Fornecedor.
 */

public class ControllerProdutos {

	/**
	 * Constroi um controlador de fornecedor
	 */
	private LinkedHashMap<String, Fornecedor> fornecedores;

	/**
	 * Representacao de um mapa para clientes. A chave eh o cpf do cliente e o valor
	 * eh o objeto Cliente.
	 */
	private Excecoes valida;

	/**
	 * Constroi um controlador de produtos
	 * 
	 * @param f recebe o controllador de fornecedores como parametro
	 */
	public ControllerProdutos(LinkedHashMap<String, Fornecedor> f) {
		this.fornecedores = f;
		this.valida = new Excecoes();
	}

	/**
	 * O metodo cadastra um produto para um fornecedor
	 * 
	 * @param nomeFornecedor recebe o nome de um fornecedo
	 * @param nomeProduto    recebe o nome do produto que deseja cadastrar
	 * @param desc           recebe a descricao do produto que deseja cadastrar
	 * @param preco          recebe o preco do produto
	 * @return Caso a operacao seja bem sucedida a mensagem 'Produto cadastrado com
	 *         sucesso' eh retornada
	 * @throws IllegalArgumentException Caso o nome do fornecedor, seja nulo ou uma
	 *                                  string vazia a excecao eh lancada. Se o
	 *                                  fornecedor nao existir tambem eh lancada. Se
	 *                                  o produto que se deseja cadastrar ja exista,
	 *                                  a excecao eh lancada.
	 */
	public String cadastraProduto(String nomeFornecedor, String nomeProduto, String desc, double preco) {
		if (nomeFornecedor == null || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		valida.validaCadastroProduto(nomeProduto, desc, preco);
		if (!this.fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		if (this.fornecedores.get(nomeFornecedor).verificaIgual(nomeProduto, desc)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		this.fornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, desc, preco);
		return "Produto cadastrado com sucesso";
	}

	/**
	 * O metodo exibe o produto de um fornecedor cadastrado no sistema
	 * 
	 * @param nome       recebe o nome do produto
	 * @param descricao  recebe a descricao do produto
	 * @param fornecedor recebe o nome do fornecedor que contem o produto
	 * @return Em uma operacao bem sucedida eh retornada em formato String 'NNNN -
	 *         DDDD - R$PP.PP', onde 'N' representa o nome do produto, 'D'
	 *         representa a descricao do produto e 'P' representa o preco do produto
	 * @throws IllegalArgumentException Caso o fornecedor passado como parametro nao
	 *                                  exista a excecao eh lancada. Caso o produto
	 *                                  nao exista, a excecao eh lancada.
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		valida.validaExibeProduto(nome, descricao, fornecedor);
		if (!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		if (!this.fornecedores.get(fornecedor).verificaIgual(nome, descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}

		return this.fornecedores.get(fornecedor).exibeUmProduto(nome, descricao);
	}

	/**
	 * O metodo exibe todos os produtos de um fornecedor cadastrado
	 * 
	 * @param nomeFornecedor recebe o nome do fornecedor
	 * @return Em uma operacao bem sucedida eh retornado no formato String o
	 *         fornecedor e seus produtos, no formato: 'FFFF - NNNN - DDDD - R$PP.PP
	 *         | . Onde 'F' representa o nome do fornecedor, 'N' o nome do produto,
	 *         'D' a descricao do produto, 'P' o preco do produto.
	 */
	public String exibeProdutosUmFornecedor(String nomeFornecedor) {
		if (nomeFornecedor == null || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (!this.fornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		String produtos = "";
		if (this.fornecedores.containsKey(nomeFornecedor)) {
			produtos = this.fornecedores.get(nomeFornecedor).exibeTodosProdutosUmFornecedor();
		}
		return produtos;
	}

	/**
	 * O metodo exibe todos os fornecedores e seus produtos cadastrados no sistema.
	 * 
	 * @return todos os fornecedores e seus produtos no formato String: 'FFFF - NNNN
	 *         - DDDD - R$PP.PP | . Onde 'F' representa o nome do fornecedor, 'N' o
	 *         nome do produto, 'D' a descricao do produto, 'P' o preco do produto.
	 */
	public String exibeProdutosFornecedores() {
		ArrayList<String> produtos = new ArrayList<>();
		for (String p : this.fornecedores.keySet()) {
			produtos.add(this.fornecedores.get(p).exibeTodosProdutosUmFornecedor());
		}
		Collections.sort(produtos);
		return String.join(" | ", produtos);
	}

	/**
	 * O metodo altera o preco de um produto em especifico
	 * 
	 * @param nome       recebe o nome do produto que deseja-se mudar o preco
	 * @param descricao  recebe a descricao do produto
	 * @param fornecedor recebe o nome do fornecedor que possui o produto
	 * @param novoPreco  recebeo o novo preco do produto
	 * @return Em uma operacao bem sucedida a mensagem 'Preco alterado com sucesso'
	 *         eh retornada. Caso o produto nao esteja cadastrado no sistema eh
	 *         retornado 'Produto nao cadastro'
	 * @throws IllegalArgumentException Se o fornecedor nao existir a excecao eh
	 *                                  lancada.
	 */
	public String alteraPrecoProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		valida.validaEditaProduto(nome, descricao, fornecedor, novoPreco);
		if (!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		if (!this.fornecedores.get(fornecedor).verificaIgual(nome, descricao)) {
			return "Produto nao cadastrado";
		}
		this.fornecedores.get(fornecedor).alteraPreco(nome, descricao, novoPreco);
		return "Preco alterado com sucesso";
	}

	/**
	 * O metodo remove o produto de um fornecedor do sistema.
	 * 
	 * @param nome       recebe o nome do produto que deseja-se remover
	 * @param descricao  recebe a descricao do produto
	 * @param fornecedor recebe o nome do fornecedor
	 * @return Em uma operacao bem sucedida eh retornado a mensagem 'Produto
	 *         removido com sucesso'
	 * @throws IllegalArgumentException Caso o fornecedor nao exista ou o produto
	 *                                  nao esteja cadastrado para remocao, entao a
	 *                                  excecao eh lancada
	 */
	public String removeProduto(String nome, String descricao, String fornecedor) {
		valida.validaRemoveProduto(nome, descricao, fornecedor);
		if (!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		if (!this.fornecedores.get(fornecedor).verificaIgual(nome, descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		this.fornecedores.get(fornecedor).removeProduto(nome, descricao);
		return "Produto removido com sucesso";
	}
	
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		valida.validaCadastroCombo(fornecedor, nome, descricao, fator, produtos);
		String[] arrayprodutos = produtos.split(", ");
		Fornecedor f = fornecedores.get(fornecedor);
		double valorDosProdutos = 0.0;

		if(!(this.fornecedores.containsKey(fornecedor))) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}
		if (this.fornecedores.get(fornecedor).verificaIgual(nome, descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		}
		
		for(int i = 0; i < arrayprodutos.length; i++) {
			arrayprodutos[i] = arrayprodutos[i].replace(" - ", " ");
			if(!(f.getProdutos().containsKey(arrayprodutos[i]))) {
				throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
			}
			if(this.fornecedores.get(fornecedor).verificaComboExiste(arrayprodutos[i])) {
				throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
			}
			valorDosProdutos += f.getProdutos().get(arrayprodutos[i]).getPreco();
		}
		
		
		fornecedores.get(fornecedor).cadastraCombo(nome, descricao, fator, valorDosProdutos, arrayprodutos);
	}
	
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		valida.validaEditaCombo(nome, descricao, fornecedor, novoFator);
		if(!(this.fornecedores.containsKey(fornecedor))) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		}
		if(!this.fornecedores.get(fornecedor).verificaIgual(nome, descricao)) {
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}
		fornecedores.get(fornecedor).editaCombo(nome, descricao, novoFator);
	}
		
}