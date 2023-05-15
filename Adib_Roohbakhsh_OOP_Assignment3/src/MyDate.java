import java.io.Serializable;

public class MyDate implements Cloneable, Comparable<MyDate>, Serializable {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void print() {
        System.out.print(year + " / " + month + " / " + day);
    }

    public String toString() {
        return year + " / " + month + " / " + day;
    }

    public Boolean isExpired(MyDate expiryDate) {
        boolean outcome = false;
        if (expiryDate.year > year) {
            outcome = true;
        }
        if (expiryDate.year == year) {
            if (expiryDate.month > month) {
                outcome = true;
            }
            if (expiryDate.month == month) {
                if (expiryDate.day >=day) {
                    outcome = true;
                }

            }
        }
        return outcome;
    }

    //  ----- LAB4 -----

    public MyDate(MyDate myDate) {
        this.day = myDate.day;
        this.month =  myDate.month;
        this.year =  myDate.year;
    }

    public MyDate clone() throws CloneNotSupportedException{
        return (MyDate) super.clone();
    }

    public int compareTo(MyDate myDate){
        if (year> myDate.year){
            return 1;
        }else if (year == myDate.year){
            if (month > myDate.month){
                return 1;
            }else if (month == myDate.month){
                if (day > myDate.day){
                    return 1;
                }else if(day == myDate.day){
                    return 0;
                }
            }
        }
        return -1;
    }

    //  --------------- LAB6 ---------------
    public String toDelimitedString ()
    {
        return year + "," + month + "," + day;
    }

}
