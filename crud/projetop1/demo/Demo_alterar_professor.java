package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Professor;

public class Demo_alterar_professor {

	public static void main(String[] args) {
		String msg  = "Professor nao alterado...";
		
		Professor p1 = new Professor();
		p1.setNome("profAlterado");
		p1.setEmail("profalterado@teste.com");
		p1.setId_professor(3);
		
		int r = p1.alterar();
		
		if (r != 0) {
			msg = "Professor alterado"; 
		}
		
		System.out.println(msg);
	}

}
