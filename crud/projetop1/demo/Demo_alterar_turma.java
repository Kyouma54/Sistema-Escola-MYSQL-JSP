package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Turma;

public class Demo_alterar_turma {

	public static void main(String[] args) {
		String msg  = "Turma nao alterado...";
		
		Turma t1 = new Turma();
		t1.setQant_horas(5555);
		t1.setDt_inicio("9999/01/01");
		t1.setDt_fim("9999/01/01");
		t1.setId_professor(2);
		t1.setId_curso(1);
		t1.setId_turma(5);
		
		int r  = t1.alterar();
		
		if (r != 0) {
			msg = "Turma alterado"; 
		}
		
		System.out.println(msg);
	}

}
