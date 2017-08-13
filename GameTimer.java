package sheepdog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa GameTimer do zliczania uplywajacego czasu
 *
 * @author PAWEŁ
 */
public class GameTimer implements ActionListener {

    /**
     * zmienna pomocnicza do zliczania sekund
     */
    public int mili = 0;
    /**
     * zmienna odpowiadajaca sekundom w grze
     */
    public static int secs = 60;
    /**
     * zmienna do wyswietlania aktualnego czasu
     */
    public static String zliczonyCzas;

    /**
     * metoda zliczajaca uplywajace sekundy
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (!Zasoby.end) {

            mili++;
            if (mili == 1) {
                secs--;
                mili = 0;

                PanelGry.losowaniePozycji(); //wywoalaj ruch wilkow
            }

            zliczonyCzas = String.valueOf(secs);//przypisuje aktualna liczbe sekund

            if (secs <= 0) {          //warunek konczace rozgrywke
                Zasoby.end = true;
                PanelGry.zapisano = 1;

            }

        }

    }//koniec actionPerformed()

}
