// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package interfaz;

import dominio.Animal;
import dominio.Sistema;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class CambiarEstado extends javax.swing.JFrame implements Observer {


    private Sistema sistema;

    public CambiarEstado(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        sistema.addObserver(this);
        lstAnimales.setCellRenderer(new RenderAnimales());
        lstAnimales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setLocationRelativeTo(null);
        cargarAnimales();
    }

    @Override
    public void update(Observable o, Object arg) {
        cargarAnimales();
    }

    @Override
    public void dispose() {
        sistema.deleteObserver(this);
        super.dispose();
    }

    // Solo se muestran los animales que no fueron entregados; se mantiene el elegido
    private void cargarAnimales() {
        Animal elegido = lstAnimales.getSelectedValue();
        lstAnimales.setListData(sistema.getAnimalesNoEntregados().toArray(new Animal[0]));
        if (elegido != null) {
            lstAnimales.setSelectedValue(elegido, true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnimales = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAnimales = new javax.swing.JList<>();
        btnCambiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar de estado");

        lblAnimales.setText("Animales (no entregados)");

        jScrollPane1.setViewportView(lstAnimales);

        btnCambiar.setText("Cambiar estado");
        btnCambiar.addActionListener(this::btnCambiarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAnimales)
                    .addComponent(btnCambiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAnimales)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(btnCambiar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        Animal animal = lstAnimales.getSelectedValue();
        if (animal == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un animal de la lista", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            sistema.cambiarEstado(animal);
        }
    }//GEN-LAST:event_btnCambiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnimales;
    private javax.swing.JList<Animal> lstAnimales;
    // End of variables declaration//GEN-END:variables
}
