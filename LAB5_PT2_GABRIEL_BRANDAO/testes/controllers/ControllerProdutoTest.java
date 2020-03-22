package controllers;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ControllerProdutoTest {

	private ControllerProdutos p1;
	private ControllerFornecedores f1;
	
	@BeforeEach
	void setUp() {
		this.f1 = new ControllerFornecedores();
		this.p1 = new ControllerProdutos(this.f1.getfornecedores());
		f1.cadastraFornecedor("Gabriel", "gabriel@ccc.ufcg.edu.br", "4002-8922");
		p1.cadastraProduto("Gabriel", "Leite", "Leite com pera", 10.50);
		p1.cadastraProduto("Gabriel", "Suco", "Suco de uva", 3.50);
	}
	
	@Test
	void testCadastraProduto() {
		assertEquals("Produto cadastrado com sucesso", p1.cadastraProduto("Gabriel", "Manga", "Leite com manga", 3.30));
	}
	
	@Test
	void testExibeProduto() {
		assertEquals("Leite - Leite com pera - R$10,50", p1.exibeProduto("Leite", "Leite com pera", "Gabriel"));
	}
	
	@Test
	void testExibeProdutosUmFornecedor() {
		assertEquals("Gabriel - Leite - Leite com pera - R$10,50 | Gabriel - Suco - Suco de uva - R$3,50", p1.exibeProdutosUmFornecedor("Gabriel"));
	}
	
	@Test
	void testExibeProdutosFornecedores() {
		f1.cadastraFornecedor("Marcinho", "marcinho@dapenha", "6666-7777");
		p1.cadastraProduto("Marcinho", "Maconha", "Maconha com reefil", 55.10);
		assertEquals("Gabriel - Leite - Leite com pera - R$10,50 | Gabriel - Suco - Suco de uva - R$3,50 | Marcinho - Maconha - Maconha com reefil - R$55,10", p1.exibeProdutosFornecedores());
	}
	
	@Test
	void testAlteraPrecoProduto() {
		assertEquals("Preco alterado com sucesso", p1.alteraPrecoProduto("Leite", "Leite com pera", "Gabriel", 7.37));
		assertEquals("Produto nao cadastrado", p1.alteraPrecoProduto("Cafe", "Cafe com leite", "Gabriel", 0.80));
	}
	
	@Test
	void testRemoveProduto() {
		assertEquals("Produto removido com sucesso", p1.removeProduto("Leite", "Leite com pera", "Gabriel"));
	}
	
	@Test
	void testAdicionaComboEEditaCombo() {
		p1.adicionaCombo("Gabriel", "Suco e leite", "Suco de uva com leite", 0.23, "Leite - Leite com pera, Suco - Suco de uva");
		p1.editaCombo("Suco e leite", "Suco de uva com leite", "Gabriel", 0.43);
	}
	
	
	@Test
	void testEntradasVazias() {
		try {
			p1.cadastraProduto("", "Uva", "Uva roxa", 0.10);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.cadastraProduto("Marcos", "Uva", "Uva roxa", 0.10);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: fornecedor nao existe.", iae.getMessage());
		}
		try {
			p1.cadastraProduto("Gabriel", "Leite", "Leite com pera", 0.10);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: produto ja existe.", iae.getMessage());
		}
		try {
			p1.cadastraProduto("Gabriel", "", "Leite com pera", 4.30);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.cadastraProduto("Gabriel", "Leite", "", 4.30);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			p1.cadastraProduto("Gabriel", "Leite", "Leite com pera", -4.21);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: preco invalido.", iae.getMessage());
		}
		try {
			p1.exibeProduto("Leite", "Leite com pera", "Nascimento");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na exibicao de produto: fornecedor nao existe.", iae.getMessage());
		}
		try {
			p1.exibeProduto("Leite", "Leite sem pera", "Gabriel");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na exibicao de produto: produto nao existe.", iae.getMessage());
		}
		try {
			p1.exibeProduto("", "Leite sem pera", "Gabriel");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.exibeProduto("Leite", "", "Gabriel");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			p1.exibeProduto("Leite", "Leite sem pera", "");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.exibeProdutosUmFornecedor("");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.exibeProdutosUmFornecedor("Max Brandon");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na exibicao de produto: fornecedor nao existe.", iae.getMessage());
		}
		try {
			p1.alteraPrecoProduto("Leite", "Leite com pera", "Neymar", 2.21);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao de produto: fornecedor nao existe.", iae.getMessage());
		}
		try {
			p1.alteraPrecoProduto("", "Leite com pera", "Gabriel", 1.00);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.alteraPrecoProduto("Leite", "", "Gabriel", 1.00);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			p1.alteraPrecoProduto("Leite", "Leite com pera", "", 1.00);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.alteraPrecoProduto("Leite", "Leite com pera", "Gabriel", -1.00);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao de produto: preco invalido.", iae.getMessage());
		}
		try {
			p1.removeProduto("Leite", "Leite com pera", "Abel");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na remocao de produto: fornecedor nao existe.", iae.getMessage());
		}
		try {
			p1.removeProduto("Leite", "Leite sem pera", "Gabriel");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na remocao de produto: produto nao existe.", iae.getMessage());
		}
		try {
			p1.removeProduto("", "Leite com pera", "Gabriel");
		} catch (IllegalArgumentException iae) {
			assertEquals("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.removeProduto("Leite", "", "Gabriel");
		} catch (IllegalArgumentException iae) {
			assertEquals("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			p1.removeProduto("Leite", "Leite com pera", "");
		} catch (IllegalArgumentException iae) {
			assertEquals("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.", iae.getMessage());
		}
	}
	
	@Test
	void testEntradasNulas() {
		try {
			p1.cadastraProduto(null, "Leite", "Leite com pera", 4.30);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.cadastraProduto("Gabriel", null, "Leite com pera", 4.30);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}try {
			p1.cadastraProduto("Gabriel", "Leite", null, 4.30);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			p1.exibeProduto(null, "Leite sem pera", "Gabriel");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.exibeProduto("Leite", null, "Gabriel");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			p1.exibeProduto("Leite", "Leite sem pera", null);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.exibeProdutosUmFornecedor(null);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.alteraPrecoProduto(null, "Leite com pera", "Gabriel", 1.00);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.alteraPrecoProduto("Leite", null, "Gabriel", 1.00);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			p1.alteraPrecoProduto("Leite", "Leite com pera", null, 1.00);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.removeProduto(null, "Leite com pera", "Gabriel");
		} catch (IllegalArgumentException iae) {
			assertEquals("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			p1.removeProduto("Leite", null, "Gabriel");
		} catch (IllegalArgumentException iae) {
			assertEquals("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			p1.removeProduto("Leite", "Leite com pera", null);
		} catch (IllegalArgumentException iae) {
			assertEquals("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.", iae.getMessage());
		}
	}
}
