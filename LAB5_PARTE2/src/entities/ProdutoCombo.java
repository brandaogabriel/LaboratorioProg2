package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Representacao de um Combo. Um combo é composto por 2 ou mais produtos
 * simples. Dessa maneira ela eh filha da classe Produtos (Conside a classe
 * Produtos como sendo ProdutoSimples). O unico diferencial eh que a classe
 * filha (ProdutoCombo) possui o atributo fator, que sera responsavel por
 * calcular o preco do combo juntamente com o preco dos produtos simples que o
 * compoem
 * 
 */
public class ProdutoCombo extends Produtos {

	/**
	 * Representa o fator de um combo
	 */
	private double fator;

	/**
	 * Representa uma lista de produtos simples que compoem um combo
	 */
	private List<Produtos> produtosSimples;

	/**
	 * O metodo controi um combo a partir do nome, descricao e fator do combo
	 *
	 * @param nome      recebe o nome do combo
	 * @param descricao recebe a descricao do combo
	 * @param fator     recebe o fator do combo
	 */
	public ProdutoCombo(String nome, String descricao, double fator) {
		super(nome, descricao, 0);
		this.fator = fator;
		this.produtosSimples = new ArrayList<>();
	}

	/**
	 * O metodo altera o valor do fator de um combo
	 * 
	 * @param fator recebe o novo fator do combo
	 */
	public void setFator(double fator) {
		this.fator = fator;
	}

	/**
	 * O metodo calcula o preco do combo. A partir da soma dos produtos simples que
	 * compoem esse combo, sera descontado do valor total do combo atraves do fator
	 * 
	 * @param somaProdutos recebe a soma total dos produtos simples que compoem o
	 *                     combo
	 */
	public void calculaPreco(double somaProdutos) {
		super.preco = somaProdutos - this.fator * somaProdutos;
	}

	/**
	 * O metodo insire na lista de produtos simples um produto que compoe o combo
	 * 
	 * @param p recebe um Produtos
	 */
	public void insireProdutoSimples(Produtos p) {
		this.produtosSimples.add(p);
	}

	/**
	 * O metodo calcula o valor dos produtos simples que compoem um combo
	 * 
	 * @return valor de todos os produtos simples que compoem o combo (sem o
	 *         desconto do fator)
	 */
	public double valorDosProdutosSimples() {
		double valor = 0.0;

		for (Produtos p : this.produtosSimples) {
			valor += p.preco;
		}
		return valor;
	}

}
