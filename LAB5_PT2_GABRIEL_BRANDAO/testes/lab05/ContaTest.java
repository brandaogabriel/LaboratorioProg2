package lab05;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Conta;

class ContaTest {
	
	private Conta conta1;
	
	@BeforeEach
	void setUp() {
		this.conta1 = new Conta();
	}
	
	@Test
	void testInsereCompra() {
		this.conta1.insereCompra("13/07/1999", "Pizza", "Pizza de frango", 31.50);	
	}
	
	@Test
	void testCalculaDebito() {
		this.conta1.insereCompra("13/07/1999", "Pizza", "Pizza de frango", 31.50);
		assertEquals(31.50, this.conta1.calculaDebito(), 0);
		assertEquals("31.50", this.conta1.getDebito());
	}
	
	@Test
	void testToString() {
		this.conta1.insereCompra("13/07/1999", "Pizza", "Pizza de frango", 31.50);
		this.conta1.insereCompra("25/12/2019", "Panetone", "Panetone de chocolate", 14.50);
		assertEquals("Pizza - 13-07-1999 | Panetone - 25-12-2019", this.conta1.reuneProdutos());
	}
	
}
