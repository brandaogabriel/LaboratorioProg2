package lab05;

import java.util.LinkedHashMap;

/**
 * Representacao de um fornecedor de um determinado estabelicimento que eh resposavel
 * por armazenar e manipular os produtos que a ele pertencem. Este por sua vez possui 
 * um nome (identificador), email, telefone e uma lista de produtos do tipo produto.
 */

public class Fornecedor {
	
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
	 * Representacao dos produtos de um fornecedor atraves de um mapa.
	 * A chave eh o nome do produto e a descricao, o valor eh o Produto.
	 */
	private LinkedHashMap<String,Produtos> produtos;
	
	/**
	  * Representa um conjunto de metodos do tipo Excecoes para realizar validacao
	  * de dados de entrada
	  */
	private Excecoes valida;
	
	/**
	 * Constroi um fornecedor a partir do nome, email e telefone
	 * @param nome recebe o nome do fornecedor
	 * @param email recebe o email do fornecedor
	 * @param telefone recebe o telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.valida = new Excecoes();
		valida.validaEntrada(nome);
		valida.validaEntrada(email);
		valida.validaEntrada(telefone);	
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new LinkedHashMap<>();
	}
	
	/**
	 * O metodo altera o email de um fornecedor
	 * @param email recebe o novo email do fornecedor
	 */
	public void setEmail(String email) {
		valida.validaEntrada(email);
		this.email = email;
	}
	
	/**
	 * O metodo altera o telefone de um fornecedor
	 * @param telefone recebe o novo telefone do fornecedor
	 */
	public void setTelefone(String telefone) {
		valida.validaEntrada(telefone);
		this.telefone = telefone;
	}
	
	/**
	 * O metodo insere um produto com chave e valor dentro do mapa. A chave eh a concatenacao
	 * do nome do produto e descricao. O valor eh o nome do produto, descricao e o preco.
	 * @param nomeProduto recebe o nome do produto
	 * @param desc recebe a descricao do produto
	 * @param preco recebe o preco do produto
	 */
	public void insereProduto(String nomeProduto, String desc, double preco) {
		String chave = nomeProduto + " " + desc;
		produtos.put(chave, new Produtos(nomeProduto, desc, preco));
	}
	
	/**
	 * O metodo verifica se dois produtos sao iguais a partir do seu nome e descricao
	 * @param nomeProduto recebe o nome do produto a ser verificado
	 * @param desc recebe a descricao do produto a ser verificada.
	 * @return caso o produto passado como parametro nao esteja dentro do mapa, sera 
	 * retornado false. Caso o produto ja exista no mapa, sera retornado true.
	 */
	public boolean verificaIgual(String nomeProduto, String desc) {
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		String chave = nomeProduto + " " + desc;
		if(produtos.containsKey(chave)) {
			return true;
		}return false;
	}
	
	/**
	 * O metodo exibe um produto existente dentro do mapa.
	 * @param nomeProduto recebe o nome de um produto
	 * @param desc recebe a descricao de um produto
	 * @return Caso o produto exista sera retornado no seu formato toString. Caso contrario, 
	 * sera retornado que o produto nao esta cadastrado.
	 */
	public String exibeUmProduto(String nomeProduto, String desc) {
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		String chave = nomeProduto + " " + desc;
		if(produtos.containsKey(chave)) {
			return produtos.get(chave).toString();
		}return "Produto nao cadastrado";
	}
	
	/**
	 * O metodo exibe todos os produtos de um fornecedor
	 * @param nomeFornecedor recebe o nome do fornecedor 
	 * @return todos os produtos.
	 */
	public String exibeTodosProdutosUmFornecedor(String nomeFornecedor) {
		valida.validaEntrada(nomeFornecedor);
		String itens = "";
		for (String p : this.produtos.keySet()) {
			itens += nomeFornecedor + " - " +  produtos.get(p).toString() + " | ";
		}
		return itens;
	}
	
	/**
	 * O metodo altera o preco de um produto
	 * @param nomeProduto recebe o nome do produto
	 * @param desc recebe a descricao de um produto
	 * @param preco recebe o novo preco a ser alterado
	 */
	public void alteraPreco(String nomeProduto, String desc, double preco) {
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		valida.verificaValorProduto(preco);
		String chave = nomeProduto + " " + desc;
		if (produtos.containsKey(chave)) {
			produtos.get(chave).setPreco(preco);
		}
	}
	
	/**
	 * O metodo remove um produto do mapa de produtos
	 * @param nomeProduto recebe o nome do produto
	 * @param desc recebe a descricao do produto
	 * @return Se o produto existir no mapa, entao sua remocao eh feita e eh retornado true.
	 * Caso contrario, sera retornado false, pois o produto nao existe para ser removido.
	 */
	public boolean removeProduto(String nomeProduto, String desc) {
		valida.validaEntrada(nomeProduto);
		valida.validaEntrada(desc);
		String chave = nomeProduto + " " + desc;
		if(produtos.containsKey(chave)) {
			produtos.remove(chave);
			return true;
		}return false;
	}
	
	/**
	 * Retorna a String que representa um fornecedor no sistema.
	 * No formato NNNN - EEEE - TTTT, onde 'N' representa o nome do fornecedor,
	 * 'E' representa o email do fornecedor e 'T' representa o telefone do fornecedor.
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}
	
	/**
	 * Retorna um numero inteiro que representa um codigo que eh gerado 
	 * a partir das informacoes do objeto Fornecedor. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * O metodo compara se um objeto eh igual ao outro, retornando true ou false.
	 * No caso em questao ele ira verificar se o nome de um fornecedor eh igual ao nome
	 * de outro fornecedor. Caso seja, retornara true, caso contrario, retornara false.
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
		
}