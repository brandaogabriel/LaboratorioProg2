package lab04;

/**
 * Representacao de um aluno em um determinado controle academico.
 * O aluno tem uma matricula (identificador), nome e curso.
 */

public class Aluno {
	
	/**
	 * Matricula de um aluno no formato String.
	 */
	private String matricula;
	
	/**
	 * Nome de um aluno no formato String.
	 */
	private String nome;
	
	/**
	 * Nome do curso do aluno no formato String.
	 */
	private String curso;
	
	/**
	 * Constroi um aluno a partir da sua matricula, nome e curso.
	 * @param matricula recebe um numero no formato String que representa a matricula do aluno.
	 * @param nome recebe o nome do aluno.
	 * @param curso recebe o curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * O metodo verifica a matricula de um determinado aluno.
	 * @return a matricula do aluno.
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * Retorna a String que representa um aluno no controle academico. 
	 * No formato MMMMM - AAAAA - CCCC. Onde 'M' representa a matricula, 'A' nome do aluno e
	 * 'C' o curso do aluno.
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
	
	/**
	 * Retorna um numero inteiro, que representa um codigo que eh gerado
	 * a partir das informacoes do objeto aluno.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Metodo que compara se um objeto eh igual ao outro, retornando true
	 * ou false. No caso em questao ele ira verificar se a matricula de um aluno é igual
	 * a matricula de outro aluno. Caso seja, retornara true, caso nao, retornara false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
}
