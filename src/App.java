import enums.Difficulty;
import game.GameHandler;

public class App {
    public static void main(String[] args) {
        GameHandler game = new GameHandler(Difficulty.MEDIUM);
        game.startGame();
    }
}
