/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observador;

import java.util.ArrayList;

/**
 *
 * @author acarretto
 */
public class Observable {
    

    private ArrayList<Observador> observadores = new ArrayList();
    
    public void agregarObservador(Observador o){
        if(!observadores.contains(o)){
            observadores.add(o);
        }
    }
    
    public void quitarObservador(Observador o){
        observadores.remove(o);
    }
    
    public void avisar(Object evento){
        ArrayList<Observador> copia = new ArrayList(observadores);
        for(Observador obs:copia){
            obs.actualizar(evento, this);
        }
    }
}


