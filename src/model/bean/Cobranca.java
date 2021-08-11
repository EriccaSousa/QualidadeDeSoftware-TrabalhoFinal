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
public class Cobranca {
    
    private int codigo;
    private double valor;
    private double parcela;
    private int numparcela;
    private Consulta consulta;
    //private Convenio convenio;

    public Cobranca() {
    }

    public Cobranca(double valor, double parcela, int numparcela, Consulta consulta) {
        this.valor = valor;
        this.parcela = parcela;
        this.numparcela = numparcela;
        this.consulta = consulta;
    }

    

    

    

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public double getParcela() {
        return parcela;
    }
    public void setParcela(double parcela) {
        this.parcela = parcela;
    }
    public int getNumparcela() {
        return numparcela;
    }
    public void setNumparcela(int numparcela) {
        this.numparcela = numparcela;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

	public boolean save(Connection con, ConnectionInterface ic) {
		String sql = "INSERT INTO cobrancas (cobvalorparc, cobnumparc, cob_conscod, cobvalor)" + "VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setDouble(1, getParcela());
			stmt.setInt(2, getNumparcela());
			stmt.setInt(3, getConsulta().getCodigo());
			stmt.setDouble(4, getValor());
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
		String sql = "UPDATE cobrancas " + "SET cobvalorparc = ?, cobnumparc = ?, cobvalor = ? "
				+ "WHERE cob_conscod = " + cod;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setDouble(1, getParcela());
			stmt.setInt(2, getNumparcela());
			stmt.setDouble(3, getValor());
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
