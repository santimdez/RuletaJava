/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador;

import Excepciones.ApuestaException;
import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Casillero;
import modelo.Jugador;
import modelo.Mesa;
import modelo.Numero;
import modelo.Ronda;

/**
 *
 * @author acarretto
 */
public interface VistaPanelJugador {

    
//    
//    public void mostrarSaldo(int v);
//    
//    public void mostrarNumMesa(int v);
//    
//    public void mostrarNumRonda(int v);
//    
//    public void mostrarUltimoNum(int v);
    
    public void mostrarNombre(String v);

    public void desactivarCasilleros();

    public void activarCasilleros(ArrayList<Casillero> casilleros);

    public void actualizarApuesta(Apuesta a);

    public void error(String e);

    public void actualizoNumeroSorteado(int numSorteado);

    public void limpiarPanel();

    public void pausarRuleta();

    public void actualizarSaldo(Jugador jugador);

    public void reanudarRuleta();

    public void desactivarExit();

    public void actualizarTablaStatsJugador(ArrayList<Ronda> rondasTotales, int totalApostadoJ, int ganado, int perdido, int balance);

    public void cerrarYPagarMesa();

    public void cierroPanel();
    
    public void actualizarTablaStatsJugador(ArrayList<Ronda> rondasTotales, Jugador j);

    public void actualizarTablaOcurrencia(Mesa m);
    
}
