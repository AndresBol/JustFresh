/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import PersistenciaDAO.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Bolaños
 */
public abstract class Usuario {
    protected String correoElectronico;
    protected String contrasena;
    protected String nombre;
    protected Pais paisOrigen;
    protected List<EPermiso> permisos;
    protected boolean permisoIngreso;
    
    public Usuario(String correoElectronico, String contrasena, String nombre, Pais paisOrigen, boolean permisoIngreso){
        
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.permisos = new ArrayList();
        this.permisoIngreso = permisoIngreso;
        
    }
    
    public int getID(){
        return UsuarioDAO.obtenerID_DB(correoElectronico, contrasena);
    }
    
    public void agregarPermiso(EPermiso permiso){
        permisos.add(permiso);
    }

    public List<EPermiso> getPermisos() {
        return permisos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public Pais getPaisOrigen() {
        return paisOrigen;
    }

    public boolean isPermisoIngreso() {
        return permisoIngreso;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario:");
        sb.append("\ncorreoElectronico=").append(correoElectronico);
        sb.append("\ncontrasena=").append(contrasena);
        sb.append("\nnombre=").append(nombre);
        sb.append("\npaisOrigen=").append(paisOrigen);
        sb.append("\npermisos=").append(permisos);
        return sb.toString();
    }
    
    
    
}
