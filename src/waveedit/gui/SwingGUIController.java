package waveedit.gui;

import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

public class SwingGUIController implements IGuiController {
	Graphics2D g;
	JFrame frame = new JFrame();
	SwingGUIMap map;

	public SwingGUIController() {

	}

	@Override
	public void initialize() {
		// TODO open Frame
		frame.setTitle("WaveEdit");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		// TODO Draw Background
		frame.setResizable(false);
		frame.setVisible(true);
		

		frame.addWindowListener(new WindowAdapter() {

		});
		// TODO Karte zeichnen
		map = new SwingGUIMap();

		frame.getContentPane().add(map);
		// TODO Men� zeichnen
	}



}
