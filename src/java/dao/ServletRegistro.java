/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Laura Santacruz
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cajero;


@WebServlet(name = "ServletRegistro", urlPatterns = ("/ServletRegistro"))

public class ServletRegistro extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String numeroC = request.getParameter("numero_cuenta");
        String titular = request.getParameter("titular");
        String clave = request.getParameter("clave");
        String saldo = request.getParameter("saldo");
        
        
        if(!numeroC.equalsIgnoreCase("")&& !titular.equalsIgnoreCase("")&& !saldo.equalsIgnoreCase("")
                && !clave.equalsIgnoreCase(""));{
                
                Cajero usuario = new Cajero(numeroC,titular,clave,saldo);
                boolean sw = CajeroDAO.registrarUsuario(usuario);
                
                if(sw){
                    request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                }else{
                    PrintWriter out = response.getWriter();
                    out.print("Algo salio mal");
                }
         }            
    }
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, java.io.IOException{
        processRequest(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, java.io.IOException{
        processRequest(request, response);
    }
}



