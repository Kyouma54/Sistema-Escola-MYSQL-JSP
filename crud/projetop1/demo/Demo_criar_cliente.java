package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Cliente;

public class Demo_criar_cliente {
	
	public static void main(String[] args) {
		String msg  = "Cliente nao criado...";
		
		Cliente c1 = new Cliente();
		c1.setNome("teste2");
		c1.setEmail("test2@eib.com");
		c1.setCpf("999.999.999-99");
		c1.setRg("99999-99");
		c1.setIdade(20);
		
		int r  = c1.criar();
		
		if (r != 0) {
			msg = "Cliente criado"; 
		}
		
		System.out.println(msg);
	}
}
