package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SettlementControl")
public class SettlementControl extends HttpServlet {
    public void createSettlement(HttpServletRequest req, HttpServletResponse resp) {
        // 시설별 정산 등록

        DoSomthingOnSettelment();
    }

    public void readAllSettlements(HttpServletRequest req, HttpServletResponse resp) {
        // 시설별 정산 조회
    }

    public void readSettlement(HttpServletRequest req, HttpServletResponse resp) {
        // 특정일의 정산 내역 조회
    }

    public void updateSettlement(HttpServletRequest req, HttpServletResponse resp) {
        // 시설별 정산 수정

        DoSomthingOnSettelment();
    }

    public void deleteSettlement(HttpServletRequest req, HttpServletResponse resp) {
        // 시설별 정산 삭제

        DoSomthingOnSettelment();
    }




    private void DoSomthingOnSettelment() {
    }
}
