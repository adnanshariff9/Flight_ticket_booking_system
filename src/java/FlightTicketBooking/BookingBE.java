/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightTicketBooking;

import DBconnection.dbconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class BookingBE extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookingBE</title>");            
            out.println("</head>");
            out.println("<body>"); 
             out.println("<h1>Your ticket details are</h1>");
             
        
                                    
            String email = request.getParameter("emailID");
            String password = request.getParameter("password");
           int customerId = Integer.parseInt(request.getParameter("customerId"));
            int flightId = Integer.parseInt(request.getParameter("flightId"));
            
            
             Connection con = dbconnection.getConnectToflight_tic();
             String sql = "INSERT INTO booking( c_id,c_name,email,f_id, f_name, source, destination, dept_time, arrival_time, date_of_dept, price)"
                     + " SELECT c_id,c_name,email, f_id, f_name, source, destination, dept_time, arrival_time, date_of_dept, price"
                     + " FROM customer , flight_schedule "
                     +" WHERE email=? AND PASSWORD=? AND c_id=? AND f_id=?;";
             PreparedStatement ps = con.prepareStatement(sql);

             ps.setString(1, email);
             ps.setString(2, password);
             ps.setInt(3, customerId);
             ps.setInt(4, flightId);
             
             int rowsAffected = ps.executeUpdate(); 

                if (rowsAffected > 0) {
                    out.println("<h1>Booking successfull!</h1>");
                } else {
                     out.println("<h1>Booking Failed</h1>");
                }
       
        out.println("</body>");
        out.println("</html>");
                    }
                }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookingBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookingBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookingBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookingBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
