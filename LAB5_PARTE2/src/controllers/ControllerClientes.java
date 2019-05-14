package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import lab05.Cliente;
import lab05.Excecoes;

/**
 * Representacao de um controle de cliente. A classe eh responsavel por
 * cadastrar um cliente, exibir um cliente, exibir todos os clientes cadastrados, editar os dados
 * de um cliente e remover um cliente do sistema.  
 */


public class ControllerClientes {
	
	 /**
	  * Representa um conjunto de metodos do tipo Excecoes para realizar validacao
	  * de dados de entrada
	  */
	private Excecoes valida;
	
	/**
	 * Representacao de um mapa para clientes. A chave eh o cpf do cliente e o valor
	 * eh o objeto Cliente.
	 */
	private HashMap<String , Cliente> clientes;

	/**
	 * Constroi um controlador de clientes. 
	 */
	public ControllerClientes() {
		this.clientes = new HashMap<>();
		this.valida = new Excecoes();
	}
	
	/**
	 * O metodo eh responsavel por cadastrar um cliente
	 * @param cpf recebe o cpf do cliente
	 * @param nome recebe o nome do cliente
	 * @param email recebe o email do cliente
	 * @param localizacao recebe a localizacao do cliente
	 * @return em uma operacao bem sucedida retorna o cpf do cliente cadastrado
	 * @throws IllegalArgumentException se tentar cadastrar um cliente que ja existe a
	 * excecao eh lancada
	 */
	public String cadastraCliente(String cpf, String nome, String email, String localizacao){
		valida.validaCadastroCliente(cpf, nome, email, localizacao);
		if(!this.clientes.containsKey(cpf)) {
			clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
			return cpf;			
			}
		throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
	}
	
	/**
	 * O metodo exibe um cliente a partir do seu cpf
	 * @param cpf recebe o cpf do cliente
	 * @return se o cpf existir sera retornado o cliente solicitado, no formato
	 * NNNNN - LLLLLL - EEEEE, onde 'N' representa o nome do cliente, 'L' representa a
	 * localizacao do cliente e 'E' representa o email do cliente
	 * @throws IllegalArgumentException se o cliente solicitado nao existir, a excecao
	 * eh lancada
	 */
	public String exibeCliente(String cpf) {
		if (clientes.containsKey(cpf)) {
			return clientes.get(cpf).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
	}
	
	/**
	 * O metodo exibe todos clientes cadastrados
	 * @return todos os clientes cadastrados
	 */
	public String exibeTodos() {
		ArrayList<String> valores = new ArrayList<>();
		for (String c : this.clientes.keySet()) {
			valores.add(this.clientes.get(c).toString());
		}
		Collections.sort(valores);
		return String.join(" | ", valores);
	}
	
	/**
	 * O metodo altera informacoes de um cliente
	 * @param cpf recebe o cpf do cliente
	 * @param atributo recebe como parametro 'nome', 'email' ou 'localizacao'. Unicos possiveis de alterar
	 * @param novoValor recebe o novo nome, email ou localizacao para o cliente solicitado.
	 * @throws IllegalArgumentException caso o cliente nao esteja cadastrado eh lancada
	 * a excecao
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
		valida.validaEditaCliente(atributo, novoValor);
		if (atributo.equals("nome")) {
			alteraDadosNome(cpf, novoValor);
		}
		if (atributo.equals("email")) {
			alteraDadosEmail(cpf, novoValor);
		}
		if(atributo.equals("localizacao")) {
			alteraDadosLocalizacao(cpf, novoValor);
		}
	}
	
	/**
	 * O metodo altera o nome do cliente
	 * @param cpf recebe o cpf do cliente 
	 * @param nome recebe o novo nome para o cliente
	 */
	public void alteraDadosNome(String cpf, String nome) {
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setNome(nome);
		}
	}
	
	/**
	 * O metodo altera o email do cliente
	 * @param cpf recebe o cpf do cliente
	 * @param email recebe o novo email para o cliente
	 */
	public void alteraDadosEmail(String cpf, String email) {
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setEmail(email);;
			
		}
	}
	
	/**
	 * O metodo altera a localizacao de um cliente
	 * @param cpf recebe o cpf do cliente
	 * @param localizacao recebe a nova localizacao para o cliente
	 */
	public void alteraDadosLocalizacao(String cpf, String localizacao) {	
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).setLocalizacao(localizacao);
		}
	}
	
	/**
	 * O metodo remove um cliente cadastrado a partir do seu cpf
	 * @param cpf o cpf do cliente
	 * @return se a remocao for bem sucedida a mensagem 'Cliente removido' eh retornada.
	 * Se o cliente que deseja-se remover nao exista, a mensagem 'Cliente nao cadastrado' eh
	 * retornada
	 */
	public String removeCliente(String cpf) {
		if (this.clientes.containsKey(cpf)) {
			this.clientes.remove(cpf);
			return "Cliente removido";
		}return "Cliente nao cadastrado";
	}
	
}
