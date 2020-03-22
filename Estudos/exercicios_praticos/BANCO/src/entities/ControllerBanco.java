package entities;

import java.util.HashMap;
import java.util.Map;

public class ControllerBanco {
	
	private Map<String, Conta> contas;

	public ControllerBanco() {
		this.contas = new HashMap<>();
	}
	
	public void cadastraCC(String cpf, int ch) {
		this.contas.put(cpf, new Corrente(cpf, ch));
	}
	
	public void cadastraPou(String cpf) {
		this.contas.put(cpf, new Poupanca(cpf));
	}
	
	public int sacar(String cpf, int valor) {
		return this.contas.get(cpf).sacar(valor);
	}
	
	public int depositar(String cpf, int valor) {
		return this.contas.get(cpf).depositar(valor);
	}
}
