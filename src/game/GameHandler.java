package game;

import java.util.Random;

import ui.GameUI;

/**
 * Classe que trata os states do jogo.
 */
public class GameHandler {

    /** Para gerar números aleatórios. */
    private Random random = new Random();

    /** Matriz que guarda o estado do jogo. */
    private int[][] game = new int[8][10];

    /** Quantidade de linhas e colunas no jogo. */
    private int rows;
    private int cols;

    /** Quantidade de bombas no jogo. */
    private int bombCount;

    /** Enumeração para os níveis de dificuldade. */
    public enum Difficulty {
        EASY, MEDIUM, HARD
    }

    /**
     * Construtor da classe, que permite definir o tamanho do campo de jogo e a
     * dificuldade.
     */
    public GameHandler(Difficulty difficulty) {
        setDifficulty(difficulty);
    }

    /**
     * Método que inicia um novo jogo.
     */
    public void startGame() {
        resetGame(); // Limpa o estado do jogo para garantir que começa do zero.

        GameUI.renderGame(game);

        // TODO: depois da primeira entrada do usuário, gera um tabuleiro.
        generateGame();
        GameUI.renderGame(game);
    }

    /**
     * Método que define a dificuldade do jogo.
     * Altera o tamanho do campo e o número de bombas com base no nível.
     */
    private void setDifficulty(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                this.rows = 8;
                this.cols = 10;
                this.bombCount = 10;
                break;
            case MEDIUM:
                this.rows = 14;
                this.cols = 18;
                this.bombCount = 40;
                break;
            case HARD:
                this.rows = 20;
                this.cols = 24;
                this.bombCount = 99;
                break;
        }

        this.game = new int[rows][cols];
    }

    /**
     * Método que gera um novo jogo aleatório.
     * 
     * @return Retorna um novo estado (matriz) aleatório para o jogo.
     */
    public void generateGame() {
        /** Quantidade de bombas dentro do jogo. */
        int bombs = 0;

        // Continuar até que 10 bombas sejam posicionadas:
        while (bombs < bombCount) {
            int row = random.nextInt(rows); // Coluna aleatória.
            int col = random.nextInt(cols); // Linha aleatória.

            // Se a posição ainda não tiver bomba:
            if (game[row][col] == 0) {
                game[row][col] = 1; // Coloca a bomba.
                bombs++; // Incrementa o contador.
            }
        }
    }

    /**
     * Método que reseta a matriz do jogo, limpando o estado.
     */
    private void resetGame() {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                game[i][j] = 0; // Limpa todas as células, colocando 0.
            }
        }
    }
}
