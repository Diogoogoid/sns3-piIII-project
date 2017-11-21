package br.com.livraria.Servlets;

import br.com.livraria.DAOs.ProdutoDAO;
import br.com.livraria.Models.ProdutoModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
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
@WebServlet(name = "Produto", urlPatterns = {"/cadastrarProduto","/exibirProduto"})
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
                    
                try{
                    
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

                ProdutoDAO.inserir(produto);
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroSucess.jsp");
                requestDispatcher.forward(request, response);
                        
                } catch (ClassNotFoundException | IllegalArgumentException | SQLException e) {
                    System.out.println("Erro" + e);
                    
                    request.setAttribute("msg", e);
                    requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroDanger.jsp");
                    requestDispatcher.forward(request, response);
                }    
                    
                break; 
                case "/exibirProduto":
                    
                    try{
                        System.out.println("Entrei servlet Produto");
                        ProdutoDAO daoProduto = new ProdutoDAO();
                        
                        String nomePesquisaProduto = request.getParameter("Nome");
                        List<ProdutoModel> produtos;
                        HttpSession sessao = request.getSession();
                       
                        
                        if(nomePesquisaProduto != null){
                            produtos = daoProduto.procurar(nomePesquisaProduto);
                            request.setAttribute("pesquisa", produtos);
                            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listaProduto.jsp").forward(request, response);
                            
                        }else if(nomePesquisaProduto.equals("")){
                            
                        }
                        
                        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listaProduto.jsp").forward(request, response);
                        
                    }catch(SQLException | ServletException | IOException e){
                        System.out.println("Erro -> " + e);
                    } catch (Exception ex) {
                        Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                break;        
            }
    }

}
