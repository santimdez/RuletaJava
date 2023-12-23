/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Efectos;

import Excepciones.ApuestaException;
import Excepciones.MesaException;
import java.util.ArrayList;
import modelo.Apuestas.TipoApuesta;
import modelo.Mesa;
import modelo.Ronda;

/**
 *
 * @author acarretto

 */
public abstract class Efecto {
    
    private String nombre;
    
    
    public Efecto(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    public abstract boolean esNumeroValido(int num, Mesa m) throws MesaException, ApuestaException;

    @Override
    public String toString() {
        return nombre;
    }
  
    
}
