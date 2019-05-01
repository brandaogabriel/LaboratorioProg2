package lab04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testControle {

	private Controle c1;
	private Controle c2;
	
	@BeforeEach
	void setUp() {
		this.c1 = new Controle();
		this.c2 = new Controle();
		c1.cadastraAluno("250", "Joaozinho", "Medicina");
		c2.cadastraAluno("251", "Mariana", "Engenharia Civil");
		c1.cadastraGrupo("panelinha da ufcg");
		c2.cadastraGrupo("otarios da ufcg");
		c1.alocaAluno("250", "panelinha da ufcg");
		c2.alocaAluno("251", "otArIoS DA UfcG");
		c1.cadastraAlunoRespondeu("250");
		c2.cadastraAlunoRespondeu("251");
	}
	
	@Test
	void testCadastraAluno() {
		assertFalse(c1.cadastraAluno("250", "Roberto", "Economia"));
		assertTrue(c2.cadastraAluno("253", "Mariana", "Engenharia Civil"));
	}
	
	@Test
	void testExibeAluno() {
		Aluno a1 = new Aluno("250", "Joaozinho", "Medicina");
		assertEquals(a1, c1.exibeAluno("250"));
		assertEquals(null, c1.exibeAluno("251"));
	}
	
	@Test
	void testCadastraGrupo() {
		assertTrue(c1.cadastraGrupo("ufcg"));
		assertTrue(c2.cadastraGrupo("uepb"));
		assertFalse(c1.cadastraGrupo("panelinha da ufcg"));
		assertFalse(c2.cadastraGrupo("otarios da ufcg"));
		assertFalse(c1.cadastraGrupo("panElInha DA UFCG"));
		assertFalse(c2.cadastraGrupo("OtArIoS Da UfCg"));
	}
	
	@Test
	void testAlocaAluno() {
		assertEquals("Aluno alocado!", c1.alocaAluno("250", "panelinha da ufcg"));
		assertEquals("Aluno alocado!", c2.alocaAluno("251", "otarios da ufcg"));
		assertEquals("Aluno nao cadastrado!", c1.alocaAluno("249", "panelinha da ufcg"));
		assertEquals("Grupo nao cadastrado!", c2.alocaAluno("251", "uepb"));
	}
	
	@Test
	void testImprimeGrupo() {
		assertEquals("Grupo nao cadastrado!" + System.lineSeparator(), c1.imprimeGrupo("abc"));
		assertEquals("Grupo nao cadastrado!" + System.lineSeparator(), c2.imprimeGrupo("bca"));
		assertEquals("Alunos do grupo panelinha da ufcg:" + System.lineSeparator() +
					"* 250 - Joaozinho - Medicina" + System.lineSeparator(), 
					c1.imprimeGrupo("panelinha da ufcg"));
		assertEquals("Alunos do grupo otarios da ufcg:" + System.lineSeparator()+
					"* 251 - Mariana - Engenharia Civil" + System.lineSeparator(),
					c2.imprimeGrupo("otarios da ufcg"));	
	}
	
	@Test
	void testCadastraAlunoRespondeu() {
		assertTrue(c1.cadastraAlunoRespondeu("250"));
		assertTrue(c2.cadastraAlunoRespondeu("251"));
		assertFalse(c1.cadastraAlunoRespondeu("251"));
		assertFalse(c2.cadastraAlunoRespondeu("250"));
	}
	
	@Test
	void testExibeAlunoRespondeu() {
		assertEquals("Alunos: " + System.lineSeparator() + 
					"1. 250 - Joaozinho - Medicina" + System.lineSeparator(), 
					c1.exibeAlunosRespondeu());
		assertEquals("Alunos: " + System.lineSeparator() + 
					"1. 251 - Mariana - Engenharia Civil" + System.lineSeparator(),
					c2.exibeAlunosRespondeu());
	}

	@Test
	void testEntradaVazia() {
		try {
			c1.cadastraAluno("", "Gabriel", "Medicina");
		}catch (IllegalArgumentException iae) {
			assertEquals("Entrada vazia", iae.getMessage());
		}
		try {
			c1.cadastraAluno("250", "", "Medicia");
		}catch (IllegalArgumentException iae) {
			assertEquals("Entrada vazia", iae.getMessage());
		}
		try {
			c1.cadastraAluno("250", "Gabriel", "");
		}catch (IllegalArgumentException iae) {
			assertEquals("Entrada vazia", iae.getMessage());
		}
		try {
			c1.alocaAluno("", "panelinha da ufcg");
		}catch (IllegalArgumentException iae) {
			assertEquals("Entrada vazia", iae.getMessage());
		}
		try {
			c1.alocaAluno("250", "");
		}catch (IllegalArgumentException iae) {
			assertEquals("Entrada vazia", iae.getMessage());
		}
		try {
			c1.cadastraAlunoRespondeu("");
		}catch (IllegalArgumentException iae) {
			assertEquals("Entrada vazia", iae.getMessage());
		}
		try {
			c1.cadastraGrupo("");
		}catch (IllegalArgumentException iae) {
			assertEquals("Entrada vazia", iae.getMessage());
		}
		try {
			c1.imprimeGrupo("");
		}catch (IllegalArgumentException iae) {
			assertEquals("Entrada vazia", iae.getMessage());
		}
	}
	
	@Test
	void testEntradaNula() {
		try {
			c1.cadastraAluno(null, "Gabriel", "CC");
		}catch (NullPointerException npe) {
			assertEquals("Entrada nula", npe.getMessage());
		}
		try {
			c1.cadastraAluno("250", null, "CC");
		}catch (NullPointerException npe) {
			assertEquals("Entrada nula", npe.getMessage());
		}
		try {
			c1.cadastraAluno("250", "Gabriel", null);
		} catch (NullPointerException npe) {
			assertEquals("Entrada nula", npe.getMessage());
		}
		try {
			c1.alocaAluno(null, "otarios da ufcg");
		}catch (NullPointerException npe) {
			assertEquals("Entrada nula", npe.getMessage());
		}
		try {
			c1.alocaAluno("250", null);
		}catch (NullPointerException npe) {
			assertEquals("Entrada nula", npe.getMessage());
		}
		try {
			c1.cadastraAlunoRespondeu(null);
		}catch (NullPointerException npe) {
			assertEquals("Entrada nula", npe.getMessage());
		}
		try {
			c1.cadastraGrupo(null);
		}catch (NullPointerException npe) {
			assertEquals("Entrada nula", npe.getMessage());
		}
		try {
			c1.imprimeGrupo(null);
		}catch (NullPointerException npe) {
			assertEquals("Entrada nula", npe.getMessage());
		}
	}
}
