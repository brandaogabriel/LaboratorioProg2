package entities;

public class Pessoa {

	private String cpf;
	private Funcao funcao;
	
	public Pessoa(String cpf, int matr) {
		this.cpf = cpf;
		this.funcao = new Aluno(matr);
	}
	
	public Pessoa(String cpf, String dpto) {
		this.cpf = cpf;
		this.funcao = new Professor(dpto);
	}
	
	public String geraDetalhes() {
		return "Cpf: " + this.cpf + " " + this.funcao.geraDetalhes();
	}
	
}
