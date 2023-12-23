/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iuGrafica;


import vistasEscritorio.ConfiguracionDeMesa;
import java.awt.Frame;
import modelo.Crupier;
import modelo.Fachada;
import modelo.Usuario;


/**
 *
 * @author acarretto
 */
public class LoginCrupier extends Login {
      public LoginCrupier(Frame parent, boolean modal) {
        super(parent, modal, "LOGIN CRUPIER");
    }

    
    @Override
    public Usuario llamarLogin(int cd, String pass){
        return Fachada.getFachada().LoginCrupier(cd, pass);
    }

    @Override
    public void proximoCasoDeUso(Usuario u) {
        new ConfiguracionDeMesa((Crupier)u).setVisible(true);
    }

   
    
    
}
