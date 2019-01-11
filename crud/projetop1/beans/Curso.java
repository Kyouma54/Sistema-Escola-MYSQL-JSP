package com.eib.projetop1.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.eib.projetop1.persistencia.DataBaseSuporte;
import com.eib.projetop1.persistencia.IPersistencia;

public class Curso implements IPersistencia<Curso> {
    private int id_curso = 0;
    private String titulo = null;
    private String descricao = null;
    private boolean ativo = false;
    private String cadastro = null;
    
	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
				"insert into tab_curso (titulo, descricao) values (?,?);",
				this.titulo,
				this.descricao
				);
		return r;
	}

	@Override
	public int excluir() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate(
				"delete from tab_curso where id_curso = ?;",
				this.id_curso
				);
		return r;
	}

	@Override
	public int alterar() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate(
				"update tab_curso set titulo = ?, descricao = ?, ativo=? where id_curso = ?;",
				this.titulo,
				this.descricao,
				this.ativo,
				this.id_curso
				);
		return r;
	}

	@Override
	public Curso buscar() {
		ResultSet rs = DataBaseSuporte.executeQuery(
				"select * from tab_curso where id_curso = ?;",
				this.id_curso
				);
		if(rs!=null) {
			try {
				if(rs.next()==true) {
					this.titulo = rs.getString("titulo");
					this.cadastro = rs.getString("cadastro");
					this.descricao = rs.getString("descricao");
					this.id_curso = rs.getInt("id_curso");
					this.ativo = rs.getBoolean("ativo");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return this;
	}

	@Override
	public Collection<Curso> buscarTodos() {
		Collection<Curso> list = new ArrayList<Curso>();
		ResultSet rs = DataBaseSuporte.executeQuery(
				"select * from tab_curso"
				);
		if(rs!=null) {
			try {
				while(rs.next()==true) {
					Curso c1 = new Curso();
					c1.titulo = rs.getString("titulo");
					c1.descricao = rs.getString("descricao");
					c1.cadastro = rs.getString("cadastro");
					c1.ativo = rs.getBoolean("ativo");
					c1.id_curso = rs.getInt("id_curso");
					list.add(c1);
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
		builder.append("Curso [id_curso=");
		builder.append(id_curso);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", ativo=");
		builder.append(ativo);
		builder.append(", cadastro=");
		builder.append(cadastro);
		builder.append("]");
		return builder.toString();
	}

}
