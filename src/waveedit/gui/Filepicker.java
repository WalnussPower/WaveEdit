package waveedit.gui;

import javax.swing.JFileChooser;


public class Filepicker {
JFileChooser fc = new JFileChooser();

public Filepicker() {

	}
	public void pick() {
		fc.setCurrentDirectory(new java.io.File("C:"));	
		fc.setDialogTitle("Save as");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.showOpenDialog(null);
		fc.getSelectedFile();

            

	}

}
