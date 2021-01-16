package lab03;

import java.util.Scanner;

public class Program {

	public static Scanner sc = new Scanner(System.in);
	
	public static Agenda agenda = new Agenda();
	
	private static void menu() {
		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contato");
		System.out.println("(E)xibir Contato");
		System.out.println("(S)air" + System.lineSeparator());
		System.out.print("Opcao> ");
	}
	
	private static void cadastraContato() {
		System.out.print(System.lineSeparator() + "Posicao: ");
		int posicao = Integer.parseInt(sc.nextLine());
		if (!agenda.verificaPosicao(posicao)) {
			System.out.println("CADASTRO NAO REALIZADO, POSICAO INVALIDA!" + System.lineSeparator());
		}
		else {
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Sobrenome: ");
		String sobreNome = sc.nextLine();
		System.out.print("Telefone: ");
		String telefone = sc.nextLine();
		agenda.cadastraContato(posicao, nome, sobreNome, telefone);
		System.out.println("CADASTRO BEM SUCEDIDO!" + System.lineSeparator());
		}
	}
	
	private static void exibeContato() {
		System.out.print("Contato> ");
		int posicaoContato = Integer.parseInt(sc.nextLine());
		System.out.println(System.lineSeparator() + agenda.exibeContato(posicaoContato) +
				System.lineSeparator());
	}
	
	private static void listaContato() {
		System.out.println(agenda.listaContatos());
	}
	
	public static void main(String[] args) {
		
		menu();
		int certificador = 0;
		do {
			String opcao = sc.nextLine();
			if (opcao.equals("C")) {
				cadastraContato();
				menu();
			}
			else if (opcao.equals("L")) {
				listaContato();
				menu();
			}
			else if (opcao.equals("E")) {
				exibeContato();
				menu();
			}
			else if (opcao.equals("S")) {
				certificador = 1;
			}
			else { 
				System.out.println("OPCAO INVALIDA!" + System.lineSeparator());
				menu();
			}
		} while (certificador != 1);
		
	}

}
