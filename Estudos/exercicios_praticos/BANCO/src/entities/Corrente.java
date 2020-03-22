package entities;

public class Corrente extends ContaAbstract {
	
	private int ch;

	public Corrente(String cpf, int ch) {
		super(cpf);
		this.ch = ch;
	}
	
	@Override
	public int sacar(int valor) {
		if(this.saldo + this.ch >= valor) {
			this.saldo -=valor;
		}
		return valor;
	}
	

}
