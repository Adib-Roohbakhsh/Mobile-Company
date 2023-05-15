import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MobileCompany implements Cloneable, Serializable {
    private String name;
    private String adminUsername;
    private String adminPassword;
    private int flatRate;
    //    private ArrayList<User> users;
    private HashMap<Integer, User> users;

    public MobileCompany(String name, String adminUsername, String adminPassword, int flatRate) {
        this.name = name;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.flatRate = flatRate;
//        this.users = new ArrayList<>();
        this.users = new HashMap<Integer, User>();
    }

    public MobileCompany() {
    }

//    public ArrayList<User> getUsers() {
//        return users;
//    }

    public String getName() {
        return name;
    }

    public int getFlatRate() {
        return flatRate;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlatRate(int flatRate) {
        this.flatRate = flatRate;
    }

    public boolean validateAdmin(String username, String password) {
        return adminUsername.equals(username) && adminPassword.equals(password);
    }

    public boolean changePassword(String newPassword, String oldPassword) {
        if (newPassword.equals(adminPassword) && !newPassword.equals(oldPassword)) {
            adminPassword = oldPassword;
            return true;
        }
        return false;
    }

    //        public boolean addUser(User user) {
//        if (findUser(user.getUserID()) == null) {
//            users.add(user);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
    public boolean addUser(String name, Address address, String password, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            User user = new User(name, address, password);
            return addUser(user, adminUsername, adminPassword);
        }
        return false;
    }

    //
//    public User findUser(int userID) {
//        for (User user : users) {
//            if (user.getUserID() == userID)
//                return user;
//        }
//        return null;
//    }
//
    public boolean addPlan(int userID, MobilePlan plan, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            User user = findUser(userID, adminUsername, adminPassword);
            if (user != null) {
                return user.addPlan(plan, userID, user.getUserPassword());
            }
            return false;
        }
        return false;
    }

    public MobilePlan findPlan(int userID, int planID, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            User user = findUser(userID, adminUsername, adminPassword);
            if (user != null) {
                return user.findPlan(planID, userID, user.getUserPassword());
            }
            return null;
        }
        return null;
    }

    public void printPlans(int userID, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            User user = findUser(userID, adminUsername, adminPassword);
            if (user != null) {
                user.printPlans(flatRate);
            }
            System.err.println("Sorry User with user Id :" + userID + " is not available.");
        }
    }

//    public void print() {
//        System.out.println("Company name: " + name + "Flat rate: " + flatRate);
//        for (User user : users) {
//            user.print(flatRate);
//        }
//    }
//
//    public String toString() {
//        String string = "Company name: " + name + "Flat rate: " + flatRate + "\n";
//        for (User user : users) {
//            string += user.toString() + "\n";
//        }
//        return string;
//    }

    public boolean createPersonalPlan(int userID, String username, int id, MobilePhone mobilePhone, int internetQuota, int capLimit, MyDate expiryDate, String city, String adminUsername, String adminPassword) throws PlanException, PlanExceptionUserName {
        if (validateAdmin(adminUsername, adminPassword)) {
            User user = findUser(userID, adminUsername, adminPassword);
            if (user != null) {
                return user.createPersonalPlan(username, id, mobilePhone, internetQuota, capLimit, expiryDate, city, userID, user.getUserPassword());
            }
            return false;
        }
        return false;
    }

    public boolean createBusinessPlan(int userID, String username, int id, MobilePhone mobilePhone, int internetQuota, int capLimit, MyDate expiryDate, int numberOfEmployees, int ABN, String adminUsername, String adminPassword) throws PlanException, PlanExceptionUserName {
        User user = findUser(userID, adminUsername, adminPassword);
        if (user != null) {
            return user.createBusinessPlan(username, id, mobilePhone, internetQuota, capLimit, expiryDate, numberOfEmployees, ABN, userID, user.getUserPassword());
        }
        return false;
    }

    public double calcTotalPayments(int userID, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            User user = findUser(userID, adminUsername, adminPassword);
            if (user != null) {
                return user.calcTotalPayments(flatRate);
            }
            return 0;
        }
        return 0;
    }

