package br.com.dio;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner ler = new Scanner(System.in)) {
			System.out.println("=============================");
			System.out.println("Banco digital Victor");
			System.out.println("=============================");
			System.out.printf("Informe o nome do cliente: ");
			System.out.printf(" ");
			String cliente = ler.next();

			Cliente cliente1 = new Cliente();	
			cliente1.setNome(cliente);

			System.out.println("Olá seja bem vindo! " + cliente1.getNome());
			System.out.println("=============================");
			System.out.println("Informe qual conta deseja usar");
			System.out.println("1. Corrente, 2. Poupança");
			int conta = ler.nextInt();

			Conta conta1 = null;

			if(conta == 1) {
				conta1 = new ContaCorrente(cliente1);
			}else if(conta == 2) {
				conta1 = new ContaPoupanca(cliente1);
			}else {
				System.out.println("Informe uma conta valida!");
			}

			System.out.println("=============================");
			System.out.println("Qual operação deseja realizar?");
			System.out.println("1. Depositar, 2. Sacar, 3. Transferir");
			int operacao = ler.nextInt();

			switch (operacao) {
			case 1:
				System.out.println("Informe o valor:");
				double valor1 = ler.nextDouble();
				conta1.depositar(valor1);
				break;
			case 2:
				System.out.println("Informe o valor:");
				double valor2 = ler.nextDouble();
				conta1.sacar(valor2);
				break;
			case 3:
				System.out.println("Informe o valor:");
				double valor3 = ler.nextDouble();
				System.out.println("Informe o nome do cliente:");
				String cliente21 = ler.next();
				Cliente cliente2 = new Cliente();
				cliente2.setNome(cliente21);
				Conta conta2 = new ContaCorrente(cliente2);
				conta1.transferir(valor3, conta2);
				break;
			}
			conta1.imprimirExtrato();
			main(args);
		}


		/*
		 * Cliente cliente1 = new Cliente(); cliente1.setNome("victor"); Cliente
		 * cliente2 = new Cliente(); cliente2.setNome("davi");
		 * 
		 * Conta conta1 = new ContaCorrente(cliente1); conta1.depositar(100); Conta
		 * conta2 = new ContaPoupanca(cliente2); conta1.transferir(40, conta2);
		 * 
		 * conta1.imprimirExtrato(); conta2.imprimirExtrato();
		 */

	}

}
