package lab04;


import java.util.HashSet;

public class Grupo {
	
	private String nomeGrupo;
	private HashSet<Aluno> aluno;
	
	public Grupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
		this.aluno = new HashSet<>();
	}
	
	public void insereAlunoGrupo(Aluno a) {
		aluno.add(a);
	}
	
	public String getAlunos() {
		String turminha = "";
		for (Aluno a : aluno) {
			turminha += "* " + a + System.lineSeparator();
		}	
		return turminha;
		
	}
	
	public String toString() {
		return "Alunos do grupo " + this.nomeGrupo + ":";
	}
	
}
