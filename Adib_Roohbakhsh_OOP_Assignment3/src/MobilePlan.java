import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class MobilePlan implements Cloneable, Comparable<MobilePlan>, Serializable {

    protected String userName;
    protected int id;
    protected MobilePhone handset;
    protected int internetQuota;
    protected int capLimit;
    protected MyDate expiryDate;

    public MobilePlan(String userName, int id, MobilePhone handset, int internetQuota, int capLimit, MyDate expiryDate) throws PlanException, PlanExceptionUserName {
        if (!Pattern.matches("USR\\d\\d\\d\\d\\d\\dU", userName)) {
            throw new PlanExceptionUserName(userName);
        } else {
            this.userName = userName;
        }
        if (id < 3000000 || id > 3999999) {
            throw new PlanException(id);
        } else {
            this.id = id;
        }
        this.handset = handset;
        this.internetQuota = internetQuota;
        this.capLimit = capLimit;
        this.expiryDate = expiryDate;
    }

    protected MobilePlan() {
    }

    public int getCapLimit() {
        return capLimit;
    }

    public int getId() {
        return id;
    }

    public int getInternetQuota() {
        return internetQuota;
    }

    public MobilePhone getHandset() {
        return handset;
    }

    public MyDate getExpiryDate() {
        return expiryDate;
    }

    public String getUserName() {
        return userName;
    }

    public double getHandsetPrice(){
        return handset.getPrice();
    }

    public int getDateYear(){
        return expiryDate.getYear();
    }

    public String getHandsetModel() {
        return this.handset.getModel();
    }

    public void setCapLimit(int capLimit) {
        this.capLimit = capLimit;
    }

    public void setExpiryDate(MyDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setHandset(MobilePhone handset) {
        this.handset = handset;
    }

    public void setInternetQuota(int internetQuota) {
        this.internetQuota = internetQuota;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHandsetModel(String handsetModel) {
        handset.setModel(handsetModel);
    }

    public void print() {
        System.out.print("   Plan User Name: " + this.userName + "    ID: " + this.id + this.handset.toString() + "    " +
                "Internet Quota:" + this.internetQuota + "    Cap Limit:" + this.capLimit + "    Expiry Date:" + expiryDate.toString());
    }

    public String toString() {
        return "   Plan User Name: " + this.userName + "    ID: " + this.id + this.handset.toString() + "    Internet Quota:" +
                this.internetQuota + "    Cap Limit:" + this.capLimit + "    Expiry Date:" + expiryDate.toString();
    }

    public abstract double calcPayment(double flatRate);

    public void mobilePriceRise(double risePercent) {
        this.handset.priceRise(risePercent);
    }

//    public static void printPlans(ArrayList<MobilePlan> mobilePlans) {
//
//        for (MobilePlan mobilePlan : mobilePlans) {
//            mobilePlan.print();
//        }
//    }

    public static String toString(ArrayList<MobilePlan> mobilePlans) {
        String result = "";
        for (MobilePlan mobilePlan : mobilePlans) {
            result += mobilePlan.toString() + "\n";
        }
        return result;
    }

    public static void printPlans(ArrayList<MobilePlan> mobilePlans, double flatRate) {
        for (MobilePlan mobilePlan : mobilePlans) {
            mobilePlan.print();
            System.out.println("\t\tPayment = " + mobilePlan.calcPayment(flatRate));
        }
    }

//    public static double calcTotalPayment(ArrayList<MobilePlan> mobilePlans, int flatRate) {
//        double totalPayment = 0;
//        for (MobilePlan mobPln : mobilePlans) {
//            totalPayment += mobPln.calcPayment(flatRate);
//        }
//        return totalPayment;
//    }

//    public static void mobilePriceRiseAll(ArrayList<MobilePlan> plans, double risePercent) {
//        for (MobilePlan mobilePlan : plans) {
//            mobilePlan.mobilePriceRise(risePercent);
//        }
//    }

    public static ArrayList<MobilePlan> filterByMobileModel(ArrayList<MobilePlan> plans, String mobileModel) {
        ArrayList<MobilePlan> filteredList = new ArrayList<>();
        for (MobilePlan mobilePlan : plans) {
            if (mobilePlan.getHandsetModel().contains(mobileModel)) {
                filteredList.add(mobilePlan);
            }
        }
        return filteredList;
    }

//    public static ArrayList<MobilePlan> filterByExpiryDate(ArrayList<MobilePlan> plans, MyDate date) {
//        ArrayList<MobilePlan> filteredList = new ArrayList<>();
//        for (MobilePlan mobilePlan : plans) {
//            if (mobilePlan.expiryDate.isExpired(date)) {
//                filteredList.add(mobilePlan);
//            }
//        }
//        return filteredList;
//    }

    //  ----- LAB4 -----
    public MobilePlan(MobilePlan mobilePlan) throws CloneNotSupportedException {
        this.userName = mobilePlan.userName;
        this.id = mobilePlan.id;
        this.handset = mobilePlan.handset.clone();
        this.internetQuota = mobilePlan.internetQuota;
        this.capLimit = mobilePlan.capLimit;
        this.expiryDate = new MyDate(mobilePlan.expiryDate);
    }

    public MobilePlan clone() throws CloneNotSupportedException {
        MobilePlan mobilePlan = (MobilePlan) super.clone();
        mobilePlan.handset = handset.clone();
        mobilePlan.expiryDate = expiryDate.clone();
        return mobilePlan;
    }

//    public static ArrayList<MobilePlan> shallowCopy(ArrayList<MobilePlan> mobilePlans) {
//        ArrayList<MobilePlan> shallowCopyList = new ArrayList<>();
//        for (MobilePlan mobilePlan : mobilePlans) {
//            shallowCopyList.add(mobilePlan);
//        }
//        return shallowCopyList;
//    }

//    public static ArrayList<MobilePlan> deepCopy(ArrayList<MobilePlan> mobilePlans) throws CloneNotSupportedException {
//        ArrayList<MobilePlan> deepCopyList = new ArrayList<>();
//        for (MobilePlan mobilePlan : mobilePlans) {
//            deepCopyList.add(mobilePlan.clone());
//        }
//        return deepCopyList;
//    }

    public int compareTo(MobilePlan mobilePlan) {
        return expiryDate.compareTo(mobilePlan.expiryDate);
    }

    //  ------------------------- LAB5 -------------------------

    public static void printPlans(HashMap<Integer, MobilePlan> mobilePlans) {
        for (MobilePlan mobilePlan : mobilePlans.values()) {
            mobilePlan.print();
        }
    }

    public static String toString(HashMap<Integer, MobilePlan> mobilePlans) {
        String result = "";
        for (MobilePlan mobilePlan : mobilePlans.values()) {
            result += mobilePlan.toString() + "\n";
        }
        return result;
    }

    public static void printPlans(HashMap<Integer, MobilePlan> mobilePlans, double flatRate) {
        for (MobilePlan mobilePlan : mobilePlans.values()) {
            mobilePlan.print();
            System.out.println("\t\tPayment = " + mobilePlan.calcPayment(flatRate));
        }
    }

    public static double calcTotalPayment(HashMap<Integer, MobilePlan> mobilePlans, int flatRate) {
        double totalPayment = 0;
        for (MobilePlan mobPln : mobilePlans.values()) {
            totalPayment += mobPln.calcPayment(flatRate);
        }
        return totalPayment;
    }

    public static void mobilePriceRiseAll(HashMap<Integer, MobilePlan> mobilePlans, double risePercent) {
        for (MobilePlan mobilePlan : mobilePlans.values()) {
            mobilePlan.mobilePriceRise(risePercent);
        }
    }

    public static HashMap<Integer, MobilePlan> filterByMobileModel(HashMap<Integer, MobilePlan> mobilePlans, String mobileModel) {
        HashMap<Integer, MobilePlan> filteredList = new HashMap<>();
        for (MobilePlan mobilePlan : mobilePlans.values()) {
            if (mobilePlan.getHandsetModel().contains(mobileModel)) {
                filteredList.put(mobilePlan.id, mobilePlan);
            }
        }
        return filteredList;
    }

    public static HashMap<Integer, MobilePlan> filterByExpiryDate(HashMap<Integer, MobilePlan> mobilePlans, MyDate date) {
        HashMap<Integer, MobilePlan> filteredList = new HashMap<>();
        for (MobilePlan mobilePlan : mobilePlans.values()) {
            if (mobilePlan.expiryDate.isExpired(date)) {
                filteredList.put(mobilePlan.id, mobilePlan);
            }
        }
        return filteredList;
    }

    public static ArrayList<MobilePlan> shallowCopy(HashMap<Integer, MobilePlan> plans) {
        ArrayList<MobilePlan> shallowCopyList = new ArrayList<>();
        for (MobilePlan mobilePlan : plans.values()) {
            shallowCopyList.add(mobilePlan);
        }
        return shallowCopyList;
    }

    public static ArrayList<MobilePlan> deepCopy(HashMap<Integer, MobilePlan> plans) throws CloneNotSupportedException {
        ArrayList<MobilePlan> deepCopyList = new ArrayList<>();
        for (MobilePlan mobilePlan : plans.values()) {
            deepCopyList.add(mobilePlan.clone());
        }
        return deepCopyList;
    }

    public static HashMap<Integer, MobilePlan> shallowCopyHashMap(HashMap<Integer, MobilePlan> plans) {
        HashMap<Integer, MobilePlan> shallowCopyList = new HashMap<>();
        for (MobilePlan mobilePlan : plans.values()) {
            shallowCopyList.put(mobilePlan.id, mobilePlan);
        }
        return shallowCopyList;
    }

    public static HashMap<Integer, MobilePlan> deepCopyHashMap(HashMap<Integer, MobilePlan> plans) throws CloneNotSupportedException {
        HashMap<Integer, MobilePlan> deepCopyList = new HashMap<>();
        for (MobilePlan mobilePlan : plans.values()) {
            deepCopyList.put(mobilePlan.id, mobilePlan.clone());
        }
        return deepCopyList;
    }

    //  ------------------------- LAB6 -------------------------

    public static boolean save(HashMap<Integer, MobilePlan> plans, String fileName) throws IOException {
        ObjectOutput outputStream;
        try {
            outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
        } catch (IOException ioe) {
            System.err.println("Error in opening or creating file");
            return false;
        }
        if (outputStream != null) {
            try {
                for (MobilePlan mobilePlan : plans.values()) {
                    outputStream.writeObject(mobilePlan);
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

    public static HashMap<Integer, MobilePlan> load(String fileName) throws IOException {
        HashMap<Integer, MobilePlan> plans = new HashMap<>();
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
        } catch (IOException ioe) {
            System.err.println("Error in opening file");
        }
        try {
            while (true) {
                assert inputStream != null;
                MobilePlan mobilePlan = (MobilePlan) inputStream.readObject();
                plans.put(mobilePlan.getId(), mobilePlan);
            }
        } catch (EOFException eofe) {
            System.out.println("\n PLan load finished\n");
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
        return plans;

    }

    //  --------------- LAB6 ---------------
    public MobilePlan(String[] fields, int index) throws PlanException {
        this.userName = fields[index + 1];
        this.id = Integer.parseInt(fields[index + 2]);
        String model = fields[index + 3];
        MobileType type = MobileType.valueOf(fields[index + 4]);
        int memorySize = Integer.parseInt(fields[index + 5]);
        double price = Double.parseDouble(fields[index + 6]);
        this.handset = new MobilePhone(model, type, memorySize, price);
        this.internetQuota = Integer.parseInt(fields[index + 7]);
        this.capLimit = Integer.parseInt(fields[index + 8]);
        int year = Integer.parseInt(fields[index + 9]);
        int month = Integer.parseInt(fields[index + 10]);
        int day = Integer.parseInt(fields[index + 11]);
        this.expiryDate = new MyDate(year, month, day);

    }

    public String toDelimitedString() {
        return this.userName + "," + this.id + "," + this.handset.toDelimitedString() + "," + this.internetQuota + "," +
                this.capLimit + "," + expiryDate.toDelimitedString();
    }

    public static boolean saveTextFile(HashMap<Integer, MobilePlan> plans, String fileName) throws IOException {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            for (MobilePlan mobilePlan : plans.values()) {
                out.write(mobilePlan.toDelimitedString()+"\n");
            }
            out.close();
            return true;
        } catch (IOException ioe) {
            System.err.println("Error in save file.");
            return false;
        }
    }
    public static HashMap<Integer, MobilePlan> loadTextFile(String fileName) throws IOException, PlanException {
        HashMap<Integer, MobilePlan> plans = new HashMap<>();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line = in.readLine();
        while (line != null) {
            line = line.trim();
            String[] fields = line.split(",");
            MobilePlan mobilePlan = createMobilePlan(fields, 0 );
            plans.put(mobilePlan.id, mobilePlan);
            line = in.readLine();

        }
        in.close();
        return plans;
    }

    public static MobilePlan createMobilePlan(String[] fields, int index) throws PlanException {
        MobilePlan mobilePlan = null;
        switch (fields[index]) {
            case "BP":
                try {
                    mobilePlan = new BusinessPlan(fields, index);
                } catch (PlanException pe) {
                    fields[index + 2] = String.valueOf(pe.getNewID());
                    mobilePlan = new BusinessPlan(fields, index);
                }
                break;
                case "PP":
                try {
                    mobilePlan = new PersonalPlan(fields, index);
                } catch (PlanException pe) {
                    fields[index + 2] = String.valueOf(pe.getNewID());
                    mobilePlan = new PersonalPlan(fields, index);
                }
                break;
        }
        return mobilePlan;
    }

    // -------------------------- LAB 8 ----------------------------------
    public static void printPlans(ArrayList<MobilePlan> plans) {
        plans.forEach(MobilePlan::print);
    }
    public static double calcTotalPayment(ArrayList<MobilePlan> plans, int flatRate) {
        return plans.stream().mapToDouble(mobilePlan -> mobilePlan.calcPayment(flatRate)).sum();
    }

    public static ArrayList<MobilePlan> filteredByMobileModel(ArrayList<MobilePlan> plans, String mobileModel) {
        return (ArrayList<MobilePlan>) plans.stream().filter(x -> x.getHandsetModel().contains(mobileModel)).collect(Collectors.toList());
    }

    public static void mobilePriceRiseAll(ArrayList<MobilePlan> plans, double risePercent) {
        plans.forEach(mobilePlan -> mobilePlan.mobilePriceRise(risePercent));
    }

    public static ArrayList<MobilePlan> filterByExpiryDate(ArrayList<MobilePlan> plans, MyDate expiryDate) {
        return (ArrayList<MobilePlan>) plans.stream().filter(x -> x.expiryDate.isExpired(expiryDate)).collect(Collectors.toList());
    }

    public static ArrayList<MobilePlan> shallowCopy(ArrayList<MobilePlan> plans) {
        return (ArrayList<MobilePlan>) plans.stream().collect(Collectors.toList());
//        return (ArrayList<MobilePlan>) new ArrayList<>(plans);
    }

    public static ArrayList<MobilePlan> deepCopy(ArrayList<MobilePlan> plans) {
        Function<MobilePlan, MobilePlan> copyList = mobilePlan -> {
            try {
                mobilePlan.clone();
            } catch (CloneNotSupportedException cnse) {
                cnse.printStackTrace();
            }
            return null;
        };
        return (ArrayList<MobilePlan>) plans.stream().map(copyList).collect(Collectors.toList());
    }


}