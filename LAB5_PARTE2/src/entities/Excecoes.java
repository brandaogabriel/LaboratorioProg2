package entities;

/**
 * Representa metodos que sao responsaveis por validar os dados que sao
 * recebidos.
 */

public class Excecoes {

	/**
	 * O metodo valida as entradas para cadastro de um cliente
	 * 
	 * @param cpf         do cliente
	 * @param nome        do cliente
	 * @param email       do cliente
	 * @param localizacao do cliente
	 * @throws IllegalArgumentException Caso o cpf, nome, email ou localizacao sejam
	 *                                  nulas ou strings vazias, entao a excecao eh
	 *                                  lancada indicando em qual parametro ocorreu
	 *                                  o erro.
	 */
	public void validaCadastroCliente(String nome, String email, String localizacao) {
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
	 * 
	 * @param atributo  recebe o tipo de atributo que deseja se editar. Nome, email
	 *                  ou localizacao.
	 * @param novoValor recebe o novo nome, email ou localizacao.
	 * @throws IllegalArgumentException caso o atributo seja uma string vazia ou
	 *                                  nula, a excecao eh lancada.
	 * @throws IllegalArgumentException caso o novoValor seja uma string vazia ou
	 *                                  nula, a excecao eh lancada.
	 * @throws IllegalArgumentException caso o atributo nao seja nome, email ou
	 *                                  localizacao a excecao eh lancada.
	 */
	public void validaEditaCliente(String atributo, String novoValor) {
		if (atributo == null || atributo.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		if (novoValor == null || novoValor.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		if (!(atributo.equals("nome")) && !(atributo.equals("email")) && !(atributo.equals("localizacao"))) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}

	/**
	 * O metodo valida as entradas para cadastro de um fornecedor
	 * 
	 * @param nome     do fornecedor
	 * @param email    do fornecedor
	 * @param telefone do fornecedor
	 * @throws IllegalArgumentException Caso o nome, email ou telefone sejam nulas
	 *                                  ou strings vazia, entoa a excecao eh lancada
	 *                                  indicando em qual parametro ocorreu o erro.
	 */
	public void validaCadastoFornecedor(String nome, String email, String telefone) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if (telefone == null || telefone.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	}

	/**
	 * O metodo valida os parametros para edicao de um fornecedor
	 * 
	 * @param atributo  parametro do tipo string a ser avaliado.
	 * @param novoValor parametro do tipo string a ser avaliado.
	 * @throws IllegalArgumentException Caso o atributo ou o novoValor sejam nulos
	 *                                  ou string vazias, ent�o a excecao eh
	 *                                  lancada indicando em qual parametro ocorreu
	 *                                  o erro.
	 */
	public void validaEditaFornecedor(String atributo, String novoValor) {
		if (atributo == null || atributo.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
		if (novoValor == null || novoValor.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
		if (!(atributo.equals("email")) && !(atributo.equals("telefone"))) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}

	/**
	 * O metodo valida os parametros para o cadastro de um produto
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @param nomeProduto    nome do produto
	 * @param desc           descricao referente ao produto
	 * @param preco          preco de um produto do tipo double
	 * @throws IllegalArgumentException Caso o nomeProduto ou descricao sejam nulas
	 *                                  ou string vazias, entao a excecao eh lancada
	 *                                  indicando em qual parametro ocorreu o erro.
	 *                                  Caso o preco seja negativo tambem eh lancada
	 *                                  a excecao.
	 */
	public void validaCadastroProduto(String nomeProduto, String desc, double preco) {
		if (nomeProduto == null || nomeProduto.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if (desc == null || desc.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
	}

	/**
	 * O metodo valida os parametros para exibir um produto.
	 * 
	 * @param nome       do produto
	 * @param descricao  do produto
	 * @param fornecedor do produto
	 * @throws IllegalArgumentException Caso o nome, descricao ou fornecedor sejam
	 *                                  nulas ou strings vazias entao a excecao eh
	 *                                  lancada indicando em qual parametro ocorreu
	 *                                  o erro.
	 */
	public void validaExibeProduto(String nome, String descricao, String fornecedor) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}

	/**
	 * O metodo valida os parametros para edicao de um produto
	 * 
	 * @param nome       do produto
	 * @param descricao  do produto
	 * @param fornecedor do produto
	 * @param novoPreco  do produto
	 * @throws IllegalArgumentException Caso o nome, descricao ou fornecedor sejam
	 *                                  nulas ou strings vazias entao a excecao eh
	 *                                  lancada indicando em qual parametro ocorreu
	 *                                  o erro. Caso o preco seja negativo tambem eh
	 *                                  lancada a excecao.
	 */
	public void validaEditaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (novoPreco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
	}

	/**
	 * O metodo valida os parametros para remocao de um produto
	 * 
	 * @param nome       do produto
	 * @param descricao  do produto
	 * @param fornecedor do produto
	 * @throws IllegalArgumentException Caso o nome, descricao ou fornecedor sejam
	 *                                  nulas ou strings vazias entao a excecao eh
	 *                                  lancada indicando em qual parametro ocorreu
	 *                                  o erro.
	 */
	public void validaRemoveProduto(String nome, String descricao, String fornecedor) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}

	/**
	 * O metodo valida os parametros para o cadastro de um combo
	 * 
	 * @param fornecedor recebe nome de um fornecedor
	 * @param nome       recebe nome do combo
	 * @param descricao  recebe descricao do combo
	 * @param fator      recebe o fator do combo
	 * @param produtos   recebe o nome dos produtos simples
	 * @throws IllegalArgumentException Caso o fornecedor, nome, descricao, fator ou
	 *                                  produtos sejam nulas, string vazias ou o
	 *                                  fator seja negativo, a excecao eh lancada
	 */
	public void validaCadastroCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		}
		if (produtos == null || produtos.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");
		}
		if (fator <= 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
	}

	/**
	 * O metodo valida os parametros de edicao de um combo
	 * 
	 * @param nome       recebe o nome do combo
	 * @param descricao  recebe a descricao do combo
	 * @param fornecedor recebe o nome do fornecedor que contem o combo
	 * @param novoFator  recebe o novo fator
	 * @throws IllegalArgumentException Caso o nome, descricao, fornecedor ou fator
	 *                                  sejam nulas, string vazias ou o novo fator
	 *                                  seja negativo ou maior-igual a 1, a excecao
	 *                                  eh lancada
	 */
	public void validaEditaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		}
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		}
		if (novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}
	}

	/**
	 * O metodo valida uma entrada do tipo string
	 * 
	 * @param string recebe a entrada
	 * @param msg    mensagem que sera lancada caso a entrada seja invalida
	 * @throws IllegalArgumentException Caso a entrada passada como paramentro seja
	 *                                  nula ou uma string vazia a excecao eh
	 *                                  lancada com uma mensagem que eh passada como
	 *                                  parametro
	 */
	public void validaString(String string, String msg) {
		if (string == null || string.trim().equals(""))
			throw new IllegalArgumentException(msg);
	}

	/**
	 * O metodo valida o cpf de um cliente
	 * 
	 * @param cpf recebe o cpf do cliente
	 * @param msg recebe a mensagem que sera lancada caso o cpf seja invalido
	 * @throws IllegalArgumentException Caso o cpf seja invalido a excecao eh
	 *                                  lancada com uma mensagem que eh passada como
	 *                                  parametro
	 */
	public void validaCpf(String cpf, String msg) {
		if(cpf == null) {
			throw new IllegalArgumentException(msg);
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * O metodo valida uma data de compra
	 * 
	 * @param data recebe a data da compra
	 * @param msg  recebe a mensagem que sera lancada caso a data seja invalida
	 * @throws IllegalArgumentException Caso a data seja invalida a excecao eh
	 *                                  lancada com uma mensagem que eh passada como
	 *                                  parametro
	 */
	public void validaData(String data, String msg) {
		String verifica = data.replace("/", "");
		if (verifica.length() != 8) {
			throw new IllegalArgumentException(msg);
		}
	}

}
