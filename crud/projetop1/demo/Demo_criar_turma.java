package com.eib.projetop1.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.eib.projetop1.beans.Turma;

public class Demo_criar_turma {
	
	public static void main(String[] args) {
		String msg  = "Turma nao criado...";
		
		Turma t1 = new Turma();
		
		t1.setQant_horas(500);
		t1.setDt_inicio("9999/01/01");
		t1.setDt_fim("9999/01/01");
		t1.setId_professor(2);
		t1.setId_curso(1);
		
		int r  = t1.criar();
		
		if (r != 0) {
			msg = "Turma criada"; 
		}
		
		System.out.println(msg);
	}
}
