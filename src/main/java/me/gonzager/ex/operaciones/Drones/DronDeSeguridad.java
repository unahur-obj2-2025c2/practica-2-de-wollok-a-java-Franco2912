package me.gonzager.ex.operaciones.Drones;

//import me.gonzager.ex.operaciones.Misiones.Mision;

public class DronDeSeguridad extends Dron {

    public DronDeSeguridad(Integer autonomia, Integer procesamiento) {
        super(autonomia, procesamiento);
    }


    @Override
    public Boolean esDronAvanzado() {
        return procesamiento > 50;
    }

}
