/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDAO;

import entidades.ETipoTarjeta;
import entidades.Tarjeta;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Bolaños
 */
public class TarjetaDAO {
    
    private static Connection connection;
    private static PreparedStatement statement;
    
    public static void insertarTarjeta(Tarjeta tarjeta, int ID_Usuario){
        try{
            connection = ConexionSqlServer.Conexion_DB();
        
            PreparedStatement InsertStatement = connection.prepareStatement("insert into Tarjeta values (?,?,?,?,?,?)");

            InsertStatement.setLong(1, tarjeta.getNumeroTarjeta());
            InsertStatement.setInt(2, tarjeta.getMesVencimiento());
            InsertStatement.setInt(3, tarjeta.getAnoVencimiento());
            InsertStatement.setInt(4, tarjeta.getCodigoSeguridad());
            InsertStatement.setInt(5, tarjeta.getTipoTarjeta().getCodigo());
            InsertStatement.setInt(6, ID_Usuario);

            InsertStatement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public static Tarjeta selectTarjeta(int ID_Usuario){
        
        Tarjeta tarjeta = null;
        
        try{
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("select * from Tarjeta where ID_Usuario=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID_Usuario);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){

                ETipoTarjeta tipoTarjeta = ETipoTarjeta.obtenerTipo(result.getInt("TipoTarjeta"));

                tarjeta = new Tarjeta(result.getInt("Numero"), result.getInt("MesVencimiento"), result.getInt("AnoVencimiento"), result.getInt("CodigoSeguridad"), tipoTarjeta);
            }
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        return tarjeta;
    }
}
