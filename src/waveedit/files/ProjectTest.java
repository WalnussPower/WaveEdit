package waveedit.files;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class ProjectTest extends Project {

    int[][] level = new int[][] {
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 } };
            
    String[] saveData = new String[] {
            "1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
            "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ",
            "0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 ",
            "0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 ",
            "0 0 0 0 0 0 0 0 0 1 1 1 1 0 0 0 0 0 0 0 0 "
    };
    

    public ProjectTest() throws FileNotFoundException, IOException {
        super("level.txt");
        for (int row = 0; row < level.length; row++) {
            System.out.println(row);
            for (int col = 0; col < level[0].length; col++) {
                System.out.print((col+1) + "/" + level[0].length + " " + (row+1) + "/"
                        + level.length + ": ");
                System.out.println(super.gameMap.getField(col, row) + " == "
                        + level[row][col]);
                int expected = level[row][col];
                int found = super.gameMap.getField(col, row).getKind();
                assertEquals(expected, found);
            }
        }
    }

    @Test
    public void testSave() throws IOException {

        save(new File("testResult.txt"));
        try (BufferedReader br = new BufferedReader(new FileReader("testResult.txt"))){
            String line;
            int cLine = 0;
            while(cLine < 13){
                if((line=br.readLine())==null){
                    fail("Could not read line "+cLine);
                }
                assertEquals(saveData[cLine], line);
                cLine++;
            }
        }
    }

}
