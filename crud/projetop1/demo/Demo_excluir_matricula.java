package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Matricula;

public class Demo_excluir_matricula {

	public static void main(String[] args) {
        String msg  = "Matricula nao excluido...";
		
		Matricula m1 = new Matricula();
		m1.setId_cliente(2);
		
		int r  = m1.excluir();
		
		if (r != 0) {
			msg = "Matricula excluido"; 
		}
		
		System.out.println(msg);

	}

}
