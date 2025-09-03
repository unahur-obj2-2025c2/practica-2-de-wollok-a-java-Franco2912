package me.gonzager.ex.operaciones.Misiones;

import me.gonzager.ex.operaciones.Drones.Dron;

public interface  Mision {

    Integer eficienciaOperativa();

    Boolean estaEnMisionAvanzada(Dron dron);

}
