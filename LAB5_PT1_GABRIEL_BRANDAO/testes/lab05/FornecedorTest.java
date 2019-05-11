package lab05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorTest {

	private Fornecedor f1;
	private Fornecedor f2;
	
	@BeforeEach
	void setUp() {
		this.f1 = new Fornecedor("Gabriel", "gabriel@ccc", "4002-8922");
		this.f2 = new Fornecedor("Jujubinha", "jujuba@ccc", "9191-2323");
	}
	
	@Test
	void testSaida() {
		assertEquals("Gabriel - gabriel@ccc - 4002-8922", f1.toString());
		assertEquals("Jujubinha - jujuba@ccc - 9191-2323", f2.toString());
	}
	
	@Test
	void testAlteraEmail() {
		this.f1.setEmail("gabriel.brandao@ccc");;
		this.f2.setEmail("juju@ccc");
		assertEquals("Gabriel - gabriel.brandao@ccc - 4002-8922", f1.toString());
		assertEquals("Jujubinha - juju@ccc - 9191-2323", f2.toString());
	}
	
	@Test
	void testAlteraTelefone(){
		this.f1.setTelefone("5555-5555");
		this.f2.setTelefone("1234-5678");
		assertEquals("Gabriel - gabriel@ccc - 5555-5555", f1.toString());
		assertEquals("Jujubinha - jujuba@ccc - 1234-5678", f2.toString());
	}
	
	@Test
	void testCadastraProduto() {
		f1.cadastraProduto("Abacate", "Abacate de uva", 5.1);
		f2.cadastraProduto("Leite", "Leite com pêra", 15.12);
	}
	
}
