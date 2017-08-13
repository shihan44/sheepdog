package sheepdog;

import java.awt.Toolkit;

/**
 * Klasa glowna programu
 *
 * @author PAWEŁ
 */
public class Sheepdog {

    public static void main(String[] args) {

        //rozmiar okna
        int gameWidth = 853;
        int gameHeight = 640;

        //pobierz rozmiar ekranu
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        //oblicz współrzędne narożnika tak, aby pole gry było wyśrodkowane
        int xCenter = (screenWidth - gameWidth) / 2;
        int yCenter = (screenHeight - gameHeight) / 2;

        //utwórz obiekt klasy Okno - konstruktor wywołuje dalszą akcję
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Okno o = new Okno(gameWidth, gameHeight, xCenter, yCenter);
                o.setVisible(true);

            }
        });

    }
}
