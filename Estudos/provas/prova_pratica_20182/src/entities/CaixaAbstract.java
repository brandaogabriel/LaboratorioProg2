package entities;

public abstract class CaixaAbstract implements Caixa {
	
	private String descricao;
	protected String personalizacao;
	protected String formato;
	protected double preco;
	
	public CaixaAbstract(String descricao, String personalizacao, String formato) {
		this.descricao = descricao;
		this.personalizacao = personalizacao;
		this.formato = formato;
		this.preco = 0;
	}

	public String getPersonalizacao() {
		return this.personalizacao;
	}
	
	public String getFormato() {
		return this.formato;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public void setPersonalizacao(String personalizacao) {
		this.personalizacao = personalizacao;
	}
	
	@Override
	public String toString() {
		return "Caixa com " + this.personalizacao + "custa R$ " + this.preco + ". " + this.formato + ".";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		CaixaAbstract other = (CaixaAbstract) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
}