//    public double calcTotalPayments() {
//        double totalPayment = 0;
//        for (User user : users) {
//            totalPayment += user.calcTotalPayments(flatRate);
//        }
//        return totalPayment;
//    }

    public boolean mobilePriceRise(int userID, double risePercent, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            User user = findUser(userID, adminUsername, adminPassword);
            if (user != null) {
                user.mobilePriceRiseAll(risePercent);
                return true;
            }
            return false;
        }
        return false;
    }

//    public void mobilePriceRise(double risePercent) {
//        for (User user : users) {
//            user.mobilePriceRiseAll(risePercent);
//        }
//    }
//
//    public ArrayList<MobilePlan> allPlans() {
//        ArrayList<MobilePlan> allPlans = new ArrayList<>();
//        for (User user : users) {
//            for (MobilePlan mobilePlan : user.getPlans()) {
//                allPlans.add(mobilePlan);
//            }
//        }
//        return allPlans;
//    }
//
//    public ArrayList<MobilePlan> filterByMobileModel(int userID, String mobileModel) {
//        User user = findUser(userID);
//        if (user != null) {
//            return user.filterByMobileModel(mobileModel);
//        }
//        return new ArrayList<MobilePlan>();
//    }
//
//    public ArrayList<MobilePlan> filterByExpiryDate(int userID, MyDate date) {
//        User user = findUser(userID);
//        if (user != null) {
//            return user.filterByExpiryDate(date);
//        }
//        return new ArrayList<MobilePlan>();
//    }
//
//    public ArrayList<MobilePlan> filterByMobileModel(String mobileModel) {
//        ArrayList<MobilePlan> filteredList = new ArrayList<>();
//        for (User user : users) {
//            ArrayList<MobilePlan> userPlans = user.filterByMobileModel(mobileModel);
//            for (MobilePlan mobilePlan : userPlans)
//                filteredList.add(mobilePlan);
//        }
//        return filteredList;
//    }
//
//    public ArrayList<MobilePlan> filterByExpiryDate(MyDate date) {
//        ArrayList<MobilePlan> filteredList = new ArrayList<>();
//        for (User user : users) {
//            ArrayList<MobilePlan> userPlans = user.filterByExpiryDate(date);
//            for (MobilePlan mobilePlan : userPlans)
//                filteredList.add(mobilePlan);
//        }
//        return filteredList;
//    }
//
//    public double getTotalPaymentForCity(String city) {
//        double totalPayment = 0;
//        for (User user : users) {
//            if (user.getAddressCity().equals(city))
//                totalPayment += user.calcTotalPayments(flatRate);
//        }
//        return Math.round(totalPayment);
//    }
//
    public ArrayList<String> populateDistinctCityNames() {
        ArrayList<String> cities = new ArrayList<String>();
        for (User user : users.values()) {
            boolean found = false;
            for (String city : cities) {
                if (user.getAddressCity().equals(city)) {
                    found = true;
                    break;
                }
            }
            if (!found)
                cities.add(user.getAddressCity());
        }
        return cities;
    }
//
//    public ArrayList<Double> getTotalPaymentPerCity(ArrayList<String> cities) {
//        ArrayList<Double> totalBalances = new ArrayList<Double>();
//        for (String city : cities) {
//            totalBalances.add(getTotalPaymentForCity(city));
//        }
//        return totalBalances;
//    }
//
//    public void reportPaymentPerCity(ArrayList<String> cities, ArrayList<Double> payments) {
//        System.out.println("\n\tCity Name \t \t Total Monthly Payment \n");
//        for (int i = 0; i < cities.size(); i++)
//            System.out.println("\t" + cities.get(i) + "\t \t \t \t $" + payments.get(i));
//    }
//
//    public ArrayList<String> populateDistinctMobileModels() {
//        ArrayList<String> mobileModels = new ArrayList<>();
//        for (User user : users) {
//            for (String mobileModel : user.populateDistinctMobileModels()) {
//                if (!findModel(mobileModels, mobileModel)) {
//                    mobileModels.add(mobileModel);
//                }
//            }
//        }
//        return mobileModels;
//    }

    public boolean findModel(ArrayList<String> mobileModels, String mobileModel) {
        if (mobileModels != null) {
            for (String string : mobileModels) {
                if (string.equalsIgnoreCase(mobileModel)) {
                    return true;
                }
            }
        }
        return false;
    }

