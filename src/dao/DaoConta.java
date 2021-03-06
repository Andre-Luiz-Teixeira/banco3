 package dao;

import java.sql.Connection;
import modelo.MdlConta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoConta {
    
    // variaveis usadas em todas as clases
    private Connection conexao;
    String sql = "";// recebe o comando no sql
    PreparedStatement pst;

    public DaoConta(){
        conexao = dao.FabricaConexao.GeraConexaoPadrao();
    }
    
    public DaoConta(Connection cnx){
        conexao = cnx;
    }
    
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

    public ArrayList<MdlConta> Selecionar(int index) {
        ArrayList<MdlConta> listaConta = new ArrayList<>();
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

                listaConta.add(conta);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar o objeto conta: " + ex.getMessage());
        }

        return listaConta;
    }

    public ArrayList<MdlConta> Selecionar() {
        ArrayList<MdlConta> listaConta = new ArrayList<>();
        MdlConta conta = new MdlConta();
        sql = "select codigo, descricao, saldo from conta";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet resultado = pst.executeQuery();

            while (resultado.next()) {
                
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
