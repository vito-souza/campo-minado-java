package sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Classe responsável por reproduzir arquivos de áudio no formato compatível com
 * Java Sound API.
 * A classe busca o arquivo de áudio no diretório "./src/resources/" e o
 * reproduz usando um {@link Clip}.
 */
public class SoundPlayer {

    /**
     * Reproduz o arquivo de áudio especificado.
     * 
     * @param sound O nome do arquivo de áudio a ser reproduzido, com o caminho
     *              relativo.
     *              O arquivo deve estar localizado na pasta "./src/resources/".
     */
    public static void playSound(String sound) {
        File file = new File("./src/resources/" + sound); // Arquivo que será reproduzido.

        if (!file.exists()) {
            System.err.println("Não foi possível encontrar o arquívo de mídia: \"" + file.getPath() + "\"");
            return;
        }

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(file); // Obtem o fluxo de áudio.
            Clip clip = AudioSystem.getClip(); // Gera um clip para reproduzir o áudio.

            clip.open(audio); // Abre o clip com o áudio.
            clip.start(); // Reproduz o áudio.
            clip.drain();
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Não foi possível reproduzir o arquivo de mídia: " + e.getMessage());
            e.printStackTrace();
        }
    }
}