
package Multimedia;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.media.Buffer;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;

/**
 * Clase que hereda de JInternalFrame con la funcionalidad de
 * reproducir video.
 * @author Jorge Valenzuela Garcia
 */
public class VentanaInternaJMFPlayer extends javax.swing.JInternalFrame{

    /**
     * Reproductor de video de la clase
     */
    private Player reproductor = null;
    
    /**
     * Constructor de la clase
     * @param f - archivo de video que deseamos reproducir
     */
    private VentanaInternaJMFPlayer(File f){
        initComponents();
        String sfichero = "file:" + f.getAbsolutePath();
        MediaLocator ml = new MediaLocator(sfichero);
        try{
            reproductor = Manager.createRealizedPlayer(ml);
            Component vc = reproductor.getVisualComponent();
            if(vc!=null)
                add(vc, java.awt.BorderLayout.CENTER);
            Component cpc = reproductor.getControlPanelComponent();
            if(cpc!=null)
                add(cpc, java.awt.BorderLayout.SOUTH);
            this.pack();
        }
        catch(Exception e){
            System.err.println("VentanaInternaJMFPlayer: "+e);
            reproductor = null;
        }
    }

    
    /**
     * Nos crea una ventana de tipo JMFPlayer
     * @param f - Archivo que queremos reproducir
     * @return VentanaInternaJMFPlayer con el reproductor asociado
     */
    public static VentanaInternaJMFPlayer getInstance(File f){
        VentanaInternaJMFPlayer vi = new VentanaInternaJMFPlayer(f);
        if(vi.reproductor != null){
            vi.setClosable(true);
            vi.setMaximizable(true);    // Le damos algunas caracteristicas
            vi.setResizable(true);
            return vi;
        }
        else
            return null;
}
    
    /**
     * Comienza a reproducir el video
     */
    public void play() {
        if (reproductor != null){
            try{
                reproductor.start();
            }
            catch (Exception e){
                System.err.println("VentanaInternaJMFPlayer: "+e);
            }
        }
    }
    
    
    /**
     * Cierra la reproduccion de video
     */
    public void close(){
        if(reproductor != null){
            try{
            reproductor.close();
            }
            catch (Exception e){
                System.err.println("VentanaInternaJMFPlayer: "+e);
            }
        }
    }
    
    
    /**
     * Nos devuelve el reproductor de la clase
     * @return 
     */
    public Player getPlayer(){
        if (this.reproductor != null)
            return this.reproductor;
        else
            return null;
    }
    
    /**
     * Captura la imagen o fotograma actual del reproductor y lo devuelve
     * @return captura de imagen del reproductor
     */
    public BufferedImage getFrame(){
        if(this.reproductor != null){
            FrameGrabbingControl fgc;
            String claseCtr = "javax.media.control.FrameGrabbingControl";
            fgc = (FrameGrabbingControl)this.reproductor.getControl(claseCtr);
            Buffer bufferFrame = fgc.grabFrame();
            BufferToImage bti;
            bti = new BufferToImage((VideoFormat)bufferFrame.getFormat());
            Image img = bti.createImage(bufferFrame);
            return (BufferedImage)img;
        }
        return null;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cuando se cierre la ventana se parara la reproduccion de video
     * @param evt 
     */
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        this.close();
    }//GEN-LAST:event_formInternalFrameClosed

    /**
     * Cuando se cierre la ventana se parara la reproduccion de video
     * @param evt 
     */
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        this.close();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
