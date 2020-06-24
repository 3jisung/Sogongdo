package common;

import model.Settlement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum SettlementDAO {
    INSTACE;

    public List<Settlement> getSettlements(String work_place, Date start_date, Date end_date) {
        final List<Settlement> settlements = new ArrayList<>();

        String query = "select * from db.Settlement " +
                "where `WorkPlace_has_User_WorkPlace_name` = ? and " +
                "`settlementDate` between ? and ?;";
        try (
                Connection conn = DataBase.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {
            preparedStatement.setString(1, work_place);
            preparedStatement.setDate(2, start_date);
            preparedStatement.setDate(3, end_date);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                settlements.add( new Settlement(
                        rs.getDate("settlementDate"),
                        rs.getString("WorkPlace_has_User_WorkPlace_name"),
                        rs.getString("WorkPlace_has_User_admin_id"),
                        rs.getTimestamp("settlementTime")
                        )
                );
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return settlements;
    }
}
