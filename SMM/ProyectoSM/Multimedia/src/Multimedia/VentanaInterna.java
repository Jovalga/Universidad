package Multimedia;

import java.awt.Component;
import java.awt.Point;
import sm.JVG.iu.Lienzo2DImagen;

/**
 * Clase que hereda de JInternalFrame que va a poseer
 * un Lienzo2DImagen sobre el que pintaremos y 
 * aplicaremos operaciones sobre imagenes
 * @author Jorge Valenzuela Garcia
 */
public class VentanaInterna extends javax.swing.JInternalFrame {
    
    
    /**
    * Contructor de la clase VentanaInterna 
    */
    public VentanaInterna(){
        initComponents();
        this.setTitle("Nuevo");
        this.setMaximizable(true);
        this.setResizable(true);
        this.lienzo.setSize(this.getWidth(), this.getHeight());
    }
    
    /**
     * Metodo que nos devuelve el lienzo actual de la ventana.
     * @return lienzo de la ventana
     */
    public Lienzo2DImagen getLienzo(){   
        return lienzo;                  
    }
    
    
    @Override
    public void add(Component comp, Object constraints) {
        super.add(comp, constraints); //To change body of generated methods, choose Tools | Templates.
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarraDesplazamiento = new javax.swing.JScrollPane();
        lienzo = new sm.JVG.iu.Lienzo2DImagen();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        lienzo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lienzoMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
        lienzo.setLayout(lienzoLayout);
        lienzoLayout.setHorizontalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );
        lienzoLayout.setVerticalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        BarraDesplazamiento.setViewportView(lienzo);

        getContentPane().add(BarraDesplazamiento, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lienzoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoMouseMoved

    }//GEN-LAST:event_lienzoMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane BarraDesplazamiento;
    private sm.JVG.iu.Lienzo2DImagen lienzo;
    // End of variables declaration//GEN-END:variables
}
