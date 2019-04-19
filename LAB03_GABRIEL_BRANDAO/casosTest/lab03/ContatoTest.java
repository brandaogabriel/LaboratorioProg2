package lab03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTest {

	private Contato contato1;
	private Contato contato2;
	
	@BeforeEach
	void setUp() {
		this.contato1 = new Contato("Gabriel", "Brandao", "(83) 9 9941-1430");
		this.contato2 = new Contato("Gabriel", "Brandao", "(83) 3421-7207");
	}
	
	@Test
	void testConstrutor() {
		assertEquals("Gabriel", contato1.getNome());
		assertEquals("Brandao", contato1.getsobreNome());
		assertEquals("(83) 9 9941-1430", contato1.getTelefone());
		assertEquals("Gabriel Brandao", contato1.getNomeCompleto());
		assertEquals("Gabriel Brandao - (83) 9 9941-1430", contato1.toString());
	}
	
	@Test
	void testDoisContatosIguais() {
		assertEquals(contato1.hashCode(), contato2.hashCode());
		assertTrue(contato1.equals(contato2));
	}
	
	@Test
	void testNomeVazio() {
		this.contato1 = new Contato("", "Brandao", "(83) 9 9941-1430");
		assertEquals("", contato1.getNome());
	}
	
	@Test
	void testSobreNomeVazio() {
		this.contato1 = new Contato("Gabriel", "", "(83) 9 9941-1430");
		assertEquals("", contato1.getsobreNome());
	}
	
	@Test
	void testNumeroVazio() {
		this.contato1 = new Contato("Gabriel", "Brandao", "");
		assertEquals("", contato1.getTelefone());
	}

}

