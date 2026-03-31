/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Estudiante
 */
public class ProductoEmpacado extends Producto{
    private int cantidad;
    private float impuesto;
    
    public ProductoEmpacado(String nombre, String descripcion, float precio, int cantidad, float impuesto){
        
        super(nombre, descripcion, precio);
        this.cantidad = cantidad;
        this.impuesto = impuesto;
        
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getImpuesto() {
        return impuesto;
    }
    
    
}
