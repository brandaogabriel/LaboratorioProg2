package entities;

public class CaixaRetangular extends CaixaAbstract {
	
	private double lado1;
	private double lado2;
	
	public CaixaRetangular(String descricao, String personalizacao, String formato, String lado1, String lado2) {
		super(descricao, personalizacao, formato);
		this.lado1 = Double.parseDouble(lado1);
		this.lado2 = Double.parseDouble(lado2);
		calculaPreco();
	}
	

	@Override
	public void calculaPreco() {
		double areaTotal = this.lado1 * this.lado2;
		this.preco = areaTotal * 0.1;
	}

}
