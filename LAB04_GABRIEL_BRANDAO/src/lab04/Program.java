package lab04;

import java.util.Scanner;

public class Program {

	private static Controle c = new Controle();
	
	private static Scanner sc = new Scanner(System.in);
	
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
	
	private static void cadastraAluno() {
		System.out.println();
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		if (!c.cadastraAluno(matricula, nome, curso)) {
			System.out.println("Matricula ja cadastrada!");
		}
		
		else {
			c.cadastraAluno(matricula, nome, curso);
			System.out.println("Cadastro realizado com sucesso!" + System.lineSeparator());
		}
	}
	
	private static void exibeAluno() {
		System.out.println();
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();
		
		if (c.exibeAluno(matricula) == null) {
			System.out.println("Aluno nao cadastrado." + System.lineSeparator());
		}else System.out.println(c.exibeAluno(matricula) + System.lineSeparator());
	}
	
	
	public static void main(String[] args) {
		
		menu();
		do {
			String opcao = sc.nextLine();
			if (opcao.toUpperCase().equals("C")) {
				cadastraAluno();
			}
			
			else if (opcao.toUpperCase().equals("E")) {
				exibeAluno();
			}
			
			else if (opcao.equals("N")) {
	
			}
			
			else if (opcao.equals("A")) {
				
			}
			
			else if (opcao.equals("R")) {

			}
			
			else if (opcao.equals("I")) {

			}
			
			else if (opcao.equals("O")) {
				break;
			}
			else {
				System.out.println("OPCAO INVALIDA!" + System.lineSeparator());
			}
			menu();
		} while (true);
		
	}
		
}
