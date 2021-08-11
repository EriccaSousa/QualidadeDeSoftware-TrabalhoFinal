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
public class Medico {
    
    private String crm;
    private String nome;
    private Especialidade especialidade;

    public Medico() {
    }

    public Medico(String crm, String nome, Especialidade especialidade) {
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    

    public String getCrm() {
        return crm;
    }

    public String getNome() {
        return nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

	public boolean save(Connection con, ConnectionInterface ic) {
		String sql = "INSERT INTO medicos (medcrm, mednome, med_espcod)" + "VALUES (?, ?, ?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, getCrm());
			stmt.setString(2, getNome());
			stmt.setInt(3, getEspecialidade().getCodigo());
			stmt.executeUpdate();
			return true;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Falha na Inserção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			ic.closeConnection(con, stmt);
		}
	}

	public boolean alterar(String oldCRM, Connection con, ConnectionInterface ic) {
		String sql = "UPDATE medicos " + "SET medcrm = ?, mednome = ?, "
				+ "med_espcod = (select espcod from especialidades where espnome = ?) " + "WHERE medcrm = " + oldCRM;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, getCrm());
			stmt.setString(2, getNome());
			stmt.setString(3, getEspecialidade().getNome());
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
