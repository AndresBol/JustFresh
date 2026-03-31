/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Estudiante
 */
public class UsuarioRegular extends Usuario{
    
    private Tarjeta tarjetaBancaria;
    
    public UsuarioRegular(String correoElectronico, String contrasena, String nombre, Pais paisOrigen, boolean permisoIngreso, Tarjeta tarjetaBancaria){
        
        super(correoElectronico, contrasena, nombre, paisOrigen, permisoIngreso);
        this.tarjetaBancaria = tarjetaBancaria;
        super.permisos.add(EPermiso.ORDENAR_PRODUCTOS);
    }

    public Tarjeta getTarjetaBancaria() {
        return tarjetaBancaria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\ntarjetaBancaria=").append(tarjetaBancaria);
        return sb.toString();
    }
    
    
    
    
    
}
