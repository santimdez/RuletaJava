/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author acarretto
 */
public class SistemaUsuario {
    
    
    private ArrayList<Crupier> crupiers = new ArrayList<>();
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    


    public ArrayList<Crupier> getCrupiers() {
        return crupiers;
    }

    public void setCrupiers(ArrayList<Crupier> crupiers) {
        this.crupiers = crupiers;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    
    
    //login: cd, pass, sldInicial 5Jugador
    public void agregarJugador(int cd, String nomCompleto,String pass, double saldoInicial){
        
        Jugador j = new Jugador(cd, nomCompleto, pass, saldoInicial) ;
        jugadores.add(j);
   //     usuarios.add(j);
        
    }
    
    
    //login: cd, pass  3Crupiers
    public void agregarCrupier(int cd, String nomCompleto, String pass, Mesa mesaAsignada){
        
        Crupier c = new Crupier(cd, nomCompleto, pass, mesaAsignada);
        crupiers.add(c);
  //      usuarios.add(c);
        
        
    }
    
    
    
    
    public Jugador LoginJugador(int cd, String pass){
        
        Usuario u = buscarUsuario(cd, pass, jugadores) ;
        Jugador j = (Jugador)u;
        
        
        return j;
        
    }
    
    
    public Crupier LoginCrupier(int cd, String pass){
        
        Usuario u = buscarUsuario(cd, pass, crupiers) ;
        Crupier c = (Crupier)u;
        
        return c;
        
    }
    
    
    public Crupier obtenerCrupier(int cd){
        for(Crupier c:crupiers){
            if(c.getCedula() == cd) return c;
        }
        return null;
    }
    
    public Jugador obtenerJugador (int cd){
        for(Jugador j:jugadores){
            if(j.getCedula() == cd) return j;
        }
        return null;
    }
    
    
    
    
    
     private Usuario buscarUsuario(int cd, String pass, ArrayList lista){
        Usuario u;
        for(Object o:lista){
            u = (Usuario)o;
            if(u.getCedula() == cd && u.getPassword().equals(pass)){
                return u;
            }
        }
        return null;
    }
     
     
    
    
   
}
