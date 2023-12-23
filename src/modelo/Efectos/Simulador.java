/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Efectos;

import Excepciones.ApuestaException;
import Excepciones.MesaException;
import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Apuestas.TipoApuesta;
import modelo.Mesa;
import modelo.Numero;

/**
 *
 * @author acarretto
 */
public class Simulador extends Efecto{

    public Simulador(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esNumeroValido(int num, Mesa m) throws ApuestaException {
        
       
        
        for(Apuesta a: m.getRondaActual().ApuestasJugadores()){
          for(Numero n : a.getCasillero().getNumeros()){
              if(n.getNumero()==num){
                  return true;
              }
          }
            
           
        }
        
        return false;
        
    }

  
    
}
