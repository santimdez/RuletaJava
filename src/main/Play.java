/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Controlador.ControladorAbrirMesa;
import iuGrafica.Menu;
import modelo.Crupier;
import modelo.Fachada;
import modelo.Jugador;
import modelo.Mesa;


/**
 *
 * @author acarretto
 */
public class Play {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Fachada f = Fachada.getFachada();
        //Precarga Jugadores
        f.agregarJugador(1, "Agustin Carretto", "123", 50);
        f.agregarJugador(2, "Emma Cabrera", "123", 4000);
        f.agregarJugador(3, "Santi Mendez", "123", 3000);
        f.agregarJugador(4, "Jhon Roverts", "123", 200);
        f.agregarJugador(5, "Juan Rodriguez", "123", 10);
        
        //Precarga Crupiers
        f.agregarCrupier(1, "Maria Caceres", "123");
        f.agregarCrupier(2, "Leonardo Perez", "123");
        f.agregarCrupier(3, "Lionel Messi", "123");
        
        //Precargas de mesa
        f.agregarMesa(f.obtenerCrupier(1));
        f.agregarMesa(f.obtenerCrupier(2));
        f.agregarMesa(f.obtenerCrupier(3));
        
        //Precarga de tipos de apuesta
        f.agregarTipo("Color",2, false, true);
        f.agregarTipo("Docena",3, false, true);
        f.agregarTipo("Directa",37, true, true);
        
        //Precargas de efectos
        f.agregarEfecto("Completo");
        f.agregarEfecto("Simulador");
        f.agregarEfecto("Parcial");
        
        
        System.out.println();
        
        
        
        
        //Inicio Mesa Con opciones de login
        new Menu().setVisible(true);
        
        
    }
    
}
