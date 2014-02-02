package ticTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ce programme est suffisament clair pour que vous puissiez le comprendre sans
 * commentaires, neanmoins je les ai rajoutes afin pour vous appreniez a lire un
 * programme, afin que la prochaine fois vous n'ayez effectivement plus besoin
 * d'eux
 * 
 * Relisez attentivement cette proposition de corrige, plusieurs fois. Soyez
 * attentif a la structure du code : fonctions courtes qui appellent d'autres
 * fonctions dont les noms sont suffisament explicites pour ne pas a avoir a
 * regarder le code pour savoir basiquement ce qu'elles font. Notez aussi que
 * chaque fontion a un role particulier, ce qui permet de faciliter les
 * modifications ulterieures de code : si vous voulez rajouter des
 * fonctionalites, implementez les en petites fonctions et rajoutez d'autres
 * fonctions pour ne fais qu'une seul d'appel de fonction (exemple :
 * startNewRound)
 * 
 * BREF relisez ce code, et essayez ensuite de developper votre propre code, de
 * maniere sans aucun doute differente. Pour cela je vous conseille de commencer
 * par decouper en fonctionnalites principales : l'affichage et le jeu en lui
 * meme sont deux choses differentes. Dans le jeu, inserer un "pion" quelque
 * part est tres different d'analyser le resultat. Donc decoupez votre programme
 * en petits modules sur une feuille avant meme de commencer a coder (ou si vous
 * etes quelqu'un de civilise dans un .txt :p ).
 * 
 * Important, n'essayez pas tout de suite de faire des petites fonctions de 5 ou
 * 6 lignes, commencez tout d'abord par faire des corps de fonctions dans lequel
 * vous serez plus a l'aise, 20 - 30 lignes, afin d'avoir un debut de resultat.
 * Bref, commencez par developper une fonction (afficher le jeu par exemple).
 * Ensuite quand elle fonctionne, vous reperez les repetitions de code => ca
 * doit etre une fonction. Vous ecrivez cette fonction, vous l'implementez, vous
 * verifiez que ca fonctionne... Vous le faites jusqu'a ce qu'il n'y ait plus de
 * repetition de code.
 * 
 * Alors commence la partie la plus interessante du decoupage en fonctions : le
 * decoupage par fonctionnalite. Vous devez indentifier des parties de code dans
 * vos grandes fonctions qui correspondent a une fonctionnalite particuliere.
 * Regroupez alors cette fonctionnalite sous un nom explicite : c'est une
 * fonction.
 * 
 * Obligez vous a faire ce travail de mapping sur cet exercice simple (si si
 * vous le trouverez tres simple dans quelques semaines ^.^) en exercie afin de
 * progresser. Ca peut vous sembler futile dans un fichier de 250 lignes (sans
 * les commentaires), mais dans un projet de plusieurs milliers de lignes (pour
 * un projet isep, plusieurs millions dans le cadre professionnel) il est
 * indispensable que le code soit lisible. C'est pour ca qu'il est indispensable
 * que le code soit decoupe en fontions courtes avec des noms comprenhensibles
 * 
 * Et bien sur n'oubliez pas d'utiliser les conventions camelCase pour nommer
 * fonctions et variables !
 * 
 * Courage ;) ca paye !!
 * 
 * N'hesitez pas a me contacter pour toute question
 * 
 * @author emilien boulben e.boulben@juniorisep.com
 * 
 */
public class TicTacToeFirst {

	/*
	 * le main est la premiere fonction appellee. je n'aime pas travailler dans
	 * le main car on ne sait pas immediatement ce qui s'y passe. J'ai prefere
	 * creer puis appeler la methode startGame, plus explicite par son nom
	 */
	public static void main(String[] args) {
		startGame();
	}

