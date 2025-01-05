import javax.sound.sampled.*;
import java.io.File;

public class SoundPlayer {
    public void playSound(String fileName) {
        try {
            File soundFile = new File("resources/sounds/" + fileName);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }
}
