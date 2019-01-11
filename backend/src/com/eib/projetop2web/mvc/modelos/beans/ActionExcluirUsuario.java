package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Cliente;
import com.eib.projetop1.beans.Usuario;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionExcluirUsuario implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idUsuario = request.getParameter("id");
		String url = "frmListarUsuario.jsp?msg=Não pode ser excluido!";
		
		Usuario u1 = new Usuario();
		u1.setId_usuario(Integer.parseInt(idUsuario));
		
		int r = u1.excluir();
		
		if(r==1) {
			url = "frmListarUsuario.jsp?msg=Usuario excluido com sucesso!";
		}
		
		response.sendRedirect(url);

	}

}
