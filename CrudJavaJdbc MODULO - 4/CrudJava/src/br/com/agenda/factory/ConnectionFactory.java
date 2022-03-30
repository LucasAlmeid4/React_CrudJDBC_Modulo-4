package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	// nome do usario do mysql
	private static final String USERNAME = "root";
	// senha do banco
	private static final String PASSWORD = "123456";
	// caminho do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/clientes?autoReconnect=true&useSSL=false";

	/*
	 * conexão com o banco de dados
	 */
	public static Connection createConnectionToMySQL() throws Exception {
		// faz com que a classe seja carregada pela jvm
		Class.forName("com.mysql.jdbc.Driver");
		// cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

	public static void main(String[] args) throws Exception {
		// recuperar a conexão com o bd se tiver
		Connection con = createConnectionToMySQL();

		if (con != null) {
			System.out.println("conexão obetida com sucesso");
			con.close();
		}
	}

}