	/*
	 * En lisant cette fonction vous savez immediatement ce que fait le
	 * programme. Il cree un plateau de jeu vide, ensuite tant que le jeu n'est
	 * pas termine, on joue un tour. A la fin du jeu on affiche la grille finale
	 * (on se doute ici qu'elle affichee dans playRound afin de permettre de
	 * jouer)
	 * 
	 * Donc comme vous le voyez, un programme avec des noms de variables et
	 * fonctions explicites et des fonctions courte est tres facilement
	 * comprehensible
	 * 
	 * Il y a juste un petit detail qui devrait vous surprendre : pourquoi
	 * gameEnded est-il un tableau de boolean d'une seule case et non un
	 * boolean?
	 * 
	 * Tout d'abord, non ca ne prend particulierement plus de memoire, pour des
	 * raisons que je n'expliciterai pas ici (ce sont des notions que nous
	 * aborderons en formations java avancees en fin du semestre).
	 * 
	 * Lorsqu'on passe un type primitif en argument d'une fonction, celui-ci est
	 * copie. Si vous faites une fonction
	 * 
	 * void add(int x, int y) { x += y; }
	 * 
	 * appellee dans ce contexte :
	 * 
	 * void main() { int x = 2, y = 3; add(x, y); System.out.println(x + " - " +
	 * y); }
	 * 
	 * malgre que la fonction soit appelle sur x et y, la valeur de x
	 * lorsqu'elle est afichee dans la console est 2. En effet, dans la fonction
	 * add les valeurs de x et y sont copiees afin de les utiliser. Il faudrait
	 * que la fonction returne un int et qu'on assigne sa valeur a x pour
	 * modifier sa valeur.
	 * 
	 * A present si vous essayez le code ci-dessous (copiez le dans eclipse puis
	 * hop ctrl + shift + f) :
	 * 
	 * void add(int[] x, int[] y) { int lenght = (x.lenght < y.lenght)? x.lenght
	 * : y.lenght; for(int i = 0; i < lenght; i++) { x[i] += y[i]; } }
	 * 
	 * void printArray(int[] arrayToPrint) { for(int i = 0; i <
	 * arrayToPrint.lenght; i++) { System.out.print(arrayToPrint[i] + "  "); }
	 * System.out.println(); }
	 * 
	 * void main() { int[] x = {1, 2, 3}; int[] y = {10, 20, 30}; add(x, y);}
	 * 
	 * Surprise, les valeurs de x ont ete modifiees ! En effet, un tableau n'est
	 * pas un type primitif, c'est un objet assez lourd. Alors pour eviter
	 * d'encombrer la memoire, les fonctions ne copient pas les arguments, mais
	 * leur adresse en memoire : c'est ce qu'on appelle un pointeur. Cela
	 * signifie que lorsqu'on manipule un objet dans une fonction, tant qu'on ne
	 * cree pas une nouvelle instance de l'objet on modifie l'objet lui-meme,
	 * pas une copie de l'objet.
	 * 
	 * Donc pourquoi un tableau de boolean avec un seul membre ? Mais pour cette
	 * raison ! Cela permettra de changer la valeur de gameEnded sans avoir a
	 * retourner la valeur. Si nous en avons besoin nous pourrons alors
	 * retourner d'autrs valeurs. C'est une petite astuces tres agreable a
	 * utiliser.
	 */
	private static void startGame() {
		int[][] gameBoard = createEmptyBoard(3);
		boolean[] gameEnded = { false };
		while (!gameEnded[0])
			playRound(gameBoard, gameEnded);
		printGame(gameBoard);
	}

	private static int[][] createEmptyBoard(int size) {
		int[][] gameBoard = new int[size][size];
		return fillBoardWith(0, gameBoard);
	}

	/*
	 * Je ne commenterai pas ce que fait la fonction puisque c'est evident, mais
	 * je vous fais remarquer que je n'ai pas utilise d'acolades pour mes for.
	 * C'est une petite astuce d'ecriture, lorsque l'instruction (dans une
	 * boulce ou une condition) tient sur une ligne, on n'a pas beosin de mettre
	 * d'accolades. D'ou le double for imbrique ainsi.
	 */
	private static int[][] fillBoardWith(int value, int[][] board) {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				board[i][j] = value;
		return board;
	}

