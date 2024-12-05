package ui;

/**
 * Responsável pela interface gráfica do jogo, exibindo o estado do campo minado
 * no console.
 */
public class GameUI {

    /**
     * Exibe o campo minado no console, representando o estado atual do jogo.
     * 
     * @param game Estado atual do jogo (posição das bombas e bandeiras).
     */
    public static void renderGame(int[][] game) {
        /** Variável utilizada para imprimir o campo de maneira cruzada. */
        int mod = 0, i = 0;

        System.out.println("  A B C D E F G H I J"); // Posições eixo X.
        for (int[] array : game) {

            System.out.print(i + " "); // Posições do eixo Y.
            for (int node : array) {

                // Se o node possuir ou não uma bomba:
                if (node == 0)
                    System.out.print((mod % 2 == 0) ? "🟩" : "🌳");
                else if (node == 1)
                    System.out.print("💣");
                else
                    System.out.print("🚩"); // Usuário colocou uma bandeira.

                mod++; // Incrementando a variável mod para controle do campo.
            }

            System.out.println(); // Pulando uma linha no final.
            mod++; // Incrementando a variável mod para controle do campo.
            i++; // Linha.
        }

        // for (int[] array : game) {
        // for (int node : array) {
        // System.out.print(node + " ");
        // }

        // System.out.println();
        // }
    }
}
