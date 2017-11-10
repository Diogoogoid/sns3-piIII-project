/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.Models;

/**
 *
 * @author Bruno Fonseca
 */
public class CargoModel {

    private int IdCargo;
    private int IdSetor;
    private String Cargo_Nome;
    private String Descricao;
    private boolean Status;

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public int getIdCargo() {
        return IdCargo;
    }

    public void setIdCargo(int IdCargo) {
        this.IdCargo = IdCargo;
    }

    public int getIdSetor() {
        return IdSetor;
    }

    public void setIdSetor(int IdSetor) {
        this.IdSetor = IdSetor;
    }

    public String getCargo_Nome() {
        return Cargo_Nome;
    }

    public void setCargo_Nome(String Cargo_Nome) {
        this.Cargo_Nome = Cargo_Nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
}