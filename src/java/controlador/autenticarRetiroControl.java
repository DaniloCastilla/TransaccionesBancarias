/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.CajeroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cajero;

/**
 *
 * @author Sergio Cadena
 */

@WebServlet(name = "autenticarRetiroControl", urlPatterns = {"/autenticarRetiroControl"})
public class autenticarRetiroControl extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet autenticarRetiroControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet autenticarRetiroControl at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        //processRequest(request, response);
        String numeroCuenta = request.getParameter("numero_cuenta");
        String numeroClave = request.getParameter("numero_clave");
        String numeroSaldo = request.getParameter("numero_saldo");
        //String numeroClave = request.getParameter("numero_clave");
        
        Cajero caj1 = new Cajero();
        Cajero caj2 = new Cajero();
        
        caj1.setNumero_cuenta(Integer.parseInt(numeroCuenta));
        caj1.setClave(Short.valueOf(numeroClave));
        
        caj2.setNumero_cuenta(Integer.parseInt(numeroCuenta));
        caj2.setSaldo(Integer.parseInt(numeroSaldo));
        
        //processRequest(request, response
        
        if (CajeroDAO.autenticar(caj1) && CajeroDAO.retiros(caj2)){
            request.setAttribute("mensaje", "El retiro ha sido exitoso");
            //request.getRequestDispatcher("loginretiros.jsp").forward(request, response);
        }else{
            request.setAttribute("mensaje", " Acceso Denegado");
            //request.getRequestDispatcher("loginretiros.jsp").forward(request, response);
        }
       request.getRequestDispatcher("loginretiros.jsp").forward(request, response);
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
