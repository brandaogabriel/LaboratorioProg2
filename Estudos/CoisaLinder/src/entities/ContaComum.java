package entities;

public class ContaComum implements TipoConta{

	private String descricaoLimitada;
	
	
	public ContaComum(String descricao) {
		this.descricaoLimitada = descricao.substring(0, 139);
	}

	@Override
	public String descricao() {
		return this.descricaoLimitada;
	}

}
