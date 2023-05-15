
import com.sun.deploy.security.ValidationState;

import java.sql.*;
import java.util.HashMap;

public class DataBaseMobilePlan {
    private final Connection connection;

    public DataBaseMobilePlan(Connection connection) {
        this.connection = connection;
    }

    public HashMap<Integer, MobilePlan> selectAllPlans() throws PlanException, PlanExceptionUserName {
        HashMap<Integer, MobilePlan> allPlans = new HashMap<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * from Plan");
            while (resultSet.next()) {
                String username = resultSet.getString("plan_username");
                int id = resultSet.getInt("plan_id");
                String model = resultSet.getString("handset_model");
                String type = resultSet.getString("handset_type");
                double price = resultSet.getDouble("handset_price");
                int memorySize = resultSet.getInt("handset_memorySize");
                int internetQuota = resultSet.getInt("plan_internetQuota");
                int capLimit = resultSet.getInt("capLimit");
                int month = resultSet.getInt("date_day");
                int day = resultSet.getInt("date_month");
                int year = resultSet.getInt("date_year");
                String planType = resultSet.getString("plan_type");
                MobilePlan plan;
                if (planType.equals("businessPlan")) {
                    int ABN = resultSet.getInt("plan_ABN");
                    int noOfEmployee = resultSet.getInt("plan_numberOfEmployee");
                    plan = new BusinessPlan(username, id, new MobilePhone(model, MobileType.valueOf(type), memorySize, price), internetQuota, capLimit, ABN, noOfEmployee, new MyDate(year, month, day));
                } else {
                    String city = resultSet.getString("plan_city");
                    plan = new PersonalPlan(username, id, new MobilePhone(model, MobileType.valueOf(type), memorySize, price), internetQuota, capLimit, city, new MyDate(year, month, day));
                }
                allPlans.put(id, plan);
            }
        } catch (SQLException e) {
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
        return allPlans;
    }

    public void deleteAllPlans() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Plan");
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

    public MobilePlan selectOneElement(int planID) throws PlanExceptionUserName, PlanException {
        MobilePlan plan = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Plan WHERE plan_id = '" + planID + "'");
            while (resultSet.next()) {
                String username = resultSet.getString("plan_username");
                int id = resultSet.getInt("plan_id");
                String model = resultSet.getString("handset_model");
                String type = resultSet.getString("handset_type");
                double price = resultSet.getDouble("handset_price");
                int memorySize = resultSet.getInt("handset_memorySize");
                int internetQuota = resultSet.getInt("plan_internetQuota");
                int capLimit = resultSet.getInt("capLimit");
                int day = resultSet.getInt("date_day");
                int month = resultSet.getInt("date_month");
                int year = resultSet.getInt("date_year");
                String planType = resultSet.getString("plan_type");
                if (planType.equals("businessPlan")) {
                    int ABN = resultSet.getInt("plan_ABN");
                    int noOfEmployee = resultSet.getInt("plan_numberOfEmployee");
                    plan = new BusinessPlan(username, id, new MobilePhone(model, MobileType.valueOf(type), memorySize, price), internetQuota, capLimit, ABN, noOfEmployee, new MyDate(year, month, day));
                } else {
                    String city = resultSet.getString("plan_city");
                    plan = new PersonalPlan(username, id, new MobilePhone(model, MobileType.valueOf(type), memorySize, price), internetQuota, capLimit, city, new MyDate(year, month, day));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    assert resultSet != null;
                    resultSet.close();
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return plan;
    }

    public boolean insertOneElement(MobilePlan plan) {
        boolean returnValue = false;
        String SQL_INSERT = "INSERT INTO " +
                "Plan (plan_id, plan_username , handset_model, handset_type, handset_price, handset_memorySize, plan_internetQuota, capLimit, date_day, date_month, date_year, plan_type, plan_ABN, plan_numberOfEmployee, plan_city) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, plan.getId());
            preparedStatement.setString(2, plan.getUserName());
            preparedStatement.setString(3, plan.getHandsetModel());
            preparedStatement.setString(4, plan.getHandset().getType() + "");
            preparedStatement.setDouble(5, plan.getHandsetPrice());
            preparedStatement.setInt(6, plan.getHandset().getMemorySize());
            preparedStatement.setInt(7, plan.getInternetQuota());
            preparedStatement.setInt(8, plan.getCapLimit());
            preparedStatement.setInt(9, plan.getExpiryDate().getDay());
            preparedStatement.setInt(10, plan.getExpiryDate().getMonth());
            preparedStatement.setInt(11, plan.getExpiryDate().getYear());
            if (plan instanceof BusinessPlan) {
                preparedStatement.setString(12, "BusinessPlan");
                preparedStatement.setInt(13, ((BusinessPlan) plan).getABN());
                preparedStatement.setInt(14, ((BusinessPlan) plan).getNumberOfEmployees());
                preparedStatement.setString(15, "-");
            } else {
                preparedStatement.setString(12, "PersonalPlan");
                preparedStatement.setInt(13, -1);
                preparedStatement.setInt(14, -1);
                preparedStatement.setString(15, ((PersonalPlan) plan).getCity());
            }
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                returnValue = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean insetAllPlans(HashMap<Integer, MobilePlan> plans) {
        for (MobilePlan plan : plans.values()) {
            if (!insertOneElement(plan)) {
                return false;
            }
        }
        return true;
    }

    public boolean deleteOnePlans(int planID) {
        boolean returnValue = false;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String SQL_DELETE = "DELETE FROM Plan WHERE plan_id = '" + planID + "'";
            int row = statement.executeUpdate(SQL_DELETE);
            if (row == 1) {
                returnValue = true;
            }
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
        return returnValue;
    }

    public boolean updateObject(MobilePlan plan) {
        boolean returnValue = false;
        String SQL_INSERT = "UPDATE Plan SET plan_username = ?, handset_model = ?, handset_type = ?, handset_price = ?, handset_memorySize = ?, plan_internetQuota = ?, capLimit = ?, date_day = ?, date_month = ?, date_year = ?, plan_type = ?, plan_ABN = ?, plan_numberOfEmployee = ?, plan_city = ? WHERE plan_id = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, plan.getUserName());
            preparedStatement.setInt(15, plan.getId());
            preparedStatement.setString(2, plan.getHandsetModel());
            preparedStatement.setString(3, plan.getHandset().getType() + "");
            preparedStatement.setDouble(4, plan.getHandsetPrice());
            preparedStatement.setInt(5, plan.getHandset().getMemorySize());
            preparedStatement.setInt(6, plan.getInternetQuota());
            preparedStatement.setInt(7, plan.getCapLimit());
            preparedStatement.setInt(8, plan.getExpiryDate().getDay());
            preparedStatement.setInt(9, plan.getExpiryDate().getMonth());
            preparedStatement.setInt(10, plan.getExpiryDate().getYear());
            if (plan instanceof PersonalPlan) {
                preparedStatement.setString(11, "PersonalPlan");
                preparedStatement.setInt(12, -1);
                preparedStatement.setInt(13, -1);
                preparedStatement.setString(14, ((PersonalPlan) plan).getCity());
            } else {
                preparedStatement.setString(11, "BusinessPlan");
                preparedStatement.setInt(12, ((BusinessPlan) plan).getABN());
                preparedStatement.setInt(13, ((BusinessPlan) plan).getNumberOfEmployees());
                preparedStatement.setString(14, "-");
            }
            int update = preparedStatement.executeUpdate();
            if (update == 1) {
                returnValue = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
