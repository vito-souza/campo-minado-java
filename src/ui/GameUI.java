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
        int pattern = 0;
        int line = 0;

        // Gerar cabeçalhos dinamicamente:
        System.out.print("   ");
        for (int col = 0; col < game[0].length; col++) {
            System.out.print((char) ('A' + col) + " ");
        }

        System.out.println(); // Nova linha após os cabeçalhos.

        for (int[] array : game) {

            System.out.printf("%2d ", line);
            for (int node : array) {

                // Se o node possuir ou não uma bomba:
                if (node == 0)
                    System.out.print((pattern % 2 == 0) ? "🟩" : "🌳");
                else if (node == 1)
                    System.out.print("💣");
                else
                    System.out.print("🚩"); // Usuário colocou uma bandeira.

                pattern++; // Incrementando a variável pattern para controle do campo.
            }

            System.out.println(); // Pulando uma linha no final.

            pattern++; // Incrementando a variável mod para controle do campo.
            line++; // Linha.
        }
    }
}
