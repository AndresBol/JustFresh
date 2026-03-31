/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import PersistenciaDAO.ProductoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public abstract class Producto {
    
    protected String nombre;
    protected String descripcion;
    protected float precio;
    
    public Producto(String nombre, String descripcion, float precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public int getID(int ID_Restaurante){
        return ProductoDAO.obtenerID_DB(this.nombre, ID_Restaurante);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }
    
    
    
}
