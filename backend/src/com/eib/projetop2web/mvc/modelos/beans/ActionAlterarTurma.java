package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Turma;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionAlterarTurma implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idTurma = request.getParameter("id");
		String qtdHoras = request.getParameter("qtdhoras");
		String dataInicio = request.getParameter("datainicio");
		String dataFim = request.getParameter("datafim");
		String idCurso = request.getParameter("idCurso");
		String ativa = request.getParameter("ativo");
		String idProfessor = request.getParameter("idProfessor");
		String url = "frmListarTurma.jsp?msg=Não pode ser alterado!";
		
		Turma t1 = new Turma();
		
		t1.setId_turma(Integer.parseInt(idTurma));
		t1.setQant_horas(Integer.parseInt(qtdHoras));
		t1.setDt_inicio(dataInicio);
		t1.setDt_fim(dataFim);
		t1.setId_curso(Integer.parseInt(idCurso));
		t1.setId_professor(Integer.parseInt(idProfessor));
		t1.setAtivo(ativa == null ? false : true);
		
		int r = t1.alterar();
		
		if(r==1) {
			url = "frmListarTurma.jsp?msg=Alterado com sucesso!";
		}
		
		response.sendRedirect(url);
	}

}
