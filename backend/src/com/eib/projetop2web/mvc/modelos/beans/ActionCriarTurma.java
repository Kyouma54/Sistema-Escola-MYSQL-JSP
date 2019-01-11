package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Turma;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionCriarTurma implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProfessor = request.getParameter("idProfessor");
		String idCurso = request.getParameter("idCurso");
		String qtdhoras = request.getParameter("qtdhoras");
		String datainicio = request.getParameter("datainicio");
		String datafim = request.getParameter("datafim");
		String url = "frmCriarTurma.jsp?msg=Não pode ser criada!";

		Turma t1 = new Turma();
		t1.setId_professor(Integer.parseInt(idProfessor));
		t1.setId_curso(Integer.parseInt(idCurso));
		t1.setQant_horas(Integer.parseInt(qtdhoras));
		t1.setDt_inicio(datainicio);
		t1.setDt_fim(datafim);
		
		int r = t1.criar();
		
		if(r==1) {
			url = "frmCriarTurma.jsp?msg=Turma criada com sucesso!";
		}
		
		response.sendRedirect(url);
		

	}

}
