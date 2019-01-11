package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Cliente;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionCriarCliente implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String idade = request.getParameter("idade");
		String rg = request.getParameter("rg");
		String cpf = request.getParameter("cpf");
		String url = "frmCriarCliente.jsp?msg=Não pode ser criado!";
		
		Cliente c1 = new Cliente();
		c1.setNome(nome);
		c1.setEmail(email);
		c1.setIdade(Integer.parseInt(idade));
		c1.setRg(rg);
		c1.setCpf(cpf);
		
		int r = c1.criar();
		
		if(r==1) {
			url = "frmCriarCliente.jsp?msg=Cliente criado com sucesso!";
		}
		
		response.sendRedirect(url);
	}

}
