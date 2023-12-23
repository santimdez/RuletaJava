/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import modelo.Fachada;
import modelo.Jugador;
import modelo.Mesa;

/**
 *
 * @author acarretto
 */
public class ControladorEntrarAMesa implements Observador{

    public VistaEntrarAMesa vista;
    private Jugador j;
    Fachada f = Fachada.getFachada();

    public ControladorEntrarAMesa(VistaEntrarAMesa v, Jugador j) {
        this.vista = v;
        this.j = j;
        f.agregarObservador(this);
        cargarMesasIniciales();
        actualizarNombre();
    }

    public Fachada getF() {
        return f;
    }

    public Jugador getJ() {
        return j;
    }
    
    public void cargarMesasIniciales(){
        vista.cargarMesasIniciales(f.getMesasHabilitadas());
    }
    
     public void actualizarNombre() {
       vista.actualizarNombre(this.j);
    }
     
    public void entrarALaMesa(Mesa m){
        if(!j.getMesasActuales().contains(m)){
            m.agregarJugadorAMesa(j);
            
            vista.proximoCasoDeUso(this.getJ(), m);
        }else{
            vista.error("Ya entro a dicha mesa");
          }
    }
    
    
   
    @Override
    public void actualizar(Object evento, Observable aThis) {
            
            if(evento.equals(Fachada.eventos.seAgregoMesa) || evento.equals(Fachada.eventos.seCerroMesa)){
            vista.cargarMesasIniciales(f.getMesasHabilitadas());
            }
            
            
        
    }

   
    
    
    
    
    
}
