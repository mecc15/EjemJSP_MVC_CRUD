/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empre.Modelo;
import java.sql.*;
/**
 *
 * @author mecc
 */
public class Conexion {
    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://127.0.0.1:3306/empre";
    private String user="root";
    private String password="";
    public Connection con()throws ClassNotFoundException,SQLException{
        Class.forName(driver);
        return DriverManager.getConnection(url,user,password);
    }
    
}
