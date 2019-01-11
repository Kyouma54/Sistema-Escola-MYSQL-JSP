package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Professor;

public class Demo_excluir_professor {

	public static void main(String[] args) {
        String msg  = "Professor nao excluido...";
		
        Professor p1 = new Professor();
		p1.setId_professor(1);
        
		int r  = p1.excluir();
		
		if (r != 0) {
			msg = "Professor excluido"; 
		}
		
		System.out.println(msg);

	}

}
