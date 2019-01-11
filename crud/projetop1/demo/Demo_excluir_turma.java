package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Turma;

public class Demo_excluir_turma {

	public static void main(String[] args) {
        String msg  = "Turma nao excluido...";
		
		Turma t1 = new Turma();
		t1.setId_turma(5);
		
		int r  = t1.excluir();
		
		if (r != 0) {
			msg = "Turma excluido"; 
		}
		
		System.out.println(msg);

	}

}
