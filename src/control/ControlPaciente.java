/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.bean.Convenio;
import model.bean.Paciente;
import model.dao.ConvenioDAO;
import model.dao.PacienteDAO;

/**
 *
 * @author Luiz Oliveira
 */
public class ControlPaciente {

    public ControlPaciente() {
    }
    
    public boolean save (String cpf, String nome, String sexo, int idade, String convnome, String cobertura){
        ConvenioDAO dao = new ConvenioDAO("mysql");
        Convenio conv = dao.getconv(convnome, cobertura);
        Paciente pac = new Paciente(cpf, nome, sexo, idade, conv);
        PacienteDAO dao2 = new PacienteDAO("mysql");
        return dao2.save(pac);                
    }
    
    public Paciente getPaciente (String cpf){
        PacienteDAO dao = new PacienteDAO("mysql");
        Paciente pac = new Paciente();
        return pac = dao.selecionar(cpf);
        
    }
    
    public boolean deletar (String cpf){
        PacienteDAO dao = new PacienteDAO("mysql");
        return dao.deletar(cpf);
    }
    
    public boolean update (String cpf, String nome, String sexo, int idade, String convnome, String cobertura, String oldcpf){
        ConvenioDAO dao = new ConvenioDAO("mysql");
        Convenio conv = dao.getconv(convnome, cobertura);
       
        //dao.save(conv);
        Paciente pac = new Paciente(cpf, nome, sexo, idade, conv);
        PacienteDAO dao2 = new PacienteDAO("mysql");
        return dao2.alterar(pac, oldcpf, conv.getNome(), conv.getCobertura());
        
    }
}
