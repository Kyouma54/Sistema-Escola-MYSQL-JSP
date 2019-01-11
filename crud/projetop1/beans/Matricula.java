package com.eib.projetop1.beans;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.eib.projetop1.persistencia.DataBaseSuporte;
import com.eib.projetop1.persistencia.IPersistencia;

public class Matricula implements IPersistencia<Matricula> {
	
	private int id_turma = 0;
	private int id_cliente = 0;
	private String cadastro = null;
	private Boolean ativo = false;
	private String nomeCliente = null;
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getId_turma() {
		return id_turma;
	}

	public void setId_turma(int id_turma) {
		this.id_turma = id_turma;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getCadastro() {
		return cadastro;
	}

	public void setCadastro(String cadastro) {
		this.cadastro = cadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int criar() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate("insert into tab_matricula (id_turma, id_cliente)"
				+ " values (?,?);",
				this.id_turma, this.id_cliente
				);
		return r;
	}

	@Override
	public int excluir() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate("delete from tab_matricula where id_cliente = ?",
				this.id_cliente
				);
		return r;
	}

	@Override
	public int alterar() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate("update tab_matricula set id_turma = ?, ativo = ?  "
				+ "where id_cliente = ?", this.id_turma, this.ativo, this.id_cliente
				);
		return r;
	}

	@Override
	public Matricula buscar() {
		ResultSet rs = DataBaseSuporte.executeQuery("select * from tab_matricula where id_cliente = ?",
				this.id_cliente);
		
		if(rs!=null) {
			try {
				if(rs.next()==true) {
					this.id_cliente = rs.getInt("id_cliente");
					this.id_turma = rs.getInt("id_turma");
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
	public Collection<Matricula> buscarTodos() {
		Collection<Matricula> list = new ArrayList<>();
		
		ResultSet rs = DataBaseSuporte.executeQuery("SELECT \r\n" + 
				"tab_matricula.id_cliente,\r\n" + 
				"tab_matricula.id_turma,\r\n" + 
				"tab_matricula.cadastro,\r\n" + 
				"tab_matricula.ativo,\r\n" + 
				"tab_cliente.nome\r\n" + 
				"FROM db_escola.tab_matricula\r\n" + 
				"INNER JOIN db_escola.tab_cliente ON\r\n" + 
				"tab_matricula.id_cliente = tab_cliente.id_cliente\r\n" + 
				";");
		
		if(rs!=null) {
			try {
				while(rs.next() == true) {
					Matricula m1 = new Matricula();
					
					m1.id_cliente = rs.getInt("id_cliente");
					m1.id_turma = rs.getInt("id_turma");
					m1.ativo = rs.getBoolean("ativo");
					m1.cadastro = rs.getString("cadastro");
					m1.nomeCliente = rs.getString("nome");
					
					list.add(m1);
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
		builder.append("Matricula [id_turma=");
		builder.append(id_turma);
		builder.append(", id_cliente=");
		builder.append(id_cliente);
		builder.append(", cadastro=");
		builder.append(cadastro);
		builder.append(", ativo=");
		builder.append(ativo);
		builder.append(", nomeCliente=");
		builder.append(nomeCliente);
		builder.append("]");
		return builder.toString();
	}
	
}
