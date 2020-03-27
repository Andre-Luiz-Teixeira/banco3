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
public class MdlExtrato {
    private int id;
    private String descricao;
    private double valor;
    private String tipo;
    private int codigo;

    public MdlExtrato(String descricao, double valor, String tipo, int codigo) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.codigo = codigo;
    }

    public MdlExtrato() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }    

    @Override
    public String toString() {
        return "id: " + this.id + " descricao: " + this.descricao + " tipo: " + this.tipo + " codigo: " + this.codigo;
    }
    
    
}
