package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Perfil;

public class Demo_buscar_todos_perfil {

	public static void main(String[] args) {
		Perfil p  = new Perfil();
		
		Collection<Perfil> list = p.buscarTodos();
		
		for (Perfil item : list) {
			System.out.println(item);
		}

	}

}
