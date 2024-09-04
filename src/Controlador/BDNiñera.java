/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Niñera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryanbautista
 */
public class BDNiñera {
    private Connection connection;

    public BDNiñera(Connection connection) {
        this.connection = connection;
    }
    
    public void insertarNiñera(Niñera niñera) throws SQLException {
        String sql = "INSERT INTO Niñera (Nombre, Edad, Estudios, Disponibilidad, ZonasTrabajo, Cursos, Experiencia, Cualidades) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, niñera.getNombre());
            statement.setInt(2, niñera.getEdad());
            statement.setString(3, niñera.getEstudios());
            statement.setString(4, niñera.getDisponibilidad());
            statement.setString(5, niñera.getZonasTrabajo());
            statement.setString(6, niñera.getCursos());
            statement.setInt(7, niñera.getExperiencia());
            statement.setString(8, niñera.getCualidades());

            statement.executeUpdate();
        }
    }
    
    public ArrayList<Niñera> buscarNiñeras(String busqueda) throws SQLException {
    ArrayList<Niñera> niñeras = new ArrayList<>();
    
    // Separar la búsqueda en palabras individuales
    String[] palabras = busqueda.split("\\s+");

    // Crear una condición para cada palabra en cada campo
    StringBuilder sqlCondition = new StringBuilder();
    for (int i = 0; i < palabras.length; i++) {
        if (i > 0) {
            sqlCondition.append(" OR ");
        }
        sqlCondition.append("Nombre ILIKE ? OR " +
                           "CAST(Edad AS TEXT) ILIKE ? OR " +
                           "Estudios ILIKE ? OR " +
                           "Disponibilidad ILIKE ? OR " +
                           "ZonasTrabajo ILIKE ? OR " +
                           "Cursos ILIKE ? OR " +
                           "CAST(Experiencia AS TEXT) ILIKE ? OR " +
                           "Cualidades ILIKE ?");
    }

    // Construir la consulta SQL final
    String sql = "SELECT * FROM Niñera WHERE " + sqlCondition.toString();

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        // Utilizar cada palabra de búsqueda en todos los campos
        for (int i = 0; i < palabras.length; i++) {
            for (int j = 1; j <= 8; j++) {
                statement.setString(i * 8 + j, "%" + palabras[i] + "%");
            }
        }

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Niñera niñera = new Niñera();
                niñera.setID(resultSet.getInt("ID"));
                niñera.setNombre(resultSet.getString("Nombre"));
                niñera.setEdad(resultSet.getInt("Edad"));
                niñera.setEstudios(resultSet.getString("Estudios"));
                niñera.setDisponibilidad(resultSet.getString("Disponibilidad"));
                niñera.setZonasTrabajo(resultSet.getString("ZonasTrabajo"));
                niñera.setCursos(resultSet.getString("Cursos"));
                niñera.setExperiencia(resultSet.getInt("Experiencia"));
                niñera.setCualidades(resultSet.getString("Cualidades"));

                niñeras.add(niñera);
            }
        }
    }
    return niñeras;
}  
    
    public Niñera buscarNiñera(String busqueda) throws SQLException {
        Niñera niñera = null; // Inicializar a null

        String sql = "SELECT * FROM Niñera WHERE Nombre = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,busqueda);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) { // Cambiado a un if, ya que solo esperamos un resultado
                    niñera = new Niñera();
                    niñera.setID(resultSet.getInt("ID"));
                    niñera.setNombre(resultSet.getString("Nombre"));
                    niñera.setEdad(resultSet.getInt("Edad"));
                    niñera.setEstudios(resultSet.getString("Estudios"));
                    niñera.setDisponibilidad(resultSet.getString("Disponibilidad"));
                    niñera.setZonasTrabajo(resultSet.getString("ZonasTrabajo"));
                    niñera.setCursos(resultSet.getString("Cursos"));
                    niñera.setExperiencia(resultSet.getInt("Experiencia"));
                    niñera.setCualidades(resultSet.getString("Cualidades"));
                }
            }
        }
        return niñera;
    }
    
    public Niñera buscarNiñeraID(int busqueda) throws SQLException {
        Niñera niñera = null; // Inicializar a null

        String sql = "SELECT * FROM Niñera WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,busqueda);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) { // Cambiado a un if, ya que solo esperamos un resultado
                    niñera = new Niñera();
                    niñera.setID(resultSet.getInt("ID"));
                    niñera.setNombre(resultSet.getString("Nombre"));
                    niñera.setEdad(resultSet.getInt("Edad"));
                    niñera.setEstudios(resultSet.getString("Estudios"));
                    niñera.setDisponibilidad(resultSet.getString("Disponibilidad"));
                    niñera.setZonasTrabajo(resultSet.getString("ZonasTrabajo"));
                    niñera.setCursos(resultSet.getString("Cursos"));
                    niñera.setExperiencia(resultSet.getInt("Experiencia"));
                    niñera.setCualidades(resultSet.getString("Cualidades"));
                }
            }
        }
        return niñera;
    }
    
    public void actualizarNiñera(Niñera niñera) throws SQLException {
        String sql = "UPDATE Niñera SET Nombre=?, Edad=?, Estudios=?, Disponibilidad=?, ZonasTrabajo=?, " +
                     "Cursos=?, Experiencia=?, Cualidades=? WHERE ID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, niñera.getNombre());
            statement.setInt(2, niñera.getEdad());
            statement.setString(3, niñera.getEstudios());
            statement.setString(4, niñera.getDisponibilidad());
            statement.setString(5, niñera.getZonasTrabajo());
            statement.setString(6, niñera.getCursos());
            statement.setInt(7, niñera.getExperiencia());
            statement.setString(8, niñera.getCualidades());
            statement.setInt(9, niñera.getID());

            statement.executeUpdate();
        }
    }

    public void elliminarNiñera(int niñeraId) throws SQLException {
        String sql = "DELETE FROM Niñera WHERE ID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, niñeraId);
            statement.executeUpdate();
        }
    }
    
}
