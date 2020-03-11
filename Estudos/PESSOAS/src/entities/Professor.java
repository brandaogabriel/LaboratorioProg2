package entities;

public class Professor implements Funcao{
	
	private String dpto;
	
	
	public Professor(String dpto) {
		this.dpto = dpto;
	}

	@Override
	public String geraDetalhes() {
		return "Prof " + this.dpto;
	}
	
	

}
