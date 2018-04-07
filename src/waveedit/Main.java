package waveedit;

import waveedit.gui.IGuiController;
import waveedit.gui.SwingGUIController;

public class Main {

    public Main() {
        // TODO Auto-generated constructor stub
    }

    public static void main(final String[] args) {
        // TODO check parameters
        // TODO start gui
        IGuiController gui = new SwingGUIController();// TODO GUI-Klasse implementieren und hier
                                  // instanziieren
        gui.initialize();
        
    }

}
