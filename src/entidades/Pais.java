/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Andrés Bolaños
 */
public class Pais {
    
    private int ID;
    private int codigo;
    private String nombre;
    
    public Pais(int codigo, String nombre){

        this.codigo = codigo;
        this.nombre = nombre;
        
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int getID() {
        return ID;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
