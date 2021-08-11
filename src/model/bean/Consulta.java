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
public class Consulta {
    private int codigo;
    private String data;
    private String hora;
    private String status;
    private Paciente paciente;
    private Medico medico;
    private List<Exame> exames;
    private List<Material> materiais;

    public Consulta() {
    }

    public Consulta(int codigo, String data, String hora, Paciente paciente, String status, Medico medico, List<Exame> exames, List<Material> materiais) {
        this.codigo = codigo;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.paciente = paciente;
        this.medico = medico;
        this.exames = exames;
        this.materiais = materiais;
    }

  
    

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }

	public boolean save(Connection con, ConnectionInterface ic) {
		String sql = "INSERT INTO consultas " + "(consdata, conshora, consstatus, cons_paccpf, cons_medcrm) "
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, getData());
			stmt.setString(2, getHora());
			stmt.setString(3, getStatus());
			stmt.setString(4, getPaciente().getCpf());
			stmt.setString(5, getMedico().getCrm());
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

	public boolean alterar(Connection con, ConnectionInterface ic) {
		String sql = "UPDATE consultas " + "SET consdata = ?, conshora = ?, consstatus = ? " + "WHERE conscod = ?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, getData());
			stmt.setString(2, getHora());
			stmt.setString(3, getStatus());
			stmt.setInt(4, getCodigo());
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
