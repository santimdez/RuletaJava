/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Apuestas;

import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Casillero;
import modelo.Mesa;
import modelo.Numero;

/**
 *
 * @author acarretto
 */
public class Color extends TipoApuesta{

    

     
    public Color(String nombre, int factorPago, boolean obligatorio, boolean esDirecta) {
        super(nombre, factorPago, obligatorio, esDirecta);
        
    }



    @Override
    public ArrayList<Casillero> crearCasilleros() {
       ArrayList<Casillero> aux = new ArrayList<>();
       ArrayList<Numero> numRojo = new ArrayList<>();
       ArrayList<Numero> numNegro = new ArrayList<>();
      
       
       numRojo.add(new Numero(1));
       numRojo.add(new Numero(3));
       numRojo.add(new Numero(5));
       numRojo.add(new Numero(7));
       numRojo.add(new Numero(9));
       numRojo.add(new Numero(12));
       numRojo.add(new Numero(14));
       numRojo.add(new Numero(16));
       numRojo.add(new Numero(18));
       numRojo.add(new Numero(19));
       numRojo.add(new Numero(21));
       numRojo.add(new Numero(23));
       numRojo.add(new Numero(25));
       numRojo.add(new Numero(27));
       numRojo.add(new Numero(30));
       numRojo.add(new Numero(32));
       numRojo.add(new Numero(34));
       numRojo.add(new Numero(36));
       
       
       
       numNegro.add(new Numero(2));
       numNegro.add(new Numero(4));
       numNegro.add(new Numero(6));
       numNegro.add(new Numero(8));
       numNegro.add(new Numero(11));
       numNegro.add(new Numero(15));
       numNegro.add(new Numero(13));
       numNegro.add(new Numero(17));
       numNegro.add(new Numero(20));
       numNegro.add(new Numero(22));
       numNegro.add(new Numero(24));
       numNegro.add(new Numero(26));
       numNegro.add(new Numero(29));
       numNegro.add(new Numero(28));
       numNegro.add(new Numero(29));
       numNegro.add(new Numero(33));
       numNegro.add(new Numero(35));

       
       
       aux.add(new Casillero(43, numRojo));
       aux.add(new Casillero(44, numNegro));
       
       return aux;
    }

   

    
}
