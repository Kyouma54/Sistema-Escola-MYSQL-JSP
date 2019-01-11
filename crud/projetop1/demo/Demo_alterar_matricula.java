package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Matricula;

public class Demo_alterar_matricula {

	public static void main(String[] args) {
		String msg  = "Matricula nao alterado...";
		
		Matricula m1 = new Matricula();
		m1.setId_turma(7);
		m1.setId_cliente(2);
		
		int r  = m1.alterar();
		
		if (r != 0) {
			msg = "Matricula alterado"; 
		}
		
		System.out.println(msg);
	}

}
