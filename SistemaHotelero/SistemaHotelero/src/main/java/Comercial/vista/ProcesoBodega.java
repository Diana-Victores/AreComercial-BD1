/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.vista;

import Comercial.datos.BodegaDAO;
import Comercial.datos.ProcesoBodegaDAO;
import Comercial.datos.ProcesoProductoDAO;
import Comercial.datos.ProductoDAO;
import Comercial.dominio.Bodega;
import Comercial.dominio.ProcesoProducto;
import Comercial.dominio.Producto;
//import static Comercial.vista.Proceso_Producto.txtnombrebodega;
import static java.awt.image.ImageObserver.WIDTH;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import seguridad.datos.BitacoraDao;
import seguridad.dominio.Bitacora;
import seguridad.vista.Aplicacion_Perfil;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login;
import seguridad.vista.MDI_Components;

/**
 *
 * @author Diana
 */
public class ProcesoBodega extends javax.swing.JInternalFrame {

    ProductoDAO procesoproducto = new ProductoDAO();
    int estadovalidacion;
    Producto Buscar = new Producto();

    /**
     * Creates new form ProcesoBodega
     */
    void habilitarAcciones() {

        int codigoAplicacion = 3010;
        var usuario = Login.usuarioComercial;

        btnGuardar.setEnabled(false);
       
        btnEliminar.setEnabled(false);
        btnBuscar.setEnabled(false);

        GenerarPermisos permisos = new GenerarPermisos();

        String[] permisosApp = new String[4];

        for (int i = 0; i < 4; i++) {
            permisosApp[i] = permisos.getAccionesAplicacion(codigoAplicacion, usuario)[i];
        }

        if (permisosApp[0].equals("1")) {
            btnGuardar.setEnabled(true);
        }
        if (permisosApp[1].equals("1")) {
            btnBuscar.setEnabled(true);
        }
       
        if (permisosApp[3].equals("1")) {
            btnEliminar.setEnabled(true);
        }
    }

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Producto");
        modelo.addColumn("Bodega");
        modelo.addColumn("Existencias");
        modelo.addColumn("Fecha de Entrega");
        modelo.addColumn("Bodega");
        modelo.addColumn("Nueva Existencia");
        modelo.addColumn("Nueva Bodega");

        ProductoDAO procesoproductoDAO = new ProductoDAO();
        List<Producto> procesoproducto = procesoproductoDAO.select();
        TablaProducto.setModel(modelo);
        String[] dato = new String[4];
        for (int i = 0; i < procesoproducto.size(); i++) {
            dato[0] = Integer.toString(procesoproducto.get(i).getPK_id_producto());
            dato[1] = procesoproducto.get(i).getNombre_producto();
            dato[2] = procesoproducto.get(i).getDescripcion_producto();
            dato[3] = procesoproducto.get(i).getFechaIngreso();

            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void limpiar() {
        txtProducto.setText("");
        txtDetalle.setText("");
        txtfecha.setText("");
        txtsalida.setText("");

    }

    public void buscar() {
        Buscar = procesoproducto.query(Buscar);
        txtProducto.setText(Buscar.getNombre_producto());
        txtDetalle.setText(Buscar.getDescripcion_producto());
        txtfecha.setText(Buscar.getFechaIngreso());

    }

    public ProcesoBodega() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        txtDetalle = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        txtsalida = new javax.swing.JTextField();
        txt_combox = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProducto = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder("ProcesoBodega"));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nombre Bodega");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Producto");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Detalle");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Ingreso de producto");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Salida de producto");

        txt_combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_comboxActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnReporte.setText("Reporte");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_combox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar)
                            .addComponent(btnReporte)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addComponent(txtfecha)
                        .addComponent(txtsalida))
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscar)
                    .addComponent(txt_combox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtsalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnReporte))
                .addContainerGap())
        );

        btnAyuda.setText("Ayuda");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("PROCESO BODEGA");

        TablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaProducto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(180, 180, 180)
                .addComponent(btnAyuda)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAyuda)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        GenerarPermisos permisos = new GenerarPermisos();
        MDI_Components mdi_Components = new MDI_Components();

        String id = "0";
        MantenimientoProductos manteminetoProductosDAO = new MantenimientoProductos();

        ProductoDAO procesobodegaDAO = new ProductoDAO();
        ProductoDAO procesobodegaDAO1 = new ProductoDAO();
        Producto productoAInsertar = new Producto();
        ProcesoProducto productoAInsertar1 = new ProcesoProducto();
        String txtcombox = txt_combox.getSelectedItem().toString();
        // productoAInsertar.setPK_id_producto((int) Integer.parseInt(txt_IdProducto.getText()));
        productoAInsertar1(txtcombox);
        productoAInsertar.setNombre_producto(txtProducto.getText());
        productoAInsertar.setDescripcion_producto(txtDetalle.getText());
        productoAInsertar.setFechaIngreso(txtfecha.getText());
       // procesoproductoAInsertar.s(txt_Estado.getText());

        procesobodegaDAO.insert(productoAInsertar);

        BitacoraDao BitacoraDAO = new BitacoraDao();

        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario("MantenimientoProductos");
        Insertar.setAccion("Insertar");
        Insertar.setCodigoAplicacion("3000");
        Insertar.setId_Usuario(Login.usuarioComercial);

        try {
            BitacoraDAO.insert(Insertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenadoDeTablas();
        limpiar();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String valor = txt_combox.getSelectedItem().toString();
        int valorint = Integer.parseInt(valor);
        ProductoDAO perfilDAO = new ProductoDAO();
        Producto perfilconsultar = new Producto();
        perfilconsultar.setPK_id_producto(valorint);
        perfilconsultar = perfilDAO.query(perfilconsultar);
        if (perfilconsultar.getPK_id_producto() != 0) {
            estadovalidacion = 1;
            txtProducto.setText(perfilconsultar.getNombre_producto());
            txtDetalle.setText(perfilconsultar.getDescripcion_producto());
            txtfecha.setText(perfilconsultar.getFechaIngreso());

        } else {

            estadovalidacion = 0;
        }

        BitacoraDao BitacoraDAO = new BitacoraDao();

        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario(Login.usuarioComercial);
        Insertar.setAccion("Buscar");

        Insertar.setCodigoAplicacion("3007");
        Insertar.setModulo("3000");
        try {
            BitacoraDAO.insert(Insertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
         limpiar();
         llenadoDeTablas();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txt_comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_comboxActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_comboxActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
     ProcesoProductoDAO productoDAO = new ProcesoProductoDAO();
        ProcesoProducto productoAEliminar = new ProcesoProducto();
        productoAEliminar.setPK_id_procesoproducto(Integer.parseInt(txt_combox.getItemAt(0)));
        productoDAO.delete(productoAEliminar);
        JOptionPane.showMessageDialog(null, "Registro Eliminado.");

        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario("ProcesoBodega");
        Insertar.setAccion("Modificar");
        Insertar.setCodigoAplicacion("3010");
        try {
            BitacoraDAO.insert(Insertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }

        llenadoDeTablas();
        limpiar();


    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProducto;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDetalle;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JComboBox<String> txt_combox;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtsalida;
    // End of variables declaration//GEN-END:variables

    private void productoAInsertar1(String txtcombox) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
