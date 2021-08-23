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
import javax.swing.JOptionPane;
import model.bean.Especialidade;
import model.bean.Medico;

/**
 *
 * @author Luiz Oliveira
 */
public class MedicoDAO {
    final private String nomeDB;
    public ConnectionInterface ic;
    private Connection con;

    public MedicoDAO() {
        this.nomeDB = null;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB("");
    }
    
    public MedicoDAO(String nome) {
        this.nomeDB = nome;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB(nome);
        this.con = ic.getConnection();
    }
    
    public boolean save(Medico medico) {
        return medico.save(con, ic);
    }
    
    public List<Medico> selecionar (){
 
        String sql = "SELECT * FROM SelectMed";
        
        List<Medico> medicos = new ArrayList<>();        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Medico med = med(rs);
				medicos.add(med);               
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return medicos;
        
    }

	private Medico med(ResultSet rs) throws SQLException {
		Medico med = new Medico();
		med.setCrm(rs.getString("medcrm"));
		med.setNome(rs.getString("mednome"));
		Especialidade esp = esp(rs);
		med.setEspecialidade(esp);
		return med;
	}

	private Especialidade esp(ResultSet rs) throws SQLException {
		Especialidade esp = new Especialidade();
		esp.setCodigo(rs.getInt("espcod"));
		esp.setNome(rs.getString("espnome"));
		return esp;
	}
    
    public boolean alterar (Medico medico, String oldCRM) {
        return medico.alterar(oldCRM, con, ic);
    }
        
        public boolean deletar(String delCRM) {

        String sql = "DELETE FROM medicos "
                + "WHERE medcrm = " + delCRM;
        
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
