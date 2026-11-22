// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package interfaz;

import dominio.Sistema;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GenerarPagina extends javax.swing.JFrame {

    private Sistema sistema; // el mismo Sistema que usa toda la aplicacion
    private File pagina;    
    
    public GenerarPagina(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGenerar = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        lblRuta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generación de página");

        btnGenerar.setText("Generar página");
        btnGenerar.addActionListener(this::btnGenerarActionPerformed);

        btnAbrir.setText("Abrir en navegador");
        btnAbrir.setEnabled(false);
        btnAbrir.addActionListener(this::btnAbrirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblRuta))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblRuta)
                .addGap(18, 18, 18)
                .addComponent(btnGenerar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        try {
            Desktop.getDesktop().browse(pagina.toURI());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"No se pudo abrir la página", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        int respuesta = chooser.showSaveDialog(this);
        if(respuesta == JFileChooser.APPROVE_OPTION){
            try{
                pagina = sistema.generarPagina(chooser.getSelectedFile().getAbsolutePath());
                lblRuta.setText("Página generada en: " + pagina.getAbsolutePath());
                pack();
                btnAbrir.setEnabled(true);
            }catch(IOException e){
                JOptionPane.showMessageDialog(this,"No se pudo generar la página", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
       
    }//GEN-LAST:event_btnGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel lblRuta;
    // End of variables declaration//GEN-END:variables
}
