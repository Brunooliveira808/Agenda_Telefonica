package AgendadeContatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import AgendaFactory.AgendaConexao;

public class ProcurarContato {
	private Scanner entrada;

	public ProcurarContato() throws SQLException, IOException {
		
		Connection conexao = AgendaConexao.getConexao();
		entrada = new Scanner (System.in);
		
		String sql = "SELECT * FROM contatos WHERE nome like ?";
		
		System.out.println("Pesquisa: ");
		String procura = entrada.nextLine();
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, '%' + procura + '%');
		ResultSet resultado = stmt.executeQuery();
		
		List<Contato> contatos = new ArrayList<>();
		while(resultado.next()) {
			int id = resultado.getInt("id");
			String nome = resultado.getString("nome");
			String telefone = resultado.getString("telefone");
			String email = resultado.getString("email");
			contatos.add(new Contato(id, nome, telefone, email));
		}
		
		for(Contato c: contatos) {
			System.out.println(c.getId() + " - " + c.getNome() + " | " + c.getTelefone() + " | " + c.getEmail());
		}

		conexao.close();
	}
}
