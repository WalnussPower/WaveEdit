package waveedit.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class SwingGUIController implements IGuiController {

	JFrame frame = new JFrame();
	JPanel background = new JPanel();

	public SwingGUIController() {

	}

	@Override
	public void initialize() {
		frame.setSize(800, 600);
		frame.getContentPane().setBackground(new Color(150, 130, 80));

		frame.setVisible(true);
	}

}
