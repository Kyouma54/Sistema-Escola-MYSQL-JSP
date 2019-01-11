package com.eib.projetop1.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.eib.projetop1.persistencia.DataBaseSuporte;
import com.eib.projetop1.persistencia.IPersistencia;

public class Cliente implements IPersistencia<Cliente> {

	private int id_cliente = 0;
	private int idade = 0;
	private String nome = null;
	private String email = null;
	private String rg = null;
	private String cpf = null;
	private String cadastro = null;
	boolean ativo = false;
	
	
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
				"insert into tab_cliente (nome, idade, email, rg, cpf) values (?,?,?,?,?);", 
				this.nome, this.idade, this.email, this.rg, this.cpf
				);
		return r;
	}

	@Override
	public int excluir() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate(
				"delete from tab_cliente where id_cliente = ?;",
				this.id_cliente
				);
		return r;
	}

	@Override
	public int alterar() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate(
				"update tab_cliente set nome = ?, cpf = ?, rg = ?, "
				+ "email = ?, idade = ?, ativo=? where id_cliente = ?;", 
				this.nome, this.cpf, this.rg, this.email, this.idade, this.ativo, this.id_cliente
				);
		return r;
	}

	@Override
	public Cliente buscar() {
		ResultSet rs = DataBaseSuporte.executeQuery(
				"select * from tab_cliente where id_cliente = ?", 
				this.id_cliente);
		
		if(rs!=null) {
			try {
				if(rs.next() == true) {
					this.nome = rs.getString("nome");
					this.cpf = rs.getString("cpf");
					this.rg = rs.getString("rg");
					this.idade = rs.getInt("idade");
					this.email = rs.getString("email");
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
	public Collection<Cliente> buscarTodos() {
		
		Collection<Cliente> list = new ArrayList<Cliente>();
		ResultSet rs = DataBaseSuporte.executeQuery("select * from tab_cliente");
		
		if(rs!=null) {
			try {
				while(rs.next()==true) {
					Cliente cliente = new Cliente();
					cliente.nome = rs.getString("nome");
					cliente.email = rs.getString("email");
					cliente.cpf = rs.getString("cpf");
					cliente.rg = rs.getString("rg");
					cliente.idade = rs.getInt("idade");
					cliente.id_cliente = rs.getInt("id_cliente");
					cliente.cadastro = rs.getString("cadastro");
					cliente.ativo = rs.getBoolean("ativo");
					
					list.add(cliente);
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
		builder.append("Cliente [id_cliente=");
		builder.append(id_cliente);
		builder.append(", idade=");
		builder.append(idade);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", email=");
		builder.append(email);
		builder.append(", rg=");
		builder.append(rg);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", cadastro=");
		builder.append(cadastro);
		builder.append(", ativo=");
		builder.append(ativo);
		builder.append("]");
		return builder.toString();
	}
}


