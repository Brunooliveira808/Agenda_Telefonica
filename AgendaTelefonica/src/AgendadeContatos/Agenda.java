package AgendadeContatos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Agenda {

	public static void main(String[] args) throws SQLException, IOException {

		Scanner entrada = new Scanner(System.in);
		
		new CriarTable();
		
		while(true) {
			mostrarMenu();
			int opcao = entrada.nextInt();
			switch (opcao) {
			case 1:
				new AdicionarContato();
				printLinha();
				break;
			case 2:
				new ListarContatos();
				printLinha();
				break;
			case 3:
				new ProcurarContato();
				printLinha();
				break;
			case 4:
				new AtualizarContato();
				printLinha();
				break;
			case 5:
				new ExcluirContato();
				printLinha();
				break;
			case 6:
				entrada.close();
				return;
			default:
				printLinha();
				System.out.println("Opção Inválida");
				printLinha();
			}
		}
	}
	
	public static void mostrarMenu() {
		System.out.println("Menu da Agenda de Contatos:");
		System.out.println("[1] Adicionar Contato");
		System.out.println("[2] Listar os Contatos");
		System.out.println("[3] Procurar Contato");
		System.out.println("[4] Atualizar Contato");
		System.out.println("[5] Excluir Contato");
		System.out.println("[6] Sair");
		printLinha();
	}
	
	public static void printLinha() {
		System.out.println("-----------------------------------------------------------");
	}
}
