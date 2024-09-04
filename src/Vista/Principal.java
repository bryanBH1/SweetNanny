package Vista;

import Controlador.BDCliente;
import Controlador.BDNiñera;
import Controlador.BDServicio;
import Modelo.Cliente;
import Modelo.Conexion;
import Modelo.Niñera;
import Modelo.Servicio;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    Conexion conexionSQL;
    BDNiñera ModeloNiñera;
    BDCliente ModeloCliente;
    BDServicio ModeloServicio;

    private Niñera niñera;
    private Cliente cliente;
    private Servicio servicio;

    private ArrayList<Niñera> niñeras;
    private ArrayList<Servicio> servicios;

    String Nombre, Edad, Estudios, Experiencia, Disponibilidad, ZonasTrabajo, Cursos, Cualidades, Buscar;
    int IDniñeraActual;
    String IDNiñera, IDCliente, FechaInicio, HoraInicio, HoraFinal, TipoServicio, TarifaHora, Descripcion;

    public void LimpiarNiñera() {
        cajaBuscarN.setText("");
        cajaNombreN.setText("");
        cajaEdadN.setText("");
        cajaEstudiosN.setText("");
        cajaDisponibilidadN.setText("");
        cajaZonaN.setText("");
        cajaCursosN.setText("");
        cajaAñosN.setText("");
        cajaCualidadesN.setText("");

    }

    public void BuscarNiñera(String Buscar) {
        try {
            niñera = ModeloNiñera.buscarNiñera(Buscar);

            IDniñeraActual = niñera.getID();
            System.out.println("El id de la niñera es: " + IDniñeraActual);
            cajaNombreN.setText(niñera.getNombre());
            cajaEdadN.setText(String.valueOf(niñera.getEdad()));
            cajaEstudiosN.setText(niñera.getEstudios());
            cajaDisponibilidadN.setText(niñera.getDisponibilidad());
            cajaZonaN.setText(niñera.getZonasTrabajo());
            cajaCursosN.setText(niñera.getCursos());
            cajaAñosN.setText(String.valueOf(niñera.getExperiencia()));
            cajaCualidadesN.setText(niñera.getCualidades());
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void MostrarServicio() {
        for (Servicio servicio : servicios) {
            System.out.println("Servicio ID: " + servicio.getID());
            System.out.println("Cliente ID: " + servicio.getIDCliente());
            System.out.println("Niñera ID: " + servicio.getIDNiñera());
            System.out.println("Fecha de Inicio: " + servicio.getFechaInicio());
            System.out.println("Hora de Inicio: " + servicio.getHoraInicio());
            System.out.println("Hora Final: " + servicio.getHoraFinal());
            System.out.println("Tipo de Servicio: " + servicio.getTipoServicio());
            System.out.println("Tarifa por Hora: " + servicio.getTarifaHora());
            System.out.println("Descripción: " + servicio.getDescripcion());
            System.out.println("--------------------------------------");
        }
    }

    public void BuscarServicios() throws SQLException {
        for (Servicio servicio : servicios) {
            if (servicio.getFechaInicio().equals(comboFechaS.getSelectedItem().toString())) {
                this.servicio = servicio; //almacenamos el servicio encontrado
                cajaTarifaS.setText(servicio.getTarifaHora());
                comboInicioS.setSelectedItem(servicio.getHoraInicio());
                comboFinalS.setSelectedItem(servicio.getHoraFinal());
                comboTipoServicioS.setSelectedItem(servicio.getTipoServicio());
                cajaDescripcionS.setText(servicio.getDescripcion());
                cliente = ModeloCliente.buscarClienteID(servicio.getIDCliente());
                if (cliente != null) {
                    cajaNombreS.setText(cliente.getNombre());
                    cajaNumeroS.setText(cliente.getTelefono());
                    cajaDomicilioS.setText(cliente.getDomicilio());
                }
                niñera = ModeloNiñera.buscarNiñeraID(servicio.getIDNiñera());
                if (niñera != null) {
                    cajaNiñeraS.setText(niñera.getNombre());
                }

            }
        }
    }

    public void fechaHoy() {
        Date fechaActual = new Date();
        fechaServicioS.setDate(fechaActual);
    }

    public void LimpiarHistorial() {
        comboFechaS.removeAllItems();
        cajaBuscarS.setText("");
        cajaNombreS.setText("");
        cajaNumeroS.setText("");
        cajaDomicilioS.setText("");
        cajaNiñeraS.setText("");
        cajaTarifaS.setText("");
        comboInicioS.setSelectedItem("06:00 AM");
        comboFinalS.setSelectedItem("06:00 AM");
        comboTipoServicioS.setSelectedItem("Servicio fijo");
        cajaDescripcionS.setText("");
        fechaHoy();
    }

    public void BloquearCajas() {
        cajaNombreS.setEditable(false);
        cajaNumeroS.setEditable(false);
        cajaDomicilioS.setEditable(false);
        cajaNiñeraS.setEditable(false);

    }

    public void DesbloquearCajas() {
        fechaServicioS.setEnabled(true);;
        cajaTarifaS.setEditable(true);
        comboInicioS.setEnabled(true);
        comboFinalS.setEnabled(true);
        comboTipoServicioS.setEnabled(true);
        cajaDescripcionS.setEditable(true);
    }

    public void BloquearCajasNiñera() {
        cajaNombreN.setEditable(false);
        cajaEdadN.setEditable(false);
        cajaEstudiosN.setEditable(false);
        cajaAñosN.setEditable(false);
        cajaDisponibilidadN.setEditable(false);
        cajaZonaN.setEditable(false);
        cajaCursosN.setEditable(false);
        cajaCualidadesN.setEditable(false);

    }

    public void DesbloquearCajasNiñera() {
        cajaNombreN.setEditable(true);
        cajaEdadN.setEditable(true);
        cajaEstudiosN.setEditable(true);
        cajaAñosN.setEditable(true);
        cajaDisponibilidadN.setEditable(true);
        cajaZonaN.setEditable(true);
        cajaCursosN.setEditable(true);
        cajaCualidadesN.setEditable(true);

    }

    public Principal() {
        initComponents();
        setLocation(100, 100);
        conexionSQL = new Conexion();
        ModeloNiñera = new BDNiñera(conexionSQL.getConexion());
        ModeloCliente = new BDCliente(conexionSQL.getConexion());
        ModeloServicio = new BDServicio(conexionSQL.getConexion());

        botonReservarN.setVisible(false);
        botonEditarN.setVisible(false);
        botonEliminarN.setVisible(false);
        botonGuardarH.setVisible(false);
        botonCancelarH.setVisible(false);
        botonCancelarN.setVisible(false);
        botonGuardarN.setVisible(false);

        BloquearCajas();
        fechaHoy();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        botonBuscarC = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cajaEdadN = new javax.swing.JTextField();
        cajaEstudiosN = new javax.swing.JTextField();
        cajaDisponibilidadN = new javax.swing.JTextField();
        cajaBuscarN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        botonReservarN = new javax.swing.JButton();
        botonEliminarN = new javax.swing.JButton();
        botonNuevoN = new javax.swing.JButton();
        botonEditarN = new javax.swing.JButton();
        cajaNombreN = new javax.swing.JTextField();
        cajaZonaN = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cajaCursosN = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cajaCualidadesN = new javax.swing.JTextArea();
        cajaAñosN = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        comboNiñeraN = new javax.swing.JComboBox<>();
        botonCancelarN = new javax.swing.JButton();
        botonGuardarN = new javax.swing.JButton();
        botonLimpiarN = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        botonEditarH = new javax.swing.JButton();
        botonGuardarH = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cajaBuscarS = new javax.swing.JTextField();
        botonRenovarS = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        comboFechaS = new javax.swing.JComboBox<>();
        cajaNombreS = new javax.swing.JTextField();
        cajaDomicilioS = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cajaNumeroS = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        signoPrecio = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        textoRenovar = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        comboFinalS = new javax.swing.JComboBox<>();
        fechaServicioS = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        comboInicioS = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        cajaDescripcionS = new javax.swing.JTextArea();
        cajaTarifaS = new javax.swing.JTextField();
        botonBuscarS = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        cajaNiñeraS = new javax.swing.JTextField();
        comboTipoServicioS = new javax.swing.JComboBox<>();
        botonCancelarH = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        botonLimpiarA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setAlignmentX(0.0F);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonBuscarC.setBackground(new java.awt.Color(237, 243, 255));
        botonBuscarC.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonBuscarC.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        botonBuscarC.setBorder(null);
        botonBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarCActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 30, 30));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Buscar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 8, 50, 30));

        cajaEdadN.setBackground(new java.awt.Color(237, 243, 255));
        cajaEdadN.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaEdadN.setForeground(new java.awt.Color(102, 102, 102));
        cajaEdadN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaEdadN.setBorder(null);
        jPanel1.add(cajaEdadN, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 40, 30));

        cajaEstudiosN.setBackground(new java.awt.Color(237, 243, 255));
        cajaEstudiosN.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaEstudiosN.setForeground(new java.awt.Color(102, 102, 102));
        cajaEstudiosN.setBorder(null);
        jPanel1.add(cajaEstudiosN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 190, 30));

        cajaDisponibilidadN.setBackground(new java.awt.Color(237, 243, 255));
        cajaDisponibilidadN.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaDisponibilidadN.setForeground(new java.awt.Color(102, 102, 102));
        cajaDisponibilidadN.setBorder(null);
        jPanel1.add(cajaDisponibilidadN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 290, 30));

        cajaBuscarN.setBackground(new java.awt.Color(237, 243, 255));
        cajaBuscarN.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaBuscarN.setForeground(new java.awt.Color(102, 102, 102));
        cajaBuscarN.setBorder(null);
        cajaBuscarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaBuscarNActionPerformed(evt);
            }
        });
        jPanel1.add(cajaBuscarN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 130, 30));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Edad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("Estudios");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("Disponibilidad");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel8.setText("Niñera");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        botonReservarN.setBackground(new java.awt.Color(102, 0, 204));
        botonReservarN.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        botonReservarN.setForeground(new java.awt.Color(255, 255, 255));
        botonReservarN.setText("Reservar");
        botonReservarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReservarNActionPerformed(evt);
            }
        });
        jPanel1.add(botonReservarN, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 110, 40));

        botonEliminarN.setBackground(new java.awt.Color(102, 0, 204));
        botonEliminarN.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        botonEliminarN.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminarN.setText("Eliminar");
        botonEliminarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarNActionPerformed(evt);
            }
        });
        jPanel1.add(botonEliminarN, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 550, 90, 40));

        botonNuevoN.setBackground(new java.awt.Color(102, 0, 204));
        botonNuevoN.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        botonNuevoN.setForeground(new java.awt.Color(255, 255, 255));
        botonNuevoN.setText("Nuevo");
        botonNuevoN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoNActionPerformed(evt);
            }
        });
        jPanel1.add(botonNuevoN, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 80, 40));

        botonEditarN.setBackground(new java.awt.Color(102, 0, 204));
        botonEditarN.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        botonEditarN.setForeground(new java.awt.Color(255, 255, 255));
        botonEditarN.setText("Editar");
        botonEditarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarNActionPerformed(evt);
            }
        });
        jPanel1.add(botonEditarN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 80, 40));

        cajaNombreN.setBackground(new java.awt.Color(204, 255, 204));
        cajaNombreN.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaNombreN.setForeground(new java.awt.Color(102, 102, 102));
        cajaNombreN.setBorder(null);
        jPanel1.add(cajaNombreN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 240, 30));

        cajaZonaN.setBackground(new java.awt.Color(237, 243, 255));
        cajaZonaN.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaZonaN.setForeground(new java.awt.Color(102, 102, 102));
        cajaZonaN.setBorder(null);
        jPanel1.add(cajaZonaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 290, 30));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel24.setText("Zona de trabajo");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel26.setText("Cursos tomados");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        cajaCursosN.setBackground(new java.awt.Color(237, 243, 255));
        cajaCursosN.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaCursosN.setForeground(new java.awt.Color(102, 102, 102));
        cajaCursosN.setBorder(null);
        jPanel1.add(cajaCursosN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 290, 30));

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel28.setText("Cualidades");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        cajaCualidadesN.setBackground(new java.awt.Color(237, 243, 255));
        cajaCualidadesN.setColumns(20);
        cajaCualidadesN.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaCualidadesN.setForeground(new java.awt.Color(102, 102, 102));
        cajaCualidadesN.setRows(5);
        cajaCualidadesN.setBorder(null);
        jScrollPane1.setViewportView(cajaCualidadesN);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 290, 70));

        cajaAñosN.setBackground(new java.awt.Color(237, 243, 255));
        cajaAñosN.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaAñosN.setForeground(new java.awt.Color(102, 102, 102));
        cajaAñosN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaAñosN.setBorder(null);
        jPanel1.add(cajaAñosN, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 70, 30));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel27.setText("Años de exp.");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel23.setText("Coincidencias");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        comboNiñeraN.setBackground(new java.awt.Color(237, 243, 255));
        comboNiñeraN.setForeground(new java.awt.Color(102, 102, 102));
        comboNiñeraN.setBorder(null);
        comboNiñeraN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNiñeraNActionPerformed(evt);
            }
        });
        jPanel1.add(comboNiñeraN, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 250, 30));

        botonCancelarN.setBackground(new java.awt.Color(102, 0, 204));
        botonCancelarN.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        botonCancelarN.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelarN.setText("Cancelar");
        botonCancelarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarNActionPerformed(evt);
            }
        });
        jPanel1.add(botonCancelarN, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, -1, 40));

        botonGuardarN.setBackground(new java.awt.Color(102, 0, 204));
        botonGuardarN.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        botonGuardarN.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardarN.setText("Guardar");
        botonGuardarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarNActionPerformed(evt);
            }
        });
        jPanel1.add(botonGuardarN, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, -1, 40));

        botonLimpiarN.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        botonLimpiarN.setForeground(new java.awt.Color(255, 255, 255));
        botonLimpiarN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        botonLimpiarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarNActionPerformed(evt);
            }
        });
        jPanel1.add(botonLimpiarN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        jTabbedPane1.addTab("Buscar Niñera", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setBackground(new java.awt.Color(0, 0, 0));
        jLabel49.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel49.setText("Servicio");
        jPanel3.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        botonEditarH.setBackground(new java.awt.Color(102, 0, 204));
        botonEditarH.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonEditarH.setForeground(new java.awt.Color(255, 255, 255));
        botonEditarH.setText("Editar");
        botonEditarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarHActionPerformed(evt);
            }
        });
        jPanel3.add(botonEditarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 130, 40));

        botonGuardarH.setBackground(new java.awt.Color(102, 0, 204));
        botonGuardarH.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonGuardarH.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardarH.setText("Actualizar");
        botonGuardarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarHActionPerformed(evt);
            }
        });
        jPanel3.add(botonGuardarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 140, 40));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Buscar");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 8, 50, 30));

        cajaBuscarS.setBackground(new java.awt.Color(237, 243, 255));
        cajaBuscarS.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaBuscarS.setForeground(new java.awt.Color(102, 102, 102));
        cajaBuscarS.setBorder(null);
        cajaBuscarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaBuscarSActionPerformed(evt);
            }
        });
        jPanel3.add(cajaBuscarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 130, 30));

        botonRenovarS.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonRenovarS.setForeground(new java.awt.Color(255, 255, 255));
        botonRenovarS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/restart2.png"))); // NOI18N
        botonRenovarS.setBorder(null);
        botonRenovarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRenovarSActionPerformed(evt);
            }
        });
        jPanel3.add(botonRenovarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 45, 45));

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel25.setText("Fecha");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        comboFechaS.setBackground(new java.awt.Color(204, 255, 204));
        comboFechaS.setForeground(new java.awt.Color(102, 102, 102));
        comboFechaS.setBorder(null);
        comboFechaS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFechaSActionPerformed(evt);
            }
        });
        jPanel3.add(comboFechaS, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 130, 30));

        cajaNombreS.setBackground(new java.awt.Color(237, 243, 255));
        cajaNombreS.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaNombreS.setForeground(new java.awt.Color(102, 102, 102));
        cajaNombreS.setBorder(null);
        jPanel3.add(cajaNombreS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 150, 30));

        cajaDomicilioS.setBackground(new java.awt.Color(237, 243, 255));
        cajaDomicilioS.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaDomicilioS.setForeground(new java.awt.Color(102, 102, 102));
        cajaDomicilioS.setBorder(null);
        jPanel3.add(cajaDomicilioS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 290, 30));

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel29.setText("Domicilio");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel9.setText("Nombre");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        cajaNumeroS.setBackground(new java.awt.Color(237, 243, 255));
        cajaNumeroS.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaNumeroS.setForeground(new java.awt.Color(102, 102, 102));
        cajaNumeroS.setBorder(null);
        jPanel3.add(cajaNumeroS, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 130, 30));

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel30.setText("Numero");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        signoPrecio.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        signoPrecio.setText("$");
        jPanel3.add(signoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 10, 30));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel19.setText("Tarifa/hora");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, -1, -1));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel20.setText("Descripcion");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        textoRenovar.setBackground(new java.awt.Color(0, 0, 0));
        textoRenovar.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        textoRenovar.setText("Renovar");
        jPanel3.add(textoRenovar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 60, -1));

        jLabel37.setBackground(new java.awt.Color(0, 0, 0));
        jLabel37.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel37.setText("Proxima fecha");
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        comboFinalS.setBackground(new java.awt.Color(237, 243, 255));
        comboFinalS.setForeground(new java.awt.Color(102, 102, 102));
        comboFinalS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "06:00 AM", "07:00 AM", "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM", "10:00 PM", "11:00 PM", "12:00 AM", "01:00 AM", "02:00 AM", "03:00 AM", "04:00 AM", "05:00 AM" }));
        comboFinalS.setBorder(null);
        jPanel3.add(comboFinalS, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 100, 30));

        fechaServicioS.setBackground(new java.awt.Color(237, 243, 255));
        jPanel3.add(fechaServicioS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 190, 30));

        jLabel31.setBackground(new java.awt.Color(0, 0, 0));
        jLabel31.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel31.setText("a");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 10, 30));

        jLabel32.setBackground(new java.awt.Color(0, 0, 0));
        jLabel32.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel32.setText("Tipo de servicio");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        comboInicioS.setBackground(new java.awt.Color(237, 243, 255));
        comboInicioS.setForeground(new java.awt.Color(102, 102, 102));
        comboInicioS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "06:00 AM", "07:00 AM", "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM", "10:00 PM", "11:00 PM", "12:00 AM", "01:00 AM", "02:00 AM", "03:00 AM", "04:00 AM", "05:00 AM" }));
        comboInicioS.setBorder(null);
        jPanel3.add(comboInicioS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, 30));

        cajaDescripcionS.setBackground(new java.awt.Color(237, 243, 255));
        cajaDescripcionS.setColumns(20);
        cajaDescripcionS.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaDescripcionS.setForeground(new java.awt.Color(102, 102, 102));
        cajaDescripcionS.setRows(5);
        cajaDescripcionS.setBorder(null);
        jScrollPane2.setViewportView(cajaDescripcionS);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 200, 50));

        cajaTarifaS.setBackground(new java.awt.Color(237, 243, 255));
        cajaTarifaS.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        cajaTarifaS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaTarifaS.setBorder(null);
        jPanel3.add(cajaTarifaS, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 80, 30));

        botonBuscarS.setBackground(new java.awt.Color(237, 243, 255));
        botonBuscarS.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonBuscarS.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        botonBuscarS.setBorder(null);
        botonBuscarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarSActionPerformed(evt);
            }
        });
        jPanel3.add(botonBuscarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 30, 30));

        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel33.setText("Niñera");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        cajaNiñeraS.setBackground(new java.awt.Color(204, 255, 204));
        cajaNiñeraS.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cajaNiñeraS.setForeground(new java.awt.Color(102, 102, 102));
        cajaNiñeraS.setBorder(null);
        jPanel3.add(cajaNiñeraS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 290, 30));

        comboTipoServicioS.setBackground(new java.awt.Color(237, 243, 255));
        comboTipoServicioS.setForeground(new java.awt.Color(102, 102, 102));
        comboTipoServicioS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Servicio fijo", "Servicio ocasional" }));
        comboTipoServicioS.setBorder(null);
        jPanel3.add(comboTipoServicioS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 170, 30));

        botonCancelarH.setBackground(new java.awt.Color(102, 0, 204));
        botonCancelarH.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonCancelarH.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelarH.setText("Cancelar");
        botonCancelarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarHActionPerformed(evt);
            }
        });
        jPanel3.add(botonCancelarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 140, 40));

        jLabel34.setBackground(new java.awt.Color(0, 0, 0));
        jLabel34.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel34.setText("Horario");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        botonLimpiarA.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        botonLimpiarA.setForeground(new java.awt.Color(255, 255, 255));
        botonLimpiarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clear.png"))); // NOI18N
        botonLimpiarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarAActionPerformed(evt);
            }
        });
        jPanel3.add(botonLimpiarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        jTabbedPane1.addTab("Historial", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 332, 639));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarCActionPerformed
        botonNuevoN.setVisible(false);
        botonReservarN.setVisible(true);
        botonEditarN.setVisible(true);
        botonEliminarN.setVisible(true);
        comboNiñeraN.removeAllItems();

        if (cajaBuscarN.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No has buscado nada");
            LimpiarNiñera();
        } else {
            try {
                Buscar = cajaBuscarN.getText();
                System.out.println("Estas buscando: "+Buscar);
                
                if(niñeras == null){
                    System.out.println("Esta nulo la lista");
                }
                niñeras = ModeloNiñera.buscarNiñeras(Buscar);

                if (!niñeras.isEmpty()) {
                    System.out.println("SOn en total: "+niñeras.size());
                    for (Niñera niñera : niñeras) {
                        comboNiñeraN.addItem(niñera.getNombre());
                        System.out.println("Nombre: "+niñera.getNombre());
                    }
                    BloquearCajasNiñera();
                    cajaBuscarN.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron niñeras");
                    LimpiarNiñera();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botonBuscarCActionPerformed

    private void botonEliminarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarNActionPerformed
        if (!cajaNombreN.getText().equals("") && !cajaEstudiosN.getText().equals("") && !cajaEdadN.getText().equals("") && !cajaAñosN.getText().equals("") && !cajaDisponibilidadN.getText().equals("") && !cajaZonaN.getText().equals("") && !cajaCursosN.getText().equals("") && !cajaCualidadesN.getText().equals("")) {
            try {
                if (IDniñeraActual > 0) {
                    ModeloNiñera.elliminarNiñera(IDniñeraActual);
                    JOptionPane.showMessageDialog(null, "Niñera eliminada");
                    LimpiarNiñera();
                    IDniñeraActual = -1;
                    comboNiñeraN.removeAllItems();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay niñera que eliminar");
        }
    }//GEN-LAST:event_botonEliminarNActionPerformed

    private void botonEditarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarNActionPerformed
        if (cajaNombreN.getText().equals("") && cajaEstudiosN.getText().equals("") && cajaEdadN.getText().equals("") && cajaAñosN.getText().equals("") && cajaDisponibilidadN.getText().equals("") && cajaZonaN.getText().equals("") && cajaCursosN.getText().equals("") && cajaCualidadesN.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No hay niñera que editar");
        } else {
            botonEditarN.setVisible(false);
            botonReservarN.setVisible(false);
            botonEliminarN.setVisible(false);
            
            botonCancelarN.setVisible(true);
            botonGuardarN.setVisible(true);
            DesbloquearCajasNiñera();
        }
    }//GEN-LAST:event_botonEditarNActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked

    }//GEN-LAST:event_jPanel3MouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void botonNuevoNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoNActionPerformed
        if (cajaNombreN.getText().equals("") || cajaEstudiosN.getText().equals("") || cajaEdadN.getText().equals("") || cajaAñosN.getText().equals("") || cajaDisponibilidadN.getText().equals("") || cajaZonaN.getText().equals("") || cajaCursosN.getText().equals("") || cajaCualidadesN.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos");
        } else {
            try {
                Nombre = cajaNombreN.getText();
                Edad = cajaEdadN.getText();
                Estudios = cajaEstudiosN.getText();
                Disponibilidad = cajaDisponibilidadN.getText();
                ZonasTrabajo = cajaZonaN.getText();
                Cursos = cajaCursosN.getText();
                Experiencia = cajaAñosN.getText();
                Cualidades = cajaCualidadesN.getText();

                niñera = new Niñera(Nombre, Integer.parseInt(Edad), Estudios, Disponibilidad, ZonasTrabajo, Cursos, Integer.parseInt(Experiencia), Cualidades);

                ModeloNiñera.insertarNiñera(niñera);
                LimpiarNiñera();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botonNuevoNActionPerformed

    private void botonRenovarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRenovarSActionPerformed
        if (cajaNombreS.getText().equals("") || cajaNumeroS.getText().equals("") || cajaDomicilioS.getText().equals("") || fechaServicioS.getDate() == null || cajaTarifaS.getText().equals("") || comboInicioS.getSelectedItem() == null || comboFinalS.getSelectedItem() == null || comboTipoServicioS.getSelectedItem() == null || cajaDescripcionS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos");
        } else {
            try {
                Date fechaEntrada = fechaServicioS.getDate();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                String entrada = formatoFecha.format(fechaEntrada);

                FechaInicio = entrada;
                HoraInicio = comboInicioS.getSelectedItem().toString();
                HoraFinal = comboFinalS.getSelectedItem().toString();
                TipoServicio = comboTipoServicioS.getSelectedItem().toString();
                TarifaHora = cajaTarifaS.getText();
                Descripcion = cajaDescripcionS.getText();

                servicio = new Servicio(niñera.getID(), cliente.getID(), FechaInicio, HoraInicio, HoraFinal, TipoServicio, TarifaHora, Descripcion);
                ModeloServicio.insertarServicio(servicio);
                JOptionPane.showMessageDialog(null, "Servicio registrado");
                LimpiarHistorial();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_botonRenovarSActionPerformed

    private void botonEditarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarHActionPerformed
        botonRenovarS.setVisible(false);
        textoRenovar.setVisible(false);
        botonBuscarS.setEnabled(false);
        if (cajaNombreS.getText().equals("") || cajaNumeroS.getText().equals("") || cajaDomicilioS.getText().equals("") || fechaServicioS.getDate() == null || cajaTarifaS.getText().equals("") || comboInicioS.getSelectedItem() == null || comboFinalS.getSelectedItem() == null || comboTipoServicioS.getSelectedItem() == null || cajaDescripcionS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecciona un registro");
        } else {
            botonEditarH.setVisible(false);
            botonGuardarH.setVisible(true);
            botonCancelarH.setVisible(true);
            //DesbloquearCajas();
        }

    }//GEN-LAST:event_botonEditarHActionPerformed

    private void botonBuscarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarSActionPerformed
        comboFechaS.removeAllItems();
        if (cajaBuscarS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No has buscado nada");
            LimpiarHistorial();
        } else {
            try {
                Buscar = cajaBuscarS.getText();
                System.out.println("Buscar es: " + Buscar);
                cliente = ModeloCliente.buscarCliente(Buscar);

                if (cliente != null) {
                    System.out.println(cliente.getID());
                    System.out.println(cliente.getNombre());
                    System.out.println(cliente.getDomicilio());
                    System.out.println(cliente.getTelefono());

                    servicios = ModeloServicio.buscarServicios(cliente.getID());
                    MostrarServicio();

                    if (!servicios.isEmpty()) {
                        for (Servicio servicio : servicios) {
                            comboFechaS.addItem(servicio.getFechaInicio());
                        }
                        cajaBuscarS.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron servicios");
                        LimpiarHistorial();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro cliente");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botonBuscarSActionPerformed

    private void comboNiñeraNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNiñeraNActionPerformed
        int elementos = comboNiñeraN.getItemCount();
        if (elementos > 0) {
            Buscar = comboNiñeraN.getSelectedItem().toString();
            BuscarNiñera(Buscar);
        }
    }//GEN-LAST:event_comboNiñeraNActionPerformed

    private void botonReservarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReservarNActionPerformed
        Secundaria ventanaS = new Secundaria(niñera);
        ventanaS.setVisible(true);

        dispose();
    }//GEN-LAST:event_botonReservarNActionPerformed

    private void cajaBuscarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBuscarNActionPerformed

    }//GEN-LAST:event_cajaBuscarNActionPerformed

    private void cajaBuscarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBuscarSActionPerformed

    }//GEN-LAST:event_cajaBuscarSActionPerformed

    private void comboFechaSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFechaSActionPerformed
        int elementos = comboFechaS.getItemCount();
        if (elementos > 0) {

            try {
                BuscarServicios();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_comboFechaSActionPerformed

    private void botonGuardarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarHActionPerformed
        botonGuardarH.setVisible(false);
        botonBuscarS.setEnabled(true);

        if (cajaNombreS.getText().equals("") || cajaNumeroS.getText().equals("") || cajaDomicilioS.getText().equals("") || fechaServicioS.getDate() == null || cajaTarifaS.getText().equals("") || comboInicioS.getSelectedItem() == null || comboFinalS.getSelectedItem() == null || comboTipoServicioS.getSelectedItem() == null || cajaDescripcionS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos");
        } else {
            try {

                Date fechaEntrada = fechaServicioS.getDate();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                String entrada = formatoFecha.format(fechaEntrada);

                FechaInicio = entrada;
                HoraInicio = comboInicioS.getSelectedItem().toString();
                HoraFinal = comboFinalS.getSelectedItem().toString();
                TipoServicio = comboTipoServicioS.getSelectedItem().toString();
                TarifaHora = cajaTarifaS.getText();
                Descripcion = cajaDescripcionS.getText();

                servicio.setFechaInicio(FechaInicio);
                servicio.setHoraInicio(HoraInicio);
                servicio.setHoraFinal(HoraFinal);
                servicio.setTipoServicio(TipoServicio);
                servicio.setTarifaHora(TarifaHora);
                servicio.setDescripcion(Descripcion);

                System.out.println("ACTUALIZAR -> Servicio ID: " + servicio.getID());
                System.out.println("Cliente ID: " + servicio.getIDCliente());
                System.out.println("Niñera ID: " + servicio.getIDNiñera());
                System.out.println("Fecha de Inicio: " + servicio.getFechaInicio());
                System.out.println("Hora de Inicio: " + servicio.getHoraInicio());
                System.out.println("Hora Final: " + servicio.getHoraFinal());
                System.out.println("Tipo de Servicio: " + servicio.getTipoServicio());
                System.out.println("Tarifa por Hora: " + servicio.getTarifaHora());
                System.out.println("Descripción: " + servicio.getDescripcion());
                System.out.println("--------------------------------------");

                ModeloServicio.actualizarServicio(servicio);
                JOptionPane.showMessageDialog(null, "Actualizado");
                LimpiarHistorial();
                botonGuardarH.setVisible(false);
                botonEditarH.setVisible(true);
                botonCancelarH.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_botonGuardarHActionPerformed

    private void botonCancelarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarHActionPerformed
        botonEditarH.setVisible(true);
        botonGuardarH.setVisible(false);
        botonCancelarH.setVisible(false);
        botonRenovarS.setVisible(true);
        textoRenovar.setVisible(true);
        botonBuscarS.setEnabled(true);
        fechaHoy();
        BloquearCajas();
        int elementos = comboFechaS.getItemCount();
        if (elementos > 0) {

            try {
                BuscarServicios();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_botonCancelarHActionPerformed

    private void botonCancelarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarNActionPerformed
        botonCancelarN.setVisible(false);
        botonGuardarN.setVisible(false);
        
        botonEditarN.setVisible(true);
        botonReservarN.setVisible(true);
        botonEliminarN.setVisible(true);
        LimpiarNiñera();
        BloquearCajasNiñera();
        int elementos = comboNiñeraN.getItemCount();
        if (elementos > 0) {
            Buscar = comboNiñeraN.getSelectedItem().toString();
            BuscarNiñera(Buscar);
        }
    }//GEN-LAST:event_botonCancelarNActionPerformed

    private void botonGuardarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarNActionPerformed
        botonCancelarN.setVisible(false);
        botonGuardarN.setVisible(false);
        
        botonEditarN.setVisible(true);
        botonReservarN.setVisible(true);
        botonEliminarN.setVisible(true);
        
        BloquearCajasNiñera();
        try {
            if (IDniñeraActual > 0) {
                //recupero la nueva informacion de la niñera
                Nombre = cajaNombreN.getText();
                Edad = cajaEdadN.getText();
                Estudios = cajaEstudiosN.getText();
                Disponibilidad = cajaDisponibilidadN.getText();
                ZonasTrabajo = cajaZonaN.getText();
                Cursos = cajaCursosN.getText();
                Experiencia = cajaAñosN.getText();
                Cualidades = cajaCualidadesN.getText();

                niñera = new Niñera(Nombre, Integer.parseInt(Edad), Estudios, Disponibilidad, ZonasTrabajo, Cursos, Integer.parseInt(Experiencia), Cualidades);
                niñera.setID(IDniñeraActual);

                ModeloNiñera.actualizarNiñera(niñera);
                JOptionPane.showMessageDialog(null, "Modificacion realizada");
                IDniñeraActual = -1;

                BuscarNiñera(Nombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonGuardarNActionPerformed

    private void botonLimpiarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarNActionPerformed
      LimpiarNiñera();
      comboNiñeraN.removeAllItems();
    }//GEN-LAST:event_botonLimpiarNActionPerformed

    private void botonLimpiarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarAActionPerformed
        LimpiarHistorial();
    }//GEN-LAST:event_botonLimpiarAActionPerformed


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
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarC;
    private javax.swing.JButton botonBuscarS;
    private javax.swing.JButton botonCancelarH;
    private javax.swing.JButton botonCancelarN;
    private javax.swing.JButton botonEditarH;
    private javax.swing.JButton botonEditarN;
    private javax.swing.JButton botonEliminarN;
    private javax.swing.JButton botonGuardarH;
    private javax.swing.JButton botonGuardarN;
    private javax.swing.JButton botonLimpiarA;
    private javax.swing.JButton botonLimpiarN;
    private javax.swing.JButton botonNuevoN;
    private javax.swing.JButton botonRenovarS;
    private javax.swing.JButton botonReservarN;
    private javax.swing.JTextField cajaAñosN;
    private javax.swing.JTextField cajaBuscarN;
    private javax.swing.JTextField cajaBuscarS;
    private javax.swing.JTextArea cajaCualidadesN;
    private javax.swing.JTextField cajaCursosN;
    private javax.swing.JTextArea cajaDescripcionS;
    private javax.swing.JTextField cajaDisponibilidadN;
    private javax.swing.JTextField cajaDomicilioS;
    private javax.swing.JTextField cajaEdadN;
    private javax.swing.JTextField cajaEstudiosN;
    private javax.swing.JTextField cajaNiñeraS;
    private javax.swing.JTextField cajaNombreN;
    private javax.swing.JTextField cajaNombreS;
    private javax.swing.JTextField cajaNumeroS;
    private javax.swing.JTextField cajaTarifaS;
    private javax.swing.JTextField cajaZonaN;
    private javax.swing.JComboBox<String> comboFechaS;
    private javax.swing.JComboBox<String> comboFinalS;
    private javax.swing.JComboBox<String> comboInicioS;
    private javax.swing.JComboBox<String> comboNiñeraN;
    private javax.swing.JComboBox<String> comboTipoServicioS;
    private com.toedter.calendar.JDateChooser fechaServicioS;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel signoPrecio;
    private javax.swing.JLabel textoRenovar;
    // End of variables declaration//GEN-END:variables
}
