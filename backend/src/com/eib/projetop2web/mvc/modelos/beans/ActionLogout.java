package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionLogout implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.removeAttribute("__user__");
		session.invalidate();
		
		response.sendRedirect("index.jsp?msg=Volte sempre!");
     
	}

}
