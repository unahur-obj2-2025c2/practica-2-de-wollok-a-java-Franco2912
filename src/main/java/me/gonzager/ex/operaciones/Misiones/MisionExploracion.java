package me.gonzager.ex.operaciones.Misiones;

import me.gonzager.ex.operaciones.Drones.Dron;

public class MisionExploracion implements Mision {

    @Override
    public Integer eficienciaOperativa() {
        return 0;
    }

    @Override
    public Boolean estaEnMisionAvanzada(Dron dron) {
        return dron.eficienciaOperativa() % 2 == 0;
    }

}
