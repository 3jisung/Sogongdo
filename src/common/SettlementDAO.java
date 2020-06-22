package common;

import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.sql.DataSource;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SettlementDAO {
    public void test() throws UnsupportedEncodingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;  // Or PreparedStatement if needed
        ResultSet rs = null;
        String parameter1 = "0";
        String parameter2 = "20";
        String parameter3 = "";

        ServletRequest request = null;
        request.setCharacterEncoding("UTF-8");
        try {
            parameter1 = request.getParameter("asdf");
            parameter2 = request.getParameter("asdf");
            parameter3 = request.getParameter("asdf");

            String query = "SELECT * FROM Settlement";

            InitialContext initialContext = new InitialContext();
            DataSource ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/gumi");
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                rs.getString("name");
            }

            rs.close();
            rs = null;
            preparedStatement.close();
            preparedStatement = null;
            connection.close();
            connection = null;
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                rs = null;
            }
            if (preparedStatement != null) {
                try { preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
                preparedStatement = null;
            }
            if (connection != null) {
                try { connection.close(); } catch (SQLException e) { e.printStackTrace(); }
                connection = null;
            }
        }
    }

}
