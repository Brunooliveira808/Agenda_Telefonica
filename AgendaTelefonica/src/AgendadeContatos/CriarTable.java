package AgendadeContatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import AgendaFactory.AgendaConexao;

public class CriarTable {
	public CriarTable() throws SQLException, IOException {
		Connection conexao = AgendaConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS Contatos ("
				+ "id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,"
				+ "nome VARCHAR(255) NOT NULL,"
				+ "telefone VARCHAR(14) NOT NULL UNIQUE,"
				+ "email VARCHAR(255) NOT NULL UNIQUE)";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		conexao.close();
	}
}
