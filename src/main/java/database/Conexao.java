/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Andrei
 */
public class Conexao {
        public static Connection abrirConexao() throws Exception {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String endereco = "localhost";
            String porta = "3306";
            String database = "dados";
            String usuario = "root";
            String senha = "mysql";

            String url = "jdbc:mysql://" + endereco
                    + ":" + porta + "/" + database
                    + "?useTimezone=&true&serverTimezonne=UTC";
            return DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public static void fecharConexao(Connection con, Statement stmt, ResultSet rs)throws Exception {
        try{
            if(rs!=null) {rs.close();}
            if(stmt!=null) {stmt.close();}
            if(con!=null) {con.close();}
            
        }catch (SQLException e){
            throw new Exception(e.getMessage());
        }
    }
    
     public static void fecharConexao(Connection con, Statement stmt)throws Exception {
        try{
            if(stmt!=null) {stmt.close();}
            if(con!=null) {con.close();}
            
        }catch (SQLException e){
            throw new Exception(e.getMessage());
        }
    }
     
      public static void fecharConexao(Connection con)throws Exception {
        try{
            if(con!=null) {con.close();}
            
        }catch (SQLException e){
            throw new Exception(e.getMessage());
        }
    }
}
