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
public class cancellationBE extends HttpServlet {

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
         out.println("<title>Servlet cancellationBE</title>");

         // Adding CSS styles
         out.println("<style>");
         out.println("body { background-color: #f2f2f2; font-family: 'Arial', sans-serif; }");
         out.println("h1 { color: #333; }");
         out.println(".return-btn { background-color: #4CAF50; color: #fff; padding: 10px 20px; text-decoration: none; border-radius: 5px; transition: background-color 0.3s; }");
         out.println(".return-btn:hover { background-color: #45a049; }");
         out.println("</style>");

         out.println("</head>");
         out.println("<body>");

         String email = request.getParameter("email");
         int customerid = Integer.parseInt(request.getParameter("customerid"));
         int flightid = Integer.parseInt(request.getParameter("flightid"));
         Connection con = dbconnection.getConnectToflight_tic();

         try {
             String sql = "DELETE FROM booking WHERE email=? AND c_id=? AND f_id=?;";
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, email);
             ps.setInt(2, customerid);
             ps.setInt(3, flightid);

             int rowsAffected = ps.executeUpdate();

             if (rowsAffected > 0) {
                 out.println("<h1>Booking cancellation successful</h1>");
             } else {
                 out.println("<h1>No booking found for the specified criteria</h1>");
             }

             
             out.println("<a href='home2.html' class='return-btn'>Return to Home</a>");

         } catch (SQLException e) {
             out.println("<h1>Error occurred while canceling booking: " + e.getMessage() + "</h1>");
         } finally {
             try {
                 if (con != null) {
                     con.close();
                 }
             } catch (SQLException e) {
                 out.println("<h1>Error closing database connection: " + e.getMessage() + "</h1>");
             }
         }

         out.println("</body>");
         out.println("</html>");        }
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
            Logger.getLogger(cancellationBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cancellationBE.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cancellationBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cancellationBE.class.getName()).log(Level.SEVERE, null, ex);
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
