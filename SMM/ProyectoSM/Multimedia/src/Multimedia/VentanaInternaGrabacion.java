
package Multimedia;

import java.io.File;
import sm.sound.SMRecorder;
import sm.sound.SMSoundRecorder;

/**
 * Clase que hereda de JInternalFrame con la funcionalidad de
 * grabar audio
 * @author Jorge Valenzuela Garcia
 */
public class VentanaInternaGrabacion extends javax.swing.JInternalFrame {
    
    /**
     * Grabador de la clase
     */
    private SMRecorder grabador = null;
    
    /**
     * Constructor de la clase
     * @param f - archivo donde se grabara el audio
     */
    public VentanaInternaGrabacion(File f) {
        initComponents();
        this.setMaximizable(true);
        this.setClosable(true);
        this.setResizable(true);
        this.setSize(150,100);
        parar.setEnabled(false);    // Al abrir el boton de stop no estara habilitado
        grabador = new SMSoundRecorder(f);
        //player.setLineListener(new ManejadorAudio());
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraGrabacion = new javax.swing.JToolBar();
        grabar = new javax.swing.JButton();
        parar = new javax.swing.JButton();

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

        barraGrabacion.setRollover(true);

        grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/RecordPressed_48x48.png"))); // NOI18N
        grabar.setToolTipText("Comenzar Grabacion");
        grabar.setFocusable(false);
        grabar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        grabar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarActionPerformed(evt);
            }
        });
        barraGrabacion.add(grabar);

        parar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/StopDisabled_48x48.png"))); // NOI18N
        parar.setToolTipText("Parar Grabacion");
        parar.setFocusable(false);
        parar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        parar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararActionPerformed(evt);
            }
        });
        barraGrabacion.add(parar);

        getContentPane().add(barraGrabacion, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Para la grabacion
     * @param evt 
     */
    private void pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararActionPerformed
        if(grabador != null){
            grabador.stop();
            parar.setEnabled(false);
            grabar.setEnabled(true);
            parar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/StopDisabled_48x48.png")));
            grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/RecordPressed_48x48.png")));
        }
    }//GEN-LAST:event_pararActionPerformed

    /**
     * Comienza la grabacion
     * @param evt 
     */
    private void grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarActionPerformed
        if(grabador != null){
            grabador.record();
            parar.setEnabled(true);
            grabar.setEnabled(false);
            parar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/StopPressedBlue_48x48.png")));
            grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/RecordDisabled_48x48.png")));
        }
    }//GEN-LAST:event_grabarActionPerformed

    /**
     * Cuando se cierre parara la reproduccion
     * @param evt 
     */
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        grabador.stop();    // Si se cierra la grabacion se parará
    }//GEN-LAST:event_formInternalFrameClosed

    /**
     * Cuando se cierre se parara la reproduccion
     * @param evt 
     */
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        grabador.stop();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraGrabacion;
    private javax.swing.JButton grabar;
    private javax.swing.JButton parar;
    // End of variables declaration//GEN-END:variables
}
