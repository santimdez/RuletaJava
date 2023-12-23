/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import modelo.Apuestas.Color;
import modelo.Apuestas.Directa;
import modelo.Apuestas.Docena;
import modelo.Apuestas.TipoApuesta;
import modelo.Efectos.Completo;
import modelo.Efectos.Efecto;
import modelo.Efectos.Parcial;
import modelo.Efectos.Simulador;
import modelo.Fachada.eventos;
import static modelo.Fachada.eventos.seCerroMesa;

/**
 *
 * @author acarretto
 */
public class SistemaJuego {
    
    
    private ArrayList<Mesa> mesasTotales = new ArrayList<>();
    private ArrayList<Mesa> mesasHabilitadas = new ArrayList<>();
    private ArrayList<TipoApuesta> tiposDeApuesta = new ArrayList<>();
    private ArrayList<Efecto> listaEfectos = new ArrayList<>();

    
    
    

    public void agregarMesa(Crupier c){
        Mesa m = new Mesa(c);
        System.out.println(m.getNumMesa());
        mesasTotales.add(m);
    }
        
    public void agregarMesaHabilitada(Mesa m){
        
        mesasHabilitadas.add(m);
       // m.nuevaRonda();
        Fachada.getFachada().avisar(eventos.seAgregoMesa);
        
    }
    
    public void cerrarMesaHabilitada(Mesa m){
        m.setHabilitada(false);
        mesasHabilitadas.remove(m);
        Fachada.getFachada().avisar(seCerroMesa);
    }
    
    
    public void agregarTipo(String nombre,int factorPago, boolean obligatorio, boolean esDirecta){
        TipoApuesta ta = CrearTipoApuesta(nombre,factorPago, obligatorio, esDirecta);
        tiposDeApuesta.add(ta);
    }
    
    public void agregarEfecto(String nombre){
        Efecto e = CrearEfecto(nombre);
        listaEfectos.add(e);
    }
    
    
    public ArrayList<Mesa> getMesasTotales() {
        return mesasTotales;
    }
    
   
    
    public Mesa obtenerMesa(int numMesa){
        
        for(Mesa m:mesasTotales){
            if(m.getNumMesa() == numMesa){
                return m;
            }
        }
        return null;
        
    }

     public ArrayList<TipoApuesta> getTiposDeApuestaNoObligatorios() {
       ArrayList<TipoApuesta> taS = new ArrayList<>();
        for(TipoApuesta t: tiposDeApuesta){
            if(!t.isObligatorio()){
                taS.add(t);
            }
            
        }
        return taS;
     }
    
    private TipoApuesta CrearTipoApuesta(String nombre, int factorPago, boolean obligatorio, boolean esDirecta) {
        switch (nombre) {
            case "Color":
                return new Color(nombre,factorPago, obligatorio, esDirecta);
            case "Directa":
                return new Directa(nombre,factorPago, obligatorio, esDirecta);
            case "Docena":
                return new Docena(nombre,factorPago, obligatorio, esDirecta);
            default:
                return null;
        }
    }

    private Efecto CrearEfecto(String nombre) {
        switch (nombre) {
            case "Completo":
                return new Completo(nombre);
            case "Parcial":
                return new Parcial(nombre);
            case "Simulador":
                return new Simulador(nombre);
            default:
                return null;
    
        }
    }
    public ArrayList<TipoApuesta> dameTiposDeApuestaObligatorios(){
        ArrayList<TipoApuesta> taS = new ArrayList<>();
        for(TipoApuesta t: tiposDeApuesta){
            if(t.isObligatorio()){
                taS.add(t);
            }
        
    }
        
        return taS;
    }

    public ArrayList<Mesa> getMesasHabilitadas() {
        return mesasHabilitadas;
    }

    
    public ArrayList<TipoApuesta> getTiposDeApuesta() {
        return tiposDeApuesta;
    }

    public ArrayList<Efecto> getListaEfectos() {
        return listaEfectos;
    }

 

    
    
    
    
}
