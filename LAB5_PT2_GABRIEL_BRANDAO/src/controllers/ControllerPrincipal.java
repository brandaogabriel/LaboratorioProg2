package controllers;

import java.util.ArrayList;
import java.util.Collections;

import entities.Excecoes;
import entities.Fornecedor;

/**
 * 
 * Representacao do Controlador principal responsavel por manipular o
 * controlador de fornecedor, controlador de cliente e controlador de produtos
 */
public class ControllerPrincipal {

	/**
	 * Representa o controlador de clientes
	 */
	private ControllerClientes cc;

	/**
	 * Representa o controlador de fornecedor
	 */
	private ControllerFornecedores cf;

	/**
	 * Representa o controlador de produtos
	 */
	private ControllerProdutos cp;

	/**
	 * Representacao de um mapa para clientes. A chave eh o cpf do cliente e o valor
	 * eh o objeto Cliente.
	 */
	private Excecoes valida;

	/**
	 * Constroi um controlador principal
	 */
	public ControllerPrincipal() {
		this.cc = new ControllerClientes();
		this.cf = new ControllerFornecedores();
		this.cp = new ControllerProdutos(cf.getfornecedores());
		this.valida = new Excecoes();
	}

	/**
	 * O metodo cadastra um cliente a partir do cpf, nome, email e localizacao
	 * 
	 * @param cpf         recebe cpf do cliente
	 * @param nome        recebe nome do cliente
	 * @param email       recebe email do cliente
	 * @param localizacao recebe a localizacao do cliente
	 * @return cpf do cliente
	 */
	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		return cc.cadastraCliente(cpf, nome, email, localizacao);
	}

	/**
	 * O metodo exibe um cliente a partir do seu cpf
	 * 
	 * @param cpf recebe o cpf do cliente
	 * @return se o cpf existir sera retornado o cliente solicitado, no formato
	 *         NNNNN - LLLLLL - EEEEE, onde 'N' representa o nome do cliente, 'L'
	 *         representa a localizacao do cliente e 'E' representa o email do
	 *         cliente
	 */
	public String exibeCliente(String cpf) {
		return cc.exibeCliente(cpf);
	}

	/**
	 * O metodo exibe todos clientes cadastrados
	 * 
	 * @return todos os clientes cadastrados
	 */
	public String exibeTodos() {
		return cc.exibeTodos();
	}

	/**
	 * O metodo altera informacoes de um cliente
	 * 
	 * @param cpf       recebe o cpf do cliente
	 * @param atributo  recebe como parametro 'nome', 'email' ou 'localizacao'.
	 *                  Unicos possiveis de alterar
	 * @param novoValor recebe o novo nome, email ou localizacao para o cliente
	 *                  solicitado.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		cc.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * O metodo remove um cliente cadastrado a partir do seu cpf
	 * 
	 * @param cpf o cpf do cliente
	 * @return se a remocao for bem sucedida a mensagem 'Cliente removido' eh
	 *         retornada. Se o cliente que deseja-se remover nao exista, a mensagem
	 *         'Cliente nao cadastrado' eh retornada
	 */
	public String removeCliente(String cpf) {
		return cc.removeCliente(cpf);
	}

	/**
	 * O metodo cadastra um fornecedor no sistema
	 * 
	 * @param nome     recebe o nome do fornecedor
	 * @param email    recebe o email do fornecedor
	 * @param telefone recebe o telefone do fornecedor
	 * @return Em uma operacao bem sucedida o nome do fornecedor eh retornado
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		return cf.cadastraFornecedor(nome, email, telefone);
	}

	/**
	 * O metodo exibe um fornecedor cadastrado no sistema
	 * 
	 * @param nome recebe o nome do fornecedor
	 * @return a representacao de um fornecedor no sistema. No formato: 'FFFF - EEEE
	 *         - TTTT' onde 'F' representa o nome do fornecedor, 'E' representa o
	 *         email e 'T' o telefone.
	 */
	public String exibeFornecedor(String nome) {
		return cf.exibeFornecedor(nome);
	}

	/**
	 * O metodo exibe todos os fornecedores do sistema
	 * 
	 * @return todos os fornecedores cadastros no sistema. No formato: 'FFFF - EEEE
	 *         - TTTT | ' onde 'F' representa o nome do fornecedor, 'E' representa o
	 *         email e 'T' o telefone.
	 */
	public String exibeTodosFornecedores() {
		return cf.exibeTodosFornecedores();
	}

	/**
	 * O metodo edita as informacoes de um fornecedor. As opcao de alteracao sao
	 * email ou telefone
	 * 
	 * @param nome      recebe o nome do fornecedor
	 * @param atributo  recebe o valor no qual deseja-se altera, podendo ser 'email'
	 *                  ou 'telefone'.
	 * @param novoValor recebe o novo valor no qual sera alterado
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		cf.editaFornecedor(nome, atributo, novoValor);
	}

	/**
	 * O metodo remove um fornecedor do sistema
	 * 
	 * @param nome recebe o nome do fornecedor que deseja-se remover
	 * @return Em uma operacao bem sucedida a mensagem 'Fornecedor removido com
	 *         sucesso' eh retornada
	 */
	public String removeFornecedor(String nome) {
		return cf.removeFornecedor(nome);
	}

	/**
	 * O metodo cadastra um produto para um fornecedor
	 * 
	 * @param nomeFornecedor recebe o nome de um fornecedo
	 * @param nomeProduto    recebe o nome do produto que deseja cadastrar
	 * @param desc           recebe a descricao do produto que deseja cadastrar
	 * @param preco          recebe o preco do produto
	 * @return Caso a operacao seja bem sucedida a mensagem 'Produto cadastrado com
	 *         sucesso' eh retornada
	 */
	public String cadastraProduto(String nomeFornecedor, String nomeProduto, String desc, double preco) {
		return cp.cadastraProduto(nomeFornecedor, nomeProduto, desc, preco);
	}

	/**
	 * O metodo exibe o produto de um fornecedor cadastrado no sistema
	 * 
	 * @param nome       recebe o nome do produto
	 * @param descricao  recebe a descricao do produto
	 * @param fornecedor recebe o nome do fornecedor que contem o produto
	 * @return Em uma operacao bem sucedida eh retornada em formato String 'NNNN -
	 *         DDDD - R$PP.PP', onde 'N' representa o nome do produto, 'D'
	 *         representa a descricao do produto e 'P' representa o preco do produto
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return cp.exibeProduto(nome, descricao, fornecedor);
	}

	/**
	 * O metodo exibe todos os produtos de um fornecedor cadastrado
	 * 
	 * @param nomeFornecedor recebe o nome do fornecedor
	 * @return Em uma operacao bem sucedida eh retornado no formato String o
	 *         fornecedor e seus produtos, no formato: 'FFFF - NNNN - DDDD - R$PP.PP
	 *         | . Onde 'F' representa o nome do fornecedor, 'N' o nome do produto,
	 *         'D' a descricao do produto, 'P' o preco do produto.
	 */
	public String exibeProdutosUmFornecedor(String nomeFornecedor) {
		return cp.exibeProdutosUmFornecedor(nomeFornecedor);
	}

	/**
	 * O metodo exibe todos os fornecedores e seus produtos cadastrados no sistema.
	 * 
	 * @return todos os fornecedores e seus produtos no formato String: 'FFFF - NNNN
	 *         - DDDD - R$PP.PP | . Onde 'F' representa o nome do fornecedor, 'N' o
	 *         nome do produto, 'D' a descricao do produto, 'P' o preco do produto.
	 */
	public String exibeProdutosFornecedores() {
		return cp.exibeProdutosFornecedores();
	}

	/**
	 * O metodo altera o preco de um produto em especifico
	 * 
	 * @param nome       recebe o nome do produto que deseja-se mudar o preco
	 * @param descricao  recebe a descricao do produto
	 * @param fornecedor recebe o nome do fornecedor que possui o produto
	 * @param novoPreco  recebeo o novo preco do produto
	 * @return Em uma operacao bem sucedida a mensagem 'Preco alterado com sucesso'
	 *         eh retornada. Caso o produto nao esteja cadastrado no sistema eh
	 *         retornado 'Produto nao cadastro'
	 */
	public String alteraPrecoProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		return cp.alteraPrecoProduto(nome, descricao, fornecedor, novoPreco);
	}

	/**
	 * O metodo remove o produto de um fornecedor do sistema.
	 * 
	 * @param nome       recebe o nome do produto que deseja-se remover
	 * @param descricao  recebe a descricao do produto
	 * @param fornecedor recebe o nome do fornecedor
	 * @return Em uma operacao bem sucedida eh retornado a mensagem 'Produto
	 *         removido com sucesso'
	 */
	public String removeProduto(String nome, String descricao, String fornecedor) {
		return cp.removeProduto(nome, descricao, fornecedor);
	}

	/**
	 * O metodo adiciona um combo a lista de produtos de um fornecedor. Um combo eh
	 * composto por dois ou mais produtos simples.
	 * 
	 * @param fornecedor recebe o nome do fornecedor
	 * @param nome       recebe o nome do combo
	 * @param descricao  recebe a descricao do combo
	 * @param fator      recebe o fator que sera utilizado para calculo do preco do
	 *                   combo
	 * @param produtos   recebe os produtos simples que irao compor o combo
	 */
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		cp.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}

	/**
	 * O metodo edita o fator de um combo existe
	 * 
	 * @param nome       recebe o nome do combo
	 * @param descricao  recebe a descricao do combo
	 * @param fornecedor recebe o nome do fornecedor que possui o combo
	 * @param novoFator  recebe o novo fator do combo
	 */
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		cp.editaCombo(nome, descricao, fornecedor, novoFator);
	}

	/**
	 * O metodo adiciona a compra de um cliente a um determinado fornecedor
	 * 
	 * @param cpf        recebe o cpf do cliente
	 * @param fornecedor recebe o nome do fornecedor
	 * @param data       recebe a data da compra do produto
	 * @param nome_prod  recebe o nome do produto
	 * @param desc_prod  recebe a descricao do produto
	 * @throws IllegalArgumentException Caso o fornecedor nao exista, o cliente nao
	 *                                  exista ou o produto nao exista, a excessao
	 *                                  eh lancada
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		valida.validaString(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		valida.validaString(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		valida.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		valida.validaData(data, "Erro ao cadastrar compra: data invalida.");
		valida.validaString(nome_prod, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		valida.validaString(desc_prod, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		valida.validaCpf(cpf, "Erro ao cadastrar compra: cpf invalido.");
		if (!this.cf.getfornecedores().containsKey(fornecedor))
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		if (!this.cc.getClientes().containsKey(cpf))
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		if (!this.cf.getfornecedores().get(fornecedor).verificaIgual(nome_prod, desc_prod))
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		if (!this.cf.getfornecedores().get(fornecedor).getContaCliente().containsKey(cpf))
			this.cf.getfornecedores().get(fornecedor).criaConta(cpf);
		this.cf.getfornecedores().get(fornecedor).insereProdutoNaConta(cpf, data, nome_prod, desc_prod);
	}

	/**
	 * O metodo retorna o debito de um cliente para um determinado fornecedor
	 * 
	 * @param cpf        recebe o cpf do cliente
	 * @param fornecedor recebe o nome do fornecedor
	 * @return debito do cliente para um determinado fornecedor
	 * @throws IllegalArgumentException Caso o cliente nao exista, o fornecedor nao
	 *                                  exista ou o cliente nao tenha debito com o
	 *                                  fornecedor, a excessao eh lancada
	 */
	public String getDebito(String cpf, String fornecedor) {
		valida.validaString(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		valida.validaCpf(cpf, "Erro ao recuperar debito: cpf invalido.");
		valida.validaString(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		if (!this.cc.getClientes().containsKey(cpf))
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		if (!this.cf.getfornecedores().containsKey(fornecedor))
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		if (!this.cf.getfornecedores().get(fornecedor).verificaSeTemConta(cpf))
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		return this.cf.getfornecedores().get(fornecedor).pegaValorDaConta(cpf);
	}

	/**
	 * O metodo exibe as contas de um cliente para um determinado fornecedor
	 * 
	 * @param cpf        recebe o cpf do cliente
	 * @param fornecedor recebe o nome do cliente
	 * @return a conta de um cliente para um determinado fornecedor, no formato:
	 *         CCCCC | FFFFF | PPPPP - DD-MM-YYYY, Onde 'C' representa o nome de um
	 *         cliente, 'F' representa o nome de um fornecedor, 'P' representa o
	 *         nome do produto, 'D' dia, 'M' mes e 'Y' ano da compra.
	 * @throws IllegalArgumentException Caso o cliente nao exista, o fornecedor nao
	 *                                  exista ou o cliente nao possua conta com o
	 *                                  fornecedor, a excessao eh lancada
	 */
	public String exibeContas(String cpf, String fornecedor) {
		valida.validaString(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		valida.validaCpf(cpf, "Erro ao exibir conta do cliente: cpf invalido.");
		valida.validaString(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		if (!this.cc.getClientes().containsKey(cpf))
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		if (!this.cf.getfornecedores().containsKey(fornecedor))
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		if (!this.cf.getfornecedores().get(fornecedor).verificaSeTemConta(cpf))
			throw new IllegalArgumentException(
					"Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");

		return "Cliente: " + this.cc.getClientes().get(cpf).getNome() + " | "
				+ this.cf.getfornecedores().get(fornecedor).exibeContas(cpf);
	}

	/**
	 * O metodo exibe todas as contas de um determinado cliente
	 * 
	 * @param cpf recebe o cpf do cliente
	 * @return todas as contas de um cliente, no formato CCCCC | FFFFF | PPPPP -
	 *         DD-MM-YYYY, Onde 'C' representa o nome de um cliente, 'F' representa
	 *         o nome de um fornecedor, 'P' representa o nome do produto, 'D' dia,
	 *         'M' mes e 'Y' ano da compra.
	 * @throws IllegalArgumentException Caso o cliente nao exista ou nao possua
	 *                                  nenhuma conta, a excessao eh lancada
	 */
	public String exibeContasClientes(String cpf) {
		valida.validaString(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		valida.validaCpf(cpf, "Erro ao exibir contas do cliente: cpf invalido.");
		boolean possuiConta = false;

		if (!this.cc.getClientes().containsKey(cpf))
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");

		String conta = "";
		ArrayList<Fornecedor> fornecedores = new ArrayList<>(this.cf.getfornecedores().values());
		Collections.sort(fornecedores);
		for (Fornecedor f : fornecedores) {
			if (f.verificaSeTemConta(cpf)) {
				conta += f.exibeContas(cpf) + " | ";
				possuiConta = true;
			}
		}
		if (!possuiConta)
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		String msg = "Cliente: " + this.cc.getClientes().get(cpf).getNome() + " | " + conta;
		return msg.substring(0, msg.length() - 3);
	}

	/**
	 * O metodo realiza o pagamento da conta de um cliente para um determinado
	 * fornecedor
	 * 
	 * @param cpf        recebe o cpf do cliente
	 * @param fornecedor recebe o nome do fornecedor
	 * @throws IllegalArgumentException Caso o cliente nao exista, o fornecedor nao
	 *                                  exista ou o cliente nao possua debito com o
	 *                                  fornecedor, a excessao eh lancada
	 */
	public void realizaPagamento(String cpf, String fornecedor) {
		valida.validaString(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		valida.validaCpf(cpf, "Erro no pagamento de conta: cpf invalido.");
		valida.validaString(fornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		if (!this.cc.getClientes().containsKey(cpf))
			throw new IllegalArgumentException("Erro no pagamento de conta: cliente nao existe.");
		if (!this.cf.getfornecedores().containsKey(fornecedor))
			throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao existe.");
		if (!this.cf.getfornecedores().get(fornecedor).verificaSeTemConta(cpf))
			throw new IllegalArgumentException(
					"Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		this.cf.getfornecedores().get(fornecedor).realizaPagamento(cpf);
	}

}