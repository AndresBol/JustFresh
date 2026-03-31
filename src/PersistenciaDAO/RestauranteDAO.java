/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDAO;

import entidades.ETipoRestaurante;
import entidades.Restaurante;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Bolaños
 */
public class RestauranteDAO {
    
    private static Connection connection;
    private static PreparedStatement statement;
        
    public static void insertarRestaurante(Restaurante restaurante, int ID_Usuario){
        try{
            connection = ConexionSqlServer.Conexion_DB();
        
            PreparedStatement InsertStatement = connection.prepareStatement("insert into Restaurante values (?,?,?,?)");

            InsertStatement.setString(1, restaurante.getNombre());
            InsertStatement.setString(2, restaurante.getLocalizacion());
            InsertStatement.setInt(3, restaurante.getTipoRestaurante().getCodigo());
            InsertStatement.setInt(4, ID_Usuario);

            InsertStatement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public static int obtenerID_DB(String nombre){
        
        int ID = 0;
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Restaurante where Nombre=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setString(1, nombre);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                ID = result.getInt("ID");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return ID;
    }
    
    public static List<Restaurante> selectRestaurantes(ETipoRestaurante tipo){
        
        List<Restaurante> restaurantes = new ArrayList();
        
        try{
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Restaurante where TipoRestaurante=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, tipo.getCodigo());

            ResultSet result = statement.executeQuery();

            while(result.next()){
                Restaurante restaurante = new Restaurante(result.getString("Nombre"), result.getString("Localizacion"), tipo);
                
                restaurantes.add(restaurante);
            }
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return restaurantes;
    }
    
    public static List<Restaurante> selectRestaurantes(){
        
        List<Restaurante> restaurantes = new ArrayList();
        
        try{
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Restaurante", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet result = statement.executeQuery();

            while(result.next()){
                Restaurante restaurante = new Restaurante(result.getString("Nombre"), result.getString("Localizacion"), ETipoRestaurante.obtenerTipo(result.getInt("TipoRestaurante")));
                
                restaurantes.add(restaurante);
            }
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return restaurantes;
    }
    
    public static List<Restaurante> selectRestaurantes(int ID_Usuario){
        
        List<Restaurante> restaurantes = new ArrayList();
        
        try{
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Restaurante where ID_Usuario=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID_Usuario);

            ResultSet result = statement.executeQuery();

            while(result.next()){
                ETipoRestaurante tipoRestaurante = ETipoRestaurante.obtenerTipo(result.getInt("TipoRestaurante"));
                Restaurante restaurante = new Restaurante(result.getString("Nombre"), result.getString("Localizacion"), tipoRestaurante);
                
                restaurantes.add(restaurante);
            }
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return restaurantes;
    }
    
    public static Restaurante selectRestaurante(int ID){
        
        Restaurante restaurante = null;
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Restaurante where ID=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                
                String nombre = result.getString("Nombre");
                String localizacion = result.getString("Localizacion");
                ETipoRestaurante tipo = ETipoRestaurante.obtenerTipo(result.getInt("TipoRestaurante")); 
                
                restaurante = new Restaurante(nombre, localizacion, tipo);
                
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return restaurante;
        
    }
    
    public static Restaurante selectRestaurante(String nombrePorBuscar){
        
        Restaurante restaurante = null;
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Restaurante where Nombre=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setString(1, nombrePorBuscar);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                
                String nombre = result.getString("Nombre");
                String localizacion = result.getString("Localizacion");
                ETipoRestaurante tipo = ETipoRestaurante.obtenerTipo(result.getInt("TipoRestaurante")); 
                
                restaurante = new Restaurante(nombre, localizacion, tipo);
                
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return restaurante;
        
    }
    
    public static void updateRestaurante(String nombrePorBuscar, int ID_Usuario, Restaurante restaurante){
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("UPDATE Restaurante SET Nombre = ?, Localizacion = ?, TipoRestaurante = ? where Nombre=? and ID_Usuario=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setString(1, restaurante.getNombre());
            statement.setString(2, restaurante.getLocalizacion());
            statement.setInt(3, restaurante.getTipoRestaurante().getCodigo());
            statement.setString(4, nombrePorBuscar);
            statement.setInt(5, ID_Usuario);

            statement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void deleteRestaurante(String nombrePorBuscar, int ID_Usuario){
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("DELETE FROM Restaurante WHERE Nombre = ? and ID_Usuario = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setString(1, nombrePorBuscar);
            statement.setInt(2, ID_Usuario);

            statement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
