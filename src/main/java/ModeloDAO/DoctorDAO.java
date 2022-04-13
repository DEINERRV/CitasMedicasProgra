package ModeloDAO;

import Config.Conexion;
import Modelo.Ciudad;
import Modelo.Doctor;
import Modelo.Especialidad;
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

    private List listar(String sql) {
        ArrayList<Doctor> list = new ArrayList<>();

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Doctor docAux = new Doctor();

                Usuario us = new UsuarioDAO().buscar(rs.getInt("id_usuario"));
                Especialidad esp = new EspecialidadDAO().buscar(rs.getInt("id_especialidad"));
                Ciudad ciu = new CiudadDAO().buscar(rs.getInt("id_ciudad"));

                docAux.setUsuario(us);
                docAux.setEspecialidad(esp);
                docAux.setCiudad(ciu);

                docAux.setPrecio(rs.getInt("precio"));
                docAux.setTiempo_cita(rs.getInt("tiempo_cita"));
                docAux.setEstado(rs.getInt("estado"));

                list.add(docAux);
            }//fin While
        } catch (Exception e) {

        }

        return list;
    }
    
    public List listarXespecialidad(int id_esp){
        String sql = "SELECT * FROM doctor WHERE id_especialidad="+id_esp+";";
        return this.listar(sql);
    }
    public List listarXciudad(int id_ciudad){
        String sql = "SELECT * FROM doctor WHERE id_ciudad="+id_ciudad+";";
        return this.listar(sql);
    }
    public List listarXestado(int estado){
        String sql = "SELECT * FROM doctor WHERE estado="+estado+";";
        return this.listar(sql);
    }
    

    public Doctor buscar(int id) {
        String sql = "SELECT * FROM doctor WHERE id_usuario=" + id + ";";
        Doctor doc = null;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                doc = new Doctor();

                Usuario us = new UsuarioDAO().buscar(rs.getInt("id_usuario"));
                Especialidad esp = new EspecialidadDAO().buscar(rs.getInt("id_especialidad"));
                Ciudad ciu = new CiudadDAO().buscar(rs.getInt("id_ciudad"));

                doc.setUsuario(us);
                doc.setEspecialidad(esp);
                doc.setCiudad(ciu);

                doc.setPrecio(rs.getInt("precio"));
                doc.setTiempo_cita(rs.getInt("tiempo_cita"));
                doc.setEstado(rs.getInt("estado"));
            }//fin while

        } catch (Exception e) {
        }

        return doc;
    }

    public void eliminar(int id) {
        String sql = "DELETE * FROM doctor WHERE id_usuario=" + id + ";";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            UsuarioDAO usDAO = new UsuarioDAO();
            usDAO.eliminar(id);
        } catch (SQLException e) {
        }
    }

    public boolean editar(Doctor doc) {
        String sql = "UPDATE doctor SET id_usuario=?, precio=?,tiempo_cita=?, estado=?,"
                + "id_especialidad=?, id_ciudad=? WHERE id_usuario=?;";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, doc.getUsuario().getId());
            ps.setInt(2, doc.getPrecio());
            ps.setInt(3, doc.getTiempo_cita());
            ps.setInt(4, doc.getEstado());
            ps.setInt(5, doc.getEspecialidad().getId());
            ps.setInt(6, doc.getCiudad().getId());
            ps.setInt(7, doc.getUsuario().getId());
            
            ps.executeUpdate();

            UsuarioDAO usDAO = new UsuarioDAO();
            usDAO.editar(doc.getUsuario());

            return true;

        } catch (SQLException e) {
        }

        return false;
    }
    
    public boolean agregar(Doctor doc){
        String sql = "INSERT INTO doctor(id_usuario,precio,tiempo_cita, estado,"
                + "id_especialidad,id_ciudad) VALUES(?,?,?,?,?,?);";

        try {
            UsuarioDAO usDAO = new UsuarioDAO();
            usDAO.agregar(doc.getUsuario());
            
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, doc.getUsuario().getId());
            ps.setInt(2, doc.getPrecio());
            ps.setInt(3, doc.getTiempo_cita());
            ps.setInt(4, doc.getEstado());
            ps.setInt(5, doc.getEspecialidad().getId());
            ps.setInt(6, doc.getCiudad().getId());
            rs = ps.executeQuery();
            
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
