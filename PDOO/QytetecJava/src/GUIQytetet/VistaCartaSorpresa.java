/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIQytetet;

/**
 *
 * @author Jorge
 */
public class VistaCartaSorpresa extends javax.swing.JPanel {

    /**
     * Creates new form VistaCartaSorpresa
     */
    public VistaCartaSorpresa() {
        initComponents();
    }
    
    public void actualizar(String descripcionCartaSorpresa){
        this.jtTextoCartaSorpresa.setText(descripcionCartaSorpresa);
        this.repaint();
        this.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTextoCartaSorpresa = new javax.swing.JTextArea();
        labelSorpresa = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(213, 130, 255), 10, true));

        jtTextoCartaSorpresa.setEditable(false);
        jtTextoCartaSorpresa.setColumns(20);
        jtTextoCartaSorpresa.setRows(5);
        jScrollPane1.setViewportView(jtTextoCartaSorpresa);

        labelSorpresa.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        labelSorpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSorpresa.setText("Carta Sorpresa");
        labelSorpresa.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 153, 255), new java.awt.Color(153, 0, 153)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(labelSorpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSorpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtTextoCartaSorpresa;
    private javax.swing.JLabel labelSorpresa;
    // End of variables declaration//GEN-END:variables
}