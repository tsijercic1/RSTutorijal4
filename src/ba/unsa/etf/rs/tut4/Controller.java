package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Controller {
    public TextArea sourceField;
    public TextArea destinationField;

    public void addToReceipt(ActionEvent actionEvent) {
        String source = sourceField.getText();
        String[] artikli = source.split("\n");
        ArrayList<Artikal> kanta = new ArrayList<>();
        for (String element : artikli) {
            kanta.add(new Artikal(element));
        }
        String rezultat = "";
        for (Artikal element : kanta) {
            rezultat += element + "\n";
        }
        destinationField.setText(rezultat);
    }
}
