/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.model;

import static com.jc.model.DAOEmpleados.empleados;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author campitos
 */
public class DAOPasajero {
    static ArrayList<Pasajero> pasajeros;
    
    public static String guardarPasajero(String nombre, String f_nac, String clase, Integer asiento, Integer id_vuelo_fk) throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call guardar_pasajero(?,?,?,?,?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2,nombre);
        callate.setString(3,f_nac);
        callate.setString(4,clase);
        callate.setInt(5,asiento);
        callate.setInt(6,id_vuelo_fk);
      
        callate.execute();
        int pk=callate.getInt(1);
        return "Se guardo el Pasajero con id:"+pk; 
    }
    public static String actualizarPasajero(Integer id_pasajero,String nombre, String f_nac, String clase, Integer asiento, Integer id_vuelo_fk) throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call actualizar_pasajero(?,?,?,?,?,?)}");
        callate.setInt(1,id_pasajero);
        callate.setString(2,nombre);
        callate.setString(3,f_nac);
        callate.setString(4,clase);
        callate.setInt(5,asiento);
        callate.setInt(6,id_vuelo_fk);
        callate.execute();
        return "Pasajero actualizado con exito"; 
    }
     public static  ArrayList<Pasajero> buscarTodosPasajero() throws Exception{
        String mensajito = "nada";
        Connection con= Conexion.conectarse();
        //Generamos una setencia para usar oracle desde java
        Statement st = con.createStatement();
        //Cursor
        ResultSet res = st.executeQuery("SELECT * FROM PASAJERO");
        int numRegistros=0;
        pasajeros= new ArrayList<>();
        while(res.next()){
            numRegistros++;
            Integer id_pasajero=res.getInt("ID_PASAJERO");
            String nombre=res.getString("NOMBRE");
            String fecha_nac=res.getString("F_NAC");
            String clase=res.getString("CLASE");
            Integer asiento=res.getInt("ASIENTO");
            Integer id_vuelo_fk=res.getInt("ID_VUELO");
            
            
            //CREAMOS EL OBJETO DE TIPO PELICULA
            Pasajero p=new Pasajero(id_pasajero, nombre, fecha_nac, clase, asiento, id_vuelo_fk);
            pasajeros.add(p);
        }
        mensajito="Registros encontrados: "+numRegistros;
        return pasajeros;
     }
     
     public static  ArrayList<Pasajero> buscarPorNombre(String nombre) throws Exception{
        String mensajito = "nada";
        Connection con= Conexion.conectarse();
        //Generamos una setencia para usar oracle desde java
        Statement st = con.createStatement();
        //Cursor
        ResultSet res = st.executeQuery("SELECT * FROM PASAJERO WHERE NOMBRE='"+nombre+"'");
        int numRegistros=0;
        pasajeros= new ArrayList<>();
        while(res.next()){
            numRegistros++;
            Integer id_pasajero=res.getInt("ID_PASAJERO");
            String nom=res.getString("NOMBRE");
            String fecha_nac=res.getString("F_NAC");
            String clase=res.getString("CLASE");
            Integer asiento=res.getInt("ASIENTO");
            Integer id_vuelo_fk=res.getInt("ID_VUELO");
            //CREAMOS EL OBJETO DE TIPO PELICULA
            Pasajero p=new Pasajero(id_pasajero, nom, fecha_nac, clase, asiento, id_vuelo_fk);
            pasajeros.add(p);
        }
        mensajito="Registros encontrados: "+numRegistros;
        return pasajeros;
     }
     public static ArrayList<Pasajero>  buscarPorId(Integer id_pasajero) throws Exception{
        String mensajito="nada";
        Connection con= Conexion.conectarse();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM PASAJERO WHERE ID_PASAJERO='"+id_pasajero+"'");
        pasajeros= new ArrayList<>();
        while(res.next()){
            Integer id=res.getInt("ID_PASAJERO");
            String nombre=res.getString("NOMBRE");
            String fecha_nac=res.getString("F_NAC");
            String clase=res.getString("CLASE");
            Integer asiento=res.getInt("ASIENTO");
            Integer id_vuelo_fk=res.getInt("ID_VUELO");
            Pasajero p=new Pasajero(id_pasajero, nombre, fecha_nac, clase, asiento, id_vuelo_fk);
            pasajeros.add(p);
           
        }
        mensajito="Registros encontrados: ";
        return pasajeros;
    }
      public static String borrarPasajero(Integer id_pasajero) throws Exception{
        String mensajito="Registro borrado con exito";
        
        Connection con= Conexion.conectarse();
        //Generamos una setencia para usar oracle desde java
        Statement st = con.createStatement();
        //Cursor
        ResultSet res = st.executeQuery("DELETE  FROM PASAJERO WHERE ID_PASAJERO='"+id_pasajero+"'");
        return mensajito;
     }
}
