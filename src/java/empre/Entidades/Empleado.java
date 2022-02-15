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
public class Empleado {
    private int id_emp;
    private String nombre;
    private String telefono;
    private Departamento depto;

    public Empleado() {
    }

    public Empleado(int id_emp, String nombre, String telefono, Departamento depto) {
        this.id_emp = id_emp;
        this.nombre = nombre;
        this.telefono = telefono;
        this.depto = depto;
    }

    public Empleado(String nombre, String telefono, Departamento depto) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.depto = depto;
    }

    public Empleado(int id_emp) {
        this.id_emp = id_emp;
    }

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }
    
}
