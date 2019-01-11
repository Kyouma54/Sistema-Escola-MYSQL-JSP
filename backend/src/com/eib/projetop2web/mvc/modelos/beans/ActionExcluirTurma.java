package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Turma;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionExcluirTurma implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idTurma = request.getParameter("id");
		String url = "frmListarTurma.jsp?msg=Não pode ser excluido!";
		
		Turma t1 = new Turma();
		t1.setId_turma(Integer.parseInt(idTurma));
		
		int r = t1.excluir();
		
		if(r==1) {
			url = "frmListarTurma.jsp?msg=Turma excluida com sucesso!";
		}
		
		response.sendRedirect(url);
	}

}
