package common;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public final class DataBase {
    private static DataSource ds;

    private DataBase() {
    }

    public static Connection getConnection() throws SQLException, NamingException {
        if (ds == null) {
            InitialContext initialContext = new InitialContext();
            ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/db");
        }

        return ds.getConnection();
    }
}
