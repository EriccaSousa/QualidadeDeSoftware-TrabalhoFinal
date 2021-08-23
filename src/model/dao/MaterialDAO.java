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
import model.bean.Material;

/**
 *
 * @author Luiz Oliveira
 */
public class MaterialDAO {
    final private String nomeDB;
    public ConnectionInterface ic;
    private Connection con;

    public MaterialDAO() {
        this.nomeDB = null;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB("");
    }
    
    public MaterialDAO(String nome) {
        this.nomeDB = nome;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB(nome);
        this.con = ic.getConnection();
    }
    
    public boolean save (Material mat){
        String sql = "INSERT INTO materiais " +
                     "(matnome) VALUES (?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, mat.getNome());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na Inserção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: "+ex);
            return false;
        } finally {
            ic.closeConnection(con, stmt);
        }
    }
    
    public List<Material> selecionar (){
        
        String sql = "SELECT * FROM materiais";
        List<Material> materiais = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Material mat = mat(rs);
				materiais.add(mat);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: "+ ex);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return materiais;
    }

	private Material mat(ResultSet rs) throws SQLException {
		Material mat = new Material();
		mat.setCodigo(rs.getInt("matcod"));
		mat.setNome(rs.getString("matnome"));
		return mat;
	}
    
    public int getCod (String matnome){
        
        //ic.getConnection();
        String sql = "SELECT matcod FROM materiais "+
                     "WHERE matnome = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int c = 0;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, matnome);
            rs = stmt.executeQuery();
            while (rs.next()){
                c = rs.getInt("matcod");
            }
            return c;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: "+ ex);
            return -1;
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
    }
    
    public boolean alterar (Material mat){
        
        return mat.alterar(con, ic);
    }
    
    public boolean deletar (int delCod){
        
        String sql = "DELETE FROM materiais " +
                     "WHERE matcod = " + delCod;
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
