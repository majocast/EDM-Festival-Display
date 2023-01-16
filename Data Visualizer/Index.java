import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;

public class Index {
    private static JFrame frame;
    private Storage storage;


    public static void main(String[] args) {
        Index index = new Index();
        index.storage = new Storage();
/*
        for(Event event : index.storage.dataMap.values()) {
            event.display();
        }
*/
        String[] columns = {"name", "price", "date", "location", "festival"};

        Object[][] data = new Object[index.storage.dataMap.size()][5];

        int i = 0;
        for(Event event : index.storage.dataMap.values()) {
            data[i][0] = event.getName();
            data[i][1] = event.getPrice();
            data[i][2] = event.getDate();
            data[i][3] = event.getLocation();
            data[i][4] = event.getFestival();
            i++;
        }

        for(int j = 0; j < data.length; j++) {
            for(int k = 0; k < data[j].length; k++) {
                System.out.println(data[j][k]);
            }
        }

        frame = new JFrame("California Events");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
