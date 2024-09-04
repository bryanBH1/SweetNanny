/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author bryanbautista
 */
public class Servicio {
    private int ID;
    private int IDNiñera;
    private int IDCliente;
    private String FechaInicio; //passar a date
    private String HoraInicio;
    private String HoraFinal;
    private String TipoServicio;
    private String TarifaHora; //pasar a double
    private String Descripcion;

    public Servicio(int IDNiñera, int IDCliente, String FechaInicio, String HoraInicio, String HoraFinal, String TipoServicio, String TarifaHora, String Descripcion) {
        this.ID = 0;
        this.IDNiñera = IDNiñera;
        this.IDCliente = IDCliente;
        this.FechaInicio = FechaInicio;
        this.HoraInicio = HoraInicio;
        this.HoraFinal = HoraFinal;
        this.TipoServicio = TipoServicio;
        this.TarifaHora = TarifaHora;
        this.Descripcion = Descripcion;
    }

    public Servicio() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    public int getIDNiñera() {
        return IDNiñera;
    }

    public void setIDNiñera(int IDNiñera) {
        this.IDNiñera = IDNiñera;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(String HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public String getHoraFinal() {
        return HoraFinal;
    }

    public void setHoraFinal(String HoraFinal) {
        this.HoraFinal = HoraFinal;
    }

    public String getTipoServicio() {
        return TipoServicio;
    }

    public void setTipoServicio(String TipoServicio) {
        this.TipoServicio = TipoServicio;
    }

    public String getTarifaHora() {
        return TarifaHora;
    }

    public void setTarifaHora(String TarifaHora) {
        this.TarifaHora = TarifaHora;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
