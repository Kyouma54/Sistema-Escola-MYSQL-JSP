package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Matricula;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionAlterarMatricula implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCliente = request.getParameter("id");
		String idTurma = request.getParameter("idTurma");
		String ativo = request.getParameter("ativo");
		String url = "frmListarMatricula.jsp?msg=Não pode ser alterado!";
		
		Matricula m1 = new Matricula();
		m1.setId_cliente(Integer.parseInt(idCliente));
		m1.setId_turma(Integer.parseInt(idTurma));
		m1.setAtivo(ativo == null ? false : true);
		
		int r = m1.alterar();
		
		if(r==1) {
			url = "frmListarMatricula.jsp?msg=Alterado com sucesso!";
		}
		
		response.sendRedirect(url);
	}

}
