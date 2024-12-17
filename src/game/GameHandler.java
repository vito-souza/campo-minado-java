package game;

import java.util.Random;

import enums.Difficulty;
import game.ui.GameUI;

public class GameHandler {

    private GameUI gameUi = new GameUI();
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
        gameUi.renderGame(game);

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

    private void resetGame() {
        game = new int[rows][cols];
    }
}
