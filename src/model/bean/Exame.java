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
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class Exame {
    
    private int codigo;
    private String nome;
    private String descricao;
    private String tipo;

    public Exame() {
    }

    public Exame(int codigo, String nome, String descricao, String tipo, List<Material> materiais) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
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
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

	public boolean save(Connection con, ConnectionInterface ic) {
		String sql = "INSERT IGNORE INTO exames (examenome, examedesc, exametip) " + "VALUES (? ,? ,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, getNome());
			stmt.setString(2, getDescricao());
			stmt.setString(3, getTipo());
			stmt.executeUpdate();
			return true;
		} catch (SQLException ex1) {
			JOptionPane.showMessageDialog(null, "Falha na Inserção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
			System.err.println("Erro: " + this);
			return false;
		} finally {
			ic.closeConnection(con, stmt);
		}
	}

	public boolean alterar(int altCod, Connection con, ConnectionInterface ic) {
		String sql = "UPDATE exames " + "SET examenome = ?, examedesc = ?. exametipo = ? " + "WHERE examecod = "
				+ altCod;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, getNome());
			stmt.setString(2, getDescricao());
			stmt.setString(3, getTipo());
			stmt.executeUpdate();
			return true;
		} catch (SQLException ex1) {
			JOptionPane.showMessageDialog(null, "Falha na Alteração de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
			System.err.println("Erro: " + this);
			return false;
		} finally {
			ic.closeConnection(con, stmt);
		}
	}   
}
