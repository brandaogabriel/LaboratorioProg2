package lab05;

/**
 * Representa metodos que sao responsaveis por validar
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
	
	public void validaCadastroCliente(String cpf, String nome, String email, String localizacao) {
		if(cpf == null || cpf.length() < 11 || cpf.length() > 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if (localizacao == null || localizacao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}
	
	/**
	 * O metodo verifica se as entradas para edicao de um cliente sao validas.
	 * @param atributo recebe o tipo de atributo que deseja se editar. Nome, email ou localizacao. 
	 * @param novoValor recebe o novo nome, email ou localizacao.
	 * @throws IllegalArgumentException caso o atributo seja uma string vazia ou nula, a excecao eh lancada.
	 * @throws IllegalArgumentException caso o novoValor seja uma string vazia ou nula, a excecao eh lancada.
	 * @throws IllegalArgumentException caso o atributo nao seja nome, email ou localizacao a excecao eh lancada.
	 */
	public void validaEditaCliente(String atributo, String novoValor) {
		if (atributo.equals("") || atributo == null) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		if (novoValor.equals("") || novoValor == null) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		if (!(atributo.equals("nome")) && !(atributo.equals("email")) && !(atributo.equals("localizacao"))) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}
	
	public void validaCadastoFornecedor(String nome, String email, String telefone) {
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if(email == null || email.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if(telefone == null || telefone.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	} 
	
	public void validaEditaFornecedor(String atributo, String novoValor) {
		if(atributo == null || atributo.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
		if(novoValor == null || novoValor.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
		if(!(atributo.equals("email")) && !(atributo.equals("telefone"))) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}
}
