package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.exception.DBException;

public interface UsuarioDAO {

	boolean validarUsuario(Usuario usuario);
	void cadastrarUsu(Usuario usuario) throws DBException;
	
}
