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
	
	public String getDebito() {
		for(int i = 0; i < compras.size(); i++) {
			this.debito += compras.get(i).getPreco();
		}
		return String.format("%.2f", debito).replaceAll(",", ".");
	}

	
	public String reuneProdutos() {
		List<String> compras = new ArrayList<>();
		for (Compra c : this.compras) {
			compras.add(c.toString());
		}
		return String.join(" | ", compras);
	}
		
}