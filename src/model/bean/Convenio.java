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
public class Convenio {

    private int codigo;
    private String nome;
    private String cobertura;

    public Convenio() {
    }
    
    public Convenio(int codigo, String nome, String cobertura) {
        this.codigo = codigo;
        this.nome = nome;
        this.cobertura = cobertura;
    }

    public Convenio(int i, String psicologo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getCobertura() {
        return cobertura;
    }
    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

	public boolean save(Connection con, ConnectionInterface ic) {
		String sql = "INSERT IGNORE INTO convenios (convnome, convcober) " + "VALUES (?, ?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, getNome());
			stmt.setString(2, getCobertura());
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

	public boolean alterar(int cod, Connection con, ConnectionInterface ic) {
		String sql = "UPDATE convenios " + "SET convnome = ?, convcober = ? " + "WHERE convcod = " + cod;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, getNome());
			stmt.setString(2, getCobertura());
			stmt.executeUpdate();
			return true;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha na Alteração de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
			System.err.println("Erro: " + ex);
			return false;
		} finally {
			ic.closeConnection(con, stmt);
		}
	}   
}

