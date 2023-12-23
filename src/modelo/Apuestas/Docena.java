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
public class Docena extends TipoApuesta {

    
    
    public Docena(String nombre, int factorPago, boolean obligatorio, boolean esDirecta) {
        super(nombre, factorPago, obligatorio, esDirecta);
        
    }

    
    @Override
    public ArrayList<Casillero> crearCasilleros() {
       ArrayList<Casillero> aux = new ArrayList<>();
       ArrayList<Numero> docena1 = new ArrayList<>();
       ArrayList<Numero> docena2 = new ArrayList<>();
       ArrayList<Numero> docena3 = new ArrayList<>();
       
       docena1.add(new Numero(1));
       docena1.add(new Numero(2));
       docena1.add(new Numero(3));
       docena1.add(new Numero(4));
       docena1.add(new Numero(5));
       docena1.add(new Numero(6));
       docena1.add(new Numero(7));
       docena1.add(new Numero(8));
       docena1.add(new Numero(9));
       docena1.add(new Numero(10));
       docena1.add(new Numero(11));
       docena1.add(new Numero(12));
       
       docena2.add(new Numero(13));
       docena2.add(new Numero(14));
       docena2.add(new Numero(15));
       docena2.add(new Numero(16));
       docena2.add(new Numero(17));
       docena2.add(new Numero(18));
       docena2.add(new Numero(19));
       docena2.add(new Numero(20));
       docena2.add(new Numero(21));
       docena2.add(new Numero(22));
       docena2.add(new Numero(23));
       docena2.add(new Numero(24));
       
       docena3.add(new Numero(25));
       docena3.add(new Numero(26));
       docena3.add(new Numero(27));
       docena3.add(new Numero(28));
       docena3.add(new Numero(29));
       docena3.add(new Numero(30));
       docena3.add(new Numero(31));
       docena3.add(new Numero(32));
       docena3.add(new Numero(33));
       docena3.add(new Numero(34));
       docena3.add(new Numero(35));
       docena3.add(new Numero(36));

       
       
       aux.add(new Casillero(40, docena1));
       aux.add(new Casillero(41, docena2));
       aux.add(new Casillero(42, docena3));
       
       return aux;
        
    }

   

   
    
}
