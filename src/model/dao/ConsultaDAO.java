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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Consulta;
import model.bean.Medico;
import model.bean.Paciente;

/**
 *
 * @author Luiz Oliveira
 */
public class ConsultaDAO {

    final private String nomeDB;
    public ConnectionInterface ic;
    private Connection con;

    public ConsultaDAO() {
        this.nomeDB = null;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB("");
    }

    public ConsultaDAO(String nome) {
        this.nomeDB = nome;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB(nome);
        this.con = ic.getConnection();
    }

    public boolean save(Consulta cons) {

        return cons.save(con, ic);
    }

    public List<Consulta> selecionar(String campoSel) {

        List<Consulta> consultas = new ArrayList<>();
        String sql = sql(campoSel);
		PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Consulta cons = cons(rs);
				consultas.add(cons);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: " + ex);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return consultas;
    }

	private String sql(String campoSel) {
		String sql;
		if (campoSel.contains("/")) {
			sql = "SELECT * FROM consultas " + "WHERE cons_medcrm = " + campoSel;
		} else {
			sql = "SELECT * FROM consultas " + "WHERE cons_paccpf = " + campoSel;
		}
		return sql;
	}

	private Consulta cons(ResultSet rs) throws SQLException {
		Consulta cons = new Consulta();
		cons.setCodigo(rs.getInt("conscod"));
		cons.setData(rs.getString("consdata"));
		cons.setHora(rs.getString("conshora"));
		cons.setStatus(rs.getString("consstatus"));
		Paciente pac = new Paciente();
		pac.setCpf(rs.getString("cons_paccpf"));
		cons.setPaciente(pac);
		Medico med = new Medico();
		med.setCrm(rs.getString("cons_medcrm"));
		cons.setMedico(med);
		return cons;
	}

    public List<String> selecionar(int consCod) {

        String sql = "SELECT * FROM conspag "
                + "WHERE conscod = " + consCod;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> campos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String campo;
                campo = rs.getString("conscod");
                campos.add(campo);
                campo = rs.getString("pacnome");
                campos.add(campo);
                campo = rs.getString("convnome");
                campos.add(campo);
                campo = rs.getString("convcober");
                campos.add(campo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: " + ex);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return campos;
    }

    public List<String> selecionarPac(String pacCpf) {

        String sql = "SELECT * FROM conspac " +
                     "WHERE cons_paccpf = " + pacCpf;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> campos = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String campo;
                campo = rs.getString("conscod");
                campos.add(campo);
                campo = rs.getString("cons_paccpf");
                campos.add(campo);
                campo = rs.getString("pacnome");
                campos.add(campo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: " + ex);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return campos;
    }
    
    public List<String> selecMedCons (String crm, String data){
        
        String sql = "SELECT * FROM realizarcons " +
                     "WHERE cons_medcrm = "+ crm +
                     " AND consdata = " + data;
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> campos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                String campo;
                campo = rs.getString("conscod");
                campos.add(campo);
                campo = rs.getString("consdata");
                campos.add(campo);
                campo = rs.getString("conshora");
                campos.add(campo);
                campo = rs.getString("pacnome");
                campos.add(campo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: " + ex);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return campos;
    }

    public boolean alterar(Consulta cons) {

        return cons.alterar(con, ic);
    }

    public boolean deletar(int delCod) {

        String sql = "DELETE FROM consultas "
                + "WHERE conscod = " + delCod;

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao deletar dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ic.closeConnection(con, stmt);
        }
    }
}
