/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Estudiante
 */
public class UsuarioAdministrador extends Usuario{
    
    public UsuarioAdministrador(String correoElectronico, String contrasena, String nombre, Pais paisOrigen, boolean permisoIngreso){
        
        super(correoElectronico, contrasena, nombre, paisOrigen, permisoIngreso);
        super.permisos.add(EPermiso.MANTENIMIENTO_RESTAURANTE);
        super.permisos.add(EPermiso.REPORTERIA);
        
    }
    
}
