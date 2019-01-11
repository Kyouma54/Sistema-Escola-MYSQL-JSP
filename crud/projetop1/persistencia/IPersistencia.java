package com.eib.projetop1.persistencia;

import java.util.Collection;
import java.util.Collections;

public abstract interface IPersistencia<T> {
	public abstract int criar();
	public abstract int excluir();
	public abstract int alterar();
	public abstract T buscar();
	public abstract Collection<T> buscarTodos();
}

