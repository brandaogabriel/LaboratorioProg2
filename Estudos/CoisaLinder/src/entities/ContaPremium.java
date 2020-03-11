package entities;

import java.util.ArrayList;
import java.util.List;

public class ContaPremium implements TipoConta {
	
	private String descricaoIlimitada;
	private List<String> comentarios;
	
	public ContaPremium(String descricao) {
		this.descricaoIlimitada = descricao;
		this.comentarios = new ArrayList<>();
	}

	@Override
	public String descricao() {
		return this.descricaoIlimitada;
	}
	
	public void comentar(String comentario) {
		this.comentarios.add(comentario);
	}

}
