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
import model.bean.Cobranca;
import model.bean.Consulta;

/**
 *
 * @author Luiz Oliveira
 */
public class CobrancaDAO {

    final private String nomeDB;
    public ConnectionInterface ic;
    private Connection con;

    public CobrancaDAO() {
        this.nomeDB = null;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB("");
    }

    public CobrancaDAO(String nome) {
        this.nomeDB = nome;
        ConnectionFactory cf = new ConnectionFactory();
        this.ic = cf.getDB(nome);
        this.con = ic.getConnection();
    }

    public boolean save(Cobranca cobranca) {
        return cobranca.save(con, ic);
    }

    public List<Cobranca> selecionar() {

        String sql = "SELECT * FROM cobrancas";

        List<Cobranca> cobrancas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cobranca cob = new Cobranca();
                cob.setParcela(rs.getDouble("cobvalorparc"));
                cob.setNumparcela(rs.getInt("cobnumparc"));
                Consulta cons = new Consulta();
                cons.setCodigo(rs.getInt("cons_cod"));
                cob.setConsulta(cons);
                cobrancas.add(cob);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na seleção de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: " + ex);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return cobrancas;
    }

    public Cobranca selectUm(int consCod) {
        String sql = "SELECT * FROM cobrancas "
                + "WHERE cob_conscod = ?";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cobranca cob = new Cobranca();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, consCod);
            rs = stmt.executeQuery();
            while (rs.next()) {
                cob.setCodigo(rs.getInt("cobcod"));
                cob.setNumparcela(rs.getInt("cobnumparc"));
                cob.setParcela(rs.getDouble("cobvalorparc"));
                cob.setValor(rs.getDouble("cobvalor"));
                Consulta cons = new Consulta();
                cons.setCodigo(rs.getInt("cob_conscod"));
                cob.setConsulta(cons);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ic.closeConnection(con, stmt, rs);
        }
        return cob;

    }

    public boolean alterar(Cobranca cobranca, int cod) {
        return cobranca.alterar(cod, con, ic);
    }

    public boolean deletar(String delCOD) {

        String sql = "DELETE FROM cobrancas "
                + "WHERE cob_conscod = " + delCOD;

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
