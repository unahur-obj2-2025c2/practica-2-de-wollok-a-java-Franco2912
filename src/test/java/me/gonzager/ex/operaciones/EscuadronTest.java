package me.gonzager.ex.operaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.gonzager.ex.operaciones.Drones.Dron;
import me.gonzager.ex.operaciones.Drones.DronComercial;
import me.gonzager.ex.operaciones.Drones.DronDeSeguridad;
import me.gonzager.ex.operaciones.Misiones.MisionDeTransporte;
import me.gonzager.ex.operaciones.Misiones.MisionVigilancia;
import me.gonzager.ex.operaciones.Misiones.MisionExploracion;
import me.gonzager.ex.operaciones.Sensores.Sensor;


public class EscuadronTest {
    Escuadron escuadronComercial = new Escuadron();
    Escuadron escuadronAvanzado = new Escuadron();
    private final Dron dronComercial = new DronComercial(2, 10);
    private final Dron dronSeguridad = new DronDeSeguridad(8, 52);

    private final MisionVigilancia   misionVigilancia   = new MisionVigilancia();
    private final MisionDeTransporte misionTransporte = new MisionDeTransporte();
    private final MisionExploracion  misionExploracion = new MisionExploracion();

    private final Sensor sensorBasico       = new Sensor(10, 30, false);
    private final Sensor sensorAvanzado     = new Sensor(20, 50, true);

    private final Zona zonaPequenia = new Zona(50);
    //private final Zona zonaMediana  = new Zona(150);
    //private final Zona zonaGrande   = new Zona(300);

    @BeforeEach
    void init() {
        misionVigilancia.agregarSensor(sensorBasico);
        misionVigilancia.agregarSensor(sensorAvanzado);

        dronComercial.setMision(misionTransporte);
        dronSeguridad.setMision(misionVigilancia);

        escuadronComercial.agregarDron(dronComercial);
        escuadronAvanzado.agregarDron(dronSeguridad);
        escuadronAvanzado.agregarDron(dronComercial);
    }

    @Test()
    void testNoSepuedeAgregarMasDronesDelLimiteMaximoDeCapacidad() {
        // Llenamos el escuadrón hasta el máximo
        for (int i = escuadronComercial.getDrones().size(); i < Escuadron.getCantidadMaximaDeDrones(); i++) {
        escuadronComercial.agregarDron(new DronComercial(1, 10));
        }
        
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,() -> escuadronComercial.agregarDron(new DronComercial(1, 10)));

        assertEquals("Supera la cantidad máxima de drones", ex.getMessage());
        assertEquals(Escuadron.getCantidadMaximaDeDrones(), escuadronComercial.getDrones().size());
    }

    @Test
    void testNoSePuedeOperarZonar(){
        assertFalse(escuadronComercial.puedeOperar(zonaPequenia));
    }

    @Test
    void testSePuedeOperarZonar(){
        assertTrue(escuadronAvanzado.puedeOperar(zonaPequenia));
    }

    @Test()
    void operarZona() {
        escuadronAvanzado.OperarEnZona(zonaPequenia);
        assertEquals(1, zonaPequenia.getCantidadOperaciones());
        assertEquals(6, dronSeguridad.getAutonomia());
        assertEquals(0, dronComercial.getAutonomia());
    }

}
