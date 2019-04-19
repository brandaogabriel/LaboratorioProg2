package lab03;

/**
 *	Representacao de um contato, que está alocado em uma determinada
 *	agenda. Um contato tem nome, sobrenome e telefone. 
 */

public class Contato {
	/**
	 * Nome de um contato no formato XXXXX - onde X representa seu nome.
	 */
	private String nome;
	
	/**
	 * Representacao do sobrenome de um contato. 
	 */
	private String sobreNome;
	
	/**
	 * Representacao do telefone do contato no Formato NN NNNN-NNNN.
	 */
	private String telefone;
	
	/**
	 * Constroi um contato a partir do seu nome, sobrenome e telefone.
	 * @param nome recebe o nome do contato.
	 * @param sobreNome recebe o sobrenome do contato.
	 * @param telefone recebe o telefone do contato.
	 */
	public Contato(String nome, String sobreNome, String telefone) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.telefone = telefone;
	}
	
	/**
	 * O metodo ira verificar qual eh o nome do contato. 
	 * @return retorna o nome do contato.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * O metodo ira verificiar qual eh o sobrenome do contato.
	 * @return o sobrenome do contato.
	 */
	public String getsobreNome() {
		return this.sobreNome;
	}
	
	/**
	 * O metodo ira verificar qual eh o telefone do contato.
	 * @return o telefone do contato.
	 */
	public String getTelefone() {
		return this.telefone;
	}
	
	/**
	 * O metodo ira verificar qual eh o nome e o sobrenome do contato
	 * @return o nome e o sobre nome do contato no formato LLLLL BBBBB, onde
	 * 'L' representa o nome e 'B' representa o sobrenome.
	 */
	public String getNomeCompleto() {
		return getNome() + " " +  getsobreNome();
	}
	
	/**
	 * Retorna a String que representa o nome, sobrenome e telefone do contato
	 * no formato LLLLLL BBBBB - XX XXXX-XXXX onde 'X' representa o telefone
	 * do contato.
	 */
	public String toString() {
			return getNomeCompleto() + " - " + getTelefone();
	}

	/**
	 * Retorna um numero inteiro, que representa um codigo que eh gerado
	 * a partir das informacoes do objeto contato.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobreNome == null) ? 0 : sobreNome.hashCode());
		return result;
	}
	
	/**
	 * Metodo que compara se um objeto eh igual ao outro, retornando true
	 * ou false. No caso em questao ele ira verificar se nome e sobrenome sao
	 * iguais. Caso seja, retornara true, caso nao, retornara false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobreNome == null) {
			if (other.sobreNome != null)
				return false;
		} else if (!sobreNome.equals(other.sobreNome))
			return false;
		return true;
	}
	
}
