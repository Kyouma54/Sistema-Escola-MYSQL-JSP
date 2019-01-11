package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Curso;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionCriarCurso implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String url = "frmCriarCurso.jsp?msg=Não pode ser criado!";
		
		Curso c1 = new Curso();
		c1.setTitulo(titulo);
		c1.setDescricao(descricao);
		
		int r = c1.criar();
		
		if(r==1) {
			url = "frmCriarCurso.jsp?msg=Curso criado com sucesso!";
		}
		
		response.sendRedirect(url);
	}

}
