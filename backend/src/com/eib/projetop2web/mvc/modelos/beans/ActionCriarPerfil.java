package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Perfil;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionCriarPerfil implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String url = "frmCriarPerfil.jsp?msg=Não pode ser criado!";
		
		Perfil p1 = new Perfil();
		p1.setTitulo(titulo);
		int r = p1.criar();
		
		if(r==1) {
			url="frmCriarPerfil.jsp?msg=Perfil criado com sucesso!";
		}
		
		response.sendRedirect(url);
	}

}
