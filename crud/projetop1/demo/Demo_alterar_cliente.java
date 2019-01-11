package com.eib.projetop1.demo;

import com.eib.projetop1.beans.Cliente;

public class Demo_alterar_cliente {

	public static void main(String[] args) {
		String msg  = "Cliente nao alterado...";
		
		Cliente c1 = new Cliente();
		c1.setNome("testeAlterado");
		c1.setEmail("testeAlterado@eib.com");
		c1.setCpf("999.999.999-99");
		c1.setRg("99999-99");
		c1.setIdade(20);
		c1.setId_cliente(2);
		
		int r  = c1.alterar();
		
		if (r != 0) {
			msg = "Cliente alterado"; 
		}
		
		System.out.println(msg);
	}

}
