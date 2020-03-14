/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import dao.*;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author andre
 */
public class bancosaulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Connection conexao = fabricaConexao.GeraConexao();
        
       
       mdl_conta obj_mdl_Conta = new mdl_conta();
        dao_conta obj_dao_Conta = new dao_conta();
        String[] vetorConta = new String[3];
        ArrayList<mdl_conta> arrayConta = new ArrayList<>();
    
        //objeto
        obj_mdl_Conta.setDescricao("Conta Teste");
        obj_mdl_Conta.setSaldo(9000);
        obj_mdl_Conta.setCodigo(2);
        
        //obj_dao_Conta.Inserir(obj_mdl_Conta);
        //obj_dao_Conta.Atualizar(obj_mdl_Conta);
        //obj_dao_Conta.Excluir(obj_mdl_Conta);
        arrayConta = obj_dao_Conta.SelecionarTudo();
        
        for (mdl_conta conta : arrayConta) {
            System.out.println(conta);
        }
    }
    
}
