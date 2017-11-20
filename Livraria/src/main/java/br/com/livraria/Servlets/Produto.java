package br.com.livraria.Servlets;

import br.com.livraria.DAOs.ProdutoDAO;
import br.com.livraria.Models.ProdutoModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "Produto", urlPatterns = {"/cadastrarProduto"})
public class Produto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // pego a url chamada pelo menuPrincipal
        String destino = request.getServletPath();
        RequestDispatcher requestDispatcher;
        
            // direciono a url chamada para a classe correta
            switch(destino){
                case "/cadastrarProduto":                    
                            
                String nome = request.getParameter("Nome");
                String fabricante = request.getParameter("Fabricante");
                String tipoProduto = request.getParameter("TipoProduto");
                int qtdProduto = Integer.parseInt(request.getParameter("qtdProduto"));
                float valorProduto = Float.parseFloat(request.getParameter("valor"));
                Date dtFabricacao = Date.valueOf(request.getParameter("dtFabricacao"));
                int garantia = Integer.parseInt(request.getParameter("garantia"));

                ProdutoModel produto = new ProdutoModel(
                        nome, fabricante, tipoProduto, qtdProduto, valorProduto, dtFabricacao, garantia
                );

                    try {
                        ProdutoDAO.inserir(produto);

                    } catch (Exception ex) {
                        Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                    }

                break;    
            }
    }

}
