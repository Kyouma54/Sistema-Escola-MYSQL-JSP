package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Professor;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionExcluirProfessor implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProfessor = request.getParameter("id");
		
		String url = "frmListarProfessor.jsp?msg=";
		
		Professor o1 = new Professor();
		o1.setId_professor(Integer.parseInt(idProfessor));
	
		
		int r = o1.excluir();
		
		if( r == 1){
		    url += "Professor excluido com sucesso!&codErro=1";
		}
		else {
			  url += "Professor não pode ser excluido!&codErro=0";
		}
		
		response.sendRedirect(url);
		
		
	}
}
