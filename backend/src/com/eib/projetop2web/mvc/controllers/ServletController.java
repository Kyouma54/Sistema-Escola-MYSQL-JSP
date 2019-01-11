package com.eib.projetop2web.mvc.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eib.projetop2web.mvc.modelos.beans.ActionAlterarCliente;
import com.eib.projetop2web.mvc.modelos.beans.ActionAlterarCurso;
import com.eib.projetop2web.mvc.modelos.beans.ActionAlterarMatricula;
import com.eib.projetop2web.mvc.modelos.beans.ActionAlterarPerfil;
import com.eib.projetop2web.mvc.modelos.beans.ActionAlterarProfessor;
import com.eib.projetop2web.mvc.modelos.beans.ActionAlterarTurma;
import com.eib.projetop2web.mvc.modelos.beans.ActionAlterarUsuario;
import com.eib.projetop2web.mvc.modelos.beans.ActionAutenticar;
import com.eib.projetop2web.mvc.modelos.beans.ActionCriarCliente;
import com.eib.projetop2web.mvc.modelos.beans.ActionCriarCurso;
import com.eib.projetop2web.mvc.modelos.beans.ActionCriarMatricula;
import com.eib.projetop2web.mvc.modelos.beans.ActionCriarPerfil;
import com.eib.projetop2web.mvc.modelos.beans.ActionCriarProfessor;
import com.eib.projetop2web.mvc.modelos.beans.ActionCriarTurma;
import com.eib.projetop2web.mvc.modelos.beans.ActionCriarUsuario;
import com.eib.projetop2web.mvc.modelos.beans.ActionExcluirCliente;
import com.eib.projetop2web.mvc.modelos.beans.ActionExcluirCurso;
import com.eib.projetop2web.mvc.modelos.beans.ActionExcluirMatricula;
import com.eib.projetop2web.mvc.modelos.beans.ActionExcluirPerfil;
import com.eib.projetop2web.mvc.modelos.beans.ActionExcluirProfessor;
import com.eib.projetop2web.mvc.modelos.beans.ActionExcluirTurma;
import com.eib.projetop2web.mvc.modelos.beans.ActionExcluirUsuario;
import com.eib.projetop2web.mvc.modelos.beans.ActionLogout;

@WebServlet("/controller.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String,ICommandController> map = null;
    
    public ServletController(){
    	map = new HashMap<String,ICommandController>();
    	map.put("login",new ActionAutenticar());
    	map.put("logout",new ActionLogout());
    	
    	map.put("criarProfessor",new ActionCriarProfessor());
    	map.put("criarPerfil", new ActionCriarPerfil());
    	map.put("criarCurso", new ActionCriarCurso());
    	map.put("criarCliente", new ActionCriarCliente());
    	map.put("criarTurma", new ActionCriarTurma());
    	map.put("criarMatricula", new ActionCriarMatricula());
    	map.put("criarUsuario", new ActionCriarUsuario());
    	
    	map.put("excluirProfessor",new ActionExcluirProfessor());
    	map.put("excluirCurso", new ActionExcluirCurso());
    	map.put("excluirPerfil", new ActionExcluirPerfil());
    	map.put("excluirCliente", new ActionExcluirCliente());
    	map.put("excluirUsuario", new ActionExcluirUsuario());
    	map.put("excluirMatricula", new ActionExcluirMatricula());
    	map.put("excluirTurma", new ActionExcluirTurma());
    	
    	map.put("alterarProfessor",new ActionAlterarProfessor());
    	map.put("alterarCurso", new ActionAlterarCurso());
    	map.put("alterarPerfil", new ActionAlterarPerfil());
    	map.put("alterarCliente", new ActionAlterarCliente());
    	map.put("alterarTurma", new ActionAlterarTurma());
    	map.put("alterarUsuario", new ActionAlterarUsuario());
    	map.put("alterarMatricula", new ActionAlterarMatricula());
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comando = request.getParameter("command");
		String msg = "Temtativa de input direwto";
		
		PrintWriter out = response.getWriter();
		
		ICommandController cmm = map.get(comando);
		
		if(cmm instanceof ICommandController) {
			cmm.execute(request, response);
		}
		else {
		   out.println(msg);
		}
	}
}
