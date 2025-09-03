package me.gonzager.ex.operaciones;

import java.util.ArrayList;
import java.util.List;

import me.gonzager.ex.operaciones.Drones.Dron;

public class Escuadron {
    private static Integer cantidadMaxima = 10;
    private final List<Dron> drones = new ArrayList<>();

    public static Integer getCantidadMaximaDeDrones() {
        return cantidadMaxima;
    }

    public List<Dron> getDrones() {
        return drones;
    }

    public static void setCantidadMaxima(Integer cantidadMaxima) {
        Escuadron.cantidadMaxima = cantidadMaxima;
    }

    public void agregarDron(Dron dron) {
        if (drones.size() >= Escuadron.cantidadMaxima)
            throw new IllegalArgumentException("Supera la cantidad máxima de drones");
        drones.add(dron);
    }

    public void retirarDron(Dron dron) {
        drones.remove(dron);
    }

    public Integer capacidadOperativaEscuadron() {
        return drones.stream().map(Dron::eficienciaOperativa).reduce(0, Integer::sum);
    }

    public boolean puedeOperar(Zona zona) {
        return this.alMenosUnDronAvanazado() && this.capacidadOperativaEscuadron() > 2 * zona.getTamanoTotal();
    }

    private boolean alMenosUnDronAvanazado() {
        return drones.stream().anyMatch(Dron::esAvanzado);
    }

    public void OperarEnZona(Zona zona){
        if(!this.puedeOperar(zona)) throw new IllegalArgumentException("El escuadron no puede operar en la zona");
        zona.sumarOperacion();
        drones.forEach(dron -> dron.reducirAutonomiaEn(2));
    }

    

}
