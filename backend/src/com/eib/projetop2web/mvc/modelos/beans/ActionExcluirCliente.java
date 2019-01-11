package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Cliente;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionExcluirCliente implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCliente = request.getParameter("id");
		String url = "frmListarCliente.jsp?msg=Não pode ser excluido!";
		
		Cliente c1 = new Cliente();
		c1.setId_cliente(Integer.parseInt(idCliente));
		
		int r = c1.excluir();
		
		if(r==1) {
			url = "frmListarCliente.jsp?msg=Cliente excluido com sucesso!";
		}
		
		response.sendRedirect(url);

	}

}
