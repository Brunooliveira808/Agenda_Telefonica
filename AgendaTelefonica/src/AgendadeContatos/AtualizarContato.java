package AgendadeContatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import AgendaFactory.AgendaConexao;

public class AtualizarContato {

	private Scanner entrada;

	public AtualizarContato() throws SQLException, IOException {

		Connection conexao = AgendaConexao.getConexao();
		entrada = new Scanner (System.in);
		
		System.out.println("Qual o nome do contato que deseja atualizar? ");
		String nomeAtual = entrada.next();
		
		String sql = "UPDATE contatos SET nome = ?, telefone = ?, email = ? WHERE nome = ?";
		
		System.out.println("Informe o NOVO nome: ");
		String nome = entrada.next();
		System.out.println("Informe o NOVO telefone: ");
		String telefone = entrada.next();
		System.out.println("Informe o NOVO email: ");
		String email = entrada.next();
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setString(2, telefone);
		stmt.setString(3, email);
		stmt.setString(4, nomeAtual);
		stmt.execute();

		System.out.println("Contato atualizado com sucesso!");
		
		conexao.close();
	}
}
