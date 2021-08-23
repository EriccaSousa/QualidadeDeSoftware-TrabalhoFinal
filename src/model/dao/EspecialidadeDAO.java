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

/**
 *
 * @author Luiz Oliveira
 */
public class EspecialidadeDAO {
    final private String nomeDB;
    public ConnectionInterface ic;
    private Connection con;

    public EspecialidadeDAO () {
        this.nomeDB = null;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB("");
    }
    
    public EspecialidadeDAO (String nome) {
        this.nomeDB = nome;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB(nome);
        this.con = ic.getConnection();
    }
    
    public boolean save (Especialidade esp){
        String sql = "INSERT IGNORE INTO especialidades (espnome) " + 
                     "VALUES (?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, esp.getNome());
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
    
    public List<Especialidade> selecionar (){
        String sql = "SELECT * FROM especialidades";
        
        List<Especialidade> especialidades = new ArrayList<>();        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Especialidade esp = esp(rs);
				especialidades.add(esp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na Seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            //System.err.println("Erro: " + ex);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return especialidades;
        
    }

	private Especialidade esp(ResultSet rs) throws SQLException {
		Especialidade esp = new Especialidade();
		esp.setCodigo(rs.getInt("espcod"));
		esp.setNome(rs.getString("espnome"));
		return esp;
	}
    
    public boolean alterar (Especialidade esp, int cod){
        String sql = "UPDATE especialidades " +
                     "SET espnome = ? " +
                     "WHERE espcod = " + cod;
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, esp.getNome());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na alteração dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ic.closeConnection(con, stmt);
        }
    }
    
    public boolean deletar(int delCOD) {

        String sql = "DELETE FROM especialidades "
                + "WHERE espcod = " + delCOD;
        
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
