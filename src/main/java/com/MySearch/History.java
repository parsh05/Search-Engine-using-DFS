package com.MySearch;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/History")
public class History {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Getting keyword from frontend
        String keyword = request.getParameter("keyword");
        // Setting up connection to database
        try {
            Connection connection = DatabaseConnection.getConnection();
            //store the query of user
            String historyQuery = "Select * from history;";
            ResultSet resultSet = connection.createStatement().executeQuery(historyQuery);
            ArrayList<HistoryResult> results = new ArrayList<>();
            while (resultSet.next()) {
                HistoryResult historyResult = new HistoryResult();
                historyResult.setKeyword(resultSet.getString("keyword"));
                historyResult.setLink(resultSet.getString("Link"));
                results.add(historyResult);
            }
            //forward this result to frontend
            request.setAttribute("resutls",results);
            request.getRequestDispatcher("history.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
