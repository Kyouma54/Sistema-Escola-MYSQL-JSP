package com.eib.projetop1.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.eib.projetop1.persistencia.DataBaseSuporte;
import com.eib.projetop1.persistencia.IPersistencia;

public class Turma implements IPersistencia<Turma> {
	private int id_turma = 0;
	private int qant_horas = 0;
	private String dt_inicio = null;
	private String dt_fim = null;
	private boolean ativo = false;
	private String cadastro = null;
	private int id_professor = 0;
	private int id_curso = 0;
	private String nomeProfessor = null;
	private String tituloCurso = null;
	
	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getTituloCurso() {
		return tituloCurso;
	}

	public void setTituloCurso(String tituloCurso) {
		this.tituloCurso = tituloCurso;
	}

	public int getId_professor() {
		return id_professor;
	}

	public void setId_professor(int id_professor) {
		this.id_professor = id_professor;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public int getId_turma() {
		return id_turma;
	}

	public void setId_turma(int id_turma) {
		this.id_turma = id_turma;
	}

	public int getQant_horas() {
		return qant_horas;
	}

	public void setQant_horas(int qant_horas) {
		this.qant_horas = qant_horas;
	}

	public String getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(String dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public String getDt_fim() {
		return dt_fim;
	}

	public void setDt_fim(String dt_fim) {
		this.dt_fim = dt_fim;
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
				"insert into tab_turma (qant_horas, dt_inicio, dt_fim, id_professor, id_curso) "
				+ "values (?,?,?,?,?);",
				this.qant_horas, this.dt_inicio, this.dt_fim, this.id_professor, this.id_curso
				);
		return r;
	}

	@Override
	public int excluir() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate("delete from tab_turma where id_turma = ?;",
				this.id_turma
				);
		return r;
	}

	@Override
	public int alterar() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate("update tab_turma set qant_horas = ?, "
				+ "dt_inicio = ?, dt_fim = ?, id_professor = ?, id_curso = ?, ativa = ? where id_turma = ?", 
				this.qant_horas, this.dt_inicio, this.dt_fim, this.id_professor, this.id_curso,
				this.ativo, this.id_turma
				);
		return r;
	}

	@Override
	public Turma buscar() {
		ResultSet rs = DataBaseSuporte.executeQuery("select * from tab_turma where id_turma = ?;",
				this.id_turma);
		if(rs!=null) {
			try {
				if(rs.next()==true) {
					this.qant_horas = rs.getInt("qant_horas");
					this.dt_inicio =  rs.getString("dt_inicio");
					this.dt_fim =	rs.getString("dt_fim");
					this.id_professor =  rs.getInt("id_professor");
					this.id_curso = rs.getInt("id_curso");
					this.ativo = rs.getBoolean("ativa");
					this.cadastro = rs.getString("cadastro");
					this.id_turma = rs.getInt("id_turma");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return this;
	}

	@Override
	public Collection<Turma> buscarTodos() {
		Collection<Turma> list = new ArrayList<>();
		
		ResultSet rs = DataBaseSuporte.executeQuery("SELECT \r\n" + 
				"	tab_turma.id_turma,\r\n" + 
				"	tab_turma.qant_horas,\r\n" + 
				"    tab_turma.dt_inicio,\r\n" + 
				"    tab_turma.dt_fim,\r\n" + 
				"    tab_turma.ativa,\r\n" + 
				"    tab_turma.cadastro,\r\n" + 
				"    tab_professor.nome,\r\n" + 
				"    tab_curso.titulo\r\n" + 
				"FROM db_escola.tab_turma\r\n" + 
				"INNER JOIN tab_professor ON\r\n" + 
				"tab_turma.id_professor = tab_professor.id_professor\r\n" + 
				"INNER JOIN tab_curso ON\r\n" + 
				"tab_turma.id_curso = tab_curso.id_curso\r\n" + 
				";");
		
		if(rs!=null) {
			try {
				while(rs.next()==true) {
					Turma t1 = new Turma();
					t1.qant_horas = rs.getInt("qant_horas");
					t1.dt_inicio =  rs.getString("dt_inicio");
					t1.dt_fim =	rs.getString("dt_fim");
					t1.ativo = rs.getBoolean("ativa");
					t1.cadastro = rs.getString("cadastro");
					t1.id_turma = rs.getInt("id_turma");
					t1.nomeProfessor = rs.getString("nome");
					t1.tituloCurso = rs.getString("titulo");
					list.add(t1);
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
		builder.append("Turma [id_turma=");
		builder.append(id_turma);
		builder.append(", qant_horas=");
		builder.append(qant_horas);
		builder.append(", dt_inicio=");
		builder.append(dt_inicio);
		builder.append(", dt_fim=");
		builder.append(dt_fim);
		builder.append(", ativo=");
		builder.append(ativo);
		builder.append(", cadastro=");
		builder.append(cadastro);
		builder.append(", id_professor=");
		builder.append(id_professor);
		builder.append(", id_curso=");
		builder.append(id_curso);
		builder.append(", nomeProfessor=");
		builder.append(nomeProfessor);
		builder.append(", tituloCurso=");
		builder.append(tituloCurso);
		builder.append("]");
		return builder.toString();
	}
	
}
