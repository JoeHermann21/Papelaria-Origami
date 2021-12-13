/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Modelo.Cliente;
import Modelo.Pedido;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class enviarTeste {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        EnviarNotaFiscal enviar = new EnviarNotaFiscal();
        Pedido ped = new Pedido();
        ped.setId(4);
        
      boolean enviou = enviar.enviarHotmail(ped);
        if (enviou) {

            System.out.println("Dados enviados com sucesso");

        } else {
            System.out.println("Não foi enviar as informações");

        }

    }

}
