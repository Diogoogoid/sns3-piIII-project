/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.Models;

import java.util.Date;

/**
 *
 * @author Bruno Fonseca
 */
public class ProdutoModel {
     // Atributos
    private Integer id;
    private String nome;
    private String fabricante;
    private String tipoProduto;
    private int qtdProduto;
    private Float ValorProduto;
    private boolean status;
    private Date dtFabricacao;
    private int garantia;

    // Get e Setter

    public Date getDtFabricacao() {
        return dtFabricacao;
    }

    public void setDtFabricacao(Date dtFabricacao) {
        this.dtFabricacao = dtFabricacao;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public boolean isStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId (){
        return this.id;
    }
    
    public void setNome (String nome){
        this.nome = nome;
    }
    
    public String getNome (){
        return this.nome;
    }
    
    public void setFabricante (String fabricante){
        this.fabricante = fabricante;
    }
    
    public String getFabricante (){
        return this.fabricante;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
     
    public void setValorProduto(Float ValorProd){
        this.ValorProduto = ValorProd;
    }
    
    public Float getValorProduto (){
        return ValorProduto;
    }
}