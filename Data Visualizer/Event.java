import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Event {
    private String name;
    private int price;
    private String date;
    private String location;
    private boolean festival;

    Event(String name, int price, String date, String location, boolean festival) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.location = location;
        this.festival = festival;
    }

    public void display() {
        System.out.println("name: " + name + " | price: $" + price + " | date: " + date + " | location: " + location + " | festival?: " + festival);
    }

    public String getDate() {
        return this.date;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean getFestival() {
        return this.festival;
    }
}
