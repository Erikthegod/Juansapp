/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rodriguez.romero.arturo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author Dam
 */
public class JpPanel extends javax.swing.JPanel {

    Mensaje nuevoMensaje;
    String tempEmisor;
    String tempMensaje;
    String tempDestinatario;
    GestorMensajes gm = new GestorMensajes();

    /**
     * Creates new form Panel
     */
    public JpPanel() {
        initComponents();
        Timer reloj = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarMensajes();
            }
        });
        reloj.start();
    }

    public void leerInterfaz() {
        tempEmisor = jtfNombreEmisor.getText();
        tempMensaje = jtfMensaje.getText();
        tempDestinatario = jtfNombreDestinatario.getText();
        nuevoMensaje = new Mensaje(tempEmisor, tempMensaje, tempDestinatario);
        gm.enviarMensaje(nuevoMensaje);
    }

    public void cargarMensajes() {
        jtaMensajeLog.append("");
        for (Mensaje mensaje : gm.recibirMensajes()) {
            if (jtfNombreEmisor.getText().equals(mensaje.getDestinatario()) || jtfNombreEmisor.getText().equals(mensaje.getEmisor())) {
                jtaMensajeLog.append(mensaje.getEmisor());
                jtaMensajeLog.append("--->");
                jtaMensajeLog.append(mensaje.getMensaje());
                jtaMensajeLog.append("\n");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfNombreEmisor = new javax.swing.JTextField();
        jlbNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaMensajeLog = new javax.swing.JTextArea();
        jtfMensaje = new javax.swing.JTextField();
        jbEnviar = new javax.swing.JButton();
        jbRefrescar = new javax.swing.JButton();
        jtfNombreDestinatario = new javax.swing.JTextField();
        jlbNombre1 = new javax.swing.JLabel();

        jlbNombre.setText("Introduce tu nombre");

        jtaMensajeLog.setColumns(20);
        jtaMensajeLog.setRows(5);
        jScrollPane1.setViewportView(jtaMensajeLog);

        jbEnviar.setText("Enviar");
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });

        jbRefrescar.setText("Refrescar");
        jbRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefrescarActionPerformed(evt);
            }
        });

        jlbNombre1.setText("Nombre destinatario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfMensaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEnviar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbRefrescar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbNombre)
                            .addComponent(jlbNombre1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNombreDestinatario)
                            .addComponent(jtfNombreEmisor))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombreEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombreDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbNombre1))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEnviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbRefrescar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarActionPerformed
        leerInterfaz();
    }//GEN-LAST:event_jbEnviarActionPerformed

    private void jbRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRefrescarActionPerformed
        cargarMensajes();
    }//GEN-LAST:event_jbRefrescarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEnviar;
    private javax.swing.JButton jbRefrescar;
    private javax.swing.JLabel jlbNombre;
    private javax.swing.JLabel jlbNombre1;
    private javax.swing.JTextArea jtaMensajeLog;
    private javax.swing.JTextField jtfMensaje;
    private javax.swing.JTextField jtfNombreDestinatario;
    private javax.swing.JTextField jtfNombreEmisor;
    // End of variables declaration//GEN-END:variables
}
