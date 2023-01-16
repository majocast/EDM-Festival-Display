import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;

public class Storage { 
    HashMap<String, Event> dataMap;

    Storage() {
        dataMap = new HashMap<String, Event>();
        dataMap.put("Countdown", new Event("Countdown", 400, "01/01/2023", "NOS Event Center", true));
        dataMap.put("Beyond Wonderland", new Event("Beyond Wonderland", 250, "03/24/2023", "NOS Event Center", true));
        dataMap.put("Sullivan King", new Event("Sullivan King", 60, "04/01/2023", "The Midway SF", false));
        dataMap.put("Subtronics", new Event("Subtronics", 130, "01/20/2023", "San Jose Civic Center", false));
        dataMap.put("Steve Aoki", new Event("Steve Aoki", 90, "03/11/2023", "Bill Graham Civic Center", false));
        dataMap.put("Wooli", new Event("Wooli", 30, "02/10/2023", "The Midway SF", false));
        dataMap.put("Basscon Wasteland", new Event("Basscon Wasteland", 140, "02/24/2023", "NOS Event Center", true));
        dataMap.put("Coachella", new Event("Coachella", 500, "04/21/2023", "Empire Polo Club", true));
        dataMap.put("Audiotistic Bay Area", new Event("Audiotistic Bay Area", 200, "07/08/2023", "Shoreline Amphitheatre", true));
        dataMap.put("Taylor Rave", new Event("Taylor Rave", 25, "02/03/2023", "August Hall", false));
        dataMap.put("Kai Wachi", new Event("Kai Wachi", 20, "01/27/2023", "1015 Folsom SF", false));
        dataMap.put("Good Times Ahead", new Event("Good Times Ahead", 20, "02/17/2023", "Yolo NightClub", false));
        dataMap.put("Skyline LA", new Event("Skyline LA", 170, "02/25/2023", "Expo Park LA", true));
        dataMap.put("ATLiens", new Event("ATLiens", 37, "04/08/2023", "San Jose Civic Center", false));
        dataMap.put("Said The Sky", new Event("Said The Sky", 50, "03/03/2023", "Exchange LA", false));
        dataMap.put("Au5", new Event("Blanke/Au5", 25, "03/17/2023", "The Midway SF Patio", false));
        dataMap.put("Outside Lands", new Event("Outside Lands", 150, "08/11/2023", "San Francisco, CA", true));
        dataMap.put("Electronic Daisy Carnival", new Event("EDC", 390, "05/19/2023", "Las Vegas Motor Speedway", true));
        dataMap.put("Seven Lions", new Event("Seven Lions", 55, "06/16/2023", "Greek Theatre, Berkeley", false));
    }
}