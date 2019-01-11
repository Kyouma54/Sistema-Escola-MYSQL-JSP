package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Perfil;

public class Demo_alterar_perfil {

	public static void main(String[] args) {
		String msg  = "Perfil nao alterado...";
		
		Perfil o = new Perfil();
		o.setTitulo("admAlterado");
		o.setAtivo(false);
		o.setIdPerfil(5);
		
		int r  = o.alterar();
		
		if (r != 0) {
			msg = "Perfil alterado"; 
		}
		
		System.out.println(msg);
	}

}
