package lab05;

/**
 * Representa um metodo que eh responsavel por validar
 * os dados que sao recebidos. 
 */

public class Excecoes {
	
	/**
	 * O metodo verifica se o parametro repassado no formato String eh valido.
	 * @param entrada recebe uma entrada do tipo String. 
	 * @throws NullPointerException se a entrada passada como parametro for nula 
	 * sera lancada a excecao e entao informado ao usuario que ele digitou uma entrada invalida.
	 * @throws IllegalArgumentException se a entrada passada como parametro for uma String vazia
	 * ou uma String composta de espacos sera lancada a excecao e entao informado ao usuario
	 * que ele digitou uma entrada vazia.
	 */
	public void validaEntrada(String entrada) {
		if (entrada.equals(null)) {
			throw new NullPointerException("Entrada nula");
		}
		if (entrada.equals("") || entrada.trim().equals("")) {
			throw new IllegalArgumentException("Entrada vazia");
		}
	}
	
}
