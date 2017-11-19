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

/**
 *
 * @author diogo
 */
@WebServlet(name = "Rotas", urlPatterns = {"/formUsuario","/formCliente"})
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
            case "/home":
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
                requestDispatcher.forward(request, response);
            break;    
        }
        /*
        
        if(destino.equalsIgnoreCase("/home")){
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            requestDispatcher.forward(request, response);
        }
        else if(destino.equalsIgnoreCase("/formUsuario")){
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastrarUsuario.jsp");
            requestDispatcher.forward(request, response);
        }
        else if(destino.equalsIgnoreCase("/formCliente")){
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastrarCliente.jsp");
            requestDispatcher.forward(request, response);
        }
        */
        
    }

}
