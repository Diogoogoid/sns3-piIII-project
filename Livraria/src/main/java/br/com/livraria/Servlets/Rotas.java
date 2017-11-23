/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Rotas", urlPatterns = {"/formUsuario","/formCliente","/menuPrincipal","/formProduto","/listarProduto","/listarCliente"})
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
            }
        
    }

}
