package com.eib.projetop1.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.eib.projetop1.persistencia.DataBaseSuporte;
import com.eib.projetop1.persistencia.IPersistencia;

public class Usuario  implements IPersistencia<Usuario>{
	
	private int id_usuario = 0;
	private int id_perfil = 0;
	private String login = null;
	private String senha = null;
	private String cadastro = null;
	private boolean ativo = false;
	private String tituloPerfil = null;
	
	public String getTituloPerfil() {
		return tituloPerfil;
	}

	public void setTituloPerfil(String tituloPerfil) {
		this.tituloPerfil = tituloPerfil;
	}

	public Usuario() {}
	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCadastro() {
		return cadastro;
	}

	public void setCadastro(String cadastro) {
		this.cadastro = cadastro;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int criar() {
		int r = 0;
		
		r = DataBaseSuporte.executeUpdate(
				"insert into tab_usuario (login,senha,id_perfil) values(?,?,?);",
				this.login,
				this.senha,
				this.id_perfil
				);
		
		return r;
	}

	@Override
	public int excluir() {
		int r = 0;
		
		r = DataBaseSuporte.executeUpdate(
				"delete from tab_usuario where id_usuario = ?;", 
				this.id_usuario
		);
		
		return r;
	}

	@Override
	public int alterar() {
		int r = 0;
		r = DataBaseSuporte.executeUpdate(
				"update tab_usuario set login = ?, senha = ?, ativo= ? where id_usuario = ?;", 
				this.login,
				this.senha,
				this.ativo,
				this.id_usuario
				);
		
		return r;
	}

	@Override
	public Usuario buscar() {
		
		ResultSet r = DataBaseSuporte.executeQuery(
			"select * from tab_usuario where id_perfil = ?",
			this.id_perfil
			);
		
		if(r != null) {
			try {
				if(r.next() == true) {
					this.login = r.getString("login");
					this.senha = r.getString("senha");
					this.cadastro = r.getString("cadastro");
					this.ativo = r.getBoolean("ativo");
					this.id_usuario = r.getInt("id_usuario");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return this;
	}

	@Override
	public Collection<Usuario> buscarTodos() {
		
		Collection<Usuario> list = new ArrayList<Usuario>();
		
		ResultSet r = DataBaseSuporte.executeQuery(
				"SELECT \r\n" + 
				"tab_usuario.id_usuario,\r\n" + 
				"tab_usuario.login,\r\n" + 
				"tab_usuario.senha,\r\n" + 
				"tab_usuario.cadastro,\r\n" + 
				"tab_usuario.ativo,\r\n" + 
				"tab_perfil.titulo\r\n" + 
				"FROM db_escola.tab_usuario\r\n" + 
				"INNER JOIN tab_perfil ON\r\n" + 
				"tab_usuario.id_perfil = tab_perfil.id_perfil\r\n" + 
				";"
				);
			
			if(r != null) {
				try {
					while(r.next() == true) {
						Usuario o = new Usuario();
						o.id_usuario = r.getInt("id_usuario");
						o.tituloPerfil = r.getString("titulo");
						o.login = r.getString("login");
						o.senha = r.getString("senha");
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
		builder.append("Usuario [id_usuario=");
		builder.append(id_usuario);
		builder.append(", id_perfil=");
		builder.append(id_perfil);
		builder.append(", login=");
		builder.append(login);
		builder.append(", senha=");
		builder.append(senha);
		builder.append(", cadastro=");
		builder.append(cadastro);
		builder.append(", ativo=");
		builder.append(ativo);
		builder.append(", tituloPerfil=");
		builder.append(tituloPerfil);
		builder.append("]");
		return builder.toString();
	}
	
}
