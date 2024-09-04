/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Niñera;
import Modelo.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author bryanbautista
 */
public class BDServicio {
    private Connection connection;

    public BDServicio(Connection connection) {
        this.connection = connection;
    }
    
    public void insertarServicio(Servicio servicio) throws SQLException {
    try {
        String fechaComoString = servicio.getFechaInicio(); // Formato: "yyyy-MM-dd"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaComoDate = sdf.parse(fechaComoString);

        // Usar java.sql.Date directamente
        java.sql.Date fechaSql = new java.sql.Date(fechaComoDate.getTime());

        String sql = "INSERT INTO Servicio (ID_Niñera, ID_Cliente, FechaInicio, HoraInicio, HoraFinal, TipoServicio, TarifaHora, Descripcion) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, servicio.getIDNiñera());
            statement.setInt(2, servicio.getIDCliente());
            statement.setDate(3, fechaSql);
            statement.setString(4, servicio.getHoraInicio());
            statement.setString(5, servicio.getHoraFinal());
            statement.setString(6, servicio.getTipoServicio());
            statement.setDouble(7, Double.parseDouble(servicio.getTarifaHora()));
            statement.setString(8, servicio.getDescripcion());

            statement.executeUpdate();
        }
    } catch (ParseException ex) {
        Logger.getLogger(BDServicio.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    public ArrayList<Servicio> buscarServicios(int buscar) throws SQLException {
        ArrayList<Servicio> servicios = new ArrayList<>();

        String sql = "SELECT * FROM Servicio WHERE ID_Cliente = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, buscar);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Servicio servicio = new Servicio();
                    servicio.setID(resultSet.getInt("ID"));
                    servicio.setIDNiñera(resultSet.getInt("ID_Niñera"));
                    servicio.setIDCliente(resultSet.getInt("ID_Cliente"));
                    servicio.setFechaInicio(resultSet.getString("FechaInicio"));
                    servicio.setHoraInicio(resultSet.getString("HoraInicio"));
                    servicio.setHoraFinal(resultSet.getString("HoraFinal"));
                    servicio.setTipoServicio(resultSet.getString("TipoServicio"));
                    servicio.setTarifaHora(resultSet.getString("TarifaHora"));
                    servicio.setDescripcion(resultSet.getString("Descripcion"));

                    servicios.add(servicio);
                }
            }
        }

        return servicios;
    } 
    
    
    public void actualizarServicio(Servicio servicio) throws SQLException {
    try {
        String fechaComoString = servicio.getFechaInicio(); // Formato: "yyyy-MM-dd"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaComoDate = sdf.parse(fechaComoString);

        // Usar java.sql.Date directamente
        java.sql.Date fechaSql = new java.sql.Date(fechaComoDate.getTime());

        String sql = "UPDATE Servicio SET ID_Niñera=?, ID_Cliente=?, FechaInicio=?, HoraInicio=?, HoraFinal=?, TipoServicio=?, TarifaHora=?, Descripcion=? " +
                "WHERE ID =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, servicio.getIDNiñera());
            statement.setInt(2, servicio.getIDCliente());
            statement.setDate(3, fechaSql);
            statement.setString(4, servicio.getHoraInicio());
            statement.setString(5, servicio.getHoraFinal());
            statement.setString(6, servicio.getTipoServicio());
            statement.setDouble(7, Double.parseDouble(servicio.getTarifaHora()));
            statement.setString(8, servicio.getDescripcion());
            statement.setInt(9, servicio.getID()); // ID es el identificador del servicio a actualizar

            
            statement.executeUpdate();
        }
    } catch (ParseException ex) {
        Logger.getLogger(BDServicio.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
}
