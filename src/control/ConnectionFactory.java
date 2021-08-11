/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import connection.ConnectionInterface;
import connection.ConnectionMySQL;

/**
 *
 * @author Luiz Oliveira
 */
public class ConnectionFactory {
    
   public ConnectionInterface getDB (String nomeDB){
       if(nomeDB == null){
           System.err.println("Informe o nome do Banco de Dados qual deseja conectar");
           return null;
       }
       else if (nomeDB.equalsIgnoreCase("MYSQL")){
           return new ConnectionMySQL();
       }
       return null;
   }
}
