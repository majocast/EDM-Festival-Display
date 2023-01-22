import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;

public class Index {
    private static JFrame frame;
    public Storage storage;


    public static void main(String[] args) {
        new FileCreate();
        Index index = new Index();
        index.storage = new Storage();
/*
        for(Event event : index.storage.dataMap.values()) {
            event.display();
        }
*/
        String[] columns = {"name", "date", "location", "festival"};

        Object[][] data = new Object[index.storage.dataMap.size()][4];

        
        int i = 0;
        for(Event event : index.storage.dataMap.values()) {
            data[i][0] = event.getName();
            data[i][1] = event.getDate();
            data[i][2] = event.getLocation();
            data[i][3] = event.getFestival();
            i++;
        }

        /*Prints data inside Object[][] data
        for(int j = 0; j < data.length; j++) {
            for(int k = 0; k < data[j].length; k++) {
                System.out.println(data[j][k]);
            }
        }
        */

        frame = new JFrame("California Events");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
