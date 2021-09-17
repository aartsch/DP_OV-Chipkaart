package P4;

import P4.DAO.OVChipkaartDAOPsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static Connection connection;

    public static void main(String[] args) throws SQLException {
       OVChipkaartDAOPsql OVChipSql = new OVChipkaartDAOPsql(getConnection());
       closeConnection();


    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost/ovchip?user=postgres&password=password";

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


    private static void closeConnection() throws SQLException {
        connection.close();
    }

}
