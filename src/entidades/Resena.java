/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Estudiante
 */
public class Resena {
    
    private OrdenCompra ordenCompra;
    private int calificacion;

    public Resena(OrdenCompra ordenCompra, int calificacion) {
        this.ordenCompra = ordenCompra;
        this.calificacion = calificacion;
    }
    
    public Usuario getUsuario(){
        return ordenCompra.getUsuario();
    }
    
    public Restaurante getRestaurante(){
        return ordenCompra.getRestaurante();
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public int getCalificacion() {
        return calificacion;
    }
    
    
    
}
