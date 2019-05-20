package entities;

public class Compra {
	
	private String data;
	private String nomeProduto;
	private String descProduto;
	private double preco;
	
	public Compra(String data, String nomeProduto, String descProduto, double preco) {
		this.data = data;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.descProduto = descProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return this.nomeProduto + " - " + this.data;
	}
	
	
}
