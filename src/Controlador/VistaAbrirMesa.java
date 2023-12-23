/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import modelo.Apuestas.TipoApuesta;
import modelo.Crupier;
import modelo.Mesa;

/**
 *
 * @author acarretto
 */
public interface VistaAbrirMesa{

    public void mostrarTiposApuestaLista(ArrayList<TipoApuesta> dameTiposDeApuestaObligatorios);

    public void mostrarTiposApuestaCombo(ArrayList<TipoApuesta> tiposDeApuesta);

    public void actualizarMesasHabilitadas(ArrayList<Mesa> mesasHabilitadas);

    public void error(String msjeError);

    public void abrirPanel();



}
