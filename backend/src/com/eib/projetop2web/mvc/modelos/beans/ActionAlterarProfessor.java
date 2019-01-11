package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Professor;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionAlterarProfessor implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProfessor = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String ativo = request.getParameter("ativo");
		String url = "frmListarProfessor.jsp?msg=Não pode ser alterado!";
		Professor o1 = new Professor();
		o1.setId_professor(Integer.parseInt(idProfessor));
		o1.setNome(nome);
		o1.setEmail(email);
		o1.setAtivo(ativo == null ? false : true);

		int r = o1.alterar();

		if (r == 1) {
			url = "frmListarProfessor.jsp?msg=Alterado com sucesso!";
		}

		response.sendRedirect(url);
	}

}
