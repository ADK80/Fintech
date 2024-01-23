package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.bean.Conta;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;


public class OracleContaDAO implements ContaDAO {

	private Connection conexao;
	
	@Override
	public void cadastrar(Conta conta) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO TB_PRODUTO (CD_PRODUTO, VL_PRODUTO, DT_FABRICACAO, CD_CATEGORIA) VALUES (SQ_TB_PRODUTO.NEXTVAL, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, conta.getValor());
			java.sql.Date data = new java.sql.Date(conta.getDataDeposito().getTimeInMillis());
			stmt.setDate(2, data);
		    stmt.setInt(3, conta.getCategoria().getCodigo());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(Conta conta) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE TB_PRODUTO SET VL_PRODUTO = ?, DT_FABRICACAO = ?, CD_CATEGORIA = ? WHERE CD_PRODUTO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, conta.getValor());
			java.sql.Date data = new java.sql.Date(conta.getDataDeposito().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setInt(3, conta.getCategoria().getCodigo());
			stmt.setInt(4, conta.getCodigo());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remover(int codigo) throws DBException {
			PreparedStatement stmt = null;

			try {
				conexao = ConnectionManager.getInstance().getConnection();
				String sql = "DELETE FROM TB_PRODUTO WHERE CD_PRODUTO = ?";
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, codigo);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("Erro ao remover.");
			} finally {
				try {
					stmt.close();
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

	@Override
	public Conta buscar(int id) {
		Conta conta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM TB_PRODUTO INNER JOIN TB_CATEGORIA ON TB_PRODUTO.CD_CATEGORIA = TB_CATEGORIA.CD_CATEGORIA WHERE TB_PRODUTO.CD_PRODUTO = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_PRODUTO");
				double valor = rs.getDouble("VL_PRODUTO");
				java.sql.Date data = rs.getDate("DT_FABRICACAO");
				Calendar dataDeposito = Calendar.getInstance();
				dataDeposito.setTimeInMillis(data.getTime());
				int codigoCategoria = rs.getInt("CD_CATEGORIA");
				String nomeCategoria = rs.getString("NM_CATEGORIA");
				
				conta = new Conta(codigo, valor, dataDeposito);
				Categoria categoria = new Categoria(codigoCategoria,nomeCategoria);
				conta.setCategoria(categoria);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conta;
	}

	@Override
	public List<Conta> listar() {
		List<Conta> lista = new ArrayList<Conta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM TB_PRODUTO INNER JOIN TB_CATEGORIA ON TB_PRODUTO.CD_CATEGORIA = TB_CATEGORIA.CD_CATEGORIA");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("CD_PRODUTO");
				double valor = rs.getDouble("VL_PRODUTO");
				java.sql.Date data = rs.getDate("DT_FABRICACAO");
				Calendar dataDeposito = Calendar.getInstance();
				dataDeposito.setTimeInMillis(data.getTime());
				int codigoCategoria = rs.getInt("CD_CATEGORIA");
				String nomeCategoria = rs.getString("NM_CATEGORIA");
				
				Conta conta = new Conta(codigo, valor, dataDeposito);
				Categoria categoria = new Categoria(codigoCategoria,nomeCategoria);
				conta.setCategoria(categoria);
				lista.add(conta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

}