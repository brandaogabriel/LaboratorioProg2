package Controller;

import java.util.Map;
import java.util.TreeMap;

import entities.Caixa;
import entities.CaixaAbstract;
import entities.CaixaCircular;
import entities.CaixaPentagonal;
import entities.CaixaRetangular;

public class ControllerCaixa {
	
	private Map<String, Caixa> caixas;

	public ControllerCaixa() {
		this.caixas = new TreeMap<>();
	}
	
	public void cadastraCaixa(String descricao, String personalizacao, String formato, String dimensao) {
		validaDimensao(dimensao);
		if(formato.equals("pentagonal") && !this.caixas.containsKey(descricao)) {
			caixas.put(descricao, new CaixaPentagonal(descricao, personalizacao, formato, dimensao));
		}
		else if (formato.equals("retangular") && !this.caixas.containsKey(descricao)) {
			String[] lados = dimensao.split(",");
			caixas.put(descricao, new CaixaRetangular(descricao, personalizacao, formato, lados[0], lados[1]));
		}
		else if (formato.equals("circular") && !this.caixas.containsKey(descricao)) {
			caixas.put(descricao, new CaixaCircular(descricao, personalizacao, formato, dimensao));
		}	
	}
	
	private void validaDimensao(String dimensao) {
		if(dimensao.equals("") || dimensao.equals("0"))
			throw new IllegalArgumentException();
	}

	public void modificaPersonalizacaoCaixa(String descricao, String novaPersonalizacao) {
		if(this.caixas.containsKey(descricao)) {
			((CaixaAbstract) this.caixas.get(descricao)).setPersonalizacao(novaPersonalizacao);
		}
	}
	
	public boolean removeCaixa(String descricao) {
		if (this.caixas.containsKey(descricao)) {
			this.caixas.remove(descricao);
			return true;
		}return false;
	}
	
	public int numeroDeCaixas() {
		return this.caixas.size();
	}
	
	public String caixasPersonalizacao(String personalizacao) {
		String caixas = "";
		for (String c : this.caixas.keySet()) {
			if (((CaixaAbstract) this.caixas.get(c)).getPersonalizacao().equals(personalizacao)) {
				caixas += this.caixas.get(c).toString() + " ";
			}
		}
		return caixas;
	}
	
	public String caixasFormato(String formato) {
		String caixas = "";
		for (String c : this.caixas.keySet()) {
			if (((CaixaAbstract) this.caixas.get(c)).getFormato().equals(formato)) {
				caixas += this.caixas.get(c).toString() + " ";
			}
		}
		return caixas;
	}
	
	public double calculaPrecoCaixas() {
		double precoCaixas = 0;
		for (String c : this.caixas.keySet()) {
			precoCaixas += ((CaixaAbstract) this.caixas.get(c)).getPreco();
		}
		return precoCaixas;
	}
	
}
