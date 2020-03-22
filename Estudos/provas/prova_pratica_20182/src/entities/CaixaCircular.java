package entities;

public class CaixaCircular extends CaixaAbstract {
	
	private double raio;
	
	public CaixaCircular(String descricao, String personalizacao, String formato, String dimensao) {
		super(descricao, personalizacao, formato);
		this.raio = Double.parseDouble(dimensao);
		calculaPreco();
	}


	@Override
	public void calculaPreco() {
		double areaTotal = 3.14 * this.raio * this.raio;
		this.preco = areaTotal * 0.1;	
	}

}
