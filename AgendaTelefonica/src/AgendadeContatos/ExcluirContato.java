package AgendadeContatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import AgendaFactory.AgendaConexao;

public class ExcluirContato {
	private Scanner entrada;

	public ExcluirContato() throws SQLException, IOException {
		
		Connection conexao = AgendaConexao.getConexao();
		
		entrada = new Scanner(System.in);
		
		String sql = "DELETE FROM contatos WHERE nome = (?)";
		
		System.out.println("Digite o nome contato que deseja excluir: ");
		String nome = entrada.nextLine();
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.execute();

		System.out.println("Contato excluído com sucesso!");

		conexao.close();
	}
}
