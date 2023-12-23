/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador;

import Observador.Observable;
import java.util.ArrayList;
import modelo.Jugador;
import modelo.Mesa;

/**
 *
 * @author acarretto
 */
public interface VistaEntrarAMesa {

    //public void entrarAMesa();

    public void error(String msjeError);

    public void cargarMesasIniciales(ArrayList<Mesa> mesas);

    public void actualizarNombre(Jugador j);

    public void proximoCasoDeUso(Jugador j, Mesa m);
    
}
