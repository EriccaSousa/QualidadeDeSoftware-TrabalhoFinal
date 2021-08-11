/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Convenio;
import model.bean.Paciente;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Luiz Oliveira
 */
public class PacienteDAOTest {
    
    public PacienteDAOTest() {
    }

    @Test
    @Ignore
    public void inserir() {
        Convenio conv = new Convenio(2, "Amil", "Prata");
        Paciente pac = new Paciente("157456", "Jaqueline", "F", 20, conv);
        PacienteDAO dao = new PacienteDAO("mysql");
        
        if(dao.save(pac)){
            System.out.println("salvo com sucesso");
        }
        else{
            fail("Erro ao salvar");
        }
        
    }
    
    @Test
    @Ignore
    public void select(){
        
        PacienteDAO dao = new PacienteDAO("mysql");
        Paciente pac = dao.selecionar("43333177897");
        if (pac != null){
            System.out.println("Nome: " + pac.getNome() + " Idade: " + pac.getIdade() + " anos.");
        }
        else
            fail("Erro ao selecionar");
        
    }
    
    @Test
    public void update(){
        Convenio conv = new Convenio(0, "Amil", "Ouro");
        Paciente pac = new Paciente("123456", "Andreza", "F", 35, conv);
        PacienteDAO dao = new PacienteDAO("mysql");
        if (dao.alterar(pac, "123456", conv.getNome(), conv.getCobertura())){
            System.out.println("Alteracao realizada com sucesso");
        }else
            fail("Erro na alteracao de dados");
    }
    
    @Test
    @Ignore
    public void delete (){
    
        PacienteDAO dao = new PacienteDAO("mysql");
        String cpf = "456123789";
        if (dao.deletar(cpf)){
            System.out.println("deletado");
        }
        else
            fail("Falha ao deletar");
        
    }
}
