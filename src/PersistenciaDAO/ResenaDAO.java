/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDAO;

import entidades.Resena;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Bolaños
 */
public class ResenaDAO {
    
    private static Connection connection;
    private static PreparedStatement statement;
    
    
    public static void insertarResena(Resena resena){
        try{
            connection = ConexionSqlServer.Conexion_DB();
        
            statement = connection.prepareStatement("insert into Resena values (?,?,?,?)");

            statement.setInt(1, resena.getUsuario().getID());
            statement.setInt(2, resena.getOrdenCompra().getID());
            statement.setInt(3, resena.getRestaurante().getID());
            statement.setInt(4, resena.getCalificacion());

            statement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public static Resena ObtenerResena(int ID_OrdenCompra, int ID_Usuario){
        Resena resena = null;
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Resena where ID_OrdenCompra=? and ID_Usuario=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID_OrdenCompra);
            statement.setInt(2, ID_Usuario);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                resena = new Resena(OrdenCompraDAO.selectOrdenCompra(ID_OrdenCompra), result.getInt("Calificacion"));
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        return resena;
        
    }
    
    public static List<Resena> selectResenasRestaurante(int ID_Restaurante){
        
        List<Resena> resenas = new ArrayList();
        
        try{
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Resena where ID_Restaurante=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID_Restaurante);

            ResultSet result = statement.executeQuery();

            while(result.next()){
                
                Resena resena = new Resena(OrdenCompraDAO.selectOrdenCompra(result.getInt("ID_OrdenCompra")), result.getInt("Calificacion")); 
                
                resenas.add(resena);
            }
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return resenas;
    }
    
    public static void updateResena(Resena resena){
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("UPDATE Resena SET Calificacion = ? where ID_Usuario=? and ID_OrdenCompra=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, resena.getCalificacion());
            statement.setInt(2, resena.getUsuario().getID());
            statement.setInt(3, resena.getOrdenCompra().getID());
            
            statement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
