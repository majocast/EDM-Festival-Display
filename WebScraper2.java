import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;

//source: https://scrapingant.com/blog/web-scraping-java
//editted by: Marc Castro

//https://www.insomniac.com/events/concerts/

public class WebScraper2 {

    public final static String url = "https://www.insomniac.com/events/concerts/";
    public static String fileName = "EDM-Event-Res.txt";
    
    WebScraper2() {
        scrape();
    }
    
    private void scrape() {
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

        final String httpsUrl = url;
        try {
            final URL url = new URL(httpsUrl);
            final HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            
            System.out.println("****** Content of the URL ********");          
            final BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            FileWriter writer = new FileWriter(fileName);

            final Document document = Jsoup.connect(httpsUrl).get();
            Elements body = document.select("div.page div#barba-wrapper main.barba-container div.layout");
            System.out.println(body.size());
            int i = 2;
            int j = 2;

            while(j < 74) {
                for(Element rowColu1 : body) {
                    String type = "div.layout__block:nth-of-type(" + i + ") div.card";
                    if(rowColu1.select(type).text().equals("")) {
                        continue;
                    } else {
                        final String ticker = rowColu1.select(type).text();
                        writer.write(ticker + "\n");
                        i++;
                    }
                }
                j++;
            }

            br.close();
            writer.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
   }  
}
