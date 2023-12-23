/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Observador.Observable;
import java.util.ArrayList;
import modelo.Apuestas.TipoApuesta;
import modelo.Crupier;
import modelo.Efectos.Efecto;
import modelo.Jugador;
import modelo.Mesa;
import modelo.SistemaJuego;
import modelo.SistemaUsuario;

/**
 *
 * @author acarretto
 */
public class Fachada extends Observable{

    
    public enum eventos {seAgregoMesa, seCerroMesa}; 
    //Defino los eventos
    
    private static Fachada f = new Fachada();

    public SistemaJuego sj = new SistemaJuego();
    public SistemaUsuario su = new SistemaUsuario();
    
    public static Fachada getFachada() {
        return f;
    }

    private Fachada() {
    }

    //---------------------------------------------------------------------

    public Crupier obtenerCrupier(int cd) {
        return su.obtenerCrupier(cd);
    }

    public Jugador obtenerJugador(int cd) {
        return su.obtenerJugador(cd);
    }

    public ArrayList<TipoApuesta> getTiposDeApuestaNoObligatorios() {
        return sj.getTiposDeApuestaNoObligatorios();
    }

    public ArrayList<TipoApuesta> dameTiposDeApuestaObligatorios() {
        return sj.dameTiposDeApuestaObligatorios();
    }
    
    
    public void agregarJugador(int cd, String nomCompleto, String pass, double saldoInicial){
         su.agregarJugador(cd, nomCompleto, pass, saldoInicial);
    }
    
    
     public void agregarCrupier(int cd,String nomCompleto, String pass){
         su.agregarCrupier(cd, nomCompleto, pass, null);
    }
    
    
    public Jugador loginJugador(int cd, String pass) {
       return su.LoginJugador(cd, pass);
        
    }

    
    public Crupier LoginCrupier(int cd, String pass) {
    return su.LoginCrupier(cd, pass);
    
    }

    public void agregarMesa(Crupier c) {
        sj.agregarMesa(c);
    }

    public void agregarTipo(String nombre,int factorPago, boolean obligatorio, boolean esDirecta) {
        sj.agregarTipo(nombre,factorPago, obligatorio, esDirecta);
    }

    public void agregarEfecto(String nombre) {
        sj.agregarEfecto(nombre);
    }

    public ArrayList<TipoApuesta> getTiposDeApuesta() {
        return sj.getTiposDeApuesta();
    }

    public ArrayList<Efecto> getListaEfectos() {
        return sj.getListaEfectos();
    }

    public void agregarMesaHabilitada(Mesa m) {
        sj.agregarMesaHabilitada(m);
       
    }

    public void cerrarMesaHabilitada(Mesa m) {
        sj.cerrarMesaHabilitada(m);
    }
    

    public ArrayList<Mesa> getMesasHabilitadas() {
        return sj.getMesasHabilitadas();
    }

  
  
   
    
    
    
    
    
}
