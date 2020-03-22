package entities;

public class Poupanca extends ContaAbstract{

	
	public Poupanca(String cpf) {
		super(cpf);		
	}

	@Override
	public int sacar(int valor) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
		}
		return valor;
	}
}
