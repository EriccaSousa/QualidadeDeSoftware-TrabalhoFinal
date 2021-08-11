/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.bean.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author Luiz Oliveira
 */
public class ControlUser {

    public ControlUser() {
    }
    
    public boolean cadUser (String login, String senha, int perfil) {
        
        UsuarioDAO dao = new UsuarioDAO("mysql");
        Usuario user = new Usuario(login, senha, perfil);
        return dao.save(user);
    }
    
}
