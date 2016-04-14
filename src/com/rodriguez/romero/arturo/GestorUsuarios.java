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
 * @author dam
 */
public class GestorUsuarios {
    private String tempUsuario;
    private String tempContrasenia;
    private Usuario user;
    ArrayList almacenDeUsuarios;
    
    public void crearUsuario(Usuario tempUser) {
        try {
            Connection c = null;//Conexión
            Statement stmt = null;//Sentencia
            String sql = null;//Cadena con la sentencia sql
            ResultSet rs = null;//Conjunto de resultados
            Class.forName("org.sqlite.JDBC");//Carga del driver
            c = DriverManager.getConnection("jdbc:sqlite:Y:/ArturoYErikApp.db");

            stmt = c.createStatement();
            sql = "insert into usuario values('" + tempUser.getNombre() + "','" + tempUser.getPass()+ "');";
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
    public ArrayList<Usuario> recibirUsuarios() {
        almacenDeUsuarios = new ArrayList();
        try {
            Connection c = null;//Conexión
            Statement stmt = null;//Sentencia
            String sql = null;//Cadena con la sentencia sql
            ResultSet rs = null;//Conjunto de resultados
            Class.forName("org.sqlite.JDBC");//Carga del driver
            c = DriverManager.getConnection("jdbc:sqlite:Y:/ArturoYErikApp.db");

            stmt = c.createStatement();
            sql = "SELECT * from usuario";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tempUsuario = rs.getString("emisor");
                tempContrasenia = rs.getString("pass");
                user = new Usuario(tempUsuario,tempContrasenia);
                almacenDeUsuarios.add(user);
            }
            c.close();
        } catch (SQLException ex) {
            System.err.println("ERROR DE SQL EXCEPTION");
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR DE CLASS NOT FOUND");
        }
        return almacenDeUsuarios;
    }
}
