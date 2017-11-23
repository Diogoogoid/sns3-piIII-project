/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.Models;

/**
 *
 * @author bruno.falmeida
 */
public class ModuloModel {
    
    private int idModulo;
    private String moduloNome;
    private String subNome;

    public String getSubNome() {
        return subNome;
    }

    public void setSubNome(String subNome) {
        this.subNome = subNome;
    }
    
    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public String getModuloNome() {
        return moduloNome;
    }

    public void setModuloNome(String moduloNome) {
        this.moduloNome = moduloNome;
    }
}
