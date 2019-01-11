package com.eib.projetop1.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.eib.projetop1.persistencia.DataBaseSuporte;
import com.eib.projetop1.persistencia.IPersistencia;

public class Professor implements IPersistencia<Professor> {
	private int id_professor = 0;
	private String nome = null;
	private String email = null;
	private boolean ativo = false;
	private String cadastro = null;
	
	public Professor() {
	}
	
	public int getId_professor() {
		return id_professor;
	}

	public void setId_professor(int id_professor) {
		this.id_professor = id_professor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
				"insert into tab_professor (nome, email) values (?,?);",
				this.nome,
				this.email
				);
		
		return r;
	}

	@Override
	public int excluir() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate(
				"delete from tab_professor where id_professor = ?;",
				this.id_professor
							);
		
		return r;
	}

	@Override
	public int alterar() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate(
				"update tab_professor set nome = ?, email = ?, ativo = ? where id_professor = ?;",
				this.nome,
				this.email,
				this.ativo,
				this.id_professor
				);
		
		return r;
	}

	@Override
	public Professor buscar() {
		ResultSet rs = DataBaseSuporte.executeQuery(
				"select * from tab_professor where id_professor = ?;",
				this.id_professor
				);
		
		if(rs != null) {
			try {
				if(rs.next() ==  true) {
					this.nome = rs.getString("nome");
					this.email = rs.getString("email");
					this.id_professor = rs.getInt("id_professor");
					this.ativo = rs.getBoolean("ativo");
					this.cadastro = rs.getString("cadastro");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return this;
	}

	@Override
	public Collection<Professor> buscarTodos() {
		Collection<Professor> list = new ArrayList<Professor>();
		
		ResultSet rs = DataBaseSuporte.executeQuery(
				"select * from tab_professor"
				);
		
		if(rs != null) {
			try {
				while(rs.next() == true) {
					Professor prof = new Professor();
					prof.nome = rs.getString("nome");
					prof.email = rs.getString("email");
					prof.ativo = rs.getBoolean("ativo");
					prof.id_professor = rs.getInt("id_professor");
					prof.cadastro = rs.getString("cadastro");
					
					list.add(prof);
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
		builder.append("Professor [id_professor=");
		builder.append(id_professor);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", email=");
		builder.append(email);
		builder.append(", ativo=");
		builder.append(ativo);
		builder.append(", cadastro=");
		builder.append(cadastro);
		builder.append("]");
		return builder.toString();
	}
	
	

}
