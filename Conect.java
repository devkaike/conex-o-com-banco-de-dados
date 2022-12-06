package conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {
	private String login = "postgres";
	private String senha = "aluno";
	private String host = "5432";
	private String dbNome = "jogador";
	private String url = "jdbc:postgres://localhost:"+host+"/"+dbNome;
	
	public Connection conexao = null;
	
	public Conect() {}
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			return null;
		}
		try {
			this.conexao = (Connection) DriverManager.getConnection(url,login,senha);
		}catch(SQLException ex){
			return null;
		}
		return this.conexao;
	}
}
