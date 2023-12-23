/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Excepciones.ApuestaException;
import java.util.ArrayList;

/**
 *
 * @author acarretto
 */

public class Jugador extends Usuario {

    private double saldoInicial;

    private double saldoActual;

    private ArrayList<Mesa> mesasActuales;

    private Apuesta ultimaApuesta;

    private ArrayList<Apuesta> apuestasDelJugadorXRonda;

    private int montoGanado;

    private int montoPerdido;

    public Jugador(int cedula, String nomCompleto, String password, double saldoInicial) {
        super(cedula, nomCompleto, password);
        this.saldoInicial = saldoInicial;
        this.saldoActual = saldoInicial;
        this.apuestasDelJugadorXRonda = new ArrayList<>();
        this.mesasActuales = new ArrayList<>();
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public int getMontoGanado() {
        return montoGanado;
    }

    public void setMontoGanado(int montoGanado) {
        this.montoGanado = montoGanado;
    }

    public int getMontoPerdido() {
        return montoPerdido;
    }

    public void setMontoPerdido(int montoPerdido) {
        this.montoPerdido = montoPerdido;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public ArrayList<Mesa> getMesasActuales() {
        return mesasActuales;
    }

    public void setMesasActuales(ArrayList<Mesa> mesasActuales) {
        this.mesasActuales = mesasActuales;
    }

    public Apuesta getUltimaApuesta() {
        return ultimaApuesta;
    }

    public void setUltimaApuesta(Apuesta ultimaApuesta) {
        this.ultimaApuesta = ultimaApuesta;
    }

    public ArrayList<Apuesta> getApuestasDelJugador() {
        return apuestasDelJugadorXRonda;
    }

    public void setApuestasDelJugador(ArrayList<Apuesta> apuestasDelJugador) {
        this.apuestasDelJugadorXRonda = apuestasDelJugador;
    }

    @Override
    public void mostrarInfo() {

        System.out.println("Nombre: " + this.getNomCompleto() + "| Cedula: " + this.getCedula() + "| Saldo Inicial: " + this.getSaldoInicial());

    }

    public boolean saldoSuficiente(int i) {
        if (this.saldoActual >= i) {
            return true;
        }
        return false;
    }

    public void apostar(int plata) throws ApuestaException {
        if (this.saldoActual >= plata) {
            this.setSaldoActual(getSaldoActual() - plata);

            System.out.println(getSaldoActual());

        } else {
            throw new ApuestaException("No tiene saldo suficiente para realizar esta apuesta");
        }
    }

    public void agregarUnaMesa(Mesa mesaAsignada) {
        this.mesasActuales.add(mesaAsignada);
    }

    public void setearValores() {
        montoGanado = 0;
        montoPerdido = 0;
        apuestasDelJugadorXRonda = new ArrayList<Apuesta>();
    }

    public boolean validarApuestaDocena(int num) {
        
        if (num >= 40 && num <= 42) {
            for (Apuesta ap : apuestasDelJugadorXRonda) {
                if (ap.getCasillero().getUcc() >= 40 && ap.getCasillero().getUcc() <= 42) {
                    if (ap.getCasillero().getUcc() != num) {
                        return false;
                    }
                }
            }

        }

        return true;
    }

    void validarNoTieneApuesta() throws ApuestaException {
            if(!apuestasDelJugadorXRonda.isEmpty()){
                throw new ApuestaException("No puede abandonar la mesa tiene una apuesta realizada");
            }
    }
}
