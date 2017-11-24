/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.Servlets;

import br.com.livraria.DAOs.FilialDAO;
import br.com.livraria.Models.CargoModel;
import br.com.livraria.Models.FilialModel;
import br.com.livraria.Services.CadastraUsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Rotas", urlPatterns = {"/formUsuario","/formCliente","/menuPrincipal","/formProduto","/listarProduto","/listarCliente","/listarUsuario"})
public class Rotas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // pego a url chamada pelo menuPrincipal
        String destino = request.getServletPath();
        RequestDispatcher requestDispatcher;
        //System.out.println("DESTINO" + destino);
        
            // direciono a url chamada para a rota necessaria
            switch(destino){
                case "/formUsuario":
                    List<CargoModel> listaCargos = null;
                     try {
                         listaCargos = CadastraUsuarioService.getCargos();
                     } catch (Exception ex) {
                         Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                     }
 
                     for(int i = 0; i < listaCargos.size(); i++) {
                         String cargoNome = listaCargos.get(i).getCargo_Nome();
                         String setorNome = listaCargos.get(i).Setor.getSetor_Nome();
                         String temp = cargoNome + " - " + setorNome;
                         listaCargos.get(i).setCargo_Nome(temp);
                     }
                     
                    List<FilialModel> listaFiliais = null;
                    try {
                        listaFiliais = FilialDAO.listar();
                    } catch (Exception ex) {
                        Logger.getLogger(Rotas.class.getName()).log(Level.SEVERE, null, ex);
                    }
 
                    request.setAttribute("filiais", listaFiliais);
                    request.setAttribute("cargos", listaCargos);
                    requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastrarUsuario.jsp");
                    requestDispatcher.forward(request, response);
                break;        
                case "/menuPrincipal":
                    requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
                    requestDispatcher.forward(request, response);
                break;    
                case "/formCliente":
                    requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastrarCliente.jsp");
                    requestDispatcher.forward(request, response);
                break;   
                case "/formProduto":
                    requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastrarProduto.jsp");
                    requestDispatcher.forward(request, response);
                break;  
                case "/listarProduto":
                    requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listarProduto.jsp");
                    requestDispatcher.forward(request, response);
                break;
                case "/listarCliente":
                    requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listarCliente.jsp");
                    requestDispatcher.forward(request, response);
                break;
                case "/listarUsuario":
                    requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listarUsuario.jsp");
                    requestDispatcher.forward(request, response);
                break;
            }   
    }
}