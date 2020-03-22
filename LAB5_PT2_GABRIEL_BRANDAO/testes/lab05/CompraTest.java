package lab05;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Compra;

class CompraTest {

	
	private Compra c1;
	private Compra c2;
	
	@BeforeEach
	void setUp() {
		this.c1 = new Compra("13/07/1999", "Pizza", "Pizza de frango", 31.50);
		this.c2 = new Compra("25/12/2019", "Panetone", "Panetone de Chocolate", 14.00);
	}
	
	@Test
	void testDescProduto() {
		assertEquals("Pizza de frango", c1.getDescProduto());
		assertEquals("Panetone de Chocolate", c2.getDescProduto());
	}
	
	@Test
	void testGetData() {
		assertEquals("13/07/1999", c1.getData());
		assertEquals("25/12/2019", c2.getData());
	}
	
	@Test
	void testGetPreco() {
		assertEquals(31.5, c1.getPreco(), 0);
		assertEquals(14.0, c2.getPreco(), 0);
	}
	
	@Test
	void testToString() {
		assertEquals("Pizza - 13-07-1999", c1.toString());
		assertEquals("Panetone - 25-12-2019", c2.toString());
	}
	
}
