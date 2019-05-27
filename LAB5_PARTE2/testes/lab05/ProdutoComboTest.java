package lab05;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.ProdutoCombo;
import entities.Produtos;

class ProdutoComboTest {

	
	private ProdutoCombo pc1;
	private Produtos p1;
	private Produtos p2;
	
	
	@BeforeEach
	void setUp() {
		this.p1 = new Produtos("Dog", "Dog simples", 3.50);
		this.p2 = new Produtos("Dog meio", "Dog com ovo", 5.00);
		this.pc1 = new ProdutoCombo("Dogao", "Sanduiche completo", 0.25);
	}
	
	@Test
	void testAlteraFatorECalculaPreco() {
		this.pc1.setFator(0.75);
		this.pc1.calculaPreco(p1.getPreco() + p2.getPreco());
	}
	
	@Test
	void testInsereProdutoSimples() {
		this.pc1.insireProdutoSimples(p1);
		this.pc1.insireProdutoSimples(p2);
	}
	
	@Test
	void testValorDosProdutosSimples() {
		this.p1 = new Produtos("X frango", "X frango sem verdura", 4.00);
		this.p2 = new Produtos("Suco", "Suco de uva", 2.50);
		this.pc1.insireProdutoSimples(p1);
		this.pc1.insireProdutoSimples(p2);
		assertEquals(6.5, this.pc1.valorDosProdutosSimples(), 0);
	}
}