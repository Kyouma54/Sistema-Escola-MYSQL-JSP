package com.eib.projetop2web.mvc.modelos.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop1.beans.Cliente;
import com.eib.projetop2web.mvc.controllers.ICommandController;

public class ActionAlterarCliente implements ICommandController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCliente = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String idade = request.getParameter("idade");
		String rg = request.getParameter("rg");
		String cpf = request.getParameter("cpf");
		String ativo = request.getParameter("ativo");
		String url = "frmListarCliente.jsp?msg=Não pode ser alterado!";
		
		Cliente c1 = new Cliente();
		c1.setId_cliente(Integer.parseInt(idCliente));
		c1.setNome(nome);
		c1.setEmail(email);
		c1.setIdade(Integer.parseInt(idade));
		c1.setRg(rg);
		c1.setCpf(cpf);
		c1.setAtivo(ativo == null ? false : true);
		
		int r = c1.alterar();
		
		if(r==1) {
			url = "frmListarCliente.jsp?msg=Alterado com sucesso!";
		}
		
		response.sendRedirect(url);
	}

}
