/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Efectos;

import java.util.ArrayList;
import java.util.Random;
import modelo.Apuestas.TipoApuesta;
import modelo.Mesa;
import modelo.Ronda;

/**
 *
 * @author acarretto
 */
public class Completo extends Efecto {

    public Completo(String nombre) {
        super(nombre);
    }
    
    
    
    
    @Override
    public boolean esNumeroValido(int num, Mesa m) {
        return true;
    }

    

    
}
