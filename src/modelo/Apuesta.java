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
public class Apuesta {
    
   // private Numero ucc;
    private Casillero casillero;
    private Jugador jugador;
    private Ronda ronda;
    private int valor;
    
    
    
   // private ArrayList<TipoApuesta> tiposApuesta = new ArrayList<>();
            
    
    
    public Apuesta(Jugador j, int valor, Casillero cas) {
        this.valor = valor;
        this.jugador = j;
        this.casillero = cas;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

//    public ArrayList<TipoApuesta> getTiposApuesta() {
//        return tiposApuesta;
//    }

    public Casillero getCasillero() {
        return casillero;
    }
    
    
    public int getValor() {
        return valor;
    }

//    public Numero getUcc() {
//        return ucc;
//    }
    
    public int getGanancia() {
        
        if(casillero.getUcc()>=0 && casillero.getUcc()<= 36){
            return valor*36;
        }else if(casillero.getUcc()>=40 && casillero.getUcc()<= 42){
            return valor*3;
        }else if(casillero.getUcc()>=43 && casillero.getUcc()<=44){
            return valor*2;
        }
        return 0;
    }

    
    
    @Override
    public String toString() {
        return "Apuesta al "+this.casillero.getUcc()+"/  El jugador: "+this.jugador.getNomCompleto()+"/  Una cantidad de: "+this.valor;
    }

    
    
    
    
}
