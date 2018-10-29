
package Multimedia;

import java.io.File;
import sm.sound.SMClipPlayer;
import sm.sound.SMPlayer;


/**
 * Clase que hereda de JInternalFrame con la funcionalidad de
 * reproducir audio
 * @author Jorge Valenzuela Garcia
 */
public class VentanaInternaAudio extends javax.swing.JInternalFrame {

    /**
     * Reproductor de audio de la clase
     */
    private SMPlayer player = null;
    
    /**
     * Constructor de la clase VentanaInternaAudio
     * @param f - archivo de audio en formato .wav
     */
    public VentanaInternaAudio(File f){
        initComponents();
        this.setMaximizable(true);
        this.setClosable(true);
        this.setResizable(true);
        this.setSize(150,100);
        botonStop.setEnabled(false);    // Al abrir el boton de stop no estara habilitado
        player = new SMClipPlayer(f);
        //player.setLineListener(new ManejadorAudio());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraReproductor = new javax.swing.JToolBar();
        botonReproducir = new javax.swing.JButton();
        botonStop = new javax.swing.JButton();

        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                formComponentRemoved(evt);
            }
        });
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        barraReproductor.setRollover(true);

        botonReproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/PlayPressed_48x48.png"))); // NOI18N
        botonReproducir.setToolTipText("Reproducir");
        botonReproducir.setFocusable(false);
        botonReproducir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonReproducir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReproducirActionPerformed(evt);
            }
        });
        barraReproductor.add(botonReproducir);

        botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/StopDisabled_48x48.png"))); // NOI18N
        botonStop.setToolTipText("Reproducir");
        botonStop.setFocusable(false);
        botonStop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonStop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonStopActionPerformed(evt);
            }
        });
        barraReproductor.add(botonStop);

        getContentPane().add(barraReproductor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Nos devuelve el reproductor de la clase
     * @return reproductor de la clase
     */
    public SMPlayer getAudio(){
        return this.player;
    }
    
    
    /**
     * Reproduce el audio que tenga el reproductor
     * @param evt
     */
    private void botonReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReproducirActionPerformed
        if(player!=null){
            player.play();
            botonStop.setEnabled(true);
            botonReproducir.setEnabled(false);
            botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/StopPressedBlue_48x48.png")));
            botonReproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/PlayDisabled_48x48.png")));
        }
        
        

    }//GEN-LAST:event_botonReproducirActionPerformed

    /**
     * Para la reproduccion de audio
     * @param evt 
     */
    private void botonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonStopActionPerformed
        if(player != null){
            player.stop();
            botonStop.setEnabled(false);
            botonReproducir.setEnabled(true);
            botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/StopDisabled_48x48.png")));
            botonReproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/PlayPressed_48x48.png")));
        }
        
        /*botonStop.setEnabled(false);
        botonReproducir.setEnabled(true);
        botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/StopDisabled_48x48.png")));
        botonReproducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/PlayPressed_48x48.png")));
        */
    }//GEN-LAST:event_botonStopActionPerformed

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved
    }//GEN-LAST:event_formComponentRemoved

    /**
     * Cuando se cierre se parara el audio
     * @param evt 
     */
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        player.stop();
    }//GEN-LAST:event_formInternalFrameClosed

    /**
     * Cuando se cierre se parara el audio
     * @param evt 
     */
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        player.stop();
    }//GEN-LAST:event_formInternalFrameClosing

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraReproductor;
    private javax.swing.JButton botonReproducir;
    private javax.swing.JButton botonStop;
    // End of variables declaration//GEN-END:variables
}
