/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luiz Oliveira
 */
public class ConnectionMySQL extends ConnectionInterface{
 
    /*
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/projetodb";
    private static final String USER = "root";
    private static final String PASS = "1234";
    */
    
    @Override
    public Connection getConnection(){
        
        try {
            //Class.forName("DriverManager");
            Class.forName("com.mysql.jdbc.Driver"); 
            return DriverManager.getConnection("jdbc:mysql://localhost/bdclinica","root","");

            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public void closeConnection(Connection con){
        
        if (con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro " + ex);
            }
        }
    }
    @Override
    public void closeConnection(Connection con, PreparedStatement stmt){
        
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro " + ex);
            }
        }
        closeConnection(con);
    }
    @Override
    public void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro " + ex);
            }
        }
        closeConnection(con, stmt);
    }
}
