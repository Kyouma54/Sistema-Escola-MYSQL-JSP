package com.eib.projetop1.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.eib.projetop1.persistencia.DataBaseSuporte;
import com.eib.projetop1.persistencia.IPersistencia;

public class Perfil implements IPersistencia<Perfil> {
	
	private int idPerfil = 0;
	private String titulo = null;
	private boolean ativo = false;
	private String cadastro = null;
	
	public Perfil() {
	}
	
	
	public int getIdPerfil() {
		return idPerfil;
	}


	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public String getCadastro() {
		return cadastro;
	}


	public void setCadastro(String cadastro) {
		this.cadastro = cadastro;
	}


	@Override
	public int criar() {
		int r = 0;
		
		r = DataBaseSuporte.executeUpdate(
				"insert into tab_perfil (titulo) values(?);",
				this.titulo
				);
		
		return r;
	}

	@Override
	public int excluir() {
		int r = 0;
		
		r = DataBaseSuporte.executeUpdate(
				"delete from tab_perfil where id_perfil = ? ;", 
				this.idPerfil
		);
		
		return r;
	}

	@Override
	public int alterar() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate(
				"update tab_perfil set titulo = ?, ativo = ? where id_perfil = ? ;", 
				this.titulo,
				this.ativo,
				this.idPerfil
				);
		
		return r;
	}

	@Override
	public Perfil buscar() {
		
		ResultSet r = DataBaseSuporte.executeQuery(
			"select * from tab_perfil where id_perfil = ?",
			this.idPerfil
			);
		
		if(r != null) {
			try {
				if(r.next() == true) {
					this.titulo = r.getString("titulo");
					this.cadastro = r.getString("cadastro");
					this.ativo = r.getBoolean("ativo");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return this;
	}

	@Override
	public Collection<Perfil> buscarTodos() {
		
		Collection<Perfil> list = new ArrayList<Perfil>();
		
		ResultSet r = DataBaseSuporte.executeQuery(
				"select * from tab_perfil"
				);
			
			if(r != null) {
				try {
					while(r.next() == true) {
						Perfil o = new Perfil();
						o.idPerfil = r.getInt("id_perfil");
						o.titulo = r.getString("titulo");
						o.cadastro = r.getString("cadastro");
						o.ativo = r.getBoolean("ativo");
						
						list.add(o);
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			return list;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Perfil [idPerfil=");
		builder.append(idPerfil);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", ativo=");
		builder.append(ativo);
		builder.append(", cadastro=");
		builder.append(cadastro);
		builder.append("]");
		return builder.toString();
	}
	
	

}
