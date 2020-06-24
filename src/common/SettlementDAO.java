package common;

import model.Settlement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum SettlementDAO {
    INSTACE;
    // enum을 이용한 싱글톤으로 만들었다.

    // 일정 범위 내 모든 정산 내역을 질의함
    public List<Settlement> getSettlements(String work_place, Date start_date, Date end_date) {
        // 결과가 들어갈 리스트
        final List<Settlement> settlements = new ArrayList<>();

        // 쿼리문. 파라메터는 ? 사용
        String query = "select * from db.Settlement " +
                "where `WorkPlace_has_User_WorkPlace_name` = ? and " +
                "`settlementDate` between ? and ?;";
        try (
                // try 블럭 안에 connection과 statement 생성
                Connection conn = DataBase.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
        ) {
            // ? 한곳에 파라메터 넣어줌
            preparedStatement.setString(1, work_place);
            preparedStatement.setDate(2, start_date);
            preparedStatement.setDate(3, end_date);

            // 쿼리 수행
            try (ResultSet rs = preparedStatement.executeQuery()) {
                // 결과값 적절히 불러와서 객체 생성
                while (rs.next()) {
                    settlements.add(new Settlement(
                                    rs.getDate("settlementDate"),
                                    rs.getString("WorkPlace_has_User_WorkPlace_name"),
                                    rs.getString("WorkPlace_has_User_admin_id"),
                                    rs.getTimestamp("settlementTime")
                            )
                    );
                }
            }

            // try 문 종료될때 close()가 필요한 항목들 자동 close() 수행됨 (connection은 DBCP에 반환)
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
        }

        return settlements;
    }
}
