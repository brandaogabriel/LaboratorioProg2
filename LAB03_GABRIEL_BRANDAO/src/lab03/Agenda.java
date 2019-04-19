package lab03;

import java.util.Arrays;

/**
 * Representacao de uma agenda, que por sua fez possui contatos e 
 * estes contatos possuem nome, sobrenome e telefone. Um contato so existe
 * se uma agenda existir.  
 */
public class Agenda {
	
	/**
	 * Um array contatos do tipo Contato. Ira armazenar as informacoes do
	 * contato. 
	 */
	private Contato[] contatos;
	
	/**
	 * Constroi um array do tipo Contato de 100 posicoes para alocacao dos 
	 * contatos.
	 */
	public Agenda() {
		this.contatos = new Contato[100];
	}
	
	/**
	 * O metodo ira verificar se uma posicao eh valida para cadastro ou nao. Para ser valida precisa estar entre 1 e 100.
	 * @param posicao recebe uma posicao qualquer.
	 * @return Caso a posicao esteja entre 1 e 100 o metodo retornara true, caso nao esteja nesse intervalo retornara false.
	 */
	public boolean verificaPosicao(int posicao) {
		if (posicao < 1 || posicao > 100) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * O metodo ira verificar se o nome do contato eh nulo.
	 * @param nome recebe a String nome do contato, podendo ser 'null' ou nao.
	 * @throws Se o nome passado como parametro for nulo, sera lancada a excecao 'NullPointerException' indicando que o nome eh nulo.
	 */
	public void verificaNomeNulo(String nome) {
		if (nome == null) {
			throw new NullPointerException("String nula!");
		}
	}
	
	/**
	 * O metodo analisa se o nome do contato eh vazio.
	 * @param nome recebe a String nome do contato. 
	 * @throws Se  o nome for vazio entao o metodo ira lancar a excecao "IllegalArgumentException" indicando que
	 *  o que foi passado no nome nao eh aceito pelo programa.
	 */
	public void verificaNomeVazio(String nome) {
		if (nome.equals("")) {
			throw new IllegalArgumentException("String vazia!");
		}
	}
	
	/**
	 * O metodo cadastra um contato na agenda. Ele ira pegar a posicao que deseja ser cadastra e alocara o nome, sobrenome e telefone nessa posicao.
	 * Vale lembrar que so sera possivel cadastrar um contato caso a posicao seja valida. 
	 * @param posicao recebe a posicao no formato int.
	 * @param nome recebe o nome do contato no formato String.
	 * @param sobreNome recebe o sobrenome do contato no formato String.
	 * @param telefone recebe o telefone do contato no formato String.
	 */
	public void cadastraContato(int posicao, String nome, String sobreNome, String telefone) {
		verificaNomeNulo(nome);
		verificaNomeVazio(nome);
		Contato contato = new Contato(nome,  sobreNome,  telefone);
		contatos[posicao - 1] = contato;
	}

	/**
	 * O metodo exibe um contato a partir de uma posicao passanda como parametro.
	 * @param posicao recebe a posicao que se deseja ver o contato.
	 * @return Se o contato existir na agenda, sera retornado o contato no formato XXXX XXXX - NNNNNNNN onde 'X' representa o nome e o sobrenome do contato
	 * e 'N' representa o numero do contato. Se a posicao do contato nao existir sera retornado 'POSICAO INVALIDA!'.
	 */
	public String exibeContato(int posicao) {
		if(contatos[posicao - 1]!= null) {
			return contatos[posicao - 1].toString();
		}
		return "POSICAO INVALIDA!" + System.lineSeparator();
	}
	
	/**
	 * O metodo lista todos os contatos de uma agenda. Caso a posicao na agenda seja diferente de null esse contato sera impresso.  
	 * @return a lista de todos os contatos da agenda. 
	 */
	public String listaContatos() {
		String listaDosContatos = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				listaDosContatos += i + 1 + " - " + contatos[i].getNomeCompleto() + 
						System.lineSeparator();
			}
		}return listaDosContatos;
	}
	
	/**
	 * Retorna um numero inteiro que representa um codigo que eh gerado a partir
	 * das informacoes do objeto. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
		return result;
	}
	
	/**
	 * Metodo que compara se um objeto eh igual ao outro, retornando true
	 * ou false. No caso em questao ele ira verificar se os contatos de uma agenda sao
	 * iguais aos contatos de outra agenda. Uma agenda eh igual a outra se os contatos estiverem na mesma posicao.  
	 * Caso esteja retornara true, caso nao, retornara false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}
	
}
