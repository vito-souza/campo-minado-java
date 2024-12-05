package game;

import java.util.Collections;
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

        // Continuar até que 10 bombas sejam posicionadas:
        while (bombs < 10) {
            int col = random.nextInt(8); // Coluna aleatória.
            int lin = random.nextInt(10); // Linha aleatória.

            // Se a posição ainda não tiver bomba:
            if (game[col][lin] == 0) {
                game[col][lin] = 1; // Coloca a bomba.
                bombs++; // Incrementa o contador.
            }
        }

        return game; // Retorando o novo jogo aleatório.
    }
}
