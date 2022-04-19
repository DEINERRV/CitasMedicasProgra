package ModeloDAO;

import Config.Conexion;
import Modelo.Cita;
import Modelo.Doctor;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class CitaDAO {
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    
     public boolean agregar(Cita cita){
        String sql = "INSERT INTO cita(id_doc,id_pac,fecha,hora) VALUES(?,?,?,?);";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cita.getDoc().getUsuario().getId());
            ps.setInt(2, cita.getPac().getId());
            ps.setDate(3, Date.valueOf(cita.getDia()));
            ps.setTime(4, Time.valueOf(cita.getHora()));
            ps.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
     
     private List listar(String sql) {
        ArrayList<Cita> list = new ArrayList<>();

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cita citaAux = new Cita();
                
                Doctor doc = new DoctorDAO().buscar(rs.getInt("id_doc"));
                Usuario us = new UsuarioDAO().buscar(rs.getInt("id_pac"));
                
               citaAux.setDoc(doc);
               citaAux.setPac(us);
               
               Time hor = rs.getTime("hora");
               citaAux.setHora(LocalTime.of(hor.getHours(), hor.getMinutes()));

               Date dia = rs.getDate("fecha");
               citaAux.setDia(dia.toLocalDate());
               
                list.add(citaAux);
            }//fin While
        } catch (Exception e) {

        }

        return list;
    }
    
    public List listarXDoc(int id_doc){
        String sql = "SELECT * FROM cita WHERE id_doc="+id_doc+";";
        return this.listar(sql);
    }
    public List listarXDocFecha(int id_doc,LocalDate fecha){
        String sql = "SELECT * FROM cita WHERE id_doc="+id_doc+" AND  fecha LIKE '"+Date.valueOf(fecha)+"';";
        return this.listar(sql);
    }
    

}
