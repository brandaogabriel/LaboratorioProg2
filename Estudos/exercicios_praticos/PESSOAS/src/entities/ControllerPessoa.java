package entities;

import java.util.HashMap;
import java.util.Map;

public class ControllerPessoa {
	
	private Map<String, Pessoa> pessoas;

	public ControllerPessoa() {
		this.pessoas = new HashMap<>();
	}
	
	public void cadastraAluno(String cpf, int matricula) {
		this.pessoas.put(cpf, new Pessoa(cpf, matricula));
	}
	
	public void cadastraProfessor(String cpf, String dpto) {
		this.pessoas.put(cpf, new Pessoa(cpf, dpto));
	}
	

}
