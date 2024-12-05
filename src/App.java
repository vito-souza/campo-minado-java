import game.GameHandler;

public class App {
    public static void main(String[] args) {
        GameHandler game = new GameHandler(GameHandler.Difficulty.MEDIUM);
        game.startGame(); // Iniciando o jogo.
    }
}
