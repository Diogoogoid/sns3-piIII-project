/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.Services;

import br.com.livraria.DAOs.LoginDAO;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import br.com.livraria.Models.LoginModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno.falmeida
 */
public class LoginService {
  public LoginModel autenticar(String username, String senha) {
    // 1) Verifica se username existe
    LoginModel usuario = null;
    try {
        usuario = LoginDAO.DoLogin(username, senha);
    } catch (SQLException ex) {
        Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    if (usuario != null) {
	return usuario;
    }

    // Usuario nao existe ou senha esta incorreta
    return null;
  }
}