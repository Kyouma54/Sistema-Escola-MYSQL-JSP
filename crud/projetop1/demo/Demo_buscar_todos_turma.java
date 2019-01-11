package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Turma;


public class Demo_buscar_todos_turma {

	public static void main(String[] args) {
		Turma t1 = new Turma();
		
		Collection<Turma> list = t1.buscarTodos();
		
		for (Turma t : list) {
			System.out.println(t);
		}

	}

}
