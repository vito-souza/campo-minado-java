package game;

import ui.GameUI;

/**
 * Classe que trata os states do jogo.
 */
public class GameHandler {

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
        /** Matriz que guarda o estado do jogo */
        int[][] game = new int[8][10];

        /** Quantidade de bombas dentro do jogo */
        int bombs = 0;

        // Preenchendo o jogo com números aleatórios:
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                // Se ainda não tiver 10 bombas:
                if (bombs <= 10) {
                    int node = (int) (Math.random() * 2);
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

    /**
     * Função utilizada para que o usuário possa fazer uma jogada.
     * 
     * @param lin  Posição Y da célula.
     * @param col  Posição X da célula.
     * @param game Estado atual do jogo.
     * @return Retornando o novo estado do jogo.
     */
    public static int[][] play(int lin, int col, int[][] game) {
        // Verifica se a posição é válida no tabuleiro:
        if (lin < 0 || lin >= game.length || col < 0 || col >= game[0].length)
            throw new IllegalArgumentException("Posição inválida no campo.");

        // Se a célula ainda não foi selecionada:
        if (game[lin][col] == 0)
            game[lin][col] = 3; // Node "jogado"
        else if (game[lin][col] == 1)
            gameOver(); // Encerra o jogo.

        return game; // Retornando o novo estado da matriz de jogos.
    }

    /**
     * Método que encerra o jogo.
     */
    public static void gameOver() {
        // "Animação" do campo explodindo.
        GameUI.renderGame(null);
        System.exit(0); // Encerrando a aplicação.
    }
}
