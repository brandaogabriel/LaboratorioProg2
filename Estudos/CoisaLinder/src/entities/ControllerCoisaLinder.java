package entities;

import java.util.HashMap;
import java.util.Map;

public class ControllerCoisaLinder {

	private Map<String, Pessoa> pessoas;

	public ControllerCoisaLinder() {
		this.pessoas = new HashMap<>();
	}
	
	public void cadastraContaComum(String nome, int idade, String descricao) {
		this.pessoas.put(nome, new Pessoa(nome, idade, descricao));
	}
	
	public void virarPremium(String nome, String descricao) {
		this.pessoas.get(nome).viraPremium(descricao);
	}
	
	public void votar(String nome) {
		this.pessoas.get(nome).votar();
	}
	
	public void comentar(String nome, String comentario) {
		this.pessoas.get(nome).comentar(comentario);
	}
}
