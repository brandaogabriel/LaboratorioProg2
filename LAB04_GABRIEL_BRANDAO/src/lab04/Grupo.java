package lab04;


import java.util.HashSet;

public class Grupo {
	
	private String nomeGrupo;
	private HashSet<Aluno> alunos;
	
	public Grupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
		this.alunos = new HashSet<>();
	}
	
	public String getnomeGrupo() {
		return this.nomeGrupo;
	}
	
	public String toString() {
		return "Grupo: " + getnomeGrupo();
	}
	
}
