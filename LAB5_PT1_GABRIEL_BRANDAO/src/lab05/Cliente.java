package lab05;

public class Cliente {
	
	 private String cpf;
	 private String nome;
	 private String email;
	 private String localizacao;
	 private Excecoes valida;
	
	 public Cliente(String cpf, String nome, String email, String localizacao){
		this.valida = new Excecoes();
		valida.validaEntrada(cpf);
		valida.validaEntrada(nome);
		valida.validaEntrada(email);
		valida.validaEntrada(localizacao);
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}
	
	 public String getCpf() {
		 return this.cpf;
	 }
	 
	 public void setNome(String nome) {
		 valida.validaEntrada(nome);
		 this.nome = nome;
	 }
	 
	 public void setEmail(String email) {
		 valida.validaEntrada(email);
		 this.email = email;
	 }
	 
	 public void setLocalizacao(String localizacao) {
		 valida.validaEntrada(localizacao);
		 this.localizacao = localizacao;
	 }
	 
	 @Override
	 public String toString() {
		 return this.nome + " - " + this.email + " - " + this.localizacao; 
	 }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	 
	 
	 
}
