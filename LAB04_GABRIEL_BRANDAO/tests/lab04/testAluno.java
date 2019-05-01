package lab04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testAluno {

	private Aluno aluno1;
	private Aluno aluno2;
	
	@BeforeEach
	void setUp() {
		this.aluno1 = new Aluno("250", "Gabriel", "CC");
		this.aluno2 = new Aluno("251", "Jubileu", "Medicina");
	}
	
	@Test
	void testSaidas() {
		assertEquals("250", aluno1.getMatricula());
		assertEquals("251", aluno2.getMatricula());
		assertEquals("250 - Gabriel - CC", aluno1.toString());
		assertEquals("251 - Jubileu - Medicina", aluno2.toString());
	}
	
	@Test
	void testAlunosIguais() {
		Aluno aluno3 = new Aluno("250", "Javis", "CC");
		assertEquals(aluno1.hashCode(), aluno3.hashCode());
		assertTrue(aluno1.equals(aluno3));
	}
	
	@Test
	void testMatriculaVazia() {
		Aluno aluno4 = new Aluno("", "Bruno", "Adm");
		assertEquals("", aluno4.getMatricula());
	}
}
