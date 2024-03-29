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
 * @author DaniloCastilla
 */
@WebServlet(name = "transaccionControl", urlPatterns = {"/transaccionControl"})

public class transaccionControl extends HttpServlet {

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
            out.println("<title>Servlet transaccionControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet transaccionControl at " + request.getContextPath() + "</h1>");
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
        
        String numeroCuentaOrigen = request.getParameter("cuentaO");
        String numeroClave = request.getParameter("numero_clave");    
        String numeroCuentaDestino = request.getParameter("cuentaD");
        String numeroSaldo = request.getParameter("numero_saldo");
        
        Cajero caj1 = new Cajero();
        Cajero caj2 = new Cajero();
        
        caj1.setNumero_cuenta(Integer.parseInt(numeroCuentaOrigen));
        caj1.setClave(Short.valueOf(numeroClave));
        caj1.setDestinatario(Integer.parseInt(numeroCuentaDestino));
        caj1.setSaldo(Integer.parseInt(numeroSaldo));
        
        caj2.setNumero_cuenta(Integer.parseInt(numeroCuentaOrigen));
        caj2.setClave(Short.valueOf(numeroClave));
        
        if (CajeroDAO.autenticar(caj2) && CajeroDAO.transaccion(caj1)) {
            request.setAttribute("mensaje", "La transaccion ha sido exitosa");
        }else{
            request.setAttribute("mensaje", "No se pudo realizar la transaccion. Acceso Denegado");
        }
        
        request.getRequestDispatcher("transacciones.jsp").forward(request, response);
        
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
