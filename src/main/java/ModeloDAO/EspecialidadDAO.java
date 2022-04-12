package ModeloDAO;

import Config.Conexion;
import Modelo.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadDAO {

    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        ArrayList<Especialidad> list = new ArrayList<>();
        String sql = "SELECT * FROM especialidad;";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Especialidad espAux = new Especialidad();
                espAux.setId(rs.getInt("id"));
                espAux.setNombre(rs.getString("nombre"));
                list.add(espAux);
            }//fin While
        } catch (Exception e) {

        }

        return list;
    }
    
    
    public boolean agregar(Especialidad esp){
        String sql = "INSERT INTO especialidad(id,nombre) VALUES(?,?);";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setObject(0, esp.getId());
            ps.setObject(1, esp.getNombre());
            rs = ps.executeQuery();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    
    public Especialidad buscar(int id){
        String sql = "SELECT * FROM especialidad WHERE id="+id+";";
        Especialidad esp = null;
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()) {
                esp = new Especialidad();
                esp.setId(rs.getInt("id"));
                esp.setNombre(rs.getString("nombre"));
            }//fin While
        } catch (Exception e) {
        }
        
        return esp;
    }
    
}