	/*
	 * Remarquez ici comment les fonctions se suivent les unes apres les autres
	 * par appel. Cela permet de parcourir tres rapidement le code qui est
	 * appele.
	 */
	private static void playRound(int[][] gameBoard, boolean[] gameEnded) {
		startNewRound(gameBoard, gameEnded, "Player 1");
		if (!gameEnded[0])
			startNewRound(gameBoard, gameEnded, "Player 2");
	}

	private static void startNewRound(int[][] gameBoard, boolean[] gameEnded,
			String player) {
		printGame(gameBoard);
		playersPlay(gameBoard, player);
		gameEnded[0] = isGameEnded(gameBoard);
	}

	/*
	 * Toute la partie d'affichage est typiquement un exemple de decoupage de
	 * fonction apres premiere ecriture : j'ai decoupe par fonctionnalite ce qui
	 * m'a permis par la suite d'ameliorer mon code en l'optimisant
	 */
	private static void printGame(int[][] board) {
		for (int i = 0; i < board[0].length; i++) {
			if (i != 0)
				printHorizontalSeparation(board.length * 4 - 1);
			printLine(getLineInBoardAtIndex(i, board));
		}
	}

	private static void printHorizontalSeparation(int numberOfCharacters) {
		for (int i = 0; i < numberOfCharacters; i++)
			System.out.print("-");
		System.out.print("\n");
	}

	private static int[] getLineInBoardAtIndex(int index, int[][] board) {
		int[] line = new int[board.length];
		for (int i = 0; i < line.length; i++)
			line[i] = board[i][index];
		return line;
	}

	/*
	 * Ici on remarque rellement un decoupage pour la lisibilite. On lit cette
	 * fonction on sait ce qu'elle fait, et lorsqu'on va a la fonction
	 * suivante...
	 */
	private static void printLine(int[] line) {
		for (int i = 0; i < line.length; i++)
			printCaseInLineAtIndex(line, i);
	}

	/*
	 * On comprend immediatement le code ici. On imprime le contenu de la case,
	 * et si ce n'est pas la derniere case on rajoute une barre verticale, sinon
	 * on revient a la ligne. Ca se lit comme une phrase : on se rend vraiment
	 * compte qu'un language informatique porte bien son nom de language
	 */
	private static void printCaseInLineAtIndex(int[] line, int index) {
		printCaseContent(line[index]);
		if (!isLastCaseOfLine(index, line))
			printVerticalSeparation();
		else
			System.out.print("\n");
	}

	private static boolean isLastCaseOfLine(int index, int[] line) {
		return (index == line.length - 1) ? true : false;
	}

	private static void printCaseContent(int content) {
		System.out.print(' ' + analyseCaseContent(content) + ' ');
	}

	private static String analyseCaseContent(int content) {
		if (content < 0)
			return "O";
		else if (content > 0)
			return "X";
		else
			return "-";
	}

	private static void printVerticalSeparation() {
		System.out.print("|");
	}

	private static void playersPlay(int[][] gameBoard, String player) {
		printMessage(player);
		int[] playerMove = getPlayerMove(gameBoard);
		changeBoardWithPlayerMove(gameBoard, playerMove);
	}

	private static void printMessage(String player) {
		System.out.println("\n" + player + ", please play :");
	}

	private static int[] getPlayerMove(int[][] gameBoard) {
		int column = getSecureCoordonateFromPlayer(gameBoard.length, "column");
		int line = getSecureCoordonateFromPlayer(gameBoard[column - 1].length,
				"line");
		int[] coordonates = { column, line };
		return coordonates;
	}

	/*
	 * Ici le nom de la fonction est tres important, il informe de plusieurs
	 * choses : 1. nous allons recuperer des informations de la part de
	 * l'utilisateur, 2. ces informations seront securisees. Cette seconde
	 * information est tres importante car elle signifie que les tests ont deja
	 * ete fait. Ainsi on peut utiliser cette fonction sans se preocupper de la
	 * pertinence du resultat : nous faisons confaince au developpeur qui a
	 * utilise ce nom de fonction pour une raison bien precise.
	 */
	private static int getSecureCoordonateFromPlayer(int sizeMax,
			String typeOfCoordonate) {
		int playersInput = 0;
		String message = "Please enter the number of the " + typeOfCoordonate
				+ " (from 1 to " + sizeMax + ") :";
		do
			playersInput = getIntegerFromPlayerAbout(message);
		while (playersInput <= 0 || playersInput > sizeMax);
		return playersInput;
	}

