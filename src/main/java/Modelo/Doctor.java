package Modelo;


public class Doctor {
    Especialidad especialidad;
    Ciudad ciudad;
    private int precio;
    private int tiempo_cita;
    Usuario usuario;
    private int estado;//activo o en espera de confirmar registro
    //List<Dia> horario
    
    
    public Doctor() {
    }

    public Doctor(Especialidad especialidad, Ciudad ciudad, int precio, int tiempo_cita, Usuario usuario, int estado) {
        this.especialidad = especialidad;
        this.ciudad = ciudad;
        this.precio = precio;
        this.tiempo_cita = tiempo_cita;
        this.usuario = usuario;
        this.estado = estado;
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

    
    
    
    
}
