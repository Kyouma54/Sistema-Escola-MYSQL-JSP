package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Perfil;

public class Demo_excluir_curso {

	public static void main(String[] args) {
        String msg  = "perfil nao excluido...";
		
		Perfil o = new Perfil();
		o.setIdPerfil(6);
		
		int r  = o.excluir();
		
		if (r != 0) {
			msg = "Perfil excluido"; 
		}
		
		System.out.println(msg);

	}

}
