package common;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public final class DataBase {
    private static DataSource ds;

    private DataBase() throws NamingException {
        InitialContext initialContext = new InitialContext();
        ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/db");
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
