package Modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;


public class Horario {
    List<Dia> dias;

    public Horario() {
    }

    public Horario(List<Dia> dias) {
        this.dias = dias;
    }

    public List<Dia> getDias() {
        return dias;
    }

    public void setDias(List<Dia> dias) {
        this.dias = dias;
    }
    
    public Dia buscarDia(int id){
        for(Dia d:this.dias){
            if(d.getId()==id) return d;
        }
        return null;
    }
    
    public List getSigDias(int cant, LocalDate dia) {
        List diasCitas = new ArrayList();
        boolean flag = true;
        
        if(this.dias.isEmpty()) return diasCitas;
        if(dia.getDayOfWeek().getValue() > dias.get(dias.size()-1).getId()) flag = false;
        
        while (diasCitas.size() < cant) {
            for (int i = 0; i < dias.size(); i++) {
                if (diasCitas.size() == cant) {
                    break;
                }
                int valdia = dias.get(i).getId();
                if (!(valdia < dia.getDayOfWeek().getValue()) || !flag) {
                    dia = dia.with(TemporalAdjusters.nextOrSame(DayOfWeek.of(valdia)));
                    if(!diasCitas.isEmpty() && this.getDias().size()==1){
                        dia = dia.with(TemporalAdjusters.next(DayOfWeek.of(valdia)));
                    }
                    diasCitas.add(dia);
                    flag = false;
                }
            }
        }

        return diasCitas;
    }

    public LocalDate getAntDia(LocalDate dia) {
        LocalDate diaAnt = null;
        boolean flag = false;
        
        for(int i=0;i<dias.size();i++){
            LocalDate aux = dia.with(TemporalAdjusters.previous(DayOfWeek.of(dias.get(i).getId())));
            
            if(diaAnt!=null && diaAnt.isAfter(aux)){
                break;
            }
            else diaAnt = aux;
            
        }
        
        return diaAnt;
    }
    
}
