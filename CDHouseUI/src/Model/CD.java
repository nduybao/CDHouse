package Model;

/**
 *
 * @author duyba
 */
public class CD implements Comparable<CD>{

    private String name;
    private String id;
    private boolean type;
    private String title;
    private double price;
    private int year;

    public CD() {
    }

    public CD(String name, String id, boolean type, String title, double price, int year) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.title = title;
        this.price = price;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id.toUpperCase();
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return this.name + "," + this.id.toUpperCase() + "," + this.type + "," + this.title + "," + this.price + "," + this.year;
    }

    @Override
    public int compareTo(CD t) {
        if(this.getTitle().equalsIgnoreCase(t.getTitle())){
            return this.getYear() - t.getYear();
        }
        return this.getTitle().toUpperCase().compareTo(t.getTitle().toUpperCase());
    }
}
