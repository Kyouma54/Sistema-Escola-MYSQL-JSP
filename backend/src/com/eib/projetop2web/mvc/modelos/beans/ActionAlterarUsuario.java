package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Usuario;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionAlterarUsuario implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idUsuario = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String ativo = request.getParameter("ativo");
		String idPerfil = request.getParameter("idPerfil");
		String url = "frmListarUsuario.jsp?msg=Não pode ser alterado!";
		
		Usuario u1 = new Usuario();
		u1.setId_usuario(Integer.parseInt(idUsuario));
		u1.setLogin(login);
		u1.setSenha(senha);
		u1.setAtivo(ativo == null ? false : true);
		u1.setId_perfil(Integer.parseInt(idPerfil));
		
		int r = u1.alterar();
		
		if(r==1) {
			url = "frmListarUsuario.jsp?msg=Alterado com sucesso!";
		}
		
		response.sendRedirect(url);

	}

}
