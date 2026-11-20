// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package interfaz;

public class Autores extends javax.swing.JFrame {
    
   

    public Autores() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJuanma = new javax.swing.JLabel();
        lblSantino = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autores");

        lblJuanma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJuanma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/diaz.jpg"))); // NOI18N
        lblJuanma.setText("Juan Manuel Díaz, 376055");
        lblJuanma.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblJuanma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblJuanma.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblSantino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSantino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/soto.jpg"))); // NOI18N
        lblSantino.setText("Santino Soto, 381618");
        lblSantino.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblSantino.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSantino.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblSantino, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJuanma, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSantino, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJuanma))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblJuanma;
    private javax.swing.JLabel lblSantino;
    // End of variables declaration//GEN-END:variables
}
