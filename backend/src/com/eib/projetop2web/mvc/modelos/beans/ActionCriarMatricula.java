package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Matricula;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionCriarMatricula implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idTurma = request.getParameter("idTurma");
		String idCliente = request.getParameter("idCliente");
		String url = "frmCriarMatricula.jsp?msg=Não pode ser criado!";
		
		Matricula m1 = new Matricula();
		m1.setId_cliente(Integer.parseInt(idCliente));
		m1.setId_turma(Integer.parseInt(idTurma));
		
		int r = m1.criar();
		
		if(r==1) {
			url = "frmCriarMatricula.jsp?msg=Matricula criada com sucesso!";
		}
		
		response.sendRedirect(url);
	}

}
