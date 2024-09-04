/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.BDCliente;
import Controlador.BDNiñera;
import Controlador.BDServicio;
import Modelo.Cliente;
import Modelo.Conexion;
import Modelo.Niñera;
import Modelo.Servicio;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bryanbautista
 */
public class Secundaria extends javax.swing.JFrame {
    Conexion conexionSQL;
    BDCliente ModeloCliente;
    BDServicio ModeloServicio;
    
    private Niñera niñera;//alexia
    private Cliente cliente;
    private Servicio servicio;
    
    String Nombre, Domicilio, Telefono;
    String Buscar, IDNiñera, IDCliente, FechaInicio, HoraInicio, HoraFinal, TipoServicio, TarifaHora, Descripcion;
      
    public Secundaria() {
        
    }
    
    public Secundaria(Niñera mensaje) {
        initComponents();
        setLocation(100, 100);
        conexionSQL = new Conexion();
        ModeloCliente = new BDCliente(conexionSQL.getConexion());
        ModeloServicio = new BDServicio(conexionSQL.getConexion());
        cajaNiñeraR.setEditable(false);
        this.niñera = mensaje;
        Recuperar();
    }
    
    public void Recuperar(){
        cajaNiñeraR.setText(niñera.getNombre());
    }
    
    public void LimpiarCajasAgenda(){
        cajaNombreA.setText("");
        cajaDomicilioA.setText("");
    }
    
