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
public class updateFlight extends HttpServlet {

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
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<style>");
            out.println("body { background-color: #f5f5f5; font-family: 'Arial', sans-serif; text-align: center; padding: 20px; }");
            out.println("h1 { color: #333; }");
            out.println(".message { font-size: 18px; margin-bottom: 20px; }");
            out.println(".return-btn { background-color: #4CAF50; color: #fff; padding: 10px 20px; text-decoration: none; border-radius: 5px; transition: background-color 0.3s; }");
            out.println(".return-btn:hover { background-color: #45a049; }");
            out.println("</style>");
            out.println("<title>Servlet updateFlight</title>");
            out.println("</head>");
            out.println("<body>");

            int flightId = Integer.parseInt(request.getParameter("flightId"));
            String newFlightName = request.getParameter("newFlightName");
            String newSource = request.getParameter("newSource");
            String newDestination = request.getParameter("newDestination");
            String newDepartureTime = request.getParameter("newDepartureTime");
            String newArrivalTime = request.getParameter("newArrivalTime");
            String newDate = request.getParameter("newDate");
            int newPrice = Integer.parseInt(request.getParameter("newPrice"));

            Connection con = dbconnection.getConnectToflight_tic();
            String sql = "UPDATE flight_schedule " +
                    "SET f_name = ?, source = ?, destination = ?, dept_time = ?, arrival_time = ?, date_of_dept = ?, price = ? " +
                    "WHERE f_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newFlightName);
            ps.setString(2, newSource);
            ps.setString(3, newDestination);
            ps.setString(4, newDepartureTime);
            ps.setString(5, newArrivalTime);
            ps.setString(6, newDate);
            ps.setInt(7, newPrice);
            ps.setInt(8, flightId);

            int i = ps.executeUpdate();

            out.println("<h1>Flight Schedule Update</h1>");

            if (i > 0) {
                out.println("<p class='message'>Flight Schedule Updated!</p>");
            } else {
                out.println("<p class='message'>Flight Schedule Not Updated!</p>");
            }

            con.close();

            // Adding "Return" button
            out.println("<a href='adminhome.html' class='return-btn'>Return</a>");

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
            Logger.getLogger(updateFlight.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateFlight.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(updateFlight.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateFlight.class.getName()).log(Level.SEVERE, null, ex);
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
