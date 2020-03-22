package entities;

/**
 * Representacao da compra de um cliente para um fornecedor. A compra possui uma
 * data, nome do Produto, descricao do produto e o seu preco
 * 
 */

public class Compra {

	/**
	 * Representacao da data de uma compra
	 */
	private String data;

	/**
	 * Representacao do nome do produto
	 */
	private String nomeProduto;

	/**
	 * Representacao da descricao de um produto
	 */
	private String descProduto;

	/**
	 * Representacao do preco de um produto
	 */
	private double preco;

	/**
	 * Constroi uma compra a partir da data, nome do produto, descricao e preco
	 * 
	 * @param data        recebe a data da compra
	 * @param nomeProduto recebe o nome do produto
	 * @param descProduto recebe a descricao do produto
	 * @param preco       recebe o preco do produto
	 */
	public Compra(String data, String nomeProduto, String descProduto, double preco) {
		this.data = data;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.descProduto = descProduto;
	}

	/**
	 * O metodo retorna a descricao de um produto
	 * 
	 * @return descricao de um produto
	 */
	public String getDescProduto() {
		return this.descProduto;
	}

	/**
	 * O metodo retorna a data de compra de um produto
	 * 
	 * @return data de compra de um produto
	 */
	public String getData() {
		return this.data;
	}

	/**
	 * O metodo retorna o preco de um produto
	 * 
	 * @return preco de um produto
	 */
	public double getPreco() {
		return this.preco;
	}

	/**
	 * Retorna a String que representa uma compra no sistema. No formato NNN -
	 * DD-DD-DDDD, onde 'N' representa o nome do produto e 'D' a data de compra do
	 * produto
	 */
	@Override
	public String toString() {
		return this.nomeProduto + " - " + this.data.replace("/", "-");
	}

}
