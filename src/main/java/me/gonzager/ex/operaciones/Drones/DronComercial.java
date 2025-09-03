package me.gonzager.ex.operaciones.Drones;

//import me.gonzager.ex.operaciones.Misiones.Mision;

public class DronComercial extends Dron {

    public DronComercial(Integer autonomia, Integer procesamiento) {
        super(autonomia, procesamiento);
    }

    @Override
    public Integer eficienciaOperativa() {
        return super.eficienciaOperativa() + 15;
    }

    @Override
    public Boolean esDronAvanzado() {
        return Boolean.FALSE;
    }

}
