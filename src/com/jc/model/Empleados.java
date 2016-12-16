/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.model;

/**
 *
 * @author Samanta
 */
public class Empleados {
    private Integer id_empleado;
    private String nombre;
    private String categoria;
    private String puesto;
    private Integer id_vuelo_fk;

    @Override
    public String toString() {
        return "Empleados{" + "id_empleado=" + id_empleado + ", nombre=" + nombre + ", categoria=" + categoria + ", puesto=" + puesto + ", id_vuelo_fk=" + id_vuelo_fk + '}';
    }

    public Empleados(Integer id_empleado, String nombre, String categoria, String puesto, Integer id_vuelo_fk) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.categoria = categoria;
        this.puesto = puesto;
        this.id_vuelo_fk = id_vuelo_fk;
    }

    public Integer getId_vuelo_fk() {
        return id_vuelo_fk;
    }

    public void setId_vuelo_fk(Integer id_vuelo_fk) {
        this.id_vuelo_fk = id_vuelo_fk;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
}
