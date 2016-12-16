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

/**
 *
 * @author campitos
 */
public class DAOVuelo {
    static ArrayList<Vuelo> vuelos;
    
    public static String guardarVuelo(String fecha, String origen, String destino, Integer matricula_fk) throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call guardar_vuelo(?,?,?,?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2,fecha);
        callate.setString(3,origen);
        callate.setString(4,destino);
        callate.setInt(5,matricula_fk);
      
        callate.execute();
        int pk=callate.getInt(1);
        return "Se guardo el vuelo con id:"+pk; 
    }
    public static String actualizarVuelo(Integer id_vuelo,String fecha, String origen, String destino, Integer matricula_fk) throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call actualizar_vuelo(?,?,?,?,?)}");
        callate.setInt(1,id_vuelo);
        callate.setString(2,fecha);
        callate.setString(3,origen);
        callate.setString(4,destino);
        callate.setInt(5,matricula_fk);
      
        callate.execute();
        return "Vuelo actualizado con exito"; 
    }
     public static  ArrayList<Vuelo> buscarTodosVuelos() throws Exception{
        String mensajito = "nada";
        Connection con= Conexion.conectarse();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM VUELO");
        int numRegistros=0;
        vuelos= new ArrayList<>();
        while(res.next()){
            numRegistros++;
            Integer id_vuelo=res.getInt("ID_VUELO");
            String fecha=res.getString("FECHA");
            String origen=res.getString("ORIGEN");
            String destino=res.getString("DESTINO");
            Integer matricula_fk=res.getInt("MATRICULA");
            Vuelo v=new Vuelo(id_vuelo, fecha, origen, destino, matricula_fk);
            vuelos.add(v);
        }
        mensajito="Registros encontrados: "+numRegistros;
        return vuelos;
     }
     
     public static  ArrayList<Vuelo> buscarPorDestino(String destino) throws Exception{
        String mensajito = "nada";
        Connection con= Conexion.conectarse();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM VUELO WHERE DESTINO='"+destino+"'");
        int numRegistros=0;
        vuelos= new ArrayList<>();
        while(res.next()){
            numRegistros++;
            Integer id_vuelo=res.getInt("ID_VUELO");
            String fecha=res.getString("FECHA");
            String origen=res.getString("ORIGEN");
            String dest=res.getString("DESTINO");
            Integer matricula_fk=res.getInt("MATRICULA");
            Vuelo v=new Vuelo(id_vuelo, fecha, origen, dest, matricula_fk);
            vuelos.add(v);
        }
        mensajito="Registros encontrados: "+numRegistros;
        return vuelos;
     }
     
     public static String borrarVuelo(Integer id_vuelo) throws Exception{
        String mensajito="Registro borrado con exito";   
        Connection con= Conexion.conectarse();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("DELETE  FROM VUELO WHERE ID_VUELO='"+id_vuelo+"'");
        return mensajito;
     }
      public static ArrayList<Vuelo>  buscarPorId(Integer id_vuelo) throws Exception{
        String mensajito="nada";
        Connection con= Conexion.conectarse();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM VUELO WHERE ID_VUELO='"+id_vuelo+"'");
        vuelos= new ArrayList<>();
        while(res.next()){
            Integer id=res.getInt("ID_VUELO");
            String fecha=res.getString("FECHA");
            String origen=res.getString("ORIGEN");
            String dest=res.getString("DESTINO");
            Integer matricula_fk=res.getInt("MATRICULA");
            Vuelo v=new Vuelo(id_vuelo, fecha, origen, dest, matricula_fk);
            vuelos.add(v);
        }
        mensajito="Registros encontrados";
        return vuelos;
      }
}
