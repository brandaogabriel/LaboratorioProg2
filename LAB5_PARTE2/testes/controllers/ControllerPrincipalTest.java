package controllers;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerPrincipalTest {

	
	private ControllerPrincipal cp;
	
	@BeforeEach
	void setUp() {
		this.cp = new ControllerPrincipal();
		cp.cadastraCliente("12345678911", "Gabriel", "gabriel@ccc", "splab");
		cp.cadastraCliente("12345678914", "Carlos", "carlosl@ccc", "splab");
		cp.cadastraFornecedor("Joaozinho", "joaozinho@firma", "4002-8922");
		cp.cadastraProduto("Joaozinho", "Big mac", "Big mac medio", 14.30);
		cp.cadastraProduto("Joaozinho", "Coca cola", "Coca media", 7.80);
		cp.adicionaCombo("Joaozinho", "Combo 01", "Big mac + coca-cola", 0.15, "Big mac - Big mac medio, Coca cola - Coca media");
	}
	
	
	@Test
	void testMetodosComLogica() {
		cp.adicionaCompra("12345678911", "Joaozinho", "20/05/2019", "Combo 01", "Big mac + coca-cola");
		assertEquals("18.79", cp.getDebito("12345678911", "Joaozinho"));
		assertEquals("Cliente: Gabriel | Joaozinho | Combo 01 - 20-05-2019", cp.exibeContas("12345678911", "Joaozinho"));
		
		cp.cadastraProduto("Joaozinho", "Suco", "Suco de uva", 3.50);
		cp.adicionaCompra("12345678911", "Joaozinho", "13/07/1999", "Suco", "Suco de uva");
		assertEquals("Cliente: Gabriel | Joaozinho | Combo 01 - 20-05-2019 | Suco - 13-07-1999", cp.exibeContasClientes("12345678911"));
		
		cp.realizaPagamento("12345678911", "Joaozinho");
	
	}
	
	@Test
	void testParametros() {
		try {
			cp.adicionaCompra("12345678911", "Marcos", "13/07/2025", "Combo 01", "Big mac + coca-cola");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro ao cadastrar compra: fornecedor nao existe.", iae.getMessage());
		}
		try {
			cp.adicionaCompra("12345678912", "Joaozinho", "13/07/2025", "Combo 01", "Big mac + coca-cola");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro ao cadastrar compra: cliente nao existe.", iae.getMessage());
		}
		try {
			cp.adicionaCompra("12345678911", "Joaozinho", "13/07/2025", "Combo 03", "Big mac + coca-cola");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro ao cadastrar compra: produto nao existe.", iae.getMessage());
		}
		try {
			cp.getDebito("12345678912", "Joaozinho");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro ao recuperar debito: cliente nao existe.", iae.getMessage());
		}
		try {
			cp.getDebito("12345678911", "Marcos");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro ao recuperar debito: fornecedor nao existe.", iae.getMessage());
		}
		try {
			cp.getDebito("12345678911", "Joaozinho");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro ao recuperar debito: cliente nao tem debito com fornecedor.", iae.getMessage());
		}
		try {
			cp.exibeContas("12345678912", "Joaozinho");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro ao exibir conta do cliente: cliente nao existe.", iae.getMessage());
		}
		try {
			cp.exibeContas("12345678911", "Marcos");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro ao exibir conta do cliente: fornecedor nao existe.", iae.getMessage());
		}
		try {
			cp.exibeContas("12345678911", "Joaozinho");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.", iae.getMessage());
		}
		try {
			cp.exibeContasClientes("12345678912");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro ao exibir contas do cliente: cliente nao existe.", iae.getMessage());
		}
		try {
			cp.exibeContasClientes("12345678911");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.", iae.getMessage());
		}
		try {
			cp.realizaPagamento("12345678912", "Joaozinho");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro no pagamento de conta: cliente nao existe.", iae.getMessage());
		}
		try {
			cp.realizaPagamento("12345678911", "Marcos");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro no pagamento de conta: fornecedor nao existe.", iae.getMessage());
		}
		try {
			cp.realizaPagamento("12345678914", "Joaozinho");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.", iae.getMessage());
		}
	}
	

}
