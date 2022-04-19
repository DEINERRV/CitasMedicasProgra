package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Dia {

    int id;//lunes = 1, martes = 2, miercoles = 3,...
    LocalTime hora_inicio;
    LocalTime hora_final;

    public Dia() {
    }

    public Dia(int id, LocalTime hora_inicio, LocalTime hora_final) {
        this.id = id;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_final() {
        return hora_final;
    }

    public void setHora_final(LocalTime hora_final) {
        this.hora_final = hora_final;
    }

    public List getSlots(int tiempo, LocalDate dia, List<Cita> citasRes, boolean flag) {
        LocalTime time = this.hora_inicio;
        List slots = new ArrayList();
        LocalTime now = LocalTime.now();
        while (time.isBefore(hora_final)) {
            boolean ok = false;
            if (flag) {
                if (time.isAfter(now)) {
                    if (citasRes != null) {
                        for (Cita c : citasRes) {
                            if (c.getHora().equals(time)) {
                                slots.add(c);
                                ok = true;
                                break;
                            }
                        }
                    }
                    if (!ok) {
                        slots.add(new Cita(null, null, dia, time));
                    }
                }
            } else {
                if (citasRes != null) {
                    for (Cita c : citasRes) {
                        if (c.getHora().equals(time)) {
                            slots.add(c);
                            ok = true;
                            break;
                        }
                    }
                }
                if (!ok) {
                    slots.add(new Cita(null, null, dia, time));
                }
            }

            time = time.plusMinutes(tiempo);
        }

        return slots;
    }

}
