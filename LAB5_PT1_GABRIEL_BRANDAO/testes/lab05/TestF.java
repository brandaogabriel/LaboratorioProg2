package lab05;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllers.ControllerFornecedores;
import controllers.ControllerProdutos;

public class TestF {

	private ControllerFornecedores forne;
	private ControllerProdutos produtos;
	
	@Test
	void testCadastra() {

		this.forne = new ControllerFornecedores();
		this.produtos = new ControllerProdutos(forne);
		forne.cadastraFornecedor("Gabriel", "23232", "2");
		forne.cadastraFornecedor("Gabriel Brandao", "gabriel@ccc", "9090");
		produtos.cadastraProduto("Gabriel", "Jujuba", "Jujuba de uva", 2.50);
		
		assertEquals("Gabriel - 23232 - 2", forne.exibeFornecedor("Gabriel"));
		assertEquals("Gabriel - 23232 - 2 | Gabriel Brandao - gabriel@ccc - 9090 | ", forne.exibeTodosFornecedores());
		
		assertEquals("Jujuba - Jujuba de uva - R$2.5", produtos.exibeProduto("Gabriel", "Jujuba", "Jujuba de uva"));
		
		assertEquals("Gabriel - Jujuba - Jujuba de uva - R$2.5 | ", produtos.exibeProdutosUmFornecedor("Gabriel"));
		produtos.cadastraProduto("Gabriel", "Acai", "Acai com uva", 10.0);
		assertEquals("Gabriel - Jujuba - Jujuba de uva - R$2.5 | Gabriel - Acai - Acai com uva - R$10.0 | ", produtos.exibeProdutosUmFornecedor("Gabriel"));
		produtos.cadastraProduto("Gabriel", "Pizza", "Pizza de frango", 10.0);
		assertEquals("Gabriel - Jujuba - Jujuba de uva - R$2.5 | Gabriel - Acai - Acai com uva - R$10.0 | Gabriel - Pizza - Pizza de frango - R$10.0 | ", produtos.exibeProdutosUmFornecedor("Gabriel"));
		
		produtos.cadastraProduto("Gabriel Brandao", "Melancia", "Melancia de uva", 20.50);
		
		assertEquals("Gabriel - Jujuba - Jujuba de uva - R$2.5 | Gabriel - Acai - Acai com uva - R$10.0 | Gabriel - Pizza - Pizza de frango - R$10.0 | Gabriel Brandao - Melancia - Melancia de uva - R$20.5 | ", produtos.exibeProdutosFornecedores());
	
		forne.alteraDadosEmailFornecedor("Gabriel", "juju@ccc");
		forne.alteraDadosTelefoneFornecedor("Gabriel", "9090");
		assertEquals("Gabriel - juju@ccc - 9090", forne.exibeFornecedor("Gabriel"));
		
		produtos.editaProduto("Gabriel", "Jujuba", "Jujuba de uva", 10.55);
		assertEquals("Jujuba - Jujuba de uva - R$10.55", produtos.exibeProduto("Gabriel", "Jujuba", "Jujuba de uva"));
	
		assertTrue(forne.removeFornecedor("Gabriel Brandao"));
		
		assertEquals("Produto removido do fornecedor",produtos.removeProduto("Gabriel", "Acai", "Acai com uva"));
		
		
	}
}
