package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Representacao da conta de um cliente que por sua vez possui uma lista que
 * contem as compras desse cliente
 *
 */
public class Conta {

	/**
	 * Representacao de uma lista do tipo Compra
	 */
	private List<Compra> compras;

	/**
	 * Constroi uma conta
	 */
	public Conta() {
		this.compras = new ArrayList<>();
	}

	/**
	 * O metodo adiciona na lista de compras uma compra
	 * 
	 * @param data      recebe a data da compra
	 * @param nome_prod recebe o nome do produto
	 * @param desc_prod recebe a descricao do produto
	 * @param preco     recebe o preco do produto
	 */
	public void insereCompra(String data, String nome_prod, String desc_prod, double preco) {
		Compra c = new Compra(data, nome_prod, desc_prod, preco);
		compras.add(c);
	}

	/**
	 * O metodo calcula o debito de um cliente para um determinado fornecedor
	 * 
	 * @return debito total de um cliente
	 */
	private double calculaDebito() {
		double debito = 0;
		for (Compra c : this.compras) {
			debito += c.getPreco();
		}
		return debito;
	}

	/**
	 * O metodo retorna o debito de um cliente.
	 * 
	 * @return debito de um cliente formatado com duas casas decimais
	 */
	public String getDebito() {
		return String.format("%.2f", calculaDebito()).replaceAll(",", ".");
	}

	/**
	 * O metodo retorna a lista de compras de um determinado cliente
	 * 
	 * @return lista de compras de um determinado cliente no formato NNNNN -
	 *         DD-DD-DD |, onde 'N' representa o nome de um produto e 'D' a data de
	 *         compra do produto
	 */
	public String reuneProdutos() {
		List<String> compras = new ArrayList<>();
		for (Compra c : this.compras) {
			compras.add(c.toString());
		}
		return String.join(" | ", compras);
	}

}