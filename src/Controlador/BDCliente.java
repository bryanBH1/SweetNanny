/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Niñera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDCliente {
    private Connection connection; //objeto para la conexion
    private Cliente cliente;
   
    public BDCliente(Connection connection) {
        this.connection = connection;
    }
    
    public void insertarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (Nombre, Domicilio, Telefono) " +
                     "VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getDomicilio());
            statement.setString(3, cliente.getTelefono());

            statement.executeUpdate();
        }
    }
    
    public Cliente buscarCliente(String busqueda) throws SQLException {
        Cliente cliente = null; // Inicializar a null

        String sql = "SELECT * FROM Cliente WHERE Telefono = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, busqueda);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) { // Cambiado a un if, ya que solo esperamos un resultado
                    cliente = new Cliente();
                    cliente.setID(resultSet.getInt("ID"));
                    cliente.setNombre(resultSet.getString("Nombre"));
                    cliente.setDomicilio(resultSet.getString("Domicilio"));
                    cliente.setTelefono(resultSet.getString("Telefono"));                    
                }
            }
        }
        return cliente;
    }
    
    public Cliente buscarClienteID(int busqueda) throws SQLException {
        Cliente cliente = null; // Inicializar a null

        String sql = "SELECT * FROM Cliente WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, busqueda);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) { // Cambiado a un if, ya que solo esperamos un resultado
                    cliente = new Cliente();
                    cliente.setID(resultSet.getInt("ID"));
                    cliente.setNombre(resultSet.getString("Nombre"));
                    cliente.setDomicilio(resultSet.getString("Domicilio"));
                    cliente.setTelefono(resultSet.getString("Telefono"));                    
                }
            }
        }
        return cliente;
    }
    
}
