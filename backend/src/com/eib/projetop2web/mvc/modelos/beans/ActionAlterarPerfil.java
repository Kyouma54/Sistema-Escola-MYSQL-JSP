package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Perfil;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionAlterarPerfil implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPerfil = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String ativo = request.getParameter("ativo");
		String url = "frmListarPerfil.jsp?msg=Não pode ser alterado!";
		
		Perfil p1 = new Perfil();
		p1.setIdPerfil(Integer.parseInt(idPerfil));
		p1.setTitulo(titulo);
		p1.setAtivo(ativo == null ? false : true);
		
		int r = p1.alterar();
		
		if(r==1) {
			url = "frmListarPerfil.jsp?msg=Alterado com sucesso!";
		}
		
		response.sendRedirect(url);

	}

}
