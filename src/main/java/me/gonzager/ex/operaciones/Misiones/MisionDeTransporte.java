package me.gonzager.ex.operaciones.Misiones;

import me.gonzager.ex.operaciones.Drones.Dron;

public class MisionDeTransporte implements Mision {

    @Override
    public Integer eficienciaOperativa() {
        return 100;
    }

    @Override
    public Boolean estaEnMisionAvanzada(Dron dron) {
        return dron.getAutonomia() > 50;
    }

}
