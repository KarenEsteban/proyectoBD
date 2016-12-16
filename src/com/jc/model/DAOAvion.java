/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.model;

import static com.jc.model.DAOVuelo.vuelos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author campitos
 */
public class DAOAvion {
    static ArrayList<Avion> aviones;
    
    public static String guardarAvion(String fabricante, String modelo, String autonomia, String capacidad) throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call guardar_avion(?,?,?,?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2,fabricante);
        callate.setString(3,modelo);
        callate.setString(4,autonomia);
        callate.setString(5,capacidad);
      
        callate.execute();
        int pk=callate.getInt(1);
        return "Se guardo el avion con id:"+pk; 
    }
    public static String actualizarAvion(Integer matricula, String fabricante, String modelo, String autonomia, String capacidad) throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call actualizar_avion(?,?,?,?,?)}");
        callate.setInt(1,matricula);
        callate.setString(2,fabricante);
        callate.setString(3,modelo);
        callate.setString(4,autonomia);
        callate.setString(5,capacidad);      
        callate.execute();
        return "Avion actualizado con exito"; 
    }
     public static  ArrayList<Avion> buscarTodosAviones() throws Exception{
        String mensajito = "nada";
        Connection con= Conexion.conectarse();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM AVION");
        int numRegistros=0;
        aviones= new ArrayList<>();
        while(res.next()){
            numRegistros++;
            Integer matricula=res.getInt("MATRICULA");
            String fabricante=res.getString("FABRICANTE");
            String modelo=res.getString("MODELO");
            String autonomia=res.getString("AUTONOMIA");
            String capacidad=res.getString("CAPACIDAD");
            Avion a=new Avion(matricula, fabricante, modelo, autonomia, capacidad);
            aviones.add(a);
        }
        mensajito="Registros encontrados: "+numRegistros;
        return aviones;
     }
     
     public static  ArrayList<Avion> buscarPorModelo(String modelo) throws Exception{
        String mensajito = "nada";
        Connection con= Conexion.conectarse();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM AVION WHERE MODELO='"+modelo+"'");
        int numRegistros=0;
        aviones= new ArrayList<>();
        while(res.next()){
            numRegistros++;
            Integer matricula=res.getInt("MATRICULA");
            String fabricante=res.getString("FABRICANTE");
            String mod=res.getString("MODELO");
            String autonomia=res.getString("AUTONOMIA");
            String capacidad=res.getString("CAPACIDAD");
            Avion a=new Avion(matricula, fabricante, mod, autonomia, capacidad);
            aviones.add(a);
        }
        mensajito="Registros encontrados: "+numRegistros;
        return aviones;
     }
     
    public static ArrayList<Avion>  buscarPorId(Integer matricula) throws Exception{
      String mensajito="nada";
        Connection con= Conexion.conectarse();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM AVION WHERE MATRICULA='"+matricula+"'");
       
        aviones= new ArrayList<>();
        while(res.next()){  
            Integer mat=res.getInt("MATRICULA");
            String fabricante=res.getString("FABRICANTE");
            String modelo=res.getString("MODELO");
            String autonomia=res.getString("AUTONOMIA");
            String capacidad=res.getString("CAPACIDAD");
             Avion a=new Avion(matricula, fabricante, modelo, autonomia, capacidad);
            aviones.add(a);
           
        }
        mensajito="Registros encontrado";
        return aviones;
    }
     
      public static String borrarAvion(Integer matricula) throws Exception{
        String mensajito="Registro borrado con exito";
        
        Connection con= Conexion.conectarse();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("DELETE  FROM AVION WHERE MATRICULA='"+matricula+"'");
        return mensajito;
     }
     }
