package game.ui;

public class GameUI {

    public void renderGame(int[][] game) {
        int pattern = 0;
        int line = 1;

        System.out.print("    ");
        for (int col = 0; col < game[0].length; col++) {
            System.out.print((char) ('A' + col) + " ");
        }

        System.out.println();

        for (int[] array : game) {

            System.out.printf("%2d ", line);
            for (int node : array) {

                if (node == 0)
                    System.out.print((pattern % 2 == 0) ? "🟩" : "🌳");
                else if (node == 1)
                    System.out.print("💣");
                else
                    System.out.print("🚩");

                pattern++;
            }

            System.out.println();

            pattern++;
            line++;
        }
    }
}
