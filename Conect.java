import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conect {

	private String login;
	private String senha;
	private String host;
	private String dbName;
	private String url;

	public Connection conexao = null;

	public Conect() {
		super();
		this.login = "postgres";
		this.senha = "aluno";
		this.host = "localhost:5432";
		this.dbName = "jogador";
		this.url = "jdbc:postgresql://" + getHost() + "/" + getDbName();

		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(getUrl(), getLogin(), getSenha());
			System.out.println("Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public int executaSQL(String sql) {
		try {
			Statement stm = conexao.createStatement();
			int res = stm.executeUpdate(sql);
			conexao.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
