/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entidades;

/**
 *
 * @author Estudiante
 */
public enum EPermiso {
    
    ORDENAR_PRODUCTOS(1, "Permite el acceso al módulo de compras"),
    REPORTERIA(2, "Permite el acceso al módulo de reportería"),
    MANTENIMIENTO_RESTAURANTE(3, "Permite el acceso a los módulos de mantenimineto");
    
    private final int codigo;
    private String descripcion;
    
    private EPermiso(int codigo, String descripcion){
        
        this.codigo = codigo;
        this.descripcion = descripcion;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public static EPermiso obtenerTipo(int codigo){
        
        for(EPermiso tipo : EPermiso.values()){
            if(tipo.getCodigo() == codigo){
                return tipo;
            }
        }
        
        return null;
        
    }
    
}
