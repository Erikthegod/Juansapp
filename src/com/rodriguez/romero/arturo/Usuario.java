/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rodriguez.romero.arturo;

/**
 *
 * @author dam
 */
public class Usuario {
    private String nombre;
    private String pass;

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }
    
}
