package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Professor;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionCriarProfessor implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String url = "frmCriarProfessor.jsp?msg=Não pode ser criado!";
		
		Professor o1 = new Professor();
		o1.setNome(nome);
		o1.setEmail(email);
		
		int r = o1.criar();
		
		if( r == 1){
		    url = "frmCriarProfessor.jsp?msg=Professor criado com sucesso!";
		}
		
		response.sendRedirect(url);

	}

}
