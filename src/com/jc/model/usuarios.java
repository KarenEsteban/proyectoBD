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
public class usuarios {
    private Integer id_usuario;
    private String login;
    private String password;

    @Override
    public String toString() {
        return "usuarios{" + "id_usuario=" + id_usuario + ", login=" + login + ", password=" + password + '}';
    }

    public usuarios(Integer id_usuario, String login, String password) {
        this.id_usuario = id_usuario;
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
