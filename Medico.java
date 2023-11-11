/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alessandro
 */
public class Medico {
    private int colegiatura;
    String nombre;
    private String especialidad;

    public Medico(int colegiatura, String nombre, String especialidad) {
        this.colegiatura = colegiatura;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getColegiatura() {
        return colegiatura;
    }

    public void setColegiatura(int colegiatura) {
        this.colegiatura = colegiatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
