package me.gonzager.ex.operaciones.Drones;

import me.gonzager.ex.operaciones.Misiones.Mision;

public abstract class Dron {
    protected Integer autonomia;
    protected final Integer procesamiento;
    protected Mision mision;

    protected Dron(Integer autonomia, Integer procesamiento) {
        this.autonomia = autonomia;
        this.procesamiento = procesamiento;
    }

    public Integer eficienciaOperativa() {
        return this.autonomia * 10 + mision.eficienciaOperativa();
    }

    public void reducirAutonomiaEn(Integer horas){
        if(horas > this.autonomia) throw new IllegalArgumentException("No se puede reducir la autonomia en más horas de las que tiene");
        this.autonomia -= horas;
    }

    public Integer getAutonomia() {
        return autonomia;
    }

    public Integer getProcesamiento() {
        return procesamiento;
    }

    public Mision getMision() {
        return mision;
    }

    public void setMision(Mision mision) {
        this.mision = mision;
    }

    public Boolean esAvanzado() {
        return this.esDronAvanzado() || this.estaEnMisionAvanzada();
    }

    public abstract Boolean esDronAvanzado();

    public Boolean estaEnMisionAvanzada(){
        return mision.estaEnMisionAvanzada(this);
    };
}
