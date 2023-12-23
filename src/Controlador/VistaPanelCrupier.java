/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Casillero;
import modelo.Efectos.Efecto;
import modelo.Jugador;
import modelo.Numero;
import modelo.Ronda;

/**
 *
 * @author acarretto
 */
public interface VistaPanelCrupier {

    public void actualizarValoresInicialesMesa(double balance, int numMesa, int numR);

    public void activarCasilleros(ArrayList<Casillero> CasillerosDisponibles);

    public void desactivarCasilleros();
    
    public void ocultarMonedas();

    public void cargarEfectos(ArrayList<Efecto> listaEfectos);

    public void actualizoNumeroSorteado(int numSorteado);

    public void pausarRuleta();

    public void startRuleta();

    public void actualizarDatos(ArrayList<Apuesta> a);

    public void limpiarPanel();

    public void error(String message);

    public void actualizarTablaJugadoresActivos(ArrayList<Jugador> jugadoresActivos);

    public void actualizarTablaEstadistica(ArrayList<Ronda> rondas);

    public void mostrarUltimosNumeros(String ult3);

    public void setCantApuestas(int size);

    public void actualizoMontoRonda(int totalApostado);
   
    
}
