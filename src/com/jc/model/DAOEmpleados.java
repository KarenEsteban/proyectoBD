/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jc.model;

import static com.jc.model.DAOAvion.aviones;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author campitos
 */
public class DAOEmpleados {
    static ArrayList<Empleados> empleados;
    
    public static String guardarEmpleados(String nombre, String categoria, String puesto, Integer id_vuelo_fk) throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call guardar_empleados(?,?,?,?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2,nombre);
        callate.setString(3,categoria);
        callate.setString(4,puesto);
        callate.setInt(5,id_vuelo_fk);
      
        callate.execute();
        int pk=callate.getInt(1);
        return "Se guardo el empleado con id:"+pk; 
    }
    public static String actualizarEmpleados(Integer id_empleado, String nombre, String categoria, String puesto, Integer id_vuelo_fk) throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call actualizar_empleados(?,?,?,?,?)}");
        callate.setInt(1,id_empleado);
        callate.setString(2,nombre);
        callate.setString(3,categoria);
        callate.setString(4,puesto);
        callate.setInt(5,id_vuelo_fk);
        callate.execute();
        return "Empleado actualizado con exito"; 
    }
     public static  ArrayList<Empleados> buscarTodosEmpleados() throws Exception{
        String mensajito = "nada";
        Connection con= Conexion.conectarse();
        //Generamos una setencia para usar oracle desde java
        Statement st = con.createStatement();
        //Cursor
        ResultSet res = st.executeQuery("SELECT * FROM EMPLEADOS");
        int numRegistros=0;
        empleados= new ArrayList<>();
        while(res.next()){
            numRegistros++;
            Integer id_empleado=res.getInt("ID_EMPLEADO");
            String nombre=res.getString("NOMBRE");
            String categoria=res.getString("CATEGORIA");
            String puesto=res.getString("PUESTO");
            Integer id_vuelo_fk=res.getInt("ID_VUELO");
            
            
            //CREAMOS EL OBJETO DE TIPO PELICULA
            Empleados e=new Empleados(id_empleado, nombre, categoria, puesto, id_vuelo_fk);
            empleados.add(e);
        }
        mensajito="Registros encontrados: "+numRegistros;
        return empleados;
     }
     
     public static  ArrayList<Empleados> buscarPorNombre(String nombre) throws Exception{
        String mensajito = "nada";
        Connection con= Conexion.conectarse();
        //Generamos una setencia para usar oracle desde java
        Statement st = con.createStatement();
        //Cursor
        ResultSet res = st.executeQuery("SELECT * FROM EMPLEADOS WHERE NOMBRE='"+nombre+"'");
        int numRegistros=0;
        empleados= new ArrayList<>();
        while(res.next()){
            numRegistros++;
            Integer id_empleado=res.getInt("ID_EMPLEADO");
            String nom=res.getString("NOMBRE");
            String categoria=res.getString("CATEGORIA");
            String puesto=res.getString("PUESTO");
            Integer id_vuelo_fk=res.getInt("ID_VUELO");
            Empleados e=new Empleados(id_empleado, nom, categoria, puesto, id_vuelo_fk);
            empleados.add(e);
        }
        mensajito="Registros encontrados: "+numRegistros;
        return empleados;
     
     }
     
     public static ArrayList<Empleados>  buscarPorId(Integer id_empleado) throws Exception{
        String mensajito="nada";
        Connection con= Conexion.conectarse();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery("SELECT * FROM EMPLEADOS WHERE ID_EMPLEADO='"+id_empleado+"'");
        empleados= new ArrayList<>();
        while(res.next()){
            Integer id=res.getInt("ID_EMPLEADO");
            String nombre=res.getString("NOMBRE");
            String categoria=res.getString("CATEGORIA");
            String puesto=res.getString("PUESTO");
            Integer id_vuelo_fk=res.getInt("ID_VUELO");
            Empleados e=new Empleados(id_empleado, nombre, categoria, puesto, id_vuelo_fk);
            empleados.add(e);
        }
        mensajito="Registros encontrados: ";
        return empleados;
    }
      public static String borrarEmpleados(Integer id_empleado) throws Exception{
        String mensajito="Registro borrado con exito";
        
        Connection con= Conexion.conectarse();
        //Generamos una setencia para usar oracle desde java
        Statement st = con.createStatement();
        //Cursor
        ResultSet res = st.executeQuery("DELETE  FROM EMPLEADOS WHERE ID_EMPLEADO='"+id_empleado+"'");
        return mensajito;
     }
     
     }
