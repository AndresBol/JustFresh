/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDAO;

import entidades.Producto;
import entidades.ProductoEmpacado;
import entidades.ProductoPreparado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Bolaños
 */
public class ProductoDAO {
    
    private static Connection connection;
    private static PreparedStatement statement;
    
    public static int PRODUCTO_EMPACADO = 1;
    public static int PRODUCTO_PREPARADO = 2;
        
    public static void insertarProducto(Producto producto, int ID_Restaurante){
        try{
            connection = ConexionSqlServer.Conexion_DB();
        
            PreparedStatement InsertStatement = connection.prepareStatement("insert into Producto values (?,?,?,?,?,?,?,?)");

            InsertStatement.setString(1, producto.getNombre());
            InsertStatement.setString(2, producto.getDescripcion());
            InsertStatement.setFloat(3, producto.getPrecio());
            if(producto instanceof ProductoEmpacado){
                ProductoEmpacado productoEmpacado = (ProductoEmpacado) producto;
                InsertStatement.setInt(4, PRODUCTO_EMPACADO);
                InsertStatement.setNull(5, Types.INTEGER);
                InsertStatement.setInt(6, productoEmpacado.getCantidad());
                InsertStatement.setFloat(7, productoEmpacado.getImpuesto());
            }else{
                ProductoPreparado productoPreparado = (ProductoPreparado) producto;
                InsertStatement.setInt(4, PRODUCTO_PREPARADO);
                InsertStatement.setInt(5, productoPreparado.getTiempoPreparacion());
                InsertStatement.setNull(6, Types.INTEGER);
                InsertStatement.setNull(7, Types.FLOAT);
            }
            
            
            InsertStatement.setInt(8, ID_Restaurante);

            InsertStatement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public static int obtenerID_DB(String nombrePorBuscar, int ID_Restaurante){
        
        int ID = 0;
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Producto where Nombre=? and ID_Restaurante=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setString(1, nombrePorBuscar);
            statement.setInt(2, ID_Restaurante);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                
                ID = result.getInt("ID");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return ID;
    }
    
    public static List<Producto> selectProductos(int ID_Restaurante){
        List<Producto> productos = new ArrayList();
        
        try{
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Producto where ID_Restaurante=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID_Restaurante);

            ResultSet result = statement.executeQuery();

            while(result.next()){
                if(result.getInt("TipoProducto") == PRODUCTO_EMPACADO){
                    productos.add( new ProductoEmpacado(result.getString("Nombre"), result.getString("Descripcion"), result.getFloat("Precio"), result.getInt("Cantidad"), result.getFloat("Impuesto")));
                }else{
                    productos.add( new ProductoPreparado(result.getString("Nombre"), result.getString("Descripcion"), result.getFloat("Precio"), result.getInt("TiempoPreparacion")));
                }
            }
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return productos;
    }
    
    public static Producto selectProducto(int ID){
        Producto producto = null;
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Producto where ID=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                
                String nombre = result.getString("Nombre");
                String descripcion = result.getString("Descripcion");
                float precio = result.getFloat("Precio");
                
                if(result.getInt("TipoProducto") == PRODUCTO_EMPACADO){
                    producto = new ProductoEmpacado(nombre, descripcion, precio, result.getInt("Cantidad"), result.getFloat("Impuesto"));
                }else{
                    producto = new ProductoPreparado(nombre, descripcion, precio, result.getInt("TiempoPreparacion"));
                }
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        return producto;
        
    }
    
    public static Producto selectProducto(String nombrePorBuscar, int ID_Restaurante){
        Producto producto = null;
        
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Producto where Nombre=? and ID_Restaurante=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setString(1, nombrePorBuscar);
            statement.setInt(2, ID_Restaurante);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){
                
                String nombre = result.getString("Nombre");
                String descripcion = result.getString("Descripcion");
                float precio = result.getFloat("Precio");
                
                if(result.getInt("TipoProducto") == PRODUCTO_EMPACADO){
                    producto = new ProductoEmpacado(nombre, descripcion, precio, result.getInt("Cantidad"), result.getFloat("Impuesto"));
                }else{
                    producto = new ProductoPreparado(nombre, descripcion, precio, result.getInt("TiempoPreparacion"));
                }
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        return producto;
        
    }
    
    public static void updateProducto(String nombrePorBuscar, int ID_Restaurante, Producto producto){
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("UPDATE Producto SET Nombre = ?, Descripcion = ?, Precio = ?, TipoProducto = ?, TiempoPreparacion = ?, Cantidad = ?, Impuesto = ? where Nombre=? and ID_Restaurante=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getDescripcion());
            statement.setFloat(3, producto.getPrecio());
            if(producto instanceof ProductoEmpacado){
                ProductoEmpacado productoEmpacado = (ProductoEmpacado) producto;
                statement.setInt(4, PRODUCTO_EMPACADO);
                statement.setNull(5, Types.INTEGER);
                statement.setInt(6, productoEmpacado.getCantidad());
                statement.setFloat(7, productoEmpacado.getImpuesto());
            }else{
                ProductoPreparado productoPreparado = (ProductoPreparado) producto;
                statement.setInt(4, PRODUCTO_PREPARADO);
                statement.setInt(5, productoPreparado.getTiempoPreparacion());
                statement.setNull(6, Types.INTEGER);
                statement.setNull(7, Types.FLOAT);
            }
            statement.setString(8, nombrePorBuscar);
            statement.setInt(9, ID_Restaurante);

            statement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void updateCantidadProducto(Producto producto, int ID_Restaurante, int nuevaCantidad){
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("UPDATE Producto SET Cantidad = ? where Nombre=? and ID_Restaurante=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, nuevaCantidad);
            statement.setString(2, producto.getNombre());
            statement.setInt(3, ID_Restaurante);

            statement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void deleteProducto(String nombrePorBuscar, int ID_Restaurante){
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("DELETE FROM Producto WHERE Nombre = ? and ID_Restaurante = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setString(1, nombrePorBuscar);
            statement.setInt(2, ID_Restaurante);

            statement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
