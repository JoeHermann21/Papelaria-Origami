/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.SQLException;
import util.conectaBD;

/**
 *
 * @author andre
 */
public class testeBanco {

    conectaBD con = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        conectaBD.getConexao();

        if (conectaBD.getConexao() == null) {
            System.out.println("nulo");
        } else {
            System.out.println("Deu certo!!!");
        }
    }
}
