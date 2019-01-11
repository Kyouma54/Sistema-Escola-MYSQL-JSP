package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Curso;

public class Demo_alterar_curso {

	public static void main(String[] args) {
		String msg  = "Curso nao alterado...";
		
		Curso c1 = new Curso();
		c1.setTitulo("testeAlterado");
		c1.setDescricao("descricaoAlterada");
		c1.setId_curso(2);
		
		int r  = c1.alterar();
		
		if (r != 0) {
			msg = "Curso alterado"; 
		}
		
		System.out.println(msg);
	}

}
