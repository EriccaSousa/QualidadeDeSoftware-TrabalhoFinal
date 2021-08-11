/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionInterface;
import control.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author Luiz Oliveira
 */
public class UsuarioDAO {
    final private String nomeDB;
    public ConnectionInterface ic;
    private Connection con;

    public UsuarioDAO() {
        this.nomeDB = null;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB("");
    }
    
    public UsuarioDAO(String nome) {
        this.nomeDB = nome;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB(nome);
        this.con = ic.getConnection();
    }
    
    public boolean save (Usuario user){
        return user.save(con, ic);
    }
    
    public Usuario checkin (String login, String senha){
        String sql = "SELECT * FROM usuarios "+
                     "WHERE login = ? AND senha = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario us = new Usuario();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while (rs.next()){
                us.setLogin(rs.getString("login"));
                us.setSenha(rs.getString("senha"));
                us.setPerfil(rs.getInt("perfil"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado, verifique o login e senha.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return us;
    }
}
