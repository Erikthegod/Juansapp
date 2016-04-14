/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rodriguez.romero.arturo;

/**
 *
 * @author Dam
 */
public class Mensaje {

    private String emisor;
    private String mensaje;
    private String destinatario;

    public Mensaje(String emisor, String mensaje, String destinatario) {
        this.emisor = emisor;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
    }

    public String getEmisor() {
        return emisor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getDestinatario() {
        return destinatario;
    }
}
