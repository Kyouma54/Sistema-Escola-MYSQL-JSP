package com.eib.projetop1.demo;

import java.util.Collection;

import com.eib.projetop1.beans.Usuario;

public class Demo_buscar_um_usuario {

	public static void main(String[] args) {
        Usuario u1 = new Usuario();
        
        u1.setId_perfil(4);
        System.out.println(u1.buscar());
        
	}

}

