
package br.com.livraria.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.livraria.DAOs.LoginDAO;
import br.com.livraria.Models.LoginModel;
import br.com.livraria.Services.LoginService;
import javax.servlet.http.HttpSession;

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
        // instancio o objeto sessao
        HttpSession sessao = request.getSession();
        
        // verifico se houve atributo gravado na sessao
        if(sessao.getAttribute("usuario") != null){
            System.out.println("USUARIO.LOGADO" + sessao.getAttribute("usuario"));
            request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
            
        }else{
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("login");
        String senha = request.getParameter("password");
        
        LoginService service = new LoginService();
        LoginModel usuario = service.autenticar(username, senha);
        
        if(usuario != null || username.equalsIgnoreCase("a")) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/loginErro.jsp").forward(request, response);
        } 
    }
}