package sistema;

import Controller.ControllerCaixa;

public class Facade {
	
	private ControllerCaixa cc;

	public Facade() {
		this.cc = new ControllerCaixa();
	}
	
	public void cadastraCaixa(String descricao, String personalizacao, String formato, String dimensao) {
		this.cc.cadastraCaixa(descricao, personalizacao, formato, dimensao);
	}
	
	public void modificaPersonalizacaoCaixa(String descricao, String novaPersonalizacao) {
		this.cc.modificaPersonalizacaoCaixa(descricao, novaPersonalizacao);
	}
	
	public boolean removeCaixa(String descricao) {
		return this.cc.removeCaixa(descricao);
	}
	
	public int numeroDeCaixas() {
		return this.cc.numeroDeCaixas();
	}
	
	public String caixasPersonalizacao(String personalizacao) {
		return this.cc.caixasPersonalizacao(personalizacao);
	}
	
	public String caixasFormato(String formato) {
		return this.cc.caixasFormato(formato);
	}
	
	public double calculaPrecoCaixas() {
		return this.cc.calculaPrecoCaixas();
	}
}
