/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entidades;

/**
 *
 * @author Estudiante
 */
public enum ETipoTarjeta {
    VISA(1),
    MASTERCARD(2);
    
    private int codigo;
    
    ETipoTarjeta(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public static ETipoTarjeta obtenerTipo(int codigo){
        
        for(ETipoTarjeta tipo : ETipoTarjeta.values()){
            if(tipo.getCodigo() == codigo){
                return tipo;
            }
        }
        
        return null;
        
    }
    
}
