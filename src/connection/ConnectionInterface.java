/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Luiz Oliveira
 */
public abstract class ConnectionInterface {
    public abstract  Connection getConnection();
    public abstract void closeConnection(Connection con);
    public abstract void closeConnection(Connection con, PreparedStatement stmt);
    public abstract void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs);
}
