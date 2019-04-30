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
		validaEntradaCadastro(matricula, nome, curso);
		if (!this.alunos.containsKey(matricula)) {
			Aluno a = new Aluno(matricula, nome, curso);
			alunos.put(a.getMatricula(), a);
			return true;
		}return false;
	}

	public Aluno exibeAluno(String matricula) {
		validaEntrada(matricula);
		return this.alunos.get(matricula);
	}
	
	public boolean cadastraGrupo(String nomeGrupo) {
		validaEntrada(nomeGrupo);
		if (!verificaNomeGrupo(nomeGrupo)) {
			Grupo g = new Grupo(nomeGrupo);
			grupos.put(nomeGrupo, g);
			return true;
		}
		return false;
	}
	
	public String alocaAluno(String matricula, String nomeGrupo) {
		validaAlocaAluno(matricula, nomeGrupo);
		if(!this.alunos.containsKey(matricula)) {
			return "Aluno nao cadastrado!";
		}
		if (!verificaNomeGrupo(nomeGrupo)){
			return "Grupo nao cadastrado!";
		}
		
		for (String g : this.grupos.keySet()) {
			if (g.toUpperCase().equals(nomeGrupo.toUpperCase())) {
				grupos.get(g).insereAlunoGrupo(exibeAluno(matricula));
			}
		}
		return "Aluno alocado!"; 
	}
	
	public String imprimeGrupo(String nomeGrupo) {
		validaEntrada(nomeGrupo);
		if (!verificaNomeGrupo(nomeGrupo)) {
			return "Grupo nao cadastrado!" + System.lineSeparator();
		}
		
		String inicio = grupos.get(nomeGrupo).toString();
		String aluno = "";
		for (String g : grupos.keySet()) {
			if (g.toUpperCase().equals(nomeGrupo.toUpperCase())) {
				aluno += grupos.get(g).getAlunos();
				}	
			}
		
		return inicio + System.lineSeparator() + aluno;
	}
	
	private boolean verificaNomeGrupo(String nomeGrupo) {
		for (String g : this.grupos.keySet()) {
			if (g.toUpperCase().equals(nomeGrupo.toUpperCase())) {
				return true;
			}
		}return false;
	}

	public boolean cadastraAlunoRespondeu(String matricula) {
		validaEntrada(matricula);
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
	
	private void validaEntradaCadastro(String matricula, String nome, String curso) {
		if (matricula == null || nome == null || curso == null) {
			throw new NullPointerException("Entrada nula");
		}
		if (matricula == "" || matricula.trim().equals("") || nome == "" || nome.trim().equals("") 
				|| curso == "" || curso.trim().equals("")) {
			throw new IllegalArgumentException("Entrada vazia");
		}
	}
	
	private void validaAlocaAluno(String matricula, String nomeGrupo) {
		if (matricula == null || nomeGrupo == null) {
			throw new NullPointerException("Entrada nula");
		}
		if (matricula == "" || matricula.trim().equals("") || nomeGrupo == "" 
				|| nomeGrupo.trim().equals("")) {
			throw new IllegalArgumentException("Entrada vazia");
		}
	}
	
	private void validaEntrada(String entrada) {
		if (entrada == null) {
			throw new NullPointerException("Entrada nula");
		}
		if (entrada == "" || entrada.trim().equals("")) {
			throw new IllegalArgumentException("Entrada vazia");
		}
	}
	
	
}
