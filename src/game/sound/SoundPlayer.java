package game.sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {

    public static void playSound(String sound) {
        File file = new File("./src/resources/" + sound);

        if (!file.exists()) {
            System.err.println("Não foi possível encontrar o arquívo de mídia: \"" + file.getPath() + "\"");
            return;
        }

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();

            clip.open(audio);
            clip.start();
            clip.drain();
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Não foi possível reproduzir o arquivo de mídia: " + e.getMessage());
            e.printStackTrace();
        }
    }
}