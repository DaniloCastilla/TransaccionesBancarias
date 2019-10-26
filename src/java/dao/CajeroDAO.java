/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public static ArrayList<Cajero> listarUsuario(){
        ArrayList<Cajero> listarUsuario = null;
        try {
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement("SELECT * FROM cajeros");
            CallableStatement cStmt = con.prepareCall("SELECT * FROM cajeros");
            
            //cStmt.setInt(1, caj.getNumero_cuenta());
            //cStmt.setString(2, caj.getTitular());
            //cStmt.setInt(3, caj.getClave());
            //cStmt.setInt(4, caj.getSaldo());
            
            ResultSet resultado = st.executeQuery();
            
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
}