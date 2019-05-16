package entities;

public class ProdutoCombo extends Produtos {
	
	private double fator;

	public ProdutoCombo(String nome, String descricao, double fator) {
		super(nome, descricao, 0);
		this.fator = fator;
	}
	
	public void setFator(double fator) {
		this.fator = fator;
	}
	
	public void calculaPreco(double somaProdutos) {
		super.preco = somaProdutos - this.fator * somaProdutos; 
	}
	
}
