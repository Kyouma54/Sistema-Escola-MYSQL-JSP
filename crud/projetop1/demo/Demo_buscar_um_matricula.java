package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Matricula;

public class Demo_buscar_um_matricula {

	public static void main(String[] args) {
        Matricula m1 = new Matricula();
        m1.setId_cliente(1);
		
		System.out.println(m1.buscar());
		
	}


}

