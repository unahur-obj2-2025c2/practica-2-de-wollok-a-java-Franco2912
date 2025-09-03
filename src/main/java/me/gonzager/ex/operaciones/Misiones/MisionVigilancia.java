package me.gonzager.ex.operaciones.Misiones;

import me.gonzager.ex.operaciones.Sensores.Sensor;
import me.gonzager.ex.operaciones.Drones.Dron;

import java.util.ArrayList;
import java.util.List;

public class MisionVigilancia implements Mision {
    private final List<Sensor> sensores = new ArrayList<>();

    public void agregarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public void retirarSensor(Sensor sensor) {
        sensores.remove(sensor);
    }

    @Override
    public Integer eficienciaOperativa() {
        return sensores.stream().map(Sensor::eficienciaOperativa).reduce(0, Integer::sum);
    }

    @Override
    public Boolean estaEnMisionAvanzada(Dron dron) {
        return sensores.stream().allMatch(Sensor::esDuradero);
    }

}
