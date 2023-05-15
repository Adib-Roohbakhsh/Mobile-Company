import java.io.Serializable;

public class Address implements Cloneable, Comparable<Address>, Serializable {
    private int streetNum;
    private String street;
    private String suburb;
    private String city;

    public Address(int streetNum, String street, String suburb, String city) {
        this.streetNum = streetNum;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public void print() {
        System.out.print(streetNum + " , " + street + " , " + suburb + " ,CITY: " + city);
    }

    public String toString() {
        return streetNum + " , " + street + " , " + suburb + " ,CITY: " + city;
    }

    //  ----- LAB4 -----
    public Address(Address address) {
        this.streetNum = address.streetNum;
        this.street = address.street;
        this.suburb = address.suburb;
        this.city = address.city;
    }

    public int compareTo (Address address){
        return city.compareTo(address.city);
    }
    public Address clone() throws CloneNotSupportedException{
        return (Address) super.clone();
    }
    //  --------------- LAB6 ---------------
    public String toDelimitedString ()
    {
        return streetNum + "," + street + "," + suburb + "," + city;
    }
}
