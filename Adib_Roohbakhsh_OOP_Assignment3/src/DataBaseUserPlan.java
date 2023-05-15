

import java.sql.*;
import java.util.HashMap;

public class DataBaseUserPlan {
    private final Connection connection;

    public DataBaseUserPlan(Connection connection) {
        this.connection = connection;
    }

    public void insertAll(HashMap<Integer, User> users, HashMap<Integer, MobilePlan> plans) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * From UserPlan");
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                User user = users.get(userId);
                int planId = resultSet.getInt("plan_id");
                MobilePlan plan = plans.get(planId);
                if (!user.addPlan(plan, userId, user.getUserPassword())) {
                    System.out.println("plan added failed");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean saveAllData(HashMap<Integer, User> users) {
        for (User user : users.values()) {
            for (MobilePlan plan : user.getPlans().values()) {
                if (!addOnePlanForOneUser(user.getUserID(), plan.getId())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void deleteAllUsersPlan() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM UserPlan");
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

    public HashMap<Integer, MobilePlan> selectPlansOfOneUser(int userID) throws PlanException, PlanExceptionUserName {
        HashMap<Integer, MobilePlan> plans = new HashMap<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("SELECT * FROM UserPlan WHERE user_id = " + userID);
            while (resultSet.next()) {
                int planId = resultSet.getInt("plan_id");
                DataBaseMobilePlan dataBaseMobilePlan = new DataBaseMobilePlan(connection);
                MobilePlan plan = dataBaseMobilePlan.selectOneElement(planId);
                plans.put(planId, plan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return plans;
    }

    public HashMap<Integer, User> selectUsersOfOnePlan(int planID) {
        HashMap<Integer, User> users = new HashMap<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM UserPlan WHERE plan_user_id = '" + planID + "'");
            while (resultSet.next()) {
                int userID = resultSet.getInt("user_id");
                DataBaseUser dataBaseUser = new DataBaseUser(connection);
                User user = dataBaseUser.selectOneUser(userID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    assert resultSet != null;
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    public boolean addOnePlanForOneUser(int userID, int planID) {
        boolean returnValue = false;
        String SQL_INSERT = "INSERT INTO " +
                "UserPlan (user_id, plan_id) " +
                "VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, planID);
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                returnValue = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean deleteOnePlanForOneUser(int userID, int planID) {
        boolean returnValue = false;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String SQL_Delete = "DELETE FROM UserPlan WHERE user_id = " + userID
                    + " AND planid = '" + planID + "'";
            int row = statement.executeUpdate(SQL_Delete);
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

    public boolean deleteOneUser(int userID) {
        boolean returnValue = false;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String SQL_DELETE = "DELETE FROM UserPlan WHERE plan_id = " + userID;
            int row = statement.executeUpdate(SQL_DELETE);
            if (row != 0) {
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
}
