package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Cliente;

public class ClienteDAO {

	public void save(Cliente contato) {

		String sql = "INSERT INTO cliente(nome, idade, cpf, email, localAtual, destino, datacadastro) VALUES(?,?, ?, ?, ?, ?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria uma conexeão com o banco de daos
			conn = ConnectionFactory.createConnectionToMySQL();

			// criamos uma prepared statement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// Adicionar o valor esperado pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setString(3, contato.getCpf());
			pstm.setString(4, contato.getEmail());
			pstm.setString(5, contato.getLocalAtual());
			pstm.setString(6, contato.getDestino());
			pstm.setDate(7, new Date(contato.getDataCadastro().getTime()));

			// Executar a query
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// fechar as conxões
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}

	public void update(Cliente c1) {

		String sql = "UPDATE cliente SET nome = ?, idade = ?, email = ?, localAtual = ?, destino = ?, dataCadastro = ?"
				+ "WHERE cpf = ?";

		Connection conn = null;

		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, c1.getNome());
			pstm.setInt(2, c1.getIdade());
			pstm.setString(3, c1.getEmail());
			pstm.setString(4, c1.getLocalAtual());
			pstm.setString(5, c1.getDestino());
			pstm.setDate(6, new Date(c1.getDataCadastro().getTime()));

			pstm.setString(7, c1.getCpf());

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if (rset != null) {
					rset.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public String deleteByCpf(String cpf) {
		String sql = "DELETE FROM cliente WHERE cpf = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, cpf);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Cliente getCadastro(String cpf) {
		String sql = "SELECT * FROM cliente WHERE cpf = ?";
		Connection conn = null;

		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, cpf);

			rset = pstm.executeQuery();

			if (rset.next()) {
				Cliente client = new Cliente();
				client.setNome(rset.getString("nome"));
				client.setIdade(rset.getInt("idade"));
				client.setCpf(rset.getString("cpf"));
				client.setEmail(rset.getString("email"));
				client.setLocalAtual(rset.getString("localAtual"));
				client.setDestino(rset.getString("destino"));
				return client;
			} else {
				System.out.println("Não encontrado no sistema");
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if (rset != null) {
					rset.close();
				}

				if (conn != null) {
					conn.close();
				}

				if (rset != null) {
					rset.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;

	}

}
