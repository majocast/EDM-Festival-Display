import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors 

//https://www.iheartraves.com/pages/popular-raves-and-festivals-in-the-us

public class WebScraper {

    public final static String url = "https://www.iheartraves.com/pages/popular-raves-and-festivals-in-the-us";
    public static String fileName = "EDM-Events.txt";
    public static void main(String[] args) {

        File file = new File(fileName);
        try {
            if(file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File exists, clearing file.");
                file.delete();
                file.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Error Occurred on creation of file");
            e.printStackTrace();
        }
         
        //begins scraping process
        try {
            FileWriter writer = new FileWriter(fileName);
            final Document document = Jsoup.connect(url).timeout(10000).get();
            Elements body = document.select("table tr");
            System.out.println(body.select("td:nth-of-type(1)"));
            for(Element rowColu1 : body) {
                if(rowColu1.select("td:nth-of-type(1)").text().equals("")) {
                    continue;
                } else {
                    final String ticker = rowColu1.select("td:nth-of-type(1)").text();
                    writer.write(ticker + "\n");
                }
            }
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}