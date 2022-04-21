package ModeloDAO;

import Config.Conexion;
import Modelo.Dia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class DiaDAO {
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;

    public boolean agregar(Dia dia,int id_doc){
        String sql = "INSERT INTO dia(id_doc,num_dia,hora_inicio,hora_final) VALUES(?,?,?,?);";

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_doc);
            ps.setInt(2, dia.getId());
            ps.setTime(3, Time.valueOf(dia.getHora_inicio()));
            ps.setTime(4, Time.valueOf(dia.getHora_final()));
            ps.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    
     public List listar(int id_doc){
        String sql = "SELECT * FROM dia WHERE id_doc="+id_doc+";";
        List<Dia> dias = new ArrayList();
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Dia diaAux = new Dia();
                diaAux.setId(rs.getInt("num_dia"));
                Time hi = rs.getTime("hora_inicio");
                Time hf = rs.getTime("hora_final");
                diaAux.setHora_inicio(LocalTime.of(hi.getHours(), hi.getMinutes()));
                diaAux.setHora_final(LocalTime.of(hf.getHours(), hf.getMinutes()));
                dias.add(diaAux);
                
            }//fin While
        } catch (Exception e) {
        }
        
        return dias;
    }
     
     
    public void eliminar(int id_doc) {
        String sql = "DELETE FROM dia WHERE id_doc=" + id_doc + ";";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
        }
    }
 
}
