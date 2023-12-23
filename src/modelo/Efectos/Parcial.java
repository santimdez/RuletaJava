/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Efectos;

import Excepciones.MesaException;
import java.util.ArrayList;
import modelo.Apuestas.TipoApuesta;
import modelo.Mesa;


/**
 *
 * @author acarretto
 */
public class Parcial extends Efecto{

    public Parcial(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esNumeroValido(int num, Mesa m) throws MesaException {
      
        for(Integer n: m.getUltimos3Numeros()){
            if(n == num){
                return false;
            }
        }
        return true;
       
    }


    
}
