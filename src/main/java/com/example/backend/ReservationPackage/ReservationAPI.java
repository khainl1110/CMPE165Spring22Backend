package com.example.backend.ReservationPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet provides specific methods such as doPost, dGet, etc...
//Http servlet can generate an HTML page
@WebServlet
public class ReservationAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        String customerEmail = request.getParameter("customerEmail");

        try {
            String db = "Type into reservation(null, ?, ?)";
            //call constructor of the driver class
            Connection con = DriverManager.getConnection("url, user, password(root)");
            //Preparedstatement methods enable to send SQL commands and receice data from database
            PreparedStatement st = con.prepareStatement(db);
            st.setInt(1, roomID);
            st.setString(2,customerEmail);
        } catch(Exception e) {
            e.printStackTrace();
        }
        //request to another resource it may be html, servlet or jsp
        RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("reservation html, JSP?");
        //when customer fill the the reservation form, 
        //it will forward the request to the Comfirmation page
        rd.forward(request, response); 
    }



    
}
