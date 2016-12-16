/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.model;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Samanta
 */
public class DAOUsuarios {
    
    public static boolean autenticar(String login, String password) throws Exception{
    
        boolean autenticando=false;
        Connection con= Conexion.conectarse();
        //Generamos una setencia para usar oracle desde java
        Statement st = con.createStatement();
        
        ResultSet res=st.executeQuery("SELECT * FROM USUARIOS WHERE LOGIN='"+login+"' AND PASSWORD='"+password+"'");

        while(res.next()){
        
        autenticando=true;
        }
        return autenticando;
    }
    
    public static String guardarUsuarios( String login, String password) throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call guardar_usuarios(?,?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2,login);
        callate.setString(3,password);
       
      
        callate.execute();
        int pk=callate.getInt(1);
        return "Usuario guardado con exito, id:"+pk; 
    }
    
}
