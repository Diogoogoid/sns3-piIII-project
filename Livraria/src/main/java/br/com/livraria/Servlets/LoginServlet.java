
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
 * @author bruno.falmeida
 * edit diogo.sfelix
 */
@WebServlet(urlPatterns = "/home")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("login");
        String senha = request.getParameter("password");
        
        if(usuario.equalsIgnoreCase("a")){
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
        }else{
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/loginErro.jsp").forward(request, response);
        } 
        
    }
}
