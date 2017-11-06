/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.Models;

import java.sql.Date;

/**
 *
 * @author bruno.falmeida
 */
public class FuncionarioModel {
    
    private int IdFunc;
    private int IdFilial;
    private int IdCargo;
    private String func_nome;
    private String sexo;
    private boolean status;
    private Date dataNasc;
    private String estadoCivil;
    private String cpf;
    private String telefone;
    private String celular;
    private String email;
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String login;
    private String senha;
    
    public FuncionarioModel(int IdFilial, int IdCargo, String func_nome, String sexo, boolean status, Date dataNasc, String estadoCivil, String cpf, String telefone, String celular, String email, String logradouro, int numero, String complemento, String cep, String bairro, String cidade, String estado, String login, String senha) {
        this.IdFilial = IdFilial;
        this.IdCargo = IdCargo;
        this.func_nome = func_nome;
        this.sexo = sexo;
        this.status = status;
        this.dataNasc = dataNasc;
        this.estadoCivil = estadoCivil;
        this.cpf = cpf;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.login = login;
        this.senha = senha;
    }
    
    public FuncionarioModel(int IdFunc, int IdFilial, int IdCargo, String func_nome, String sexo, boolean status, Date dataNasc, String estadoCivil, String cpf, String telefone, String celular, String email, String logradouro, int numero, String complemento, String cep, String bairro, String cidade, String estado, String login, String senha) {
        this.IdFunc = IdFunc;
        this.IdFilial = IdFilial;
        this.IdCargo = IdCargo;
        this.func_nome = func_nome;
        this.sexo = sexo;
        this.status = status;
        this.dataNasc = dataNasc;
        this.estadoCivil = estadoCivil;
        this.cpf = cpf;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.login = login;
        this.senha = senha;
    }

    public int getIdFunc() {
        return IdFunc;
    }

    public void setIdFunc(int IdFunc) {
        this.IdFunc = IdFunc;
    }

    public int getIdFilial() {
        return IdFilial;
    }

    public void setIdFilial(int IdFilial) {
        this.IdFilial = IdFilial;
    }

    public int getIdCargo() {
        return IdCargo;
    }

    public void setIdCargo(int IdCargo) {
        this.IdCargo = IdCargo;
    }

    public String getFunc_nome() {
        return func_nome;
    }

    public void setFunc_nome(String func_nome) {
        this.func_nome = func_nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}