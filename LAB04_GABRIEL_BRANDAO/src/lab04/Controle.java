package lab04;

import java.util.ArrayList;
import java.util.HashMap;


public class Controle {
	
	private HashMap<String, Aluno> alunos;
	private HashMap<String, Grupo> grupos;
	private ArrayList<String> alunosResponderam; 
	
	
	public Controle() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunosResponderam = new ArrayList<>();
	}
	
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		verificaEntradas(matricula, nome, curso);
		if (!this.alunos.containsKey(matricula)) {
			Aluno a = new Aluno(matricula, nome, curso);
			alunos.put(a.getMatricula(), a);
			return true;
		}return false;
	}

	public Aluno exibeAluno(String matricula) {
		return this.alunos.get(matricula);
	}
	
	public boolean cadastraGrupo(String nomeGrupo) {
		if (!verificaNomeGrupo(nomeGrupo)) {
			Grupo g = new Grupo(nomeGrupo);
			grupos.put(nomeGrupo, g);
			System.out.println(grupos);
			return true;
		}
		return false;
	}
	
	// PAREI AQUI //
	public String alocaAluno(String matricula, String nomeGrupo) {
		if(!this.alunos.containsKey(matricula)) {
			return "Aluno nao cadastrado!";
		}
		if (!verificaNomeGrupo(nomeGrupo)){
			return "Grupo não cadastrado!";
		}
		return "Aluno alocado!"; 
	}
	
	private boolean verificaNomeGrupo(String nomeGrupo) {
		for (String g : this.grupos.keySet()) {
			if (g.toUpperCase().equals(nomeGrupo.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	public boolean cadastraAlunoRespondeu(String matricula) {
		boolean result = false;
		if (this.alunos.containsKey(matricula)) {
			alunosResponderam.add(matricula);
			result = true;
		}return result;
	}
	
	public String exibeAlunosRespondeu() {
		String entry = "Alunos: " + System.lineSeparator();
		String quemRespondeu = "";
		int contador = 1;
		for (int i = 0; i < alunosResponderam.size(); i ++) {
			if(this.alunos.containsKey(alunosResponderam.get(i))) {
				quemRespondeu += contador + ". " + exibeAluno(alunosResponderam.get(i)) + System.lineSeparator();
			}contador +=1;
		}return entry + quemRespondeu;
		
	}
	
	private void verificaEntradas(String matricula, String nome, String curso) {
		if (matricula == null || nome == null || curso == null) {
			throw new NullPointerException("Entrada nula");
		}
		if (matricula == "" || matricula.trim().equals("") || nome == "" || nome.trim().equals("") || curso == "" || curso.trim().equals("")) {
			throw new IllegalArgumentException("Entrada vazia");
		}
	}
	
	
}
