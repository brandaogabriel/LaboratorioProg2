package entities;

public abstract class ContaAbstract implements Conta{
	
	private String cpf;
	protected int saldo;
	
	public ContaAbstract(String cpf) {
		this.cpf = cpf;
		this.saldo = 0;
	}
	
	public abstract int sacar(int valor);
	
	public int depositar(int valor) {
		this.saldo += valor;
		return valor;
	}
	
}
