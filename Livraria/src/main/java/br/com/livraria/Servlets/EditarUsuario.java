/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.Servlets;

import br.com.livraria.DAOs.FilialDAO;
import br.com.livraria.DAOs.FuncionarioDAO;
import br.com.livraria.Models.CargoModel;
import br.com.livraria.Models.FilialModel;
import br.com.livraria.Models.FuncionarioModel;
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

/**
 *
 * @author jose__000
 */
@WebServlet(name = "EditarUsuario", urlPatterns = {"/EditarUsuario"})
public class EditarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idFunc = Integer.parseInt(request.getParameter("idUsuario"));

        FuncionarioModel usuario = null;
        try {
            usuario = FuncionarioDAO.obter(idFunc);
        } catch (Exception ex) {
            Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        request.setAttribute("usuarioEditar", usuario);
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastrarUsuario.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}