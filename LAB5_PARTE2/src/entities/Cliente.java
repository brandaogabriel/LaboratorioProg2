package entities;

/**
 * Representacao de um cliente em um estabelecimento comercial. O cliente por
 * sua vez eh identificado pelo cpf, mas tamb�m possui nome, email e uma
 * localizacao (area de trabalho).
 */

public class Cliente implements Comparable<Cliente> {
	/**
	 * Representa o cpf de um cliente
	 */
	private String cpf;

	/**
	 * Representa o nome de um cliente
	 */
	private String nome;

	/**
	 * Representa o email de um cliente
	 */
	private String email;

	/**
	 * Representa a localizacao de um cliente
	 */
	private String localizacao;

	/**
	 * Representa um conjunto de metodos do tipo Excecoes para realizar validacao de
	 * dados de entrada
	 */
	private Excecoes valida;

	/**
	 * Constroi um cliente a partir de seu cpf, nome, email e localizacao.
	 * 
	 * @param cpf         recebe o cpf do cliente no formato String
	 * @param nome        recebe o nome do cliente no formato String
	 * @param email       recebe o email do cliente no formato String
	 * @param localizacao recebe a localizacao do cliente no formato String
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.valida = new Excecoes();
		valida.validaCadastroCliente(cpf, nome, email, localizacao);
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}

	public String getName() {
		return this.getName();
	}

	/**
	 * Altera o nome de um cliente
	 * 
	 * @param nome recebe o novo nome do cliente no formato String
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Altera o email de um cliente
	 * 
	 * @param email recebe o novo email do cliente no formato String
	 */
	public void setEmail(String email) {

		this.email = email;
	}

	/**
	 * Altera a localizacao de um cliente
	 * 
	 * @param localizacao recebe a nova localizacao no formato String
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Retorna a String que representa um cliente no sistema. No formato NNNN -
	 * LLLLL - EEEEE, onde 'N' representa o nome do cliente, 'L' representa a
	 * localizacao do cliente e 'E' representa o email do cliente.
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	/**
	 * Retorna um numero inteiro que representa um codigo que eh gerado a partir das
	 * informacoes do objeto Cliente.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	/**
	 * O metodo compara se um objeto eh igual ao outro, retornando true ou false. No
	 * caso em questao ele ira verificar se o cpf de um cliente eh igual ao cpf de
	 * outro cliente. Caso seja, retornara true, caso contrario, retornara false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cliente other) {
		return this.nome.compareTo(other.getName());
	}

}