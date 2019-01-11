package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Usuario;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionCriarUsuario implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPerfil = request.getParameter("idPerfil");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = "frmCriarUsuario.jsp?msg=Não pode ser criado!";
		
		Usuario u1 = new Usuario();
		u1.setId_perfil(Integer.parseInt(idPerfil));
		u1.setLogin(login);
		u1.setSenha(senha);
		
		int r = u1.criar();
		
		if(r==1) {
			url = "frmCriarUsuario.jsp?msg=Usuario criado com sucesso!";
		}
		
		response.sendRedirect(url);

	}

}
