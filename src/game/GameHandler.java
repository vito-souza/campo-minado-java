package game;

import java.util.Random;

import enums.Difficulty;
import game.ui.GameUI;

public class GameHandler {

    private GameUI ui = new GameUI();
    private Random random = new Random();
    private int[][] game;
    private int rows;
    private int cols;
    private int bombCount;

    public GameHandler(Difficulty difficulty) {
        setDifficulty(difficulty);
    }

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

    public void startGame() {
        resetGame();
        ui.renderGame(game);

        // TODO: depois da primeira entrada do usuário, gera um tabuleiro.
    }

    public void generateGame() {
        int bombs = 0;

        while (bombs < bombCount) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if (game[row][col] == 0) {
                game[row][col] = 1;
                bombs++;
            }
        }
    }

    public void getInput(String input) {
        if (!isValidInput(input)) {
            System.out.println("Entrada inválida! Tente novamente.");
            return;
        }

        int column = input.charAt(0) - 'A';
        int row = Integer.parseInt(input.substring(1)) - 1;

        System.out.println("Coluna (índice): " + column);
        System.out.println("Linha: " + row);
    }

    private boolean isValidInput(String input) {
        if (input.length() < 2 || !Character.isLetter(input.charAt(0)) || !input.substring(1).matches("\\d+")) {
            return false;
        }

        int column = input.charAt(0) - 'A';
        int row = Integer.parseInt(input.substring(1)) - 1;

        return column >= 0 && column < cols && row >= 0 && row < rows;
    }

    private void resetGame() {
        game = new int[rows][cols];
    }
}
