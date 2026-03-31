/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Andrés Bolaños
 */
public class OrdenCompra {
    
    private static final float IVA = 0.13f;
    private static final float TRANSPORTE = 0.1f;
    private int ID;
    private String fechaCompra;
    private Usuario usuario;
    private Restaurante restaurante;
    private List<LineaCompra> lineasDeCompra;

    public OrdenCompra(String fechaCompra, Usuario usuario, Restaurante restaurante, List<LineaCompra> lineasDeCompra) {
        this.fechaCompra = fechaCompra;
        this.usuario = usuario;
        this.restaurante = restaurante;
        this.lineasDeCompra = lineasDeCompra;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getFechaCompra() {
        return fechaCompra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }
    
    
    public int getNumeroDeOrden(){
        return 0;
    }

    public List<LineaCompra> getLineasDeCompra() {
        return lineasDeCompra;
    }
    
    public float calcularSubtotal(){
        
        float subtotal = 0f;
        
        for(LineaCompra lineaCompra : lineasDeCompra){
            
            subtotal += lineaCompra.getProducto().getPrecio() * lineaCompra.getCantidad();
            
        }
        
        return subtotal;
    }
    
    public float calcularImpuestos(){
        
        float impuestos = 0f;
        
        for(LineaCompra lineaCompra : lineasDeCompra){
            Producto producto = lineaCompra.getProducto();
            
            if(producto instanceof ProductoPreparado){
               impuestos += (producto.getPrecio() * IVA) * lineaCompra.getCantidad();
               impuestos += (producto.getPrecio() * TRANSPORTE) * lineaCompra.getCantidad();
            }else{
               impuestos += producto.getPrecio() * ((ProductoEmpacado)producto).getImpuesto();
            }
        }
        
        return impuestos;
        
    }
    
    public float calcularTotal(){
        return calcularSubtotal() + calcularImpuestos();
    }
    
    public int calcularTiempoPreparacion(){
        int tiempo = 0;
        
        for(LineaCompra lineaCompra : lineasDeCompra){
            if(lineaCompra.getProducto() instanceof ProductoPreparado productoPreparado){
                tiempo += productoPreparado.getTiempoPreparacion() * lineaCompra.getCantidad();
            }
        }
        
        return tiempo;
    }

    @Override
    public String toString() {
        
        DecimalFormat df = new DecimalFormat("###,##0.00");
        
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------------- Factura --------------");
        sb.append("\nFecha de compra: ").append(fechaCompra);
        sb.append("\n\nRestaurante: ").append(restaurante.getNombre());

        for(LineaCompra lineaCompra : lineasDeCompra){
            sb.append("\n\n").append(lineasDeCompra.indexOf(lineaCompra)+1).append(lineaCompra.toString());
        }
        sb.append("\n___________________________\n");
        sb.append("\nSubtotal: ₡").append(df.format(calcularSubtotal()));
        sb.append("\nImpuestos a cobrar: ₡").append(df.format(calcularImpuestos()));
        sb.append("\nTotal a pagar: ₡").append(df.format(calcularTotal()));
        sb.append("\n\nTiempo de preparación total: ").append(calcularTiempoPreparacion()).append(" minutos");
        
        
        return sb.toString();
    }
    
    
    
}
