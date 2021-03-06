package waveedit.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import waveedit.datamodel.Field;
import waveedit.datamodel.GameMap;

public class Project {

    /**
     * The File in which the current project is and will be saved. This needs to
     * be set when saving for the first time or when loading a Project
     */
    private File file;

    /**
     * The field in which the GameMap that is currently being edited will be
     * stored.
     *
     * TODO This field is set to 'protected' access to make testing easier. Set
     * this to 'private' before deployment.
     */
    protected GameMap gameMap;

    /**
     * This Constructor takes a {@link String} that contains a path to the file
     * that is to be loaded
     *
     * @param pFilePath
     *            The filepath
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Project(final String pFilePath)
            throws FileNotFoundException, IOException {
        this(new File(pFilePath));
    }

    public Project(final File pFile) throws FileNotFoundException, IOException {
        load(pFile);
    }

    public void load(final File pFile)
            throws FileNotFoundException, IOException {
        file = pFile;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            ArrayList<Field[]> fieldLines = new ArrayList<>();
            String line = br.readLine();
            int x = -1;
            int y = -1;
            while (line != null && !line.equals("")) {
                ArrayList<Field> fieldsInLine = new ArrayList<>();
                y++;
                int curX = 0;
                for (String strKind : line.split(" ")) {
                    fieldsInLine
                            .add(new Field(curX, y, Integer.parseInt(strKind)));
                    curX++;
                }
                if (x < 0) {
                    x = curX;
                } else if (x != curX) {
                    throw new IOException("Error while trying to load \""
                            + file.getPath()
                            + "\": The map's horizontal length must be constant!");
                }
                fieldLines.add(fieldsInLine.toArray(new Field[x]));
                line = br.readLine();
            }
            gameMap = new GameMap(fieldLines.toArray(new Field[y][x]));
        }
    }

    public void save() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            int row = 0;
            writeLine(bw, row);
            for (row = 1; row < gameMap.getRows(); row++) {
                bw.newLine();
                writeLine(bw, row);
            }
        }
    }

    private void writeLine(final BufferedWriter bw, final int row)
            throws IOException {
        for (int col = 0; col < gameMap.getCols(); col++) {
            bw.write(gameMap.getField(col, row).toString());
        }
    }

    public void save(final File pFile) throws IOException {
        if (pFile == null) {
            throw new IllegalArgumentException("Error: tried to save to NULL");
        }
        file = pFile;
        save();
    }

    public void setField(final int pCol, final int pRow, final int pKind) {
        gameMap.setField(pCol, pRow, pKind);
    }

    public int getField(final int pCol, final int pRow) {
        return gameMap.getField(pCol, pRow).getKind();
    }

}
