package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Curso;


public class Demo_buscar_todos_curso {

	public static void main(String[] args) {
		Curso c1 = new Curso();
		
		Collection<Curso> list = c1.buscarTodos();
		
		for (Curso c : list) {
			System.out.println(c);
		}

	}

}
