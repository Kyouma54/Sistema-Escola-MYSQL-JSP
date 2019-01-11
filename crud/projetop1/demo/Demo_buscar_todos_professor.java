package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Professor;


public class Demo_buscar_todos_professor {

	public static void main(String[] args) {
		Professor p1 = new Professor();
		
		Collection<Professor> list = p1.buscarTodos();
		
		for (Professor p : list) {
			System.out.println(p);
		}

	}

}
