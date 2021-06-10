package br.jogos;

import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) {
		start();
	}

	public static void start() {
		char tabuleiro[][] = iniciar();
		int jogoAtivo = -1, lin, col;
		char jogador[] = { 'O', 'X' };
		int i = 0;

		Scanner ler = new Scanner(System.in);
		
		System.out.println("\n\t###########################\n\t�---<| JOGO DA VELHA |>---�\n\t###########################");
		while (jogoAtivo == -1) {
			System.out.println("\n� Vez do Jogador [" + jogador[i] + "]\n");
			printGame(tabuleiro);
			// entrada de dados
			System.out.print("\nDigite a linha(0-2) :");
			lin = ler.nextInt();
			System.out.print("Digite a coluna(0-2):");
			col = ler.nextInt();

			// jogada valida
			if (step(tabuleiro, lin, col, jogador[i])) {
				// int status (char M[ ][ ]){...}
				jogoAtivo = status(tabuleiro, jogador[i]);
				// troca a vez do jagador
				// i = (i + 1)%2;
				i = 1 - i;
			} else
				System.out.println("Jogada invalida do [" + jogador[i] + "]");

			// resultado do jogo
		}
		if (jogoAtivo == 0)
			System.out.println("O jogo deu Velha!");
		else if (jogoAtivo == 1)
			System.out.println("\n\t�---<| O jogador [O] ganhou a partida! |>---�\n");
		else
			System.out.println("\n\t�---<| O jogador [X] ganhou a partida! |>---�\n");

		System.out.println("*Agora digite o n�mero referente a sua escolha:\n0 - Jogar novamente\n1 - Voltar para o menu\n2 - Encerrar");
		int escolhafinal = ler.nextInt();
		Menu menu = new Menu(); // Defino o m�todo menu() da Classe Menu para poder cham�-lo no switch case.
		switch (escolhafinal) {
		case 0:
			start(); // Chama o m�todo do jogo da Forca novamente para ser executado.
			break;
		case 1:
			System.out.println("\n\n");
			menu.menu(); // Chama o m�todo do menu() para aparecer o menu.
			break;
		default: // Encerra o jogo por aqui mesmo, agradecendo-o por ter jogado e mostrando os cr�ditos.
			System.out.println("Encerrado, obrigado por jogar! :D\n\n\n\t    §---< Desenvolvedores"
			+ " >---§\n\n     §   Claubson Santos // @oninho_s       §\n     §   Enzo Gama       // @enzox7         §\n"
			+ "     §   Iago Roque      // @iagorockque    §\n     §   Kevin Vasques   // @kevinvasques_  §"
			+ "\n     §   Lucas Emanuel   // @elucasouza     §\n\n §-< https://github.com/iagoroque/Jogos-em-Java >-§");
			break;
		}
	}

	private static char[][] iniciar() {
		// inicia a matriz
		char M[][] = new char[3][3];

		// inicializa a matriz com _ = vazio
		for (int i = 0; i < M.length; i++) // linha
			for (int j = 0; j < M[0].length; j++) // coluna
				M[i][j] = '_';
		return M;
	}

	private static boolean step(char[][] tabuleiro, int lin, int col, char jogador) {
		// se a posicao tiver vazia
		if (tabuleiro[lin][col] == '_') {
			// troc o sinal de (-) pela jogada
			tabuleiro[lin][col] = jogador;
			return true;
		}
		return false;
	}

	private static int status(char[][] tabuleiro, char jogador) {
		int ret = 1; // testando o jogador 'O'

		if (jogador == 'X')
			ret = 2;

		// testa para linha e coluna os dois jogadores
		for (int i = 0; i < tabuleiro.length; i++) {
			// verifica as linhas
			if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
			// verifica a coluna
					(tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador))
				return ret;
		}
		// testar as diagonais
		// diagonal principal
		if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
		// diagonal secundaria
				(tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador))
			return ret;

		ret = 0; // empate
		for (int i = 0; i < tabuleiro.length; i++)
			for (int j = 0; j < tabuleiro[0].length; j++)
				if (tabuleiro[i][j] == '_')
					ret = -1; //

		return ret;
	}

	private static void printGame(char[][] tabuleiro) {
		for (int i = 0; i < tabuleiro.length; i++) { // linha
			for (int j = 0; j < tabuleiro[0].length; j++) // coluna
				System.out.print(tabuleiro[i][j] + " | ");

			System.out.println(); // alinhar tabuleiro
		}
	}

}