package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;


public class Cita {
    Doctor doc;
    Usuario pac;
    LocalDate dia;
    LocalTime hora;
    String nota;

    public Cita() {
    }

    public Cita(Doctor doc, Usuario pac, LocalDate dia, LocalTime hora,String nota) {
        this.doc = doc;
        this.pac = pac;
        this.dia = dia;
        this.hora = hora;
        this.nota = nota;
    }

    public Doctor getDoc() {
        return doc;
    }

    public void setDoc(Doctor doc) {
        this.doc = doc;
    }

    public Usuario getPac() {
        return pac;
    }

    public void setPac(Usuario pac) {
        this.pac = pac;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
}
