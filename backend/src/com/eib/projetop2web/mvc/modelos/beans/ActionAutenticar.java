package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eib.projetop1.beans.Usuario;

import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionAutenticar implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = "index.jsp?msg=Login Incorreto!";
		Usuario o1 = new Usuario();
		Collection<Usuario> list = o1.buscarTodos();
		
		for (Usuario item : list) {
			if(item.getLogin().equals(login)){
				if(item.getSenha().equals(senha)){
					if(item.isAtivo() == true ){
					    HttpSession session = request.getSession();
					    item.setSenha(null);
					    session.setAttribute("__user__",item);
					    
					    url = "frmGerenciador.jsp";
					    
						break;
					}
				}
			}
		}
		
		response.sendRedirect(url);
		
		//PrintWriter out = response.getWriter();
		//out.println("AUTENTICAR");
	}

}
