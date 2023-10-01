/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Modelo;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fabri
 */
public final class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public String nombre;
    public String descripcion;
    public int cantidad;
    public int id;
    public double precio;
    DefaultTableModel tabla = new DefaultTableModel();

    public Inicio() {
        initComponents();
        ListarProducto();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextNombre = new javax.swing.JTextField();
        jTextPrecio = new javax.swing.JTextField();
        jTextDescripcion = new javax.swing.JTextField();
        jTextCantidad = new javax.swing.JTextField();
        jBtnGuardar = new javax.swing.JButton();
        jTextID = new javax.swing.JTextField();
        jBtnEliminar = new javax.swing.JButton();
        jBtnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jCbxOpciones = new javax.swing.JComboBox<>();
        jBtnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextNombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        getContentPane().add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 27, 123, 52));

        jTextPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio"));
        getContentPane().add(jTextPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 123, 52));

        jTextDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción"));
        getContentPane().add(jTextDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 85, 123, 52));

        jTextCantidad.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad"));
        getContentPane().add(jTextCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 123, 52));

        jBtnGuardar.setText("GUARDAR");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 27, 142, 50));

        jTextID.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));
        getContentPane().add(jTextID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 123, 52));

        jBtnEliminar.setText("ELIMINAR");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 93, 142, 50));

        jBtnActualizar.setText("ACTUALIZAR");
        jBtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 142, 50));

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripción", "Cantidad", "Precio"
            }
        ));
        jScrollPane1.setViewportView(TablaProductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 27, 708, 438));

        jCbxOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar Producto por Nombre", "Ordenar Productos por Precio de Menor a Mayor", "Ordenar Productos por Precio de Mayor a Menor", "Buscar Producto por Codigo" }));
        jCbxOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbxOpcionesActionPerformed(evt);
            }
        });
        getContentPane().add(jCbxOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 310, 50));

        jBtnBuscar.setText("BUSCAR");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 161, 142, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed

        nombre = jTextNombre.getText();
        descripcion = jTextDescripcion.getText();
        cantidad = Integer.parseInt(jTextCantidad.getText());
        precio = Double.parseDouble(jTextPrecio.getText());

        // Crear un objeto Productos con los detalles ingresados por el usuario
        Productos nuevoProducto = new Productos(nombre, descripcion, cantidad, precio);

        // Llamar al método insertarProducto para insertar el nuevo producto en la base de datos
        GestorProductos.insertarProducto(nuevoProducto);
    }//GEN-LAST:event_jBtnGuardarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        // TODO add your handling code here:

        id = Integer.parseInt(jTextID.getText());

        // Llamar al método eliminarProducto para eliminar el producto de la base de datos
        GestorProductos.eliminarProducto(id);


    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnActualizarActionPerformed
        // TODO add your handling code here:

        id = Integer.parseInt(jTextID.getText());
        nombre = jTextNombre.getText();
        descripcion = jTextDescripcion.getText();
        cantidad = Integer.parseInt(jTextCantidad.getText());
        precio = Double.parseDouble(jTextPrecio.getText());

        // Llamar al método modificarProducto para actualizar el producto en la base de datos
        GestorProductos.modificarProducto(id, nombre, descripcion, cantidad, precio);
    }//GEN-LAST:event_jBtnActualizarActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        // TODO add your handling code here:
        LimpiarTablaProductos();

        String seleccion = (String) jCbxOpciones.getSelectedItem();
        if (seleccion != null) {
            switch (seleccion) {
                case "Buscar Producto por Codigo":
                    int codigoABuscar = Integer.parseInt(jTextID.getText());
                    ListarProductoPorCodigo(codigoABuscar);
                    break;
                case "Buscar Producto por Nombre":
                    String nombreABuscar = jTextNombre.getText();
                    buscarProductoPorNombre(nombreABuscar);
                    break;
                case "Ordenar Productos por Precio de Menor a Mayor":
                    ordenarProductosPorPrecioAscendente();
                    break;
                case "Ordenar Productos por Precio de Mayor a Menor":
                    ordenarProductosPorPrecioDescendente();
                    break;
                default:
                    break;

            }
        }


    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jCbxOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbxOpcionesActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jCbxOpcionesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton jBtnActualizar;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JComboBox<String> jCbxOpciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextField jTextDescripcion;
    private javax.swing.JTextField jTextID;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextPrecio;
    // End of variables declaration//GEN-END:variables

    public void ListarProducto() {
        List<Productos> productos = GestorProductos.obtenerTodosLosProductos();
        tabla = (DefaultTableModel) TablaProductos.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < productos.size(); i++) {
            ob[0] = productos.get(i).getID();
            ob[1] = productos.get(i).getNombre();
            ob[2] = productos.get(i).getDescripcion();
            ob[3] = productos.get(i).getCantidad();
            ob[4] = productos.get(i).getPrecio();
            tabla.addRow(ob);
        }
        TablaProductos.setModel(tabla);

    }

    public void ListarProductoPorCodigo(int codigoABuscar) {
        List<Productos> productos = GestorProductos.buscarProductosPorCodigo(codigoABuscar);
        tabla = (DefaultTableModel) TablaProductos.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < productos.size(); i++) {
            ob[0] = productos.get(i).getID();
            ob[1] = productos.get(i).getNombre();
            ob[2] = productos.get(i).getDescripcion();
            ob[3] = productos.get(i).getCantidad();
            ob[4] = productos.get(i).getPrecio();
            tabla.addRow(ob);
        }
        TablaProductos.setModel(tabla);

    }

    public void buscarProductoPorNombre(String nombreABuscar) {
        List<Productos> productos = GestorProductos.buscarProductoPorNombre(nombreABuscar);
        tabla = (DefaultTableModel) TablaProductos.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < productos.size(); i++) {
            ob[0] = productos.get(i).getID();
            ob[1] = productos.get(i).getNombre();
            ob[2] = productos.get(i).getDescripcion();
            ob[3] = productos.get(i).getCantidad();
            ob[4] = productos.get(i).getPrecio();
            tabla.addRow(ob);
        }
        TablaProductos.setModel(tabla);

    }

    public void ordenarProductosPorPrecioAscendente() {
        List<Productos> productos = GestorProductos.ordenarProductosPorPrecioAscendente();
        tabla = (DefaultTableModel) TablaProductos.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < productos.size(); i++) {
            ob[0] = productos.get(i).getID();
            ob[1] = productos.get(i).getNombre();
            ob[2] = productos.get(i).getDescripcion();
            ob[3] = productos.get(i).getCantidad();
            ob[4] = productos.get(i).getPrecio();
            tabla.addRow(ob);
        }
        TablaProductos.setModel(tabla);

    }

    public void ordenarProductosPorPrecioDescendente() {
        List<Productos> productos = GestorProductos.ordenarProductosPorPrecioDescendente();
        tabla = (DefaultTableModel) TablaProductos.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < productos.size(); i++) {
            ob[0] = productos.get(i).getID();
            ob[1] = productos.get(i).getNombre();
            ob[2] = productos.get(i).getDescripcion();
            ob[3] = productos.get(i).getCantidad();
            ob[4] = productos.get(i).getPrecio();
            tabla.addRow(ob);
        }
        TablaProductos.setModel(tabla);

    }

    private void LimpiarTablaProductos() {
        tabla = (DefaultTableModel) TablaProductos.getModel();
        int fila = TablaProductos.getRowCount();
        for (int i = 0; i < fila; i++) {
            tabla.removeRow(0);
        }

    }

}
