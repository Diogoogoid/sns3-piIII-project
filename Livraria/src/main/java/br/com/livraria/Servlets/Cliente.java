/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.Servlets;

import br.com.livraria.DAOs.ClienteDAO;
import br.com.livraria.Models.ClienteModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diogo.sfelix
 */
@WebServlet(name = "Cliente", urlPatterns = {"/cadastrarCliente","/exibirCliente","/listarTodosClientes"})
public class Cliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {

         // pego a url chamada pelo menuPrincipal
        String destino = request.getServletPath();
        RequestDispatcher requestDispatcher;
        
        ClienteDAO daoCliente = new ClienteDAO();
        List<ClienteModel> clientes;
        ClienteModel cliente;
        
            // direciono a url chamada para a classe correta
            switch(destino){
                case "/cadastrarCliente":                    
                    
                try{
        
                String nomeCliente = request.getParameter("Nome");
                String sexo = request.getParameter("sexo");
                Date dataNasc = Date.valueOf(request.getParameter("dtnasc"));
                String estadoCivil = request.getParameter("estadoCivil");
                String cpf = request.getParameter("cpf");
                String telefone = request.getParameter("telefone");
                String celular =  request.getParameter("celular");       
                String email = request.getParameter("email");
                String cep = request.getParameter("cep");
                String rua = request.getParameter("rua");
                String numero = request.getParameter("numero");
                String bairro = request.getParameter("bairro");
                String estado = request.getParameter("cidade");
                String cidade = request.getParameter("estado"); 
                
                cliente = new ClienteModel(
                        nomeCliente, sexo, dataNasc, estadoCivil, cpf, telefone, celular,
                        email, cep, rua, numero, bairro, estado, cidade
                );
                
                ClienteDAO.inserir(cliente);
                
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroSucess.jsp");
                requestDispatcher.forward(request, response);
                        
                } catch (ClassNotFoundException | IllegalArgumentException | SQLException e) {
                    System.out.println("Erro" + e);
                    
                    request.setAttribute("msg", e);
                    requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroDanger.jsp");
                    requestDispatcher.forward(request, response);
                }    
                    
                    break;        
                case "/exibirCliente":
                    System.out.println("Exibir cliente");
                    try{
                        
                        String nomePesquisaCliente = request.getParameter("Nome");
                        
                        if(!nomePesquisaCliente.isEmpty()){
                            clientes = daoCliente.procurar(nomePesquisaCliente);
                            request.setAttribute("pesquisa", clientes);

                        }else{
                            request.setAttribute("msgErroBusca", "Sua busca não gerou resultados!");
                                   
                        }
                        
                        request.getRequestDispatcher("/WEB-INF/jsp/listarCliente.jsp").forward(request, response);
                        
                    }catch(SQLException | ServletException | IOException e){
                        System.out.println("Erro -> " + e);
                    } catch (Exception ex) {
                        Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                case "/listarTodosClientes":
                    case "/listarTodosProdutos":
                    
                    try {
                        clientes = ClienteDAO.listar();
                         
                        if(clientes != null){
                            request.setAttribute("pesquisa", clientes);
                            
                        }else{
                            request.setAttribute("msgErroBusca", "Sua busca no gerou resuldato");
                            
                        }
                        
                        request.getRequestDispatcher("/WEB-INF/jsp/listarCliente.jsp").forward(request, response);
                        
                    } catch(SQLException | ServletException | IOException e){
                        System.out.println("Erro -> " + e);
                    } catch (Exception ex) {
                        Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;
                    
            }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
