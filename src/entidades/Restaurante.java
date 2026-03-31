/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import PersistenciaDAO.RestauranteDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class Restaurante {
    
    private String nombre;
    private String localizacion;
    private List<Producto> productos;
    private ETipoRestaurante tipoRestaurante;
    private List<Resena> resenas;
    
    public Restaurante(String nombre, String localizacion, ETipoRestaurante tipoRestaurante){
        
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.tipoRestaurante = tipoRestaurante;
        this.productos = new ArrayList();
        this.resenas = new ArrayList();
        
    }
    
    public int getID(){
        return RestauranteDAO.obtenerID_DB(nombre);
    }
    
    public void agregarProducto(Producto producto){
        this.productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public ETipoRestaurante getTipoRestaurante() {
        return tipoRestaurante;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }
    
    public int getCalificacion(){
        
        if(!resenas.isEmpty()){
            int calificacion = 0;
        
            for(Resena resena : resenas){

                calificacion += resena.getCalificacion();

            }

            return calificacion / resenas.size();
        }
        
        return 0;
    }
    
    public float getCalificacionPrecisa(){
        
        if(!resenas.isEmpty()){
            int calificacion = 0;
        
            for(Resena resena : resenas){

                calificacion += resena.getCalificacion();

            }

            return calificacion / resenas.size();
        }
        
        return 0f;
    }

    @Override
    public String toString() {
        return nombre + ", " + getCalificacion() + " ☆";
    }
    
    
}
