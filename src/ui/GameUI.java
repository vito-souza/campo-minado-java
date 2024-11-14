package ui;

/**
 * Interface gráfica do jogo.
 */
public class GameUI {

    /**
     * Método que imprime o campo minado para o usuário no console.
     * 
     * @param game Estado atual do jogo (posição das bombas e bandeiras).
     */
    public static void renderGame(int[][] game) {
        /** Variável utilizada para imprimir o campo de maneira cruzada. */
        int mod = 0;

        for (int[] array : game) {
            for (int node : array) {
                // Se o node possuir ou não uma bomba:
                if (node == 0 || node == 1)
                    System.out.print((mod % 2 == 0) ? "🟩" : "🌳");
                else
                    System.out.print("🚩"); // Usuário colocou uma bandeira.

                mod++; // Incrementando a variável mod para controle do campo.
            }

            System.out.println(); // Pulando uma linha no final.
            mod++; // Incrementando a variável mod para controle do campo.
        }

        for (int[] array : game) {
            for (int node : array) {
                System.out.print(node + " ");
            }

            System.out.println();
        }
    }
}
