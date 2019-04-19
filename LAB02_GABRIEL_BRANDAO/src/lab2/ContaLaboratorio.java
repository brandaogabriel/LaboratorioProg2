package lab2;

/**
 * Representação do uso de memória de um computador do laboratorio
 * de computacao da UFCG. Cada computador tem um limite de memoria definido. 
 * 
 * @author Gabriel Brandao 
 */

public class ContaLaboratorio {
	/**
	 * Nome do laboratorio. No formato LCCX onde X identifica o numero
	 * do laboratorio.
	 */
	private String nomeLaboratorio;
	
	/**
	 * Espaco de memoria que o usuario do laboratorio de computacao esta a usar.
	 */
	private int espacoOcupado;

	/**
	 * Cota de mbytes que o usuario do laboratorio possui para uso no
	 * computador.
	 */
	private int cota = 2000;
	
	/**
	 * Constroi um laboratorio a partir do seu nome. 
	 * @param nomeLaboratorio recebe o nome do laboratoio. 
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
	}
	
	/**
	 * Constroi um laboratorio a partir do seu nome e uma cota de uso 
	 * de memoria.
	 * @param nomeLaboratorio representa o nome do laboratorio.
	 * @param cota quantitade maxima que um usuario pode atingir de memoria.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
	}
	
	/**
	 * A funcao nao retorna nada, apenas adiciona a memoria utilizada pelo usuario.	
	 * @param mbytes recebe a quantidade de mbytes utilizada. 
	 */
	public void consomeEspaco(int mbytes) {
		this.espacoOcupado += mbytes;
	}
	
	/**
	 * A funcao nao retorna nada, apenas remove memoria que nao esta mais sendo utilizada.
	 * @param mbytes recebe a quantidade de memoria.
	 */
	public void liberaEspaco(int mbytes) {
		this.espacoOcupado -= mbytes;
	}
	
	/**
	 * A funcao verifica se o limite de memoria utilizada foi atingida.
	 * @return ira retornar verdadeiro caso a memoria tenha atingido o limite e falso caso contrario.
	 */
	public boolean atingiuCota() {
		if (espacoOcupado >= cota) {
			return true;
		}else return false;
	}
	
	/**
	 * Retorna a string que representa o laboratorio, memoria utilizada e a cota. 
	 * A representação segue o formato "LCCX - ZZZZ/LLLL , onde X representa o numero do laboratorio,
	 * Z representa quanto de memoria esta sendo utilizado e L representa o limite (cota). 
	 */
	public String toString() {
		return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
	}
}
