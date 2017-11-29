/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.Servlets;

import br.com.livraria.DAOs.CargoDAO;
import br.com.livraria.DAOs.FilialDAO;
import br.com.livraria.DAOs.FuncionarioDAO;
import br.com.livraria.Models.CargoModel;
import br.com.livraria.Models.FuncionarioModel;
import br.com.livraria.Models.SetorModel;
import br.com.livraria.Services.CadastraUsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author diogo.sfelix
 */
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario","/exibirUsuario","/listarTodosUsuario"})
public class CadastrarUsuario extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
         
         // pego a url chamada pelo menuPrincipal
        String destino = request.getServletPath();
        RequestDispatcher requestDispatcher;
        
        FuncionarioDAO daoFuncionario = new FuncionarioDAO();
        List<FuncionarioModel> funcionarios;
        FuncionarioModel funcionario;   
        
        // direciono a url chamada para a classe correta
            switch(destino){
                case "/CadastrarUsuario": 
                   
                    try{
                        System.out.println("Entrei no post");
                        
                        String nomeUsuario = request.getParameter("Nome");
                        System.out.println("Nome " + nomeUsuario);
                        String login = request.getParameter("login");
                        System.out.println("login " + login);
                        String password = request.getParameter("password");
                        System.out.println("password" + password);
                        int idFilial = Integer.parseInt(request.getParameter("filial"));
                        System.out.println("filial" + idFilial);
                        int idCargo = Integer.parseInt(request.getParameter("Cargo"));
                        System.out.println("idcargo" + idCargo);
                        
                        funcionario = new FuncionarioModel(
                                  FilialDAO.obter(idFilial), CargoDAO.obter(idCargo), nomeUsuario, login, password
                        );
                        
                        FuncionarioDAO.inserir(funcionario);
                        
                        requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroSucess.jsp");
                        requestDispatcher.forward(request, response);
                        
                    } catch (ClassNotFoundException | IllegalArgumentException | SQLException e) {
                        System.out.println("Erro" + e);
                    
                        request.setAttribute("msg", e);
                        requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroDanger.jsp");
                        requestDispatcher.forward(request, response);
                        
                    } catch (Exception ex) {    
                        Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                case "/exibirUsuario":
                    try{
                        
                        String nomePesquisaCliente = request.getParameter("Nome");
                        
                        System.out.println("Entre no exibirUsuario");
                        if(!nomePesquisaCliente.isEmpty()){
                            funcionarios = daoFuncionario.procurar(nomePesquisaCliente);
                            request.setAttribute("pesquisa", funcionarios);

                        }else{
                            request.setAttribute("msgErroBusca", "Sua busca não gerou resultados!");
                                   
                        }
                        
                        request.getRequestDispatcher("/WEB-INF/jsp/listarUsuario.jsp").forward(request, response);
                        
                    }catch(SQLException | ServletException | IOException e){
                        System.out.println("Erro -> " + e);
                    } catch (Exception ex) {
                        Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                case "/listarTodosUsuario":
                    
                    try{
                        funcionarios = FuncionarioDAO.listar();
                         
                        if(funcionarios != null){
                            request.setAttribute("pesquisa", funcionarios);
                            
                        }else{
                            request.setAttribute("msgErroBusca", "Sua busca no gerou resuldato");
                            
                        }
                        
                        request.getRequestDispatcher("/WEB-INF/jsp/listarUsuario.jsp").forward(request, response);
                    
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
        // criar a seção para gravar o usuario
        /*
        HttpSession sessao = request.getSession(); 
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        
        List<SetorModel> listaSetores = null;
        try {
            listaSetores = CadastraUsuarioService.getSetores();
        } catch (Exception ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("setores", listaSetores);
        
        List<CargoModel> listaCargos = null;
        try {
            listaCargos = CadastraUsuarioService.getCargos();
        } catch (Exception ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("cargos", listaCargos);
        
        request.getRequestDispatcher("WEB-INF/jsp/cadastrarUsuario.jsp").forward(request, response);
        */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         processRequest(request, response);
    }
}