package ModeloDAO;

import Config.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;

    public Usuario buscar(int id) {

        String sql = "SELECT * FROM usuario WHERE id=" + id + ";";
        Usuario us = null;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                us = new Usuario();
                us.setId(rs.getInt("id"));
                us.setNombre(rs.getString("nombre"));
                us.setContrasena(rs.getString("contrasena"));
                us.setTipo(rs.getInt("tipo"));
                us.setTelefono(rs.getString("telefono"));
                us.setCorreo(rs.getString("correo"));
            }//fin while
            
        } 
        catch (Exception e) {
        }
        
        return us;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE id=" + id + ";";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } 
        catch (Exception e) {
        }
    }
    
    public boolean editar(Usuario us){
        String sql = "UPDATE usuario set id"+us.getId()+",nombre='"+
        us.getNombre()+"',contrasena='"+us.getContrasena()+"',tipo="+
        us.getTipo()+",telefono='"+us.getTelefono()+"',correo='"+
        us.getCorreo()+"' WHERE id="+us.getId()+";";
        
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
            
        } 
        catch (SQLException e) {
        }
        
        return false;
    }
    
    public boolean agregar(Usuario us){
        String sql = "INSERT INTO usuario(id,nombre,contrasena,tipo,telefono,correo)"+
        "VALUES(?,?,?,?,?,?)";
        
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setObject(0, us.getId());
            ps.setObject(1, us.getNombre());
            ps.setObject(2, us.getContrasena());
            ps.setObject(3, us.getTipo());
            ps.setObject(4, us.getTelefono());
            ps.setObject(5, us.getCorreo());
            rs = ps.executeQuery();
        }
        catch(Exception e){ 
            return false;   
        }
        
        return true;
        
    }
}
