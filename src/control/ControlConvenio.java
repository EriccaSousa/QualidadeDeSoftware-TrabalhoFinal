/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.bean.Convenio;
import model.dao.ConvenioDAO;

/**
 *
 * @author Luiz Oliveira
 */
public class ControlConvenio {

    public ControlConvenio() {
    }
    
    public boolean save (String nome, String cobertura){
        ConvenioDAO dao = new ConvenioDAO("mysql");
        Convenio conv = new Convenio(0, nome, cobertura);
        return dao.save(conv);
        
    }
}
