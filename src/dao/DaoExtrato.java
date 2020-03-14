package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.MdlExtrato;


public class DaoExtrato {
    // variaveis usadas em todas as clases
    Connection conexao = FabricaConexao.GeraConexao(); // Gera conexao com o banco
    String sql = "";// recebe o comando no sql
    PreparedStatement pst;

    public void Inserir(MdlExtrato extrato) {
        sql = "insert into extrato(descricao, valor, tipo, codigo) values (?, ?, ?, ?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, extrato.getDescricao());
            pst.setDouble(2, extrato.getValor());
            pst.setString(3, extrato.getTipo());
            pst.setInt(4, extrato.getCodigo());
            

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir o objeto extrato: " + ex.getMessage());
        }
    }

    public void Atualizar(MdlExtrato extrato) {
        sql = "update extrato set descricao = ?, valor = ?, tipo = ?, codigo = ? where id = ? ";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, extrato.getDescricao());
            pst.setDouble(2, extrato.getValor());
            pst.setString(3, extrato.getTipo());
            pst.setInt(4, extrato.getCodigo());
            
            pst.setInt(5, extrato.getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto extrato: " + ex.getMessage());
        }
    }

    public void Excluir(MdlExtrato extrato) {
        sql = "delete from extrato where id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, extrato.getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir o objeto extrato: " + ex.getMessage());
        }
    }

    public ArrayList<MdlExtrato> Selecionar(int index) {
        MdlExtrato extrato = new MdlExtrato();
        ArrayList<MdlExtrato> listaExtrato = new ArrayList<>();
        sql = "select id, descricao, valor, tipo, codigo from extrato where id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, index);

            ResultSet resultado = pst.executeQuery();
            if (resultado.next()) {
                extrato.setId(resultado.getInt("id"));
                extrato.setDescricao(resultado.getString("descricao"));
                extrato.setValor(resultado.getDouble("valor"));
                extrato.setTipo(resultado.getString("tipo"));
                extrato.setCodigo(resultado.getInt("codigo"));
                
                listaExtrato.add(extrato);
                
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar o objeto extrato: " + ex.getMessage());
        }

        return listaExtrato;
    }

    public ArrayList<MdlExtrato> Selecionar() {
        ArrayList<MdlExtrato> listaExtrato = new ArrayList<>();
        sql = "select id, descricao, valor, tipo, codigo from extrato";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet resultado = pst.executeQuery();

            while (resultado.next()) {
                MdlExtrato extrato = new MdlExtrato();

                extrato.setId(resultado.getInt("id"));
                extrato.setDescricao(resultado.getString("descricao"));
                extrato.setValor(resultado.getDouble("valor"));
                extrato.setTipo(resultado.getString("tipo"));
                extrato.setCodigo(resultado.getInt("codigo"));

                listaExtrato.add(extrato);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao selecionar tudo todos objeto extrato do banco: " + ex.getMessage());;
        }

        return listaExtrato;
    }
}
