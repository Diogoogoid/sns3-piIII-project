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
@WebServlet(name = "Produto", urlPatterns = {"/cadastrarProduto","/exibirProduto","/listarTodosProdutos"})
public class Produto extends HttpServlet {
   
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         
        // pego a url chamada pelo menuPrincipal
        String destino = request.getServletPath();
        RequestDispatcher requestDispatcher;
        
        ProdutoDAO daoProduto = new ProdutoDAO();
        List<ProdutoModel> produtos;
        ProdutoModel produto;
        
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

                produto = new ProdutoModel(
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
                     System.out.println("entrei exibir Produto");
                    try{
                        
                        String nomePesquisaProduto = request.getParameter("Nome");
                        
                        if(!nomePesquisaProduto.isEmpty()){
                            produtos = daoProduto.procurar(nomePesquisaProduto);
                            request.setAttribute("pesquisa", produtos);
                            
                        }else{
                            request.setAttribute("msgErroBusca", "Sua busca não gerou resultados!");
                                   
                        }
                        
                        request.getRequestDispatcher("/WEB-INF/jsp/listarProduto.jsp").forward(request, response);
                        
                    }catch(SQLException | ServletException | IOException e){
                        System.out.println("Erro -> " + e);
                    } catch (Exception ex) {
                        Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;   
                case "/listarTodosProdutos":
                    
                    try {

                        produtos = ProdutoDAO.listar();
                         
                        if(produtos != null){
                            request.setAttribute("pesquisa", produtos);
                            
                        }else{
                            request.setAttribute("msgErroBusca", "Sua busca no gerou resuldato");
                            
                        }
                        
                        request.getRequestDispatcher("/WEB-INF/jsp/listarProduto.jsp").forward(request, response);
                        
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
