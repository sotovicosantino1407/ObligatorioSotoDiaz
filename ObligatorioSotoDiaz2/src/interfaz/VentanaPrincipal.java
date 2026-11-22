// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package interfaz;

import dominio.Animal;
import dominio.Donacion;
import dominio.Sistema;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaPrincipal extends javax.swing.JFrame implements Observer {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());

    private Sistema sistema; // el modelo: de aca sale todo lo que se muestra

    public VentanaPrincipal(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        sistema.addObserver(this); // me registro para que Sistema me avise de los cambios
        lstAnimales.setCellRenderer(new RenderAnimales()); // la lista pinta cada fila con color
        setLocationRelativeTo(null);
        actualizar(); // primera carga de los datos
    }

    // Lo llama el Sistema cada vez que cambia algo
    @Override
    public void update(Observable o, Object arg) {
        actualizar();
    }

    // Muestra en pantalla las cantidades y la lista de animales
    private void actualizar() {
        lblTotal.setText("Total de animales: " + sistema.getAnimales().size());
        lblDisponibles.setText("Disponibles: " + sistema.cantidadAnimalesEnEstado(Animal.DISPONIBLE));
        lblNoDisponibles.setText("No disponibles: " + sistema.cantidadAnimalesEnEstado(Animal.NO_DISPONIBLE));
        lblEntregados.setText("Entregados a familias: " + sistema.cantidadAnimalesEnEstado(Animal.ENTREGADO));
        lblAdopciones.setText("Adopciones registradas: " + sistema.getAdopciones().size());
        lblEmpresas.setText("Empresas registradas: " + sistema.getEmpresas().size());
        lblStock1.setText("Stock perros grandes: " + sistema.stockDeTipo(Donacion.PERROS_GRANDES) + " kg");
        lblStock2.setText("Stock perros chicos: " + sistema.stockDeTipo(Donacion.PERROS_CHICOS) + " kg");
        lblStock3.setText("Stock perros adultos: " + sistema.stockDeTipo(Donacion.PERROS_ADULTOS) + " kg");
        lblStock4.setText("Stock otros: " + sistema.stockDeTipo(Donacion.OTRO) + " kg");
        lstAnimales.setListData(sistema.getAnimales().toArray(new Animal[0]));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTotal = new javax.swing.JLabel();
        lblDisponibles = new javax.swing.JLabel();
        lblNoDisponibles = new javax.swing.JLabel();
        lblEntregados = new javax.swing.JLabel();
        lblAdopciones = new javax.swing.JLabel();
        lblEmpresas = new javax.swing.JLabel();
        lblStock1 = new javax.swing.JLabel();
        lblStock2 = new javax.swing.JLabel();
        lblStock3 = new javax.swing.JLabel();
        lblStock4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAnimales = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemAltaAnimal = new javax.swing.JMenuItem();
        itemAltaFamilia = new javax.swing.JMenuItem();
        itemAltaEmpresa = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemAdopcion = new javax.swing.JMenuItem();
        itemCambiarEstado = new javax.swing.JMenuItem();
        itemAnularAdopcion = new javax.swing.JMenuItem();
        itemDonacion = new javax.swing.JMenuItem();
        itemImportar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        itemConsultaFamilia = new javax.swing.JMenuItem();
        itemConsultaDonaciones = new javax.swing.JMenuItem();
        itemPagina = new javax.swing.JMenuItem();
        itemRecuperar = new javax.swing.JMenuItem();
        itemAutores = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Refugio de perros");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblTotal.setText("lblTotal");

        lblDisponibles.setText("lblDisponibles");

        lblNoDisponibles.setText("lblNoDisponibles");

        lblEntregados.setText("lblEntregados");

        lblAdopciones.setText("lblAdopciones");

        lblEmpresas.setText("lblEmpresas");

        lblStock1.setText("lblStock1");

        lblStock2.setText("lblStock2");

        lblStock3.setText("lblStock3");

        lblStock4.setText("lblStock4");

        jScrollPane1.setViewportView(lstAnimales);

        jMenu1.setText("Altas");

        itemAltaAnimal.setText("Animales");
        itemAltaAnimal.addActionListener(this::itemAltaAnimalActionPerformed);
        jMenu1.add(itemAltaAnimal);

        itemAltaFamilia.setText("Familias");
        itemAltaFamilia.addActionListener(this::itemAltaFamiliaActionPerformed);
        jMenu1.add(itemAltaFamilia);

        itemAltaEmpresa.setText("Empresas");
        itemAltaEmpresa.addActionListener(this::itemAltaEmpresaActionPerformed);
        jMenu1.add(itemAltaEmpresa);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Movimientos");

        itemAdopcion.setText("Realizar adopcion");
        itemAdopcion.addActionListener(this::itemAdopcionActionPerformed);
        jMenu2.add(itemAdopcion);

        itemCambiarEstado.setText("Cambiar de estado");
        itemCambiarEstado.addActionListener(this::itemCambiarEstadoActionPerformed);
        jMenu2.add(itemCambiarEstado);

        itemAnularAdopcion.setText("Anular adopcion");
        itemAnularAdopcion.addActionListener(this::itemAnularAdopcionActionPerformed);
        jMenu2.add(itemAnularAdopcion);

        itemDonacion.setText("Registrar donacion");
        itemDonacion.addActionListener(this::itemDonacionActionPerformed);
        jMenu2.add(itemDonacion);

        itemImportar.setText("Importar donaciones");
        itemImportar.addActionListener(this::itemImportarActionPerformed);
        jMenu2.add(itemImportar);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Varios");

        itemConsultaFamilia.setText("Consulta de familia");
        itemConsultaFamilia.addActionListener(this::itemConsultaFamiliaActionPerformed);
        jMenu3.add(itemConsultaFamilia);

        itemConsultaDonaciones.setText("Consulta de donaciones");
        itemConsultaDonaciones.addActionListener(this::itemConsultaDonacionesActionPerformed);
        jMenu3.add(itemConsultaDonaciones);

        itemPagina.setText("Generacion de pagina");
        itemPagina.setToolTipText("");
        itemPagina.addActionListener(this::itemPaginaActionPerformed);
        jMenu3.add(itemPagina);

        itemRecuperar.setText("Recuperar datos");
        itemRecuperar.addActionListener(this::itemRecuperarActionPerformed);
        jMenu3.add(itemRecuperar);

        itemAutores.setText("Autores");
        itemAutores.addActionListener(this::itemAutoresActionPerformed);
        jMenu3.add(itemAutores);

        itemSalir.setText("Salir");
        itemSalir.addActionListener(this::itemSalirActionPerformed);
        jMenu3.add(itemSalir);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDisponibles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNoDisponibles, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(lblEntregados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAdopciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStock1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStock2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStock3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStock4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDisponibles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNoDisponibles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEntregados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAdopciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmpresas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStock1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStock2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStock3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStock4)))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemAltaAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAltaAnimalActionPerformed
        new AltaAnimal(sistema).setVisible(true);
    }//GEN-LAST:event_itemAltaAnimalActionPerformed

    private void itemAltaFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAltaFamiliaActionPerformed
        new AltaFamilia(sistema).setVisible(true);
    }//GEN-LAST:event_itemAltaFamiliaActionPerformed

    private void itemAltaEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAltaEmpresaActionPerformed
        new AltaEmpresa(sistema).setVisible(true);
    }//GEN-LAST:event_itemAltaEmpresaActionPerformed

    private void itemDonacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDonacionActionPerformed
        new RegistrarDonacion(sistema).setVisible(true);
    }//GEN-LAST:event_itemDonacionActionPerformed

    private void itemAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAdopcionActionPerformed
        new RealizarAdopcion(sistema).setVisible(true);
    }//GEN-LAST:event_itemAdopcionActionPerformed

    private void itemCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCambiarEstadoActionPerformed
        new CambiarEstado(sistema).setVisible(true);
    }//GEN-LAST:event_itemCambiarEstadoActionPerformed

    private void itemAnularAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAnularAdopcionActionPerformed
        new AnularAdopcion(sistema).setVisible(true);
    }//GEN-LAST:event_itemAnularAdopcionActionPerformed

    private void itemImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemImportarActionPerformed
        importarDonaciones();
    }//GEN-LAST:event_itemImportarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        salir();
    }//GEN-LAST:event_formWindowClosing

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        salir();
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRecuperarActionPerformed
        recuperarDatos();   
    }//GEN-LAST:event_itemRecuperarActionPerformed

    private void itemAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAutoresActionPerformed
        new Autores().setVisible(true);
    }//GEN-LAST:event_itemAutoresActionPerformed

    private void itemConsultaDonacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaDonacionesActionPerformed
        new ConsultaDonaciones(sistema).setVisible(true);
    }//GEN-LAST:event_itemConsultaDonacionesActionPerformed

    private void itemConsultaFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaFamiliaActionPerformed
        new ConsultaFamilia(sistema).setVisible(true);
    }//GEN-LAST:event_itemConsultaFamiliaActionPerformed

    private void itemPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPaginaActionPerformed
        new GenerarPagina(sistema).setVisible(true);
    }//GEN-LAST:event_itemPaginaActionPerformed

    // Deja elegir un archivo de texto y le pide al sistema que registre las donaciones que trae
    private void importarDonaciones() {
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Elegir archivo de donaciones");
        selector.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
        if (selector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = selector.getSelectedFile();
            try {
                int errores = sistema.importarDonaciones(archivo);
                if (errores == 0) {
                    JOptionPane.showMessageDialog(this, "Importacion terminada sin errores");
                } else {
                    JOptionPane.showMessageDialog(this, "Importacion terminada con " + errores
                            + " linea(s) con errores.\nSe genero un archivo de errores en la misma carpeta.");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "No se pudo leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Guarda los datos y cierra; si no se pueden guardar, pregunta si salir igual
    private void salir() {
        try {
            sistema.guardar(Sistema.ARCHIVO_DATOS);
            System.exit(0);
        } catch (IOException e) {
            int respuesta = JOptionPane.showConfirmDialog(this, "Los datos no se guardaron, ¿desea salir igual?", "Error", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
    
    // Reemplaza los datos actuales por los guardados, previa confirmación
    private void recuperarDatos(){
        int respuesta = JOptionPane.showConfirmDialog(this, "Los datos actuales se reemplazarán por los guardados, ¿desea continuar?", "Recuperar datos", JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_OPTION){
            try {
                sistema.recuperar(Sistema.ARCHIVO_DATOS);
                JOptionPane.showMessageDialog(this, "Datos recuperados de manera exitosa");
            } catch (FileNotFoundException e){
                JOptionPane.showMessageDialog(this, "No hay datos guardados");
            } catch (IOException | ClassNotFoundException e ){
                JOptionPane.showMessageDialog(this, "El archivo de datos está dañado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // El sistema siempre arranca vacío; los datos se cargan solo con "Recuperar datos"
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal(new Sistema()).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAdopcion;
    private javax.swing.JMenuItem itemAltaAnimal;
    private javax.swing.JMenuItem itemAltaEmpresa;
    private javax.swing.JMenuItem itemAltaFamilia;
    private javax.swing.JMenuItem itemAnularAdopcion;
    private javax.swing.JMenuItem itemAutores;
    private javax.swing.JMenuItem itemCambiarEstado;
    private javax.swing.JMenuItem itemConsultaDonaciones;
    private javax.swing.JMenuItem itemConsultaFamilia;
    private javax.swing.JMenuItem itemDonacion;
    private javax.swing.JMenuItem itemImportar;
    private javax.swing.JMenuItem itemPagina;
    private javax.swing.JMenuItem itemRecuperar;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdopciones;
    private javax.swing.JLabel lblDisponibles;
    private javax.swing.JLabel lblEmpresas;
    private javax.swing.JLabel lblEntregados;
    private javax.swing.JLabel lblNoDisponibles;
    private javax.swing.JLabel lblStock1;
    private javax.swing.JLabel lblStock2;
    private javax.swing.JLabel lblStock3;
    private javax.swing.JLabel lblStock4;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList<Animal> lstAnimales;
    // End of variables declaration//GEN-END:variables
}
