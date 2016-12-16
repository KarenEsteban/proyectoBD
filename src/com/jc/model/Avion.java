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
public class Avion {
    private Integer matricula;
    private String fabricante;
    private String modelo;
    private String autonomia;
    private String capacidad;

    @Override
    public String toString() {
        return "Avion{" + "matricula=" + matricula + ", fabricante=" + fabricante + ", modelo=" + modelo + ", autonomia=" + autonomia + ", capacidad=" + capacidad + '}';
    }

    public Avion(Integer matricula, String fabricante, String modelo, String autonomia, String capacidad) {
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.autonomia = autonomia;
        this.capacidad = capacidad;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(String autonomia) {
        this.autonomia = autonomia;
    }
    
}
