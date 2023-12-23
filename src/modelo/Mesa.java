/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Excepciones.ApuestaException;
import Excepciones.MesaException;
import Observador.Observable;
import java.util.ArrayList;
import java.util.Queue;
import modelo.Apuestas.TipoApuesta;
import modelo.Casillero;
import modelo.Crupier;
import modelo.Efectos.Efecto;
import modelo.Jugador;
import static modelo.Mesa.eventos.seCreoRonda;
import static modelo.Mesa.eventos.seDesactivanTiposApuesta;
import modelo.Ronda;

/**
 *
 * @author acarretto
 */
public class Mesa extends Observable {

    public enum eventos {
        seDesactivanTiposApuesta, jugadorNuevo, jugadorSeRetira, seActivanApuestas, seLanzaBola, seCreoRonda, seAposto, cerrarMesa
    }

    private Crupier crupier;

    private int numMesa;

    private static int contador;

    public ArrayList<Jugador> jugadoresActivos = new ArrayList<>();

    public ArrayList<Casillero> casilleros = new ArrayList<>();

    private ArrayList<TipoApuesta> tiposApuestas = new ArrayList<>();

    private ArrayList<Ronda> rondas = new ArrayList<>();

    private Ronda rondaActual;

    private int balanceTotal;

    private boolean habilitada;

    private ArrayList<Integer> ultimos3Numeros = new ArrayList<>();

    public Mesa(Crupier c) {
        this.crupier = c;
        this.contador++;
        this.numMesa = contador;
        this.balanceTotal = 0;
        this.habilitada = false;
        this.crupier.setMesaAsignada(this);
        

    }

    public Ronda getRondaActual() {
        return rondaActual;
    }

    public void setRondaActual(Ronda rondaActual) {
        this.rondaActual = rondaActual;
    }

    public ArrayList<Integer> getUltimos3() {
        return ultimos3Numeros;

    }

    public ArrayList<Integer> getUltimos3Numeros() throws MesaException {
        if (ultimos3Numeros.size() >= 3) {
            return ultimos3Numeros;
        } else {
            throw new MesaException("Aun no se sortearon 3 numeros");
        }
    }

    public void setUltimos3Numeros(ArrayList<Integer> ultimos3Numeros) {
        this.ultimos3Numeros = ultimos3Numeros;
    }

    public void seApuesta(Jugador j, int ucc, int valor) throws ApuestaException {
        rondaActual.seApuesta(j, ucc, valor);
        this.avisar(Mesa.eventos.seAposto);
    }

    public void actualizoTA(ArrayList<TipoApuesta> TAs) {
        ArrayList<TipoApuesta> tiposApuestas2 = new ArrayList<>();
        tiposApuestas = tiposApuestas2;
        tiposApuestas.addAll(TAs);

    }

    public ArrayList<Casillero> getCasilleros() {
        return casilleros;
    }

   

    public ArrayList<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(ArrayList<Ronda> rondas) {
        this.rondas = rondas;
    }

    public ArrayList<TipoApuesta> getTiposApuestas() {
        //avisar(eventos.tipoApuestas);
        return tiposApuestas;
    }

    public void setTiposApuestas(ArrayList<TipoApuesta> tiposApuestas) {
        this.tiposApuestas = tiposApuestas;
    }

    public int lanzarPelota(Efecto e) throws MesaException, ApuestaException {
        return rondaActual.sortearNumero(e);
    }
    //

    public boolean isHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        if(!habilitada){
            this.avisar(eventos.cerrarMesa);
        }
        this.habilitada = habilitada;

        //this.avisar(seDeshabilitoMesa);
    }

    public Crupier getCrupier() {
        return crupier;
    }

    public void setCrupier(Crupier crupier) {
        this.crupier = crupier;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getBalance() {
        return balanceTotal;
    }

    public ArrayList<Jugador> getJugadoresActivos() {
        //avisar(eventos.jugadoresActivos);
        return jugadoresActivos;
    }

    public void setBalance(int balance) {
        this.balanceTotal = balance;
    }

    public void agregarJugadorAMesa(Jugador j) {
        jugadoresActivos.add(j);
        j.getMesasActuales().add(this);
        this.avisar(eventos.jugadorNuevo);
    }

    
    
    public double ocurrencia(int numSorteado) {
        int contador=0;
        for(Ronda r:rondas){
            if(numSorteado == r.getNumSorteado()){
                contador++;
            }
        }
        int cantRondas = rondas.size();
        return (double) contador/cantRondas;
    }
    
    
    
    
    
    public void abandonarMesa(Jugador jugador) throws ApuestaException {

        jugador.validarNoTieneApuesta();
        jugador.getMesasActuales().remove(this);
        this.jugadoresActivos.remove(jugador);
        this.avisar(eventos.jugadorSeRetira);

    }

    public Ronda nuevaRonda() {
        if (rondaActual != null) {
            ultimos3Numeros.add(rondaActual.getNumSorteado());
            if (ultimos3Numeros.size() == 4) {
                ultimos3Numeros.remove(0);
            }
        }

        Ronda r = new Ronda(tiposApuestas, this);
        rondas.add(r);
        rondaActual = r;
        rondaActual.crearCasilleros(tiposApuestas);
        casilleros = rondaActual.getCasillerosDeRonda();
        rondaActual.setBalancePrevio(balanceTotal);
        if (rondas.size() > 1) {
            this.avisar(eventos.seCreoRonda);
        }
        return r;
    }

    
    
    
    
    public boolean JugadorEstaEnMesa(Jugador j, Mesa mesa) {
        if (mesa.jugadoresActivos.contains(j)) {
            return true;
        }
        return false;
    }

    public int ultimoNumero() {
        int i = 0;
        return i;

        ///implementar
    }

    @Override
    public String toString() {
        return "Mesa: " + getNumMesa() + " Crupier: " + getCrupier().getNomCompleto();
    }

    public int getCantApuestas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getMontoTotal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
