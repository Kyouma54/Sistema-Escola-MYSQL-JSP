package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Perfil;

public class Demo_buscar_um_perfil {

	public static void main(String[] args) {
        Perfil o  = new Perfil();
		o.setIdPerfil(4);
		o.buscar();
		
		System.out.println(o);
		
	
	}


}

