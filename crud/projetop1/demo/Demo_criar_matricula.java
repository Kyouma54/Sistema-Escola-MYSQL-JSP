package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Matricula;

public class Demo_criar_matricula {
	
	public static void main(String[] args) {
		String msg  = "Matricula nao criado...";
		
		Matricula m1 = new Matricula();
		m1.setId_cliente(2);
		m1.setId_turma(4);
		
		int r = m1.criar();
		
		if (r != 0) {
			msg = "Matricula criado"; 
		}
		
		System.out.println(msg);
	}
}
