package AgendaFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AgendaConexao {

	public static Connection getConexao() throws SQLException, IOException {
		Properties prop = getProperties();
		final String url = prop.getProperty("banco.url");
		final String usuario = prop.getProperty("banco.usuario");;
		final String senha = prop.getProperty("banco.senha");;
		
		return DriverManager.getConnection(url, usuario, senha);
	}
	
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String caminho = "/conexaoModelo.properties";
		prop.load(AgendaConexao.class.getResourceAsStream(caminho));
		return prop;
	}
	
}
