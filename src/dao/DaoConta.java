package dao;

import java.sql.Connection;
import modelo.MdlConta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoConta {

    // variaveis usadas em todas as clases
    Connection conexao = FabricaConexao.GeraConexao(); // Gera conexao com o banco
    String sql = "";// recebe o comando no sql
    PreparedStatement pst;

    public void Inserir(MdlConta conta) {
        sql = "insert into conta(descricao, saldo) values (?, ?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, conta.getDescricao());
            pst.setDouble(2, conta.getSaldo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir o objeto conta: " + ex.getMessage());
        }
    }

    public void Atualizar(MdlConta conta) {
        sql = "update conta set descricao = ?, saldo = ? where codigo = ? ";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, conta.getDescricao());
            pst.setDouble(2, conta.getSaldo());
            pst.setInt(3, conta.getCodigo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto conta: " + ex.getMessage());
        }
    }

    public void Excluir(MdlConta conta) {
        sql = "delete from conta where codigo = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, conta.getCodigo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir o objeto conta: " + ex.getMessage());
        }
    }

    public MdlConta Selecionar(int index) {
        MdlConta conta = new MdlConta();
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

    public ArrayList<MdlConta> SelecionarTudo() {
        ArrayList<MdlConta> listaConta = new ArrayList<>();
        sql = "select codigo, descricao, saldo from conta";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet resultado = pst.executeQuery();

            while (resultado.next()) {
                MdlConta conta = new MdlConta();

                conta.setCodigo(resultado.getInt("codigo"));
                conta.setDescricao(resultado.getString("descricao"));
                conta.setSaldo(resultado.getDouble("saldo"));

                listaConta.add(conta);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar tudo todos objeto conta do banco: " + ex.getMessage());;
        }

        return listaConta;
    }
}
