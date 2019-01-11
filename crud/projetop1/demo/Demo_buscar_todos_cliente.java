package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Cliente;


public class Demo_buscar_todos_cliente {

	public static void main(String[] args) {
		Cliente c1 = new Cliente();
		
		Collection<Cliente> list = c1.buscarTodos();
		
		for (Cliente c : list) {
			System.out.println(c);
		}

	}

}
