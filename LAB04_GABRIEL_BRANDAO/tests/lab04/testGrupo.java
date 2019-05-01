package lab04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testGrupo {

	private Grupo grupo1;
	private Grupo grupo2;
	private Aluno aluno1;
	private Aluno aluno2;
	
	@BeforeEach
	void setUp() {
		this.grupo1 = new Grupo("Jubileu");
		this.grupo2 = new Grupo("Panelinha");
		this.aluno1 = new Aluno("1", "Gabriel", "CC pq sim");
		this.aluno2 = new Aluno("2", "Gabriela", "CC nao vei");
	}
	
	@Test
	void testListaGrupo() {
		grupo1.insereAlunoGrupo(aluno1);
		grupo2.insereAlunoGrupo(aluno2);
		assertEquals("* 1 - Gabriel - CC pq sim" + System.lineSeparator(),grupo1.getAlunos());
		assertEquals("* 2 - Gabriela - CC nao vei" + System.lineSeparator(),grupo2.getAlunos());
	}
	
	@Test
	void testToString() {
		assertEquals("Alunos do grupo Jubileu:", grupo1.toString());
		assertEquals("Alunos do grupo Panelinha:", grupo2.toString());
	}
	
	@Test
	void testGruposIguais() {
		Grupo grupo3 = new Grupo("Jubileu");
		assertFalse(grupo1.equals(grupo2));
		assertEquals(grupo1.hashCode(), grupo3.hashCode());
		assertTrue(grupo1.equals(grupo3));
	}
	
}
