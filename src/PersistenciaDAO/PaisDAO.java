/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDAO;

import entidades.Pais;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Bolaños
 */
public class PaisDAO {
    
    private static Connection connection;
    private static PreparedStatement statement;
    
    public static void insertarPais(Pais pais){
        try{
            connection = ConexionSqlServer.Conexion_DB();
        
            PreparedStatement InsertStatement = connection.prepareStatement("insert into Pais values (?,?)");

            InsertStatement.setString(1, pais.getNombre());
            InsertStatement.setInt(2, pais.getCodigo());

            InsertStatement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public static Pais selectPais(int ID_Pais){
        
        Pais pais = null;
        
        try{
            connection = ConexionSqlServer.Conexion_DB();
        
            statement = connection.prepareStatement("select * from Pais where ID=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, ID_Pais);

            ResultSet result = statement.executeQuery();

            if(result.absolute(1)){

                pais = new Pais(result.getInt("Codigo"), result.getString("Nombre"));
                pais.setID(ID_Pais);

            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
            
        return pais;
    }
    
    public static ArrayList<Pais> selectALLPaises(){
        
        ArrayList<Pais> listaPaises = new ArrayList<>();
        
        try{
            connection = ConexionSqlServer.Conexion_DB();
        
            statement = connection.prepareStatement("select * from Pais", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet result = statement.executeQuery();

            while(result.next()){
                Pais pais = new Pais(result.getInt("Codigo"), result.getString("Nombre"));
                pais.setID(result.getInt("ID"));
                listaPaises.add(pais);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
            
        return listaPaises;
    }
    
    public static void updatePais(Pais pais, int ID){
        try{    
            connection = ConexionSqlServer.Conexion_DB();

            statement = connection.prepareStatement("UPDATE Pais SET Nombre = ?, Codigo = ? where ID=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            statement.setString(1, pais.getNombre());
            statement.setInt(2, pais.getCodigo());
            statement.setInt(3, ID);
            

            statement.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha sucedido un error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
