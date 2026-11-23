// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package interfaz;

import dominio.Adopcion;
import dominio.Animal;
import dominio.Familia;
import dominio.Sistema;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class RealizarAdopcion extends javax.swing.JFrame implements Observer {


    private Sistema sistema;

    public RealizarAdopcion(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        sistema.addObserver(this);
        lstAnimales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstAnimales.addListSelectionListener(e -> mostrarDatosAnimal());
        setLocationRelativeTo(null);
        cargarAnimales();
        cargarFamilias();
    }

    @Override
    public void update(Observable o, Object arg) {
        cargarAnimales();
        cargarFamilias();
    }

    @Override
    public void dispose() {
        sistema.deleteObserver(this);
        super.dispose();
    }

    // Solo se pueden adoptar los animales disponibles; se mantiene el elegido si sigue disponible
    private void cargarAnimales() {
        Animal elegido = lstAnimales.getSelectedValue();
        lstAnimales.setListData(sistema.getAnimalesDisponibles().toArray(new Animal[0]));
        if (elegido != null) {
            lstAnimales.setSelectedValue(elegido, true);
        }
        mostrarDatosAnimal();
    }

    private void cargarFamilias() {
        Familia elegida = (Familia) cmbFamilia.getSelectedItem();
        cmbFamilia.removeAllItems();
        for (Familia f : sistema.getFamilias()) {
            cmbFamilia.addItem(f);
        }
        if (elegida != null) {
            cmbFamilia.setSelectedItem(elegida);
        }
    }

    private void mostrarDatosAnimal() {
        Animal animal = lstAnimales.getSelectedValue();
        if (animal == null) {
            lblPeso.setText("Peso: -");
            lblTemperamento.setText("Temperamento: -");
        } else {
            lblPeso.setText("Peso: " + animal.getPeso() + " kg");
            lblTemperamento.setText("Temperamento: " + animal.getTemperamento());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnimales = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAnimales = new javax.swing.JList<>();
        lblPeso = new javax.swing.JLabel();
        lblTemperamento = new javax.swing.JLabel();
        lblFamilia = new javax.swing.JLabel();
        cmbFamilia = new javax.swing.JComboBox<>();
        lblComentarios = new javax.swing.JLabel();
        txtComentarios = new javax.swing.JTextField();
        btnAdoptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar adopción");

        lblAnimales.setText("Animales disponibles");

        jScrollPane1.setViewportView(lstAnimales);

        lblPeso.setText("Peso:");

        lblTemperamento.setText("Temperamento:");

        lblFamilia.setText("Familia");

        lblComentarios.setText("Comentarios");

        btnAdoptar.setText("Adoptar");
        btnAdoptar.addActionListener(this::btnAdoptarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdoptar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComentarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFamilia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblPeso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTemperamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(cmbFamilia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtComentarios))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAnimales)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTemperamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFamilia))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComentarios)
                    .addComponent(txtComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdoptar)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdoptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdoptarActionPerformed
        Animal animal = lstAnimales.getSelectedValue();
        Familia familia = (Familia) cmbFamilia.getSelectedItem();

        if (animal == null) {
            mostrarError("Seleccione un animal de la lista");
        } else if (familia == null) {
            mostrarError("Primero debe registrar una familia");
        } else {
            String comentarios = txtComentarios.getText().trim();
            Adopcion adopcion = sistema.realizarAdopcion(animal, familia, comentarios);
            JOptionPane.showMessageDialog(this, "Adopción realizada. Número: " + adopcion.getNumero());
            txtComentarios.setText("");
        }
    }//GEN-LAST:event_btnAdoptarActionPerformed

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdoptar;
    private javax.swing.JComboBox<Familia> cmbFamilia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnimales;
    private javax.swing.JLabel lblComentarios;
    private javax.swing.JLabel lblFamilia;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblTemperamento;
    private javax.swing.JList<Animal> lstAnimales;
    private javax.swing.JTextField txtComentarios;
    // End of variables declaration//GEN-END:variables
}
