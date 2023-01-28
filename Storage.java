import java.util.*;

public class Storage { 
    public HashMap<String, Event> dataMap;

    Storage() {
        dataMap = new HashMap<String, Event>();
        new WebScraper(this.dataMap);
        System.out.println(dataMap.size());
    }
}