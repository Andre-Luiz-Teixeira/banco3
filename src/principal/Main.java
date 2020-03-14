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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Connection conexao = fabricaConexao.GeraConexao();
        /*
        //Teste de conta
        MdlConta mdlConta = new MdlConta();
        DaoConta daoConta = new DaoConta();
        String[] vetorConta = new String[3];
        ArrayList<MdlConta> arrayConta = new ArrayList<>();

        //objeto
        mdlConta.setDescricao("Conta Teste");
        mdlConta.setSaldo(9000);
        mdlConta.setCodigo(2);

        //daoConta.Inserir(mdlConta);
        //daoConta.Atualizar(mdlConta);
        //daoConta.Excluir(mdlConta);
        arrayConta = daoConta.Selecionar(2);
        
        for (MdlConta conta : arrayConta) {
            System.out.println(conta);
        }
         */

        /*
        //Teste de extrato
        MdlExtrato mdlExtrato = new MdlExtrato();
        DaoExtrato daoExtrato = new DaoExtrato();
        ArrayList<MdlExtrato> arrayExtrato = new ArrayList<>();

        //objeto
     
        mdlExtrato.setId(3);
        mdlExtrato.setDescricao("pagamento");
        mdlExtrato.setValor(100);
        mdlExtrato.setTipo("debito");
        mdlExtrato.setCodigo(2);

        //comandos dao
        //daoExtrato.Inserir(mdlExtrato);
        //daoExtrato.Atualizar(mdlExtrato);
        //daoExtrato.Excluir(mdlExtrato);
        
        /*arrayExtrato = daoExtrato.Selecionar(3);

        for (MdlExtrato conta : arrayExtrato) {
            System.out.println(conta);
        }*/
        
        /*arrayExtrato = daoExtrato.Selecionar();

        for (MdlExtrato conta : arrayExtrato) {
            System.out.println(conta);
        }*/
    }
}
