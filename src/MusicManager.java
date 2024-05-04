import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class MusicManager {
    private Clip musicClip;

    public void playMusic(String musicFile, float volume) {
        try {
            if (musicClip != null && musicClip.isRunning()) {
                return; // Si la música ya está sonando, no inicia la reproducción
            }

            URL url = this.getClass().getClassLoader().getResource(musicFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            musicClip = AudioSystem.getClip();
            musicClip.open(audioIn);
            FloatControl volumeControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            volumeControl.setValue(dB);
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        if (musicClip != null && musicClip.isRunning()) {
            musicClip.stop();
        }
    }
}