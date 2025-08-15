package AgendadeContatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AgendaFactory.AgendaConexao;

public class ListarContatos {

	public ListarContatos() throws SQLException, IOException {
		Connection conexao = AgendaConexao.getConexao();
		
		String sql = "SELECT * FROM contatos";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
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
		
		stmt.close();
		conexao.close();
	}	
}
