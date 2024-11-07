package sistema;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Scanner;


import objetos.Carro;
import objetos.Vaga;


public class Estacionamento {
	public static ArrayList<Carro> historicoCarros = new ArrayList<>();
	public static ArrayList<Vaga> vagas = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	public static void newVaga(int num, String tam) {
		boolean vagaExiste = false;

		if(!vagas.isEmpty()) {		
		    for (Vaga vaga : vagas) {
		        if(num == vaga.getNumVaga()) {
		            System.out.println("Erro: Esse número de vaga já está em uso");
		            vagaExiste = true;
		            break;
		        }
		    }
		    if (!vagaExiste) {
				vagas.add(new Vaga(num, tam));
				System.out.println("Vaga criada.");
		    }
		} else {
			vagas.add(new Vaga(num, tam));
			System.out.println("Vaga criada.");
		}

	}
	public static void listarDisp() {
		for (Vaga vaga : vagas) {
			if(vaga.isDisp()) {
				System.out.println(vaga);
			}
		}
	}
	
	public static void editarVaga(int num, int choice) {
		for (Vaga vaga : vagas) {
			if(vaga.isDisp()&&vaga.getNumVaga()==num) {
				switch (choice) {
				case 1: {
					System.out.println("Qual o novo número da vaga?");
					int newNum = scan.nextInt();
					for (Vaga vaga2 : vagas) {
				        if(newNum == vaga2.getNumVaga()) {
				            System.out.println("Erro: Esse número de vaga já está em uso");
				            return;
				        }
				    }
					vaga.setNumVaga(newNum);
					break;
				}
				case 2:{
					System.out.println("Qual o novo tamanho da vaga?\n1 - Pequeno\n2 - Médio\n3 - Grande");
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
					default: {
						System.out.println("Inválido");
					}
				}
					vaga.setTamanho(tam);
					break;
				}
			}
				case 3:{
					System.out.println("Digite \"deletar\" para excluir a vaga permanentemente");
					String del = scan.next();
					if(del.equalsIgnoreCase("deletar")) {
						vagas.remove(vaga);
						System.out.println("Vaga deletada com sucesso.");
						return;
					}
					System.out.println(del);
					System.out.println("Operação cancelada.");
					break;
					
					
				}
				default:{
					System.out.println("Valor inválido");
					break;
				}
				
		}
				return;
	}
			System.out.println("A vaga não existe ou está ocupada.");
	
}}
	public static void listarOcupadas() {
		for (Vaga vaga : vagas) {
			if(!vaga.isDisp()) {
				System.out.println(vaga);
			}
		}
	}
	public static void newCarro(String model, String tam, String placa) {
		Carro carro = new Carro(placa, model, tam);
		for (Vaga vaga : vagas) {
			if(vaga.getTamanho()==carro.getTamanho()&&vaga.isDisp()) {
				vaga.setCarro(carro);
				vaga.setDisp(false);
				System.out.println("O carro foi estacionado na vaga "+vaga.getNumVaga()+" às "+carro.getHoraEntrada());
				return;
			}
		}
		System.out.println("Não há vagas para esse carro.");
		
	}
	public static void checkOut(int num) {
		for (Vaga vaga : vagas) {
			if(!vaga.isDisp()&&vaga.getNumVaga()==num) {
				Carro carro = vaga.getCarro();
				carro.checkOut();
				vaga.setDisp(true);
				historicoCarros.add(carro);
				System.out.println("O carro fez checkout às " + carro.getHoraSaida() +" depois de " + carro.getHoras() + " horas ou "+ carro.getMinutos() + " minutos na vaga, resultando em um valor de R$:"+carro.getValor());
				return;
			}
	}
		System.out.println("Não há nenhum carro nessa vaga.");
		}
	public static void histórico() {
		for (Carro carro : historicoCarros) {
			if(carro.isCompleted()) {
				System.out.println(carro);
			}
		}
	}}
