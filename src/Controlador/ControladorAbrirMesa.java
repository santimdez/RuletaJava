/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.MesaException;
import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Apuestas.TipoApuesta;
import modelo.Crupier;
import modelo.Fachada;
import modelo.Mesa;

/**
 *
 * @author acarretto
 */
public class ControladorAbrirMesa implements Observador {
    
    private VistaAbrirMesa vista;
    private Crupier c;
    private ArrayList<TipoApuesta> tiposApuestaCombo;
    private ArrayList<TipoApuesta> tiposApuestaList;
    Fachada f = Fachada.getFachada();

    public ControladorAbrirMesa(VistaAbrirMesa v, Crupier c) {
        this.vista = v;
        this.c = c;
        //c.getMesaAsignada().agregarObservador(this);
        tiposApuestaCombo = f.getTiposDeApuestaNoObligatorios();
        tiposApuestaList = f.dameTiposDeApuestaObligatorios();
        mostrarTiposApuestaLista();
        mostrarTiposApuestaCombo();
        actualizarMesasHabilitadas();
        
 
    }

    public ControladorAbrirMesa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void salir(){
      //f.quitarObservador(this);
    }


    public Crupier getC() {
        return c;
    }
    
   public void abrirMesa() {
       try{
       if(c.getMesaAsignada().isHabilitada()){
           throw new MesaException("Esta Mesa ya esta habilitada");
       }else{
       c.getMesaAsignada().setHabilitada(true);
       c.getMesaAsignada().actualizoTA(tiposApuestaList);
       f.agregarMesaHabilitada(c.getMesaAsignada());
       vista.abrirPanel();
       
       }
       } catch (MesaException ex) {
            vista.error(ex.getMessage());
        }
    }
   
   
    @Override
    public void actualizar(Object evento, Observable aThis) {
        
     
      
     } 
    
    
    
    
    public void agregarTipo(TipoApuesta ta){
        if(!tiposApuestaList.contains(ta)){
            tiposApuestaList.add(ta);
            mostrarTiposApuestaLista();
        }else{
           vista.error("DENEGADO: El tipo que desea agregar ya esta en la lista");
        }
    }
    
    public void quitarTipo(TipoApuesta ta){
        if(!ta.isObligatorio()){
        tiposApuestaList.remove(ta);
        mostrarTiposApuestaLista();
        }else{
        vista.error("DENEGADO: El tipo que quiere quitar es obligatorio");
        }
    }
    
    
    private void mostrarTiposApuestaLista() {
       vista.mostrarTiposApuestaLista(tiposApuestaList);
    }

    private void mostrarTiposApuestaCombo() {
      vista.mostrarTiposApuestaCombo(tiposApuestaCombo);
    }

    private void actualizarMesasHabilitadas() {
        vista.actualizarMesasHabilitadas(f.getMesasHabilitadas());
    }

    
    
    
    
    
}
