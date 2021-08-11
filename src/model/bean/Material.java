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
 * @author Eduardo
 */
public class Material {
    
    private int codigo;
    private String nome;

    public Material() {
        this.nome = "";
    }
    public Material(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
	public boolean alterar(Connection con, ConnectionInterface ic) {
		String sql = "UPDATE materiais " + "SET matnome = ? " + "WHERE matcod = ?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, getNome());
			stmt.setInt(2, getCodigo());
			stmt.executeUpdate();
			return true;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha na Alteração de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			ic.closeConnection(con, stmt);
		}
	}
    
}
