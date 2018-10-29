
package GUIQytetet;

import modeloqytetec.Qytetet;

/**
 * @author Jorge Valenzuela Garcia
 */
public class VistaQytetet extends javax.swing.JPanel {

    /**
     * Creates new form VistaQytetet
     */
    public VistaQytetet() {
        initComponents();
    }
    
    public void actualizarVistaSorpresa(Qytetet qytetet){
        this.vistaCartaSorpresa.actualizar(qytetet.getCartaActual().toString());
    }
    
    public void limpiarVistaSorpresa(){
        this.vistaCartaSorpresa.actualizar("");
    }
    
    public void actualizar(Qytetet qytetet){
       this.vistaJugador.actualizar(qytetet.getJugadorActual().toString());
       this.vistaCasilla.actualizar(qytetet.getJugadorActual().getCasillaActual().toString());
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vistaJugador = new GUIQytetet.VistaJugador();
        vistaCasilla = new GUIQytetet.VistaCasilla();
        vistaCartaSorpresa = new GUIQytetet.VistaCartaSorpresa();
        LabelTitulo = new javax.swing.JLabel();

        LabelTitulo.setFont(new java.awt.Font("Yu Gothic", 0, 24)); // NOI18N
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("QYTETET");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(vistaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vistaCartaSorpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                            .addComponent(vistaCasilla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(vistaCartaSorpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vistaCasilla, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(vistaJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTitulo;
    private GUIQytetet.VistaCartaSorpresa vistaCartaSorpresa;
    private GUIQytetet.VistaCasilla vistaCasilla;
    private GUIQytetet.VistaJugador vistaJugador;
    // End of variables declaration//GEN-END:variables
}