//    public ArrayList<Integer> getTotalCountPerMobileModel(ArrayList<String> mobileModels) {
//        ArrayList<Integer> counts = new ArrayList<Integer>();
//        for (User user : users) {
//            for (Integer count : user.getTotalCountPerMobileModel(mobileModels)) {
//                counts.add(count);
//            }
//        }
//        return counts;
//    }
//
//    public ArrayList<Double> getTotalPaymentPerMobileModel(ArrayList<String> mobileModels) {
//        ArrayList<Double> payments = new ArrayList<Double>();
//        for (User user : users) {
//            for (Double payment : user.getTotalPaymentPerMobileModel(mobileModels, flatRate))
//                payments.add(payment);
//        }
//        return payments;
//    }

    public void reportPaymentsPerMobileModel(ArrayList<String> mobileModels, ArrayList<Integer> counts, ArrayList<Double> monthlyPayments) {

        System.out.println("\n\tMobile Model \t \t Total Monthly Payment \t \t Average Monthly Payment \n");
        for (int i = 0; i < mobileModels.size(); i++)
            System.out.println("\t" + mobileModels.get(i) + "\t \t \t \t $" + monthlyPayments.get(i) + "\t \t \t \t $" + Math.round(monthlyPayments.get(i) / counts.get(i)));
    }

    //  ----- LAB4 -----
