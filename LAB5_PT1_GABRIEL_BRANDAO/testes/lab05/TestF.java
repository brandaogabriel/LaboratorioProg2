package lab05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestF {

	private ControllerFornecedores forne;
	
	@Test
	void testCadastra() {
		this.forne = new ControllerFornecedores();
		forne.cadastraFornecedor("Gabriel", "23232", "2");
		forne.cadastraProduto("Gabriel", "Jujuba", "Jujub de uva", 2.50);
	}
}
