package me.gonzager.ex.operaciones;

public class Zona {
    private final Integer tamanoTotal;
    private Integer cantidadOperaciones = 0;

    public Zona(Integer tamanoTotal) {
        this.tamanoTotal = tamanoTotal;
    }

    public Integer getTamanoTotal() {
        return this.tamanoTotal;
    }

    public Integer getCantidadOperaciones() {
        return this.cantidadOperaciones;
    }

    public void sumarOperacion() {
        this.cantidadOperaciones += 1;
    }

}
