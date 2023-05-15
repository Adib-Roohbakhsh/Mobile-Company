import java.io.Serializable;

public class PersonalPlan extends MobilePlan implements Serializable {

    protected String city;

    public PersonalPlan(String userName, int id, MobilePhone handset, int internetQuota, int capLimit, String city, MyDate expiryDate) throws PlanException, PlanExceptionUserName {
        super(userName, id, handset, internetQuota, capLimit, expiryDate);
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void print() {
        super.print();
        System.out.println("    City: " + city);
    }

    public String toString() {
        return super.toString() + "    City: " + city + "\n";
    }

    @Override
    public double calcPayment(double flatRate) {
        return handset.getPrice() / 24 + (double) capLimit / 20 + internetQuota * 5 + flatRate;
    }

    //  ----- LAB4 -----
    public PersonalPlan(PersonalPlan personalPlan) throws CloneNotSupportedException {
        super(personalPlan);
        this.city = personalPlan.city;
    }
    //  --------------- LAB6 ---------------
    public String toDelimitedString() {
        return "PP," + super.toDelimitedString() +","+ city;
    }

    public PersonalPlan(String[] fields, int index) throws PlanException{
        super(fields, index);
        this.city = fields[index + 12];
    }
}