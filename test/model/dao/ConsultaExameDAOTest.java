/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Consulta;
import model.bean.ConsultaExame;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luiz Oliveira
 */
public class ConsultaExameDAOTest {
    
    public ConsultaExameDAOTest() {
    }

    @Test
    public void testSomeMethod() {
        
        ConsultaExameDAO  dao = new ConsultaExameDAO("mysql");
        Consulta cons = new Consulta();
        cons.setCodigo(2);
        ConsultaExame exam = new ConsultaExame("00/00", "00:00", cons);
        exam.setCodigo(1);
        if(dao.save(exam)){
            
        }else {
            fail("Erro");
        }
    }
    
}
