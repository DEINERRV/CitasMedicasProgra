package ModeloDAO;

import Config.Conexion;
import Modelo.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CiudadDAO {
   Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        ArrayList<Ciudad> list = new ArrayList<>();
        String sql = "SELECT * FROM ciudad;";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ciudad ciudadAux = new Ciudad();
                ciudadAux.setId(rs.getInt("id"));
                ciudadAux.setNombre(rs.getString("nombre"));
                list.add(ciudadAux);
            }//fin While
        } catch (Exception e) {

        }

        return list;
    }
    
    
    public boolean agregar(Ciudad ciudad){
        String sql = "INSERT INTO ciudad(id,nombre) VALUES(?,?);";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setObject(0, ciudad.getId());
            ps.setObject(1, ciudad.getNombre());
            rs = ps.executeQuery();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    
    public Ciudad buscar(int id){
        String sql = "SELECT * FROM ciudad WHERE id="+id+";";
        Ciudad ciudad = null;
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()) {
                ciudad = new Ciudad();
                ciudad.setId(rs.getInt("id"));
                ciudad.setNombre(rs.getString("nombre"));
            }//fin While
        } catch (Exception e) {
        }
        
        return ciudad;
    }
 
}
