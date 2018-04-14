package waveedit.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class SwingGUIMap extends JPanel {
    // TODO draw GUI
    SwingGUIController ctrl;
    SwingGUIMap map;
    Graphics g;
    JLayeredPane glassPane = new JLayeredPane();
    private static final long serialVersionUID = 1922691013005376966L;

    public SwingGUIMap() {

        JButton Save = new JButton("SAVE");
        JButton Tile = new JButton("Tile");
        JButton Wall = new JButton("Wall");
        JButton Nexus = new JButton("Nexus");
        JButton Delete = new JButton("Delete");
        setLayout(null);

        Save.setBounds(670, 450, 100, 20);
        setBounds(0, 0, 800, 600);
        Save.setVisible(true);
        add(Save);

        Tile.setBounds(675, 60, 90, 30);
        setBounds(0, 0, 800, 600);
        Tile.setVisible(true);
        add(Tile);

        Wall.setBounds(675, 100, 90, 30);
        setBounds(0, 0, 800, 600);
        Wall.setVisible(true);
        add(Wall);

        Nexus.setBounds(675, 140, 90, 30);
        setBounds(0, 0, 800, 600);
        Nexus.setVisible(true);
        add(Nexus);

        Delete.setBounds(675, 180, 90, 30);
        setBounds(0, 0, 800, 600);
        Delete.setVisible(true);
        add(Delete);

    }

    public void paint(Graphics g) {

        super.paintComponent(g);
        g.setColor(new Color(150, 150, 150));
        g.fillRect(50, 50, 600, 350);
        g.fillRect(670, 50, 100, 200);

        // typing field
        g.setColor(Color.white);
        g.fillRect(50, 450, 600, 20);
        // Borders
        g.setColor(Color.black);
        g.drawRect(50, 450, 600, 20);
        g.drawRect(670, 50, 100, 200);
        g.drawRect(50, 50, 600, 350);
        setBackground(new Color(250, 230, 200));

        setVisible(true);
    }

}
