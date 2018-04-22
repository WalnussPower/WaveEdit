package waveedit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import waveedit.files.Project;
import waveedit.gui.IGuiController;
import waveedit.gui.SwingGUIController;

public class Main {
	
	private static final String DEFAULTPROJECTPATH = "";
	
	private static Map<Integer, Icon> iconMap = new HashMap<>();
	
	private static Project project;

	public static final int EMPTY = 0;

	public static final int WALL = 1;

	public static final int NEXUS = 2;

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(final String[] args) {
		// TODO check parameters
		String projectFilePath = DEFAULTPROJECTPATH;
		if(args.length>0) {
			projectFilePath = args[0];
		}
		
		try {
			setProject(new Project(projectFilePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		iconMap.put(EMPTY, new ImageIcon(Main.class.getResource("tile.png")));
		iconMap.put(WALL, new ImageIcon(Main.class.getResource("wall.png")));
		iconMap.put(NEXUS, new ImageIcon(Main.class.getResource("nexus.png")));
		
		
		IGuiController gui = new SwingGUIController();// TODO generates gui class and instances here

		gui.initialize();

	}

	public static Project getProject() {
		return project;
	}

	public static void setProject(Project project) {
		Main.project = project;
	}

}
