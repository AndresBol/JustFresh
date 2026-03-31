/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Andrés Bolaños
 */
public class LineaCompra {
    private int cantidad;
    private Producto producto;

    public LineaCompra(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        
        DecimalFormat df = new DecimalFormat("###,##0.00");
        
        StringBuilder sb = new StringBuilder();
        sb.append("- ").append(producto.getNombre());
        sb.append("\nPrecio de unidad: ₡").append(df.format(producto.getPrecio()));
        if(producto instanceof ProductoPreparado){
            sb.append("\nTiempo de preparación: ").append(((ProductoPreparado) producto).getTiempoPreparacion()).append(" minutos.");
        }
        sb.append("\nCantidad: ").append(cantidad);
        sb.append("\n____________");
        sb.append("\nPrecio: ₡").append(df.format(producto.getPrecio() * cantidad));
        return sb.toString();
    }
    
    
    
    
}
