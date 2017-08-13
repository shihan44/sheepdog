package sheepdog;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.swing.JOptionPane;
import static sheepdog.PanelGry.name;

/**
 * Klasa zapisu wynikow
 *
 * @author PAWEŁ
 */
public class Zapisywanie {

    /**
     * zmienna przechowujaca aktulna date i czas
     */
    public static Date date;

    /**
     * metoda zapisu wynikow do pliku
     *
     * @throws IOException
     */
    public static void save() throws IOException {
        //pobiera date
        date = new Date();
        //pobiera nick
        name = JOptionPane.showInputDialog("Podaj nick:");

        try {
            PrintWriter zapis = new PrintWriter(new FileWriter("punkty.txt", true));
            zapis.println(PanelGry.name + "  " + String.valueOf(PanelGry.pkt) + " pkt;   On " + date.toString());
            zapis.println("");
            zapis.close();
        } catch (Exception e) {
            System.out.println("Error opening file");

        }

    }//koniec save()

}
