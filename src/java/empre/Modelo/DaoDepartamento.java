/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empre.Modelo;
import java.sql.*;
import empre.Entidades.*;
import java.util.*;
/**
 *
 * @author mecc
 */
public class DaoDepartamento extends Conexion implements Crud{
    PreparedStatement ps;
    ResultSet rs;
    Departamento dep;
    Empleado emp;
    int res;

    @Override
    public ArrayList<Object> mostrar() throws ClassNotFoundException, SQLException {
        ArrayList<Object> ar=new ArrayList<>();
           ps=super.con().prepareStatement("select * from departamento");
           try {
              rs=ps.executeQuery();
              while(rs.next()){
                   dep=new Departamento(rs.getInt(1),rs.getString(2));
                   ar.add(dep);
              }
        } catch (Exception e) {
        }
           finally{
           super.con().close();
           }
           return ar;   
    }

    @Override
    public int insertar(Object ob) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar(Object ob) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Object ob) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
