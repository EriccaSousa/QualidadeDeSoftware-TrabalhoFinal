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
public class Paciente {
    
    private String cpf;
    private String nome;
    private String sexo;
    private int idade;
    private Convenio convenio;
    //private Telefone telefone;

    public Paciente() {
    }

    public Paciente(String cpf, String nome, String sexo, int idade, Convenio convenio) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.convenio = convenio;
    }


    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

	public boolean save(Connection con, ConnectionInterface ic) {
		String sql = "INSERT INTO pacientes (paccpf, pacnome, pacsexo, pacidade, cod_conv)" + "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, getCpf());
			stmt.setString(2, getNome());
			stmt.setString(3, getSexo());
			stmt.setInt(4, getIdade());
			stmt.setInt(5, getConvenio().getCodigo());
			stmt.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.err.println("Erro: " + ex);
			return false;
		} finally {
			ic.closeConnection(con, stmt);
		}
	}

	public boolean alterar(String oldCPF, String newConvnome, String newConvcob, Connection con,
			ConnectionInterface ic) {
		String sql = "UPDATE pacientes SET paccpf = ?, pacnome = ?, pacsexo = ?, pacidade = ?, "
				+ "cod_conv = (SELECT convcod FROM convenios WHERE convnome = ? AND convcober = ?)" + " WHERE paccpf = "
				+ oldCPF;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, getCpf());
			stmt.setString(2, getNome());
			stmt.setString(3, getSexo());
			stmt.setInt(4, getIdade());
			stmt.setString(5, newConvnome);
			stmt.setString(6, newConvcob);
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
