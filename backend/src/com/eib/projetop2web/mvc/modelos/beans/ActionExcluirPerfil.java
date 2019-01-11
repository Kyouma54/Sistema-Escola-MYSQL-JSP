package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Perfil;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionExcluirPerfil implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPerfil = request.getParameter("id");
		String url = "frmListarPerfil.jsp?msg=Não pode ser excluido!";
		
		Perfil p1 = new Perfil();
		p1.setIdPerfil(Integer.parseInt(idPerfil));
		
		int r = p1.excluir();
		
		if(r==1) {
			url="frmListarPerfil.jsp?msg=Perfil excluido com sucesso!";
		}
		
		response.sendRedirect(url);
	}

}
