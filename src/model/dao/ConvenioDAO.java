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
import model.bean.Convenio;

/**
 *
 * @author Luiz Oliveira
 */
public class ConvenioDAO {
    final private String nomeDB;
    public ConnectionInterface ic;
    private Connection con;

    public ConvenioDAO () {
        this.nomeDB = null;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB("");
    }
    
    public ConvenioDAO (String nome) {
        this.nomeDB = nome;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB(nome);
        this.con = ic.getConnection();
    }
    
    public boolean save (Convenio conv){
        return conv.save(con, ic);
        
    }
    
    public List<Convenio> selecionar (){
        String sql = "SELECT * FROM convenios";
        List<Convenio> convenios = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Convenio conv = new Convenio();
                conv.setCodigo(rs.getInt("convcod"));
                conv.setNome(rs.getString("convnome"));
                conv.setCobertura(rs.getString("convcober"));
                convenios.add(conv);
            }
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: " + ex);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return convenios;       
    }
    
    public Convenio getconv (String nome, String cobertura){
        String sql = "SELECT * FROM convenios "+
                     "WHERE convnome = ? AND convcober = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Convenio conv = new Convenio();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cobertura);
            rs = stmt.executeQuery();
            while(rs.next()){
                conv.setCodigo(rs.getInt("convcod"));
                conv.setNome(rs.getString("convnome"));
                conv.setCobertura(rs.getString("convcober"));
            }
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: " + ex);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return conv;
        
    }
    
    public boolean alterar (Convenio conv, int cod){
        return conv.alterar(cod, con, ic);
    }
    
    public boolean deletar(int delCOD) {

        String sql = "DELETE FROM convenios "
                + "WHERE convcod = " + delCOD;
        
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
