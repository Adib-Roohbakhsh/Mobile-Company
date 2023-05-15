
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;


public class DataBaseTest {
    public static void main(String[] args) throws PlanExceptionUserName, PlanException, IOException {
        MobileCompany company = new MobileCompany();
        company.loadTextFile("company.txt");
        DataBaseCompany dataBaseCompany = new DataBaseCompany("Company.accdb");
        dataBaseCompany.deleteAll();
        dataBaseCompany.saveData(company);
        DataBaseCompany dataBaseCompany1 = new DataBaseCompany("Test.accdb");
        dataBaseCompany1.deleteAll();
        dataBaseCompany1.saveData(fillData());
        test();
    }

    public static void test() throws PlanExceptionUserName, PlanException {

        MobilePhone mobilePhone10 = new MobilePhone("Nokia10", MobileType.WINDOWS, 256, 11000);
        MyDate expiryDate3 = new MyDate(2021, 12, 7);
        DataBaseCompany dataBaseCompany = new DataBaseCompany("Test.accdb");
        Connection connection = dataBaseCompany.getConnection();
        DataBaseMobilePlan dataBaseMobilePlan = new DataBaseMobilePlan(connection);
        DataBaseUser dataBaseUser = new DataBaseUser(connection);
//...............................
        HashMap<Integer, MobilePlan> plans = dataBaseMobilePlan.selectAllPlans();
        System.out.println(" \n\n\n\n\n\n\n\n\n\n\n\n\n\nplans \n");
        plans.values().forEach(System.out::println);
        BusinessPlan businessPlan10 = new BusinessPlan("USR303400U",  3123200, mobilePhone10, 23, 435, 575,324, expiryDate3);
        dataBaseMobilePlan.insertOneElement(businessPlan10);
        plans = dataBaseMobilePlan.selectAllPlans();
        System.out.println("  plans after insert \n");
        plans.values().forEach(System.out::println);
        System.out.println(" new  subject is inserted \n");
        dataBaseMobilePlan.selectOneElement(3123200).print();
        businessPlan10 = new BusinessPlan("USR303400U",  3123200, mobilePhone10, 128, 25, 73,10234, expiryDate3);
        dataBaseMobilePlan.updateObject(businessPlan10);
        System.out.println("\n\n updated plan \n");
        dataBaseMobilePlan.selectOneElement(3123200).print();
        dataBaseMobilePlan.deleteOnePlans(1);
        dataBaseMobilePlan.deleteOnePlans(3123200);
        plans = dataBaseMobilePlan.selectAllPlans();
        System.out.println(" deleting the plan \n");
        plans.values().forEach(System.out::println);

        //............................
        HashMap<Integer, User> users = dataBaseUser.selectAllElements();
        System.out.println("  users\n");
        users.values().forEach(System.out::print);
        dataBaseUser.insertOneElements(850, "Adib", "adib", "LA", "Green", "Flower", 117);
        users = dataBaseUser.selectAllElements();
        System.out.println(" users after insert \n");
        users.values().forEach(System.out::print);
        System.out.println(" new  user is inserted\n");
        dataBaseUser.selectOneUser(850).print();
        dataBaseUser.updateOneElement(850, "Adiboo", "adiboo", "NY", "Brown", "Stone", 186);
        System.out.println(" new updated user \n");
        dataBaseUser.selectOneUser(850).print();
        dataBaseUser.deleteOneElement(85);
        dataBaseUser.deleteOneElement(850);
        users = dataBaseUser.selectAllElements();
        System.out.println(" deleting the user\n");
        users.values().forEach(System.out::print);
    }

