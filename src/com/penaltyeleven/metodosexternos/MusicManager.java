package com.penaltyeleven.metodosexternos;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Clase que permite reproducir sonidos y música en un juego.
 *
 * @version 1.0
 * @since 1.0
 */
public class MusicManager {
    private Clip musicClip;

    /**
     * Reproduce un sonido.
     *
     * @param soundFile Archivo de sonido a reproducir.
     * @param volume Volumen del sonido (0.0 - 1.0).
     */
    public void playSound(String soundFile, float volume) {
        try {
            // Abrir un audio input stream
            URL url = this.getClass().getClassLoader().getResource(soundFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

            // Obtener un clip de sonido
            Clip clip = AudioSystem.getClip();

            // Abrir el clip de audio y cargar muestras de audio del audio input stream
            clip.open(audioIn);

            // Obtener el control de volumen
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Convertir el volumen en decibelios
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            volumeControl.setValue(dB);

            // Iniciar la reproducción
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reproduce música.
     *
     * @param musicFile Archivo de música a reproducir.
     * @param volume Volumen de la música (0.0 - 1.0).
     */
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

    /**
     * Detiene la reproducción de la música.
     */
    public void stopMusic() {
        if (musicClip != null && musicClip.isRunning()) {
            musicClip.stop();
        }
    }
}