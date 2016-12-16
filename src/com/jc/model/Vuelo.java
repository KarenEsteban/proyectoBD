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
public class Vuelo {
     private Integer id_vuelo;
     private String fecha;
     private String origen;
     private String destino;
     private Integer matricula_fk;

    public Vuelo(Integer id_vuelo, String fecha, String origen, String destino, Integer matricula_fk) {
        this.id_vuelo = id_vuelo;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.matricula_fk = matricula_fk;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "id_vuelo=" + id_vuelo + ", fecha=" + fecha + ", origen=" + origen + ", destino=" + destino + ", matricula_fk=" + matricula_fk + '}';
    }

    public Integer getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(Integer id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Integer getMatricula_fk() {
        return matricula_fk;
    }

    public void setMatricula_fk(Integer matricula_fk) {
        this.matricula_fk = matricula_fk;
    }
     
}
