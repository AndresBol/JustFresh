/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDAO;

import entidades.EPermiso;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Bolaños
 */
public class PermisoDAO {
    
    private static Connection connection;
    private static PreparedStatement statement;
    
    public static void asignarPermiso(int ID_Usuario, EPermiso permiso){
        try{
            connection = ConexionSqlServer.Conexion_DB();
        
            PreparedStatement InsertStatement = connection.prepareStatement("insert into UsuarioPermiso values (?,?)");

            InsertStatement.setInt(1, ID_Usuario);
            InsertStatement.setInt(2, permiso.getCodigo());

            InsertStatement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public static EPermiso selectPermiso(int ID_Usuario){
        
        try{
            connection = ConexionSqlServer.Conexion_DB();
        
            statement = connection.prepareStatement("select * from UsuarioPermiso where ID_Usuario=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID_Usuario);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                return EPermiso.obtenerTipo(result.getInt("ID_Permiso"));
            }
            return null;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
            
        return null;
    }
    
}
