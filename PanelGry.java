package sheepdog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * Klasa zawierajaca grafike i akcje
 *
 * @author PAWEŁ
 */
public class PanelGry extends JPanel {

    /**
     * szerokosc
     */
    public int sWidth;
    /**
     * wysokosc
     */
    public int sHeight;
    /**
     * zmienna przechowujaca liczbe punktow
     */
    public static int pkt;
    /**
     * rozmiar czcionki
     */
    public int fontSize = 25;
    /**
     * wysokosc dolnego paska
     */
    public int barHeight;
    /**
     * zmienna pomocnicza do wyswietlania opisu
     */
    public int opis = 0;
    /**
     * zmienna przechowujaca nick
     */
    public static String name;
    /**
     * wspolrzedne wilkow
     */
    private static int x0, x1, x2, x3;
    /**
     * wspolrzedne wilkow
     */
    private static int y0, y1, y2, y3;
    /**
     * zmienna pomocnicza do oznaczenia kolejnych wilkow
     */
    int i = 0;
    /**
     * zmienna pomocnicza do zapisu
     */
    public static int zapisano = 0;
    /**
     * wspolrzedna owiec
     */
    private int ox = 700;
    /**
     * wspolrzedna owiec
     */
    private int oy;

    /**
     * Konstruktor
     *
     * @param width szerokosc
     * @param height wysokosc
     */
    public PanelGry(int width, int height) {
        this.sWidth = width;
        this.sHeight = height;
        barHeight = 75;

        losowaniePozycji();//zmienia pozycje wilkow

        /**
         * metoda przypisujaca zdarzenia kliknieciom myszki
         */
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {

                //opcja zapisu
                if (Zasoby.zapis) {
                    if (me.getX() > 330 && me.getX() < 450 && me.getY() > 300 && me.getY() < 330) {

                        try {
                            Zapisywanie.save();
                        } catch (IOException ex) {
                            Logger.getLogger(PanelGry.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        zapisano = 2;
                        repaint();

                    }
                }

                //opcja zakończ grę
                if (me.getX() > 5 && me.getX() < 155 && me.getY() > 570 && me.getY() < 600) {

                    System.exit(1);

                }

                //opcja nowa gra
                if (me.getX() > 700 && me.getX() < 830 && me.getY() > 570 && me.getY() < 600) {

                    i = 0;
                    pkt = 0;
                    GameTimer.secs = 60;
                    Zasoby.end = false;

                    opis = 0;
                    zapisano = 0;

                }

                //opcja opisu gry
                if (me.getX() > 550 && me.getX() < 650 && me.getY() > 570 && me.getY() < 600) {

                    Zasoby.end = true;
                    opis = 1;

                }
                //trafienie wilka 0 
                if ((me.getX() > x0 && me.getX() < x0 + 77 && me.getY() > y0 && me.getY() < y0 + 96)) {

                    Zasoby.wilki[i] = null;

                    Efekty.sound();
                    pkt++;

                }
                //trafienie wilka 1
                if (me.getX() > x1 && me.getX() < x1 + 77 && me.getY() > y1 && me.getY() < y1 + 96) {

                    Zasoby.wilki[i + 1] = null;

                    Efekty.sound();
                    pkt++;

                }
                //trafienie wilka 2
                if (me.getX() > x2 && me.getX() < x2 + 77 && me.getY() > y2 && me.getY() < y2 + 96) {

                    Zasoby.wilki[i + 2] = null;

                    Efekty.sound();
                    pkt++;

                }

                //trafienie wilka 3
                if (me.getX() > x3 && me.getX() < x3 + 77 && me.getY() > y3 && me.getY() < y3 + 96) {

                    Zasoby.wilki[i + 3] = null;

                    Efekty.sound();
                    pkt++;

                }
                //trafienie owcy 0 
                if (me.getX() > ox && me.getX() < ox + 90 && me.getY() > oy && me.getY() < oy + 96) {

                    Efekty.sound();
                    pkt--;

                }
                //trafienie owcy 1
                if (me.getX() > ox + 100 && me.getX() < ox + 100 + 90 && me.getY() > oy && me.getY() < oy + 96) {

                    Efekty.sound();
                    pkt--;

                }
                //trafienie owcy 2
                if (me.getX() > ox + 200 && me.getX() < ox + 200 + 90 && me.getY() > oy && me.getY() < oy + 96) {

                    Efekty.sound();
                    pkt--;

                }
                //trafienie owcy 3
                if (me.getX() > ox + 300 && me.getX() < ox + 300 + 90 && me.getY() > oy && me.getY() < oy + 96) {

                    Efekty.sound();
                    pkt--;

                }
                //trafienie owcy 4
                if (me.getX() > ox + 400 && me.getX() < ox + 400 + 90 && me.getY() > oy && me.getY() < oy + 96) {

                    Efekty.sound();
                    pkt--;

                }

            }//koniec mouseClicked()
        });

    }