    public void LimpiarCajasAgendaTodo(){  
        fechaServicioA.setDate(null);
        cajaTarifaA.setText("");
        comboInicioA.setSelectedItem("06:00 AM");
        comboFinalA.setSelectedItem("06:00 AM");
        comboTipoServicioA.setSelectedItem("Servicio fijo");
        cajaDescripcionA.setText("");
        cajaNumeroA.setText("");
        cajaNombreA.setText("");
        cajaDomicilioA.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        botonBuscarR = new javax.swing.JButton();
        signoPrecio = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cajaTarifaA = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        comboFinalA = new javax.swing.JComboBox<>();
        fechaServicioA = new com.toedter.calendar.JDateChooser();
        botonGuardarR = new javax.swing.JButton();
        botonEditarR = new javax.swing.JButton();
        cajaNiñeraR = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        comboInicioA = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        cajaDescripcionA = new javax.swing.JTextArea();
        cajaNumeroA = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cajaNombreA = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cajaDomicilioA = new javax.swing.JTextField();
        comboTipoServicioA = new javax.swing.JComboBox<>();
        botonLimpiarA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonBuscarR.setBackground(new java.awt.Color(204, 255, 204));
        botonBuscarR.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonBuscarR.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        botonBuscarR.setBorder(null);
        botonBuscarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarRActionPerformed(evt);
            }
        });
        jPanel2.add(botonBuscarR, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 30, 30));

        signoPrecio.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        signoPrecio.setText("$");
        jPanel2.add(signoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 10, 30));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel14.setText("Agendar");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        cajaTarifaA.setBackground(new java.awt.Color(237, 243, 255));
        cajaTarifaA.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        cajaTarifaA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaTarifaA.setBorder(null);
        jPanel2.add(cajaTarifaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 80, 30));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel19.setText("Tarifa/hora");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel20.setText("Descripcion");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel22.setText("Horario");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel37.setBackground(new java.awt.Color(0, 0, 0));
        jLabel37.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel37.setText("Fecha de servicio");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        comboFinalA.setBackground(new java.awt.Color(237, 243, 255));
        comboFinalA.setForeground(new java.awt.Color(102, 102, 102));
        comboFinalA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "06:00 AM", "07:00 AM", "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM", "10:00 PM", "11:00 PM", "12:00 AM", "01:00 AM", "02:00 AM", "03:00 AM", "04:00 AM", "05:00 AM" }));
        comboFinalA.setBorder(null);
        jPanel2.add(comboFinalA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 100, 30));

        fechaServicioA.setBackground(new java.awt.Color(237, 243, 255));
        jPanel2.add(fechaServicioA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 150, 30));

        botonGuardarR.setBackground(new java.awt.Color(102, 0, 204));
        botonGuardarR.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        botonGuardarR.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardarR.setText("Crear servicio");
        botonGuardarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarRActionPerformed(evt);
            }
        });
        jPanel2.add(botonGuardarR, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, 140, 40));

        botonEditarR.setBackground(new java.awt.Color(102, 0, 204));
        botonEditarR.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        botonEditarR.setForeground(new java.awt.Color(255, 255, 255));
        botonEditarR.setText("Cancelar");
        botonEditarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarRActionPerformed(evt);
            }
        });
        jPanel2.add(botonEditarR, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 120, 40));

        cajaNiñeraR.setBackground(new java.awt.Color(204, 255, 204));
        cajaNiñeraR.setForeground(new java.awt.Color(102, 102, 102));
        cajaNiñeraR.setBorder(null);
        jPanel2.add(cajaNiñeraR, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 230, 30));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel23.setText("Niñera seleccionada");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel24.setText("a");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel25.setText("Tipo de servicio");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        comboInicioA.setBackground(new java.awt.Color(237, 243, 255));
        comboInicioA.setForeground(new java.awt.Color(102, 102, 102));
        comboInicioA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "06:00 AM", "07:00 AM", "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM", "10:00 PM", "11:00 PM", "12:00 AM", "01:00 AM", "02:00 AM", "03:00 AM", "04:00 AM", "05:00 AM" }));
        comboInicioA.setBorder(null);
        jPanel2.add(comboInicioA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 100, 30));

        cajaDescripcionA.setBackground(new java.awt.Color(237, 243, 255));
        cajaDescripcionA.setColumns(20);
        cajaDescripcionA.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaDescripcionA.setForeground(new java.awt.Color(102, 102, 102));
        cajaDescripcionA.setRows(5);
        cajaDescripcionA.setBorder(null);
        jScrollPane1.setViewportView(cajaDescripcionA);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 290, 50));

        cajaNumeroA.setBackground(new java.awt.Color(204, 255, 204));
        cajaNumeroA.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaNumeroA.setForeground(new java.awt.Color(102, 102, 102));
        cajaNumeroA.setBorder(null);
        jPanel2.add(cajaNumeroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 160, 30));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("Numero del cliente");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("Nombre");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        cajaNombreA.setBackground(new java.awt.Color(237, 243, 255));
        cajaNombreA.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaNombreA.setForeground(new java.awt.Color(102, 102, 102));
        cajaNombreA.setBorder(null);
        jPanel2.add(cajaNombreA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 290, 30));

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel26.setText("Domicilio");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        cajaDomicilioA.setBackground(new java.awt.Color(237, 243, 255));
        cajaDomicilioA.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaDomicilioA.setForeground(new java.awt.Color(102, 102, 102));
        cajaDomicilioA.setBorder(null);
        jPanel2.add(cajaDomicilioA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 290, 30));

        comboTipoServicioA.setBackground(new java.awt.Color(237, 243, 255));
        comboTipoServicioA.setForeground(new java.awt.Color(102, 102, 102));
        comboTipoServicioA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Servicio fijo", "Servicio ocasional" }));
        comboTipoServicioA.setBorder(null);
        jPanel2.add(comboTipoServicioA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 150, 30));

        botonLimpiarA.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        botonLimpiarA.setForeground(new java.awt.Color(255, 255, 255));
        botonLimpiarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        botonLimpiarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarAActionPerformed(evt);
            }
        });
        jPanel2.add(botonLimpiarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 30, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 332, 639));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
      
    }//GEN-LAST:event_jPanel2MouseClicked

    private void botonEditarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarRActionPerformed
        Principal ventanaP = new Principal();
        ventanaP.setVisible(true);

        dispose();
    }//GEN-LAST:event_botonEditarRActionPerformed

    private void botonGuardarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarRActionPerformed
                  
   if(fechaServicioA.getDate() == null || cajaTarifaA.getText().equals("") || comboInicioA.getSelectedItem() == null || comboFinalA.getSelectedItem() == null || comboTipoServicioA.getSelectedItem() == null || cajaDescripcionA.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Faltan datos");
    }else{
        if(cliente == null){ //cuando el cliente no existe
            try {
            //primero creo el cliente
            Nombre = cajaNombreA.getText();
            Domicilio = cajaDomicilioA.getText();
            Telefono = cajaNumeroA.getText();
            
            cliente = new Cliente(Nombre, Domicilio, Telefono);
            ModeloCliente.insertarCliente(cliente); //se creo el registro en base de datos
           
            System.out.println("El numero es: "+Telefono);
            cliente = ModeloCliente.buscarCliente(Telefono);//se debe de recuperar el ID del cliente agregadado y buscado por su telefono
            
            System.out.println("El id del clientes es: "+cliente.getID());
            System.out.println("El nombre del clientes es: "+cliente.getNombre());
            System.out.println("El domicilio del clientes es: "+cliente.getDomicilio());
            System.out.println("El telefono del clientes es: "+cliente.getTelefono());  
            
            IDCliente = String.valueOf(cliente.getID());
            
            Date fechaEntrada = fechaServicioA.getDate();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String entrada = formatoFecha.format(fechaEntrada);
            FechaInicio = entrada;
            HoraInicio = comboInicioA.getSelectedItem().toString();
            HoraFinal = comboFinalA.getSelectedItem().toString();
            TipoServicio = comboTipoServicioA.getSelectedItem().toString();
            TarifaHora = cajaTarifaA.getText();
            Descripcion = cajaDescripcionA.getText();
            
            servicio = new Servicio(niñera.getID(), Integer.parseInt(IDCliente), FechaInicio, HoraInicio, HoraFinal, TipoServicio, TarifaHora, Descripcion);
            ModeloServicio.insertarServicio(servicio);
            JOptionPane.showMessageDialog(null, "Servicio registrado");
            
            Principal ventanaP = new Principal();
                ventanaP.setVisible(true);
            dispose();
            
            } catch (SQLException ex) {
                Logger.getLogger(Secundaria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                Date fechaEntrada = fechaServicioA.getDate();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                String entrada = formatoFecha.format(fechaEntrada);
                FechaInicio = entrada;
                HoraInicio = comboInicioA.getSelectedItem().toString();
                HoraFinal = comboFinalA.getSelectedItem().toString();
                TipoServicio = comboTipoServicioA.getSelectedItem().toString();
                TarifaHora = cajaTarifaA.getText();
                Descripcion = cajaDescripcionA.getText();
                
                servicio = new Servicio(niñera.getID(), cliente.getID(), FechaInicio, HoraInicio, HoraFinal, TipoServicio, TarifaHora, Descripcion);
                ModeloServicio.insertarServicio(servicio);
                JOptionPane.showMessageDialog(null, "Servicio registrado");
                
                Principal ventanaP = new Principal();
                ventanaP.setVisible(true);

                dispose();
                
            } catch (SQLException ex) {
                Logger.getLogger(Secundaria.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    }//GEN-LAST:event_botonGuardarRActionPerformed

    private void botonBuscarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarRActionPerformed
        if(cajaNumeroA.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No has buscado nada");   
            LimpiarCajasAgenda();
        }else{         
            try {
                Buscar = cajaNumeroA.getText();
                cliente = ModeloCliente.buscarCliente(Buscar); 
                
                if(cliente!=null){
                    System.out.println("El id cliente es: " + cliente.getID());
                    cajaNombreA.setText(cliente.getNombre());
                    cajaDomicilioA.setText(cliente.getDomicilio());
                }else {
                    JOptionPane.showMessageDialog(null, "El cliente no existe");
                    LimpiarCajasAgenda();
                } 
                
            } catch (SQLException ex) {
                Logger.getLogger(Secundaria.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
    }//GEN-LAST:event_botonBuscarRActionPerformed

    private void botonLimpiarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarAActionPerformed
        LimpiarCajasAgendaTodo();
    }//GEN-LAST:event_botonLimpiarAActionPerformed

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
            java.util.logging.Logger.getLogger(Secundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Secundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Secundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Secundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Secundaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarR;
    private javax.swing.JButton botonEditarR;
    private javax.swing.JButton botonGuardarR;
    private javax.swing.JButton botonLimpiarA;
    private javax.swing.JTextArea cajaDescripcionA;
    private javax.swing.JTextField cajaDomicilioA;
    private javax.swing.JTextField cajaNiñeraR;
    private javax.swing.JTextField cajaNombreA;
    private javax.swing.JTextField cajaNumeroA;
    private javax.swing.JTextField cajaTarifaA;
    private javax.swing.JComboBox<String> comboFinalA;
    private javax.swing.JComboBox<String> comboInicioA;
    private javax.swing.JComboBox<String> comboTipoServicioA;
    private com.toedter.calendar.JDateChooser fechaServicioA;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel signoPrecio;
    // End of variables declaration//GEN-END:variables
}
