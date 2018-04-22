package waveedit.gui;

import javax.swing.Icon;
import javax.swing.JButton;

public class FieldButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5302247247774185761L;
	
	private final int x, y;
	
	private boolean marked = false;

	public FieldButton(Icon icon, int pX, int pY) {
		super(icon);
		x = pX;
		y = pY;
	}
	
	
	public void toggleMark() {
		marked = !marked;
		
	}

	public int getFieldX() {
		return x;
	}

	public int getFieldY() {
		return y;
	}
	
}
