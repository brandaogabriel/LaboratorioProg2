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
		if (entrada == null) {
			throw new NullPointerException("Entrada nula");
		}
		if (entrada.equals("") || entrada.trim().equals("")) {
			throw new IllegalArgumentException("Entrada vazia");
		}
	}
	
	public void validaEditaCliente(String atributo, String novoValor) {
		if (atributo.equals("sobrenome")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
		if (atributo.equals("") || atributo.equals(null)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		if (novoValor.equals("") || novoValor.equals(null)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
	}
	
	public void validaCadastroCliente(String cpf, String nome, String email, String localizacao) {
		if(cpf.length() < 11 || cpf.length() > 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		if (nome == null) {
			throw new NullPointerException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if (nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if (email == null) {
			throw new NullPointerException("Erro no cadastro do cliente: email nao pode vazio ser ou nulo.");
		}
		if (email.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if (localizacao == null) {
			throw new NullPointerException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
		if (localizacao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}
	/**
	 * O metodo verifica se o parametro repassado no formato double eh valida.
	 * @param preco recebe um preco a ser verificado.
	 * @throws IllegalArgumentException se o preco passado como parametro for 
	 * menor que 0 entao a excecao eh lancada pois nao existe valor negativo para um
	 * preco
	 */
	public void verificaValorProduto(double preco) {
		if (preco < 0.0) {
			throw new IllegalArgumentException("Preco negativo");
		}
	}
	
}
