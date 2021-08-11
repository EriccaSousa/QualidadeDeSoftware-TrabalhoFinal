/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Convenio;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Luiz Oliveira
 */
public class ConvenioDAOTest {
    
    public ConvenioDAOTest() {
    }

    @Test
    @Ignore
    public void insert() {
        
        ConvenioDAO dao = new ConvenioDAO("mysql");
        Convenio conv = new Convenio(0, "Amil", "Platina");
        if(dao.save(conv)){
            System.out.println("Sucesso na inserção.");
        }
        else{
            fail("Erro!");
        }
        
    }
    @Test
    @Ignore
    public void select(){
    
        ConvenioDAO dao = new ConvenioDAO("mysql");
        for (Convenio c: dao.selecionar()){
        
            System.out.println("Cod: " + c.getCodigo()+ " Nome: " + c.getNome() + " Cobertura: " + c.getCobertura());
            
        }
    }
    @Test
    @Ignore
    public void update(){
        
        ConvenioDAO dao = new ConvenioDAO("mysql");
        int cod = 2;
        Convenio conv = new Convenio(0, "Amil", "Prata");
        if(dao.alterar(conv, cod)){
            System.out.println("alterado com sucesso");
        }
        else
            fail("Falha ao atualizar");
    }
    
    @Test
    @Ignore
    public void delete (){
    
        ConvenioDAO dao = new ConvenioDAO("mysql");
        int cod = 1;
        if (dao.deletar(cod)){
            System.out.println("deletado");
        }
        else
            fail("Falha ao deletar");
        
    }
    
    @Test
    public void getconv (){
    
        ConvenioDAO dao = new ConvenioDAO("mysql");
        Convenio conv = new Convenio(0, "Amil", "Prata");
        Convenio convenio = dao.getconv(conv.getNome(), conv.getCobertura());
        System.out.println(""+ convenio.getNome()+ " "+ convenio.getCobertura());
    }
}
