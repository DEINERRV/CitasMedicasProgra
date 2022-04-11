package ModeloDAO;

import Config.Conexion;
import Modelo.Doctor;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    Doctor doc = new Doctor();

    public List listar(String estado) {
        ArrayList<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctor,especialidad,ciudad\n"
                + "WHERE  especialidad.id = doctor.id_especialidad"
                + " and ciudad.id = doctor.id_ciudad and doctor.estado = " + estado + ";";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Doctor docAux = new Doctor();

                Usuario us = new UsuarioDAO().buscar(rs.getInt("id"));
                docAux.setUsuario(us);

                docAux.setPrecio(rs.getInt("precio"));
                docAux.setTiempo_cita(rs.getInt("tiempo_cita"));
                docAux.setEstado(rs.getInt("estado"));
                docAux.setEspecialidad(rs.getString("especialidad.nombre"));
                docAux.setId_especialidad(rs.getInt("id_especialidad"));
                docAux.setCiudad(rs.getString("ciudad.nombre"));
                docAux.setId_ciudad(rs.getInt("id_ciudad"));
                

                list.add(docAux);
            }//fin While
        } catch (Exception e) {

        }

        return list;
    }

    public Doctor buscar(int id) {
        String sql = "SELECT FROM doctor WHERE id=" + id + ";";
        Doctor doc = null;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                doc = new Doctor();

                Usuario us = new UsuarioDAO().buscar(id);
                doc.setUsuario(us);

                doc.setPrecio(rs.getInt("precio"));
                doc.setTiempo_cita(rs.getInt("tiempo_cita"));
                doc.setEstado(rs.getInt("estado"));
                doc.setEspecialidad(rs.getString("especialidad.nombre"));
                doc.setId_especialidad(rs.getInt("id_especialidad"));
                doc.setCiudad(rs.getString("ciudad.nombre"));
                doc.setId_ciudad(rs.getInt("id_ciudad"));
            }//fin while

        } catch (Exception e) {
        }

        return doc;
    }

    public void eliminar(int id){
        String sql = "DELETE FROM doctor WHERE id=" + id + ";";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            UsuarioDAO usDAO = new UsuarioDAO();
            usDAO.eliminar(id);      
        } catch (SQLException e) {
        }
    }
    
    public boolean editar(Doctor doc){
            String sql = "UPDATE doctor set id_usuario"+doc.getUsuario().getId()+
            ",precio="+doc.getPrecio()+",tiempo_cita="+doc.getTiempo_cita()+
            ",estado="+doc.getEstado()+",id_especialidad="+doc.getId_especialidad()+
            "id_ciudad="+doc.getId_ciudad()+" WHERE id_usuario="+doc.getUsuario().getId()+
            ";";
        
        try{
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
            UsuarioDAO usDAO = new UsuarioDAO();
            usDAO.editar(doc.getUsuario());
            
            return true;
            
        } catch (SQLException e) {
        }
        
        return false;
    }
    
}
