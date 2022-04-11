package Modelo;


public class Doctor {
    private String especialidad;
    private int id_especialidad;
    private String ciudad;
    private int id_ciudad;
    private int precio;
    private int tiempo_cita;
    Usuario usuario;
    private int estado;//activo o en espera de confirmar registro
    //List<Dia> horario
    
    
    public Doctor() {
    }

    public Doctor(String especialidad, int id_especialidad, String ciudad, int id_ciudad, int precio, int tiempo_cita, Usuario usuario, int estado) {
        this.especialidad = especialidad;
        this.id_especialidad = id_especialidad;
        this.ciudad = ciudad;
        this.id_ciudad = id_ciudad;
        this.precio = precio;
        this.tiempo_cita = tiempo_cita;
        this.usuario = usuario;
        this.estado = estado;
    }

    

    

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    
    
    
}
