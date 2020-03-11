package entities;

public class Aluno implements Funcao{
	
	private int matricula;
	

	public Aluno(int matricula) {
		this.matricula = matricula;
	}



	@Override
	public String geraDetalhes() {
		return "Aluno: " + this.matricula;
	}

}
