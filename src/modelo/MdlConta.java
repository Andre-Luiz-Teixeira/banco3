/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author andre
 */
public class MdlConta {
    private int codigo;
    private String descricao;
    private double saldo;

    public MdlConta(String descricao, double saldo) {
        this.descricao = descricao;
        this.saldo = saldo;
    }

    public MdlConta() {
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String[] toVetor(){
        String vetor[] = new String[3];
        
        vetor[0] = String.valueOf(getCodigo());
        vetor[1] = getDescricao();
        vetor[2] = String.valueOf(getSaldo());
        
        return vetor;
    }

    public void vetorTo(String[] dados) {
        this.setCodigo(Integer.parseInt(dados[0]));
        this.setDescricao(dados[1]);
        this.setSaldo(Double.parseDouble(dados[2]));
    }

    @Override
    public String toString() {
        return "Codigo: " + this.codigo + " descricao: " + this.descricao + " saldo: " + this.saldo;
    }
    
    
}
