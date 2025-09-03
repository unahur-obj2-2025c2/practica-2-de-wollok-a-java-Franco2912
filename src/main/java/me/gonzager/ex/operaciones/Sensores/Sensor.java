package me.gonzager.ex.operaciones.Sensores;

public class Sensor {
    private final Integer capacidad;
    private final Integer durabilidad;
    private final Boolean tecnologiaAvanzada;

    public Sensor(Integer capacidad, Integer durabilidad, Boolean tecnologiaAvanzada) {
        if (capacidad == null || durabilidad == null || tecnologiaAvanzada == null) {
        throw new IllegalArgumentException("Ningún valor puede ser null");
    }
        this.capacidad = capacidad;
        this.durabilidad = durabilidad;
        this.tecnologiaAvanzada = tecnologiaAvanzada;
    }

    public Integer eficienciaOperativa() {
        return !tecnologiaAvanzada ? capacidad : capacidad * 2; 
    }

    public boolean esDuradero() {
        return durabilidad > capacidad * 2;
    }

}