//    public MobileCompany(MobileCompany mobileCompany) {
//        this.name = mobileCompany.name;
//        this.adminPassword = mobileCompany.adminPassword;
//        this.adminUsername = mobileCompany.adminUsername;
//        this.flatRate = mobileCompany.flatRate;
//        ArrayList<User> copyUserList = new ArrayList<User>();
//        for (User user : users) {
//            copyUserList.add(new User(user));
//        }
//        this.users = copyUserList;
//    }
//
//    public MobileCompany clone() throws CloneNotSupportedException {
//        MobileCompany mobileCompany = (MobileCompany) super.clone();
//        mobileCompany.users = User.deepCopy(users);
//        return mobileCompany;
//    }
//
//    public ArrayList<User> deepCopyUsers() throws CloneNotSupportedException {
//        return User.deepCopy(users);
//    }
//
//    public ArrayList<User> shallowCopyUsers() throws CloneNotSupportedException {
//        return User.shallowCopy(users);
//    }
//
//    public ArrayList<User> sortUsers() {
//        Collections.sort(users);
//        return users;
//    }

    //  ------------------------- LAB5 -------------------------

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public boolean addUser(User user, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            if (findUser(user.getUserID(), adminUsername, adminPassword) == null) {
                users.put(user.getUserID(), user);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public User findUser(int userID, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            return users.get(userID);
        }
        return null;
    }

    public void print() {
        System.out.println("Company name: " + name + "  Flat rate: " + flatRate);
        for (User user : users.values()) {
            user.print(flatRate);
        }
    }

    public String toString() {
        String string = "Company name: " + name + "  Flat rate: " + flatRate + "\n";
        for (User user : users.values()) {
            string += user.toString() + "\n";
        }
        return string;
    }

//    public double calcTotalPayments() {
//        double totalPayment = 0;
//        for (User user : users.values()) {
//            totalPayment += user.calcTotalPayments(flatRate);
//        }
//        return totalPayment;
//    }

//    public void mobilePriceRise(double risePercent) {
//        for (User user : users.values()) {
//            user.mobilePriceRiseAll(risePercent);
//        }
//    }

    public HashMap<Integer, MobilePlan> allPlans() {
        HashMap<Integer, MobilePlan> allPlans = new HashMap<>();
        for (User user : users.values()) {
            for (MobilePlan mobilePlan : user.getPlans().values()) {
                allPlans.put(mobilePlan.id, mobilePlan);
            }
        }
        return allPlans;
    }

    public HashMap<Integer, MobilePlan> filterByMobileModel(int userID, String mobileModel, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            User user = findUser(userID, adminUsername, adminPassword);
            if (user != null) {
                return user.filterByMobileModel(mobileModel);
            }
            return new HashMap<Integer, MobilePlan>();
        }
        return null;
    }

    public HashMap<Integer, MobilePlan> filterByExpiryDate(int userID, MyDate date, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            User user = findUser(userID, adminUsername, adminPassword);
            if (user != null) {
                return user.filterByExpiryDate(date);
            }
            return new HashMap<Integer, MobilePlan>();
        }
        return null;
    }

    public HashMap<Integer, MobilePlan> filterByMobileModel(String mobileModel, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            HashMap<Integer, MobilePlan> filteredList = new HashMap<>();
            for (User user : users.values()) {
                HashMap<Integer, MobilePlan> userPlans = user.filterByMobileModel(mobileModel);
                for (MobilePlan mobilePlan : userPlans.values())
                    filteredList.put(mobilePlan.id, mobilePlan);
            }
            return filteredList;
        }
        return null;
    }

    public HashMap<Integer, MobilePlan> filterByExpiryDate(MyDate date, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            HashMap<Integer, MobilePlan> filteredList = new HashMap<>();
            for (User user : users.values()) {
                HashMap<Integer, MobilePlan> userPlans = user.filterByExpiryDate(date);
                for (MobilePlan mobilePlan : userPlans.values())
                    filteredList.put(mobilePlan.id, mobilePlan);
            }
            return filteredList;
        }
        return null;
    }

    public HashMap<Integer, User> deepCopyUsersHashMap() throws CloneNotSupportedException {
        return User.deepCopyHashMap(users);
    }

    public HashMap<Integer, User> shallowCopyUsersHashMap() {
        return User.shallowCopyHashMap(users);
    }

    public ArrayList<User> sortUsers(String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            ArrayList<User> sortList = User.shallowCopy(users);
            Collections.sort(sortList);
            return sortList;
        }
        return null;
    }

    public MobileCompany clone() throws CloneNotSupportedException {
        MobileCompany mobileCompany = (MobileCompany) super.clone();
        mobileCompany.users = User.deepCopyHashMap(users);
        return mobileCompany;
    }

    public HashMap<String, Double> getTotalPaymentPerCity(String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            HashMap<String, Double> totalPaymentsPerCity = new HashMap<>();
            for (User user : users.values()) {
                Double totalPayment = totalPaymentsPerCity.get(user.getAddressCity());
                Double userTotalPayment = user.calcTotalPayments(flatRate);
                if (totalPayment != null) {
                    totalPaymentsPerCity.put(user.getAddressCity(), totalPayment + userTotalPayment);
                } else {
                    totalPaymentsPerCity.put(user.getAddressCity(), userTotalPayment);
                }
            }
            return totalPaymentsPerCity;
        }
        return null;
    }

    public void reportPaymentPerCity(HashMap<String, Double> payments) {
        System.out.println("\n\tCity Name \t \t Total Monthly Payment \n");
        for (String city : payments.keySet())
            System.out.println("\t" + city + "\t \t \t \t $" + payments.get(city));
    }

    public HashMap<String, Integer> getTotalCountPerMobileModel(String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            HashMap<String, Integer> counts = new HashMap<String, Integer>();
            for (User user : users.values()) {
                HashMap<String, Integer> userCount = user.getTotalCountPerMobileModel(user.getUserID(), user.getUserPassword());
                for (String string : userCount.keySet()) {
                    counts.put(string, userCount.get(string));
                }
            }
            return counts;
        }
        return null;
    }

    public HashMap<String, Double> getTotalPaymentPerMobileModel(double flatRate, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            HashMap<String, Double> totalPayment = new HashMap<String, Double>();
            for (User user : users.values()) {
                HashMap<String, Double> userPayment = user.getTotalPaymentPerMobileModel(flatRate, user.getUserID(), user.getUserPassword());
                for (String string : userPayment.keySet()) {
                    totalPayment.put(string, userPayment.get(string));
                }
            }
            return totalPayment;
        }
        return null;
    }

    public void reportPaymentsPerMobileModel(HashMap<String, Integer> counts, HashMap<String, Double> monthlyPayments) {
        System.out.println("\n\tMobile model \t \t Total Monthly Payment \t \t Average Monthly Payment \n");
        for (String mobileModel : monthlyPayments.keySet())
            System.out.println("\t" + mobileModel + "\t \t \t \t $" + monthlyPayments.get(mobileModel) + "\t \t \t \t $" +
                    Math.round(monthlyPayments.get(mobileModel) / counts.get(mobileModel)));
    }

    //  ------------------------- LAB6 -------------------------

    public boolean save(String fileName) throws IOException {
        ObjectOutput outputStream = null;
        try {
            outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
        } catch (IOException ioe) {
            System.err.println("Error in opening or creating file");
        }
        if (outputStream != null) {
            try {
                outputStream.writeObject(this);
                outputStream.close();
            } catch (IOException ioe) {
                System.err.println(" Can't adding file");
            }
            return true;
        }
        return false;
    }

    public boolean load(String fileName) throws IOException {
        ObjectInputStream inputStream;
        MobileCompany mobileCompany;
        try {
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
        } catch (IOException ioe) {
            System.err.println("Error in opening file");
            return false;
        }
        try {
            mobileCompany = (MobileCompany) inputStream.readObject();
        } catch (EOFException eofe) {
            System.out.println("\nCompany load finished\n");
            return false;
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Class not found in file.");
            return false;
        } catch (IOException ioe) {
            System.err.println(" can't add object to file");
            return false;
        }
        try {
            if (inputStream != null)
                inputStream.close();
        } catch (IOException ioe) {
            System.err.println(" Can't close file");
            return false;
        }
        this.name = mobileCompany.name;
        this.adminUsername = mobileCompany.adminUsername;
        this.adminPassword = mobileCompany.adminPassword;
        this.flatRate = mobileCompany.flatRate;
        this.users = mobileCompany.users;
        return true;

    }

    public String toDelimitedString() {
        String usersString = "";
        for (User user : users.values()) {
            usersString += ",";
            usersString += user.toDelimitedString();
        }
        return this.name + "," + this.adminUsername + "," + this.adminPassword + "," + this.flatRate + "," + users.size() + usersString;

    }

    public boolean saveTextFile(String fileName) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(this.toDelimitedString());
            out.close();
            return true;
        } catch (IOException ioe) {
            System.err.println("Error in save file.");
            return false;
        }
    }

    public boolean loadTextFile(String fileName) throws IOException, PlanException {
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String line = in.readLine();
            line = line.trim();
            String[] fields = line.split(",");
            this.name = fields[0];
            this.adminUsername = fields[1];
            this.adminPassword = fields[2];
            this.flatRate = Integer.parseInt(fields[3]);
            HashMap<Integer, User> users = new HashMap<>();
            int counter = 0;
            for (int i = 0; i < Integer.parseInt(fields[4]); i++) {
                User user = User.createUser(fields, 5 + counter);
                counter += user.getCounter() + 8;
                users.put(user.getUserID(), user);
            }
            this.users = users;
            in.close();
        } catch (IOException ioe) {
            System.err.println("Error in load file.");
            return false;
        }
        return true;
    }
