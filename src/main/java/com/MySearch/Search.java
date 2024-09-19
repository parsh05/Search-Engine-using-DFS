package com.MySearch;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/Search")
public class Search extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Getting keyword from frontend
        String keyword = request.getParameter("keyword");
        System.out.println(keyword);
        try {
            //Setting up connection to database
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into history values (?,?);");
            preparedStatement.setString(1,keyword);
            preparedStatement.setString(2,"http://localhost:8080/SearchEngineUsingDFS/Search?keyword="+keyword);
            preparedStatement.executeUpdate();


            //Getting Result after Running Ranking Query
            String searchQuery = "select pageTitle,pageLink ,(length(lower(pageText))-length(replace(lower(pageText),'"+keyword.toLowerCase()+"','')))/length('"+keyword.toLowerCase()+"') as countoccurence from pages order by countoccurence desc limit 50;";

            ResultSet rs = connection.createStatement().executeQuery(searchQuery);
            ArrayList<SearchResult> results = new ArrayList<SearchResult>();
            //Transferring values from resultSet to results arrayList
            while (rs.next()) {
                SearchResult searchResult = new SearchResult();
                searchResult.setPageTitle(rs.getString("pageTitle"));
                searchResult.setPageLink(rs.getString("pageLink"));
                results.add(searchResult);
            }
            // displaying results arrayList in console
            for (SearchResult result : results) {
                System.out.println(result.getPageTitle()+"\n"+result.getPageLink()+"\n");

            }

            request.setAttribute("results",results);
            request.getRequestDispatcher("search.jsp").forward(request,response);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
        } catch (Exception e){
            e.printStackTrace();
        }
        //pw.println("<h3>This is the keyword you have entered "+keyword+"</h3>");
    }
}
