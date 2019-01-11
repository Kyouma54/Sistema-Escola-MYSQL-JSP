package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Usuario;

public class Demo_alterar_usuario {

	public static void main(String[] args) {
		String msg  = "Usuario nao alterado...";
		
		Usuario u1 = new Usuario();
		u1.setLogin("admAlterado");
		u1.setSenha("rootAlterado");
		u1.setAtivo(false);
		u1.setId_usuario(1);
		
		int r  = u1.alterar();
		
		if (r != 0) {
			msg = "Usuario alterado"; 
		}
		
		System.out.println(msg);
	}

}
