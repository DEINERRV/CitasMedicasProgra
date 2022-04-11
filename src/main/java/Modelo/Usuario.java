package Modelo;


public class Usuario {
    private int id;
    private String contrasena;
    private String nombre;
    private int tipo;
    private String telefono;
    private String correo;

    public Usuario() {
    }

    public Usuario(int id, String contrasena, String nombre, int tipo, String telefono, String correo) {
        this.id = id;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.tipo = tipo;
        this.telefono = telefono;
        this.correo = correo;
    }

    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
}
