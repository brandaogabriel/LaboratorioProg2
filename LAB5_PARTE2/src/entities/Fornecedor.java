package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Representacao de um fornecedor de um determinado estabelicimento que eh
 * resposavel por armazenar e manipular os produtos que a ele pertencem. Este
 * por sua vez possui um nome (identificador), email, telefone e uma lista de
 * produtos do tipo produto.
 */

public class Fornecedor implements Comparable<Fornecedor> {

	/**
	 * Representacao do nome de um fornecedor
	 */
	private String nome;

	/**
	 * Representacao do email de um fornecedor
	 */
	private String email;

	/**
	 * Representacao do telefone de um fornecedor
	 */
	private String telefone;

	/**
	 * Representacao dos produtos de um fornecedor atraves de um mapa. A chave eh o
	 * nome do produto e a descricao, o valor eh o Produto.
	 */
	private LinkedHashMap<String, Produtos> produtos;

	/**
	 * Representacao da conta de um cliente atraves de um mapa. A chave eh o cpf do
	 * cliente e o valor eh o tipo Conta
	 */
	private Map<String, Conta> contasClientes;

	/**
	 * Representa um conjunto de metodos do tipo Excecoes para realizar validacao de
	 * dados de entrada
	 */
	private Excecoes valida;

	/**
	 * Constroi um fornecedor a partir do nome, email e telefone
	 * 
	 * @param nome     recebe o nome do fornecedor
	 * @param email    recebe o email do fornecedor
	 * @param telefone recebe o telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.valida = new Excecoes();
		this.valida.validaCadastoFornecedor(nome, email, telefone);
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new LinkedHashMap<>();
		this.contasClientes = new LinkedHashMap<>();
	}

	/**
	 * O metodo retorna o nome de um fornecedor
	 * 
	 * @return nome do fornecedor
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * O metodo retorna o mapa das contas dos clientes de um fornecedor
	 * 
	 * @return mapa das contas
	 */
	public Map<String, Conta> getContaCliente() {
		return this.contasClientes;
	}

	/**
	 * O metodo altera o email de um fornecedor
	 * 
	 * @param email recebe o novo email do fornecedor
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * O metodo retorna o mapa de produtos do fornecedor
	 * 
	 * @return mapa de produtos do fornecedor
	 */
	public LinkedHashMap<String, Produtos> getProdutos() {
		return produtos;
	}

	/**
	 * O metodo altera o telefone de um fornecedor
	 * 
	 * @param telefone recebe o novo telefone do fornecedor
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * O metodo insere um produto com chave e valor dentro do mapa. A chave eh a
	 * concatenacao do nome do produto e descricao. O valor eh o nome do produto,
	 * descricao e o preco.
	 * 
	 * @param nomeProduto recebe o nome do produto
	 * @param desc        recebe a descricao do produto
	 * @param preco       recebe o preco do produto
	 */
	public void cadastraProduto(String nomeProduto, String desc, double preco) {
		valida.validaCadastroProduto(nomeProduto, desc, preco);
		String chave = nomeProduto + " " + desc;
		produtos.put(chave, new Produtos(nomeProduto, desc, preco));
	}

	/**
	 * O metodo verifica se dois produtos sao iguais a partir do seu nome e
	 * descricao
	 * 
	 * @param nomeProduto recebe o nome do produto a ser verificado
	 * @param desc        recebe a descricao do produto a ser verificada.
	 * @return caso o produto passado como parametro nao esteja dentro do mapa, sera
	 *         retornado false. Caso o produto ja exista no mapa, sera retornado
	 *         true.
	 */
	public boolean verificaIgual(String nomeProduto, String desc) {
		String chave = nomeProduto + " " + desc;
		if (produtos.containsKey(chave)) {
			return true;
		}
		return false;
	}