	private static int getIntegerFromPlayerAbout(String message) {
		int valueToReturn = 0;
		System.out.println(message);
		try {
			valueToReturn = new Scanner(System.in).nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please put an integer");
		}
		return valueToReturn;
	}

	private static void changeBoardWithPlayerMove(int[][] gameBoard,
			int[] playerMove) {
		boolean isFirstPlayerTurn = (getSumOfBoardsContent(gameBoard) < 0) ? true
				: false;
		if (isFirstPlayerTurn)
			gameBoard[playerMove[0] - 1][playerMove[1] - 1] = 1;
		else
			gameBoard[playerMove[0] - 1][playerMove[1] - 1] = -1;
	}

	private static int getSumOfBoardsContent(int[][] board) {
		int sum = 0;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				sum += board[i][j];
		return sum;
	}

	/*
	 * ici, nous cherchons d'abord a savoir si un des joueurs a gagne. Ensuite
	 * nous regardons si la grille est pleine. alors : si il y a un gagnant ou
	 * renvoie true, sinon on informe si la grille ets pleine et donc si le jeu
	 * est termine
	 */
	private static boolean isGameEnded(int[][] gameBoard) {
		boolean thereIsOneWinner = isThereWinner(gameBoard);
		boolean gridIsFull = isGridFull(gameBoard);
		return (thereIsOneWinner) ? true : gridIsFull;
	}

	private static boolean isThereWinner(int[][] gameBoard) {
		boolean diagonalFull = areDiagonalsFull(gameBoard);
		boolean lineOrColumnFull = isThereLineOrColumnFull(gameBoard);
		return (diagonalFull || lineOrColumnFull) ? true : false;
	}

	private static boolean isThereLineOrColumnFull(int[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++)
			for (int j = i; j < gameBoard[i].length; j++)
				if (isColumnFull(gameBoard, i) || isLineFull(gameBoard, j))
					return true;
		return false;
	}

	private static boolean isColumnFull(int[][] gameBoard, int theColumn) {
		for (int i = 1; i < gameBoard[theColumn].length; i++)
			if (gameBoard[theColumn][i] != gameBoard[theColumn][i - 1]
					|| gameBoard[theColumn][i] == 0)
				return false;
		return true;
	}

	private static boolean isLineFull(int[][] gameBoard, int theLine) {
		for (int i = 1; i < gameBoard.length; i++)
			if (gameBoard[i][theLine] != gameBoard[i - 1][theLine]
					|| gameBoard[i][theLine] == 0)
				return false;
		return true;
	}

	private static boolean areDiagonalsFull(int[][] gameBoard) {
		boolean firstDiagonalFull = isFirstDiagonalFull(gameBoard);
		boolean secondDiagonalFull = isSecondDiagonalFull(gameBoard);
		return (firstDiagonalFull || secondDiagonalFull) ? true : false;
	}

	private static boolean isFirstDiagonalFull(int[][] gameBoard) {
		for (int i = 1, j = 1; i < gameBoard.length; i++, j++)
			if (gameBoard[i][j] != gameBoard[i - 1][j - 1]
					|| gameBoard[i][j] == 0)
				return false;
		return true;
	}

	private static boolean isSecondDiagonalFull(int[][] gameBoard) {
		for (int i = 1, j = 1; i < gameBoard.length; i++, j++)
			if (gameBoard[i][gameBoard[i].length - j - 1] != gameBoard[i - 1][gameBoard[i].length
					- j]
					|| gameBoard[i][gameBoard[i].length - j - 1] == 0)
				return false;
		return true;
	}

	private static boolean isGridFull(int[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++)
			for (int j = 0; j < gameBoard[i].length; j++)
				if (gameBoard[i][j] == 0)
					return false;
		return true;
	}
}