    public static MobileCompany fillData() throws PlanException, PlanExceptionUserName {
        MobileCompany mobileCompany = new MobileCompany("Test Company", "admin", "admin", 10);
        MobilePhone mobilePhone1 = new MobilePhone("Nokia 8", MobileType.WINDOWS, 128, 700);
        MobilePhone mobilePhone2 = new MobilePhone("Iphone X", MobileType.IOS, 64, 1000);
        MobilePhone mobilePhone3 = new MobilePhone("Samsung S21", MobileType.ANDROID, 256, 940);
        MobilePhone mobilePhone4 = new MobilePhone("Nokia 10", MobileType.WINDOWS, 64, 1700);

        MyDate date1 = new MyDate(2012, 7, 11);
        MyDate date2 = new MyDate(2017, 3, 17);
        MyDate date3 = new MyDate(2019, 9, 23);
        MyDate date4 = new MyDate(2021, 11, 29);

        PersonalPlan personalPlan1 = new PersonalPlan("USR888881U", 3888881, mobilePhone1, 8, 18, "London", date1);
        PersonalPlan personalPlan2 = new PersonalPlan("USR666662U", 3666662, mobilePhone2, 4, 15, "Paris", date2);
        BusinessPlan businessPlan1 = new BusinessPlan("USR999990U", 3999990, mobilePhone3, 8, 17, 12, 501, date3);
        BusinessPlan businessPlan2 = new BusinessPlan("USR757484U", 3757484, mobilePhone4, 4, 20, 8, 539, date4);

        Address address1 = new Address(18, "Black", "Smith", "Las Vegas");
        User user1 = new User("Shade", address1, "user");

        UserInterface.addPlan(user1, personalPlan1);
        UserInterface.addPlan(user1, personalPlan2);
        UserInterface.addPlan(user1, businessPlan1);
        UserInterface.addPlan(user1, businessPlan2);
        //----------------------------------------------------------------------------------------------------------

        Address address2 = new Address(28, "White", "Jan", "Los angeles");
        User user2 = new User("Jack", address2, "user");

        MobilePhone mobilePhone5 = new MobilePhone("Nokia 10", MobileType.WINDOWS, 128, 700);
        MobilePhone mobilePhone6 = new MobilePhone("Iphone 8", MobileType.IOS, 64, 1000);
        MobilePhone mobilePhone7 = new MobilePhone("Iphone X", MobileType.IOS, 64, 1000);

        MyDate date5 = new MyDate(2011, 12, 21);
        MyDate date6 = new MyDate(2016, 3, 27);
        MyDate date7 = new MyDate(2018, 1, 13);

        PersonalPlan personalPlan3 = new PersonalPlan("USR987471U", 3987471, mobilePhone5, 8, 18, "London", date5);
        PersonalPlan personalPlan4 = new PersonalPlan("USR256789U", 3256789, mobilePhone6, 4, 15, "Paris", date6);
        BusinessPlan businessPlan3 = new BusinessPlan("USR234567U", 3234567, mobilePhone7, 8, 17, 12, 501, date7);

        UserInterface.addPlan(user2, personalPlan3);
        UserInterface.addPlan(user2, personalPlan4);
        UserInterface.addPlan(user2, businessPlan3);
        //----------------------------------------------------------------------------------------------------------

        Address address3 = new Address(18, "Brown", "Smith", "London");
        User user3 = new User("Shade", address3, "user");

        MobilePhone mobilePhone8 = new MobilePhone("Samsung S20", MobileType.ANDROID, 256, 940);

        MyDate date8 = new MyDate(2020, 9, 29);

        BusinessPlan businessPlan4 = new BusinessPlan("USR234566U", 3234566, mobilePhone8, 8, 17, 12, 501, date8);

        UserInterface.addPlan(user3, businessPlan4);

        //----------------------------------------------------------------------------------------------------------

        Address address4 = new Address(73, "Green", "Flower", "London");
        User user4 = new User("Oak", address4, "user");

        //----------------------------------------------------------------------------------------------------------

        UserInterface.addUser(user1, mobileCompany);
        UserInterface.addUser(user2, mobileCompany);
        UserInterface.addUser(user3, mobileCompany);
        UserInterface.addUser(user4, mobileCompany);
        return mobileCompany;

    }
}
