import game.GameHandler;

public class App {
    public static void main(String[] args) {
        GameHandler game = new GameHandler(GameHandler.Difficulty.HARD);
        game.startGame(); // Iniciando o jogo.
    }
}
