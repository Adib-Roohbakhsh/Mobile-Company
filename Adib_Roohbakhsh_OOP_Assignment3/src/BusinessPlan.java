import java.io.Serializable;

public class BusinessPlan extends MobilePlan implements Serializable {

    protected int numberOfEmployees;
    protected int ABN;

    public BusinessPlan(String userName, int id, MobilePhone handset, int internetQuota, int capLimit, int numberOfEmployees, int ABN, MyDate expiryDate) throws PlanException, PlanExceptionUserName {
        super(userName, id, handset, internetQuota, capLimit, expiryDate);
        this.numberOfEmployees = numberOfEmployees;
        this.ABN = ABN;
    }

    public int getABN() {
        return ABN;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    @Override
    public double calcPayment(double flatRate) {
        double finalPayment = handset.getPrice() / 24 + (double) capLimit / 10 + internetQuota * 10 + flatRate;
        if (this.numberOfEmployees > 10) {
            finalPayment += (numberOfEmployees - 10) * 50;
        }
        return finalPayment;
    }

    public void print() {
        super.print();
        System.out.println("    Number of Employees: " + numberOfEmployees + "    Australian Business Number (ABN):" + ABN);
    }

    public String toString() {
        return super.toString() + "    Number of Employees: " + numberOfEmployees + "    Australian Business Number (ABN):" + ABN + "\n";
    }

    //  ----- LAB4 -----
    public BusinessPlan(BusinessPlan businessPlan) throws CloneNotSupportedException {
        super(businessPlan);
        this.ABN = businessPlan.ABN;
        this.numberOfEmployees = businessPlan.numberOfEmployees;
    }


//  --------------- LAB6 ---------------
public String toDelimitedString() {
    return "BP," + super.toDelimitedString() +","+ numberOfEmployees+","+ABN;
}

    public BusinessPlan(String[] fields, int index) throws PlanException{
        super(fields, index);
        this.numberOfEmployees =Integer.parseInt(fields[index + 12]);
        this.ABN = Integer.parseInt(fields[index + 13]);
    }
}