    /**
     * metoda rysujaca grafike
     *
     * @param gs
     */
    @Override
    protected void paintComponent(Graphics gs) {

        Graphics2D g = (Graphics2D) gs;
        //tryb lepszej jakości grafiki
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        setLayout(null);

        g.drawImage(Zasoby.bgImage, 0, 0, null);

        g.setColor(Color.green);
        g.fillRect(0, sHeight - barHeight, sWidth, barHeight);

        g.setColor(Color.DARK_GRAY);

        g.setFont(new Font("Arial", Font.ITALIC, fontSize));
        g.drawString("ZAKOŃCZ", 5, 595);
        g.drawString("O GRZE", 550, 595);
        g.drawString("NOWA GRA", 700, 595);

        if (!Zasoby.end) {

            g.setColor(Color.black);

            g.setFont(new Font("Arial", Font.BOLD, fontSize));

            g.drawString("PUNKTY: " + String.valueOf(pkt), 240, 595);
            g.drawString("CZAS: " + String.valueOf(GameTimer.zliczonyCzas), 400, 595);

            for (int j = 0; j < 7; j++) {

                g.drawImage(Zasoby.owce[0], ox + 120 * j, (int) (oy), null);
            }

            g.drawImage(Zasoby.wilki[i], x0, y0, null);
            g.drawImage(Zasoby.wilki[i + 1], x1, y1, null);
            g.drawImage(Zasoby.wilki[i + 2], x2, y2, null);
            g.drawImage(Zasoby.wilki[i + 3], x3, y3, null);

            ox = ox - 1;
            // oy = 400;

            if (ox + 500 < 10) {
                ox = 600;
                oy = -80;

            }

            if (oy <= 0) {
                oy = 400;
            }

            if (Zasoby.wilki[i] == null || Zasoby.wilki[i + 1] == null || Zasoby.wilki[i + 2] == null || Zasoby.wilki[i + 3] == null) {
                i++;
                repaint();
            }

        }

        if (Zasoby.end) {

            if (opis == 1) {

                g.drawString("ZDMUCHNIJ JAK NAJWIĘCEJ WILKÓW ", 200, 130);
                g.drawString("MASZ MINUTĘ", 320, 165);
                g.drawString("(UWAGA NA OWCE!)", 290, 210);
                g.setColor(Color.green);
                g.drawString("POWODZENIA!", 320, 260);
                g.setFont(new Font("Arial", Font.BOLD, fontSize + 20));
                g.setColor(Color.blue);
                g.drawString("GRA SHEEPDOG ", 250, 90);

            } else {

                g.setColor(Color.RED);

                g.setFont(new Font("Arial", Font.BOLD, fontSize));
                g.drawString("KONIEC GRY! ZDOBYTE PUNKTY:  " + String.valueOf(pkt), 200, 130);

                g.setColor(Color.black);

                if (zapisano == 1) {
                    g.drawString("Zapisz wynik", 350, 320);
                    Zasoby.zapis = true;

                } else if (zapisano == 2) {
                    g.drawString("Zapisano!", 360, 320);

                }

            }

        }

        repaint();

    }

    /**
     * metoda zmieniajaca pozycje wilkow na planszy w trakcie rozgrywki
     */
    public static void losowaniePozycji() {

        x0 = (int) (670 * Math.random());
        y0 = (int) (480 * Math.random());

        x1 = (int) (670 * Math.random());
        y1 = (int) (480 * Math.random());

        x2 = (int) (670 * Math.random());
        y2 = (int) (480 * Math.random());

        x3 = (int) (670 * Math.random());
        y3 = (int) (480 * Math.random());

    }//koniec losowaniePozycji()

}
