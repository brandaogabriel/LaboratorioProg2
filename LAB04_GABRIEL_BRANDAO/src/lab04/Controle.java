package lab04;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representacao de um controle academico de uma determinada
 * universidade. O controle academico possui um mapa que contem matriculas e nome
 * dos alunos. Possui um mapa de grupos de alunos e tambem uma lista na qual 
 * representa alunos que responderam aos professores em sala. 
 */
public class Controle {
	
	/**
	 * Representacao dos alunos atraves de um mapa. A chave eh a matricula
	 * e o valor eh o objeto aluno. 
	 */
	private HashMap<String, Aluno> alunos;
	
	/**
	 * Representacao dos grupos de estudo atraves de um mapa. A chave eh o nome 
	 * do grupo e o valor eh o objeto grupo que contem seus respectivos alunos. 
	 */
	private HashMap<String, Grupo> grupos;
	
	/**
	 * Representacao atraves de uma lista do tipo String dos alunos que responderam 
	 * seus professores em sala.
	 */
	private ArrayList<String> alunosResponderam; 
	
	/**
	 * Constroi um controle academico, sem necessidade de parametros.
	 */
	public Controle() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunosResponderam = new ArrayList<>();
	}
	
	/**
	 * O metodo ira cadastrar um aluno no controle academico. Porem antes é 
	 * verificado se as entradas sao validas a partir do metodo ValidaEntradaCadastro().
	 * 
	 * @param matricula recebe a matricula do aluno.
	 * @param nome recebe o nome do aluno.
	 * @param curso recebe o nome do curso do aluno.
	 * @return Se o cadastro ocorrer com exito, retornara true. Caso contrario
	 * retornara false.
	 */
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		validaEntradaCadastro(matricula, nome, curso);
		if (!this.alunos.containsKey(matricula)) {
			Aluno a = new Aluno(matricula, nome, curso);
			alunos.put(a.getMatricula(), a);
			return true;
		}return false;
	}

	/**
	 * Exibe o aluno a partir de sua matricula.
	 * @param matricula recebe a matricula do aluno. 
	 * @return retorna o objeto aluno. Caso o aluno nao esteja cadastrado retornara
	 * null. 
	 */
	public Aluno exibeAluno(String matricula) {
		validaEntrada(matricula);
		return this.alunos.get(matricula);
	}
	
	/**
	 * Cadastra um grupo a partir de um nome. 
	 * @param nomeGrupo recebe o nome do grupo a ser criado.
	 * @return Caso o grupo nao exista sera retornado true. Caso contrario, false.
	 */
	public boolean cadastraGrupo(String nomeGrupo) {
		validaEntrada(nomeGrupo);
		if (!verificaNomeGrupo(nomeGrupo)) {
			Grupo g = new Grupo(nomeGrupo);
			grupos.put(nomeGrupo, g);
			return true;
		}
		return false;
	}
	
	/**
	 * O metodo aloca um aluno em um determinado grupo. Cada grupo possui uma matricula de
	 * aluno unica, ou seja, sem repeticao. 
	 * 
	 * @param matricula recebe a matricula do aluno.
	 * @param nomeGrupo recebe o nome de um grupo.
	 * @return Caso a matricula do aluno nao exista, sera retornado 'Aluno nao cadastrado'.
	 * Caso o grupo nao exista, sera retornado 'Grupo nao cadastrado'. Se as 2 hipoteses acima
	 * forem falsas, sera retornado 'Aluno Alocado'.
	 */
	public String alocaAluno(String matricula, String nomeGrupo) {
		validaAlocaAluno(matricula, nomeGrupo);
		if(!this.alunos.containsKey(matricula)) {
			return "Aluno nao cadastrado!";
		}
		if (!verificaNomeGrupo(nomeGrupo)){
			return "Grupo nao cadastrado!";
		}
		
		for (String g : this.grupos.keySet()) {
			if (g.toUpperCase().equals(nomeGrupo.toUpperCase())) {
				grupos.get(g).insereAlunoGrupo(exibeAluno(matricula));
			}
		}
		return "Aluno alocado!"; 
	}
	
	/**
	 * O metodo imprime um grupo a partir de um dado nome. 
	 * @param nomeGrupo recebe o nome de um grupo.
	 * @return Caso o grupo nao exista sera retornado 'Grupo nao cadastro'.
	 * Caso o grupo exista, sera verificando dentro do conjunto os alunos que a ele pertencem
	 * e sera retornado o nome do grupo juntamente com seus alunos. 
	 */
	public String imprimeGrupo(String nomeGrupo) {
		validaEntrada(nomeGrupo);
		if (!verificaNomeGrupo(nomeGrupo)) {
			return "Grupo nao cadastrado!" + System.lineSeparator();
		}
		
		String inicio = grupos.get(nomeGrupo).toString();
		String aluno = "";
		for (String g : grupos.keySet()) {
			if (g.toUpperCase().equals(nomeGrupo.toUpperCase())) {
				aluno += grupos.get(g).getAlunos();
				}	
			}	
		return inicio + System.lineSeparator() + aluno;
	}
	
	/**
	 * O metodo verifica se um grupo existe dentro de um Mapa. 
	 * @param nomeGrupo recebe o nome do grupo. 
	 * @return Caso o grupo nao exista, retornara false. Se existir retornara true.
	 */
	private boolean verificaNomeGrupo(String nomeGrupo) {
		for (String g : this.grupos.keySet()) {
			if (g.toUpperCase().equals(nomeGrupo.toUpperCase())) {
				return true;
			}
		}return false;
	}
	
	/**
	 * O metodo ira cadastrar um determinado aluno que respondeu ao professor.
	 * @param matricula recebe a matricula de um aluno.
	 * @return Caso a matricula nao exista, sera retornado false e o cadastro nao
	 * eh realizado. Caso contrario sera retornado true e o cadastrado efetuado.
	 */
	public boolean cadastraAlunoRespondeu(String matricula) {
		validaEntrada(matricula);
		boolean result = false;
		if (this.alunos.containsKey(matricula)) {
			alunosResponderam.add(matricula);
			result = true;
		}return result;
	}
	
	/**
	 * O metodo exibe os alunos que responderam em sala de aula.
	 * @return os alunos que responderam em sala no formato (X. MMM - NNNN - CCCC) onde,
	 * X representa um numero inteiro positivo que comeca em 1 e vai ate a quantidade de alunos
	 * que responderam. 'M' representa a matricula do aluno, 'N' representa o nome do aluno e 
	 * 'C' representa o curso do aluno. 
	 */
	public String exibeAlunosRespondeu() {
		String entry = "Alunos: " + System.lineSeparator();
		String quemRespondeu = "";
		int contador = 1;
		for (int i = 0; i < alunosResponderam.size(); i ++) {
			if(this.alunos.containsKey(alunosResponderam.get(i))) {
				quemRespondeu += contador + ". " + exibeAluno(alunosResponderam.get(i)) + System.lineSeparator();
			}contador +=1;
		}return entry + quemRespondeu;
		
	}
	
	/**
	 * O metodo eh responsavel por validar 3 entradas que sao passadas.
	 * @param matricula recebe matricula do aluno.
	 * @param nome recebe nome do aluno.
	 * @param curso recebe o nome do curso.
	 * @throws caso algums dos 3 parametros seja 'null' sera lancada a excecao
	 * 'NullPointerException' indicando que a entrada eh nula. 
	 * @throws caso algum dos 3 parametros seja uma string vazia ou string composta de 
	 * varios espacos, entao sera lancada a excecao 'IllegalArumentExecption' indicando
	 * que a entrada eh invalida. 
	 */
	private void validaEntradaCadastro(String matricula, String nome, String curso) {
		if (matricula == null || nome == null || curso == null) {
			throw new NullPointerException("Entrada nula");
		}
		if (matricula == "" || matricula.trim().equals("") || nome == "" || nome.trim().equals("") 
				|| curso == "" || curso.trim().equals("")) {
			throw new IllegalArgumentException("Entrada vazia");
		}
	}
	
	/**
	 * O metodo verifica se 2 parametros passados sao validos, no caso em questao, a matricula
	 * e o nome de um grupo.
	 * @param matricula recebe a matricula do aluno.
	 * @param nomeGrupo recebe o nome de um grupo.
	 * @throws caso algum dos 2 parametros seja nulo, sera lancada a excecao 'NullPointerException'
	 * indicando que o valor passado é nulo. 
	 * @throws caso algum dos 2 parametros seja uma string vazia ou uma string composta de espacos
	 * entao sera lancada a excecao 'IllegalArgumentException' indicando que o valor eh invalido.
	 */
	private void validaAlocaAluno(String matricula, String nomeGrupo) {
		if (matricula == null || nomeGrupo == null) {
			throw new NullPointerException("Entrada nula");
		}
		if (matricula == "" || matricula.trim().equals("") || nomeGrupo == "" 
				|| nomeGrupo.trim().equals("")) {
			throw new IllegalArgumentException("Entrada vazia");
		}
	}
	
	/**
	 * O metodo verifica se uma entrada eh valida.
	 * @param entrada recebe um valor do tipo string.
	 * @throws caso o parametro seja nulo, sera lancada a excecao 'NullPointerException' indicando
	 * que o valor eh nulo.
	 * @throws caso o parametro seja uma string ou uma string composta de varios espacos entao
	 * sera lancada a excecao 'IllegalArgumentException' indicando que o valor eh vazio. 
	 */
	private void validaEntrada(String entrada) {
		if (entrada == null) {
			throw new NullPointerException("Entrada nula");
		}
		if (entrada == "" || entrada.trim().equals("")) {
			throw new IllegalArgumentException("Entrada vazia");
		}
	}
		
}
