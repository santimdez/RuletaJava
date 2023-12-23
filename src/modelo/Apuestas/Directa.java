/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Apuestas;

import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Casillero;
import modelo.Mesa;
import modelo.Numero;

/**
 *
 * @author acarretto
 */
public class Directa extends TipoApuesta {

    public Directa(String nombre, int factorPago, boolean obligatorio, boolean esDirecta) {
        super(nombre, factorPago, obligatorio, esDirecta);

    }

    @Override
    public ArrayList<Casillero> crearCasilleros() {
        ArrayList<Casillero> casilleros = new ArrayList<>();
        

        for (int i = 0; i < 37; i++) {
            ArrayList<Numero> nums = new ArrayList<>();
            Numero nuevo = new Numero(i);
            nums.add(nuevo);

            casilleros.add(new Casillero(i, nums));
 
        }
        return casilleros;

    }


}
