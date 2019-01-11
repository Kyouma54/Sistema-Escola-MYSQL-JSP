package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Matricula;


public class Demo_buscar_todos_matricula {

	public static void main(String[] args) {
		Matricula m1 = new Matricula();
		
		Collection<Matricula> list = m1.buscarTodos();
		
		for (Matricula m : list) {
			System.out.println(m);
		}

	}

}
