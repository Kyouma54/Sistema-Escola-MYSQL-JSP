package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Turma;


public class Demo_buscar_um_turma {

	public static void main(String[] args) {
        Turma t1 = new Turma();
		t1.setId_turma(4);
		
		System.out.println(t1.buscar());
		
	}
}

