/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno.falmeida
 */
public class LoginDAO {
        public LoginModel DoLogin(int idFuncionario) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Funcionario f = null;

        String sql = "SELECT idFuncionario, nomeFuncionario, sobrenomeFuncionario, dataNasc, "
                + " cpfFuncionario, emailFuncionario, telefoneFuncionario, estadoFuncionario, cidadeFuncionario, cargo, login, senha "
                + "FROM Funcionario WHERE idFuncionario = ?";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idFuncionario);
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                int id = resultados.getInt("idFuncionario");
                String nome = resultados.getString("nomeFuncionario");
                String sobrenome = resultados.getString("sobrenomeFuncionario");
                Date dataNasc = resultados.getDate("dataNasc");
                String cpf = resultados.getString("cpfFuncionario");
                String email = resultados.getString("emailFuncionario");
                String telefone = resultados.getString("telefoneFuncionario");
                String estado = resultados.getString("estadoFuncionario");
                String cidade = resultados.getString("cidadeFuncionario");
                String cargo = resultados.getString("cargo");
                String login = resultados.getString("login");
                String senha = resultados.getString("senha");
                f = new Funcionario(id, nome, sobrenome, dataNasc, cpf, email, telefone, estado, cidade, cargo, login, senha);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Código colocado aqui para garantir que a conexão com o banco
            // seja sempre fechada, independentemente se executado com sucesso
            // ou erro.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return f;
    }
}
