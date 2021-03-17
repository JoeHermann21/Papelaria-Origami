
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.funcionario;
import util.conectaBD;

public class LoginDAO {
    public boolean checkLogin(funcionario func) throws ClassNotFoundException, SQLException {
        Connection conexao = conectaBD.getConexao();
        PreparedStatement ps = null;
        ResultSet resultado = null;
        boolean check = false;
       
            try {
            ps = conexao.prepareStatement("select * from funcionario where registro = ? and senha = ?");
            ps.setInt(1, func.getRegistro());
            ps.setString(2, func.getSenha());

            resultado = ps.executeQuery();

            if (resultado.next()){
                check = true;
            }
            conexao.close();
            ps.close();
            resultado.close();
        } catch (SQLException ex) {
            System.out.print("LoginDAO: " + ex);
        }
        
        return check;
    }
}
