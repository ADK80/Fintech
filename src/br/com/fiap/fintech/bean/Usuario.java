package br.com.fiap.fintech.bean;

import br.com.fiap.fintech.util.CriptografiaUtils;

public class Usuario {
	
	private String login;
	
	private String senha;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String login, String senha) {
		super();
		this.login = login;
		setSenha(senha);
	}

	public String getUsuario() {
		return login;
	}

	public void setUsuario(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