	/**
	 * O metodo exibe um produto existente dentro do mapa.
	 * 
	 * @param nomeProduto recebe o nome de um produto
	 * @param desc        recebe a descricao de um produto
	 * @return Caso o produto exista sera retornado no seu formato toString. Caso
	 *         contrario, sera retornado que o produto nao esta cadastrado.
	 */
	public String exibeUmProduto(String nomeProduto, String desc) {
		String chave = nomeProduto + " " + desc;
		if (produtos.containsKey(chave)) {
			return produtos.get(chave).toString();
		}
		return "Produto nao cadastrado";
	}

	/**
	 * O metodo exibe todos os produtos de um fornecedor
	 * 
	 * @param nomeFornecedor recebe o nome do fornecedor
	 * @return todos os produtos.
	 */
	public String exibeTodosProdutosUmFornecedor() {
		ArrayList<String> valores = new ArrayList<>();
		ArrayList<Produtos> produtosOrdenados = new ArrayList<>();
		for (Produtos p : this.produtos.values()) {
			produtosOrdenados.add(p);
		}
		Collections.sort(produtosOrdenados);

		if (this.produtos.isEmpty()) {
			valores.add(this.nome + " -");
		} else {
			for (Produtos p : produtosOrdenados) {
				valores.add(this.nome + " - " + p.toString());
			}
		}
		return String.join(" | ", valores);
	}

	/**
	 * O metodo altera o preco de um produto
	 * 
	 * @param nomeProduto recebe o nome do produto
	 * @param desc        recebe a descricao de um produto
	 * @param preco       recebe o novo preco a ser alterado
	 */
	public boolean alteraPreco(String nomeProduto, String desc, double preco) {
		String chave = nomeProduto + " " + desc;
		if (produtos.containsKey(chave)) {
			produtos.get(chave).setPreco(preco);
		}
		return true;
	}

	/**
	 * O metodo remove um produto do mapa de produtos
	 * 
	 * @param nomeProduto recebe o nome do produto
	 * @param desc        recebe a descricao do produto
	 * @return Se o produto existir no mapa, entao sua remocao eh feita e eh
	 *         retornado true. Caso contrario, sera retornado false, pois o produto
	 *         nao existe para ser removido.
	 */
	public boolean removeProduto(String nomeProduto, String desc) {
		String chave = nomeProduto + " " + desc;
		if (produtos.containsKey(chave)) {
			produtos.remove(chave);
			return true;
		}
		return false;
	}

	/**
	 * O metodo ira cadastrar o combo de produtos e ira inseri-lo no mapa de
	 * produtos. Alem disso ele tambem ira armazenar em uma lista os produtos que
	 * compoem esse combo para que seja possivel obter o preco de cada produto
	 * separadamente
	 * 
	 * @param nome             recebe o nome do combo
	 * @param descricao        recebe a descricao do combo
	 * @param fator            recebe o fator do combo
	 * @param valorSemDesconto recebe o valor total dos dois produtos simples
	 * @param produtinhos      recebe um array do tipo string que contem o nome e a
	 *                         descricao (chave) de cada produto simples que compoe
	 *                         o combo
	 */
	public void cadastraCombo(String nome, String descricao, double fator, double valorSemDesconto,
			String[] produtinhos) {
		String chave = nome + " " + descricao;
		ProdutoCombo produto = new ProdutoCombo(nome, descricao, fator);
		produto.calculaPreco(valorSemDesconto);
		produtos.put(chave, produto);
		for (String p : produtinhos) {
			produto.insireProdutoSimples(this.produtos.get(p));
		}
	}

	/**
	 * O metodo verifica se o combo ja existe
	 * 
	 * @param nomeProduto recebe o nome do combo
	 * @return Caso o combo exista sera retornado true, senao sera retornado false
	 */
	public boolean verificaComboExiste(String nomeProduto) {
		if (produtos.containsKey(nomeProduto)) {
			return produtos.get(nomeProduto) instanceof ProdutoCombo;
		}
		return false;
	}

