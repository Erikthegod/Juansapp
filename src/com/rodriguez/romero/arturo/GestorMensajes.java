/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rodriguez.romero.arturo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dam
 */
public class GestorMensajes {

    private String tempEmisorRecibido;
    private String tempMensajeRecibido;
    private String tempDestinatarioRecibido;
    private Mensaje tempObjetoMensajeRecibido;
    private ArrayList<Mensaje> almacenDeMensajes;

    public void enviarMensaje(Mensaje tempMensaje) {
        try {
            Connection c = null;//Conexión
            Statement stmt = null;//Sentencia
            String sql = null;//Cadena con la sentencia sql
            ResultSet rs = null;//Conjunto de resultados
            Class.forName("org.sqlite.JDBC");//Carga del driver
            c = DriverManager.getConnection("jdbc:sqlite:Y:/base.db");

            stmt = c.createStatement();
            sql = "insert into mensaje values('" + tempMensaje.getEmisor() + "','" + tempMensaje.getMensaje() + "','" + tempMensaje.getDestinatario() + "');";
            stmt.executeUpdate(sql);
            c.close();

        } catch (SQLException ex) {
            System.err.println("ERROR DE SQL EXCEPTION");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR DE CLASS NOT FOUND");
            ex.printStackTrace();
        }
    }

    public ArrayList<Mensaje> recibirMensajes() {
        almacenDeMensajes = new ArrayList();
        try {
            Connection c = null;//Conexión
            Statement stmt = null;//Sentencia
            String sql = null;//Cadena con la sentencia sql
            ResultSet rs = null;//Conjunto de resultados
            Class.forName("org.sqlite.JDBC");//Carga del driver
            c = DriverManager.getConnection("jdbc:sqlite:Y:/base.db");

            stmt = c.createStatement();
            sql = "SELECT * from mensaje";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tempEmisorRecibido = rs.getString("emisor");
                tempMensajeRecibido = rs.getString("mensaje");
                tempDestinatarioRecibido = rs.getString("destinatario");
                tempObjetoMensajeRecibido = new Mensaje(tempEmisorRecibido, tempMensajeRecibido, tempDestinatarioRecibido);
                almacenDeMensajes.add(tempObjetoMensajeRecibido);
            }
            c.close();
        } catch (SQLException ex) {
            System.err.println("ERROR DE SQL EXCEPTION");
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR DE CLASS NOT FOUND");
        }
        return almacenDeMensajes;
    }
}
