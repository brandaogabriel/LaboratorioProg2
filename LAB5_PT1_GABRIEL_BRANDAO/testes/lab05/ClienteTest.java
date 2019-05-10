package lab05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	private Cliente cliente1;
	private Cliente cliente2;
	
	@BeforeEach
	void setUp() {
		this.cliente1 = new Cliente("11122233344", "Gabriel", "gabriel@ccc",
				"splab");
		this.cliente2 = new Cliente("33344455566", "Joaozinho", "joaozinho@ccc",
				"embedded");
	}

	@Test
	void testSaida() {
		assertEquals("Gabriel - splab - gabriel@ccc", cliente1.toString());
		assertEquals("Joaozinho - embedded - joaozinho@ccc", cliente2.toString());
	}
	
	
	@Test
	void testAlteraNome() {
		this.cliente1.setNome("Gabriel Brandao");
		assertEquals("Gabriel Brandao - splab - gabriel@ccc", cliente1.toString());
		this.cliente2.setNome("Joaozinho bobo");
		assertEquals("Joaozinho bobo - embedded - joaozinho@ccc", cliente2.toString());
	}
	
	@Test
	void testAlteraEmail(){
		this.cliente1.setEmail("gabriel.brandao@ccc");
		assertEquals("Gabriel - splab - gabriel.brandao@ccc", cliente1.toString());
		this.cliente2.setEmail("joaozinho.bobo@ccc");
		assertEquals("Joaozinho - embedded - joaozinho.bobo@ccc", cliente2.toString());
	}
	
	@Test
	void testAlteraLocalizacao() {
		this.cliente1.setLocalizacao("analytics");
		assertEquals("Gabriel - analytics - gabriel@ccc", cliente1.toString());
		this.cliente2.setLocalizacao("nilson");
		assertEquals("Joaozinho - nilson - joaozinho@ccc", cliente2.toString());
	}
	
	@Test
	void testClientesIguais() {
		Cliente cliente3 = new Cliente("11122233344", "Marcos", "marcos@ccc", "18");
		assertEquals(cliente1.hashCode(),cliente3.hashCode());
		assertTrue(cliente1.equals(cliente3));
		assertFalse(cliente1.equals(cliente2));
	}
	
	@Test
	void testEntradasVazias() {
		try {
			new Cliente("", "Gabriel", "gabriel@ccc", "splab");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: cpf invalido.", iae.getMessage());
		}
		try {
			new Cliente("11122233344", "", "gabriel@ccc", "splab");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			new Cliente("11122233344", "Gabriel", "", "splab");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			new Cliente("11122233344", "Gabriel", "gabriel@ccc", "");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			Cliente c = new Cliente("11122233344", "Gabriel", "gabriel@ccc", "splab");
			c.setNome("");
		}catch (IllegalArgumentException iae) {
			assertEquals("Entrada vazia", iae.getMessage());
		}
		try {
			Cliente c = new Cliente("11122233344", "Gabriel", "gabriel@ccc", "splab");
			c.setEmail("");
		}catch (IllegalArgumentException iae) {
			assertEquals("Entrada vazia", iae.getMessage());
		}
		try {
			Cliente c = new Cliente("11122233344", "Gabriel", "gabriel@ccc", "splab");
			c.setLocalizacao("");
		}catch (IllegalArgumentException iae) {
			assertEquals("Entrada vazia", iae.getMessage());
		}
	}
	
	@Test
	void testEntradasNulas() {
		try {
			new Cliente(null, "Gabriel", "gabriel@ccc", "splab");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: cpf invalido.", iae.getMessage());
		}
		try {
			new Cliente("11122233344", null, "gabriel@ccc", "splab");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			new Cliente("11122233344", "Gabriel", null, "splab");
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			new Cliente("11122233344", "Gabriel", "gabriel@ccc", null);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			Cliente c = new Cliente("11122233344", "Gabriel", "gabriel@ccc", "splab");
			c.setNome(null);
		}catch (NullPointerException npe) {
			assertEquals("Entrada nula", npe.getMessage());
		}
		try {
			Cliente c = new Cliente("11122233344", "Gabriel", "gabriel@ccc", "splab");
			c.setEmail(null); 
		}catch (NullPointerException npe) {
			assertEquals("Entrada nula", npe.getMessage());
		}
		try {
			Cliente c = new Cliente("11122233344", "Gabriel", "gabriel@ccc", "splab");
			c.setLocalizacao(null);
		}catch (NullPointerException npe) {
			assertEquals("Entrada nula", npe.getMessage());
		}
	}
}
