package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Matricula;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionExcluirMatricula implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCliente = request.getParameter("id");
		String url = "frmListarMatricula.jsp?msg=Não pode ser excluido!";
		
		Matricula m1 = new Matricula();
		m1.setId_cliente(Integer.parseInt(idCliente));
		
		int r = m1.excluir();
		
		if(r==1) {
			url = "frmListarMatricula.jsp?msg=Matricula excluida com sucesso!";
		}
		
		response.sendRedirect(url);

	}

}
