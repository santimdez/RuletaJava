/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iuGrafica;


import java.awt.Frame;
import modelo.Fachada;
import modelo.Jugador;
import modelo.Usuario;
import vistasEscritorio.SeleccionDeMesa;

/**
 *
 * @author acarretto
 */
public class LoginJugador extends Login{
    
    
    public LoginJugador(Frame parent, boolean modal) {
        super(parent, modal, "LOGIN JUGADOR");
    }

    
    
    @Override
    public Usuario llamarLogin(int cd, String pass) {
        return Fachada.getFachada().loginJugador(cd, pass);
        
    }

    @Override
    public void proximoCasoDeUso(Usuario u) {
        new SeleccionDeMesa((Jugador)u).setVisible(true);
    }

   
   

   
    
    
}
