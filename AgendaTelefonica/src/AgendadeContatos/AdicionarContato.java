package AgendadeContatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import AgendaFactory.AgendaConexao;

public class AdicionarContato {
 
	private Scanner entrada;

	public AdicionarContato() throws SQLException, IOException {
		
		entrada = new Scanner(System.in);
		
		Connection conexao = AgendaConexao.getConexao();
		
		System.out.println("Informe o nome: ");
		String nome = entrada.nextLine();
		System.out.println("Informe o telefone: ");
		String telefone = entrada.nextLine();
		System.out.println("Informe o email: ");
		String email = entrada.nextLine();
		
		String sql = "INSERT INTO contatos (nome, telefone, email) VALUES (?, ?, ?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setString(2, telefone);
		stmt.setString(3, email);
		
		stmt.execute();
			
		System.out.println("Pessoa incluida com sucesso!");
		
		conexao.close();
	}
}
