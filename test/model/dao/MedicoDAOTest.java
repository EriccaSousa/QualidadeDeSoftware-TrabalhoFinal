/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Especialidade;
import model.bean.Medico;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Luiz Oliveira
 */
public class MedicoDAOTest {
    
    public MedicoDAOTest() {
    }

    @Test
    @Ignore
    public void inserir() {
        Especialidade esp = new Especialidade(1, "Cirurgiao");
        Medico med = new Medico("43333177854", "Roberto", esp);
        MedicoDAO dao = new MedicoDAO("mysql");
        
        if(dao.save(med)){
            System.out.println("salvo com sucesso");
        }
        else{
            fail("Erro ao salvar");
        }
        
    }
    
    @Test
    @Ignore
    public void select(){
    
        MedicoDAO dao = new MedicoDAO("mysql");
        for (Medico m: dao.selecionar()){
        
            System.out.println("CRM: " + m.getCrm() + " Nome: " + m.getNome() + " Esp: " + m.getEspecialidade().getNome());
            
        }
    }
    
    @Test
    @Ignore
    public void update(){
        
        MedicoDAO dao = new MedicoDAO("mysql");
        String oldCRM = "789456";
        Especialidade esp = new Especialidade(3, "Urologista");
        Medico med = new Medico("156321123", "Teste Update3", esp);
        if(dao.alterar(med, oldCRM)){
            System.out.println("alterado com sucesso");
        }
        else
            fail("Falha ao atualizar");
    }
    
    @Test
    @Ignore
    public void delete (){
    
        MedicoDAO dao = new MedicoDAO("mysql");
        String crm = "123456";
        if (dao.deletar(crm)){
            System.out.println("deletado");
        }
        else
            fail("Falha ao deletar");
        
    }
}
