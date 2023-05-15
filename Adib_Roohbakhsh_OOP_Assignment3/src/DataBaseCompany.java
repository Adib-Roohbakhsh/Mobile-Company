
import java.sql.*;
import java.util.HashMap;

public class DataBaseCompany {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DataBaseCompany(String name) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Problem in loading or registering MS Access JDBC driver");
            e.printStackTrace();
        }
        try {
            String msAccessDBName = name;
            String dbURL = "jdbc:ucanaccess://" + msAccessDBName;
            connection = DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MobileCompany loadData() {
        Statement statement = null;
        ResultSet resultSet = null;
        MobileCompany company = null;
        try {
            statement = connection.createStatement();
            // Admin
            resultSet = statement.executeQuery("SELECT * FROM company");
            while (resultSet.next()) {
                String adminUsername = resultSet.getString("username");
                String adminPassword = resultSet.getString("password");
                String companyName = resultSet.getString("name");
                int flatRate = resultSet.getInt("flat_rate");
                company = new MobileCompany(companyName, adminUsername, adminPassword, flatRate);
            }
            // Subject
            DataBaseMobilePlan dataBaseMobilePlan = new DataBaseMobilePlan(connection);
            HashMap<Integer, MobilePlan> allSubjects = dataBaseMobilePlan.selectAllPlans();
            // Student
            DataBaseUser dataBaseUser = new DataBaseUser(connection);
            HashMap<Integer, User> allStudents = dataBaseUser.selectAllElements();
            for (User user : allStudents.values()) {
                assert company != null;
                company.addUser(user, company.getAdminUsername(), company.getAdminPassword());
            }
            // StudentSubject
            DataBaseUserPlan dataBaseUserPlan = new DataBaseUserPlan(connection);
            dataBaseUserPlan.insertAll(allStudents, allSubjects);
        } catch (SQLException | PlanException | PlanExceptionUserName e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    assert resultSet != null;
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return company;
    }

    public boolean saveData(MobileCompany company) {
        String SQL_INSERT = "INSERT INTO " +
                "Company (username, password, company_name, flat_rate) " +
                "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, company.getAdminUsername());
            preparedStatement.setString(2, company.getAdminPassword());
            preparedStatement.setString(3, company.getName());
            preparedStatement.setInt(4, company.getFlatRate());
            int row = preparedStatement.executeUpdate();
            if (row != 1) {
                return false;
            }
            boolean success = new DataBaseUser(connection).insetAll(company.getUsers());
            if (!success)
                return false;
            success = new DataBaseMobilePlan(connection).insetAllPlans(company.allPlans());
            if (!success)
                return false;
            success = new DataBaseUserPlan(connection).saveAllData(company.getUsers());
            if (!success)
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void deleteAll() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Company");
            new DataBaseMobilePlan(connection).deleteAllPlans();
            new DataBaseUser(connection).deleteAllElements();
            new DataBaseUserPlan(connection).deleteAllUsersPlan();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public MobilePlan loadOnePlan(int planID) throws PlanExceptionUserName, PlanException {
        DataBaseMobilePlan dataBaseMobilePlan = new DataBaseMobilePlan(connection);
        return dataBaseMobilePlan.selectOneElement(planID);
    }

    public boolean addPlan(MobilePlan plan) {
        DataBaseMobilePlan dataBaseMobilePlan = new DataBaseMobilePlan(connection);
        return dataBaseMobilePlan.insertOneElement(plan);
    }

    public boolean deletePlan(int planID) {
        DataBaseMobilePlan dataBaseMobilePlan = new DataBaseMobilePlan(connection);
        return dataBaseMobilePlan.deleteOnePlans(planID);
    }

    public boolean updatePlan(MobilePlan plan) {
        DataBaseMobilePlan dataBaseMobilePlan = new DataBaseMobilePlan(connection);
        return dataBaseMobilePlan.updateObject(plan);
    }
    public boolean addOnePlanForOneUser(int userId,int planID) {
        DataBaseUserPlan dataBaseUserPlan = new DataBaseUserPlan(connection);
        return dataBaseUserPlan.addOnePlanForOneUser(userId,planID);
    }

    public boolean deleteOnePlanForOneStudent(int userID,int planID) {
        DataBaseUserPlan dataBaseUserPlan = new DataBaseUserPlan(connection);
        return dataBaseUserPlan.deleteOnePlanForOneUser(userID,planID);
    }

    public User loadOneUser(int userID) {
        DataBaseUser dataBaseUser = new DataBaseUser(connection);
        return dataBaseUser.selectOneUser(userID);
    }
    public HashMap<Integer,MobilePlan> loadPlansOfOneUser(int userID) throws PlanExceptionUserName, PlanException {
        DataBaseUserPlan dataBaseUserPlan = new DataBaseUserPlan(connection);
        return dataBaseUserPlan.selectPlansOfOneUser(userID);
    }

    public boolean deleteAllUserPlans(int userId) {
        DataBaseUserPlan dataBaseUserPlan = new DataBaseUserPlan(connection);
        return dataBaseUserPlan.deleteOneUser(userId);
    }
    public boolean addUser(int id, String name, String password, String city, String suburb, String street, int streetNum) {
        DataBaseUser dataBaseUser = new DataBaseUser(connection);
        return dataBaseUser.insertOneElements(id, name, password, city, suburb, street, streetNum);
    }

    public boolean deleteUser(int userID) {
        DataBaseUser dataBaseUser = new DataBaseUser(connection);
        return dataBaseUser.deleteOneElement(userID);
    }

    public boolean updateUser(int id, String name, String password, String city, String suburb, String street, int streetNum) {
        DataBaseUser dataBaseUser = new DataBaseUser(connection);
        return dataBaseUser.updateOneElement(id, name, password, city, suburb, street, streetNum);
    }


}
