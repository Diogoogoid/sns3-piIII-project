/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.DAOs;

import br.com.livraria.Models.FuncionarioModel;
import br.com.livraria.Utils.ConexaoDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno.falmeida
 */
public class FuncionarioDAO {
    //Insere um cliente na tabela "cliente" do banco de dados
    public static void inserir(FuncionarioModel func)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO FUNCIONARIO (FUNC_NOME, SEXO, STATUS, DATANASC, ESTADOCIVIL,"
                + "CPF, TEL, CEL, EMAIL, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, "
                + "BAIRRO, CIDADE, ESTADO, LOGIN, SENHA, IDFILIAL, IDCARGO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        //Conexão para abertura e fechamento
        Connection connection = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, func.getFunc_nome());
            preparedStatement.setString(2, func.getSexo());
            preparedStatement.setBoolean(3, true);
            Timestamp t = new Timestamp(func.getDataNasc().getTime());
            preparedStatement.setTimestamp(4, t);
            preparedStatement.setString(5, func.getEstadoCivil());
            preparedStatement.setString(6, func.getCpf());
            preparedStatement.setString(7, func.getTelefone());
            preparedStatement.setString(8, func.getCelular());
            preparedStatement.setString(9, func.getEmail());
            preparedStatement.setString(10, func.getLogradouro());
            preparedStatement.setString(11, func.getNumero());
            preparedStatement.setString(12, func.getComplemento());
            preparedStatement.setString(13, func.getCep());
            preparedStatement.setString(14, func.getBairro());
            preparedStatement.setString(15, func.getCidade());
            preparedStatement.setString(16, func.getEstado());
            preparedStatement.setString(17, func.getLogin());
            preparedStatement.setString(18, func.getSenha());
            preparedStatement.setInt(19, func.getIdFilial());
            preparedStatement.setInt(20, func.getIdCargo());
            
