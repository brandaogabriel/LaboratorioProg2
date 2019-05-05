package lab05;

public class Excecoes {
	
	public void validaEntrada(String entrada) {
		if (entrada.equals(null)) {
			throw new NullPointerException("Entrada nula");
		}
		if (entrada.equals("") || entrada.trim().equals("")) {
			throw new IllegalArgumentException("Entrada vazia");
		}
	}
	
}
