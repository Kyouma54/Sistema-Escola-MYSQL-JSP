package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Curso;


public class Demo_buscar_um_curso {

	public static void main(String[] args) {
        Curso c1 = new Curso();
		c1.setId_curso(1);
		
		System.out.println(c1.buscar());

	}


}

