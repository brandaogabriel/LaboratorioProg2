package controllers;

import java.util.ArrayList;
import java.util.Collections;

import entities.Excecoes;
import entities.Fornecedor;

public class ControllerPrincipal {

	private ControllerClientes cc;
	private ControllerFornecedores cf;
	private ControllerProdutos cp;
	private Excecoes valida;

	public ControllerPrincipal() {
		this.cc = new ControllerClientes();
		this.cf = new ControllerFornecedores();
		this.cp = new ControllerProdutos(cf.getfornecedores());
		this.valida = new Excecoes();
	}

	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		return cc.cadastraCliente(cpf, nome, email, localizacao);
	}

	public String exibeCliente(String cpf) {
		return cc.exibeCliente(cpf);
	}

	public String exibeTodos() {
		return cc.exibeTodos();
	}

	public void editaCliente(String cpf, String atributo, String novoValor) {
		cc.editaCliente(cpf, atributo, novoValor);
	}

	public void alteraDadosNome(String cpf, String nome) {
		cc.alteraDadosNome(cpf, nome);
	}

	public void alteraDadosEmail(String cpf, String email) {
		cc.alteraDadosEmail(cpf, email);
	}

	public void alteraDadosLocalizacao(String cpf, String localizacao) {
		cc.alteraDadosLocalizacao(cpf, localizacao);
	}

	public String removeCliente(String cpf) {
		return cc.removeCliente(cpf);
	}

	public String cadastraFornecedor(String nome, String email, String telefone) {
		return cf.cadastraFornecedor(nome, email, telefone);
	}

	public String exibeFornecedor(String nome) {
		return cf.exibeFornecedor(nome);
	}

	public String exibeTodosFornecedores() {
		return cf.exibeTodosFornecedores();
	}

	public void editaFornecedor(String nome, String atributo, String novoValor) {
		cf.editaFornecedor(nome, atributo, novoValor);
	}

	public void alteraDadosEmailFornecedor(String nome, String email) {
		cf.alteraDadosEmailFornecedor(nome, email);
	}

	public void alteraDadosTelefoneFornecedor(String nome, String telefone) {
		cf.alteraDadosTelefoneFornecedor(nome, telefone);
	}

	public String removeFornecedor(String nome) {
		return cf.removeFornecedor(nome);
	}

	public String cadastraProduto(String nomeFornecedor, String nomeProduto, String desc, double preco) {
		return cp.cadastraProduto(nomeFornecedor, nomeProduto, desc, preco);
	}

	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return cp.exibeProduto(nome, descricao, fornecedor);
	}

	public String exibeProdutosUmFornecedor(String nomeFornecedor) {
		return cp.exibeProdutosUmFornecedor(nomeFornecedor);
	}

	public String exibeProdutosFornecedores() {
		return cp.exibeProdutosFornecedores();
	}

	public String alteraPrecoProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		return cp.alteraPrecoProduto(nome, descricao, fornecedor, novoPreco);
	}

	public String removeProduto(String nome, String descricao, String fornecedor) {
		return cp.removeProduto(nome, descricao, fornecedor);
	}

	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		cp.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}

	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		cp.editaCombo(nome, descricao, fornecedor, novoFator);
	}

	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		valida.validaString(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		valida.validaString(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		valida.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		valida.validaData(data, "Erro ao cadastrar compra: data invalida.");
		valida.validaString(nome_prod,"Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		valida.validaString(desc_prod, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		valida.validaCpf(cpf, "Erro ao cadastrar compra: cpf invalido.");
		if (!this.cf.getfornecedores().containsKey(fornecedor))
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		if (!this.cc.getClientes().containsKey(cpf))
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		if(!this.cf.getfornecedores().get(fornecedor).verificaIgual(nome_prod, desc_prod))
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		if (!this.cf.getfornecedores().get(fornecedor).getContaCliente().containsKey(cpf))
			this.cf.getfornecedores().get(fornecedor).criaConta(cpf);
		this.cf.getfornecedores().get(fornecedor).insereProdutoNaConta(cpf, data, nome_prod, desc_prod);
	}
	
	public String getDebito(String cpf, String fornecedor) {
		valida.validaString(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		valida.validaCpf(cpf, "Erro ao recuperar debito: cpf invalido.");
		valida.validaString(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		if(!this.cc.getClientes().containsKey(cpf))
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		if(!this.cf.getfornecedores().containsKey(fornecedor))
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		if(!this.cf.getfornecedores().get(fornecedor).verificaSeTemConta(cpf)) 
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		return this.cf.getfornecedores().get(fornecedor).pegaValorDaConta(cpf);
	}
	
	public String exibeContas(String cpf, String fornecedor) {
		valida.validaString(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		valida.validaCpf(cpf, "Erro ao exibir conta do cliente: cpf invalido.");
		valida.validaString(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		if(!this.cc.getClientes().containsKey(cpf))
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		if(!this.cf.getfornecedores().containsKey(fornecedor))
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		if(!this.cf.getfornecedores().get(fornecedor).verificaSeTemConta(cpf)) 
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		
		return "Cliente: " + this.cc.getClientes().get(cpf).getNome() + " | " + this.cf.getfornecedores().get(fornecedor).exibeContas(cpf);
	}
	
	public String exibeContasClientes(String cpf) {
		valida.validaString(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		valida.validaCpf(cpf, "Erro ao exibir contas do cliente: cpf invalido.");
		boolean possuiConta = false;
		
		if(!this.cc.getClientes().containsKey(cpf))
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		
		String conta = "";
		ArrayList<Fornecedor> fornecedores = new ArrayList<>(this.cf.getfornecedores().values());	
		Collections.sort(fornecedores);
		for(Fornecedor f : fornecedores) {
			if(f.verificaSeTemConta(cpf)) {
				conta += f.exibeContas(cpf) + " | ";
				possuiConta = true;
			}			
		}	
		if(!possuiConta)
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		
		String msg = "Cliente: " + this.cc.getClientes().get(cpf).getNome() + " | "  + conta;
		return msg.substring(0, msg.length() - 3);
	}
	
	public void realizaPagamento(String cpf, String fornecedor) {
		valida.validaString(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		valida.validaCpf(cpf, "Erro no pagamento de conta: cpf invalido.");
		valida.validaString(fornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		if(!this.cc.getClientes().containsKey(cpf))
			throw new IllegalArgumentException("Erro no pagamento de conta: cliente nao existe.");
		if(!this.cf.getfornecedores().containsKey(fornecedor))
			throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao existe.");
		if(!this.cf.getfornecedores().get(fornecedor).verificaSeTemConta(cpf)) 
			throw new IllegalArgumentException("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		this.cf.getfornecedores().get(fornecedor).realizaPagamento(cpf);
	}
	
}