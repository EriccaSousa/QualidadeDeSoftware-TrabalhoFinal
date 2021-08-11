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
public class ControlLogin {

    public ControlLogin() {
    }
    
    public int Checkin (String login, String senha){
        UsuarioDAO dao = new UsuarioDAO("mysql");
        //Usuario us = new Usuario(login, senha, 0);
        Usuario user = dao.checkin(login, senha);
        return user.getPerfil();
        
    }
}
