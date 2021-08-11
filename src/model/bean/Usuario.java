/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import connection.ConnectionInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz Oliveira
 */
public class Usuario {
    
    private String login;
    private String senha;
    private int perfil;

    public Usuario() {
    }

    public Usuario(String login, String senha, int perfil) {
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

	public boolean save(Connection con, ConnectionInterface ic) {
		String sql = "INSERT INTO usuarios " + "(login, senha, perfil) VALUES (?, ?, ?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, getLogin());
			stmt.setString(2, getSenha());
			stmt.setInt(3, getPerfil());
			stmt.executeUpdate();
			return true;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha na Inserção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
			System.err.println("Erro: " + ex);
			return false;
		} finally {
			ic.closeConnection(con, stmt);
		}
	}
    
    
}
