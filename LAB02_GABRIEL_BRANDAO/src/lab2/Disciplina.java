package lab2;
/**
 * Representacao de uma determinada disciplina. A disciplina possui um nome, horas de estudo e
 * notas de provas, assim como, sua media. 
 *
 * @author Gabriel Brandao
 *
 */
public class Disciplina {
	/**
	 * Nome da disciplina no formato AAAA, onde A representa o nome da mesma.
	 */
	private String nomeDisciplina;
	
	/**
	 * Horas que foram dedicadas a disciplinas. 
	 */
	private int horasEstudo;
	
	/**
	 * Um array do tipo double que armazena em cada posição o valor de cada nota.
	 * Nota1, nota2, nota3 e nota4, respectivamente. 
	 */
	private double[] notas = new double[4];
	
	/**
	 * Soma das notas da disciplina.
	 */
	private double somaNotas;
	
	/**
	 * Constroi uma disicplina a partir do seu nome.
	 * @param nomeDisciplina recebe o nome no formato String. 
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	 * A funcao nao ira retornar nada. Apenas atribui a quantidade de horas dedicadas a disciplina. 
	 * @param horas recebe as horas no formato int. 
	 */
	public void cadastraHoras(int horas) {
		this.horasEstudo = horas;
	}
	
	/**
	 * A funcao ira atribuir o valor da nota a cada posicao no array de tamanho 4.
	 * Exp: Nota1 = 7.0; Nota1 sera atribuida no espaco 0 do array e assim sucessivamente... 
	 * @param nota recebe a nota 
	 * @param valorNota recebe o valor da nota. 
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota; 	
	}
	
	/**
	 * A funcao soma todos os valores dentro array e em seguida divide por 4 e verifica 
	 * se a media é maior ou menor que 7.
	 *  
	 * @return retorna um valor do tipo boolean; Verdadeiro caso a media seja maior ou igual a 7.0. 
	 * Se a media for menor do que 7.0 retornará falso. 
	 */
	public boolean aprovado() {
		for (int i = 0; i < notas.length; i++) {
			somaNotas += notas[i];
		}
		if (somaNotas / 4 >= 7.0) {
			return true;
		}else somaNotas = 0; return false;
	}
	
	/**
	 * Retorna a String que representa a disciplina com seu nome, horas de estudo, media e os valores da nota.
	 * Formato: XXXXXX H M [N1 , N2, N3, N4], onde X representa o nome da disciplina, H representa as horas de
	 * estudo, M representa a media e N1, N2, N3 e N4 representa os valores de cada nota respectivamente.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.horasEstudo + " " + somaNotas/4 + " " + "[" + notas[0]+
		", " + notas[1] + ", " + notas[2] + ", " + notas[3] + "]";		
	}
}
