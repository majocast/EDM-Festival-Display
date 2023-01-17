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

//https://concerts50.com/upcoming-concerts-in-california/g/dance-electronic?city=san-francisco&is_hot=0&dateto=

public class WebScraper3 {

    public final static String url = "https://concerts50.com/upcoming-concerts-in-california/g/dance-electronic?city=san-francisco&is_hot=0&dateto=";
    public static String fileName = "Concerts50-Res.txt";
    public static void main(String[] args) {
        new WebScraper3().scrape();
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
            Elements body = document.select("div.container div#events.list-view" /*div.items tbody*/);
            System.out.println(body.size());
            int i = 2;
            int j = 2;

            while(j < 100) {
                for(Element rowColu1 : body) {
                    
                    String type = "tr.event-item.row:nth-of-type(" + i + ")";
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
