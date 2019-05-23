package entities;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	
	private List<Compra> compras;
	
	public Conta() {
		this.compras = new ArrayList<>();
	}

	public void insereCompra(String data, String nome_prod, String desc_prod, double preco) {
		Compra c = new Compra(data, nome_prod, desc_prod, preco);
		compras.add(c);
	}
	
	private double calculaDebito() {
		double debito = 0;
		for(Compra c : this.compras) {
			debito += c.getPreco();
		}
		return debito;
	}
	
	public String getDebito() {
		return String.format("%.2f", calculaDebito()).replaceAll(",", ".");
	}

	
	public String reuneProdutos() {
		List<String> compras = new ArrayList<>();
		for (Compra c : this.compras) {
			compras.add(c.toString());
		}
		return String.join(" | ", compras);
	}
		
}