package sistema;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		sistema();
		Estacionamento estacionamento = new Estacionamento();
	}
	
	public static void sistema() {
		int choice = 0;
		System.out.println("Bem vindo! Escolha uma opção para continuar:");
		while(choice != 9) {
		 System.out.println("1. Gerenciar Vagas");
         System.out.println("2. Gerenciar Veículos");
         System.out.println("3. Histórico");
         System.out.println("9. Sair");
         choice = scan.nextInt();
         switch (choice) {
		case 1: {
			gerenciarVagas();
			break;
		}
		case 2: {
			gerenciarVeiculos();
			break;
		}
		case 3: {
			Estacionamento.histórico();
			break;
		}
		case 9:{
			System.out.println("Até logo!");
			break;
		}
		default: {
			System.out.println("Opção inválida, tente novamente.");
			break;
		}
         }
	}}

	private static void gerenciarVeiculos() {
		int choice = 0;
		System.out.println("Bem vindo! Escolha uma opção para continuar:");
		while(choice != 9) {
		 System.out.println("1. Registrar Entrada");
         System.out.println("2. Registrar Saida");
         System.out.println("9. Sair");
         choice = scan.nextInt();
         switch (choice) {
		case 1: {
			System.out.println("Qual o modelo do carro?");
			String model = scan.next();
			System.out.println("Qual a placa do carro?");
			String placa = scan.next();
			System.out.println("Qual o tamanho do carro?\n1 - Pequeno\n2 - Médio\n3 - Grande");
			int option = 0;
			String tam = null;
			while(!(option<3&&option>0)) {
				option = scan.nextInt();
			switch (option){
			case 1: {
				tam = "Pequeno";
				break;
			}
			case 2: {
				tam = "Médio";
				break;
			}
			case 3: {
				tam = "Grande";
				break;
			}
			default:
				System.out.println("Inválido, tente novamente.");
			}}
			Estacionamento.newCarro(model, tam, placa);
			break;
		}
		case 2: {
			System.out.println("Em qual vaga o carro está estacionado?");
			Estacionamento.listarOcupadas();
			int num = scan.nextInt();
			Estacionamento.checkOut(num);
			break;
		}
		case 9:{
			System.out.println("Voltando..");
			break;
		}
		default: {
			System.out.println("Opção inválida, tente novamente.");
			break;
		}
		}
         }
		
	}

	private static void gerenciarVagas() {
		int choice = 0;
		System.out.println("Bem vindo! Escolha uma opção para continuar:");
		while(choice != 9) {
		 System.out.println("1. Adicionar Vaga");
         System.out.println("2. Editar Vaga");
         System.out.println("3. Listar vagas ocupadas");
         System.out.println("9. Sair");
         choice = scan.nextInt();
         switch (choice) {
		case 1: {
			System.out.println("Qual o número da vaga?");
			int num = scan.nextInt();
			System.out.println("Qual o tamanho da vaga?\n1 - Pequeno\n2 - Médio\n3 - Grande");
			int option = 0;
			String tam = null;
			while(!(option<3&&option>0)) {
				option = scan.nextInt();
			switch (option){
			case 1: {
				tam = "Pequeno";
				break;
			}
			case 2: {
				tam = "Médio";
				break;
			}
			case 3: {
				tam = "Grande";
				break;
			}
			default:
				System.out.println("Inválido, tente novamente.");
			}}
			Estacionamento.newVaga(num, tam);
			break;
		}
		case 2: {
			System.out.println("Qual vaga deseja editar?");
			Estacionamento.listarDisp();
			int num = scan.nextInt();
			System.out.println("O que deseja fazer?\n1 - Editar número\n2 - Editar tamanho\n3 - Excluir vaga");
			int edit = scan.nextInt();
			Estacionamento.editarVaga(num, edit);
			break;
		}
		case 3: {
			Estacionamento.listarOcupadas();
			break;
		}
		case 9:{
			System.out.println("Voltando..");
			break;
		}
		default: {
			System.out.println("Opção inválida, tente novamente.");
			break;
		}
         }
	}

	}
}
