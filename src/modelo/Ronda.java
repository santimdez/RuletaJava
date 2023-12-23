/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Excepciones.ApuestaException;
import Excepciones.MesaException;
import Observador.Observable;
import java.util.ArrayList;
import java.util.Random;
import modelo.Apuestas.TipoApuesta;
import modelo.Efectos.Efecto;

/**
 *
 * @author acarretto
 */
public class Ronda extends Observable {

    public enum eventos {
        seCreoRondaNueva, seSorteoNumero, pausarR, reanudarR, sePagoApuestas
    };

    private ArrayList<Casillero> casillerosDeRonda = new ArrayList<>();

    private ArrayList<Apuesta> apuestasJugadores = new ArrayList<>();
    private Mesa mesa;
    private int numSorteado;
    private int balancePrevio;
    private int balancePosterior = 0;
    private int numRonda;
    private int perdidasDeRonda;
    private int gananciasDeRonda;
    private int totalApostado;
    private Efecto efecto;

    public Ronda(ArrayList<TipoApuesta> tiposApuestas, Mesa mesa) {
        this.mesa = mesa;

    }

    public void crearCasilleros(ArrayList<TipoApuesta> tiposApuestas) {
        for (TipoApuesta ta : tiposApuestas) {
            casillerosDeRonda.addAll(ta.crearCasilleros());
        }

    }

    public ArrayList<Casillero> getCasillerosDeRonda() {
        return casillerosDeRonda;
    }

    public void setCasillerosDeRonda(ArrayList<Casillero> casillerosDeRonda) {
        this.casillerosDeRonda = casillerosDeRonda;
    }

    public int getBalancePrevio() {
        return balancePrevio;
    }

    public void setBalancePrevio(int balancePrevio) {
        this.balancePrevio = balancePrevio;
    }

    public int getBalancePosterior() {
        return balancePosterior;
    }

    public void setBalancePosterior(int balancePosterior) {
        this.balancePosterior = balancePosterior;
    }

    public ArrayList<Apuesta> getApuestasJugadores() {
        return apuestasJugadores;
    }

    public ArrayList<Apuesta> ApuestasJugadores() throws ApuestaException {
        if (apuestasJugadores.isEmpty()) {
            throw new ApuestaException("No hay apuestas en la mesa aun");
        }
        return apuestasJugadores;
    }

    public void setApuestasJugadores(ArrayList<Apuesta> apuestasJugadores) {
        this.apuestasJugadores = apuestasJugadores;
    }

    public int getNumSorteado() {
        return numSorteado;
    }

    public void setNumSorteado(int numSorteado) {
        this.numSorteado = numSorteado;
    }

    public int getNumRonda() {
        return numRonda;
    }

    public void setNumRonda(int numRonda) {
        this.numRonda = numRonda;
    }

    public int getApuestasGanadoras() {
        return perdidasDeRonda;
    }

    public void setApuestasGanadoras(int apuestasGanadoras) {
        this.perdidasDeRonda = apuestasGanadoras;
    }

    public int getApuestasPerdedoras() {
        return gananciasDeRonda;
    }

    public void setApuestasPerdedoras(int apuestasPerdedoras) {
        this.gananciasDeRonda = apuestasPerdedoras;
    }

    public int getTotalApostado() {
        return totalApostado;
    }

    public void setTotalApostado(int totalApostado) {
        this.totalApostado = totalApostado;
    }

    public String BalanceDeDinero() {
        return "";
    }

    public int ApuestasTotales() {
        return perdidasDeRonda + gananciasDeRonda;
    }

    public int sortearNumero(Efecto e) throws MesaException, ApuestaException {
        efecto = e;
        Random random = new Random();
        int valor = random.nextInt(37);
        while (!this.efecto.esNumeroValido(valor, mesa)) {
            valor = random.nextInt(37);
        }
        this.setNumSorteado(valor);
        this.avisar(eventos.seSorteoNumero);
        return valor;

    }

    public void seApuesta(Jugador j, int ucc, int valor) throws ApuestaException {
        if (valor == 0) {
            throw new ApuestaException("Debe seleccionar un valor de moneda");
        }
        if(!j.validarApuestaDocena(ucc)){
            throw new ApuestaException("No puede apostar a mas de una docena");
        }
        for (Casillero c : casillerosDeRonda) {
            if (ucc == c.getUcc()) {
                for (Apuesta a : c.getApuestasCasillero()) {
                    if (a.getJugador() == j) {
                        j.setUltimaApuesta(a);
                        j.apostar(valor);
                        a.setValor(a.getValor() + valor);
                        mesa.setBalance(mesa.getBalance() + valor);
                        totalApostado += valor;
                        return;
                    }
                }
                Apuesta ap = c.apuestaNueva(j, valor);
                j.apostar(valor);
                System.out.println(ap);
                getApuestasJugadores().add(ap);
                j.setUltimaApuesta(ap);
                j.setMontoPerdido(j.getMontoPerdido() + valor);
                mesa.setBalance(mesa.getBalance() + valor);
                totalApostado += valor;

                return;
            }
        }
    }

    public void pagarApuestas() {
        boolean apuestaGanadora = false;

        for (Apuesta a : this.getApuestasJugadores()) {
            for (Numero n : a.getCasillero().getNumeros()) {
                if (n.getNumero() == this.getNumSorteado()) {
                    apuestaGanadora = true;
                }
            }

            if (apuestaGanadora) {
                Jugador j = a.getJugador();
                j.setMontoGanado(j.getMontoGanado() + a.getGanancia());
                j.setSaldoActual(j.getSaldoActual() + a.getGanancia());
                mesa.setBalance(mesa.getBalance() - a.getGanancia());
                setApuestasGanadoras(perdidasDeRonda + a.getGanancia());
                setBalancePosterior(balancePrevio - perdidasDeRonda);
            } else {
                setApuestasPerdedoras(gananciasDeRonda + a.getValor());
                setBalancePosterior(balancePrevio + gananciasDeRonda);
            }
            apuestaGanadora = false;
        }
        
        this.avisar(eventos.sePagoApuestas);
    }

    public int totalGanadoPorJugador(Jugador j){

        return j.getMontoGanado();
    }
    public int totalPerdidoPorJugador(Jugador j){

        return totalApostado(j);
        
    }
    public int balanceJugador(Jugador j){
        int ganado = totalGanadoPorJugador(j);
        int perdido = totalPerdidoPorJugador(j);
        int balance = ganado - perdido;
        return balance;
    }

    public int totalApostado(Jugador j){
        int total = 0;
        for(Apuesta a: j.getApuestasDelJugador()){
            total+= a.getValor();
        }
        return total;
    }
    
    
    
    
}
