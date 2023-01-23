import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.net.URL;
import java.text.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;

//https://www.iheartraves.com/pages/popular-raves-and-festivals-in-the-us

public class WebScraper{

    public final static String url1 = "https://www.iheartraves.com/pages/popular-raves-and-festivals-in-the-us";
    public static String fileName1 = "EDM-Events.txt";

    public final String url2 = "https://concerts50.com/upcoming-concerts-in-california/g/dance-electronic?city=san-francisco&is_hot=0&dateto=";
    public static String fileName2 = "Concerts50-Res.txt";

    WebScraper() {}

    WebScraper(HashMap<String, Event> dataMap) {
        scrape(dataMap);
    }

    void scrape(HashMap<String, Event> dataMap) {
        //begins scraping process
        try {
            /*parse through url 1*/
            System.out.println("Parsing through URL 1");
            FileWriter writer = new FileWriter(fileName1);
            Document document = Jsoup.connect(url1).get();
            Elements body = document.select("table tr");
            for(Element rowColu1 : body) {
                if(rowColu1.select("td:nth-of-type(1)").text().equals("")) {
                    continue;
                } else {
                    String name = rowColu1.select("td:nth-of-type(1)").text();
                    writer.write(name + " ");
                    String date = rowColu1.select("td:nth-of-type(2)").text();
                    writer.write(date + " ");
                    String location = rowColu1.select("td:nth-of-type(3)").text();
                    writer.write(location + "\n");

                    //accounting for a bug in the website that wouldnt show this location for some reason
                    if(name.contains("Bass Canyon")) {
                        location = "George, WA";
                    } else if (location.contains("")) {
                        location = "OPEN FOR RESEARCH";
                    }

                    dataMap.put(name, new Event(name, date + ", 2023", location, true));
                }
            }
            writer.close();
            System.out.println("Successfully Parse through URL 1");

            /*parse through url 2 */
            System.out.println("Parsing through URL 2");
            final URL url2 = new URL(this.url2);
            HttpsURLConnection con = (HttpsURLConnection) url2.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            con = (HttpsURLConnection) url2.openConnection();
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            writer = new FileWriter(fileName2);
            document = Jsoup.connect(this.url2).get();
            body = document.select("div.container div#events.list-view");
            int i = 1;
            int j = 0;

            while(j < 100) {
                for(Element rowColu1 : body) {
                    String type = "tr.event-item.row:nth-of-type(" + i + ")";
                    if(rowColu1.select(type).text().equals("")) {
                        continue;
                    } else {
                        String event = rowColu1.select(type).text();
                        writer.write(event + "\n");
                        String[] dateTokens = event.split(" ");
                        String date = dateTokens[0] + " " + dateTokens[1] + " " + dateTokens[2] + " " + dateTokens[3] + " " + dateTokens[4] + " " + dateTokens[5];
                        type = ".name.col-lg-7.col-md-7.col-4.d-inline-block div";
                        String location = rowColu1.select(type).text();
                        String[] locTokens = location.split(" - San Francisco, CA ");
                        location = locTokens[j];
                        type = "tr.event-item.row:nth-of-type(" + i + ") .name.col-lg-7.col-md-7.col-4.d-inline-block p";
                        String artist = rowColu1.select(type).text();
                        if(location.contains("San Francisco")) {
                            location = location + ", CA";
                        } else {
                            location = location + " San Francisco, CA";
                        }
                        dataMap.put(artist, new Event(artist, date, location, false));
                        i++;
                    }
                }
                j++;
            }
            br.close();
            writer.close();
            System.out.println("Successfully Parse through URL 2");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
