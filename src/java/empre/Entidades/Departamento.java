/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empre.Entidades;

/**
 *
 * @author mecc
 */
public class Departamento {
    private int id_depto;
    private String nombre;

    public Departamento() {
    }

    public Departamento(int id_depto, String nombre) {
        this.id_depto = id_depto;
        this.nombre = nombre;
    }

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public Departamento(int id_depto) {
        this.id_depto = id_depto;
    }

    public int getId_depto() {
        return id_depto;
    }

    public void setId_depto(int id_depto) {
        this.id_depto = id_depto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
