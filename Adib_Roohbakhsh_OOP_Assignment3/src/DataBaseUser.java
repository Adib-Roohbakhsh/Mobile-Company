


import java.sql.*;
import java.util.HashMap;

public class DataBaseUser {
    private final Connection connection;

    public DataBaseUser(Connection connection) {
        this.connection = connection;
    }

    public HashMap<Integer, User> selectAllElements() {
        HashMap<Integer, User> allUser = new HashMap<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM User");
            while (resultSet.next()) {
                String name = resultSet.getString("user_name");
                int id = resultSet.getInt("user_id");
                String password = resultSet.getString("user_password");
                String city = resultSet.getString("address_city");
                String street = resultSet.getString("address_street");
                String suburb = resultSet.getString("address_suburb");
                int streetNum = resultSet.getInt("address_streetNum");
                User user = new User(name, new Address(streetNum, street, suburb, city),password);
                allUser.put(id, user);
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
        return allUser;
    }

    public void deleteAllElements() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM User");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public User selectOneUser(int userID) {
        User user = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM User WHERE user_id = " + userID);
            while (resultSet.next()) {
                String name = resultSet.getString("user_name");
                int id = resultSet.getInt("user_id");
                String password = resultSet.getString("user_password");
                String city = resultSet.getString("address_city");
                String street = resultSet.getString("address_street");
                String suburb = resultSet.getString("address_suburb");
                int streetNum = resultSet.getInt("address_streetNum");
                user = new User(name, new Address(streetNum, street, suburb, city),password);
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
        return user;
    }

    public boolean insertOneElements(int id, String name, String password, String city, String suburb, String street, int streetNum) {
        boolean returnValue = false;
        String SQL_INSERT = "INSERT INTO " +
                "User (user_id, user_name , user_password, address_city, address_street, address_suburb, address_streetNum) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, street);
            preparedStatement.setString(6, suburb);
            preparedStatement.setInt(7, streetNum);
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                returnValue = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean insertOneElements(User user) {
        boolean returnValue = false;
        String SQL_INSERT = "INSERT INTO " +
                "User (user_id , user_name , user_password, address_city, address_street, address_suburb, address_streetNum) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, user.getUserID());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getUserPassword());
            preparedStatement.setString(4, user.getCity());
            preparedStatement.setString(5, user.getAddress().getStreet());
            preparedStatement.setString(6, user.getAddress().getSuburb());
            preparedStatement.setInt(7, user.getAddress().getStreetNum());
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                returnValue = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean insetAll(HashMap<Integer,User> users) {
        for (User user : users.values()) {
            if (!insertOneElements(user)) {
                return false;
            }
        }
        return true;
    }

    public boolean deleteOneElement(int userID) {
        boolean returnValue = false;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String SQL_DELETE = "DELETE FROM User WHERE user_id = " + userID;
            int row = statement.executeUpdate(SQL_DELETE);
            if (row == 1) {
                returnValue = true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return returnValue;
    }

    public boolean updateOneElement(int id, String name, String password, String city, String suburb, String street, int streetNum) {
        boolean returnValue = false;
        String SQL_UPDATE = "UPDATE User SET user_name=?, user_password=?, address_city=?, address_street=?, address_suburb=?, address_streetNum=? WHERE user_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, street);
            preparedStatement.setString(5, suburb);
            preparedStatement.setInt(6, streetNum);
            preparedStatement.setInt(7, id);
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                returnValue = true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return returnValue;
    }


}
