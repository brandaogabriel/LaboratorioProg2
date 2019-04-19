package lab2;

/**
 * Representacao da saude fisica e mental de um aluno. Todo aluno tem seu estado:
 * boa, ok ou fraca. 
 * @author Gabriel Brandao
 *
 */
public class Saude {
	
	/**
	 * Saude fisica do aluno que pode ser representada na forma: "boa" ou "fraca".
	 */
	private String saudeFisica;
	
	/**
	 * Saude mental do aluno que pode ser representada na forma: "boa" ou "fraca"./
	 */
	private String saudeMental;
	
	/**
	 * Constroi a saude mental e fisica de um aluno, inicializada como "boa" para os 2 atribuitos.
	 */
	public Saude() {
		this.saudeFisica = "boa";
		this.saudeMental = "boa";
	}
	
	/**
	 * Define a saude mental de um aluno. Podendo ser "boa" ou "fraca". 
	 * @param valor recebe o valor no tipo String.
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
	}
	
	/**
	 * Define a saude fisica de um aluno. Podendo ser "boa" ou "fraca".
	 * @param valor recebe o valor no tipo string
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
	}
	
	/**
	 * A funcao ira avaliar a saude mental e fisica do aluno e retornara o seu estado. 
	 * 
	 * @return Caso a saude mental e fisica estejam boas
	 * retorna "boa". Caso a saude mental e fisica estejam fracas retorna "fraca". 
	 * Caso contrario retornara "ok".
	 */
	public String getStatusGeral() {
		if (this.saudeMental.equals("boa") && this.saudeFisica.equals("boa")) {
			return "boa";
		}
		else if (this.saudeMental.equals("fraca") && this.saudeFisica.equals("fraca")) {
			return "fraca";	
		}else return "ok";
	}
	
}
