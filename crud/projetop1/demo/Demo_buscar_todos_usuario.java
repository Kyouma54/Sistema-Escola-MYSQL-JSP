package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Usuario;

public class Demo_buscar_todos_usuario {

	public static void main(String[] args) {
		Usuario u1 = new Usuario();
		
		Collection<Usuario> list = u1.buscarTodos();
		
		for (Usuario u : list) {
			System.out.println(u);
		}

	}

}