            //Executa o comando no banco de dados
            preparedStatement.execute();
        }
        catch (SQLException e) {
        }
        finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static void atualizar(FuncionarioModel func)
            throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando
        //prepared statement
        String sql = "UPDATE FUNCIONARIO SET IDFILIAL=?, IDCARGO=?, FUNC_NOME=?, " 
                + "SEXO=?, STATUS=?, DATANASC=?, "
                + "ESTADOCIVIL=?, CPF=?, TEL=?, CEL=?, EMAIL=?, LOGRADOURO=?, "
                + "NUMERO=?, COMPLEMENTO=?, CEP=?, BAIRRO=?, CIDADE=?, ESTADO=? "
                + "LOGIN=?, SENHA=?"
            + "WHERE (IDFUNC=?)";
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();
            
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, func.getIdFilial());
            preparedStatement.setInt(2, func.getIdCargo());
            preparedStatement.setString(3, func.getFunc_nome());
            preparedStatement.setString(4, func.getSexo());
            preparedStatement.setBoolean(5, true);
            Timestamp t = new Timestamp(func.getDataNasc().getTime());
            preparedStatement.setTimestamp(6, t);
            preparedStatement.setString(7, func.getEstadoCivil());
            preparedStatement.setString(8, func.getCpf());
            preparedStatement.setString(9, func.getTelefone());
            preparedStatement.setString(10, func.getCelular());
            preparedStatement.setString(11, func.getEmail());
            preparedStatement.setString(12, func.getLogradouro());
            preparedStatement.setString(13, func.getNumero());
            preparedStatement.setString(14, func.getComplemento());
            preparedStatement.setString(15, func.getCep());
            preparedStatement.setString(16, func.getBairro());
            preparedStatement.setString(17, func.getCidade());
            preparedStatement.setString(18, func.getEstado());
            preparedStatement.setString(19, func.getLogin());
            preparedStatement.setString(20, func.getSenha());
            preparedStatement.setInt(21, func.getIdFunc());

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    //Lista todos os clientes da tabela clientes
    public static List<FuncionarioModel> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM FUNCIONARIO WHERE (STATUS=?)";

        //Lista de clientes de resultado
        List<FuncionarioModel> listaFuncionarios = null;

        //Conexão para abertura e fechamento
        Connection connection = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaFuncionarios == null) {
                    listaFuncionarios = new ArrayList<>();
                }
                
                //Cria uma instância de Cliente e popula com os valores do BD
                FuncionarioModel funcionario = new FuncionarioModel();
                funcionario.setIdFunc(result.getInt("IDFUNC"));
                funcionario.setIdFilial(result.getInt("IDFILIAL"));
                funcionario.setIdCargo(result.getInt("IDCARGO"));
                funcionario.setFunc_nome(result.getString("FUNC_NOME"));
                funcionario.setSexo(result.getString("SEXO"));
                Date d = new Date(result.getTimestamp("DATANASC").getTime());
                funcionario.setDataNasc(d);
                funcionario.setStatus(result.getBoolean("STATUS"));
                funcionario.setEstadoCivil(result.getString("ESTADOCIVIL"));
                funcionario.setCpf(result.getString("CPF"));
                funcionario.setTelefone(result.getString("TEL"));
                funcionario.setCelular(result.getString("CEL"));
                funcionario.setEmail(result.getString("EMAIL"));
                funcionario.setLogradouro(result.getString("LOGRADOURO"));
                funcionario.setNumero(result.getString("NUMERO"));
                funcionario.setComplemento(result.getString("COMPLEMENTO"));
                funcionario.setCep(result.getString("CEP"));
                funcionario.setBairro(result.getString("BAIRRO"));
                funcionario.setCidade(result.getString("CIDADE"));
                funcionario.setEstado(result.getString("ESTADO"));
                
                //Adiciona a instância na lista
                listaFuncionarios.add(funcionario);
            }
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

        return listaFuncionarios;
    }
    
    //Procura um cliente no banco de dados, de acordo com o nome
    public static List<FuncionarioModel> procurar(String nome)
            throws SQLException, Exception {
        //Monta a string de consulta de clientes no banco, utilizando
        //o valor passado como parâmetro para busca nas colunas de
        //nome (através do "LIKE" e ignorando minúsculas
        //ou maiúsculas, através do "UPPER" aplicado à coluna e ao
        //parâmetro). Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de clientes configurada com
        //o valor correto ("enabled" com "true")
        String sql = "SELECT * FROM FUNCIONARIO "
                + "WHERE UPPER(FUNC_NOME) LIKE UPPER(?) AND STATUS=?";
        
        //Lista de clientes de resultado
        List<FuncionarioModel> listaFuncionarios = null;
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();
            
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, "%" + nome + "%");
            preparedStatement.setBoolean(2, true);
            
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaFuncionarios == null) {
                    listaFuncionarios = new ArrayList<>();
                }
                
                //Cria uma instância de Cliente e popula com os valores do BD
                FuncionarioModel funcionario;
                funcionario = new FuncionarioModel();
                funcionario.setIdFunc(result.getInt("IDFUNC"));
                funcionario.setIdFilial(result.getInt("IDFILIAL"));
                funcionario.setIdCargo(result.getInt("IDCARGO"));
                funcionario.setFunc_nome(result.getString("FUNC_NOME"));
                funcionario.setSexo(result.getString("SEXO"));
                Date d = new Date(result.getTimestamp("DATANASC").getTime());
                funcionario.setDataNasc(d);
                funcionario.setStatus(result.getBoolean("STATUS"));
                funcionario.setEstadoCivil(result.getString("ESTADOCIVIL"));
                funcionario.setCpf(result.getString("CPF"));
                funcionario.setTelefone(result.getString("TEL"));
                funcionario.setCelular(result.getString("CEL"));
                funcionario.setEmail(result.getString("EMAIL"));
                funcionario.setLogradouro(result.getString("LOGRADOURO"));
                funcionario.setNumero(result.getString("NUMERO"));
                funcionario.setComplemento(result.getString("COMPLEMENTO"));
                funcionario.setCep(result.getString("CEP"));
                funcionario.setBairro(result.getString("BAIRRO"));
                funcionario.setCidade(result.getString("CIDADE"));
                funcionario.setEstado(result.getString("ESTADO"));
                
                //Adiciona a instância na lista
                listaFuncionarios.add(funcionario);
            }
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
        
        //Retorna a lista de clientes do banco de dados
        return listaFuncionarios;        
    }
    
    //Obtém uma instância da classe "Cliente" através de dados do
    //banco de dados, de acordo com o ID fornecido como parâmetro
    public static FuncionarioModel obter(Integer id)
            throws SQLException, Exception {
        
        //Compõe uma String de consulta que considera apenas o cliente
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM FUNCIONARIO WHERE IDFUNC=? AND STATUS=?";

        //Conexão para abertura e fechamento
        Connection connection = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, id);            
            preparedStatement.setBoolean(2, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {                
                //Cria uma instância de Cliente e popula com os valores do BD
                FuncionarioModel funcionario = new FuncionarioModel();
                funcionario.setIdFunc(result.getInt("IDFUNC"));
                funcionario.setIdFilial(result.getInt("IDFILIAL"));
                funcionario.setIdCargo(result.getInt("IDCARGO"));
                funcionario.setFunc_nome(result.getString("FUNC_NOME"));
                funcionario.setSexo(result.getString("SEXO"));
                Date d = new Date(result.getTimestamp("DATANASC").getTime());
                funcionario.setDataNasc(d);
                funcionario.setStatus(result.getBoolean("STATUS"));
                funcionario.setEstadoCivil(result.getString("ESTADOCIVIL"));
                funcionario.setCpf(result.getString("CPF"));
                funcionario.setTelefone(result.getString("TEL"));
                funcionario.setCelular(result.getString("CEL"));
                funcionario.setEmail(result.getString("EMAIL"));
                funcionario.setLogradouro(result.getString("LOGRADOURO"));
                funcionario.setNumero(result.getString("NUMERO"));
                funcionario.setComplemento(result.getString("COMPLEMENTO"));
                funcionario.setCep(result.getString("CEP"));
                funcionario.setBairro(result.getString("BAIRRO"));
                funcionario.setCidade(result.getString("CIDADE"));
                funcionario.setEstado(result.getString("ESTADO"));
                
                //Retorna o resultado
                return funcionario;
            }            
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
    
    //Realiza a exclusão lógica de um cliente no BD, com ID fornecido
    //como parâmetro. A exclusão lógica simplesmente "desliga" o
    //cliente, configurando um atributo específico, a ser ignorado
    //em todas as consultas de cliente ("enabled").
    public static void excluir(Integer id) throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando
        //prepared statement
        String sql = "UPDATE FUNCIONARIO SET STATUS=? WHERE IDFUNC=?";
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();
            
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);
            
            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}