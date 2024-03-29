/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cajero;

/**
 *
 * @author DaniloCastilla
 */
public class CajeroDAO {
    //HOLAAAAAAAAAAAAAAAAAAAAAAAAA
    public static boolean registrarUsuario(Cajero caj){
        Connection con = Conexion.conectar();
        try {
            
            CallableStatement cStmt = con.prepareCall("call insertarUsuarios(?,?,?,?)");
            
            cStmt.setInt(1, caj.getNumero_cuenta());
            cStmt.setString(2, caj.getTitular());
            cStmt.setShort(3, caj.getClave());
            cStmt.setInt(4, caj.getSaldo());
            
            if (cStmt.executeUpdate()>0) {
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(CajeroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean transaccion(Cajero caj){
        
        Connection con = Conexion.conectar();
        
        try {
            CallableStatement cStmt = con.prepareCall("call transaccion(?,?,?,?)");
            
            cStmt.setInt(1, caj.getNumero_cuenta());
            cStmt.setInt(2, caj.getClave());
            cStmt.setInt(3, caj.getDestinatario());
            cStmt.setInt(4, caj.getSaldo());
            
            if (cStmt.executeUpdate()>0) {
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(CajeroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static ArrayList<Cajero> listarUsuario(){
        Connection con = Conexion.conectar();
        try {
            
            CallableStatement cStmt = con.prepareCall("call listarUsuarios()");
            
            //cStmt.setInt(1, caj.getNumero_cuenta());
            //cStmt.setString(2, caj.getTitular());
            //cStmt.setInt(3, caj.getClave());
            //cStmt.setInt(4, caj.getSaldo());
            
            ResultSet resultado = cStmt.executeQuery();
            
            ArrayList<Cajero> listaUsuarios = null;
            Cajero caj;
            while (resultado.next()) {                
                
                caj = new Cajero();
                
                caj.setNumero_cuenta(resultado.getInt("numero_cuenta"));
                caj.setTitular(resultado.getString("titular"));
                caj.setClave(resultado.getShort("clave"));
                caj.setSaldo(resultado.getInt("saldo"));
                
                listaUsuarios.add(caj);
            }
            
            return listaUsuarios;
            
        } catch (SQLException ex) {
            //Logger.getLogger(CajeroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static boolean autenticar(Cajero caj){
        
        
        int total = 0;
        
         Connection con = Conexion.conectar();
        try {
            CallableStatement cStmt = con.prepareCall("call autenticar(?,?)");
            
            cStmt.setInt(1, caj.getNumero_cuenta());
            cStmt.setShort(2, caj.getClave());
            
            ResultSet resultado = cStmt.executeQuery();
            
           
            while (resultado.next()) {                

                caj.setNumero_cuenta(resultado.getInt("numero_cuenta"));
                caj.setClave(resultado.getShort("clave"));
                
                total +=1;
            }
            
            if (total != 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(CajeroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static boolean consignacionUsuario(Cajero caj){
        
        Connection con = Conexion.conectar();
        
        try {
            CallableStatement cStmt = con.prepareCall("call consignaciones(?,?)");
            
            cStmt.setInt(1, caj.getNumero_cuenta());
            cStmt.setInt(2, caj.getSaldo());
            
            if (cStmt.executeUpdate()>0) {
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(CajeroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static boolean retiros(Cajero caj){
        
        Connection con = Conexion.conectar();
        
        try {
            CallableStatement cStmt = con.prepareCall("call retiros(?,?)");
            
            cStmt.setInt(1, caj.getNumero_cuenta());
            cStmt.setInt(2, caj.getSaldo());
            
            if (cStmt.executeUpdate()>0) {
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(CajeroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}