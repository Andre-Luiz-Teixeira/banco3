/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import com.sun.istack.internal.logging.Logger;
import dao.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
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
        MdlConta conta = new MdlConta("teste2", 999);
        try {

            Connection transacao1 = dao.FabricaConexao.getConexaoCustomizada();

            DaoConta dao = new DaoConta(transacao1);
            dao.Inserir(conta);

            transacao1.commit();

        } catch (Exception ex) { 
        }
        
        
    }
}
