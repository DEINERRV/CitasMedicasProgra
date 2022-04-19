package Modelo;

import java.util.ArrayList;
import java.util.List;


public class Doctor {
    Especialidad especialidad;
    Ciudad ciudad;
    private int precio;
    private int tiempo_cita;
    Usuario usuario;
    private int estado;//activo o en espera de confirmar registro
    private Horario horario;
    private List<Cita> slots;
    
    
    public Doctor() {
        this.slots = new ArrayList();
    }

    public Doctor(Especialidad especialidad, Ciudad ciudad, int precio, int tiempo_cita, Usuario usuario, int estado) {
        this.especialidad = especialidad;
        this.ciudad = ciudad;
        this.precio = precio;
        this.tiempo_cita = tiempo_cita;
        this.usuario = usuario;
        this.estado = estado;
        this.slots = new ArrayList();
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTiempo_cita() {
        return tiempo_cita;
    }

    public void setTiempo_cita(int tiempo_cita) {
        this.tiempo_cita = tiempo_cita;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<Cita> getSlots() {
        return slots;
    }

    public void setSlots(List<Cita> slots) {
        this.slots = slots;
    }

    public void AddSlots(List<Cita> slots){
        for(Cita c:slots){
            this.slots.add(c);
        }
    }

    
}
