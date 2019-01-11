package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Professor;

public class Demo_criar_professor {
	
	public static void main(String[] args) {
		String msg  = "Professor nao criado...";
		
		Professor p1 = new Professor();
		p1.setNome("Prof2");
		p1.setEmail("prof2@teste.com");
		int r  = p1.criar();
		
		if (r != 0) {
			msg = "Professor criado"; 
		}
		
		System.out.println(msg);
	}
}
