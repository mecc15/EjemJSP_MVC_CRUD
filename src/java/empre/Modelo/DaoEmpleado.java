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
public class DaoEmpleado extends Conexion implements Crud{
    PreparedStatement ps;
    ResultSet rs;
    Departamento dep;
    Empleado emp;
    int res;
    @Override
    public ArrayList<Object> mostrar() throws ClassNotFoundException, SQLException {
           ArrayList<Object> ar=new ArrayList<>();
           ps=super.con().prepareStatement("select * from empleado,departamento"
                   + " where empleado.id_depto=departamento.id_depto");
           try {
              rs=ps.executeQuery();
              while(rs.next()){
                   dep=new Departamento(rs.getInt(5),rs.getString(6));
                   emp=new Empleado(rs.getInt(1),rs.getString(2),rs.getString(3),dep);
                   ar.add(emp);
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
        emp=(Empleado)ob;
        ps=super.con().prepareStatement("insert into empleado(nombre,telefono,"
                + "id_depto) values(?,?,?)");
        ps.setString(1,emp.getNombre());
        ps.setString(2,emp.getTelefono());
        ps.setInt(3,emp.getDepto().getId_depto());
        try {
            res=ps.executeUpdate();
        } catch (Exception e) {
        }
        finally{
          super.con().close();
        }
        return res;
    }

    @Override
    public int modificar(Object ob) throws ClassNotFoundException, SQLException {
        emp=(Empleado)ob;
        ps=super.con().prepareStatement("update empleado set nombre=?,telefono=?"
                + ",id_depto=? where id_emp=?");
        ps.setString(1,emp.getNombre());
        ps.setString(2,emp.getTelefono());
        ps.setInt(3,emp.getDepto().getId_depto());
        ps.setInt(4,emp.getId_emp());
        try {
            res=ps.executeUpdate();
        } catch (Exception e) {
        }
        finally{
          super.con().close();
        }
        return res;  
    }

    @Override
    public int eliminar(Object ob) throws ClassNotFoundException, SQLException {
       emp=(Empleado)ob;
        ps=super.con().prepareStatement("delete from empleado where id_emp=?");
        ps.setInt(1,emp.getId_emp());
        try {
            res=ps.executeUpdate();
        } catch (Exception e) {
        }
        finally{
          super.con().close();
        }
        return res;    
    }
    
    
}
