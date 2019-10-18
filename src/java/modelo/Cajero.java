/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author DaniloCastilla
 */
public class Cajero implements Serializable{
    private int numero_cuenta;
    private String titular;
    private short clave;
    private int saldo;
    private String remitente;
    
    public Cajero(){
        this.numero_cuenta = 0;
        this.titular = "";
        this.clave = 0;
        this.saldo = 0;
        this.remitente = "";
    }

    public Cajero(int numero_cuenta, String titular, short clave, int saldo, String remitente) {
        this.numero_cuenta = numero_cuenta;
        this.titular = titular;
        this.clave = clave;
        this.saldo = saldo;
        this.remitente = remitente;
    }

    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public String getTitular() {
        return titular;
    }

    public short getClave() {
        return clave;
    }
    
    public int getSaldo(){
        return saldo;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setClave(short clave) {
        this.clave = clave;
    }
    
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }
}