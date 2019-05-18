package entities;

import java.util.ArrayList;
import java.util.List;

public class ProdutoCombo extends Produtos {
	
	private double fator;
	private List<Produtos> produtosSimples;
	
	public ProdutoCombo(String nome, String descricao, double fator) {
		super(nome, descricao, 0);
		this.fator = fator;
		this.produtosSimples = new ArrayList<>();
	}
	
	public void setFator(double fator) {
		this.fator = fator;
	}
	
	public void calculaPreco(double somaProdutos) {
		super.preco = somaProdutos - this.fator * somaProdutos;
	}
	
	public void insireProdutoSimples(Produtos p) {
		this.produtosSimples.add(p);
	}
	
	public double valorDosProdutosSimples() {
		double valor = 0.0;
		
		for(Produtos p : this.produtosSimples) {
			valor += p.preco;
		}
		return valor;
	}
	
}
