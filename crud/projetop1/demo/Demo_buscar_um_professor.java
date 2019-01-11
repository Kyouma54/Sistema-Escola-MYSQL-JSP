package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Professor;

public class Demo_buscar_um_professor {

	public static void main(String[] args) {
        Professor p1 = new Professor();
		p1.setId_professor(2);
		
		System.out.println(p1.buscar());	
	
	}


}

