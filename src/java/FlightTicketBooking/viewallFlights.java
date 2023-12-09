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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class viewallFlights extends HttpServlet {

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
            out.println("<title>Servlet viewallFlights</title>");            
            out.println("</head>");
            out.println("<body>");
          
            Connection con=dbconnection.getConnectToflight_tic();
             String sql = "SELECT * FROM flight_schedule";
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             
             
             
             
              out.println("<style>");
        out.println("table {");
        out.println("    width: 100%;");
        out.println("    border-collapse: collapse;");
        out.println("    margin: 20px 0;");
        out.println("}");
        out.println("th, td {");
        out.println("    padding: 10px;");
        out.println("    text-align: left;");
        out.println("    border: 1px solid #ddd;");
        out.println("}");
        out.println("th {");
        out.println("    background-color: #4CAF50;");
        out.println("    color: white;");
        out.println("}");
        out.println("tr:hover {");
        out.println("    background-color: #f5f5f5;");
        out.println("}");
        out.println("</style>");
        out.println("<h1>View all Flights:</h1>");
        // Add your table HTML code
        out.println("<table>");
        out.println("<tr><th>Flight id</th></th><th>Airlines</th><th>Source</th><th>Destination</th><th>Departure time</th><th>arrival time</th><th>date of departure</th><th>price</th></tr>");
        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getInt(1) + "</td>");
            out.println("<td>" + rs.getString(2) + "</td>");
            out.println("<td>" + rs.getString(3) + "</td>");
            out.println("<td>" + rs.getString(4) + "</td>");
            out.println("<td>" + rs.getString(5) + "</td>");
            out.println("<td>" + rs.getString(6) + "</td>");
            out.println("<td>" + rs.getString(7) + "</td>");
            out.println("<td>" + rs.getInt(8) + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");

        // Add your CSS styles for the return button
        out.println("<style>");
        out.println(".return-button {");
        out.println("    background-color: green;");
        out.println("    color: white;");
        out.println("    padding: 10px 20px;");
        out.println("    text-align: center;");
        out.println("    text-decoration: none;");
        out.println("    display: inline-block;");
        out.println("    font-size: 16px;");
        out.println("    cursor: pointer;");
        out.println("}");
        out.println(".return-button:hover {");
        out.println("    background-color: darkgreen;");
        out.println("}");
        out.println("</style>");

        // Add your return button HTML code
        out.println("<a href=\"adminhome.html\" class=\"return-button\">Return</a>");

       
            
            con.close();
             
            
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
            Logger.getLogger(viewallFlights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewallFlights.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(viewallFlights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewallFlights.class.getName()).log(Level.SEVERE, null, ex);
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
