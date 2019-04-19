package lab03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {

	private Agenda agenda1;
	private Agenda agenda2;
	
	@BeforeEach
	void setUp() {
		this.agenda1 = new Agenda();
		this.agenda2 = new Agenda();
	}
	
	@Test
	void testPosicao() {
		assertEquals(true, agenda1.verificaPosicao(1));
		assertEquals(true, agenda1.verificaPosicao(100));
		assertEquals(false, agenda1.verificaPosicao(0));
		assertEquals(false, agenda1.verificaPosicao(101));
	}
	
	@Test
	void testCadastraContato() {
		agenda1.cadastraContato(1, "Gabriel", "Brandao", "212121");
		assertEquals("Gabriel Brandao - 212121", agenda1.exibeContato(1));
		assertEquals("POSICAO INVALIDA!" + System.lineSeparator(), agenda1.exibeContato(3));
	}

	@Test
	void testCadastraContatoVazio() {
		agenda2.cadastraContato(25, "Gabriel", "", "(83) 9 9941-1430");
		assertEquals("Gabriel  - (83) 9 9941-1430", agenda2.exibeContato(25));
	}

	@Test
	void testListaContato() {
		agenda1.cadastraContato(1, "GABRIEL", "BRANDAO", "322121");
		agenda1.cadastraContato(2, "RUTE", "BRANDAO", "231212");
		assertEquals("1 - GABRIEL BRANDAO" + System.lineSeparator() 
		+"2 - RUTE BRANDAO" + System.lineSeparator(), agenda1.listaContatos());
		}
	
	@Test
	void testListaContatoVazia() {
		assertEquals("", agenda1.listaContatos());
	}
	
	@Test
	void testAgendaIgual() {
		agenda1.cadastraContato(1, "Gabriel", "Brandao", "232323");
		agenda2.cadastraContato(1, "Gabriel", "Brandao", "83 9 9941-1430");
		assertEquals(agenda1.hashCode(), agenda2.hashCode());
		assertTrue(agenda1.equals(agenda2));
	}
	
	@Test
	public void testNomeNull() {
		try {
			agenda1.cadastraContato(1, null, "BRANDAO", "232321");
		}catch (NullPointerException npe) {
			assertEquals("String nula!", npe.getMessage());
		}
	}
}