// ____________________________ Assignment 2 ______________________________

    class Compare implements Comparator<User> {
        @Override
        public int compare(User user1, User user2) {
            return Double.compare(user1.calcTotalPayments(flatRate), user2.calcTotalPayments(flatRate));
        }
    }

    public ArrayList<User> sortUsersByMonthlyPayment(String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            ArrayList<User> sortUser = User.shallowCopy(users);
            Collections.sort(sortUser, new Compare());
            return sortUser;
        }
        return null;
    }

//    public HashMap<String, ArrayList<User>> getUsersPerCity() {
//        HashMap<String, ArrayList<User>> userPerCity = new HashMap<>();
//        HashMap<String, Double> cityList = getTotalPaymentPerCity();
//        for (String city : cityList.keySet()) {
//            ArrayList<User> tempUsers = new ArrayList<>();
//            for(User user : users.values()){
//                if (user.getAddressCity().equals(city)){
//                     tempUsers.add(user);
//                }
//            }
//            userPerCity.put(city, tempUsers);
//        }
//        return userPerCity;
//    }

    public HashMap<String, ArrayList<User>> getUsersPerCity(String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            HashMap<String, ArrayList<User>> userPerCity = new HashMap<>();
            for (User user : users.values()) {
                ArrayList<User> tempUsers = new ArrayList<>();
                String city = user.getAddressCity();
                if (userPerCity.get(city) != null) {
                    tempUsers = userPerCity.get(city);
                }
                tempUsers.add(user);
                userPerCity.put(city, tempUsers);
            }
            return userPerCity;
        }
        return null;
    }

    public void reportUsersPerCity(String adminUsername, String adminPassword) {
        HashMap<String, ArrayList<User>> usersPerCity = getUsersPerCity(adminUsername, adminPassword);
        for (String city : usersPerCity.keySet()) {
            System.out.println(city + ":");
            User.printUsers(usersPerCity.get(city));
            System.out.println("\n");
        }
    }

    public HashMap<String, ArrayList<MobilePlan>> filterPlansByExpiryDate(MyDate expiryDate, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            HashMap<String, ArrayList<MobilePlan>> filteredPlansByExpiryDate = new HashMap<>();
            for (User user : users.values()) {
                ArrayList<MobilePlan> plans = MobilePlan.shallowCopy(filterByExpiryDate(user.getUserID(), expiryDate, adminUsername, adminPassword));
                filteredPlansByExpiryDate.put(user.getName(), plans);
            }
            return filteredPlansByExpiryDate;
        }
        return null;
    }

    public void reportPlansByExpiryDate(MyDate expiryDate, String adminUsername, String adminPassword) {
        HashMap<String, ArrayList<MobilePlan>> plansByExpiryDat = filterPlansByExpiryDate(expiryDate, adminUsername, adminPassword);
        for (String userName : plansByExpiryDat.keySet()) {
            System.out.println(userName + ":");
            MobilePlan.printPlans(plansByExpiryDat.get(userName));
            System.out.println("\n");
        }
    }

    public User validateUser(int userID, String password, String adminUsername, String adminPassword) {
        if (validateAdmin(adminUsername, adminPassword)) {
            User user = findUser(userID, adminUsername, adminPassword);
            if (user.validateUser(password, userID)) {
                System.out.println("\n You Log in successful!");
                return user;
            } else {
                System.out.println("Wrong password or user id");
                return null;
            }
        }
        return null;
    }

    public int[] planCount(String adminUsername, String adminPassword, int[] ranges) {
        if (validateAdmin(adminUsername, adminPassword)) {
            int[] planCount = new int[ranges.length];
            for (User user : users.values()) {
                int[] planUserCount = user.planCount(user.getUserID(), user.getUserPassword(), ranges, flatRate);
                for (int i = 0; i < planUserCount.length; i++) {
                    planCount[i] += planUserCount[i];
                }
            }
            return planCount;
        }
        return null;
    }

    public int countInRange(double lower, double higher) {
        int count = 0;
        for (User user : users.values()) {
            if ((user.calcTotalPayments(flatRate) > lower) && (user.calcTotalPayments(flatRate) <= higher))
                count++;
        }
        return count;
    }

    public HashMap<String, int[]> planCityCount(String adminUsername, String adminPassword, int[] ranges) {
        if (validateAdmin(adminUsername, adminPassword)) {
            HashMap<String, int[]> planForCityCount = new HashMap<>();
            for (User user : users.values()) {
                int[] planCount = user.planCount(user.getUserID(), user.getUserPassword(), ranges, flatRate);
                String city = user.getAddressCity();
                int[] planCityCount = planForCityCount.get(city);
                if (planCityCount != null) {
                    for (int i = 0; i < planCount.length; i++) {
                        planCount[i] += planCityCount[i];
                    }
                }
                planForCityCount.put(city, planCount);
            }
            return planForCityCount;
        }
        return null;
    }

    public int[] userCount(String adminUsername, String adminPassword, int[] ranges) {
        if (validateAdmin(adminUsername, adminPassword)) {
            int[] userCount = new int[ranges.length];
            for (User user : users.values()) {
                int[] planCount = user.planCount(user.getUserID(), user.getUserPassword(), ranges, flatRate);
                for (int i = 0; i < ranges.length; i++) {
                    if (planCount[i] != 0) {
                        userCount[i]++;
                    }
                }
            }
            return userCount;
        }
        return null;
    }

    public HashMap<String, int[]> userMobileModelCount(String adminUsername, String adminPassword, int[] ranges) {
        if (validateAdmin(adminUsername, adminPassword)) {
        HashMap<String, int[]> userMobileModelCount = new HashMap<>();
        int[] mobileModelArray;
        for (User user : users.values()) {
            HashMap<String, int[]> userCount = user.planMobileModelCount(user.getUserID(), user.getUserPassword(), ranges, flatRate);
            for (String mobileModel : userCount.keySet()) {
                mobileModelArray = userCount.get(mobileModel);
                int[] userCountArray = userMobileModelCount.get(mobileModel);
                if (userCountArray == null) {
                    userCountArray = new int[ranges.length];
                }
                for (int i = 0; i < ranges.length; i++) {
                    if (mobileModelArray[i] != 0) {
                        userCountArray[i] ++;
                        userMobileModelCount.put(mobileModel, userCountArray);
                    }
                }
            }
        }
        return userMobileModelCount;
        }
        return null;
    }

    public HashMap<String, int[]> planMobileModelCount(String adminUsername, String adminPassword, int[] ranges) {
        if (validateAdmin(adminUsername, adminPassword)) {
            HashMap<String, int[]> planMobileModelCount = new HashMap<>();
            for (User user : users.values()) {
                HashMap<String, int[]> planUserCount = user.planMobileModelCount(user.getUserID(), user.getUserPassword(), ranges, flatRate);
                for (String mobileModel : planUserCount.keySet()) {
                    int[] planModelUserCount = planUserCount.get(mobileModel);
                    int[] planModelUserCount2 = planMobileModelCount.get(mobileModel);
                    if (planModelUserCount2 == null) {
                        planMobileModelCount.put(mobileModel, planModelUserCount);
                    } else {
                        for (int i = 0; i < ranges.length; i++) {
                            planModelUserCount2[i] += planModelUserCount[i];
                        }
                        planMobileModelCount.put(mobileModel, planModelUserCount2);
                    }
                }
            }
            return planMobileModelCount;
        }
        return null;
    }

    // -------------------------- LAB 8 ----------------------------------
    public double calcTotalPayments(){
        return users.values().stream().mapToDouble( user -> user.calcTotalPayments(flatRate)).sum();
    }

    public void mobilePriceRise(double risePercent){
        users.values().forEach(user -> user.mobilePriceRiseAll(risePercent));
    }

    public ArrayList<MobilePlan> filterByMobileModel(String mobileModel){
        return (ArrayList<MobilePlan>) allPlans().values().stream().filter(mobilePlan->mobilePlan.getHandsetModel().contains(mobileModel)).collect(Collectors.toList());
    }

    public HashMap<String, Double>  getTotalPaymentPerCity(){
        return (HashMap<String, Double>) users.values().stream().collect(Collectors.groupingBy(User::getCity,Collectors.summingDouble(user -> user.calcTotalPayments(flatRate))));
    }

    //________________________ Assignment 3 _______________________
    public HashMap<String, Integer> getTotalCountPerMobileModelLambda() {
        return (HashMap<String, Integer>) allPlans().values().stream()
                .collect(Collectors.groupingBy(MobilePlan::getHandsetModel, Collectors.summingInt(plan -> 1)));
    }

    public HashMap<String, Double> getTotalPaymentPerMobileModelLambda() {
        return (HashMap<String, Double>) allPlans().values().stream()
                .collect(Collectors.groupingBy(MobilePlan::getHandsetModel, Collectors.summingDouble(plan -> plan.calcPayment(flatRate))));
    }
}
