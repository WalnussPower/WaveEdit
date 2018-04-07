package waveedit.gui;

import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.WindowAdapter;

public class SwingGUIController extends JPanel implements IGuiController{
	Graphics2D g;
	JFrame frame = new JFrame();
	JPanel map = new JPanel();

	public SwingGUIController() {

	}

	@Override
	public void initialize() {
		frame.setTitle("WaveEdit");
		frame.setSize(800, 600);
		frame.getContentPane().setBackground(new Color(250, 230, 200));
		frame.setResizable(false);
		frame.setVisible(true);
		repaint();
		

		frame.addWindowListener(new WindowAdapter(){
		    
		});
	}
	protected void paint() {
		super.paintComponent(g);
		g.setColor (Color.red);
		g.fillRect(500,400,50,50);
		
		
;	}
	

}
