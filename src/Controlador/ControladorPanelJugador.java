/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.ApuestaException;
import Observador.Observable;
import Observador.Observador;
import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Jugador;
import modelo.Mesa;
import modelo.Ronda;

/**
 *
 * @author acarretto
 */
public class ControladorPanelJugador implements Observador {

    private VistaPanelJugador vista;
    private Jugador jugador;
    private int ValorFicha;
    private Ronda rondaActual;
    private ArrayList<Ronda> rondasTotales;
    private Mesa mesaActual;

    public ControladorPanelJugador(VistaPanelJugador v, Jugador j, Mesa m) {
        this.vista = v;
        this.jugador = j;
        mesaActual = m;
        mesaActual.agregarObservador(this);
        rondaActual = m.getRondaActual();
        rondaActual.agregarObservador(this);
        vista.actualizarSaldo(jugador);
        mostrarNombre();
        desactivarCasilleros();
        activarCasilleros();
    }

    public int getValorFicha() {
        return ValorFicha;
    }

    public void setValorFicha(int ValorFicha) {
        this.ValorFicha = ValorFicha;
    }

    public void guardarFichaApostada(int valor) {
        setValorFicha(valor);
        System.out.println(valor);
    }

    @Override
    public void actualizar(Object evento, Observable aThis) {

        if (evento.equals(Mesa.eventos.seDesactivanTiposApuesta)) {
            vista.desactivarCasilleros();
        }
        if (evento.equals(Mesa.eventos.seAposto)) {
            vista.actualizarApuesta(jugador.getUltimaApuesta());
            vista.actualizarSaldo(jugador);
        }

        if (evento.equals(Mesa.eventos.cerrarMesa)) {
            vista.cerrarYPagarMesa();
            vista.cierroPanel();
        }
        if (evento.equals(Ronda.eventos.sePagoApuestas)) {
            vista.actualizarSaldo(jugador);
            vista.reanudarRuleta();
            vista.actualizarTablaStatsJugador(mesaActual.getRondas(), jugador);
            vista.actualizarTablaOcurrencia(mesaActual);
        }
        if (evento.equals(Ronda.eventos.seSorteoNumero)) {
            vista.pausarRuleta();
            vista.desactivarExit();
            vista.limpiarPanel();
            vista.actualizoNumeroSorteado(rondaActual.getNumSorteado());

        }
//        if(evento.equals(Mesa.eventos.seLanzaBola)){ 
//           
//        }
        if (evento.equals(Mesa.eventos.seCreoRonda)) {
            setearValoresJugador();
            setValorFicha(0);
            rondaActual.quitarObservador(this);
            rondaActual = mesaActual.getRondaActual();
            rondaActual.agregarObservador(this);
            desactivarCasilleros();
            activarCasilleros();

        }

    }

    
    private void mostrarNombre() {
        String nombre = jugador.getNomCompleto();
        vista.mostrarNombre(nombre);
    }

    private void activarCasilleros() {
        vista.activarCasilleros(mesaActual.getCasilleros());
    }

    private void desactivarCasilleros() {
        vista.desactivarCasilleros();
    }

    public void apostar(int ucc) {
        try {
            mesaActual.seApuesta(jugador, ucc, ValorFicha);

        } catch (ApuestaException e) {
            vista.error(e.getMessage());
        }
    }

    public void abandonarMesa() {

        try {
            mesaActual.abandonarMesa(jugador);
            vista.cierroPanel();
        } catch (ApuestaException e) {
            vista.error(e.getMessage());
        }

    }

    public void actualizarTablaStatsJugador() {

        //Se pasan los datos del jugador, Num Ronda, totalApostado, ganado, perdido, balance.
        int totalApostadoJ = 0;

        for (Apuesta a : jugador.getApuestasDelJugador()) {
            totalApostadoJ += a.getValor();
        }
        int ganado = jugador.getMontoGanado();
        int perdido = jugador.getMontoPerdido();
        int balance = ganado - perdido;
        //recorrer todas las rondas y obtener datos por ronda del player

        vista.actualizarTablaStatsJugador(rondasTotales, totalApostadoJ, ganado, perdido, balance);

    }
    //Esto esta mal tendria q hacer un array de rondas en jugador? o recorrer rondas actuales, coincidir jugador?

    private void setearValoresJugador() {
        jugador.setearValores();
    }

}
