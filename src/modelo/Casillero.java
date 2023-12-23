/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import modelo.Apuestas.TipoApuesta;

/**
 *
 * @author acarretto
 */
public class Casillero {
    
    private int ucc;
    
    private ArrayList<Apuesta> apuestasDelCasillero = new ArrayList<>();
    
    private ArrayList<Numero> numeros = new ArrayList<>();  //1-18
    
    
    
    
    public Casillero(int ucc, ArrayList<Numero> numeros) {
        this.ucc = ucc;
        this.numeros = numeros;
    }




    public ArrayList<Apuesta> getApuestasCasillero() {
        return apuestasDelCasillero;
    }


    public int getUcc() {
        return ucc;
    }

    public void setUcc(int ucc) {
        this.ucc = ucc;
    }

    public ArrayList<Numero> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Numero> numeros) {
        this.numeros = numeros;
    }

    public Apuesta apuestaNueva(Jugador j, int valor) {
        Apuesta a = new Apuesta(j, valor, this);
        j.getApuestasDelJugador().add(a);
        j.setUltimaApuesta(a);
        apuestasDelCasillero.add(a);
       return a;
    }
    
    
    
}
