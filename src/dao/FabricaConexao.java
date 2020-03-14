/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author g3ra1d0
 */
public class FabricaConexao {
    private static final String STR_DRIVER = "org.gjt.mm.mysql.Driver";  // definição de qual banco será utilizado
    private static final String DATABASE = "banco3"; // Nome do banco de dados         
    private static final String IP = "127.0.0.1";  // ip de conexao
    
    private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE; // string de conexao com o banco de dados
  
    private static final String USER = "root"; // Nome do usuário
    private static final String PASSWORD = ""; // senha
    
    private static Connection objConexao = null;
 
    public FabricaConexao() {
        try{
            Class.forName(STR_DRIVER);
            objConexao = DriverManager.getConnection(STR_CON, USER, PASSWORD);
            System.out.println("Conector com o BD!");
        }catch (ClassNotFoundException e) {   
            String errorMsg = "Driver nao encontrado: "+e.getMessage();    
            System.out.println(errorMsg);
        } catch (SQLException e) {   
            String errorMsg = "Erro ao obter a conexao: "+e.getMessage();   
            System.out.println(errorMsg);
        }   
    }
 
    public static Connection GeraConexao() {
        if (objConexao == null) {
            FabricaConexao MANTERCONEXAO = new FabricaConexao();
        }
        return objConexao;
    }
     
}