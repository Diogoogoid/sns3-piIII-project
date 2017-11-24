/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.DAOs;

import br.com.livraria.Models.LoginModel;
import br.com.livraria.Models.ModuloModel;
import br.com.livraria.Utils.ConexaoDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno.falmeida
 */
public class LoginDAO {
    public static LoginModel DoLogin(String login, String senha) throws SQLException {
        String sql = "SELECT f.IdFunc, c.IdCargo, f.login, f.nome, c.cargo_nome, s.setor_nome " +
                        "FROM funcionario f " +
                        "INNER JOIN cargo c on c.IdCargo = f.IdCargo " +
                        "INNER JOIN setor s on s.IdSetor = c.IdSetor " +
                        "WHERE f.login = ? and f.senha = ?";
        
        // conexao para abertura e fechamento do BD
        Connection connection = null;
        
        // Statement para obtenção atraves da conexão, execuçao
        // comandos SQL
        PreparedStatement preparedStatement = null;
        
        //Armazenará os resultados do banco de dados
        ResultSet result = null;

        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, login);            
            preparedStatement.setString(2, senha);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {                
                LoginModel Login = new LoginModel();
                Login.setIdUsuario(result.getInt("IdFunc"));
                Login.setIdCargo(result.getInt("IdCargo"));
                Login.setLogin(result.getString("login"));
                Login.setNome(result.getString("nome"));
                Login.setCargo(result.getString("cargo_nome"));
                Login.setSetor(result.getString("setor_nome"));
                
                //Retorna o resultado
                return getPermissao(Login);
            }
        }catch(SQLException e) {
            
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        return null;
    }
        
    private static LoginModel getPermissao(LoginModel login) throws SQLException {
        
        List<ModuloModel> modulos = null;

        String sql = "SELECT m.IDMODULO, m.MODULO_NOME, m.SUB_NOME from MODULO m " +
                    "INNER JOIN PERMISSAO p on p.IDMODULO = m.IDMODULO AND p.IDCARGO = ?";
        
        // conexao para abertura e fechamento do BD
        Connection connection = null;
        
        // Statement para obtenção atraves da conexão, execuçao
        // comandos SQL
        PreparedStatement preparedStatement = null;
        
        //Armazenará os resultados do banco de dados
        ResultSet result = null;

        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, login.getIdCargo());

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (modulos == null) {
                    modulos = new ArrayList<>();
                }
                
                ModuloModel modulo = new ModuloModel();
                modulo.setIdModulo(result.getInt("IDMODULO"));
                modulo.setModuloNome(result.getString("MODULO_NOME"));
                modulo.setSubNome(result.getString("SUB_NOME"));
                
                //Adiciona a instância na lista
                modulos.add(modulo);
            }
            
            login.setModulos(modulos);
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        return login;
    }
}