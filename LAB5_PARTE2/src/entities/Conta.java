package entities;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	private List<Compra> compras;
	private double debito;
	
	public Conta() {
		this.compras = new ArrayList<>();
		this.debito = 0.0;
	}

	public void insereCompra(String data, String nome_prod, String desc_prod, double preco) {
		Compra c = new Compra(data, nome_prod, desc_prod, preco);
		compras.add(c);
	}
	
	public double getDebito() {
		for(Compra c : this.compras) {
			debito += c.getPreco();
		}
		return debito;
	}
	
}