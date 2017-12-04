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
@WebServlet(name = "Produto", urlPatterns = {"/cadastrarProduto"})
public class Produto extends HttpServlet {
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher requestDispatcher;

            if(!request.getParameter("idProduto").isEmpty()){
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));

                ProdutoModel produto = null;
                try{
                    produto = ProdutoDAO.obter(idProduto);

                }catch(Exception e){
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
                }

                request.setAttribute("produto", produto);

                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastrarProduto.jsp");
                requestDispatcher.forward(request, response);

            }
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // pego a url chamada pelo menuPrincipal
        String destino = request.getServletPath();
        RequestDispatcher requestDispatcher;
        
        ProdutoDAO daoProduto = new ProdutoDAO();
        List<ProdutoModel> produtos;
        ProdutoModel produto;
        
        //if(request.getParameter("idProduto").isEmpty()){
            System.out.println("Vou inserir");
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

            }catch(ClassNotFoundException | IllegalArgumentException | SQLException e) {
            System.out.println("Erro" + e);

            request.setAttribute("msg", e);
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroDanger.jsp");
            requestDispatcher.forward(request, response);

            } catch (Exception ex) {    
                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }    

        /*
            }else{
            System.out.println("Vou atualizar");
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

                produto.setId(Integer.parseInt(request.getParameter("idProduto")));

                ProdutoDAO.atualizar(produto);

                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroSucess.jsp");
                requestDispatcher.forward(request, response);

            }catch (ClassNotFoundException | IllegalArgumentException | SQLException e) {
                System.out.println("Erro" + e);

                request.setAttribute("msg", e);
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroDanger.jsp");
                requestDispatcher.forward(request, response);

            } catch (Exception ex) {    
                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
        }
                /*    
                if(request.getParameter("idProduto").isEmpty()){
                    System.out.println("Nao teve id");
                }else{    
                    
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
                }
                break;
                
                /*
                case "/editarProduto":
                    if(request.getParameter("idProduto").isEmpty()){
                        System.out.println("Vou inserir");
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
                        
                        }catch(ClassNotFoundException | IllegalArgumentException | SQLException e) {
                        System.out.println("Erro" + e);

                        request.setAttribute("msg", e);
                        requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroDanger.jsp");
                        requestDispatcher.forward(request, response);

                        } catch (Exception ex) {    
                            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }    
                            
                    }else{
                        System.out.println("Vou atualizar");
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
                        
                        produto.setId(Integer.parseInt(request.getParameter("idProduto")));
                        
                        ProdutoDAO.atualizar(produto);
                        
                        requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroSucess.jsp");
                        requestDispatcher.forward(request, response);
                        
                        }catch (ClassNotFoundException | IllegalArgumentException | SQLException e) {
                            System.out.println("Erro" + e);

                            request.setAttribute("msg", e);
                            requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroDanger.jsp");
                            requestDispatcher.forward(request, response);

                        } catch (Exception ex) {    
                            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                    break;
                    */    
    }
        





