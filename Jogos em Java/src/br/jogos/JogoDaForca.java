package br.jogos;

import java.util.Random;  // Biblioteca do Random, usada para escolher uma palavra aleatoriamente dentro da String[].
import java.util.Scanner; // Biblioteca do Scanner, usada para pegar e ler dados inseridos no console.

public class JogoDaForca {

	public static void main(String[] args) { // M�todo principal
		start(); // Caso essa classe seja executada sem o uso da classe de "Menu", ela poder� chamar o m�todo "executar" normalmente.
	}
	
	public static String desenhoForca(int chances) { // M�todo com o desenho em console da forca.
		String[] forca = { "  ______\n |      |\n |\n |\n |\n_|_\n", "  ______\n |      |\n |      O\n |\n |\n_|_\n",
				"  ______\n |      |\n |      O\n |      |\n |\n_|_\n",
				"  ______\n |      |\n |      O\n |     /|\n |\n_|_\n",
				"  ______\n |      |\n |      O\n |     /|\\\n |\n_|_\n",
				"  ______\n |      |\n |      O\n |     /|\\\n |     /\n_|_\n",
				"  ______\n |      |\n |      O\n |     /|\\\n |     / \\\n_|_\n" };
		String desenhoForca = forca[chances];
		return desenhoForca;
	}
	
	public static void seGanhou(int chances, String pSorteada) { // M�todo que exibe a mensagem se a pessoa ganhou ou n�o a partir da quantidade de chances que restou.
		if (chances > 0) { // Se o usu�rio ainda estiver com alguma chance sobrando ap�s encerrar o jogo, significa que ela finalizou o jogo e ganhou ele.
			System.out.println("\n\n\t�---<| Jogo finalizado, voc� ganhou, parab�ns! |>---�\n");
		} else { // Se ele n�o tiver nenhuma chance sobrando, significa que ele finalizou o jogo por causa que ele acabou com todas as suas chances e perdeu o jogo.
			System.out.println("\n\n\t�---<| Jogo finalizado, voc� foi enforcado! A palavra era: " + pSorteada + " |>---�\n");
		}
	}

