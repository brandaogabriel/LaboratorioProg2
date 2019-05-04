package lab05;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestF {

	private ControllerFornecedores forne;
	
	@Test
	void testCadastra() {
		this.forne = new ControllerFornecedores();
		forne.cadastraFornecedor("Gabriel", "23232", "2");
		forne.cadastraFornecedor("Gabriel Brandao", "gabriel@ccc", "9090");
		forne.cadastraProduto("Gabriel", "Jujuba", "Jujuba de uva", 2.50);
		
		assertEquals("Gabriel - 23232 - 2", forne.exibeFornecedor("Gabriel"));
		assertEquals("Gabriel - 23232 - 2 | Gabriel Brandao - gabriel@ccc - 9090 | ", forne.exibeTodosFornecedores());
		
		assertEquals("Jujuba - Jujuba de uva - R$2.5", forne.exibeProduto("Gabriel", "Jujuba", "Jujuba de uva"));
		
		assertEquals("Gabriel - Jujuba - Jujuba de uva - R$2.5 | ", forne.exibeProdutosUmFornecedor("Gabriel"));
		forne.cadastraProduto("Gabriel", "Acai", "Acai com uva", 10.0);
		assertEquals("Gabriel - Jujuba - Jujuba de uva - R$2.5 | Gabriel - Acai - Acai com uva - R$10.0 | ", forne.exibeProdutosUmFornecedor("Gabriel"));
		forne.cadastraProduto("Gabriel", "Pizza", "Pizza de frango", 10.0);
		assertEquals("Gabriel - Jujuba - Jujuba de uva - R$2.5 | Gabriel - Acai - Acai com uva - R$10.0 | Gabriel - Pizza - Pizza de frango - R$10.0 | ", forne.exibeProdutosUmFornecedor("Gabriel"));
		
		forne.cadastraProduto("Gabriel Brandao", "Melancia", "Melancia de uva", 20.50);
		
		assertEquals("Gabriel - Jujuba - Jujuba de uva - R$2.5 | Gabriel - Acai - Acai com uva - R$10.0 | Gabriel - Pizza - Pizza de frango - R$10.0 | Gabriel Brandao - Melancia - Melancia de uva - R$20.5 | ", forne.exibeProdutosFornecedores());
	
		forne.alteraDadosFornecedor("Gabriel", "juju@ccc", "9090");
		assertEquals("Gabriel - juju@ccc - 9090", forne.exibeFornecedor("Gabriel"));
		
		forne.editaProduto("Gabriel", "Jujuba", "Jujuba de uva", 10.55);
		assertEquals("Jujuba - Jujuba de uva - R$10.55", forne.exibeProduto("Gabriel", "Jujuba", "Jujuba de uva"));
	
		assertTrue(forne.removeFornecedor("Gabriel Brandao"));
		
		assertEquals("Produto removido do fornecedor",forne.removeProduto("Gabriel", "Acai", "Acai com uva"));
		
		
	}
}
