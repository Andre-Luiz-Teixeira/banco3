package dao;

import java.sql.Connection;
import modelo.mdl_conta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dao_conta {

    // variaveis usadas em todas as clases
    Connection conexao = fabricaConexao.GeraConexao(); // Gera conexao com o banco
    String sql = "";// recebe o comando no sql
    PreparedStatement pst;

    public void Inserir(mdl_conta objConta) {
        sql = "insert into conta(descricao, saldo) values (?, ?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objConta.getDescricao());
            pst.setDouble(2, objConta.getSaldo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir o objeto conta: " + ex.getMessage());
        }
    }

    public void Atualizar(mdl_conta objConta) {
        sql = "update conta set descricao = ?, saldo = ? where codigo = ? ";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objConta.getDescricao());
            pst.setDouble(2, objConta.getSaldo());
            pst.setInt(3, objConta.getCodigo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto conta: " + ex.getMessage());
        }
    }

    public void Excluir(mdl_conta objConta) {
        sql = "delete from conta where codigo = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objConta.getCodigo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir o objeto conta: " + ex.getMessage());
        }
    }

    public mdl_conta Selecionar(int index) {
        mdl_conta conta = new mdl_conta();
        sql = "select codigo, descricao, saldo from conta where codigo = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, index);

            ResultSet resultado = pst.executeQuery();
            if (resultado.next()) {

                conta.setCodigo(resultado.getInt("codigo"));
                conta.setDescricao(resultado.getString("descricao"));
                conta.setSaldo(resultado.getDouble("saldo"));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar o objeto conta: " + ex.getMessage());
        }

        return conta;
    }

    public ArrayList<mdl_conta> SelecionarTudo() {
        ArrayList<mdl_conta> ListaConta = new ArrayList<>();
        sql = "select codigo, descricao, saldo from conta";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet resultado = pst.executeQuery();

            while (resultado.next()) {
                mdl_conta conta = new mdl_conta();

                conta.setCodigo(resultado.getInt("codigo"));
                conta.setDescricao(resultado.getString("descricao"));
                conta.setSaldo(resultado.getDouble("saldo"));

                ListaConta.add(conta);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar tudo todos objeto do banco: " + ex.getMessage());;
        }

        return ListaConta;
    }
}
