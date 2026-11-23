// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package interfaz;

import dominio.Familia;
import dominio.Sistema;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;

public class ConsultaFamilia extends javax.swing.JFrame implements Observer {

    private Sistema sistema;

    public ConsultaFamilia(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        sistema.addObserver(this);
        setLocationRelativeTo(null);
        cargarFamilias();
    }

    @Override
    public void update(Observable o, Object arg) {
        cargarFamilias();
    }

    @Override
    public void dispose() {
        sistema.deleteObserver(this);
        super.dispose();
    }

    // Carga la tabla con el orden elegido en el combo
    private void cargarFamilias() {
        DefaultTableModel modelo = (DefaultTableModel) tblFamilias.getModel();
        modelo.setRowCount(0);
        ArrayList<Familia> lista;
        if (cmbOrden.getSelectedIndex() == 0) {
            lista = sistema.getFamiliasPorApellido();
        } else {
            lista = sistema.getFamiliasPorAdopciones();
        }
        for (Familia f : lista) {
            modelo.addRow(new Object[]{f.getApellido(), f.getCedula(), sistema.cantidadAdopcionesDe(f), f.getCelular()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbOrden = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        scrollFamilias = new javax.swing.JScrollPane();
        tblFamilias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de familia");

        cmbOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apellido", "Cant. adopciones" }));
        cmbOrden.addActionListener(this::cmbOrdenActionPerformed);

        jLabel1.setText("Ordenar por:");

        tblFamilias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Apellido", "Cédula", "Adopciones", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollFamilias.setViewportView(tblFamilias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollFamilias, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollFamilias, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrdenActionPerformed
        cargarFamilias();
    }//GEN-LAST:event_cmbOrdenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scrollFamilias;
    private javax.swing.JTable tblFamilias;
    // End of variables declaration//GEN-END:variables
}
