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
public class insertFlightBE extends HttpServlet {

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
                out.println("<title>Servlet insertFlightBE</title>");
                out.println("</head>");
                out.println("<body>");

                String flightName = request.getParameter("flightName");
                String source = request.getParameter("source");
                String destination = request.getParameter("destination");
                String departureTime = request.getParameter("departureTime");
                String arrivalTime = request.getParameter("arrivalTime");
                String date = request.getParameter("date");
                int price = Integer.parseInt(request.getParameter("price"));

                Connection con = dbconnection.getConnectToflight_tic();
                String sql = "INSERT INTO flight_schedule(f_name,source,destination,dept_time,arrival_time,date_of_dept,price) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, flightName);
                ps.setString(2, source);
                ps.setString(3, destination);
                ps.setString(4, departureTime);
                ps.setString(5, arrivalTime);
                ps.setString(6, date);
                ps.setInt(7, price);

                int i = ps.executeUpdate();

                out.println("<h1>Flight Schedule Insertion</h1>");

                if (i > 0) {
                    out.println("<p class='message'>New Flight Schedule Inserted</p>");
                } else {
                    out.println("<p class='message'>Error occurred during insertion</p>");
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
            Logger.getLogger(insertFlightBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(insertFlightBE.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(insertFlightBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(insertFlightBE.class.getName()).log(Level.SEVERE, null, ex);
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
