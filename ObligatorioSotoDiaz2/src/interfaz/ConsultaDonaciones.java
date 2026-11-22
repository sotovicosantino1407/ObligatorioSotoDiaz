// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package interfaz;

import dominio.Donacion;
import dominio.Sistema;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;

public class ConsultaDonaciones extends javax.swing.JFrame implements Observer {

    private Sistema sistema;

    public ConsultaDonaciones(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        sistema.addObserver(this);
        setLocationRelativeTo(null);
        cargarDonaciones();
    }

    @Override
    public void update(Observable o, Object arg) {
        cargarDonaciones();
    }

    @Override
    public void dispose() {
        sistema.deleteObserver(this);
        super.dispose();
    }

    // Carga la tabla con todas las donaciones, ordenadas por número
    private void cargarDonaciones() {
        DefaultTableModel modelo = (DefaultTableModel) tblDonaciones.getModel();
        modelo.setRowCount(0);
        for (Donacion d : sistema.getDonaciones()) {
            modelo.addRow(new Object[]{d.getNumero(), d.getEmpresa().getNombre(), Donacion.nombreTipo(d.getTipo()), d.getKilos()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollDonaciones = new javax.swing.JScrollPane();
        tblDonaciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de donaciones");

        tblDonaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Empresa", "Tipo", "Kilos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollDonaciones.setViewportView(tblDonaciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(scrollDonaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(scrollDonaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollDonaciones;
    private javax.swing.JTable tblDonaciones;
    // End of variables declaration//GEN-END:variables
}
