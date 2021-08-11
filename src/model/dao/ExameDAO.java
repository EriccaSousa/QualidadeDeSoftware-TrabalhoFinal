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
import model.bean.Exame;

/**
 *
 * @author Luiz Oliveira
 */
public class ExameDAO {

    final private String nomeDB;
    public ConnectionInterface ic;
    private Connection con;

    public ExameDAO() {
        this.nomeDB = null;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB("");
    }

    public ExameDAO(String nome) {
        this.nomeDB = nome;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB(nome);
        this.con = ic.getConnection();
    }

    public boolean save(Exame ex) {

        return ex.save(con, ic);
    }

    public List<Exame> selecionar() {

        String sql = "SELECT * FROM exames";
        List<Exame> exames = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Exame ex = new Exame();
                ex.setCodigo(rs.getInt("examecod"));
                ex.setNome(rs.getString("examenome"));
                ex.setDescricao(rs.getString("examedesc"));
                ex.setTipo(rs.getString("exametipo"));
                exames.add(ex);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: " + ex);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return exames;
    }

    public Exame selecionarUm(int exCod) {

        String sql = "SELECT * FROM exames "
                + "WHERE examecod = " + exCod;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Exame exam = new Exame();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                exam.setCodigo(rs.getInt("examecod"));
                exam.setNome(rs.getString("examenome"));
                exam.setDescricao(rs.getString("examedesc"));
                exam.setTipo(rs.getString("exametipo"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: " + ex);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return exam;
    }

    public boolean alterar(Exame ex, int altCod) {

        return ex.alterar(altCod, con, ic);
    }

    public boolean deletar(int delCod) {

        String sql = "DELETE FROM exames "
                + "WHERE examecod = " + delCod;
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
