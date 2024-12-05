package game;

import java.util.Random;

import ui.GameUI;

/**
 * Classe que trata os states do jogo.
 */
public class GameHandler {

    /** Para gerar números aleatórios. */
    private static Random random = new Random();

    /**
     * Método que inicia um novo jogo.
     */
    public static void startGame() {
        // Iniciando o jogo:
        GameUI.renderGame(generateGame());
    }

    /**
     * Método que gera um novo jogo aleatório.
     * 
     * @return Retorna um novo estado (matriz) aleatório para o jogo.
     */
    public static int[][] generateGame() {
        /** Matriz que guarda o estado do jogo. */
        int[][] game = new int[8][10];

        /** Quantidade de bombas dentro do jogo. */
        int bombs = 0;

        // Preenchendo o jogo com números aleatórios:
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                // Se ainda não tiver 10 bombas:
                if (bombs <= 10) {
                    int node = random.nextInt(2);
                    game[i][j] = node; // Atribuindo o valor de bomb.

                    // Se for uma bomba:
                    if (node == 1)
                        bombs++; // Incrementando o contador de bombas.
                } else {
                    game[i][j] = 0; // É só grama!!
                }
            }
        }

        return game; // Retorando o novo jogo aleatório.
    }
}
