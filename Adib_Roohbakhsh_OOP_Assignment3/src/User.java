import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class User implements Cloneable, Comparable<User>, Serializable {
    private String name;
    private int userID;
    private Address address;
    private String userPassword;
    //    private ArrayList<MobilePlan> plans;
    private HashMap<Integer, MobilePlan> plans;
    private int counter;

    public User(String name, Address address, String password) {
        this.name = name;
        this.userID = provideID();
        this.address = address;
//        this.plans = new ArrayList<>();
        this.plans = new HashMap<Integer, MobilePlan>();
        this.userPassword = password;

    }

    private static int BASE_ID = 0;

    public Address getAddress() {
        return address;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public boolean validateUser(String password, int userID) {
        return userPassword.equals(password) && this.userID == userID;
    }

//    public ArrayList<MobilePlan> getPlans() {
//        return plans;
//    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getAddressCity() {
        return address.getCity();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setCity(String city) {
        this.address.setCity(city);
    }

    public String getCity() {
        return this.address.getCity();
    }

//  public boolean addPlan(MobilePlan plan) {
//        if (findPlan(plan.getId()) == null) {
//            this.plans.add(plan);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public MobilePlan findPlan(int planID) {
//        for (MobilePlan mobilePlan : this.plans) {
//            if (mobilePlan.getId() == planID)
//                return mobilePlan;
//        }
//        return null;
//    }

    public void print() {
        System.out.print("    User name : " + this.name + "    User ID : " + this.userID + "    Address: ");
        this.address.print();
        System.out.println("\n    Plans :");
        MobilePlan.printPlans(this.plans);
    }

    public void print(int flatRate) {
        System.out.print("    User name : " + this.name + "    User ID : " + this.userID + "    Address: ");
        this.address.print();
        System.out.println("\n    Plans :");
        printPlans(flatRate);
    }

    public static void printUsers(ArrayList<User> users) {
        for (User user : users) {
            System.out.println();
            user.print();
        }
    }

    public static void printUsers(ArrayList<User> users, int flatRate) {
        for (User user : users) {
            System.out.println();
            user.print(flatRate);
        }
    }

    public static void printUsersPayment(ArrayList<User> users, int flatRate) {
        for (User user : users) {
            System.out.print(user.getName() + ":");
            System.out.println(user.calcTotalPayments(flatRate));
        }
    }

    public String toString() {
        return "    User name : " + this.name + "    User ID : " + this.userID + "    Address: " + this.address.toString() + "\n    Plans :\n" + MobilePlan.toString(plans);
    }

//    public void printPlans(int flatRate) {
//        MobilePlan.printPlans(this.plans, flatRate);
//    }

    public double calcTotalPayments(int flatRate) {
        return MobilePlan.calcTotalPayment(this.plans, flatRate);
    }

    public void mobilePriceRiseAll(double risePercent) {
        MobilePlan.mobilePriceRiseAll(this.plans, risePercent / 100);
    }

//    public ArrayList<MobilePlan> filterByMobileModel(String mobileModel) {
//        return MobilePlan.filterByMobileModel(this.plans, mobileModel);
//    }

    public boolean createPersonalPlan(String username, int id, MobilePhone mobilePhone, int internetQuota, int capLimit, MyDate expiryDate, String city, int userID, String userPassword) throws PlanException, PlanExceptionUserName {
        return addPlan(new PersonalPlan(username, id, mobilePhone, internetQuota, capLimit, city, expiryDate), userID, userPassword);
    }

    public boolean createBusinessPlan(String username, int id, MobilePhone mobilePhone, int internetQuota, int capLimit, MyDate expiryDate, int numberOfEmployees, int ABN, int userID, String userPassword) throws PlanException, PlanExceptionUserName {
        return addPlan(new BusinessPlan(username, id, mobilePhone, internetQuota, capLimit, numberOfEmployees, ABN, expiryDate), userID, userPassword);
    }

    //    public ArrayList<MobilePlan> filterByExpiryDate(MyDate date) {
//        return MobilePlan.filterByExpiryDate(plans, date);
//    }
//
//    public ArrayList<String> populateDistinctMobileModels() {
//        ArrayList<String> mobileModels = new ArrayList<String>();
//        for (MobilePlan mobilePlan : plans) {
//            boolean found = false;
//            for (String mobileModel : mobileModels) {
//                if (mobilePlan.getHandsetModel().equals(mobileModel)) {
//                    found = true;
//                    break;
//                }
//            }
//            if (!found)
//                mobileModels.add(mobilePlan.getHandsetModel());
//        }
//        return mobileModels;
//    }
//
//    public int getTotalCountForMobileModel(String mobileModel) {
//        int totalCount = 0;
//        for (MobilePlan mobilePlan : plans) {
//            if (mobilePlan.getHandsetModel().equals(mobileModel))
//                totalCount++;
//        }
//        return totalCount;
//    }
//
//    public double getTotalPaymentForMobileModel(String mobileModel, double flatRate) {
//        double totalPayment = 0;
//        for (MobilePlan mobilePlan : plans) {
//            if (mobilePlan.getHandsetModel().equals(mobileModel))
//                totalPayment += mobilePlan.calcPayment(flatRate);
//        }
//        return Math.round(totalPayment);
//    }
//
//    public ArrayList<Integer> getTotalCountPerMobileModel(ArrayList<String> mobileModels) {
//        ArrayList<Integer> totalBalances = new ArrayList<Integer>();
//        for (String mobileModel : mobileModels) {
//            totalBalances.add(getTotalCountForMobileModel(mobileModel));
//        }
//        return totalBalances;
//    }
//
//    public ArrayList<Double> getTotalPaymentPerMobileModel(ArrayList<String> mobileModels, double flatRate) {
//        ArrayList<Double> totalBalances = new ArrayList<Double>();
//        for (String mobileModel : mobileModels) {
//            totalBalances.add(getTotalPaymentForMobileModel(mobileModel, flatRate));
//        }
//        return totalBalances;
//    }
//
    public void reportPaymentsPerMobileModel(ArrayList<String> mobileModels, ArrayList<Integer> counts, ArrayList<Double> monthlyPayments) {
        System.out.println("\n\tMobile model \t \t Total Monthly Payment \t \t Average Monthly Payment \n");
        for (int i = 0; i < mobileModels.size(); i++)
            System.out.println("\t" + mobileModels.get(i) + "\t \t \t \t $" + monthlyPayments.get(i) + "\t \t \t \t $" + Math.round(monthlyPayments.get(i) / counts.get(i)));
    }

    private static int provideID() {
        BASE_ID++;
        return BASE_ID;
    }

    //  ----- LAB4 -----
//    public User(User user) throws CloneNotSupportedException {
//        this.name = user.name;
//        this.userPassword = user.userPassword;
//        this.userID = user.userID;
//        this.address = user.address.clone();
//        ArrayList<MobilePlan> copyPlanList = new ArrayList<MobilePlan>();
//        for (MobilePlan mobilePlan : plans) {
//            if (mobilePlan instanceof PersonalPlan) {
//                copyPlanList.add(new PersonalPlan((PersonalPlan) mobilePlan));
//            }
//            if (mobilePlan instanceof BusinessPlan) {
//                copyPlanList.add(new BusinessPlan((BusinessPlan) mobilePlan));
//            }
//        }
//        this.plans = copyPlanList;
//    }
//
//    public User clone() throws CloneNotSupportedException {
//        User user = (User) super.clone();
//        user.plans = MobilePlan.deepCopy(plans);
//        user.address = address.clone();
//        return user;
//    }

//    public static ArrayList<User> shallowCopy(ArrayList<User> users) {
//        ArrayList<User> shallowCopyList = new ArrayList<>();
//        for (User user : users) {
//            shallowCopyList.add(user);
//        }
//        return shallowCopyList;
//    }

//    public static ArrayList<User> deepCopy(ArrayList<User> users) throws CloneNotSupportedException {
//        ArrayList<User> deepCopyList = new ArrayList<>();
//        for (User user : users) {
//            deepCopyList.add(user.clone());
//        }
//        return deepCopyList;
//    }

    public ArrayList<MobilePlan> shallowCopyPlans() {
        return MobilePlan.shallowCopy(plans);
    }

    public ArrayList<MobilePlan> deepCopyPlans() throws CloneNotSupportedException {
        return MobilePlan.deepCopy(plans);
    }

    public int compareTo1(User user) {
        int flatRate = 5;
        double otherTotalPayment = user.calcTotalPayments(flatRate);
        double thisTotalPayment = calcTotalPayments(flatRate);
        if (otherTotalPayment == thisTotalPayment) {
            return 0;
        }
        return thisTotalPayment > otherTotalPayment ? 1 : -1;
    }

    public int compareTo(User user) {
        return address.compareTo(user.address);
    }

//    public ArrayList<MobilePlan> sortPlansByDate() {
//        Collections.sort(plans);
//        return plans;
//    }

    //  ------------------------- LAB5 -------------------------

    public HashMap<Integer, MobilePlan> getPlans() {
        return plans;
    }

    public boolean addPlan(MobilePlan plan, int userID, String userPassword) {
        if (validateUser(userPassword, userID)) {
            if (findPlan(plan.getId(), userID, userPassword) == null) {
                this.plans.put(plan.id, plan);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public MobilePlan findPlan(int planID, int userID, String userPassword) {
        if (validateUser(userPassword, userID)) {
            return plans.get(planID);
        }
        return null;
    }

    public HashMap<Integer, MobilePlan> filterByMobileModel(String mobileModel) {
        return MobilePlan.filterByMobileModel(this.plans, mobileModel);
    }

    public HashMap<Integer, MobilePlan> filterByExpiryDate(MyDate date) {
        return MobilePlan.filterByExpiryDate(plans, date);
    }

    public static void printUsers(HashMap<Integer, User> users) {
        for (User user : users.values()) {
            user.print();
        }
    }

    public static void printUsers(HashMap<Integer, User> users, int flatRate) {
        for (User user : users.values()) {
            user.print(flatRate);
        }
    }

    public User(User user) throws CloneNotSupportedException {
        this.name = user.name;
        this.userPassword = user.userPassword;
        this.userID = user.userID;
        this.address = user.address.clone();
        HashMap<Integer, MobilePlan> copyPlanList = new HashMap<>();
        for (MobilePlan mobilePlan : plans.values()) {
            if (mobilePlan instanceof PersonalPlan) {
                copyPlanList.put(mobilePlan.id, new PersonalPlan((PersonalPlan) mobilePlan));
            }
            if (mobilePlan instanceof BusinessPlan) {
                copyPlanList.put(mobilePlan.id, new BusinessPlan((BusinessPlan) mobilePlan));
            }
        }
        this.plans = copyPlanList;
    }

    public static ArrayList<User> shallowCopy(HashMap<Integer, User> users) {
        ArrayList<User> shallowCopyList = new ArrayList<>();
        for (User user : users.values()) {
            shallowCopyList.add(user);
        }
        return shallowCopyList;
    }

    public static ArrayList<User> deepCopy(HashMap<Integer, User> users) throws CloneNotSupportedException {
        ArrayList<User> deepCopyList = new ArrayList<>();
        for (User user : users.values()) {
            deepCopyList.add(user.clone());
        }
        return deepCopyList;
    }

    public static HashMap<Integer, User> shallowCopyHashMap(HashMap<Integer, User> users) {
        HashMap<Integer, User> shallowCopyList = new HashMap<>();
        for (User user : users.values()) {
            shallowCopyList.put(user.userID, user);
        }
        return shallowCopyList;
    }

    public static HashMap<Integer, User> deepCopyHashMap(HashMap<Integer, User> users) throws CloneNotSupportedException {
        HashMap<Integer, User> deepCopyList = new HashMap<>();
        for (User user : users.values()) {
            deepCopyList.put(user.userID, user.clone());
        }
        return deepCopyList;
    }

    public User clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.plans = MobilePlan.deepCopyHashMap(plans);
        user.address = address.clone();
        return user;
    }

    public ArrayList<MobilePlan> sortPlansByDate() {
        ArrayList<MobilePlan> sortList = MobilePlan.shallowCopy(plans);
        Collections.sort(sortList);
        return sortList;
    }

    public HashMap<String, Integer> getTotalCountPerMobileModel(int userID, String userPassword) {
        if (validateUser(userPassword, userID)) {
            HashMap<String, Integer> counts = new HashMap<String, Integer>();
            for (MobilePlan mobilePlan : plans.values()) {
                Integer count = counts.get(mobilePlan.getHandsetModel());
                if (count != null) {
                    counts.put(mobilePlan.getHandsetModel(), count + 1);
                } else {
                    counts.put(mobilePlan.getHandsetModel(), 1);
                }
            }
            return counts;
        }
        return null;
    }

    public HashMap<String, Double> getTotalPaymentPerMobileModel(double flatRate, int userID, String userPassword) {
        if (validateUser(userPassword, userID)) {
            HashMap<String, Double> totalPayment = new HashMap<String, Double>();
            for (MobilePlan mobilePlan : plans.values()) {
                Double payment = totalPayment.get(mobilePlan.getHandsetModel());
                if (payment != null) {
                    totalPayment.put(mobilePlan.getHandsetModel(), payment + mobilePlan.calcPayment(flatRate));
                } else {
                    totalPayment.put(mobilePlan.getHandsetModel(), mobilePlan.calcPayment(flatRate));
                }
            }
            return totalPayment;
        }
        return null;
    }

    public void reportPaymentsPerMobileModel(HashMap<String, Integer> counts, HashMap<String, Double> monthlyPayments) {
        System.out.println("\n\tMobile model \t \t Total Monthly Payment \t \t Average Monthly Payment \n");
        for (String mobileModel : monthlyPayments.keySet())
            System.out.println("\t" + mobileModel + "\t \t \t \t $" + monthlyPayments.get(mobileModel) + "\t \t \t \t $" + Math.round(monthlyPayments.get(mobileModel) / counts.get(mobileModel)));
    }

    //  ------------------------- LAB6 -------------------------

    public static boolean save(HashMap<Integer, User> users, String fileName) throws IOException {
        ObjectOutput outputStream = null;
        try {
            outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
        } catch (IOException ioe) {
            System.err.println("Error in opening or creating file");
            return false;
        }
        if (outputStream != null) {
            try {
                for (User user : users.values()) {
                    outputStream.writeObject(user);
                }
                outputStream.close();
            } catch (IOException ioe) {
                System.err.println(" Can't adding file");
                return false;
            }
            return true;
        }
        return false;
    }

    public static HashMap<Integer, User> load(String fileName) throws IOException {
        HashMap<Integer, User> users = new HashMap<>();
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
        } catch (IOException ioe) {
            System.err.println("Error in opening file");
        }
        try {
            while (true) {
                User user = (User) inputStream.readObject();
                users.put(user.getUserID(), user);
            }
        } catch (EOFException eofe) {
            System.out.println(" \nUser load finished\n");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Class not found in file.");
        } catch (IOException ioe) {
            System.err.println(" can't add object to file");
        }
        try {
            if (inputStream != null)
                inputStream.close();
        } catch (IOException ioe) {
            System.err.println(" Can't close file");
        }
        return users;

    }

    public String toDelimitedString() {
        String plansString = "";
        if (plans.size() != 0) {
            for (MobilePlan mobilePlan : plans.values()) {
                plansString += ",";
                plansString += mobilePlan.toDelimitedString();
            }
        }
        return this.name + "," + this.userID + "," + this.address.toDelimitedString() + "," + userPassword + "," + plans.size() + plansString;

    }

    public static boolean saveTextFile(HashMap<Integer, User> users, String fileName) throws IOException {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            for (User user : users.values()) {
                out.write(user.toDelimitedString() + "\n");
            }
            out.close();
            return true;
        } catch (IOException ioe) {
            System.err.println("Error in save file.");
            return false;
        }
    }

    public static HashMap<Integer, User> loadTextFile(String fileName) throws IOException, PlanException {
        HashMap<Integer, User> users = new HashMap<>();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line = in.readLine();
        while (line != null) {
            line = line.trim();
            String[] fields = line.split(",");
            User user = createUser(fields, 0);
            users.put(user.userID, user);
            line = in.readLine();
        }
        in.close();
        return users;
    }

    public User(String[] fields, int index) throws PlanException {
        int counter = 0;
        this.name = fields[index];
        this.userID = Integer.parseInt(fields[index + 1]);
        int streetNum = Integer.parseInt(fields[index + 2]);
        String street = fields[index + 3];
        String suburb = fields[index + 4];
        String city = fields[index + 5];
        this.address = new Address(streetNum, street, suburb, city);
        this.userPassword = fields[index + 6];
        HashMap<Integer, MobilePlan> plans = new HashMap<>();
        for (int i = 0; i < Integer.parseInt(fields[index + 7]); i++) {
            MobilePlan mobilePlan = MobilePlan.createMobilePlan(fields, index + 8 + counter);
            if (mobilePlan instanceof BusinessPlan) {
                counter += 14;
            } else {
                counter += 13;
            }
            plans.put(mobilePlan.id, mobilePlan);
        }
        this.counter = counter;
        this.plans = plans;
    }

    public static User createUser(String[] fields, int index) throws PlanException {
        return new User(fields, index);
    }

    public int getCounter() {
        return counter;
    }

    // ____________________________ Assignment 2 ______________________________
    public int countInRange(double lower, double higher, int flatRate) {
        int count = 0;
        for (MobilePlan mobilePlan : plans.values()) {
            if ((mobilePlan.calcPayment(flatRate) > lower) && (mobilePlan.calcPayment(flatRate) <= higher))
                count++;
        }
        return count;
    }

    public int[] planCount(int userID, String password, int[] ranges, int flatRate) {
        if (validateUser(password, userID)) {
            int[] planCount = new int[ranges.length];
            planCount[0] = countInRange(0, ranges[0], flatRate);
            for (int i = 0; i < ranges.length - 1; i++) {
                planCount[i + 1] = countInRange(ranges[i], ranges[i + 1], flatRate);
            }
            return planCount;
        }
        return null;
    }

    public HashMap<String, int[]> planMobileModelCount(int userID, String password, int[] ranges, int flatRate) {
        if (validateUser(password, userID)) {
            HashMap<String, int[]> planForMobileModelCount = new HashMap<>();
            int[] planModelCount;
            for (MobilePlan mobilePlan : plans.values()) {
                String mobileModel = mobilePlan.getHandsetModel();
                double payment = mobilePlan.calcPayment(flatRate);
                planModelCount = planForMobileModelCount.get(mobileModel);
                double temp;
                if (planModelCount == null) {
                    planModelCount = new int[ranges.length];
                    planForMobileModelCount.put(mobileModel, planModelCount);
                    temp = payment;
                } else {
                    temp = mobilePlan.calcPayment(flatRate);
                }
                for (int i = 0; i < ranges.length; i++) {
                    if (temp <= ranges[i]) {
                        planModelCount[i]++;
                        planForMobileModelCount.put(mobileModel, planModelCount);
                        break;
                    }
                }
            }
            return planForMobileModelCount;
        }
        return null;
    }

    // -------------------------- LAB 8 ----------------------------------
    public void printPlans(int flatRate) {
        plans.values().forEach(mobilePlan -> System.out.println(mobilePlan + "Monthly Payment = " + mobilePlan.calcPayment(flatRate)));
    }

    public static ArrayList<User> shallowCopy(ArrayList<User> users) {
        return (ArrayList<User>) users.stream().collect(Collectors.toList());
//        return (ArrayList<User>) new ArrayList<>(users);

    }

    public ArrayList<User> deepCopy(ArrayList<User> users) {
        Function<User, User> copyList = x -> {
            try {
                x.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        };
        return (ArrayList<User>) users.stream().map(copyList).collect(Collectors.toList());
    }

}


