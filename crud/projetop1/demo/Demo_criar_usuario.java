package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Usuario;

public class Demo_criar_usuario {
	
	public static void main(String[] args) {
		String msg  = "usuario nao criado...";
		
		Usuario u1 = new Usuario();
		u1.setLogin("adm2");
		u1.setSenha("root2");
		u1.setId_perfil(5);
		
		int r = u1.criar();
		
		if (r != 0) {
			msg = "Usuario criado"; 
		}
		
		System.out.println(msg);
	}
}
