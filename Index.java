import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class Index {
    private static JFrame frame;
    public Storage storage;

    public static void main(String[] args) {
        new FileCreate();
        Index index = new Index();
        index.storage = new Storage();
        

        String[] columns = {"name", "date", "location", "festival"};

        /*Preps info for data table*/
        Object[][] data = new Object[index.storage.dataMap.size()][4];
        int i = 0;
        for(Event event : index.storage.dataMap.values()) {
            data[i][0] = event.getName();
            data[i][1] = event.getDate();
            data[i][2] = event.getLocation();
            data[i][3] = event.getFestival();
            i++;
        }
        frame = new JFrame("San Francisco/Festival Scraper");
        JTable table = new JTable(data, columns);

        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Filter");
        panel.add(label, BorderLayout.WEST);
        final JTextField filterText = new JTextField("");
        panel.add(filterText, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        filterText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = filterText.getText().trim();
                if(text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    try {
                        System.out.println("entered text: " + filterText.getText());
                        sorter.setRowFilter(RowFilter.regexFilter(text));
                    } catch(Exception ex) {
                        System.out.println("Bad regex pattern");
                    }
                }
            }
        });
        frame.setSize(550, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
