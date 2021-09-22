/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.vista;


import java.io.File;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.Objects;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.view.JasperViewer;
import seguridad.datos.BitacoraDao;
import seguridad.datos.Conexion;
import seguridad.dominio.Usuario;
import seguridad.datos.UsuarioDAO;
import seguridad.datos.Hash;
import static seguridad.datos.Hash.getHash;
import seguridad.dominio.Bitacora;

/**
 *
 * @author OtakuGT
 */
public class Mantenimiento_Usuario extends javax.swing.JInternalFrame {

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("User");
        modelo.addColumn("Password");
        modelo.addColumn("Correo");
        modelo.addColumn("Cambio Contraseña");
        modelo.addColumn("Estado");
        modelo.addColumn("Ultima Conexion");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.select();
        Tabla.setModel(modelo);
        Object[] objeto = new Object[9];
        for (int i = 0; i < usuarios.size(); i++) {
            objeto[0] = usuarios.get(i).getId_usuario();
            objeto[1] = usuarios.get(i).getNombre_usuario();
            objeto[2] = usuarios.get(i).getApellido_usuario();
            objeto[3] = usuarios.get(i).getUser_usuario();
            objeto[4] = usuarios.get(i).getPassword_usuario();
            objeto[5] = usuarios.get(i).getCorreo_usuario();
            objeto[6] = usuarios.get(i).getCambio_password();
            objeto[7] = usuarios.get(i).getEstado_usuario();
            objeto[8] = usuarios.get(i).getUltima_conexion();

            modelo.addRow(objeto);
        }
    }

    /**
     * Creates new form FrmCrudUsuarios
     */
    void habilitarAcciones() {

        var codigoAplicacion = 10;
        var usuario = Login.usuarioSesion;

        BtnIng.setEnabled(false);
        BtnMod.setEnabled(false);
        BtnElim.setEnabled(false);
        BtnBus.setEnabled(false);

        GenerarPermisos permisos = new GenerarPermisos();

        String[] permisosApp = new String[5];

        for (int i = 0; i < 5; i++) {
            permisosApp[i] = permisos.getAccionesAplicacion(codigoAplicacion, usuario)[i];
        }

        if (permisosApp[0].equals("1")) {
            BtnIng.setEnabled(true);
        }
        if (permisosApp[1].equals("1")) {
            BtnBus.setEnabled(true);
        }
        if (permisosApp[2].equals("1")) {
            BtnMod.setEnabled(true);
        }
        if (permisosApp[3].equals("1")) {
            BtnElim.setEnabled(true);
        }
    }

    public Mantenimiento_Usuario() {
        initComponents();
       // habilitarAcciones();
        llenadoDeTablas();
    }

    public void limpiar() {
        txtID.setText("");
        txtNom.setText("");
        txtApe.setText("");
        txtUsuario.setText("");
        txtPass.setText("");
        txtCorreo.setText("");
        RBCC1.setSelected(false);
        RBCC0.setSelected(false);
        RBEU1.setSelected(false);
        RBEU0.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGCambiarContrasena = new javax.swing.ButtonGroup();
        BtnGEstadoUs = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtApe = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        RBCC1 = new javax.swing.JRadioButton();
        RBCC0 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        RBEU1 = new javax.swing.JRadioButton();
        RBEU0 = new javax.swing.JRadioButton();
        BtnIng = new javax.swing.JButton();
        BtnMod = new javax.swing.JButton();
        BtnElim = new javax.swing.JButton();
        BtnBus = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        BtnAyuda = new javax.swing.JButton();
        BtnRep = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Usuarios");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("ID Usuario");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Password");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar contraseña"));

        BtnGCambiarContrasena.add(RBCC1);
        RBCC1.setText("Activado");

        BtnGCambiarContrasena.add(RBCC0);
        RBCC0.setText("Desactivado");
        RBCC0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBCC0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(RBCC1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RBCC0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBCC1)
                    .addComponent(RBCC0))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado usuario"));

        BtnGEstadoUs.add(RBEU1);
        RBEU1.setText("Habilitado");

        BtnGEstadoUs.add(RBEU0);
        RBEU0.setText("Deshabilitado");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(RBEU1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBEU0)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBEU1)
                    .addComponent(RBEU0))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        BtnIng.setText("Ingresar");
        BtnIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngActionPerformed(evt);
            }
        });

        BtnMod.setText("Modificar");
        BtnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModActionPerformed(evt);
            }
        });

        BtnElim.setText("Eliminar");
        BtnElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnElimActionPerformed(evt);
            }
        });

        BtnBus.setText("Buscar");
        BtnBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBusActionPerformed(evt);
            }
        });

        jLabel5.setText("Usuario");

        jLabel6.setText("Correo");

        BtnAyuda.setText("?");
        BtnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAyudaActionPerformed(evt);
            }
        });

        BtnRep.setText("Reporte");
        BtnRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo)
                    .addComponent(txtUsuario)
                    .addComponent(txtID)
                    .addComponent(txtNom)
                    .addComponent(txtApe)
                    .addComponent(txtPass))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnAyuda)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnIng, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnMod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnElim, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnBus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnRep, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnBus, BtnElim, BtnIng, BtnMod});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BtnAyuda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnIng)
                    .addComponent(BtnMod)
                    .addComponent(BtnElim)
                    .addComponent(BtnBus)
                    .addComponent(BtnRep)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnBus, BtnElim, BtnIng, BtnMod});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String last_session = null;
    Date date = new Date();
    DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private void BtnBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBusActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        
        AInsertar.setId_Usuario(Login.usuarioSesion);
        AInsertar.setAccion("Buscar");
        AInsertar.setCodigoAplicacion("10");
        AInsertar.setModulo("0");
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mantenimiento_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Usuario usuarioBuscar = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String ID = txtID.getText();
        int IntID = Integer.parseInt(ID);
        usuarioBuscar.setId_usuario(IntID);

        usuarioBuscar = usuarioDAO.query2(usuarioBuscar);

        txtID.setText(String.valueOf(usuarioBuscar.getId_usuario()));
        txtNom.setText(String.valueOf(usuarioBuscar.getNombre_usuario()));
        txtApe.setText(String.valueOf(usuarioBuscar.getApellido_usuario()));
        txtUsuario.setText(String.valueOf(usuarioBuscar.getUser_usuario()));
        txtPass.setText(String.valueOf(usuarioBuscar.getPassword_usuario()));
        txtCorreo.setText(String.valueOf(usuarioBuscar.getCorreo_usuario()));

        if (usuarioBuscar.getEstado_usuario() == 1) {
            RBCC1.setSelected(true);
        }
        if (usuarioBuscar.getEstado_usuario() == 0) {
            RBCC0.setSelected(true);
        }
        if (usuarioBuscar.getEstado_usuario() == 1) {
            RBEU1.setSelected(true);
        }
        if (usuarioBuscar.getEstado_usuario() == 0) {
            RBEU0.setSelected(true);
        }
        last_session = usuarioBuscar.getUltima_conexion();
        {
        }
        llenadoDeTablas();
    }//GEN-LAST:event_BtnBusActionPerformed

    private void BtnElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnElimActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        
        AInsertar.setId_Usuario(Login.usuarioSesion);
        AInsertar.setAccion("Eliminar");
        AInsertar.setCodigoAplicacion("10");
        AInsertar.setModulo("0");
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mantenimiento_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Usuario usuarioEliminar = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        String ID = txtID.getText();
        int IntID = Integer.parseInt(ID);
        usuarioEliminar.setId_usuario(IntID);
        usuarioDAO.delete(usuarioEliminar);
        JOptionPane.showMessageDialog(null, "Usuario Eliminado.");
        llenadoDeTablas();
        limpiar();
    }//GEN-LAST:event_BtnElimActionPerformed

    private void BtnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        
        AInsertar.setId_Usuario(Login.usuarioSesion);
        AInsertar.setAccion("Modificar");
        AInsertar.setCodigoAplicacion("10");
        AInsertar.setModulo("0");
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mantenimiento_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Usuario usuarioMod = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String ID = txtID.getText();
        int IntID = Integer.parseInt(ID);
        String pass = txtPass.getText();
        String nuevoPass = Hash.sha1(pass);
        usuarioMod.setId_usuario(IntID);
        usuarioMod.setNombre_usuario(txtNom.getText());
        usuarioMod.setApellido_usuario(txtApe.getText());
        usuarioMod.setUser_usuario(txtUsuario.getText());
        usuarioMod.setPassword_usuario(nuevoPass);
        usuarioMod.setCorreo_usuario(txtCorreo.getText());

        if (RBCC1.isSelected()) {
            usuarioMod.setCambio_password(1);
        }
            else if (RBCC0.isSelected()) {
            usuarioMod.setCambio_password(0);
        }
        //
        if (RBEU1.isSelected()) {
            usuarioMod.setEstado_usuario(1);
        }
            else if (RBEU0.isSelected()) {
            usuarioMod.setEstado_usuario(0);
        }
        usuarioMod.setUltima_conexion(last_session);
        usuarioDAO.update(usuarioMod);
        JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        llenadoDeTablas();
    }//GEN-LAST:event_BtnModActionPerformed

    private void BtnIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        
        AInsertar.setId_Usuario(Login.usuarioSesion);
        AInsertar.setAccion("Insertar");
        AInsertar.setCodigoAplicacion("10");
        AInsertar.setModulo("0");
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mantenimiento_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Usuario usuarioInsertar = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        String pass = txtPass.getText();
        if (txtID.getText().length() != 0 && txtNom.getText().length() != 0
                && txtApe.getText().length() != 0 && txtPass.getText().length() != 0 && RBCC1.isSelected()
                || RBCC0.isSelected() && RBEU1.isSelected() || RBEU0.isSelected()) {
            {
                String ID = txtID.getText();
                int IntID = Integer.parseInt(ID);
                String nuevoPass = Hash.sha1(pass);
                usuarioInsertar.setId_usuario(IntID);
                usuarioInsertar.setNombre_usuario(txtNom.getText());
                usuarioInsertar.setApellido_usuario(txtApe.getText());
                usuarioInsertar.setUser_usuario(txtUsuario.getText());
                usuarioInsertar.setPassword_usuario(nuevoPass);
                usuarioInsertar.setCorreo_usuario(txtCorreo.getText());
                if (RBCC1.isSelected()) {
                    usuarioInsertar.setCambio_password(1);
                }
                if (RBCC0.isSelected()) {
                    usuarioInsertar.setCambio_password(0);
                }
                if (RBEU1.isSelected()) {
                    usuarioInsertar.setEstado_usuario(1);
                }
                if (RBCC0.isSelected()) {
                    usuarioInsertar.setEstado_usuario(0);
                }
                usuarioInsertar.setUltima_conexion(fechaHora.format(date));
                {
                    JOptionPane.showMessageDialog(null, "Usuario registrado Exitosamente");
                }
                limpiar();
                llenadoDeTablas();
                usuarioDAO.insert(usuarioInsertar);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            llenadoDeTablas();
        }
        llenadoDeTablas();
    }//GEN-LAST:event_BtnIngActionPerformed

    private void RBCC0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBCC0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBCC0ActionPerformed

    private void BtnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAyudaActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        
        AInsertar.setId_Usuario(Login.usuarioSesion);
        AInsertar.setAccion("Ayuda");
        AInsertar.setCodigoAplicacion("10");
        AInsertar.setModulo("0");
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mantenimiento_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if ((new File("src\\main\\java\\seguridad\\ayuda\\AyudaMantenimientoUsuarios.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\seguridad\\ayuda\\AyudaMantenimientoUsuarios.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_BtnAyudaActionPerformed
private Connection connection = null;
    private void BtnRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRepActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        
        AInsertar.setId_Usuario(Login.usuarioSesion);
        AInsertar.setAccion("Reporte");
        AInsertar.setCodigoAplicacion("10");
        AInsertar.setModulo("0");
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mantenimiento_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Map p = new HashMap();
//        JasperReport report;
//        JasperPrint print;

        try {
            connection = Conexion.getConnection();
//            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
//                    + "/src/main/java/seguridad/reportes/ReporteMantenimientousuarios.jrxml");
//            print = JasperFillManager.fillReport(report, p, connection);
//            JasperViewer view = new JasperViewer(print, false);
//            view.setTitle("Reporte de Mantenimiento Usuarios");
//            view.setVisible(true);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_BtnRepActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAyuda;
    public javax.swing.JButton BtnBus;
    public javax.swing.JButton BtnElim;
    public javax.swing.ButtonGroup BtnGCambiarContrasena;
    public javax.swing.ButtonGroup BtnGEstadoUs;
    public javax.swing.JButton BtnIng;
    public javax.swing.JButton BtnMod;
    private javax.swing.JButton BtnRep;
    public javax.swing.JRadioButton RBCC0;
    public javax.swing.JRadioButton RBCC1;
    public javax.swing.JRadioButton RBEU0;
    public javax.swing.JRadioButton RBEU1;
    public javax.swing.JTable Tabla;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtNom;
    public javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
