public class Event {
    private String name;
    private String date;
    private String location;
    private boolean festival;

    Event(String name, String date, String location, boolean festival) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.festival = festival;
    }

    public void display() {
        System.out.println("name: " + name + " | date: " + date + " | location: " + location + " | festival?: " + festival);
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean getFestival() {
        return this.festival;
    }

    public void setFestival(boolean festival) {
        this.festival = festival;
    }
}
