/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDAO;

/**
 *
 * @author Andrés Bolaños
 */
import java.sql.*;


public class ConexionSqlServer {
    
    public static final String USER = "sa";
    public static final String PASSWORD = "123456";
    
    public static Connection Conexion_DB() throws ClassNotFoundException, SQLException{
        
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JustFresh;user=" + USER + ";password=" + PASSWORD + ";");
        
        return connection;
    }
    
}
