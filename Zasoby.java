package sheepdog;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Klasa przechowujaca grafike i dzwiek oraz parametry gry
 *
 * @author PAWEŁ
 */
public class Zasoby {

    /**
     * zmienne okreslajace stan gry
     */
    public static boolean end = false;
    public static boolean zapis = false;
    /**
     * szerokosc gry
     */

    public static int gWidth = 853;
    /**
     * wysokosc
     */
    public static int gHeight = 640;
    /**
     * tablica obrazow z wilkiem
     */

    public static Image[] wilki;
    /**
     * tablica obrazow z owca
     */
    public static Image[] owce;
    /**
     * tlo
     */
    public static Image bgImage;

    /**
     * metoda wczytujaca obrazy
     */
    public static void loadInitialImages() {

        bgImage = loadImage("images/tlo.jpg");

        wilki = new Image[1000];
        owce = new Image[1];

        owce[0] = loadImage("images/sheep.png");

        for (int i = 0; i < 1000; i++) {
            wilki[i] = loadImage("images/wolf.png");
        }

    }//koniec loadInitialImages()

    /**
     * Metoda pobierania obiektu klasy Image ze sciezki podanej jako string
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage();

}
