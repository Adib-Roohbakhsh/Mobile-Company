import java.io.Serializable;

public class MobilePhone implements Cloneable, Serializable {
    private String model;
    private MobileType type;
    private int memorySize;
    private double price;

    public MobilePhone(String model, MobileType type, int memorySize, double price) {
        this.model = model;
        this.type = type;
        this.memorySize = memorySize;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public MobileType getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(MobileType type) {
        this.type = type;
    }

    public void print() {
        System.out.print("    Mobile Model:" + model + "    Mobile Type: " + type + "    Mobile Memory size:" + memorySize + "GB    Mobile Price:" + price + "$");
    }

    public String toString() {
        return "    Mobile Model:" + model + "    Mobile Type: " + type + "    Mobile Memory size:" + memorySize + "GB    Mobile Price:" + price + "$";
    }

    public void priceRise(double rise) {
        price *= (1 + rise);
    }

    //  ----- LAB4 -----
    public MobilePhone(MobilePhone mobilePhone) {
        this.model = mobilePhone.model;
        this.type = mobilePhone.type;
        this.memorySize = mobilePhone.memorySize;
        this.price = mobilePhone.price;
    }

    public MobilePhone clone() throws CloneNotSupportedException{
        return (MobilePhone) super.clone();
    }
    //  --------------- LAB6 ---------------
    public String toDelimitedString ()
    {
        return  model + "," + type + "," + memorySize + "," + price ;
    }

}
