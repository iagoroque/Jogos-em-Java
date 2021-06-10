package br.jogos;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) { // M�todo principal
		menu(); // Chama o m�todo "menu()" para exibir o menu no console e a escolha do jogo.
	}

	public static void menu() { // M�todo onde est� o menu dos jogos que ser� exibido em console.
		Scanner in = new Scanner(System.in);
		System.out.println("Bem-vindo aos Jogos de LPA feitos em Java!\n"
				+ "Para escolher um jogo, digite o n�mero correspondente:\n1 - Jogo da Forca\n"
				+ "2 - Batalha Naval\n3 - Jogo da Velha\n4 - Sair e encerrar o c�digo");
		int escolha = in.nextInt();
		jogos(escolha); // Chama o m�todo "jogos()" inserindo o par�metro de escolha de jogo que o usu�rio digitou.
	}

	public static void jogos(int ind) {         // M�todo para chamar os m�todos de execu��o das classes dos jogos, sendo chamada a que o usu�rio escolheu atrav�s do switch case.
		JogoDaForca jogoF = new JogoDaForca();
		BatalhaNaval jogoB = new BatalhaNaval();// Aqui declaro as vari�veis para receber as classe dos jogos.
		JogoDaVelha jogoV = new JogoDaVelha();
		switch (ind) {                          // Switch case para decidir qual jogo executar a partir do valor digitado pelo usu�rio.
		case 1:
			jogoF.start();
			break;
		case 2:
			jogoB.start();
			break;
		case 3:
			jogoV.start();
			break;
		case 4:
			System.out.println("Encerrado, obrigado por jogar! :D\n\n\n\t �---< Desenvolvedores"
					+ " >---�\n\n   �   Claubson Santos // @oninho_s     �\n   �   Enzo Gama       // @enzox7       �\n"
					+ "   �   Iago Roque      // @iagorockque  �\n   �   Kevin Vasques   // @kevinvasques_�"
					+ "\n   �   Lucas Emanuel   // @elucasouza   �");
			break;
		default:
			System.out.println("Encerrado.\n\n\n\t �---< Desenvolvedores"
					+ " >---�\n\n   �   Claubson Santos // @oninho_s     �\n   �   Enzo Gama       // @enzox7       �\n"
					+ "   �   Iago Roque      // @iagorockque  �\n   �   Kevin Vasques   // @kevinvasques_�"
					+ "\n   �   Lucas Emanuel   // @elucasouza   �");
			break;
		}
	}
}