	public static void start() { // M�todo onde realmente est� todo o jogo, e esse ser� o m�todo chamado pela classe "Menu".
		
		// Random para escolher uma palavra aleatoriamente dentro do array, e a abertura do Scanner.
		Random random = new Random();
		Scanner in = new Scanner(System.in);
		
		// String[] onde ficam armazenada as palavras da forca, todas em letra mai�scula e sem acentos ou caracteres especiais.
		String[] palavras = { "ANIMAL", "FRUTA", "CIDADE", "PALAVRA", "UNIVERSIDADE", "JOGO", "FORCA", "BIBLIOTECA",
				"ECLIPSE", "JAVA", "INTERNET", "COMPUTADOR", "ALGORITMO", "CONSTANTE", "RECORDE", "TEMPO", "BRASIL",
				"BAHIA", "SALVADOR", "PROCESSADOR", "ATIVIDADE", "REDE", "MUNDO", "PLANETA", "SISTEMA", "BATALHA",
				"GUERRA", "PAZ", "AMOR", "INFINITO", "ARQUIVO", "CLASSE", "UNIDADE", "CAPITAL", "DINHEIRO", "DATA",
				"TEMPO", "VIDA", "DIAS", "HORA", "MINUTO", "SEGUNDO", "ANO", "SEMANA", "MULHER", "HOMEM", "MAGIA",
				"TECNOLOGIA", "MAR", "OCEANO", "TERRA", "ARQUITETURA", "ENGENHARIA", "SOFTWARE", "ENERGIA", "MASSA" };

		int qPalavras = palavras.length; // Var tipo int para receber a quantidade de palavras que existem dentro de "palavras[]"
		int indSorteado = random.nextInt(qPalavras); // O random l� o int "qPalavras" e escolhe um n�mero aleatoriamente, que depois � recebida na var "indSorteado".
		String pSorteada = palavras[indSorteado]; // Com um n�mero escolhido aleatoriamente pelo random dentro da quantidade de palavras existentes, a var "pSorteada"
		                                          //vai receber a palavra que est� no �ndice do array que o random escolheu aleatoriamente.

		char[] acertos = new char[pSorteada.length()]; // A var "acertos[]" � criada com o tamanho definido pela quantidade de caracteres que tem na palavra sorteada.
		for (int i = 0; i < acertos.length; i++) { // Esse for � para atribuir a todos os caracteres do "acertos[]" o valor 0, pois depois
			acertos[i] = 0;                        // esse par�metro ser� utilizado ou para mostrar "_" ou a letra que a pessoa acertou"
		}
		
		String lUtilizadas = ""; // Var que vai guardar as letras utilizadas.
		char letra; // Var que vai receber as letras digitadas pelo usu�rio.
		boolean ganhou = false; // Var que vai definir se o jogo ir� continuar no do/while ou n�o, pois verifica se o jogador ganhou ou perdeu.
		int chances = 6; // Quantidade de erros que a pessoa pode cometer, e � equivalente a quantidade de partes desenhadas do boneco da forca.

		//Aqui � onde come�a a ser mostrado o jogo no console.
		System.out.println("\n\tA _ C _ E _ G _ I _ K _ M _\n\t�---<| JOGO DA FORCA |>---�\n\t_ B _ D _ F _ H _ J _ L _ N\n");
		System.out.println("*Uma entre " + qPalavras + " palavras diferentes foi escolhida para voc�, boa sorte!*");
		System.out.println(desenhoForca(0)); // Mostra a forca pela primeira vez quando executado.
		for (int i = 0; i < pSorteada.length(); i++) { // Mostra as "_" que ser�o substituidas pelos caracteres da palavra.
			System.out.print("_ ");
		}
		
		do { // � a partir desse do/while que o jogo se repete
			System.out.print("\n\nLetras utilizadas:" + lUtilizadas + "\nDigite uma letra: "); // Mostra as letras utilizadas e pede para digitar uma letra.
			letra = in.next().toUpperCase().charAt(0); // Recebe a letra digitada com o uso do scanner, tranforma ela em mai�scula caso n�o esteja com o uso do
			// .toUpperCase(), e o 0 no charAt() para pegar a primeira letra digitada.
			lUtilizadas += " " + letra; // Vai juntando as letras digitas para mostrar para o usu�rio.

			boolean perdeChance = true; // Declaro perdeVida como sendo verdadeira.
			for (int i = 0; i < pSorteada.length(); i++) { // Verifica se a letra digitada � compat�vel com algum caractere da palavra sorteada.
				if (letra == pSorteada.charAt(i)) { // Se sim, ele altera a posi��o daquela letra no array acertos[] de 0 para 1 para posteriormente ser utilizado.
					acertos[i] = 1;
					perdeChance = false; // E ainda altera perdeChance para false para indicar naquela jogada que o usu�rio n�o perdeu uma chance.
				}
			}
			if (perdeChance) { // Se perdeChance for verdadeira, perco uma chance, se n�o, continuo com a mesma quantidade de chances.
				chances--;
			}
			
			switch (chances) { // A partir da quantidade de chances que a pessoa tem, � determinado o desenho da forca que ser� mostrado.
			case 6:
				System.out.println(desenhoForca(0));
				break;
			case 5:
				System.out.println(desenhoForca(1));
				break;
			case 4:
				System.out.println(desenhoForca(2));
				break;
			case 3:
				System.out.println(desenhoForca(3));
				break;
			case 2:
				System.out.println(desenhoForca(4));
				break;
			case 1:
				System.out.println(desenhoForca(5));
				break;
			case 0:
				System.out.println(desenhoForca(6));
				break;
			default:
				break;
			}
			
			ganhou = true; // ganhou � definida como verdadeira, sendo assim, o do/while j� pode encerrar.
			for (int i = 0; i < pSorteada.length(); i++) { // for que verifica se "acertos[]" continuar com 0, ele ir� mostrar "_", mas se a pessoa acertar
				if (acertos[i] == 0) {                     // a letra, ele ir� mostrar a letra digitada no lugar correto.
					System.out.print("_ ");
					ganhou = false;                        // Aqui o do while � definida como false para que no do/while reconhecer como ganhou verdadeira,
				} else {                                   // pois no do/while, ele verificar o valor oposto do valor booleano por causa do "!".
					System.out.print(pSorteada.charAt(i) + " "); // Mas se n�o existir mais nenhum vetor sendo 0 em "acertos[]", ele vai mostrar a letra correspondente
				}                                                // aquela posi��o e n�o vai alterar ganhou, deixando com o valor true
			}
			
		} while ((!ganhou) && (chances > 0)); // Se o valor de ganhou for true e a quantidade de chances for maior que 0, o while se encerra, encerrando assim o jogo.
		// Ou basicamente se ele n�o ganhou e ainda tem chances, o jogo se repete.
		
		seGanhou(chances, pSorteada); // O m�todo que confere se a pessoa ganhou ou perdeu pela quantidade de chances � chamado.

		// Aqui aparece uma escolha no console para o usu�rio definir o que deseja ap�s ter terminado o jogo.
		System.out.println("*Agora digite o n�mero referente a sua escolha:\n0 - Jogar novamente\n1 - Voltar para o menu\n2 - Encerrar");
		int escolhafinal = in.nextInt();
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

}