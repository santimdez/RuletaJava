/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.ApuestaException;
import Excepciones.MesaException;
import Observador.Observable;
import Observador.Observador;
import componente.PanelRuleta;
import java.util.ArrayList;
import modelo.Apuestas.TipoApuesta;
import modelo.Crupier;
import modelo.Efectos.Efecto;
import modelo.Fachada;
import modelo.Mesa;
import modelo.Numero;
import modelo.Ronda;

/**
 *
 * @author acarretto
 */
public class ControladorPanelCrupier implements Observador {

    private VistaPanelCrupier vista;
    private Crupier c;
    private ArrayList<TipoApuesta> tiposApuesta;
    Fachada f = Fachada.getFachada();
    private Mesa m;
    private Ronda rActual;
    private boolean seLanzo = false;

    public ControladorPanelCrupier(VistaPanelCrupier vista, Crupier c) {
        this.vista = vista;
        this.c = c;
        this.tiposApuesta = c.getMesaAsignada().getTiposApuestas();

        m = c.getMesaAsignada();
        m.agregarObservador(this);
        f.agregarObservador(this);
        cargarEfectos();
        rActual = m.nuevaRonda();
        rActual.agregarObservador(this);
        vista.actualizarTablaEstadistica(m.getRondas());
        desactivarCasilleros();
        activarCasilleros();
        actualizarValoresInicialesMesa();

    }

    @Override
    public void actualizar(Object evento, Observable aThis) {
        if (evento.equals(Mesa.eventos.seCreoRonda)) {
            mostrarUltimos3();
            rActual.quitarObservador(this);
            rActual = m.getRondaActual();
            rActual.agregarObservador(this);
            actualizarValoresInicialesMesa();
            vista.actualizarTablaEstadistica(m.getRondas());
            vista.actualizarTablaJugadoresActivos(m.getJugadoresActivos());
            desactivarCasilleros();
            activarCasilleros();
        }
        if (evento.equals(Mesa.eventos.jugadorNuevo) || evento.equals(Mesa.eventos.jugadorSeRetira)) {

            vista.actualizarTablaJugadoresActivos(m.getJugadoresActivos());

        }
        if (evento.equals(Mesa.eventos.seAposto)) {
            vista.actualizoMontoRonda(rActual.getTotalApostado());
            vista.actualizarTablaJugadoresActivos(m.getJugadoresActivos());
            vista.setCantApuestas(rActual.getApuestasJugadores().size());
            vista.limpiarPanel();
            vista.actualizarDatos(rActual.getApuestasJugadores());

        }

        if (evento.equals(Ronda.eventos.seSorteoNumero)) {
            vista.actualizoNumeroSorteado(rActual.getNumSorteado());

        }

    }

    public void desactivarCasilleros() {
        vista.desactivarCasilleros();
    }

    public void actualizarValoresInicialesMesa() {
        vista.actualizarValoresInicialesMesa(m.getBalance(), m.getNumMesa(), m.getRondas().size());
    }

    public void activarCasilleros() {
        vista.activarCasilleros(m.getCasilleros());
    }

    public void cargarEfectos() {
        vista.cargarEfectos(f.getListaEfectos());
    }

    public void actualizarDatosPanel() {

    }

    public void cerrarMesa() {
        f.cerrarMesaHabilitada(m);
        vista.desactivarCasilleros();

    }

    public void lanzarBola(Efecto e) {

        try {
            if (seLanzo) {
                rActual.pagarApuestas();
                setSeLanzo(false);
                rActual = m.nuevaRonda();
                vista.startRuleta();
            } else {
                vista.pausarRuleta();
                rActual.sortearNumero(e);
                setSeLanzo(true);
            }
        } catch (MesaException | ApuestaException m) {
            vista.error(m.getMessage());

        }

    }

    public void pagarApuestas() {

    }

    public void salir() {
        f.quitarObservador(this);
    }

    public Crupier getC() {
        return c;
    }

    public boolean isSeLanzo() {
        return seLanzo;
    }

    public void setSeLanzo(boolean seLanzo) {
        this.seLanzo = seLanzo;
    }


    public void recargarRonda() {

    }

    private void mostrarUltimos3() {
        String resultado = "";
        for(Integer i: m.getUltimos3()){
            resultado +=" | " + i; 
        }
        resultado += " | ";
      vista.mostrarUltimosNumeros(resultado);
    }

}
