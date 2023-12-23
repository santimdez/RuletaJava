package modelo;

import java.util.ArrayList;

public class Usuario {
    
    private String nomCompleto;
    
    private int cedula;
    
    private String password;
    
    private boolean logueado;

    public boolean isLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }

    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
     public Usuario(int cedula, String nomCompleto, String password) {
        this.cedula = cedula;
        this.nomCompleto = nomCompleto;
        this.password = password;
        this.logueado = false;
        
    }
     
    public void mostrarInfo(){
        
        System.out.println("Nombre: " + this.getNomCompleto() + "Cedula: " +this.getCedula());
        
        
    }
    
    
}
