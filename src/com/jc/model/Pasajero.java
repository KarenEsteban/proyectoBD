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
public class Pasajero {
    private Integer id_pasajero;
    private String nombre;
    private String f_nac;
    private String clase;
    private Integer asiento;
    private Integer id_vuelo_fk;

    @Override
    public String toString() {
        return "Pasajero{" + "id_pasajero=" + id_pasajero + ", nombre=" + nombre + ", f_nac=" + f_nac + ", clase=" + clase + ", asiento=" + asiento + ", id_vuelo_fk=" + id_vuelo_fk + '}';
    }

    public Pasajero(Integer id_pasajero, String nombre, String f_nac, String clase, Integer asiento, Integer id_vuelo_fk) {
        this.id_pasajero = id_pasajero;
        this.nombre = nombre;
        this.f_nac = f_nac;
        this.clase = clase;
        this.asiento = asiento;
        this.id_vuelo_fk = id_vuelo_fk;
    }

    public Integer getId_vuelo_fk() {
        return id_vuelo_fk;
    }

    public void setId_vuelo_fk(Integer id_vuelo_fk) {
        this.id_vuelo_fk = id_vuelo_fk;
    }

    public Integer getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(Integer id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nac() {
        return f_nac;
    }

    public void setFecha_nac(String f_nac) {
        this.f_nac = f_nac;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Integer getAsiento() {
        return asiento;
    }

    public void setAsiento(Integer asiento) {
        this.asiento = asiento;
    }
    
            
}
