/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entidades;

/**
 *
 * @author Estudiante
 */
public enum ETipoRestaurante {
    ITALIANO(1),
    HAMBURGUESERIA(2),
    PIZZERIA(3),
    JAPONES(4),
    REPOSTERIA(5);
    
    private int codigo;
    
    ETipoRestaurante(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public static ETipoRestaurante obtenerTipo(int codigo){
        
        for(ETipoRestaurante tipo : ETipoRestaurante.values()){
            if(tipo.getCodigo() == codigo){
                return tipo;
            }
        }
        
        return null;
        
    }
    
    
}
