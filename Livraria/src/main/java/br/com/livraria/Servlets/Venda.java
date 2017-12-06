/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.Servlets;

import br.com.livraria.DAOs.ClienteDAO;
import br.com.livraria.DAOs.ProdutoDAO;
import br.com.livraria.Models.ClienteModel;
import br.com.livraria.Models.ItemPedidoModel;
import br.com.livraria.Models.PedidoModel;
import br.com.livraria.Models.ProdutoModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bruno.almeida
 */
@WebServlet(name = "Venda", urlPatterns = {"/Venda"})
public class Venda extends HttpServlet {
    
    boolean flag = true;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(flag) {
            if(!request.getParameter("idCliente").isEmpty()) {
                ClienteModel cliente = null;
                try {
                    cliente = ClienteDAO.obter(Integer.parseInt(request.getParameter("idCliente")));
                } catch (Exception ex) {
                    Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
                }

                PedidoModel pedido = new PedidoModel();
                pedido.setCliente(cliente);

                HttpSession sessao = request.getSession();
                sessao.setAttribute("pedido", pedido);
                
                flag = false;
            }
        }

        RequestDispatcher requestDispatcher;

        List<ProdutoModel> listaProduto = null;
        try {
            listaProduto = ProdutoDAO.listar();
        } catch (Exception e) {
            Logger.getLogger(Rotas.class.getName()).log(Level.SEVERE, null, e);
        }

        request.setAttribute("produtos", listaProduto);
        requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/venda.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProduto = Integer.parseInt(request.getParameter("produto"));
        int qtd = Integer.parseInt(request.getParameter("qtd"));
        
        ProdutoModel produto = null;
        try {
            produto = ProdutoDAO.obter(idProduto);
        } catch (Exception ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ItemPedidoModel item = new ItemPedidoModel();
        item.setProduto(produto);
        item.setQtd(qtd);
        item.setValorParcial(qtd*produto.getValorProduto());
        

        
        HttpSession sessao = request.getSession();
        PedidoModel pedido = (PedidoModel)sessao.getAttribute("pedido");
        pedido.setItem(item);
        float valorTotal = 0;
        for(int i = 0; i < pedido.getItens().size(); i++) {
            valorTotal += pedido.getItens().get(i).getValorParcial();
        }
        
        pedido.setValorTotal(valorTotal);
        
        sessao.removeAttribute("pedido");
        sessao.setAttribute("pedido", pedido);
        
        doGet(request, response);
    }
}