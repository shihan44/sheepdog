package sheepdog;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Klasa do efektow dzwiekowych
 *
 * @author PAWEŁ
 */
public class Efekty {

    /**
     * pusty konstruktor
     */
    public Efekty() {

    }

    /**
     * metoda wywolujaca dzwiek owcy
     */
    public static void sound() {

        playSound(new File("sounds/bee.wav"));

    }

    /**
     * metoda odtwarzajaca dzwiek z pliku
     *
     * @param f zmienna do pliku dzwiekowego
     */
    public static synchronized void playSound(final File f) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }

}
