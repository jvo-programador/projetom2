package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConexao() {
		
		Connection conexao = null;
		
		try {
			//carregar o driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//caminho do banco de dados
			String url = "jdcb:mysql://localhost/projetom2";
			//retorno o objeto de conexao
			conexao = DriverManager.getConnection(url,"root","");
			
		
		}catch(SQLException ex) {
			//Registro o erro no log do tomcat
			System.out.print("erro na conexao com o banco de dados ");
			throw new RuntimeException("erro ao abrir conexao", ex);
		
		}catch(Exception ex) {
			//Registro o erro no log do tomcat
			System.out.print("erro ao abrir a conexao ");
			throw new RuntimeException("erro ao registrar driver do jdbc", ex);
		}
		
		return conexao;
	}
}
