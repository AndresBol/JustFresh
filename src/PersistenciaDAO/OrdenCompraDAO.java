/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDAO;

import entidades.LineaCompra;
import entidades.OrdenCompra;
import entidades.Restaurante;
import entidades.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Bolaños
 */
public class OrdenCompraDAO {
    
    private static Connection connection;
    private static PreparedStatement statement;
    
        
    public static void insertarOrdenCompra(OrdenCompra ordenCompra){
        try{
            connection = ConexionSqlServer.Conexion_DB();
        
            PreparedStatement InsertStatement = connection.prepareStatement("insert into OrdenCompra values (?,?,?,?,?,?)");

            InsertStatement.setString(1, ordenCompra.getFechaCompra());
            InsertStatement.setFloat(2, ordenCompra.calcularSubtotal());
            InsertStatement.setFloat(3, ordenCompra.calcularImpuestos());
            InsertStatement.setFloat(4, ordenCompra.calcularTotal());
            InsertStatement.setInt(5, ordenCompra.getUsuario().getID());
            InsertStatement.setInt(6, ordenCompra.getRestaurante().getID());

            InsertStatement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public static int obtenerSiguienteID(){
        
        int ID = 0;
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from OrdenCompra", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet result = statement.executeQuery();

            
            while(result.next()){
                if(result.getInt("ID") > ID){
                    ID = result.getInt("ID");
                }
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return ID + 1;
    }
    
    public static OrdenCompra selectOrdenCompra(int ID){
        OrdenCompra ordenCompra = null;
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from OrdenCompra where ID=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                
                String fechaCompra = result.getString("FechaCompra");
                
                ordenCompra = new OrdenCompra(fechaCompra, UsuarioDAO.selectUsuario(result.getInt("ID_Usuario")), RestauranteDAO.selectRestaurante(result.getInt("ID_Restaurante")), LineaCompraDAO.ObtenerLineasCompras(ID));
                ordenCompra.setID(ID);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        return ordenCompra;
        
    }
    
    public static List<OrdenCompra> OrdenesDeUsuario(int ID_Usuario){
        List<OrdenCompra> ordenesCompra = new ArrayList();
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from OrdenCompra where ID_Usuario=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID_Usuario);

            ResultSet result = statement.executeQuery();

            while(result.next()){
                
                int ID_Orden = result.getInt("ID");
                String fechaCompra = result.getString("FechaCompra");
                
                OrdenCompra ordenCompra = new OrdenCompra(fechaCompra, UsuarioDAO.selectUsuario(ID_Usuario), RestauranteDAO.selectRestaurante(result.getInt("ID_Restaurante")), LineaCompraDAO.ObtenerLineasCompras(ID_Orden));
                ordenCompra.setID(ID_Orden);
                
                ordenesCompra.add(ordenCompra);
                
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        return ordenesCompra;
        
    }
    
    public static List<OrdenCompra> OrdenesDeRestaurante(int ID_Restaurante){
        List<OrdenCompra> ordenesCompra = new ArrayList();
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from OrdenCompra where ID_Restaurante=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID_Restaurante);

            ResultSet result = statement.executeQuery();

            while(result.next()){
                
                int ID_Orden = result.getInt("ID");
                String fechaCompra = result.getString("FechaCompra");
                
                OrdenCompra ordenCompra = new OrdenCompra(fechaCompra, UsuarioDAO.selectUsuario(result.getInt("ID_Usuario")), RestauranteDAO.selectRestaurante(ID_Restaurante), LineaCompraDAO.ObtenerLineasCompras(ID_Orden));
                ordenCompra.setID(ID_Orden);
                
                ordenesCompra.add(ordenCompra);
                
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        return ordenesCompra;
        
    }
}
