/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author amaranta
 */
public class conectaBD {
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
         Class.forName("org.postgresql.Driver");
         Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/novaDB","postgres","postgres");
//         Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.2:5432/novaDB","postgres","018266");
            return con;
   }
}
