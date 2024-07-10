/*
    Isabelly Barbosa Gonçalves CB3021467
    Lucas Aragão Almeida CB3013146
*/

package br.com.isabellycomex.tp02.product.models;

public class Produtos {
    private Integer id;
    private String nome;
    private Integer unidadeCompra;
    private String descricao;
    private Double qtdPrevistoMes;
    private Double precoMaxComprado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getUnidadeCompra() {
        return unidadeCompra;
    }

    public void setUnidadeCompra(Integer unidadeCompra) {
        this.unidadeCompra = unidadeCompra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getQtdPrevistoMes() {
        return qtdPrevistoMes;
    }

    public void setQtdPrevistoMes(Double qtdPrevistoMes) {
        this.qtdPrevistoMes = qtdPrevistoMes;
    }

    public Double getPrecoMaxComprado() {
        return precoMaxComprado;
    }

    public void setPrecoMaxComprado(Double precoMaxComprado) {
        this.precoMaxComprado = precoMaxComprado;
    }
}
