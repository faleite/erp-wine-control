package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(
            final String ipAddress, final int portAddress,
            final String nameBank, final String user,
            final String password) throws SQLException {

        return DriverManager.getConnection("jdbc:postgresql://" + ipAddress + ":" + portAddress + "/" + nameBank,
                user, password);
    }
}
