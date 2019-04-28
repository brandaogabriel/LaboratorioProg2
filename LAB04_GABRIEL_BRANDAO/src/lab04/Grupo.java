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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}
	
}
