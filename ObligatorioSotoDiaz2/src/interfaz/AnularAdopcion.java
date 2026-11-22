// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package interfaz;

import dominio.Adopcion;
import dominio.Sistema;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class AnularAdopcion extends javax.swing.JFrame implements Observer {


    private Sistema sistema; // el mismo Sistema que usa toda la aplicacion

    public AnularAdopcion(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        sistema.addObserver(this); // la lista se actualiza si cambian los datos
        lstAdopciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setLocationRelativeTo(null);
        cargarAdopciones();
    }

    @Override
    public void update(Observable o, Object arg) {
        cargarAdopciones();
    }

    // Al cerrar la ventana dejamos de observar al sistema
    @Override
    public void dispose() {
        sistema.deleteObserver(this);
        super.dispose();
    }

    // Muestra todas las adopciones, ya ordenadas por numero
    private void cargarAdopciones() {
        Adopcion elegida = lstAdopciones.getSelectedValue();
        lstAdopciones.setListData(sistema.getAdopciones().toArray(new Adopcion[0]));
        if (elegida != null) {
            lstAdopciones.setSelectedValue(elegida, true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAdopciones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAdopciones = new javax.swing.JList<>();
        btnAnular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Anular adopcion");

        lblAdopciones.setText("Adopciones");

        jScrollPane1.setViewportView(lstAdopciones);

        btnAnular.setText("Anular adopcion");
        btnAnular.addActionListener(this::btnAnularActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(lblAdopciones, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(btnAnular)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblAdopciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnular)
                .addGap(0, 149, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        Adopcion adopcion = lstAdopciones.getSelectedValue();
        if (adopcion == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una adopcion de la lista", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            sistema.anularAdopcion(adopcion); // el animal pasa a no disponible
            JOptionPane.showMessageDialog(this, "Adopcion anulada");
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdopciones;
    private javax.swing.JList<Adopcion> lstAdopciones;
    // End of variables declaration//GEN-END:variables
}
