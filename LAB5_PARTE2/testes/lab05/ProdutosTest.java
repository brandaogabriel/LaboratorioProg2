package lab05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Produtos;

class ProdutosTest {

	private Produtos p1;
	private Produtos p2;
	
	@BeforeEach
	void setUp() {
		this.p1 = new Produtos("Abacate", "Abacate de uva", 5.2);
		this.p2 = new Produtos("Pastel", "Pastel de frango", 3);
	}
	
	@Test
	void testSaida() {
		assertEquals("Abacate - Abacate de uva - R$5,20", p1.toString());
		assertEquals("Pastel - Pastel de frango - R$3,00", p2.toString());
	}
	
	@Test
	void testAlteraPreco() {
		this.p1.setPreco(10.55);
		this.p2.setPreco(5.36);
		assertEquals("Abacate - Abacate de uva - R$10,55", p1.toString());
		assertEquals("Pastel - Pastel de frango - R$5,36", p2.toString());
	}

	@Test
	void testProdutosIguais() {
		Produtos p3 = new Produtos("Abacate", "Abacate de uva", 4.30);
		assertEquals(p1.hashCode(), p3.hashCode());
		assertTrue(p1.equals(p3));
	}
	
	@Test
	void testEntradasVazias() {
		try {
			new Produtos("", "Abacate de uva", 5.2);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			new Produtos("Abacate", "", 5.2);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", iae.getMessage());
		}
		try {
			new Produtos("Abacate", "Abacate de uva", -5);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: preco invalido.", iae.getMessage());
		}
	}
	
	@Test
	void testEntradasNulas() {
		try {
			new Produtos(null, "Abacate de uva", 5.2);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", iae.getMessage());
		}
		try {
			new Produtos("Abacate", null, 5.2);
		}catch (IllegalArgumentException iae) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", iae.getMessage());
		}
	}
}