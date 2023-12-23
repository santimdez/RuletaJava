/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author acarretto
 */
public class Crupier extends Usuario{
    
   
    
    private Mesa mesaAsignada;

    public Mesa getMesaAsignada() {
        return mesaAsignada;
    }

    public void setMesaAsignada(Mesa mesaAsignada) {
        this.mesaAsignada = mesaAsignada;
    }

    public Crupier(int cedula, String nomCompleto, String password, Mesa mesaAsignada) {
        super(cedula, nomCompleto, password);
        this.mesaAsignada = mesaAsignada;
    }
    
    @Override
    public void mostrarInfo(){
        
        System.out.println("Nombre: " + this.getNomCompleto() + "| Cedula: " +this.getCedula() + "| Mesa Actual: "+ this.getMesaAsignada());
        
    }
    
    public void iniciarMesa(){
        Mesa m = new Mesa(this);
        
    }
    
}
