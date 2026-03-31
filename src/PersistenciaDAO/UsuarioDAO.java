/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDAO;

import entidades.EPermiso;
import entidades.Pais;
import entidades.Tarjeta;
import entidades.Usuario;
import entidades.UsuarioAdministrador;
import entidades.UsuarioGerente;
import entidades.UsuarioRegular;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Bolaños
 */
public class UsuarioDAO {
    
    private static Connection connection;
    private static PreparedStatement statement;
    
    public static final int USUARIO_ADMINISTRADOR = 3;
    public static final int USUARIO_GERENTE = 2;
    public static final int USUARIO_REGULAR = 1;
    
    public static void insertarUsuario(Usuario usuario){
        try{
            connection = ConexionSqlServer.Conexion_DB();
        
            PreparedStatement InsertStatement = connection.prepareStatement("insert into Usuario values (?,?,?,?,?,?)");

            InsertStatement.setString(1, usuario.getCorreoElectronico());
            InsertStatement.setString(2, usuario.getContrasena());
            InsertStatement.setString(3, usuario.getNombre());
            InsertStatement.setInt(4, usuario.getPaisOrigen().getID());
            
            if(usuario instanceof UsuarioAdministrador){
                InsertStatement.setInt(5, USUARIO_ADMINISTRADOR);
            }else if (usuario instanceof UsuarioGerente){
                InsertStatement.setInt(5, USUARIO_GERENTE);
            }else{
                InsertStatement.setInt(5, USUARIO_REGULAR);
            }
            
            InsertStatement.setInt(6, 1);

            InsertStatement.executeUpdate();
            
            for(EPermiso permiso : selectUsuario(usuario.getCorreoElectronico()).getPermisos()){
                PermisoDAO.asignarPermiso(obtenerID_DB(usuario.getCorreoElectronico(), usuario.getContrasena()), permiso);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public static int obtenerID_DB(String correo, String contrasena){
        
        int ID = 0;
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Usuario where CorreoElectronico=? and Contrasena=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setString(1, correo);
            statement.setString(2, contrasena);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                ID = result.getInt("ID");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return ID;
    }
    
    
    public static List<UsuarioGerente> selectUsuariosGerentes(){
        
        List<UsuarioGerente> gerentes = new ArrayList<>();
        
        try{
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Usuario", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet result = statement.executeQuery();

            while(result.next()){
                if(result.getInt("TipoUsuario") == USUARIO_GERENTE){

                    int ID_Pais = result.getInt("ID_PaisOrigen");
                    String correo = result.getString("CorreoElectronico");
                    String contrasena = result.getString("Contrasena");
                    String nombre = result.getString("Nombre");
                    Pais pais = PaisDAO.selectPais(ID_Pais);
                    boolean IngresoPermitido = result.getBoolean("IngresoPermitido");
                    
                    gerentes.add(new UsuarioGerente(correo, contrasena, nombre, pais, IngresoPermitido));
                }
            }
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return gerentes;
        
    }
    
    public static ArrayList<Usuario> selectUsuarios(){
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        try{
            connection = ConexionSqlServer.Conexion_DB();
        
            statement = connection.prepareStatement("select * from Usuario", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet result = statement.executeQuery();

            while(result.next()){
                
                
                Usuario usuario = null;
                
                int ID = result.getInt("ID");
                int ID_Pais = result.getInt("ID_PaisOrigen");
                String correo = result.getString("CorreoElectronico");
                String contrasena = result.getString("Contrasena");
                String nombre = result.getString("Nombre");
                Pais pais = PaisDAO.selectPais(ID_Pais);
                boolean IngresoPermitido = result.getBoolean("IngresoPermitido");

                switch (result.getInt("TipoUsuario")) {
                    case USUARIO_ADMINISTRADOR:
                        usuario = new UsuarioAdministrador(correo, contrasena, nombre, pais, IngresoPermitido);
                        break;
                    case USUARIO_GERENTE:
                        usuario = new UsuarioGerente(correo, contrasena, nombre, pais, IngresoPermitido);
                        break;
                    case USUARIO_REGULAR:
                        Tarjeta tarjeta = TarjetaDAO.selectTarjeta(ID);
                        usuario = new UsuarioRegular(correo, contrasena, nombre, pais, IngresoPermitido, tarjeta);
                        break;
                }
                
                usuarios.add(usuario);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
            
        return usuarios;
    }
    
    public static Usuario selectUsuario(int ID){
        
        Usuario usuario = null;
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Usuario where ID=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                
                int ID_Pais = result.getInt("ID_PaisOrigen");
                String correo = result.getString("CorreoElectronico");
                String contrasena = result.getString("Contrasena");
                String nombre = result.getString("Nombre");
                Pais pais = PaisDAO.selectPais(ID_Pais);
                boolean IngresoPermitido = result.getBoolean("IngresoPermitido");

                switch (result.getInt("TipoUsuario")) {
                    case USUARIO_ADMINISTRADOR:
                        usuario = new UsuarioAdministrador(correo, contrasena, nombre, pais, IngresoPermitido);
                        break;
                    case USUARIO_GERENTE:
                        usuario = new UsuarioGerente(correo, contrasena, nombre, pais, IngresoPermitido);
                        break;
                    case USUARIO_REGULAR:
                        Tarjeta tarjeta = TarjetaDAO.selectTarjeta(ID);
                        usuario = new UsuarioRegular(correo, contrasena, nombre, pais, IngresoPermitido, tarjeta);
                        break;
                }
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return usuario;
        
    }
    
    public static Usuario selectUsuario(String correo){
        
        Usuario usuario = null;
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Usuario where CorreoElectronico=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setString(1, correo);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                
                int ID = result.getInt("ID");
                int ID_Pais = result.getInt("ID_PaisOrigen");
                String contrasena = result.getString("Contrasena");
                String nombre = result.getString("Nombre");
                Pais pais = PaisDAO.selectPais(ID_Pais);
                boolean IngresoPermitido = result.getBoolean("IngresoPermitido");

                switch (result.getInt("TipoUsuario")) {
                    case USUARIO_ADMINISTRADOR:
                        usuario = new UsuarioAdministrador(correo, contrasena, nombre, pais, IngresoPermitido);
                        break;
                    case USUARIO_GERENTE:
                        usuario = new UsuarioGerente(correo, contrasena, nombre, pais, IngresoPermitido);
                        break;
                    case USUARIO_REGULAR:
                        Tarjeta tarjeta = TarjetaDAO.selectTarjeta(ID);
                        usuario = new UsuarioRegular(correo, contrasena, nombre, pais, IngresoPermitido, tarjeta);
                        break;
                }
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return usuario;
        
    }
    
    public static boolean verificarDisponibilidadEmail(String correo){
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Usuario where CorreoElectronico=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setString(1, correo);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                
                int ID_user = result.getInt("ID");
                
                if(ID_user != 0){
                    return false;
                }
                
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return true;
    }
    
    public static void updateAccessUsuario(String correo, boolean ingresoPermitido){
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("UPDATE Usuario SET IngresoPermitido = ? WHERE CorreoElectronico = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setBoolean(1, ingresoPermitido);
            statement.setString(2, correo);

            statement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    
}
