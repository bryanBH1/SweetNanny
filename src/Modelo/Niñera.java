/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author bryanbautista
 */
public class Niñera {
    private int ID;
    private String Nombre;
    private int Edad;
    private String Estudios;       
    private String Disponibilidad;
    private String ZonasTrabajo;
    private String Cursos;
    private int Experiencia;
    private String Cualidades;

    public Niñera(String Nombre, int Edad, String Estudios, String Disponibilidad, String ZonasTrabajo, String Cursos, int Experiencia, String Cualidades) {
        this.ID = 0; //no necesita un id en interfaz pero si un id cuando recupero de la base de datos
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Estudios = Estudios;
        this.Disponibilidad = Disponibilidad;
        this.ZonasTrabajo = ZonasTrabajo;
        this.Cursos = Cursos;
        this.Experiencia = Experiencia;
        this.Cualidades = Cualidades;
    }

    public Niñera() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getEstudios() {
        return Estudios;
    }

    public void setEstudios(String Estudios) {
        this.Estudios = Estudios;
    }

    public String getDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(String Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

    public String getZonasTrabajo() {
        return ZonasTrabajo;
    }

    public void setZonasTrabajo(String ZonasTrabajo) {
        this.ZonasTrabajo = ZonasTrabajo;
    }

    public String getCursos() {
        return Cursos;
    }

    public void setCursos(String Cursos) {
        this.Cursos = Cursos;
    }

    public int getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(int Experiencia) {
        this.Experiencia = Experiencia;
    }

    public String getCualidades() {
        return Cualidades;
    }

    public void setCualidades(String Cualidades) {
        this.Cualidades = Cualidades;
    }
    
      
}