	/**
	 * O metodo edita o fator de um combo existente
	 * 
	 * @param nome      recebe o nome do combo
	 * @param descricao recebe a descricao do combo
	 * @param novoFator recebe o novo fator do combo
	 */
	public void editaCombo(String nome, String descricao, double novoFator) {
		String chave = nome + " " + descricao;
		if (produtos.containsKey(chave)) {
			if (produtos.get(chave) instanceof ProdutoCombo) {
				ProdutoCombo combo = (ProdutoCombo) produtos.get(chave);
				combo.setFator(novoFator);
				combo.calculaPreco(combo.valorDosProdutosSimples());
			}
		}
	}

	/**
	 * O metodo cria uma conta de um cliente para um fornecedor
	 * 
	 * @param cpf recebe o cpf de um cliente existente
	 */
	public void criaConta(String cpf) {
		this.contasClientes.put(cpf, new Conta());
	}

	/**
	 * O metodo insere na conta de um cliente um produto que o mesmo comprou
	 * 
	 * @param cpf       recebe o cpf do cliente
	 * @param data      recebe a data da compra do produto
	 * @param nome_prod recebe o nome do produto
	 * @param desc_prod recebe a descricao do produto
	 */
	public void insereProdutoNaConta(String cpf, String data, String nome_prod, String desc_prod) {
		double precoProduto = this.produtos.get(nome_prod + " " + desc_prod).getPreco();
		this.contasClientes.get(cpf).insereCompra(data, nome_prod, desc_prod, precoProduto);
	}

	/**
	 * O metodo ira retornar o valor de debito de um cliente para um fornecedor
	 * 
	 * @param cpf recebe o cpf do cliente
	 * @return valor de debito do cliente para o fornecedor
	 */
	public String pegaValorDaConta(String cpf) {
		return this.contasClientes.get(cpf).getDebito();
	}

	/**
	 * O metodo verifica se um cliente possui conta com um fornecedor
	 * 
	 * @param cpf recebe o cpf de um cliente
	 * @return Caso o cliente possua conta com o fornecedor, sera retornado true.
	 *         Caso contrario, sera retornado false.
	 */
	public boolean verificaSeTemConta(String cpf) {
		return this.contasClientes.containsKey(cpf);
	}

	/**
	 * O metodo exibe a conta de um cliente para um determinado fornecedor
	 * 
	 * @param cpf recebe o cpf de um cliente
	 * @return conta de um cliente para um determinado fornecedor, no formato FFFF |
	 *         NNNNN - DD-DD-DDDD. Onde 'F' representa o nome do fornecedor, 'N'
	 *         representa o nome do produto e 'D' a data da compra do produto
	 */
	public String exibeContas(String cpf) {
		return this.nome + " | " + this.contasClientes.get(cpf).reuneProdutos();
	}

	/**
	 * O metodo realiza o pagamento da conta de um cliente para um determinado
	 * fornecedor removendo do mapa de contas o cliente.
	 * 
	 * @param cpf recebe o cpf de um cliente
	 */
	public void realizaPagamento(String cpf) {
		this.contasClientes.remove(cpf);
	}

	/**
	 * Retorna a String que representa um fornecedor no sistema. No formato NNNN -
	 * EEEE - TTTT, onde 'N' representa o nome do fornecedor, 'E' representa o email
	 * do fornecedor e 'T' representa o telefone do fornecedor.
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	/**
	 * Retorna um numero inteiro que representa um codigo que eh gerado a partir das
	 * informacoes do objeto Fornecedor.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * O metodo compara se um objeto eh igual ao outro, retornando true ou false. No
	 * caso em questao ele ira verificar se o nome de um fornecedor eh igual ao nome
	 * de outro fornecedor. Caso seja, retornara true, caso contrario, retornara
	 * false.
	 */
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

	/**
	 * O metodo compara se o nome de um fornecedor eh maior do que outro
	 * alfabeticamente
	 * 
	 * @return um numero inteiro
	 */
	@Override
	public int compareTo(Fornecedor o) {
		return this.nome.compareTo(o.getNome());
	}

}