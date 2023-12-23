/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Apuestas;

import Observador.Observable;
import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Casillero;
import modelo.Mesa;
import modelo.Numero;

/**
 *
 * @author acarretto
 */
public abstract class TipoApuesta{
    
    private int factorPago;
    private String nombre;
    
 //   private ArrayList<Casillero> casilleros = new ArrayList<>();
    
//    public ArrayList<Numero> numRojo = new ArrayList<>();
//    public ArrayList<Numero> numNegro = new ArrayList<>();
//    private ArrayList<Numero> numsUCC = new ArrayList<>();
    private boolean obligatorio;
    private boolean esDirecta;
    
    
    
    
    public TipoApuesta(String nombre, int factorPago, boolean obligatorio, boolean esDirecta) {
        this.nombre = nombre;
        this.factorPago = factorPago;
        this.obligatorio = obligatorio;
        this.esDirecta = esDirecta;
    }

    public boolean isObligatorio() {
        return obligatorio;
    }

    public abstract ArrayList<Casillero> crearCasilleros();
    
  

    @Override
    public String toString() {
        return nombre;
    }
   
   
   
  
}
