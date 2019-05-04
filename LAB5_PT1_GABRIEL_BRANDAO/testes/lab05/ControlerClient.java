package lab05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.ControllerClientes;

class ControlerClient {

	
	private ControllerClientes cliente;
	
	@BeforeEach
	void setUp() {
		this.cliente = new ControllerClientes();
	}
	
	@Test
	void testCadastra() {
		assertEquals("Entrada nula",cliente.cadastraCliente(null, "gabriel", "gabriel@ccc", "splab"));
	}
	
}
