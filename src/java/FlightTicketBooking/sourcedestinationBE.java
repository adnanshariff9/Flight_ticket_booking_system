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
public class sourcedestinationBE extends HttpServlet {

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
            out.println("<title>Servlet sourcedestinationBE</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet sourcedestinationBE at " + request.getContextPath() + "</h1>");
            
            String source=request.getParameter("source");
            String destination=request.getParameter("destination");
            String date_of_dept=request.getParameter("dateofdeparture");
            
            //jdbc
             Connection con=dbconnection.getConnectToflight_tic();
             String sql="SELECT * FROM flight_schedule WHERE source=? AND destination=? AND date_of_dept=?";
             PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, source);
            ps.setString(2,destination);
            ps.setString(3,date_of_dept);
            ResultSet rs=ps.executeQuery();
             
            
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
            
            out.println("<h1>Available Flights:</h1>");
            out.println("<table border=1>");
            out.println("<tr><th>Flight ID</th><th>Airlines</th><th>Source</th><th>Destination</th><th>departure time</th><th>arrival time</th><th>date of departure</th><th>price</th></tr>");
            

            while (rs.next()) {
           out.println("<tr><td>" + rs.getInt(1) + "</td>");
           out.println("<td>" + rs.getString(2) + "</td>");
           out.println("<td>" + rs.getString(3) + "</td>");
           out.println("<td>" + rs.getString(4) + "</td>");
           out.println("<td>" + rs.getString(5) + "</td>");
           out.println("<td>" + rs.getString(6) + "</td>");
           out.println("<td>" + rs.getString(7) + "</td>");
           out.println("<td>" + rs.getInt(8) + "</td>");

           // Add "Book Ticket" button
          out.println("<td><form action='booking.html' method='post'>");
out.println("<input type='hidden' name='flightId' value='" + rs.getInt(1) + "'>");
out.println("<input type='submit' value='Book Ticket'></form></td></tr>");

       }


            out.println("</table>");
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
            Logger.getLogger(sourcedestinationBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sourcedestinationBE.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(sourcedestinationBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sourcedestinationBE.class.getName()).log(Level.SEVERE, null, ex);
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
