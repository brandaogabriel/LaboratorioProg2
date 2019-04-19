package lab2;
/**
 * Representacao de gastos de um aluno em uma determinada cantina. Todo aluno tem seus gastos,
 * quantidade de lanches que consumiu e quanto falta pagar. 
 * 
 * @author Gabriel Brandao
 *
 */
public class ContaCantina {
	
	/**
	 * Da nome a uma cantina no formato XXXXX, onde X representa o nome da cantina.
	 */
	private String nomeCantina;
	
	/**
	 * Representa os gastos totais que um aluno tem na cantina.
	 */
	private int gastosTotal;
	
	/**
	 * Determina quanto o aluno ainda deve na cantina.
	 */
	private int faltaPagar;
	
	/**
	 * Quantidade de lanches que o aluno pediu na cantina.
	 */
	private int itensLanche;
	
	/**
	 * Constroi uma cantina a partir do seu nome.
	 * @param nomeCantina recebe o nome da cantina.
	 */
	public ContaCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
	}
	
	/**
	 * A função não retorna nada. Atribui a quantidade e o preco dos lanches do aluno. 
	 * @param qtdItens recebe a quantidade de itens consumidos. 
	 * @param valorCentavos recebe o valor dos itens consumidos.
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.itensLanche += qtdItens;
		this.gastosTotal += valorCentavos;
		this.faltaPagar += valorCentavos;
	}
	
	/**
	 * A função nao retorna nada. Atribui a deduçao de debito caso o aluno pague o lanche.
	 * @param valorCentavos representação do valor que foi pago.
	 */
	public void pagaConta(int valorCentavos) {
		this.faltaPagar -= valorCentavos;
	}
	
	/**
	 * Representa quanto o aluno falta pagar a cantina
	 * @return representacao do valor. 
	 */
	public int getFaltaPagar() {
		return this.faltaPagar;
	}
	
	/**
	 * Retorna a String que representa a cantina, quantidade de itens consumidos e o gasto total.
	 * Tem o formato: XXXX A LLL, onde 'X' representa o nome da cantina, 'A' a quantidade de itens 
	 * e 'L' o valor gasto total.
	 */
	public String toString() {
		return nomeCantina + " " + itensLanche +  " " + gastosTotal;
	}
}

