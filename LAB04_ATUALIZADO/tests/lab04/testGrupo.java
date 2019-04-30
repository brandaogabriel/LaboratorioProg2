package lab04;

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
	}
	
	
}
