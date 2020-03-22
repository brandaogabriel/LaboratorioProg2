package entities;

public class CaixaPentagonal extends CaixaAbstract {
	
	private double lado;
	
	public CaixaPentagonal(String descricao, String personalizacao, String formato, String dimensao) {
		super(descricao, personalizacao, formato);
		this.lado = Double.parseDouble(dimensao);
		calculaPreco();
	}
	
	@Override
	public void calculaPreco() {
		double alturaPentagono = (this.lado / 2 * Math.sqrt(5) + 2 * Math.sqrt(5)) / 2;
		double areaTotal = 5.0 * (this.lado * alturaPentagono) / 2;
		this.preco = 0.1 * areaTotal;
	}

}
