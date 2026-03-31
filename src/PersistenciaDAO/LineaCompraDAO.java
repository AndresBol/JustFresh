/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDAO;

import entidades.LineaCompra;
import entidades.OrdenCompra;
import entidades.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Bolaños
 */
public class LineaCompraDAO {
    
    private static Connection connection;
    private static PreparedStatement statement;
    
    
    public static void insertarLineasCompras(OrdenCompra ordenCompra){
        try{
            for(LineaCompra lineaCompra : ordenCompra.getLineasDeCompra()){
                connection = ConexionSqlServer.Conexion_DB();
        
                statement = connection.prepareStatement("insert into LineaCompra values (?,?,?)");

                statement.setInt(1, ordenCompra.getID());
                statement.setInt(2, lineaCompra.getProducto().getID(ordenCompra.getRestaurante().getID()));
                statement.setInt(3, lineaCompra.getCantidad());
                
                statement.executeUpdate();
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public static List<LineaCompra> ObtenerLineasCompras(int ID_OrdenCompra){
        List<LineaCompra> lineasCompra = new ArrayList();
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from LineaCompra where ID_OrdenCompra=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID_OrdenCompra);

            ResultSet result = statement.executeQuery();

            while(result.next()){
                
                LineaCompra lineaCompra = new LineaCompra(result.getInt("Cantidad"), ProductoDAO.selectProducto(result.getInt("ID_Producto")));
                
                lineasCompra.add(lineaCompra);
                
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        return lineasCompra;
        
    }
}
