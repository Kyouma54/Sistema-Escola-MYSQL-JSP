package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Perfil;

public class Demo_criar_perfil {
	
	public static void main(String[] args) {
		String msg  = "perfil nao criado...";
		
		Perfil o = new Perfil();
		o.setTitulo("admexcluir");
		int r  = o.criar();
		
		if (r != 0) {
			msg = "Perfil criado"; 
		}
		
		System.out.println(msg);
	}
}
