package controllers;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerFornecedorTest {

	private ControllerFornecedores f1;
	private ControllerFornecedores f2;
	
	@BeforeEach
	void setUp() {
		this.f1 = new  ControllerFornecedores();
		this.f2 = new ControllerFornecedores();
		this.f1.cadastraFornecedor("Gabriel", "gabriel@brasil", "4002-8922");
		this.f2.cadastraFornecedor("Marcos", "marcos@ambev", "3421-0011");
	}
	
	@Test
	void testExibeFornecedor() {
		assertEquals("Gabriel - gabriel@brasil - 4002-8922", f1.exibeFornecedor("Gabriel"));
		assertEquals("Marcos - marcos@ambev - 3421-0011",f2.exibeFornecedor("Marcos"));
	}
	
	@Test
	void testExibeTodosFornecedores() {
		this.f1.cadastraFornecedor("Junior", "junior@brasil", "1234-5678");
		assertEquals("Gabriel - gabriel@brasil - 4002-8922 | Junior - junior@brasil - 1234-5678", f1.exibeTodosFornecedores());
		assertEquals("Marcos - marcos@ambev - 3421-0011", f2.exibeTodosFornecedores());
	}
	
	
	@Test
	void testEditaFornecedor() {
		f1.editaFornecedor("Gabriel", "email", "gabriel@ambev");
		f2.editaFornecedor("Marcos", "telefone", "5544-9090");
		assertEquals("Gabriel - gabriel@ambev - 4002-8922", f1.exibeFornecedor("Gabriel"));
		assertEquals("Marcos - marcos@ambev - 5544-9090",f2.exibeFornecedor("Marcos"));
	}
	
	@Test
	void testRemoveFornecedor() {
		assertEquals("Fornecedor removido com sucesso", f1.removeFornecedor("Gabriel"));
		assertEquals("Fornecedor removido com sucesso", f2.removeFornecedor("Marcos"));
	}
	
	@Test
	void testEntradasVazias(){
		try {
			f1.cadastraFornecedor("", "gabriel@ambev", "4002-8922");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			f1.cadastraFornecedor("Gabriel", "", "4002-8922");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			f1.cadastraFornecedor("Gabriel", "gabriel@ambev", "");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			f1.cadastraFornecedor("Gabriel", "gabriel@ambev", "4002-8922");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de fornecedor: fornecedor ja existe.", iae.getMessage());
		}
		try {
			f1.exibeFornecedor("Jacob");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na exibicao do fornecedor: fornecedor nao existe.", iae.getMessage());
		}
		try {
			f1.editaFornecedor("Gabriel", "nome", "Gabriel B");
		} catch(IllegalArgumentException iae) {
			assertEquals("Erro na edicao do fornecedor: nome nao pode ser editado.", iae.getMessage());
		}
		try {
			f1.editaFornecedor("Gabriel", "", "Gabriel Brandao");
		} catch(IllegalArgumentException iae) {
			assertEquals("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			f1.editaFornecedor("Gabriel", "email", "");
		} catch(IllegalArgumentException iae) {
			assertEquals("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			f1.editaFornecedor("Gabriel", "sobrenome", "Brandao");
		} catch(IllegalArgumentException iae) {
			assertEquals("Erro na edicao do fornecedor: atributo nao existe.", iae.getMessage());
		}
		try {
			f1.removeFornecedor("");
		} catch(IllegalArgumentException iae) {
			assertEquals("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.", iae.getMessage());
		}
		try {
			f1.removeFornecedor("Max Weiber");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro na remocao do fornecedor: fornecedor nao existe.", iae.getMessage());
		}
	}
	
	@Test
	void testEntradasNulas() {
		try {
			f1.cadastraFornecedor(null, "gabriel@ambev", "4002-8922");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			f1.cadastraFornecedor("Gabriel", null, "4002-8922");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			f1.cadastraFornecedor("Gabriel", "gabriel@ambev", null);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			f1.editaFornecedor("Gabriel", "email", null);
		} catch(IllegalArgumentException iae) {
			assertEquals("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.", iae.getMessage());
		}
	}
}
