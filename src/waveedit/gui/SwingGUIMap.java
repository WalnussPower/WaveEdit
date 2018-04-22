package waveedit.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingGUIMap extends JPanel {
	// TODO draw GUI

	private int x = 50;
	private int y = 50;

	Icon nexusIcon = new ImageIcon(SwingGUIMap.class.getResource("/nexus.png"));
	Icon openIcon = new ImageIcon(SwingGUIMap.class.getResource("/open.png"));
	Icon saveIcon = new ImageIcon(SwingGUIMap.class.getResource("/save.png"));
	Icon tileIcon = new ImageIcon(SwingGUIMap.class.getResource("/tile.png"));
	Icon trashIcon = new ImageIcon(SwingGUIMap.class.getResource("/trash.png"));
	Icon wallIcon = new ImageIcon(SwingGUIMap.class.getResource("/wall.png"));

	JToggleButton tileButton = new JToggleButton(tileIcon);
	JToggleButton wallButton = new JToggleButton(wallIcon);
	JToggleButton nexusButton = new JToggleButton(nexusIcon);
	JButton saveButton = new JButton(saveIcon);
	JButton deleteButton = new JButton(trashIcon);
	JButton openButton = new JButton(openIcon);
	JTextField txtfield = new JTextField();
	Filepicker fp = new Filepicker();
	ItemMenue menue = new ItemMenue();

	private static final long serialVersionUID = 1922691013005376966L;

	public SwingGUIMap() {
		setLayout(null);
		/////////////////////////////////////////////////////////////////////////
		// TODO: Creates Map
		int fields[][] = new int[13][];
		for (int row = 0; row < 13; row++) {
			int[] line = new int[21];
			for (int col = 0; col < 21; col++) {
				FieldButton Coordin = new FieldButton(tileIcon, x, y);
				Coordin.setBounds(x, y, 32, 32);
				add(Coordin);
				line[col] = 0;// TODO set global constants for the different field types. like in the class
								// Field.
				x = x + 32;
			}
			fields[row] = line;
			x = 50;
			y = y + 32;

		}
		////////////////////////////////////////////////////////////////////////
		setBounds(0, 0, 800, 600);

		saveButton.setBounds(775, 500, 40, 40);
		add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.pick();
			}
		});
		///////////////////////////////////////////////////////////////////////
		tileButton.setBounds(775, 50, 90, 40);
		add(tileButton);
		menue.swop(tileButton, wallButton, nexusButton);

		wallButton.setBounds(775, 90, 90, 40);
		add(wallButton);
		menue.swop(wallButton, tileButton, nexusButton);

		nexusButton.setBounds(775, 130, 90, 40);
		add(nexusButton);
		menue.swop(nexusButton, wallButton, tileButton);
		///////////////////////////////////////////////////////////////////////
		deleteButton.setBounds(775, 170, 90, 40);
		add(deleteButton);

		openButton.setBounds(820, 500, 40, 40);
		add(openButton);

		txtfield.setBounds(50, 500, 672, 40);
		add(txtfield);
	}

	///////////////////////////////////////////////////////////////////////
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		setBackground(new Color(250, 230, 200));

	}

}
