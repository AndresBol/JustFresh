/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import PersistenciaDAO.RestauranteDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class UsuarioGerente extends Usuario{
    
    private List<Restaurante> restaurantes;
    
    public UsuarioGerente(String correoElectronico, String contrasena, String nombre, Pais paisOrigen, boolean permisoIngreso){
        
        super(correoElectronico, contrasena, nombre, paisOrigen, permisoIngreso);
        this.restaurantes = new ArrayList();
        super.permisos.add(EPermiso.MANTENIMIENTO_RESTAURANTE);
        ingresarRestaurantes();
        
    }
    
    private void ingresarRestaurantes(){
        this.restaurantes = RestauranteDAO.selectRestaurantes(super.getID());
    }
    
    public void agregarRestaurante(Restaurante restaurante){
        restaurantes.add(restaurante);
    }

    public void setRestaurantes(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }
    

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    @Override
    public String toString() {
        return super.nombre;
    }
    
    
    
}
