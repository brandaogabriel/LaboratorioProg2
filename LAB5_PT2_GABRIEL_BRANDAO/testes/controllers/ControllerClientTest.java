package controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerClientTest {

	
	private ControllerClientes c1;
	private ControllerClientes c2;
	
	@BeforeEach
	void setUp() {
		this.c1 = new ControllerClientes();
		this.c2 = new ControllerClientes();
		this.c1.cadastraCliente("99988877766", "Gabriel", "gabriel@ccc", "embedded");
		this.c2.cadastraCliente("11122233344", "Junior", "juinim@ccc", "splab");
	}
	
	@Test
	void testExibeCliente() {
		assertEquals("Gabriel - embedded - gabriel@ccc",c1.exibeCliente("99988877766"));
		assertEquals("Junior - splab - juinim@ccc", c2.exibeCliente("11122233344"));
	}
	 
	@Test
	void testExibeTodosClientes() {
		this.c1.cadastraCliente("90908765432", "Carlos", "carlos@fm", "ufcg");
		assertEquals("Carlos - ufcg - carlos@fm | Gabriel - embedded - gabriel@ccc", c1.exibeTodos());
		assertEquals("Junior - splab - juinim@ccc", c2.exibeTodos());
	}

	@Test
	void testEditaCliente() {
		this.c1.editaCliente("99988877766", "nome", "Gabriel B");
		this.c2.editaCliente("11122233344", "email", "junior@ufcg");
		this.c2.editaCliente("11122233344", "localizacao", "epol");
		assertEquals("Gabriel B - embedded - gabriel@ccc", c1.exibeCliente("99988877766"));
		assertEquals("Junior - epol - junior@ufcg", c2.exibeCliente("11122233344"));
	}
	
	@Test
	void testRemoveCliente() {
		assertEquals("Cliente removido",this.c1.removeCliente("99988877766"));
		assertEquals("Cliente nao cadastrado", this.c1.removeCliente("40028922981"));
		assertEquals("Cliente removido",this.c2.removeCliente("11122233344"));
		assertEquals("Cliente nao cadastrado",this.c2.removeCliente("65438156321"));
	}
	
	@Test
	void testEntradaVazia() {
		try {
			this.c1.cadastraCliente("1234567", "Gabriel", "gab@cc", "ufcg");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: cpf invalido.", iae.getMessage());
		}
		try {
			this.c1.cadastraCliente("12345678911", "", "gabri@ccc", "analytics");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			this.c1.cadastraCliente("12345678911", "Gabriel", "", "analytics");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			this.c1.cadastraCliente("12345678911", "Gabriel", "gabri@ccc", "");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			this.c1.cadastraCliente("99988877766", "Bruno", "bruno@ufcg.edu", "epol");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: cliente ja existe.", iae.getMessage());
		}
		try {
			this.c1.exibeCliente("34525789026");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro na exibicao do cliente: cliente nao existe.", iae.getMessage());
		}
		try {
			this.c1.editaCliente("45678943261", "nome", "max");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao do cliente: cliente nao existe.", iae.getMessage());
		}
		try {
			this.c1.editaCliente("99988877766", "", "Carlos");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			this.c1.editaCliente("99988877766", "nome", "");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			this.c1.editaCliente("99988877766", "sobrenome", "Gabriel");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao do cliente: atributo nao existe.", iae.getMessage());
		}
	} 
	
	@Test
	void testEntradaNula() {
		try {
			this.c1.cadastraCliente(null, "Gabriel", "gab@cc", "ufcg");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: cpf invalido.", iae.getMessage());
		}
		try {
			this.c1.cadastraCliente("12345678911", null, "gabri@ccc", "analytics");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			this.c1.cadastraCliente("12345678911", "Gabriel", null, "analytics");
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			this.c1.cadastraCliente("12345678911", "Gabriel", "gabri@ccc", null);
		}catch(IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			this.c1.editaCliente("99988877766", null, "Gabriel");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			this.c1.editaCliente("99988877766", "nome", null);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", iae.getMessage());
		}		
	}
}