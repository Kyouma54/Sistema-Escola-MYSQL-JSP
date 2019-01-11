package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Usuario;

public class Demo_excluir_usuario {

	public static void main(String[] args) {
        String msg  = "Usuario nao excluido...";
		
		Usuario u1 = new Usuario();
		u1.setId_usuario(2);
		
		int r  = u1.excluir();
		
		if (r != 0) {
			msg = "Usuario excluido"; 
		}
		
		System.out.println(msg);

	}

}
