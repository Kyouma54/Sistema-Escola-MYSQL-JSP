package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Curso;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionExcluirCurso implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCurso = request.getParameter("id");
		String url = "frmListarCurso.jsp?msg=Não pode ser excluido!";
		
		Curso c1 = new Curso();
		c1.setId_curso(Integer.parseInt(idCurso));
		int r = c1.excluir();
		
		if(r==1) {
			url = "frmListarCurso.jsp?msg=Curso Excluido com sucesso!";
		}
		
		response.sendRedirect(url);

	}

}
