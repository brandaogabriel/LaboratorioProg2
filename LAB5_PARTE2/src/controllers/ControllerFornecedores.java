package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

import lab05.Excecoes;
import lab05.Fornecedor;

/**
 * Representacao de um controlador de fornecedor, este por sua vez eh responsavel por cadastrar, exibir, editar e remover
 * fornecedores do sistema SAGA 
 */
public class ControllerFornecedores { 
	
	/**
	 * Representacao de um mapa para clientes. A chave eh o cpf do cliente e o valor
	 * eh o objeto Cliente.
	 */
	private Excecoes valida;
	
	/**
	 * Representao de um mapa ordenado de fornecedores. A chave eh o nome do fornecedor e o valor
	 * eh o objeto Fornecedor
	 */
	private LinkedHashMap<String, Fornecedor> fornecedores;

	public ControllerFornecedores() {
		this.fornecedores = new LinkedHashMap<>();
		this.valida = new Excecoes();
	}
	
	/**
	 * O metodo cadastra um fornecedor no sistema
	 * @param nome recebe o nome do fornecedor
	 * @param email recebe o email do fornecedor
	 * @param telefone recebe o telefone do fornecedor
	 * @return Em uma operacao bem sucedida o nome do fornecedor eh retornado
	 * @throws IllegalArgumentException Se o fornecedor ja existir a excecao eh lancada
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {		
		valida.validaCadastoFornecedor(nome, email, telefone);
		if (!this.fornecedores.containsKey(nome)) {
			this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
			return nome;
		}
		throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
	}
	
	/**
	 * O metodo exibe um fornecedor cadastrado no sistema
	 * @param nome recebe o nome do fornecedor
	 * @return a representacao de um fornecedor no sistema. No formato: 'FFFF - EEEE - TTTT' onde
	 * 'F' representa o nome do fornecedor, 'E' representa o email e 'T' o telefone.
	 * @throws IllegalArgumentException Caso o fornecedor que deseja-se exibir nao exista, a excecao eh lancada
	 */
	public String exibeFornecedor(String nome) {
		if (this.fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
	}
	
	/**
	 * O metodo exibe todos os fornecedores do sistema
	 * @return todos os fornecedores cadastros no sistema. No formato: 'FFFF - EEEE - TTTT | ' onde
	 * 'F' representa o nome do fornecedor, 'E' representa o email e 'T' o telefone.
	 */
	public String exibeTodosFornecedores() {
		ArrayList<String> valores = new ArrayList<>();
		for (String f : this.fornecedores.keySet()) {
			valores.add(this.fornecedores.get(f).toString());
		}
		Collections.sort(valores);
		return String.join(" | ", valores);
	} 
	
	/**
	 * O metodo edita as informacoes de um fornecedor. As opcao de alteracao sao email ou telefone
	 * @param nome recebe o nome do fornecedor
	 * @param atributo recebe o valor no qual deseja-se altera, podendo ser 'email' ou 'telefone'.
	 * @param novoValor recebe o novo valor no qual sera alterado
	 * @throws IllegalArgumentException Se for tentado alteracao do nome do fornecedor a excecao eh lancada
	 * visto que o nome eh o identificador, dessa forma, nao pode ser alterado.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		if(atributo.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		valida.validaEditaFornecedor(atributo, novoValor);
		if(atributo.equals("email")) {
			alteraDadosEmailFornecedor(nome,novoValor);
		}
		if(atributo.equals("telefone")) {
			alteraDadosTelefoneFornecedor(nome, novoValor);
		}
	}
	
	/**
	 * O metodo altera o email de um fornecedor
	 * @param nome recebe o nome do fornecedor
	 * @param email recebe o novo email do fornecedor
	 */
	public void alteraDadosEmailFornecedor(String nome, String email) {
		if(this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).setEmail(email);
		}
	}
	
	/**
	 * O metodo altera o telefone de um fornecedor
	 * @param nome recebe o nome do fornecedor
	 * @param telefone recebe o novo telefone do fornecedor
	 */
	public void alteraDadosTelefoneFornecedor(String nome, String telefone) {
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).setTelefone(telefone);
		}
	}
	
	/**
	 * O metodo remove um fornecedor do sistema
	 * @param nome recebe o nome do fornecedor que deseja-se remover
	 * @return Em uma operacao bem sucedida a mensagem 'Fornecedor removido com sucesso' eh retornada
	 * @throws IllegalArgumentException Caso o parametro do metodo seja uma string vazia a excecao eh lancada
	 */
	public String removeFornecedor(String nome) {
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.remove(nome);
		}else throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		return "Fornecedor removido com sucesso";
	}
	
	/**
	 * O metodo retorna o mapa de fornecedores para manipulacao no ControllerProdutos.
	 * @return o mapa de fornecedores
	 */
	public LinkedHashMap<String, Fornecedor> getfornecedores() {
		return this.fornecedores;
	}
	
}