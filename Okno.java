package sheepdog;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Klasa, w ktorej tworzy sie okno
 *
 * @author PAWEŁ
 */
public class Okno extends JFrame {

    /**
     * Konstrktor - ustawienie parametrow, szerokosc, wysokosc
     *
     * @param width
     * @param height
     * @param x
     * @param y
     */
    public Okno(int width, int height, int x, int y) {
        super(); //wywołaj konstruktor klasy nadrzędnej - utwórz okno
        setSize(width, height); //ustaw wymiary okna
        setLocation(x, y); //ustaw pozycję okna
        setResizable(false); //zablokuj możliwość zmian rozmiaru okna
        initGUI(width, height); //wywołaj metodę budowy interfejsu
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ActionListener listener = new GameTimer();
        /**
         * utworzenia timera
         */
        Timer t = new Timer(1000, listener);
        t.start();
        /**
         * czas start
         */
        if (Zasoby.end) {
            t.stop();
        }

    }

    /**
     * metoda tworzaca interfejs uzytkownika
     *
     * @param width szerokosc
     * @param height wysokosc
     */
    private void initGUI(int width, int height) {

        //ustaw zasoby i parametry początkowe
        Zasoby.loadInitialImages();

        setTitle("Sheepdog"); //ustaw tytul

        add(new PanelGry(width, height)); //dodaj panel gry zawierający grafikę i akcję

    }//koniec initGUI

}
