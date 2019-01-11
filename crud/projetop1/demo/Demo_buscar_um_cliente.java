package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Cliente;


public class Demo_buscar_um_cliente {

	public static void main(String[] args) {
        Cliente c1 = new Cliente();
		c1.setId_cliente(1);

		System.out.println(c1.buscar());
	
	}
}

