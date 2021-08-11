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
import javax.swing.JOptionPane;
import model.bean.Convenio;
import model.bean.Paciente;

/**
 *
 * @author Eduardo
 */
public class PacienteDAO {
    final private String nomeDB;
    public ConnectionInterface ic;
    private Connection con;

    public PacienteDAO() {
        this.nomeDB = null;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB("");
    }
    
    public PacienteDAO(String nome) {
        this.nomeDB = nome;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB(nome);
        this.con = ic.getConnection();
    }
    
    public boolean save(Paciente paciente) {
        return paciente.save(con, ic);
    }
    
    public Paciente selecionar (String campo1){
        Paciente pac = new Paciente();
        String sql = "SELECT * FROM selectpac "
                + "WHERE paccpf = " + campo1;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                pac.setCpf(rs.getString("paccpf"));
                pac.setNome(rs.getString("pacnome"));
                pac.setSexo(rs.getString("pacsexo"));
                pac.setIdade(rs.getInt("pacidade"));
                Convenio conv = new Convenio();
                conv.setCodigo(rs.getInt("convcod"));
                conv.setNome(rs.getString("convnome"));
                conv.setCobertura(rs.getString("convcober"));
                pac.setConvenio(conv);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na Seleção do Paciente.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return pac;
    }
    
    public boolean alterar (Paciente pac, String oldCPF, String newConvnome, String newConvcob){
        return pac.alterar(oldCPF, newConvnome, newConvcob, con, ic);
        
    }
    
    public boolean deletar(String delCPF) {

        String sql = "DELETE FROM pacientes "
                + "WHERE paccpf = " + delCPF;
        
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
