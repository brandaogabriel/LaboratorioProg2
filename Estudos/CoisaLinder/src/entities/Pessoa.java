package entities;

public class Pessoa {
	
	private String nome;
	private int idade;
	private TipoConta tipoConta;
	private int votos;
	
	
	public Pessoa(String nome, int idade, String descricao) {
		this.nome = nome;
		this.idade = idade;
		this.tipoConta = new ContaComum(descricao);
	}
	
	public void viraPremium(String descricao) {
		this.tipoConta = new ContaPremium(descricao);
	}
	
	public void votar() {
		if(this.tipoConta instanceof ContaComum)
			votos += 1;
		else
			votos += 2;
	}
	
	public String descricao() {
		return this.nome + " - " + this.idade + " - " + this.votos + " - " + this.tipoConta.descricao();
	}
	
	public void comentar(String comentario) {
		if(this.tipoConta instanceof ContaPremium)
			((ContaPremium) this.tipoConta).comentar(comentario);
	}
}
