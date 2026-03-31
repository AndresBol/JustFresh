/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Estudiante
 */
public class ProductoPreparado extends Producto{
    private int tiempoPreparacion;
    
    public ProductoPreparado(String nombre, String descripcion, float precio, int tiempoPreparacion){
        
        super(nombre, descripcion, precio);
        this.tiempoPreparacion = tiempoPreparacion;
        
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }
    
    
}
