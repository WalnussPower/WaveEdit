package waveedit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class ItemMenue {
	static JToggleButton selected = null;

	public ItemMenue() {}
	
	public void swop(JToggleButton choosen, JToggleButton unselected1, JToggleButton unselected2) {
		choosen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (choosen.isSelected()) {
					unselected1.setSelected(false);
					unselected2.setSelected(false);
				}
			}
		});
	}
}
