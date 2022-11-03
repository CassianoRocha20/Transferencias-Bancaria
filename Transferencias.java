package view;

import java.util.ArrayList;
import java.util.Scanner;

import helper.Utils;
import model.Conta;

public class Banco {

	static String nome = " 20 bank ";
	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Conta> contas;

	public static void main(String[] args) {
		Banco.contas = new ArrayList<Conta>();
		Banco.menu();

	}

	public static void menu() {
		int opcao = 0;
		System.out.println("=================================");
		System.out.println("========== ATM ========");
		System.out.println("====== " + Banco.nome + " ====== ");
		System.out.println("=================================");
		System.out.println("Selecione uma opcao no menu: ");
		System.out.println(" 1 - criar conta ");
		System.out.println(" 2 - Efetuar saque ");
		System.out.println(" 3 - Efetuar deposito ");
		System.out.println(" 4 - Efetuar transferencia ");
		System.out.println(" 5 - listar contas  ");
		System.out.println(" 6 - Sair do do sistema ");

		try {
			opcao = Integer.parseInt(Banco.teclado.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Por Favor, informe uma opcao valida.");
			Utils.pausar(2);
			Banco.menu();
		}
		switch (opcao) {
		case 1:
			Banco.criarConta();
			break;
		case 2:
			Banco.efetuarSaque();
			break;
		case 3:
			Banco.efetuarDeposito();
			break;
		case 4:
			Banco.efetuarTransferencia();
			break;
		case 5:
			Banco.listarContas();
			break;
		case 6:
			System.out.println(" ------- Até a Proxima ------- ");
			Utils.pausar(2);
			System.exit(0);

		default:
			System.out.println(" Opcao invalida. ");
			Utils.pausar(2);
			Banco.menu();
			break;
		}

	}

	public static void criarConta() {
		System.out.println("Criando conta ... ");
	}

	public static void efetuarSaque() {
		System.out.println("Efetuando Saque ... ");
	}

	public static void efetuarDeposito() {
		System.out.println("Efetuando Deposito ... ");
	}

	public static void efetuarTransferencia() {
		System.out.println("Efetuando Transferencia ... ");
	}

	public static void listarContas() {
		System.out.println("Listando contas ... ");
	}

}
