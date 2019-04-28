package lab04;

import java.util.Scanner;

public class Program {

	
	private static void menu() {
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
		System.out.print("Opcao> ");
	}
	
	private static void cadastraAluno(Scanner sc, Controle c) {
		System.out.print(System.lineSeparator() + "Matricula: ");
		String matricula = sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		if (!c.cadastraAluno(matricula, nome, curso)) {
			System.out.println("Matricula ja cadastrada!" + System.lineSeparator());
		}
		
		else {
			c.cadastraAluno(matricula, nome, curso);
			System.out.println("Cadastro realizado com sucesso!" + System.lineSeparator());
		}
	}
	
	private static void exibeAluno(Scanner sc, Controle c) {
		System.out.print(System.lineSeparator() + "Matricula: ");
		String matricula = sc.nextLine();
		
		if (c.exibeAluno(matricula) == null) {
			System.out.println("Aluno nao cadastrado." + System.lineSeparator());
		}else System.out.println("Aluno: " + c.exibeAluno(matricula) + System.lineSeparator());
	}
	
	private static void cadastraGrupo(Scanner sc, Controle c) {
		System.out.print(System.lineSeparator() + "Grupo: ");
		String grupo = sc.nextLine();
		if(c.cadastraGrupo(grupo)) {
			System.out.println("Cadastro realizado!" + System.lineSeparator());
		}
		else System.out.println("Grupo ja cadastrado!" + System.lineSeparator());
	}
	
	private static void alocarAluno(Scanner sc, Controle c) {
		System.out.print(System.lineSeparator() + "Matricula: ");
		String matricula = sc.nextLine();
		System.out.print("Grupo: ");
		String grupo = sc.nextLine();
		System.out.println(c.alocaAluno(matricula, grupo) + System.lineSeparator());
	}
	
	private static void imprimeGrupo(Scanner sc, Controle c) {
		System.out.print("Grupo: ");
		String grupo = sc.nextLine();
		System.out.println(c.imprimeGrupo(grupo));
	}
	
	private static void registraResposta(Scanner sc, Controle c) {
		System.out.print(System.lineSeparator() + "Matricula: ");
		String matricula = sc.nextLine();
		if (c.cadastraAlunoRespondeu(matricula)) {
			System.out.println("Aluno Registrado!" + System.lineSeparator());
		}else System.out.println("Aluno nao cadastrado!" + System.lineSeparator());
	}
	
	private static void imprimeResposta(Scanner sc, Controle c) {
		if (c.exibeAlunosRespondeu().equals("Alunos: " + System.lineSeparator())) {
			System.out.println("Nenhum aluno respondeu!" + System.lineSeparator());
		}
		else {
			System.out.println(c.exibeAlunosRespondeu() + System.lineSeparator());
		}
	}
	
	public static void main(String[] args) {
		
		Controle c = new Controle();
		Scanner sc = new Scanner(System.in);
		
		menu();
		do {
			String opcao = sc.nextLine();
			if (opcao.toUpperCase().equals("C")) {
				cadastraAluno(sc, c);
			}
			
			else if (opcao.toUpperCase().equals("E")) {
				exibeAluno(sc, c);
			}
			
			else if (opcao.toUpperCase().equals("N")) {
				cadastraGrupo(sc, c);
			}
			
			else if (opcao.toUpperCase().equals("A")) {
				System.out.print(System.lineSeparator() + "(A)locar Aluno ou (I)mprimir Grupo? ");
				String escolha = sc.nextLine();
				if(escolha.toUpperCase().equals("A")) {
					alocarAluno(sc, c);
				}
				else if (escolha.toUpperCase().equals("I")) {
					imprimeGrupo(sc, c);
				}
				else {
					System.out.println(System.lineSeparator() + 
							"Entrada invalida, tente novamente!" + System.lineSeparator());
				}
			}
			
			else if (opcao.toUpperCase().equals("R")) {
				registraResposta(sc, c);
			}
			
			else if (opcao.toUpperCase().equals("I")) {
				imprimeResposta(sc, c);
			}
			
			else if (opcao.toUpperCase().equals("O")) {
				break;
			}
			else {
				System.out.println("OPCAO INVALIDA!" + System.lineSeparator());
			}
			menu();
		} while (true);
		
	}
		
}
