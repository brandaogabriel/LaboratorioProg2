package lab04;

import java.util.HashSet;
import java.util.Set;

/**
 * Representacao de um grupo que possui um nome (identificador) e um conjunto
 * HashSet do tipo Aluno, que armazena alunos que pertencem a um determinado
 * grupo.
 */

public class Grupo {
	/**
	 * Nome de um grupo no formato String.
	 */
	private String nomeGrupo;
	
	/**
	 * Lista do tipo aluno que armazenas alunos sem repeticao.
	 */
	private Set<Aluno> aluno;
	
	/**
	 * Constroi um grupo a partir de um nome.
	 * Tambem iniciara um conjunto vazio de alunos. 
	 * @param nomeGrupo recebe o nome do grupo a ser criado.
	 */
	public Grupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
		this.aluno = new HashSet<>();
	}
	
	/**
	 * O metodo insere um aluno em um determinado grupo.
	 * @param a recebe um objeto Aluno que sera inserido no conjunto de um grupo.
	 */
	public void insereAlunoGrupo(Aluno a) {
		aluno.add(a);
	}
	
	/**
	 * O metodo ira formatar no tipo String os alunos de um grupo.
	 * 
	 * @return os alunos de um grupo no formato * MMM - AAAA - CC, para cada um.
	 * Onde 'M' representa a matricula, 'A' representa o nome do aluno e 'C' representa
	 * o curso do aluno. Para cada aluno do grupo sera feito o mesmo procedimento, atraves
	 * do for each. 
	 */
	public String getAlunos() {
		String turminha = "";
		for (Aluno a : aluno) {
			turminha += "* " + a + System.lineSeparator();
		}	
		return turminha;	
	}
	
	/**
	 * Retorna a string que representa o nome de um grupo.
	 * No formato 'Alunos do grupo GGGGG:' onde 'G' representa o nome 
	 * de um grupo.
	 */
	public String toString() {
		return "Alunos do grupo " + this.nomeGrupo + ":";
	}

	/**
	 * Retorna um numero inteiro, que representa um codigo que eh gerado
	 * a partir das informacoes do objeto Grupo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}
	
	/**
	 * Metodo que compara se um objeto eh igual ao outro, retornando true
	 * ou false. No caso em questao ele ira verificar se o nome de um grupo � igual
	 * ao nome de outro. Caso seja, retornara true, caso nao, retornara false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}
	
	
	
}
