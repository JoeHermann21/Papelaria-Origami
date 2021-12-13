/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class testConexao {
    conectaDB con = null;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        conectaDB.getConexao();
        if(conectaDB.getConexao() == null){
            System.out.println("nulo");
        } else {
            System.out.println("Deu certo");
        }
    }
}
