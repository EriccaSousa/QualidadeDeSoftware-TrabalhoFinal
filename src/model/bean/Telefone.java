/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Eduardo
 */
public class Telefone {
    
    private String telefone;
    //private Paciente paciente;

    public Telefone() {
        this.telefone = "";
    }
    public Telefone(String telefone) {
        this.telefone = telefone;
    }
    public Telefone(Telefone a) {
        this.telefone = a.telefone;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
