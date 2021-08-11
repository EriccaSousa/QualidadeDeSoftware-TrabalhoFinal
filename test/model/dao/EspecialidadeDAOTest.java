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
public class EspecialidadeDAOTest {
    
    public EspecialidadeDAOTest() {
    }

    @Test
    @Ignore
    public void insert() {
        EspecialidadeDAO dao = new EspecialidadeDAO("mysql");
        Especialidade esp = new Especialidade(0, "Cardiologista");
        if(dao.save(esp)){
            System.out.println("Sucesso na inserção.");
        }
        else{
            fail("Erro!");
        }
    }
    
    @Test
    @Ignore
    public void select(){
    
        EspecialidadeDAO dao = new EspecialidadeDAO("mysql");
        for (Especialidade e: dao.selecionar()){
        
            System.out.println("Cod: " + e.getCodigo()+ " Nome: " + e.getNome());
            
        }
    }
    
    @Test
    @Ignore
    public void update(){
        
        EspecialidadeDAO dao = new EspecialidadeDAO("mysql");
        int cod = 9;
        Especialidade esp = new Especialidade(0, "Psicologo");
        if(dao.alterar(esp, cod)){
            System.out.println("alterado com sucesso");
        }
        else
            fail("Falha ao atualizar");
    }
    
    @Test
    public void delete (){
    
        EspecialidadeDAO dao = new EspecialidadeDAO("mysql");
        int cod = 9;
        if (dao.deletar(cod)){
            System.out.println("deletado");
        }
        else
            fail("Falha ao deletar");
        
    }
}
