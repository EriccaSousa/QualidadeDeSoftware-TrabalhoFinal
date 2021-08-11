/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Luiz Oliveira
 */
public class ConsultaDAOTest {
    
    public ConsultaDAOTest() {
    }

    @Test
    public void selectpag() {
        
        ConsultaDAO dao = new ConsultaDAO("mysql");
        List<String> campos = new ArrayList<>();
        campos = dao.selecMedCons("1236547888", "29/11");
        String[] c = new String[4];
        for (int i = 0; i < campos.size(); i++){
            c[i] = campos.get(i);
            System.out.println("" + c[i]);
        }
        
    }
    
}
