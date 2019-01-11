package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Curso;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionAlterarCurso implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCurso = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String ativo = request.getParameter("ativo");
		String url = "frmListarCurso.jsp?msg=Não pode ser alterado!";
		
		Curso c1 = new Curso();
		c1.setId_curso(Integer.parseInt(idCurso));
		c1.setTitulo(titulo);
		c1.setDescricao(descricao);
		c1.setAtivo(ativo == null ? false : true);
		
		int r = c1.alterar();
		
		if(r==1) {
			url = "frmListarCurso.jsp?msg=Alterado com sucesso!";
		}
		
		response.sendRedirect(url);
	}

}
