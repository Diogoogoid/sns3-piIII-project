/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livraria.Servlets;

import br.com.livraria.Models.CargoModel;
import br.com.livraria.Models.FuncionarioModel;
import br.com.livraria.Models.SetorModel;
import br.com.livraria.Services.CadastraUsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // criar a seção para gravar o usuario
        HttpSession sessao = request.getSession(); 
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        
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

        request.setAttribute("cargos", listaCargos);
        
        request.getRequestDispatcher("WEB-INF/jsp/cadastrarUsuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FuncionarioModel user = new FuncionarioModel();
        user.setNome(request.getParameter("Nome"));
        user.setCpf(request.getParameter("cpf"));
        SimpleDateFormat format = new SimpleDateFormat();
        Date date = null;
        try {
            date = (Date) format.parse(request.getParameter("dtnasc"));
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        user.setDataNasc((java.sql.Date) date);
        user.setSexo(request.getParameter("sexo"));
        user.setCep(request.getParameter("cep"));
        user.setLogradouro(request.getParameter("rua"));
        user.setNumero(request.getParameter("numero"));
        user.setBairro(request.getParameter("bairro"));
        user.setCidade(request.getParameter("cidade"));
        user.setEstado(request.getParameter("estado"));
        user.setEstadoCivil(request.getParameter("EstadoCivil"));
        user.setLogin(request.getParameter("login"));
        user.setSenha(request.getParameter("password"));
        //user.setIdCargo((int)request.getParameter("Departamento"));
    }
}