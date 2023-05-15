import java.util.function.Predicate;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class UserInterface {
    public static Scanner scanner;

    private MobileCompany mobileCompany;

    public UserInterface(MobileCompany mobileCompany) {
        this.mobileCompany = mobileCompany;
        scanner = new Scanner(System.in);
    }

    public void fillData() throws PlanException, PlanExceptionUserName {
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

        addPlan(user1, personalPlan1);
        addPlan(user1, personalPlan2);
        addPlan(user1, businessPlan1);
        addPlan(user1, businessPlan2);
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

        addPlan(user2, personalPlan3);
        addPlan(user2, personalPlan4);
        addPlan(user2, businessPlan3);
        //----------------------------------------------------------------------------------------------------------

        Address address3 = new Address(18, "Brown", "Smith", "London");
        User user3 = new User("Shade", address3, "user");

        MobilePhone mobilePhone8 = new MobilePhone("Samsung S20", MobileType.ANDROID, 256, 940);

        MyDate date8 = new MyDate(2020, 9, 29);

        BusinessPlan businessPlan4 = new BusinessPlan("USR234566U", 3234566, mobilePhone8, 8, 17, 12, 501, date8);

        addPlan(user3, businessPlan4);

        //----------------------------------------------------------------------------------------------------------

        Address address4 = new Address(73, "Green", "Flower", "London");
        User user4 = new User("Oak", address4, "user");

        //----------------------------------------------------------------------------------------------------------

        addUser(user1, mobileCompany);
        addUser(user2, mobileCompany);
        addUser(user3, mobileCompany);
        addUser(user4, mobileCompany);

        System.out.println(" Data filled successfully");

    }

    public void mainMenu() throws CloneNotSupportedException, PlanException, IOException, PlanExceptionUserName {
        mobileCompany.load("mobileCompany.ser");
        int MenuOption = 0;
        while (MenuOption != 3) {
            displayMainMenu();
            MenuOption = getInt();

            switch (MenuOption) {
                case 1:
                    if (adminLogin()) {
                        scanner.nextLine();
                        press();
                        adminMenu();
                    }
                    press();
                    break;
                case 2:
                    userLogin();
                    scanner.nextLine();
                    press();

                    break;

                case 3:
                    mobileCompany.save("mobileCompany.ser");
                    System.out.println("Have a good day :) ");
                    break;

                default:
                    System.err.println("\nWrong number try again\n ");
                    press();
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n Main Menu \n");
        System.out.println("1- Admin Menu");
        System.out.println("2- User Menu");
        System.out.println("3- Save data and Exit ");
    }

    private boolean adminLogin() {
        System.out.print("\nPlease enter admin username: ");
        String username = scanner.next();

        System.out.print("Please enter admin password: ");
        String password = scanner.next();

        if (!mobileCompany.validateAdmin(username, password)) {
            System.err.println("\nWrong username or password.\n");
            scanner.nextLine();
            return false;

        } else {
            System.out.println("\n You Log in successful!");
            return true;
        }
    }

    private void adminMenu() throws CloneNotSupportedException, PlanException, IOException, PlanExceptionUserName {
        int adminOption = 0;
        while (adminOption != 18) {
            displayAdminMenu();
            adminOption = getInt();
            switch (adminOption) {
                case 1:
                    fillData();
//                    testCase();
//                    press();
//                    TestcaseFile();
//                    press();
//                    testCaseAdvance();
//                    press();
                    testCaseLambda();
                    press();
                    break;
                case 2:
                    createUser();
                    scanner.nextLine();
                    press();
                    break;
                case 3:
                    createPersonalPlan();
                    press();
                    break;
                case 4:
                    createBusinessPlan();
                    press();
                    break;
                case 5:
                    printUserInformation();
                    press();
                    break;
                case 6:
                    filterByMobileModel();
                    press();
                    break;
                case 7:
                    filterByExpiryDate();
                    press();
                    break;
                case 8:
                    updateAddressAdmin();
                    scanner.nextLine();
                    press();
                    break;
                case 9:
                    removePlanAdmin();
                    press();
                    break;
                case 10:
                    removeUser();
                    press();
                    break;
                case 11:
                    changePassword();
                    press();
                    break;
                case 12:
                    reportPaymentPerCity();
                    press();
                    break;
                case 13:
                    reportPaymentsPerMobileModel();
                    press();
                    break;
                case 14:
                    reportPaymentsPerMobileModelForUser();
                    press();
                    break;
                case 15:
                    sortUsersByMonthlyPayment();
                    press();
                    break;
                case 16:
                    reportUsersPerCity();
                    press();
                    break;
                case 17:
                    reportPlansByExpiryDate();
                    press();
                    break;
                case 18:
                    return;
                default:
                    System.err.println("\nWrong number!! Try again\n ");
                    press();
            }
        }
    }

    public static void displayAdminMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n Admin Menu \n");
        System.out.println("1- Test code");
        System.out.println("2- Create user");
        System.out.println("3- Create Personal Plan");
        System.out.println("4- Create Business Plan");
        System.out.println("5- Print User Information");
        System.out.println("6- Filter by Mobile Model");
        System.out.println("7- Filter by Expiry Date");
        System.out.println("8- Update Address");
        System.out.println("9- Remove Plan");
        System.out.println("10- Remove User");
        System.out.println("11- Change Password ");
        System.out.println("12- Report Payment Per City fo users");
        System.out.println("13- Report Payments Per Mobile Model for users");
        System.out.println("14- Report Payments Per Mobile Model for a user");
        System.out.println("15- Sort Users By Monthly Payment");
        System.out.println("16- Report Users Per City");
        System.out.println("17- Report Plans By ExpiryDate ");
        System.out.println("18- Back to Main Menu ");
        System.out.print("\nPlease enter the number of option you want.");
    }


    private void testCase() throws CloneNotSupportedException, PlanException, PlanExceptionUserName {

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

        addPlan(user1, personalPlan1);
        addPlan(user1, personalPlan2);
        addPlan(user1, businessPlan1);
        addPlan(user1, businessPlan2);
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

        addPlan(user2, personalPlan3);
        addPlan(user2, personalPlan4);
        addPlan(user2, businessPlan3);
        //----------------------------------------------------------------------------------------------------------

        Address address3 = new Address(18, "Brown", "Smith", "London");
        User user3 = new User("Shade", address3, "user");

        MobilePhone mobilePhone8 = new MobilePhone("Samsung S20", MobileType.ANDROID, 256, 940);

        MyDate date8 = new MyDate(2020, 9, 29);

        BusinessPlan businessPlan4 = new BusinessPlan("USR389527U", 3234566, mobilePhone8, 8, 17, 12, 501, date8);

        addPlan(user3, businessPlan4);

        //----------------------------------------------------------------------------------------------------------

        Address address4 = new Address(73, "Green", "Flower", "London");
        User user4 = new User("Oak", address4, "user");

        //----------------------------------------------------------------------------------------------------------

        addUser(user1, mobileCompany);
        addUser(user2, mobileCompany);
        addUser(user3, mobileCompany);
        addUser(user4, mobileCompany);

        System.out.println("***************************************************************\n");
        System.out.println("Find and print plan that exist:\n");
        findAndPrintPlan(user1, 3888881);
        System.out.println("***************************************************************\n");
        System.out.println("Find and print plan that not exist:\n");
        findAndPrintPlan(user1, 1);
        System.out.println("***************************************************************\n");
        System.out.println("\nFind a plan of a user by plan Id:");
        MobilePlan foundPlan = user1.findPlan(3888881,user1.getUserID(),user1.getUserPassword());
        System.out.println("\nPrint found plan");
        foundPlan.print();
        System.out.println("\nPrice rise by rise percent = 0.1 and then print it again.");
        System.out.println("Price rise should change to (700 * 1.1 = 770) ");
        foundPlan.mobilePriceRise(0.1);
        foundPlan.print();
        System.out.println("\nPrint total payment price rise all by rise percent= 10 and print again. ");
        System.out.println("Total payment is 509");
        printTotalPayment(user1, mobileCompany.getFlatRate());
        user1.mobilePriceRiseAll(10);
        System.out.println("\nTotal payment after 10 percent should be 527");
        printTotalPayment(user1, mobileCompany.getFlatRate());
        System.out.println("***************************************************************\n");
        System.out.println("Filtered list by Nokia mobile model ");
//        ArrayList<MobilePlan> filteredListByMobileModel = user1.filterByMobileModel("Nokia");
        HashMap<Integer, MobilePlan> filteredListByMobileModel = user1.filterByMobileModel("Nokia");
        System.out.println("List should be contain two Nokia device:");
        MobilePlan.printPlans(filteredListByMobileModel);
        System.out.println("***************************************************************\n");
        System.out.println("Filtered list by expiry date");
//        ArrayList<MobilePlan> filteredListByExpiryDate = user1.filterByExpiryDate(new MyDate(2015, 1, 1));
        HashMap<Integer, MobilePlan> filteredListByExpiryDate = user1.filterByExpiryDate(new MyDate(2015, 1, 1));
        System.out.println("List should be contain a date before 2015/1/1 ");
        MobilePlan.printPlans(filteredListByExpiryDate);
        System.out.println("***************************************************************\n");
        System.out.println("wrong user name and password");
        String wrongUserName = "wsedtrfyg";
        String wrongPassword = "xdcfvgh";
        checkAdminLogin(wrongUserName, wrongPassword, mobileCompany);
        System.out.println("\n correct user and password");
        String userName = "admin";
        String password = "admin";
        checkAdminLogin(userName, password, mobileCompany);
        System.out.println("***************************************************************\n");
        System.out.println("create a businessPlan:");
        createBusinessPlan(user1.getUserID(), "USR678905U", 3678905, mobilePhone4, 8, 15, date4,
                20, 689, mobileCompany);
        System.out.println("create a personalPlan with wrong id");
        createPersonalPlan(110, "USR8765378U", 38765378, mobilePhone3, 3, 12, date3, "London", mobileCompany);
        System.out.println("create a personalPlan with correct id");
        createPersonalPlan(user2.getUserID(), "USR345677U", 3456787, mobilePhone3, 9, 17, date3, "Moscow", mobileCompany);
        System.out.println("***************************************************************\n");
        System.out.println("Find plan of a user and print it with find methods");
        int userID = 2;
        User wantedUser = mobileCompany.findUser(userID, mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        wantedUser.print();
        int planID = 3456787;
        MobilePlan plan = mobileCompany.findPlan(userID, planID, mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        plan.print();
        System.out.println("***************************************************************\n");
        System.out.println("Print company then price rise by 10 percent and again print ");
        mobileCompany.print();
        System.out.println("_______________________________________________________________");
        mobileCompany.mobilePriceRise(10);
        System.out.println("_______________________________________________________________");
        mobileCompany.print();
        System.out.println("***************************************************************\n");
        System.out.println("Total payment of user 2 should be 505");
        System.out.println("Total payment of user: " + mobileCompany.calcTotalPayments());
        System.out.println("Total payment of company  should be 1987");
        System.out.println("Total  payment of company: " + mobileCompany.calcTotalPayments());
        System.out.println("***************************************************************\n");
        System.out.println("Prints company plans");
        MobilePlan.printPlans(mobileCompany.allPlans());
        System.out.println("Prints company plans filtered by date 2015/1/1");
        MobilePlan.printPlans(mobileCompany.filterByExpiryDate(userID, new MyDate(2015, 1, 1),mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword()));
        System.out.println("***************************************************************\n");
        System.out.println("Populate Distinct Mobile Models of a user ");
        System.out.println("Our output should be: \n Nokia8  $90  $90 \nNokia 10  $832  $416  \nIphone X  $81  $81  \nSamsung S21   $244   $244");
//        ArrayList<String> mobileModelList = user1.populateDistinctMobileModels();
//        user1.reportPaymentsPerMobileModel(mobileModelList, user1.getTotalCountPerMobileModel(mobileModelList),
//                user1.getTotalPaymentPerMobileModel(mobileModelList, mobileCompany.getFlatRate()));
        user1.reportPaymentsPerMobileModel(user1.getTotalCountPerMobileModel(user1.getUserID(),user1.getUserPassword()),
                user1.getTotalPaymentPerMobileModel(mobileCompany.getFlatRate(),user1.getUserID(),user1.getUserPassword()));
        System.out.println("***************************************************************\n");
        System.out.println(" Report payment per city of company ");
        System.out.println(" We should have three city  \nLas Vegas   $1247\n  Los angeles    $505\n  London   $235 ");
//        ArrayList<String> cityList = mobileCompany.populateDistinctCityNames();
//        mobileCompany.reportPaymentPerCity(cityList, mobileCompany.getTotalPaymentPerCity(cityList));
        mobileCompany.reportPaymentPerCity(mobileCompany.getTotalPaymentPerCity(mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword()));
        System.out.println("***************************************************************\n");
        System.out.println("Populate Distinct Mobile Models of company  ");
        System.out.println(" We should have :\nNokia 8     $90    $90 \nIphone X    $81    $81 \nSamsung S21   $244   $244\n Nokia 10    $832    $416 \n Iphone 8  0   0 \nSamsung S20     $0    $0");
//        ArrayList<String> mobileModelListByMobileModel = mobileCompany.populateDistinctMobileModels();
//        mobileCompany.reportPaymentsPerMobileModel(mobileModelListByMobileModel,
//                mobileCompany.getTotalCountPerMobileModel(mobileModelListByMobileModel),
//                mobileCompany.getTotalPaymentPerMobileModel(mobileModelListByMobileModel));
        mobileCompany.reportPaymentsPerMobileModel(mobileCompany.getTotalCountPerMobileModel(mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword()),
                mobileCompany.getTotalPaymentPerMobileModel(mobileCompany.getFlatRate(),mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword()));

        //________________________________ Deep and shallow copy ______________________________________________
        ArrayList<MobilePlan> deepCopyUserPlans = user1.deepCopyPlans();
        ArrayList<MobilePlan> shallowCopyUserPlans = user1.shallowCopyPlans();
        user1.setCity("New York");
        personalPlan1.setCity("New York");
        personalPlan1.setExpiryDate(new MyDate(2020, 3, 4));
        personalPlan2.setCapLimit(9);
        personalPlan2.setInternetQuota(6);
        personalPlan2.setHandsetModel("Xiaomi note9");
        user1.addPlan(personalPlan4,user1.getUserID(),user1.getUserPassword());
        user1.sortPlansByDate();
        System.out.println("\nMain Plans list");
        MobilePlan.printPlans(user1.getPlans());
        System.out.println("\nDeep copy Plans list");
        MobilePlan.printPlans(deepCopyUserPlans);
        System.out.println("\nShallow copy Plans list");
        MobilePlan.printPlans(shallowCopyUserPlans);
//        ArrayList<User> deepCopyUsers = mobileCompany.deepCopyUsers();
//        ArrayList<User> shallowCopyUsers = mobileCompany.shallowCopyUsers();
        HashMap<Integer, User> deepCopyUsers = mobileCompany.deepCopyUsersHashMap();
        HashMap<Integer, User> shallowCopyUsers = mobileCompany.shallowCopyUsersHashMap();
        Address address = new Address(12, "Great wall", "Ruby", "San Andreas");
        mobileCompany.addUser("Willy", address, "adiboo",mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        mobileCompany.sortUsers(mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        System.out.println("\nMain Users list");
        User.printUsers(mobileCompany.getUsers());
        System.out.println("\nDeep copy Users list");
//        User.printUsers(deepCopyUsers);
        User.printUsers(deepCopyUsers);
        System.out.println("\nShallow copy Users list");
//        User.printUsers(shallowCopyUsers);
        User.printUsers(shallowCopyUsers);
        MobileCompany mobileCompanyClone = mobileCompany.clone();
        mobileCompany.setFlatRate(8);
        mobileCompany.changePassword("12345", "admin");
        mobileCompany.createBusinessPlan(1, "USR345123U", 3345123, mobilePhone7, 8, 18, date7, 12, 22,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        mobileCompany.createPersonalPlan(1, "USR349923U", 3349923, mobilePhone6, 8, 18, date6, "London",mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        mobileCompany.setName("Smart Tech");
        System.out.println("\nEnter Main Company");
        mobileCompany.validateAdmin("admin", "adiboo");
        System.out.println("\nEnter Clone Company");
        mobileCompanyClone.validateAdmin("admin", "adiboo");
        System.out.println("\nMain Company");
        mobileCompany.print();
        System.out.println("\nClone Company");
        mobileCompanyClone.print();
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.println("Sort Users By Monthly Payment");
        ArrayList<User> sortedList2 = mobileCompany.sortUsersByMonthlyPayment(mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        User.printUsersPayment(sortedList2, mobileCompany.getFlatRate());
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.println("filter Plans By Expiry date");
        MyDate expiryDate = new MyDate(2015, 1, 1);
        mobileCompany.reportPlansByExpiryDate(expiryDate,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        System.out.println("\nfilter Users Per city");
        mobileCompany.reportUsersPerCity(mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        System.out.print("\n\nIf you want to finish test:");

    }

    public void TestcaseFile() throws IOException, PlanException, PlanExceptionUserName {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("testing binary file and list of plans");
        MobilePlan.save(mobileCompany.allPlans(), "plans.ser");
        HashMap<Integer, MobilePlan> plans = MobilePlan.load("plans.ser");
        MobilePlan.printPlans(plans);
        MobilePhone mobilePhone = new MobilePhone("Nokia 888", MobileType.WINDOWS, 1288, 7000);
        MyDate date = new MyDate(2002, 7, 11);
        PersonalPlan personalPlan = new PersonalPlan("USR885678U", 3885678, mobilePhone, 88, 188, "London", date);
        plans.put(12, personalPlan);
        MobilePlan.save(plans, "plans.ser");
        plans.clear();
        plans = MobilePlan.load("plans.ser");
        MobilePlan.printPlans(plans);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("testing binary file and list of users");
        User.save(mobileCompany.getUsers(), "users.ser");
        HashMap<Integer, User> users = User.load("users.ser");
        User.printUsers(users);
        Address address3 = new Address(18, "Brown", "Smith", "London");
        User usr = new User("Shade", address3, "user");
        usr.addPlan(personalPlan,usr.getUserID(), usr.getUserPassword());
        users.put(usr.getUserID(), usr);
        User.save(users, "users.ser");
        users.clear();
        users = User.load("users.ser");
        User.printUsers(users);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("mobileCompany and binary file");
        mobileCompany.save("company.ser");
        MobileCompany mobileCompany1 = new MobileCompany();
        mobileCompany1.load("company.ser");
        System.out.println(mobileCompany1);
        mobileCompany1.addUser(usr,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        mobileCompany1.addPlan(11, personalPlan,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        mobileCompany1.save("company.ser");
        MobileCompany mobileCompany2 = new MobileCompany();
        mobileCompany2.load("company.ser");
        System.out.println(mobileCompany2);


        System.out.println("\n------------------------------------------------------------------------\n");
        System.out.println("testing text file and list of plans with toDelimitedString");
//        MobilePhone mobilePhone = new MobilePhone("Nokia 888", MobileType.WINDOWS, 1288, 7000);
//        MyDate date = new MyDate(2002, 7, 11);
//        PersonalPlan personalPlan = new PersonalPlan("Jaycob", 3885678, mobilePhone, 88, 188, "London", date);
        BusinessPlan businessPlan = new BusinessPlan("USR383367U", 3833678, mobilePhone, 66, 166, 11, 11, date);
        MobilePlan.saveTextFile(mobileCompany.allPlans(), "plans.txt");
        HashMap<Integer, MobilePlan> plansText = MobilePlan.loadTextFile("plans.txt");
        MobilePlan.printPlans(plansText);
        System.out.println("\n------------------------------------------------------------------------\n");
        plansText.put(personalPlan.id, personalPlan);
        plansText.put(businessPlan.id, businessPlan);
        MobilePlan.saveTextFile(plansText, "plans.txt");
        plansText.clear();
        plansText = MobilePlan.loadTextFile("plans.txt");
        MobilePlan.printPlans(plansText);

        System.out.println("\n------------------------------------------------------------------------\n");
        System.out.println("testing text file and list of users with toDelimitedString");
        User.saveTextFile(mobileCompany.getUsers(), "users.txt");
        HashMap<Integer, User> usersText = User.loadTextFile("users.txt");
        User.printUsers(usersText);
        System.out.println("\n------------------------------------------------------------------------\n");
//        Address address3 = new Address(18, "Brown", "Smith", "London");
        User user = new User("Shade", address3, "user");
        user.addPlan(personalPlan,user.getUserID(),user.getUserPassword());
        usersText.put(user.getUserID(), user);
        User.saveTextFile(users, "users.txt");
        usersText.clear();
        usersText = User.loadTextFile("users.txt");
        User.printUsers(usersText);

        System.out.println("\n------------------------------------------------------------------------\n");
        System.out.println("mobileCompany and text file");
        mobileCompany.saveTextFile("company.txt");
//        MobileCompany mobileCompany1 = new MobileCompany();//using default constructor
        mobileCompany1.loadTextFile("company.txt");//all users and all plans are loaded
        System.out.println(mobileCompany1);
        System.out.println("\n------------------------------------------------------------------------\n");
        mobileCompany1.addUser(user,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        mobileCompany1.addPlan(user.getUserID(), personalPlan,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        mobileCompany1.saveTextFile("company.txt");
//        MobileCompany mobileCompany2 = new MobileCompany();
        mobileCompany2.loadTextFile("company.txt");
        System.out.println(mobileCompany2);
        System.out.println("\n------------------------------------------------------------------------\n");
        System.out.print("Please enter any key to finish test");
    }

    private void createUser() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Create an User :\n");
        System.out.print(" Please enter User's name: ");
        String name = scanner.nextLine();
        System.out.print(" Please enter password: ");
        String password = scanner.nextLine();
        addUser(name, getAddress(), mobileCompany, password);
        System.out.println();
    }

    private void createPersonalPlan() throws PlanException, PlanExceptionUserName {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(" Please enter the user Id of the user that you want to add plan");
        int userID = getInt();
        getPersonalPlan(userID);
    }

    private void createPersonalPlan(int userID) throws PlanException, PlanExceptionUserName {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        getPersonalPlan(userID);
    }

    public void getPersonalPlan(int userID) throws PlanException, PlanExceptionUserName {
        if (mobileCompany.findUser(userID,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword()) != null) {
            System.out.println(" Create Personal Plan:\n");
            System.out.println("Please enter username.");
            String username = scanner.nextLine();
            System.out.println("Please enter id.");
            int id = getInt();
            System.out.println("Please enter internet quota.");
            int internetQuota = getInt();
            System.out.println("Please enter cap limit.");
            int capLimit = getInt();
            System.out.println("Please enter plan's city.");
            String city = scanner.nextLine();
            MobilePhone mobilePhone = getMobilePhone();
            MyDate myDate = getExpiryDate();
            String newUserName;
            int newId;
            try {
                createPersonalPlan(userID, username, id, mobilePhone, internetQuota, capLimit, myDate, city, mobileCompany);
            } catch (PlanExceptionUserName eu) {
                newUserName = eu.getNewUserName();
                System.out.println(eu);
                try {
                    createPersonalPlan(userID, newUserName, id, mobilePhone, internetQuota, capLimit, myDate, city, mobileCompany);
                } catch (PlanException e) {
                    System.out.println(e);
                    createPersonalPlan(userID, newUserName, e.getNewID(), mobilePhone, internetQuota, capLimit, myDate, city, mobileCompany);
                }
            } catch (PlanException e) {
                newId = e.getNewID();
                System.out.println(e);
                createPersonalPlan(userID, username, newId, mobilePhone, internetQuota, capLimit, myDate, city, mobileCompany);
            }

        } else
            System.err.println("Sorry User with user Id :" + userID + " is not available.");
    }

    private void createBusinessPlan() throws PlanException, PlanExceptionUserName {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(" Please enter the user Id of the user that you want to add plan");
        int userID = getInt();
        getBusinessPlan(userID);
    }

    private void createBusinessPlan(int userID) throws PlanException, PlanExceptionUserName {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        getBusinessPlan(userID);
    }

    public void getBusinessPlan(int userID) throws PlanException, PlanExceptionUserName {
        if (mobileCompany.findUser(userID,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword()) != null) {
            System.out.println(" Create Business Plan:\n");
            System.out.println("Please enter username.");
            String username = scanner.nextLine();
            System.out.println("Please enter id.");
            int id = getInt();
            System.out.println("Please enter internet quota.");
            int internetQuota = getInt();
            System.out.println("Please enter cap limit.");
            int capLimit = getInt();
            System.out.println("Please enter ABN.");
            int ABN = getInt();
            System.out.println("Please enter number of employees.");
            int numberOfEmployees = getInt();
            MobilePhone mobilePhone = getMobilePhone();
            MyDate myDate = getExpiryDate();
            String newUserName;
            int newId;
            try {
                createBusinessPlan(userID, username, id, mobilePhone, internetQuota, capLimit, myDate, numberOfEmployees, ABN, mobileCompany);
            } catch (PlanExceptionUserName eu) {
                newUserName = eu.getNewUserName();
                System.out.println(eu);
                try {
                    createBusinessPlan(userID, newUserName, id, mobilePhone, internetQuota, capLimit, myDate, numberOfEmployees, ABN, mobileCompany);
                } catch (PlanException e) {
                    System.out.println(e);
                    createBusinessPlan(userID, newUserName, e.getNewID(), mobilePhone, internetQuota, capLimit, myDate, numberOfEmployees,
                            ABN, mobileCompany);
                }

            } catch (PlanException e) {
                newId = e.getNewID();
                System.out.println(e);
                createBusinessPlan(userID, username, newId, mobilePhone, internetQuota, capLimit, myDate, numberOfEmployees, ABN, mobileCompany);
            }
        } else
            System.err.println("Sorry User with user Id :" + userID + " is not available.");
    }

    private void printUserInformation() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Print User Information:\n");
        System.out.println(" Please enter the user Id of the user that you want to print");
        int userID = getInt();
        User foundUser = mobileCompany.findUser(userID,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        if (foundUser != null) {
            foundUser.print();
        } else
            System.err.println("Sorry User with user Id :" + userID + " is not available.");
    }

    private void filterByMobileModel() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Filter By Mobile Model:\n");
        System.out.println(" Please enter the mobile model that you wan to filter with");
        String mobileModel = scanner.nextLine();
//        ArrayList<MobilePlan> filteredList = mobileCompany.filterByMobileModel(mobileModel);
        HashMap<Integer, MobilePlan> filteredList = mobileCompany.filterByMobileModel(mobileModel,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        MobilePlan.printPlans(filteredList, mobileCompany.getFlatRate());
    }

    private void filterByExpiryDate() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Filter By  Model Expiry Date:\n");
        System.out.println(" Please enter the user Id of the user that you want to filter");
        int userID = getInt();
        User foundUser = mobileCompany.findUser(userID,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        if (foundUser != null) {
//            ArrayList<MobilePlan> filteredList = foundUser.filterByExpiryDate(getExpiryDate());
            HashMap<Integer, MobilePlan> filteredList = foundUser.filterByExpiryDate(getExpiryDate());
            MobilePlan.printPlans(filteredList);
        } else
            System.err.println("Sorry User with user Id :" + userID + " is not available.");
    }

    private void updateAddressUser(int userID) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        updateAddress(userID);
    }

    private void updateAddressAdmin() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(" Please enter the user Id of the user that you want to update its address.");
        int userID = getInt();
        updateAddress(userID);
    }

    private void updateAddress(int userID) {
        User user = mobileCompany.findUser(userID,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        if (user != null) {
            System.out.println(" Update Address\n");
            user.setAddress(getAddress());
        } else
            System.err.println("Sorry User with user Id :" + userID + " is not available.");
    }

    private void removeUser() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Remove User:\n");
        System.out.println(" Please enter the user Id of the user that you want to remove.");
        int userID = getInt();
        User user = mobileCompany.findUser(userID,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        if (user != null) {
            mobileCompany.getUsers().remove(user);
            System.out.println("User removed successfully");
        } else
            System.err.println("User not found!");
    }

    private void changePassword() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Change password :\n");
        System.out.println("Please enter your old password:");
        String oldPassword = scanner.nextLine();
        System.out.println("Please enter your new password");
        String newPassword = scanner.nextLine();
        if (mobileCompany.changePassword(newPassword, oldPassword)) {
            System.out.println("Password changed successfully");
        } else
            System.err.println("The Old password is incorrect!!");
    }

    private void userMenu(int userID, String password) throws PlanException, PlanExceptionUserName {
        int userOption = 0;
        while (userOption != 8) {
            displayUserMenu();
            userOption = getInt();
            switch (userOption) {
                case 1:
                    createBusinessPlan(userID);
                    press();
                    break;
                case 2:
                    createPersonalPlan(userID);
                    press();
                    break;
                case 3:
                    printPlan(userID);
                    press();
                    break;
                case 4:
                    removePlanUser(userID);
                    press();
                    break;
                case 5:
                    updateAddressUser(userID);
                    press();
                    break;
                case 6:
                    User user = mobileCompany.findUser(userID,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
                    user.print(mobileCompany.getFlatRate());
                    scanner.nextLine();
                    press();
                    break;
                case 7:
                    reportPaymentsPerMobileModel(userID);
                    press();
                    break;
                case 8:
                    return;
                default:
                    System.err.println("\nWrong number!! Try again\n ");
                    press();
            }
        }
    }

    public static void displayUserMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n User Menu \n");
        System.out.println("1- Add Business Plan");
        System.out.println("2- Add Personal Plan");
        System.out.println("3- Print Plan");
        System.out.println("4- Remove Plan");
        System.out.println("5- Change Address");
        System.out.println("6- Print User information");
        System.out.println("7- Report Payments Per Mobile Model");
        System.out.println("8- Back to Main Menu");
        System.out.print("\nPlease enter the number of option you want.");
    }

    private void userLogin() throws PlanExceptionUserName, PlanException {
        System.out.println(" Please enter the user Id of the user that you want to log in");
        int userID = getInt();
        System.out.print("Please enter User password: ");
        String password = scanner.next();
        if (mobileCompany.validateUser(userID, password,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword()) != null) {
            userMenu(userID, password);
        }
    }


    private void removePlanUser(int userID) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        removePlan(userID);
    }

    private void removePlanAdmin() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(" Please enter the user Id of the user that you want to remove");
        int userID = getInt();
        removePlan(userID);
    }

    private void removePlan(int userID) {
        User user = mobileCompany.findUser(userID,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        if (user != null) {
            System.out.println("Remove Plan:\n");
            System.out.println("Please enter the plan's id that you want to remove");
            int planId = getInt();
            MobilePlan plan = user.findPlan(planId,user.getUserID(),user.getUserPassword());
            if (plan != null) {
                user.getPlans().remove(plan);
                System.out.println("Plan removed successfully");
            } else
                System.out.println("Sorry plan not found");
        } else
            System.err.println("Sorry User with user Id :" + userID + " is not available.");
    }

    private void printPlan(int userID) {
        User user = mobileCompany.findUser(userID,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Please enter the plan's id that you want to print");
        int planId = getInt();
        findAndPrintPlan(user, planId);
    }

    public Address getAddress() {
        System.out.println("Your  Address:\n");
        System.out.println("Please enter your city");
        String city = scanner.next();
        System.out.println("Please enter your  suburb");
        scanner.next();
        String suburb = scanner.nextLine();
        System.out.println("Please enter you street");
        String street = scanner.nextLine();
        System.out.println("Please enter your street number");
        int streetNum = getInt();
        return new Address(streetNum, street, suburb, city);
    }

//    private void reportPaymentsPerMobileModel(User user) {
//        ArrayList<String> mobileModelList = user.populateDistinctMobileModels();
//        user.reportPaymentsPerMobileModel(mobileModelList, user.getTotalCountPerMobileModel(mobileModelList),
//                user.getTotalPaymentPerMobileModel(mobileModelList, mobileCompany.getFlatRate()));
//    }

    private void reportPaymentsPerMobileModel(int userID) {
        User user = mobileCompany.findUser(userID,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        user.reportPaymentsPerMobileModel(user.getTotalCountPerMobileModel(userID, user.getUserPassword()), user.getTotalPaymentPerMobileModel(mobileCompany.getFlatRate(),userID, user.getUserPassword()));
    }

//    private void reportPaymentsPerMobileModel() {
//        ArrayList<String> mobileModelList = mobileCompany.populateDistinctMobileModels();
//        mobileCompany.reportPaymentsPerMobileModel(mobileModelList, mobileCompany.getTotalCountPerMobileModel(mobileModelList),
//                mobileCompany.getTotalPaymentPerMobileModel(mobileModelList));
//    }

    private void reportPaymentsPerMobileModel() {
        mobileCompany.reportPaymentsPerMobileModel(mobileCompany.getTotalCountPerMobileModel(mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword()), mobileCompany.getTotalPaymentPerMobileModel(mobileCompany.getFlatRate(),mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword()));
    }

//    private void reportPaymentPerCity() {
//        ArrayList<String> cityList = mobileCompany.populateDistinctCityNames();
//        mobileCompany.reportPaymentPerCity(cityList, mobileCompany.getTotalPaymentPerCity(cityList));
//    }

    private void reportPaymentsPerMobileModelForUser() {
        System.out.println(" Please enter the user Id of the user that you want to get report.");
        int userID = getInt();
        User user = mobileCompany.findUser(userID,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        if (user != null) {
            reportPaymentsPerMobileModel(userID);
            System.out.println("\n\nUser reported successfully");
        } else
            System.err.println("User not found!");
    }

    private void reportPaymentPerCity() {
        mobileCompany.reportPaymentPerCity(mobileCompany.getTotalPaymentPerCity(mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword()));
    }

    private void reportPlansByExpiryDate() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Report Plans By Expiry date:");
        mobileCompany.reportPlansByExpiryDate(getExpiryDate(),mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());

    }

    private void reportUsersPerCity() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\nReport filtered Users Per city");
        mobileCompany.reportUsersPerCity(mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
    }

    private void sortUsersByMonthlyPayment() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Sort Users By Monthly Payment");
        ArrayList<User> sortedList1 = mobileCompany.sortUsers(mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        User.printUsers(sortedList1, mobileCompany.getFlatRate());
    }

    public MyDate getExpiryDate() {
        System.out.println("Please enter year of expiry date.");
        int year = getInt();
        System.out.println("Please enter month of expiry date.");
        int month = getInt();
        System.out.println("Please enter day of expiry date.");
        int day = getInt();
        return new MyDate(year, month, day);
    }

    public MobilePhone getMobilePhone() {
        System.out.println("Please enter mobile phone model.");
        String model = scanner.nextLine();
        System.out.println("Please enter mobile phone memory size.");
        int memorySize = getInt();
        System.out.println("Please enter mobile phone price.");
        double price = getDouble();
        MobileType type = choseMobileType();
        return new MobilePhone(model, type, memorySize, price);

    }

    public MobileType choseMobileType() {
        int mobileTypeNumber;
        do {
            System.out.println("1-IOS");
            System.out.println("2-WINDOWS");
            System.out.println("3-ANDROID");
            System.out.println(" Please enter the number of mobile type you want.");
            mobileTypeNumber = getInt();
        }
        while (mobileTypeNumber < 0 || mobileTypeNumber > 4);
        return MobileType.values()[mobileTypeNumber - 1];
    }

    private void press() {
        System.out.print("\nPlease press any key to continue");
        scanner.nextLine();
    }

    public static int getInt() {
        boolean success = false;
        int intNum = -1;
        while (!success) {
            try {
                intNum = scanner.nextInt();
                scanner.nextLine();
                success = true;
            } catch (InputMismatchException e) {
                System.out.println("Enter integer please :)");
                scanner.next();
            }
        }
        return intNum;
    }

    public static double getDouble() {
        boolean success = false;
        double doubleNum = -1;
        while (!success) {
            try {
                doubleNum = scanner.nextDouble();
                scanner.nextLine();
                success = true;
            } catch (InputMismatchException e) {
                System.out.println("Enter integer please :)");
                scanner.next();
            }
        }
        return doubleNum;
    }

    public static void addPlan(User user, MobilePlan plan) {
        if (user.addPlan(plan, user.getUserID(),user.getUserPassword()))
            System.out.println("The Plan has been added successfully");
        else
            System.err.println("The Plan can't be added");
    }

    public static void findAndPrintPlan(User user, int planId) {
        MobilePlan foundPlan = user.findPlan(planId, user.getUserID(), user.getUserPassword());
        if (foundPlan == null) {
            System.err.println("Plan has not been found");
        } else {
            System.out.println("Plan has been found");
            foundPlan.print();
        }
    }

    public static void printTotalPayment(User user, int flatRate) {
        double totalPaymentUserTemp = user.calcTotalPayments(flatRate);
        System.out.println("\n    Total payment of User = " + Math.round(totalPaymentUserTemp) + "$");
    }

    public static void addUser(User user, MobileCompany company) {
        if (company.addUser(user,company.getAdminUsername(), company.getAdminPassword())) {
            System.out.println("User has been added successfully");
        } else {
            System.err.println("User can't be added");
        }
    }

    public static void addUser(String name, Address address, MobileCompany company, String password) {
        if (company.addUser(name, address, password,company.getAdminUsername(), company.getAdminPassword())) {
            System.out.println("User has been added successfully.please enter any key to add user");
        } else {
            System.err.println("User can't be added");
        }
    }

    public static void addPlan(MobileCompany mobileCompany, MobilePlan plan, int userID) {
        if (mobileCompany.addPlan(userID, plan, mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword())) {
            System.out.println("Plan added successfully");
        } else {
            System.err.println("plan added failed");
        }
    }

    public static void createPersonalPlan(int userID, String username, int id, MobilePhone mobilePhone, int internetQuota, int capLimit, MyDate expiryDate, String city, MobileCompany mobileCompany) throws PlanException, PlanExceptionUserName {
        if (mobileCompany.createPersonalPlan(userID, username, id, mobilePhone, internetQuota, capLimit, expiryDate, city, mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword())) {
            System.out.println("Plan has been created successfully");
        } else {
            System.err.println("Plan can't be created successfully");
        }
    }

    public static void createBusinessPlan(int userID, String username, int id, MobilePhone mobilePhone, int internetQuota, int capLimit, MyDate expiryDate, int numberOfEmployees, int ABN, MobileCompany mobileCompany) throws PlanException, PlanExceptionUserName {
        if (mobileCompany.createBusinessPlan(userID, username, id, mobilePhone, internetQuota, capLimit, expiryDate, numberOfEmployees, ABN, mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword())) {
            System.out.println("Plan has been created successfully");
        } else {
            System.err.println("Plan can't be created successfully");
        }
    }

    public static void checkAdminLogin(String username, String password, MobileCompany mobileCompany) {
        if (mobileCompany.validateAdmin(username, password)) {
            System.out.println("Welcome to Company");
        } else {
            System.out.println("Sorry username or password is incorrect Please try again");
        }
    }

    public static void testCaseAdvance() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        MobilePhone IphoneX = new MobilePhone("Iphone X", MobileType.IOS, 10, 10);
        MobilePhone LGT65 = new MobilePhone("LG T65", MobileType.IOS, 10, 10);
        MobilePhone SamsungGalaxyS10 = new MobilePhone("Samsung Galaxy S10", MobileType.IOS, 10, 10);
        MobilePhone NokiaS78 = new MobilePhone("Nokia S78", MobileType.IOS, 10, 10);
        MobilePhone GooglePixel5 = new MobilePhone("Google Pixel 5", MobileType.IOS, 10, 10);

        MobilePlan plan1 = new TestPlan(20, 1, IphoneX);
        MobilePlan plan2 = new TestPlan(50, 2, IphoneX);
        MobilePlan plan3 = new TestPlan(30, 3, IphoneX);
        MobilePlan plan4 = new TestPlan(100, 4, LGT65);

        User user1 = new User("sara", new Address(12, "xxx", "xxx", "Wollongong"), "1234");

        user1.addPlan(plan1, user1.getUserID(), user1.getUserPassword());
        user1.addPlan(plan2, user1.getUserID(), user1.getUserPassword());
        user1.addPlan(plan3, user1.getUserID(), user1.getUserPassword());
        user1.addPlan(plan4, user1.getUserID(), user1.getUserPassword());

        MobilePlan plan5 = new TestPlan(50, 5, LGT65);
        MobilePlan plan6 = new TestPlan(10, 6, IphoneX);
        MobilePlan plan7 = new TestPlan(100, 7, LGT65);
        MobilePlan plan8 = new TestPlan(200, 8, SamsungGalaxyS10);

        User user2 = new User("John", new Address(12, "xxx", "xxx", "Wollongong"), "1234");

        user2.addPlan(plan5, user2.getUserID(), user2.getUserPassword());
        user2.addPlan(plan6, user2.getUserID(), user2.getUserPassword());
        user2.addPlan(plan7, user2.getUserID(), user2.getUserPassword());
        user2.addPlan(plan8, user2.getUserID(), user2.getUserPassword());

        MobilePlan plan9 = new TestPlan(15, 9, SamsungGalaxyS10);
        MobilePlan plan10 = new TestPlan(100, 10, LGT65);
        MobilePlan plan11 = new TestPlan(500, 11, IphoneX);
        MobilePlan plan12 = new TestPlan(40, 12, NokiaS78);

        User user3 = new User("Robert", new Address(12, "xxx", "xxx", "Sydney"), "1234");

        user3.addPlan(plan9, user3.getUserID(), user3.getUserPassword());
        user3.addPlan(plan10, user3.getUserID(), user3.getUserPassword());
        user3.addPlan(plan11, user3.getUserID(), user3.getUserPassword());
        user3.addPlan(plan12, user3.getUserID(), user3.getUserPassword());

        MobilePlan plan13 = new TestPlan(50, 13, GooglePixel5);
        MobilePlan plan14 = new TestPlan(100, 14, LGT65);

        User user4 = new User("Alex", new Address(12, "xxx", "xxx", "Melbourne"), "1234");

        user4.addPlan(plan13, user4.getUserID(), user4.getUserPassword());
        user4.addPlan(plan14, user4.getUserID(), user4.getUserPassword());


        MobileCompany company = new MobileCompany("RGR", "admin", "admin", 30);

        company.addUser(user1, company.getAdminUsername(), company.getAdminPassword());
        company.addUser(user2, company.getAdminUsername(), company.getAdminPassword());
        company.addUser(user3, company.getAdminUsername(), company.getAdminPassword());
        company.addUser(user4, company.getAdminUsername(), company.getAdminPassword());

        int[] range = {20, 50, 100, 1000};

        System.out.println("testing plan count:");
        for (User usr : company.getUsers().values()) {
            int[] planCount = usr.planCount(usr.getUserID(), usr.getUserPassword(), range, company.getFlatRate());
            System.out.println(usr.getName() + "  " + Arrays.toString(planCount));
        }

        System.out.println("\n testing plan count in mobile company:");
        int[] planCount = company.planCount(company.getAdminUsername(), company.getAdminPassword(), range);
        System.out.println(Arrays.toString(planCount));

        System.out.println("\n testing plan city count:");
        HashMap<String, int[]> planCityCount = company.planCityCount(company.getAdminUsername(), company.getAdminPassword(), range);
        for (String cty : planCityCount.keySet()) {
            System.out.println(cty + "   " + Arrays.toString(planCityCount.get(cty)));
        }

        System.out.println("\n testing user count:");
        int[] userCount = company.userCount(company.getAdminUsername(), company.getAdminPassword(), range);
        System.out.println(Arrays.toString(userCount));

       System.out.println("\n testing user mobile model count:");
        HashMap<String, int[]> userMobileModelCount = company.userMobileModelCount(company.getAdminUsername(), company.getAdminPassword(), range);
        for (String mdl : userMobileModelCount.keySet()) {
            System.out.println(mdl + "    " + Arrays.toString(userMobileModelCount.get(mdl)));
        }

        System.out.println("\n testing plan mobile model count:");
        for (User usr : company.getUsers().values()) {
            HashMap<String, int[]> planMobileModelCount = usr.planMobileModelCount(usr.getUserID(), usr.getUserPassword(), range, company.getFlatRate());
            System.out.print("\n" + usr.getName() + ":");
            for (String mdl : planMobileModelCount.keySet()) {
                System.out.print("     " + mdl + "  " + Arrays.toString(planMobileModelCount.get(mdl)));
            }
        }

        System.out.println("\n\n testing plan mobile model count in company:");
        HashMap<String, int[]> planMobileModelCount = company.planMobileModelCount(company.getAdminUsername(), company.getAdminPassword(), range);
        for (String mdl : planMobileModelCount.keySet()) {
            System.out.println(mdl + "      " + Arrays.toString(planMobileModelCount.get(mdl)));
        }
        System.out.print("\n\nIf you want to finish test:");
    }
    static class TestPlan extends MobilePlan {
        double monthlyPayment;

        public TestPlan(double payment, int id, MobilePhone handset) {
            super();
            this.monthlyPayment = payment;
            this.handset = handset;
            this.id = id;
        }

        @Override
        public double calcPayment(double flatRate) {
            return monthlyPayment;
        }
    }

    //--------------------------------- LAB 8---------------------------
    public void testCaseLambda() {
        HashMap<Integer, MobilePlan> plans = mobileCompany.allPlans();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Filter and sort capLimit < 20 by Internet Quota\n");
        plans.values().stream().filter(mobilePlan -> mobilePlan.getCapLimit() < 20).sorted(Comparator.comparing(MobilePlan::getInternetQuota)).forEach(System.out::println);

        System.out.println( "\n\n\nFilter username by (USR2) \n");
        plans.values().stream().filter(mobilePlan -> mobilePlan.getUserName().contains("USR2")).forEach(System.out::println);

        System.out.println( "\n\n\nFilter  payment for plans have (USR2)\n");
        plans.values().stream().filter(mobilePlan -> mobilePlan.getUserName().contains("USR2")).forEach(mobilePlan -> System.out.println("Payment = " + mobilePlan.calcPayment(mobileCompany.getFlatRate())));

        System.out.println("\n\n\nFind the first plan' monthly payment bigger than 200 \n" );
        String username = plans.values().stream().filter(mobilePlan -> mobilePlan.calcPayment(mobileCompany.getFlatRate()) > 200).findFirst().get().getUserName();
        System.out.println( "Username  = " + username);

        System.out.println( "\n\n\nFind all plans with the bigger more then 200, sort them by ID \n");
        plans.values().stream().filter(mobilePlan -> mobilePlan.calcPayment(mobileCompany.getFlatRate()) > 200).sorted(Comparator.comparing(MobilePlan::getId)).forEach(x -> System.out.println("Username : " + x.getUserName() + " ,ID : " + x.getId() + " ,payment: " + x.calcPayment(mobileCompany.getFlatRate())));

        System.out.println("\n\n\nCalculate all monthlyPayment for plans smaller than 200 \n" );
        System.out.println(plans.values().stream().filter(mobilePlan -> mobilePlan.calcPayment(mobileCompany.getFlatRate()) < 200).mapToDouble(x -> x.calcPayment(mobileCompany.getFlatRate())).sum());

        System.out.println( "\n\n\nfilter and print list by filter Plan method \n" );
        Predicate<MobilePlan> c1 = mobilePlan -> mobilePlan.getUserName().equals("USR999990U");
        ArrayList<MobilePlan> filterList = filterPlans(plans, c1);
        MobilePlan.printPlans(filterList);

        System.out.println( "\n\n\nfilter for a plan with year 2021\n" );
        MobilePlan.printPlans(filterPlans(plans, mobilePlan -> mobilePlan.getDateYear() == 2021));

        System.out.println("\n\n\nfilter for a plan with model Nokia\n" );
        MobilePlan.printPlans(filterPlans(plans, mobilePlan -> mobilePlan.getHandsetModel().contains("Nokia")));

        System.out.println( "\n\n\nfilter with handset type = IOS and sort list by price\n" );
        ArrayList<MobilePlan> filterPlans = filterPlans(plans, mobilePlan -> mobilePlan.getHandset().getType().equals(MobileType.IOS));
        filterPlans.stream().sorted((Comparator.comparing(MobilePlan::getHandsetPrice))).forEach(System.out::println);

        System.out.println( "\n\n\nAggregate plans by expiry Date' year\n ");
        ArrayList<MobilePlan> plans1 = MobilePlan.shallowCopy(plans);
        Map<Integer, List<MobilePlan>> plans2 = plans1.stream().collect(Collectors.groupingBy(MobilePlan::getDateYear, Collectors.toList()));
        printList(plans2);
    }

    public ArrayList<MobilePlan> filterPlans(HashMap<Integer, MobilePlan> plans, Predicate<MobilePlan> criteria) {
        return (ArrayList<MobilePlan>) plans.values().stream().filter(criteria).collect(Collectors.toList());
    }

    public void printList(Map<Integer, List<MobilePlan>> plans) {
        plans.values().forEach(mobilePlans -> MobilePlan.printPlans((ArrayList<MobilePlan>) mobilePlans));
    }


}
